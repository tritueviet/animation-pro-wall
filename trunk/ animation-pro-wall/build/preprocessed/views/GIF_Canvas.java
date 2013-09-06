package views;

/*************************************************************************

IMPORTANT: This code requires the MIDP 2.0 APIs to function!

File: GIF_Canvas.java

Purpose: Displays the choosen GIF file and implements animation for it

Created by: Tom Thompson

 *************************************************************************/
import Control.Controller;
import Control.MakeGif;
import java.io.*;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import models.Text;

public class GIF_Canvas extends Canvas implements CommandListener, Runnable {

    private Thread dThread;   // Use a thread to0 animate the display
    public boolean action;
    public static Image gifImage;
    private int screenWidth;
    private int screenHeight;
    private String mediaTypes[];
    private final String GIF_MIME_TYPE = "image/gif";
    static boolean gifSupported;   // Flag to use built-in GIF decoder
    public GifDecoder d;
    private final MakeGif midlet;
    private final Displayable caller;
    private Command backCommand = new Command("Back", Command.OK, 0);
    private int quay = 1;
    private boolean kq = true;

    GIF_Canvas(MakeGif midlet, Displayable caller, int quay, boolean kq) {
        // manually call superclass constructor (unlike C++)
        super();
        setTitle(Text.results);
        this.midlet = midlet;
        this.caller = caller;
        this.quay = quay;
        this.kq = kq;
        screenWidth = getWidth();           // Get screen dimensions
        screenHeight = getHeight();
        gifImage = null;

// Get the media types to check for support of GIF file display
        mediaTypes = Manager.getSupportedContentTypes(null);
        int count = mediaTypes.length;

// Check list for GIF MIME type; set support flag if present
        gifSupported = false;
        for (int i = 0; i < count; i++) {
            if (mediaTypes[i] == GIF_MIME_TYPE) {
                gifSupported = true;
            }
        } // end for

        addCommand(backCommand);
        setCommandListener(this);

        action = true;
        dThread = new Thread(this);   // Set up thread that will animate GIF

    } // end GIF_Canvas constructor

    public void commandAction(Command command, Displayable d) {

        if (command == backCommand) {           // Set display to previous screen
            action = false;                     // Stop loop
            d = null;                           // Release images and decoder object
            gifImage = null;

            if (quay == 1) {
                Controller.getInstance().showCamera();
            } else {
                midlet.build2();
            }
        } // end if
    } // end commandAction

// Implement the paint method
    public void paint(Graphics g) {
// Clear the screen
        if (Controller.height > 350) {
            g.setColor(0x000000);                      // Pick white...
        } else {
            g.setColor(0xffffff);
        }
        g.fillRect(0, 0, screenWidth, screenHeight);    // ... and flood the buffer
        if (gifImage != null) {
            g.drawImage(gifImage, screenWidth / 2, screenHeight / 2, Graphics.VCENTER | Graphics.HCENTER);
        } // end if
        ;
        g.setColor(0x00cc00);
        if (kq == true) {
            g.drawString(Text.successful, 5, 5, Graphics.TOP | Graphics.LEFT);
        } else {
            g.drawString(Text.failed, 5, 5, Graphics.TOP | Graphics.LEFT);
        }
    } // end paint

// Pass the resource name to be read and displayed for this choice
    public void showGif(String location) {

// Does J2ME implementation support native GIF format decode?
        if (gifSupported) {
            try {
                gifImage = Image.createImage(location);   // Yes, read stream into an Image
//                gifImage=img;
                System.out.println(" da load");
            } catch (Exception ioe) {
                System.out.println("Exception while loading GIF image:\n "
                        + ioe.toString());
            };
            action = false;                         // Disable animation loop
//            System.out.println("Using native GIF support");
        } else {
            System.out.println("k ho tro");
            d = new GifDecoder();
            if (d != null) {
                FileConnection file = null;
                try {
                    file = (FileConnection) Connector.open(location);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

//                int err = d.read(location);
                int err = 0;
                try {
                    err = d.read(file.openDataInputStream());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("doc lan 1");
                if (err == 0) {
                    System.out.println("doc lan 2");
                    gifImage = d.getImage();
                    if (gifImage != null) {
                        dThread.start();
                    }
                } // end if
            } // end if
        } // end else
    } // end showGIF

// The run method for the class. Retrieves the GIF images and presents them for the
//   delay interval specified.
    public void run() {
        int t;
        if (gifImage != null) {
            while (action) {
                int n = d.getFrameCount();
                for (int i = 0; i < n; i++) {
                    gifImage = d.getFrame(i);  // frame i
                    t = d.getDelay(i);  // delay duration for frame i in milliseconds
                    repaint();
                    serviceRepaints();
                    try {
                        Thread.sleep(t);
                    } catch (Exception ex) {
                    }
                } // end for
            } // end while
        } // end if
    } // end run
} // end GIF_Canvas class

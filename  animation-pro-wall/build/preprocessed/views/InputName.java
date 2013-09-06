/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.MakeGif;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.*;
import models.Text;

/**
 *
 * @author User
 */
public class InputName extends Form implements CommandListener {

    private Command ok2;
    private boolean bien = true;
    private TextField tf0;
    private Form ten = new Form(Text.addNameOfAnimal);
    private byte[] imageData = null;
    private String text = null;
    private MakeGif xuli;
    private Display ds;
    int luu = 1;

    public InputName(int luu, byte[] imageData, MakeGif xuli) {
        super(Text.pleaTypeYour);
        this.imageData = imageData;
        this.xuli = xuli;
        this.luu = luu;
        //ds= Display.getDisplay(xuli);
        ok2 = new Command(Text.save, Command.OK, 1);
        tf0 = new TextField(Text.addtext, "", 13, TextField.ANY);
        ds = Display.getDisplay(xuli);
    }

    public void start() {
        tf0.setString("wall");
        append(Text.saveTo + System.getProperty("fileconn.dir.photos"));
        append(tf0);
        addCommand(ok2);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == ok2) {
            text = tf0.getString();
            boolean faile = false;
            if (text.trim().equals("")) {
                faile = true;
            }
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) > 'z' || (text.charAt(i) < 'A' && (text.charAt(i) < '0' || text.charAt(i) >= '9'))) {
                    faile = true;
                    break;
                }
            }
            if (faile == true) {
                Alert a = new Alert(Text.loi, Text.textLoi, null, AlertType.INFO);
                a.setTimeout(2500);
                Display.getDisplay(xuli).setCurrent(a);

            } else {
                try {
                    saveImage2File(imageData, text);
                } catch (Exception e) {

                    bien = false;
                    ds.setCurrent(ten);
                }

            }
        }
        Runtime.getRuntime().gc();

    }

    void saveImage2File(final byte[] photo, final String text) {
        new Thread() {
            public void run() {
                try {
                    // Receive a photo as byte array 
                    // Save Image to file
                    FileConnection fileConn = null;
                    DataOutputStream dos = null;
                    //fileConn = (FileConnection) Connector.open("file:///E:/"+text+".gif");
                    if (Text.numberTake == 1) {
                        fileConn = (FileConnection) Connector.open(System.getProperty("fileconn.dir.photos") + text + ".jpg");
                    } else {
                        fileConn = (FileConnection) Connector.open(System.getProperty("fileconn.dir.photos") + text + ".gif");
                    }

                    if (!fileConn.exists()) {
                        fileConn.create();
                    }

                    dos = new DataOutputStream(fileConn.openOutputStream());
                    dos.write(photo);

                    dos.flush();
                    dos.close();
                    fileConn.close();

                    Runtime.getRuntime().gc();
                    if (Controller.height > 350) {
                        if (Text.numberTake > 2 && luu == 1) {
                            Resuit xuat = new Resuit(luu, false, xuli, bien, photo, text);
                            xuat.start();
                            Display.getDisplay(xuli).setCurrent(xuat);
                            xuat = null;

                        } else {
                            Displayable oldDisp = Display.getDisplay(xuli).getCurrent();  // Preserve current screen
                            GIF_Canvas gifDisplay = new GIF_Canvas(xuli, oldDisp, luu, bien);
                            if (Text.numberTake == 1) {
                                gifDisplay.showGif(System.getProperty("fileconn.dir.photos") + text + ".jpg");
                            } else {
                                gifDisplay.showGif(System.getProperty("fileconn.dir.photos") + text + ".gif");
                            }
                            Display.getDisplay(xuli).setCurrent(gifDisplay);
                        }
                    } else {
                        Displayable oldDisp = Display.getDisplay(xuli).getCurrent();  // Preserve current screen
                        GIF_Canvas gifDisplay = new GIF_Canvas(xuli, oldDisp, luu, bien);
                        if (Text.numberTake == 1) {
                            gifDisplay.showGif(System.getProperty("fileconn.dir.photos") + text + ".jpg");
                        } else {
                            gifDisplay.showGif(System.getProperty("fileconn.dir.photos") + text + ".gif");
                        }
                        Display.getDisplay(xuli).setCurrent(gifDisplay);
                    }
                    Runtime.getRuntime().gc();
                } catch (Exception e) {
                    System.out.println("Error!" + e.getMessage());
                }
            }
        }.start();
        Runtime.getRuntime().gc();
    }
}

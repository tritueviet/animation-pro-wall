package views;

import Control.BlendImage;
import java.io.IOException;
import models.Text;
import Control.Controller;
import Control.Resize;
import Control.EndGif;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;


import com.sun.lwuit.VideoComponent;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.CoordinateLayout;
import com.sun.lwuit.layouts.FlowLayout;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VideoControl;

/**
 *
 * @author WALL
 */
public class Camera extends Form implements ActionListener {

    public Player player;
    public VideoComponent videoComponent;
    public VideoControl videoControl;
    //private Form form;
    private Command chup;
    private byte[] raw;
    private Image capturedImage;
    //private Button btn;
    byte[] imageData;

    public Camera() {

        setTitle(Text.camera);
        //Controller.getInstance().thongbao();
        //form= new Form(Text.camera);
        setLayout(new CoordinateLayout(240, 240));
        try {
            chup = new Command(Text.chupp, com.sun.lwuit.Image.createImage("/images/camera.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setDefaultCommand(chup);
        addCommand(chup);
        //System.out.println("++"+Display.getInstance().);

        addCommandListener(this);
        createCamera();
    }

    public void createCamera() {
        try {
            videoComponent = VideoComponent.createVideoPeer("capture://image");
            player = (Player) videoComponent.getNativePeer();
            player.realize();
            videoControl = (VideoControl) player.getControl("VideoControl");
            //videoControl.setDisplayFullScreen(true);
            videoComponent.setFullScreen(true);


            addComponent(videoComponent);
//            System.out.println("  :"+ Text.with+"   :"+ Text.height);
//            videoComponent.setPreferredH(300);
//            videoComponent.setPreferredW(240);
            videoComponent.start();

        } catch (MediaException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        // System.out.println("cdcs");
        if (ae.getCommand() == chup) {
            System.out.println("chao.....");

            removeCommand(chup);

            new Thread(new Runnable() {

                public void run() {

                    System.out.println("chaovvvvvvvv");
                    EndGif tao = new EndGif();
                    BlendImage blend = new BlendImage();

                    ByteArrayOutputStream bos = null;
                    bos = new ByteArrayOutputStream();
                    tao.start(bos);
                    tao.setRepeat(0);
                    for (int i = 0; i < Text.numberTake; i++) {
                        try {
                            //raw = videoControl.getSnapshot("encoding=png&width =240&height=320");
                            raw = videoControl.getSnapshot(null);

                            capturedImage = Image.createImage(raw, 0, raw.length);
//                    
//                    Image chao = Image.createImage(capturedImage.getWidth(), capturedImage.getHeight());
//                    Graphics g= chao.getGraphics();
//                    g.drawImage(capturedImage, 0, 0, Graphics.LEFT|Graphics.TOP);
//                    Resize re= new Resize();
//                    
//                    Image hh=re.CreateScaledImage(Image.createImage("/vang.png"), capturedImage.getWidth(), capturedImage.getHeight());
//                    g.drawImage(hh, 0, 0, Graphics.LEFT|Graphics.TOP);

                            if (0 == Text.effect) {
                                tao.addFrame(capturedImage);
                            } else if (1 == Text.effect) {
                                tao.addFrame(Controller.makeScale1(capturedImage));
                            } else if (2 == Text.effect) {
                                tao.addFrame(Controller.makeScale2(capturedImage));
                            } else if (3 == Text.effect) {
                                tao.addFrame(Controller.makeScale3(capturedImage));
                            } else if (4 == Text.effect) {
                                tao.addFrame(Controller.makeScale4(capturedImage));
                            } else if (5 == Text.effect) {
                                tao.addFrame(Controller.makeScale5(capturedImage));
                            } else if (6 == Text.effect) {
                                tao.addFrame(Controller.makeScale6(capturedImage));
                            } else if (7 == Text.effect) {
                                if (Text.imageNumber == 0) {
                                    tao.addFrame(blend.blend(capturedImage, capturedImage, Text.value, Text.typeEfect));
                                } else {
                                    tao.addFrame(blend.blend(capturedImage, blend.scaleImage(Image.createImage("/images/effect" + Text.imageNumber + ".png"), capturedImage.getWidth(), capturedImage.getHeight()), Text.value, Text.typeEfect));
                                }
                            }


                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        tao.setDelay(400);
                        tao.setRepeat(0);
                        Runtime.getRuntime().gc();

                    }
                    tao.finish();
                    tao = null;
                    imageData = new byte[bos.toByteArray().length];
                    imageData = bos.toByteArray();
                    Runtime.getRuntime().gc();


                    try {
                        bos.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    //xuli.xuat(imageData);
                    try {
                        if (player != null) {
                            Controller.getInstance().gause();
                            player.stop();
                            videoComponent.stop();
                            player.close();
                            player = null;
                            Runtime.getRuntime().gc();
                        }
                    } catch (MediaException ex) {
                        ex.printStackTrace();
                    }
                    InputName nhap = new InputName(1, imageData, Controller.getInstance().main);
                    nhap.start();
                    javax.microedition.lcdui.Display.getDisplay(Controller.getInstance().main).setCurrent(nhap);
                    imageData=null;
                    System.out.println("k loi");
                    Runtime.getRuntime().gc();
                }
            }).start();


        }

    }

    public void tao() {
        try {
            player.start();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
        videoComponent.start();
        createCamera();
    }

    public void huy() {
        try {
            if (player != null) {
                player.stop();
                videoComponent.stop();
                player.close();
                player = null;
            }
        } catch (MediaException ex) {
            ex.printStackTrace();
        }


    }

    void saveImage2File(byte[] photo, String text) {
        // Receive a photo as byte array
        // Save Image to file
        FileConnection fileConn = null;
        DataOutputStream dos = null;

        try {
            fileConn = (FileConnection) Connector.open("file:///E:/" + text + ".gif");
            if (!fileConn.exists()) {
                fileConn.create();
            }
            dos = new DataOutputStream(fileConn.openOutputStream());
            dos.write(photo);

            dos.flush();
            dos.close();
            fileConn.close();

        } catch (IOException ioe) {
            System.out.println("Error!" + ioe);
        }
    }
}

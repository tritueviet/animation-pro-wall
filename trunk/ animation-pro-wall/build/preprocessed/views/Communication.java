package views;

import Control.EndGif;
import Control.MakeGif;
import Control.Resize;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.microedition.midlet.MIDlet;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import models.Text;

public class Communication extends GameCanvas implements Runnable, CommandListener {

    Random nn = new Random();
    private Graphics g;
    private Font font;
    private MakeGif xuli;
    private Image goc, goc2;
    private int dai, ngan;
    private byte xacdinh = 0, dem, dem2, dem3, dem4, dem5, dem6, dem7;
    private String text;
    private Command exit;
    private Command ok, add;
    boolean run;
    private Image im;
    private int h = getHeight() / 2, chay = 0;
    private int w = getWidth() / 2;
    private int[] W = new int[7], H = new int[7];
    private Display ds;
    private ChoiceGroup c3;
    private Form mf;
    private Image hu, sk;
    private Image oki;
    private byte sohu = 4;
    private byte sosk = 4;
    private byte[] effect = new byte[7];
    private boolean chuyen = false;
    private int[] mau = {0xff0000, 0xff9900, 0xffff00, 0x00cccc, 0x0000cc, 0x006600,
        0xff00ff, 0x9900ff, 0x660000, 0xffffff, 0x000000, 0x999999};
    private int[] styles = {Font.STYLE_PLAIN, Font.STYLE_BOLD, Font.STYLE_ITALIC};
    private int[] sizes = {Font.SIZE_SMALL, Font.SIZE_MEDIUM, Font.SIZE_LARGE};
    private Command ok4;
    private Image[] sk2 = null;
    private byte chon = 0;
    private Image goc3;
    private Image[] Im = null;

    public Communication(boolean suppressKeyEvents, MakeGif xuli, Image goc, int dai, int ngan,
            byte dem, byte dem2, byte dem3, String text, byte dem4, byte dem5, byte dem6, byte dem7) {
        super(suppressKeyEvents);
        setFullScreenMode(false);
        run = true;



        this.xuli = xuli;
        this.goc = goc;
        this.dai = dai;
        this.ngan = ngan;
        this.dem = dem;
        this.dem2 = dem2;
        this.dem3 = dem3;
        this.dem4 = dem4;
        this.dem5 = dem5;
        this.dem6 = dem6;
        this.dem7 = dem7;
        this.text = text;
        //======================================================================


        sk2 = new Image[15];
        try {
            for (byte i = 0; i < 15; i++) {
                sk2[i] = Image.createImage("/b/sukien" + (i + 1) + "/1.png");
            }
            c3 = new ChoiceGroup(Text.event, Choice.POPUP, Text.name_events, sk2);
            c3.setSelectedIndex(0, true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ok4 = new Command(Text.ok, Command.OK, 1);
        sk2 = null;


        //======================================================================
        try {
            this.g = this.getGraphics();
            this.font = Font.getFont(Font.STYLE_BOLD, Font.FACE_MONOSPACE, Font.SIZE_LARGE);
        } catch (Exception e) {
        };
        try {

            hu = Image.createImage("/a/hu" + (dem + 1) + "/1.png");
            Resize r = new Resize();
            hu = r.CreateScaledImage(hu, dai, ngan);
            goc2 = Image.createImage(dai, ngan);
            Graphics gra = goc2.getGraphics();
            gra.drawImage(goc, 0, 0, Graphics.TOP | Graphics.LEFT);
            gra.drawImage(hu, 0, 0, Graphics.TOP | Graphics.LEFT);

            im = Image.createImage("/b/sukien" + (dem2 + 1) + "/1.png");

        } catch (Exception e) {
        };
        if (dem3 == 0) {
            if (chuyen == false) {
                ok = new Command(Text.next, Command.OK, 1);
                addCommand(ok);
            }
            if (chuyen == true) {
                removeCommand(ok);
                ok = new Command(Text.build, Command.OK, 2);
                addCommand(ok);

            }
        }
        if (dem3 == 1) {
            ok = new Command(Text.build, Command.OK, 1);
            addCommand(ok);

        }
        if (chuyen == false) {
            add = new Command(Text.addMoreEff, Command.OK, 1);
            addCommand(add);
        }

        exit = new Command(Text.backChoose, Command.ITEM, 1);
        addCommand(exit);
        updateGameScreen(getGraphics());
        setCommandListener(this);
    }

    public void run() {

        while (run) {

            // update game elements, positions, collisions, etc..
            updateGameState();
            // render screen
            updateGameScreen(getGraphics());
            // redraws screen
            this.flushGraphics();

            // controls at which rate the updates are done
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Runtime.getRuntime().gc();
        }
    }

    // start Thread
    public void start() {
        System.out.println("chem chet");
        run = true;
        try {

            Thread t = new Thread(this);
            t.start();
            System.out.println("thread start!");
            //run = false;
            t = null;
        } catch (Exception e) {
            System.out.println("thread error " + e.getMessage());
        }


    }

    // stop Thread
    public void stop() {
        //run = false;
    }

    public void commandAction(Command c, Displayable d) {
        if (c == add) {
            if (chay == 5) {
                removeCommand(add);
            }
            effect[chay] = dem2;
            W[chay] = w;
            H[chay] = h;
            chay++;
            //w=getWidth()/2;h=getHeight()/2;

            String[] name_events = Text.name_events;

            sk2 = new Image[15];
            try {
                for (byte i = 0; i < 15; i++) {
                    sk2[i] = Image.createImage("/b/sukien" + (i + 1) + "/1.png");


                }
                c3 = new ChoiceGroup(Text.event, Choice.POPUP, name_events, sk2);
                c3.setSelectedIndex(0, true);

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            ok4 = new Command(Text.ok, Command.OK, 1);
            sk2 = null;
            name_events = null;
            Runtime.getRuntime().gc();


            mf = new Form(Text.select);
            mf.addCommand(ok4);
            mf.append(c3);
            mf.setCommandListener(this);
            ds = Display.getDisplay(xuli);
            ds.setCurrent(mf);

        }
        if (c == ok4) {
            boolean get[] = new boolean[22];
            c3.getSelectedFlags(get);
            for (byte i = 0; i < get.length; i++) {
                if (get[i] == true) {
                    chon = i;
                    break;
                }
            }
            System.out.println("chon: " + chon);

            try {
                goc3 = Image.createImage(dai, ngan);
                Graphics gra = goc3.getGraphics();
                gra.drawImage(goc2, 0, 0, Graphics.TOP | Graphics.LEFT);
                gra.drawImage(im, w, h, Graphics.TOP | Graphics.LEFT);
                goc2 = goc3;
                dem2 = chon;
                im = Image.createImage("/b/sukien" + (dem2 + 1) + "/1.png");

            } catch (Exception e) {
            };

            this.start();
            ds.setCurrent(this);
            System.out.println("ok nua");
        }
        //========================================================
        if (c == exit) {

            /*
             * styles= null;sizes=null;mau=null;
             * oki=null;im=null;goc=null;goc2=null; font= null;
             * mf=null;ok=null;exit=null; text =null; hu=null;
             * sk=null;g=null;ds=null; Runtime.getRuntime().gc();
             */
            xuli.build2();
        }

        if (c == ok) {

            if (dem3 == 1) {
                effect[chay] = dem2;
                W[chay] = w;
                H[chay] = h;
                chay++;
                run = false;

                build();
            }
            if (dem3 == 0) {
                if (chuyen == false) {
                    removeCommand(add);
                    removeCommand(ok);

                    ok = new Command(Text.build, Command.OK, 1);
                    addCommand(ok);
                    chuyen = true;
                    effect[chay] = dem2;
                    W[chay] = w;
                    H[chay] = h;
                    chay++;
                    //w=getWidth()/2;h=getHeight()/2;


                    try {
                        goc3 = Image.createImage(dai, ngan);
                        Graphics gra = goc3.getGraphics();
                        gra.drawImage(goc2, 0, 0, Graphics.TOP | Graphics.LEFT);
                        gra.drawImage(im, w, h, Graphics.TOP | Graphics.LEFT);
                        goc2 = goc3;
                        dem2 = chon;
                        im = Image.createImage("/b/sukien" + (dem2 + 1) + "/1.png");

                    } catch (Exception e) {
                    };

                    start();
                } else {
                    run = false;

                    build();
                }
            }
        }
    }

    protected void pointerPressed(int x, int y) {
        w = x;
        h = y;
    }

    private void updateGameState() {
        int keyStates = getKeyStates();
        if ((keyStates & LEFT_PRESSED) != 0) {
            w -= 4;
        } else if ((keyStates & RIGHT_PRESSED) != 0) {
            w += 4;
        } else if ((keyStates & UP_PRESSED) != 0) {
            h -= 4;
        } else if ((keyStates & DOWN_PRESSED) != 0) {
            h += 4;
        }


    }

    private void updateGameScreen(Graphics g) {
        g.setColor(0x000000);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(0xffffff);
        for (int j = 0; j < getHeight(); j++) {
            int x = (nn.nextInt() % (3 * getWidth())) / 2;
            if (x >= getWidth()) {
                x = -1;
            }
            g.drawLine(x, j, x, j);
        }
        g.drawImage(goc2, 0, 0, Graphics.TOP | Graphics.LEFT);
        //g.drawString("OK", getWidth()/2, getHeight()-10,Graphics.VCENTER|Graphics.HCENTER);
        if (chuyen == true) {
            font = Font.getFont(Font.FACE_SYSTEM, styles[dem5], sizes[dem4]);
            g.setFont(font);
            g.setColor(mau[dem7]);
            g.drawString(text, w, h, Graphics.TOP | Graphics.LEFT);
        }
        if (chuyen == false) {
            g.drawImage(im, w, h, Graphics.TOP | Graphics.LEFT);
        }


    }

    private void build() {
        try {


            ByteArrayOutputStream bos = null;
            bos = new ByteArrayOutputStream();

            EndGif encoder = new EndGif();
            encoder.start(bos);
            encoder.setRepeat(0);
            // encoder.setQuality(40);
            System.out.println("ok1");

            for (byte soanh = 1; soanh <= 4; soanh++) {
                try {

                    hu = Image.createImage("/a/hu" + (dem + 1) + "/" + soanh + ".png");
                    Im = new Image[chay + 1];
                    for (byte j = 0; j < chay; j++) {
                        System.out.println("j: " + j);
                        Im[j] = Image.createImage("/b/sukien" + (effect[j] + 1) + "/" + soanh + ".png");
                    }

                } catch (IOException ex) {
                    System.out.println("loi " + soanh);
                }

                Resize r = new Resize();
                hu = r.CreateScaledImage(hu, dai, ngan);

                try {
                    oki = Image.createImage(dai, ngan);
                    Graphics graphics = oki.getGraphics();

                    graphics.drawImage(goc, 0, 0, Graphics.TOP | Graphics.LEFT);
                    graphics.drawImage(hu, 0, 0, Graphics.TOP | Graphics.LEFT);
                    for (byte j = 0; j < chay; j++) {
                        graphics.drawImage(Im[j], W[j], H[j], Graphics.TOP | Graphics.LEFT);
                    }

                    if (dem3 == 0) {
                        if (dem6 == 0) {
                            if (soanh % 2 == 1) {

                                font = Font.getFont(Font.FACE_SYSTEM, styles[dem5], sizes[dem4]);
                                graphics.setFont(font);
                                graphics.setColor(mau[dem7]);

                                graphics.drawString(text, w, h, Graphics.TOP | Graphics.LEFT);
                            }
                        } else {

                            font = Font.getFont(Font.FACE_SYSTEM, styles[dem5], sizes[dem4]);
                            graphics.setFont(font);
                            graphics.setColor(mau[dem7]);

                            graphics.drawString(text, w, h, Graphics.TOP | Graphics.LEFT);
                        }
                    }

                } catch (Exception e) {
                    System.err.println(e);
                }
                System.out.println("dem7:" + dem7);
                hu = null;
                Im = null;
                Runtime.getRuntime().gc();
                encoder.addFrame(oki);

                oki = null;
                encoder.setDelay(400);
                encoder.setRepeat(0);
                Runtime.getRuntime().gc();
                System.out.println("ok" + soanh);
            }

            encoder.finish();
            encoder = null;
            Runtime.getRuntime().gc();
            byte[] imageData = new byte[bos.toByteArray().length];
            imageData = bos.toByteArray();
            bos.close();
            xuli.xuat(imageData);
            Runtime.getRuntime().gc();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}

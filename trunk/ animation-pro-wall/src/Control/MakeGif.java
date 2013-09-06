package Control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import views.Communication;
import java.io.*;
import java.util.*;
import javax.microedition.io.*;
import javax.microedition.io.file.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import models.Text;
import views.InputName;

/**
 * @author TRITUEVIET
 */
public class MakeGif extends MIDlet implements CommandListener {

    private Image anh = null;
    private byte[] imageData = null;
    //===========================================================  
    private static String[] attrList = {Text.read, Text.write, Text.hide};
    private static String[] typeList = {Text.regular, Text.director};
    private static String[] monthList = Text.monthList;
    private static String UP_DIRECTORY = ". ..";
    private static String MEGA_ROOT = "/";
    private static String SEP_STR = "/";
    private static char SEP = '/';
    private String currDirName;
    private Command view = new Command(Text.open, Command.ITEM, 1);
    private Command creat = new Command(Text.neww, Command.ITEM, 2);
    //add delete file functionality
    private Command delete = new Command(Text.deletee, Command.ITEM, 3);
    private Command creatOK = new Command(Text.ok, Command.OK, 1);
    private Command prop = new Command(Text.profi, Command.ITEM, 2);
    private Command back = new Command(Text.Back, Command.BACK, 2);
    private Command exit = new Command(Text.backChoose, Command.BACK, 3);
    private Command exitcuoi = new Command(Text.Back, Command.BACK, 0);
    private Command sang = new Command(Text.ok, Command.OK, 1);
    private Command chonProf = new Command(Text.ok, Command.OK, 1);
    private TextField nameInput; // Input field for new file name
    private ChoiceGroup typeInput; // Input field for file type (regular/dir)
    private Image dirIcon, fileIcon;
    private Image[] iconList;
//===========================================================    
    boolean bien = true;
//===========================================================
    private Command ok, cmdq;
    private Display ds;
    private Form nao = new Form(Text.inputSize);
    private TextField tf, tf2;
    int dai, ngan;
    //===========================================================   
    // private Image[] fd;
    private Form mf3 = new Form(Text.chooseType);
    private ChoiceGroup c1, c2, c3, c4, c5, c6;
//    private Image[] hu;
    private byte dem = 0, dem2 = 0, dem3 = 0;
    private Command quay, oki;
    private Form mf4 = new Form(Text.teext);
    private Image[] sk;
    //  private  Image okio;
//    private Image goc;
    private boolean one = true;
    private TextField tf0;
    private ChoiceGroup c0;
    private Form mf5 = new Form(Text.select), mf6 = new Form(Text.select);
    private ChoiceGroup c7, c8;
    private byte di = 0;
    private byte di2;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    EndGif encoder = new EndGif();
    private boolean hien = false;
    private Command vao;

    public MakeGif() {

//        com.sun.lwuit.Display.init(this);
        try {
            dirIcon = Image.createImage("/images/folder.png");
            fileIcon = Image.createImage("/images/file.png");
        } catch (IOException e) {
//            dirIcon = null;
//            fileIcon = null;
        }

        iconList = new Image[]{fileIcon, dirIcon};
        MEGA_ROOT = "/";
        currDirName = MEGA_ROOT;
        SEP_STR = "/";

    }

    public void KhoiChay() {
//        mf3.deleteAll();mf4.deleteAll();mf5.deleteAll();mf6.deleteAll();
//        c0.deleteAll();c2.deleteAll();c3.deleteAll();c4.deleteAll();c5.deleteAll();c6.deleteAll();c7.deleteAll();c8.deleteAll();
//        c1.deleteAll();      nao.deleteAll();

//        mf3 = null;
//        mf4 = null;
//        mf5 = null;
//        mf6 = null;
//        c0 = null;
//        c1 = null;
//        c2 = null;
//        c3 = null;
//        c4 = null;
//        c5 = null;
//        c6 = null;
//        c7 = null;
//        c8 = null;
//        nao = null;

        ds = javax.microedition.lcdui.Display.getDisplay(this);

        attrList[0] = Text.read;
        attrList[1] = Text.write;
        attrList[2] = Text.hide;
        typeList[0] = Text.regular;
        typeList[1] = Text.director;
        monthList = Text.monthList;


        one = true;
        dem = 0;
        dem2 = 0;
        dem3 = 0;
        bien = true;
        view = new Command(Text.open, Command.ITEM, 1);
        creat = new Command(Text.neww, Command.ITEM, 2);
        //add delete file functionality
        delete = new Command(Text.deletee, Command.ITEM, 3);
        creatOK = new Command(Text.ok, Command.OK, 1);
        prop = new Command(Text.profi, Command.ITEM, 2);
        back = new Command(Text.Back, Command.BACK, 2);
        exit = new Command(Text.backChoose, Command.BACK, 3);
        exitcuoi = new Command(Text.Back, Command.BACK, 0);
        sang = new Command(Text.ok, Command.OK, 1);
        chonProf = new Command(Text.ok, Command.OK, 1);
        nao = new Form(Text.inputSize);


        mf3 = new Form(Text.chooseType);
        mf4 = new Form(Text.teext);
        mf5 = new Form(Text.select);
        mf6 = new Form(Text.select);
        di = 0;
        hien = false;

        //============================================
        MEGA_ROOT = "/";
        currDirName = MEGA_ROOT;
        SEP_STR = "/";

        try {
            dirIcon = Image.createImage("/images/folder.png");
            fileIcon = Image.createImage("/images/file.png");
        } catch (Exception e) {
//            dirIcon = null;
//            fileIcon = null;
        }

        iconList = new Image[]{fileIcon, dirIcon};
        //===============================================================
        Ticker t = new Ticker(Text.ticker);
        nao.setTicker(t);
        tf = new TextField(Text.addNewImgW, "", 3, TextField.NUMERIC);
        tf2 = new TextField(Text.addNewImgH, "", 3, TextField.NUMERIC);
        // tf2.getString("320");
        //tf.g
        tf.setString("200");
        tf2.setString("200");
        ok = new Command(Text.ok, Command.OK, 1);
        cmdq = new Command(Text.backChoose, Command.EXIT, 0);
        nao.append(tf);
        nao.append(tf2);
        nao.addCommand(ok);
        nao.addCommand(cmdq);

        nao.setCommandListener(this);
        //====================================================================
        //ds = Display.getDisplay(this);
        //hu= new Image[4];

        sk = new Image[15];

        mf3.setTicker(t);

        c2 = new ChoiceGroup(Text.efect, Choice.POPUP);

        c1 = new ChoiceGroup(Text.addtext, Choice.POPUP);
//        String[] name_effects = Text.name_effects;
//        String[] name_events = Text.name_events;

        try {
            for (byte i = 0; i < 22; i++) {

                //hu[i]= Image.createImage("/a/hu"+(i+1)+"/1.png");
                c2.append(Text.name_effects[i], null);
                //Text.name_effects[i] = null;
                //hu[i]=null;

                // Runtime.getRuntime().gc();
            }

            for (byte i = 0; i < 15; i++) {
                sk[i] = Image.createImage("/b/sukien" + (i + 1) + "/1.png");
            }
            c3 = new ChoiceGroup(Text.event, Choice.POPUP, Text.name_events, sk);
            c3.setSelectedIndex(0, true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Choice 
//        hu=null;
        sk = null;
//        name_effects = null;
//        name_events = null;
        //Runtime.getRuntime().gc();
        c1.append(Text.yes, null);
        c1.append(Text.no, null);

        oki = new Command(Text.ok, Command.OK, 1);
        quay = new Command(Text.backChoose, Command.EXIT, 0);
        mf3.addCommand(quay);
        mf3.addCommand(oki);
        mf3.append(c2);
        mf3.append(c3);
        mf3.append(c1);
        mf3.setCommandListener(this);
        //============================================================================   
        vao = new Command(Text.ok, Command.OK, 1);


        //============================================================================
        // ds = Display.getDisplay(this);

        mf4.setTicker(t);
        tf0 = new TextField(Text.addtext, "", 12, TextField.ANY);
        mf4.append(tf0);
        int[] mau = {0xff0000, 0xff9900, 0xffff00, 0x00cccc, 0x0000cc, 0x006600,
            0xff00ff, 0x9900ff, 0x660000, 0xffffff, 0x000000, 0x999999};

        c4 = new ChoiceGroup(Text.size, Choice.POPUP);
        c5 = new ChoiceGroup(Text.style, Choice.POPUP);
        c6 = new ChoiceGroup(Text.efect, Choice.POPUP);
        c4.append(Text.small, null);
        c4.append(Text.medium, null);
        c4.append(Text.large, null);
        c5.append(Text.plain, null);
        c5.append(Text.bold, null);
        c5.append(Text.italic, null);
        c6.append(Text.sparkling, null);
        c6.append(Text.normal, null);
        Image[] fd = new Image[12];
        String[] chuoi = new String[12];
        for (byte i = 0; i < 12; i++) {
            fd[i] = Image.createImage(30, 30);
            Graphics graphics = fd[i].getGraphics();
            graphics.setColor(mau[i]);
            graphics.fillRect(0, 0, 30, 30);
            //c0.append("", fd);
            chuoi[i] = "";
            //fd = null;
            // Runtime.getRuntime().gc();
        }
        c0 = new ChoiceGroup(Text.color, Choice.POPUP, chuoi, fd);
        mau = null;
        chuoi = null;
        fd = null;
        //Runtime.getRuntime().gc();
        mf4.addCommand(exitcuoi);
        mf4.addCommand(sang);
        mf4.append(c0);
        mf4.append(c4);
        mf4.append(c5);
        mf4.append(c6);
        mf4.setCommandListener(this);
        //ds = Display.getDisplay(this);
        //================================================================




        mf5.setTicker(t);
        c7 = new ChoiceGroup(Text.chooseType, Choice.POPUP);
        c7.append(Text.onePicture, null);
        c7.append(Text.morePicture, null);
        mf5.addCommand(ok);
        mf5.append(c7);
        mf5.setCommandListener(this);
        //ds = Display.getDisplay(this);
        //==========================================================
        mf6.setTicker(t);
        c8 = new ChoiceGroup(Text.choose, Choice.POPUP);
        c8.append(Text.addNextPicture, null);
        c8.append(Text.finish, null);
        mf6.addCommand(ok);
        mf6.append(c8);
        mf6.setCommandListener(this);
        //ds = Display.getDisplay(this);

    }

    public void startApp() {
        Controller.getInstance().loadConfig();
        if (Text.numberTake==0)  Text.numberTake=3;
        try {
            dirIcon = Image.createImage("/images/folder.png");
            fileIcon = Image.createImage("/images/file.png");
        } catch (Exception e) {
//            dirIcon = null;
//            fileIcon = null;
        }

        iconList = new Image[]{fileIcon, dirIcon};
        MEGA_ROOT = "/";
        currDirName = MEGA_ROOT;
        SEP_STR = "/";
//        typeList = new String[]{"Regular File", "Directory"};
//        attrList = new String[]{"Read", "Write", "Hidden"};
//        monthList = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


//        UP_DIRECTORY = ". ..";


        com.sun.lwuit.Display.init(this);
        Controller.getInstance().chay(this);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        Controller.getInstance().updateConfig();
        notifyDestroyed();
    }

    public void build2() {

        // Controller.getInstance().categoryBar.setVisibility(true);
//        ds = Display.getDisplay(this);
        ds.setCurrent(mf5);

    }

    public void build() {

        //  boolean isAPIAvailable = false;
        if (System.getProperty(
                "microedition.io.file.FileConnection.version") != null) {
            //    isAPIAvailable = true;
            try {
                System.out.println("chay");
                showCurrDir();

            } catch (SecurityException e) {
            } catch (Exception e) {
            }
        } else {
            Alert alert =
                    new Alert(Text.eurro, Text.youNeedTo, null,
                    AlertType.INFO);
            alert.setTimeout(Alert.FOREVER);

            Display.getDisplay(this).setCurrent(alert, mf5);
        }

    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdq) {
            startApp();
        } else if (c == ok) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            if (d == mf5) {
                boolean get[] = new boolean[c7.size()];
                c7.getSelectedFlags(get);
                for (byte i = 0; i < get.length; i++) {
                    if (get[i] == true) {
                        di = i;
                        break;
                    }
                }
                if (di == 0) {
                    hien = true;

                    build();
                } else {
                    ds.setCurrent(nao);
                }
            } else if (d == mf6) {
                boolean get[] = new boolean[2];
                c8.getSelectedFlags(get);
                for (byte i = 0; i < 2; i++) {
                    if (get[i] == true) {
                        di2 = i;
                        break;
                    }
                }
                if (di2 == 0) {
                    build();
                } else {

                    encoder.finish();
                    byte[] imageData = new byte[bos.toByteArray().length];
                    imageData = bos.toByteArray();
                    try {
                        bos.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    xuat(imageData);
                }
            } else if (d == nao) {
                if (di == 0) {
//                    dirIcon = null;
//                    fileIcon = null;
//                    iconList = null;
//                    currDirName = null;
//                    SEP_STR = null;
//                    attrList = null;
//                    monthList = null;
//                    typeList = null;
//                    MEGA_ROOT = null;
//                    UP_DIRECTORY = null;
                }
                //Runtime.getRuntime().gc();
                try {
                    dai = Integer.parseInt(tf.getString());
                    ngan = Integer.parseInt(tf2.getString());
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
                //if (dai > 500 || ngan > 500) {
                //   Alert a = new Alert("error", "width< 500 and height < 500", null, AlertType.ERROR);
                //  a.setTimeout(5000);

                // ds = Display.getDisplay(this);
                //  ds.setCurrent(a, nao);


                //} else {

                if (di == 0) {
                    Resize re = new Resize();
                    anh = re.CreateScaledImage(anh, dai, ngan);


                    ds.setCurrent(mf3);
                } else {
                    build();

                }
            }
        } else //}
        //============================================================
        if (c == oki) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            boolean get[] = new boolean[22];
            c2.getSelectedFlags(get);
            for (byte i = 0; i < get.length; i++) {
                if (get[i] == true) {
                    dem = i;
                    break;
                }
            }
            //get[] = new boolean[c3.size()];       

            c3.getSelectedFlags(get);
            for (byte i = 0; i < 15; i++) {
                if (get[i] == true) {
                    dem2 = i;
                    break;
                }
            }

            c1.getSelectedFlags(get);
            for (byte i = 0; i < 2; i++) {
                if (get[i] == true) {
                    dem3 = i;
                    break;
                }
            }
            System.out.println("dem3 :" + dem3);
            if (dem3 == 1) {
                Communication gt = new Communication(false, this, anh, dai, ngan, dem, dem2, dem3, "", dem, dem, dem, dem);
                gt.start();
                Display.getDisplay(this).setCurrent(gt);
            }
            if (dem3 == 0) {
                ds.setCurrent(mf4);

            }

        } else if (c == quay) {
            build2();
        } else //==========================================================
        if (c == exitcuoi) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            ds.setCurrent(mf3);
        } else if (c == sang) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            byte dem4 = 0, dem5 = 0, dem6 = 0, dem7 = 0;
            boolean get[] = new boolean[c0.size()];
            c4.getSelectedFlags(get);
            for (byte i = 0; i < 3; i++) {
                if (get[i] == true) {
                    dem4 = i;
                }
            }
            //boolean get[] = new boolean[c3.size()];       

            c5.getSelectedFlags(get);
            for (byte i = 0; i < 3; i++) {
                System.out.println("dem5 i:" + i);
                if (get[i] == true) {
                    dem5 = i;
                }
            }
            c6.getSelectedFlags(get);
            for (byte i = 0; i < 2; i++) {
                System.out.println("dem6 i:" + i);
                if (get[i] == true) {

                    dem6 = i;
                }
            }
            c0.getSelectedFlags(get);
            for (byte i = 0; i < get.length; i++) {
                System.out.println("dem7 i:" + i);
                if (get[i] == true) {

                    dem7 = i;
                }
            }
            String text = tf0.getString();
            System.out.println("cac dem " + dem5 + dem6 + dem4);

            Communication gt = new Communication(false, this, anh, dai, ngan, dem, dem2, dem3, text, dem4, dem5, dem6, dem7);
            gt.start();
            Display.getDisplay(this).setCurrent(gt);
            System.out.println("gt= null;");
            gt = null;
        } else //============================================================
        if (c == view) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            List curr = (List) d;
            final String currFile = curr.getString(curr.getSelectedIndex());
            new Thread(new Runnable() {

                public void run() {
                    if (currFile.endsWith(SEP_STR) || currFile.equals(UP_DIRECTORY)) {
                        traverseDirectory(currFile);
                    } else {
                        // Show file contents
                        showFile(currFile);
                    }
                }
            }).start();
        } else if (c == prop) {
            //Controller.getInstance().categoryBar.setVisibility(false);

            List curr = (List) d;
            String currFile = curr.getString(curr.getSelectedIndex());
            showProperties(currFile);
        } else if (c == creat) {
            //Controller.getInstance().categoryBar.setVisibility(false);

            createFile();
        } else if (c == creatOK) {
            String newName = nameInput.getString();

            if ((newName == null) || newName.equals("")) {
                Alert alert =
                        new Alert(Text.eurro, Text.fileNameis, null,
                        AlertType.INFO);
                alert.setTimeout(Alert.FOREVER);
                Display.getDisplay(this).setCurrent(alert);
            } else {
                // Create file in a separate thread and disable all commands
                // except for "exit"
                executeCreateFile(newName, typeInput.getSelectedIndex() != 0);
                Display.getDisplay(this).getCurrent().removeCommand(creatOK);
                Display.getDisplay(this).getCurrent().removeCommand(back);
            }
        } else if (c == back) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            build();
        } else if (c == chonProf) {
            build();

        } else if (c == exit) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            startApp();

        } else if (c == delete) {
            //Controller.getInstance().categoryBar.setVisibility(true);
            List curr = (List) d;
            String currFile = curr.getString(curr.getSelectedIndex());
            executeDelete(currFile);
        } //===================================================================
        else {
            List curr = (List) d;
            final String currFile = curr.getString(curr.getSelectedIndex());
            new Thread(new Runnable() {

                public void run() {
                    if (currFile.endsWith(SEP_STR) || currFile.equals(UP_DIRECTORY)) {
                        traverseDirectory(currFile);
                    } else {
                        // Show file contents
                        showFile(currFile);
                    }
                }
            }).start();
        }
    }

    void delete(String currFile) {
        if (!currFile.equals(UP_DIRECTORY)) {
            if (currFile.endsWith(SEP_STR)) {
                checkDeleteFolder(currFile);
            } else {
                deleteFile(currFile);
                //showCurrDir();
                build();
            }
        } else {
            Alert cantDeleteFolder =
                    new Alert(Text.eurro,
                    Text.canNotDeleteTheUpDerec, null,
                    AlertType.INFO);
            cantDeleteFolder.setTimeout(Alert.FOREVER);
            Display.getDisplay(this).setCurrent(cantDeleteFolder);
        }
    }

    private void executeDelete(String currFile) {
        final String file = currFile;
        new Thread(new Runnable() {

            public void run() {
                delete(file);
            }
        }).start();
    }

    private void checkDeleteFolder(String folderName) {
        try {
            FileConnection fcdir =
                    (FileConnection) Connector.open("file://localhost/" + currDirName + folderName);
            Enumeration content = fcdir.list("*", true);

            //only empty directory can be deleted
            if (!content.hasMoreElements()) {
                fcdir.delete();
                //showCurrDir();
                build();
            } else {
                Alert cantDeleteFolder =
                        new Alert(Text.eurro, Text.canNotDeleTheNon + folderName, null,
                        AlertType.INFO);
                cantDeleteFolder.setTimeout(Alert.FOREVER);
                Display.getDisplay(this).setCurrent(cantDeleteFolder);
            }
        } catch (IOException ioe) {
            System.out.println(currDirName + folderName);

            ioe.printStackTrace();
        }
    }

    //Starts creatFile with another Thread
    private void executeCreateFile(final String name, final boolean val) {

        new Thread(new Runnable() {

            public void run() {
                createFile(name, val);
            }
        }).start();
    }

    /**
     * Show file list in the current directory .
     */
    public void showCurrDir() {
        System.out.println("4");
        Enumeration eee;
        FileConnection currDir = null;
        List browser;
        System.out.println("3");
        try {
            if (MEGA_ROOT.equals(currDirName)) {
                System.out.println("1");
                eee = FileSystemRegistry.listRoots();
                System.out.println("11");
                browser = new List(currDirName, List.IMPLICIT);

            } else {
                System.out.println("1111");
                currDir = (FileConnection) Connector.open(
                        "file://localhost/" + currDirName);
                eee = currDir.list();
                browser = new List(currDirName, List.IMPLICIT);
                // not root - draw UP_DIRECTORY
                browser.append(UP_DIRECTORY, dirIcon);
                System.out.println("2");
            }
            System.out.println("5");
            while (eee.hasMoreElements()) {
                String fileName = (String) eee.nextElement();

                if (fileName.charAt(fileName.length() - 1) == SEP) {
                    // This is directory
                    browser.append(fileName, dirIcon);
                } else {
                    // this is regular file
                    browser.append(fileName, fileIcon);
                }
                System.out.println("con chay");
            }
            System.out.println("~~~~~~~~~~~~~~~ :" + Controller.height);

           if (Controller.height>350) browser.setSelectCommand(view);



            //Do not allow creating files/directories beside root
            if (!MEGA_ROOT.equals(currDirName)) {
                if (Controller.height > 350) {
                    browser.addCommand(prop);
                    browser.addCommand(delete);
                }
                browser.addCommand(creat);

            }

            //browser.addCommand(exit);

            browser.setCommandListener(this);

            if (currDir != null) {
                currDir.close();
            }
            System.out.println("sao k ra");
            Display.getDisplay(this).setCurrent(browser);

        } catch (IOException ioe) {
            System.out.println("no day loi do");
            ioe.printStackTrace();
        }
    }

    void traverseDirectory(String fileName) {
        /*
         * In case of directory just change the current directory and show it
         */
        if (currDirName.equals(MEGA_ROOT)) {
            if (fileName.equals(UP_DIRECTORY)) {
                // can not go up from MEGA_ROOT
                return;
            }

            currDirName = fileName;
        } else if (fileName.equals(UP_DIRECTORY)) {
            // Go up one directory
            int i = currDirName.lastIndexOf(SEP, currDirName.length() - 2);

            if (i != -1) {
                currDirName = currDirName.substring(0, i + 1);
            } else {
                currDirName = MEGA_ROOT;
            }
        } else {
            currDirName = currDirName + fileName;
        }
        build();

    }

    void showFile(String fileName) {
        try {
            FileConnection fileConn =
                    (FileConnection) Connector.open("file:///" + currDirName + fileName, Connector.READ);

            /*
             * DataInputStream fis =
             * fileConn.openDataInputStream();//.openInputStream(); int size =
             * fis.available();              *
             * byte[] imageData= new byte[size]; fis.read(imageData, 0, size);
             *
             */

            InputStream fis = fileConn.openInputStream();
            long overallSize = fileConn.fileSize();
            int CHUNK_SIZE = 1024;
            int length = 0;
            byte[] imageData = new byte[0];
            while (length < overallSize) {
                byte[] data = new byte[CHUNK_SIZE];
                int readAmount = fis.read(data, 0, CHUNK_SIZE);
                byte[] newImageData = new byte[imageData.length + CHUNK_SIZE];
                System.arraycopy(imageData, 0, newImageData, 0, length);
                System.arraycopy(data, 0, newImageData, length, readAmount);
                imageData = newImageData;
                length += readAmount;
            }
            System.out.println("lenth" + imageData.length);
            fis.close();
            fileConn.close();
            /* if (imageData.length >= 350000) {
            Alert a = new Alert("error", "out of memory ! image size < 350kb ", null, AlertType.ERROR);
            a.setTimeout(3500);
            imageData = null;
            ds = Display.getDisplay(this);
            ds.setCurrent(a, mf5);
            
            System.out.println("ukm");
            
            } else {
             */

            anh = Image.createImage(imageData, 0, length);
            imageData = null;
            System.out.println("OK, da tao xong anh");

            //anh= Image.createImage(fis);
            fis.close();
            fileConn.close();
            //Alert a= new Alert("hi","select an image from memory", null ,AlertType.INFO);
            //ds.setCurrent(a);
            if (di == 0) {
                //ds = Display.getDisplay(this);
                ds.setCurrent(nao);
            } else {
                if (hien == false) {
                    hien = true;
                    encoder.start(bos);
                    encoder.setRepeat(0);
                    System.out.println("khoi tao ");
                }
                Resize re = new Resize();
                anh = re.CreateScaledImage(anh, dai, ngan);
                encoder.addFrame(anh);
                anh = null;
                encoder.setDelay(400);
                System.out.println("khoi tao xong");

                //ds = Display.getDisplay(this);
                ds.setCurrent(mf6);

            }
            //          }
            //==================================================================
      /*
             *
             * int entry = 10000; okio= null; int oldW = 0; int oldH = 0;
             *
             * try{ okio= Image.createImage(240,320); Graphics graphics =
             * okio.getGraphics();
             *
             * if(entry >= size) entry = size; int step = 0;
             * System.out.println("Size: " + size); while(step < size) {
             *
             * byte[] imageData = new byte[entry]; int length =
             * fis.read(imageData, 0, entry);
             * System.out.println("-----\nlength:" + length + " size :" + size);
             * try { goc = Image.createImage(imageData, 0, length);
             * System.out.println("OK"); } catch(Exception e) {
             * System.out.println("Loi: "+ e.getMessage()); } //
             * graphics.drawImage(goc,oldW,oldH, Graphics.TOP|Graphics.LEFT);
             *
             * for(int i = 0; i < length; ++i) { System.out.print(imageData[i]);
             * if(i%500 == 0) System.out.println(""); } // Lay toa do ve moi
             * oldW += goc.getWidth(); oldH += goc.getHeight();
             * System.out.println("----\n X: " + oldW + " Y: " + oldH);
             *
             *
             *
             * step += entry; System.out.println("Entry: " + entry + " Step: " +
             * step); if (step < size && size - step < entry) { entry = size -
             * step; }
             *
             * // break; } }catch (Exception e){ System.err.println(e); } Form a
             * = new Form ("dsc"); a.append(okio); ds.setCurrent(a);              *
             */

            //===============================================================
        } catch (Exception e) {
            System.out.println("LOi: " + e.getMessage());
        }





    }

    void deleteFile(String fileName) {
        try {
            FileConnection fc = (FileConnection) Connector.open("file:///" + currDirName + fileName);
            fc.delete();
        } catch (Exception e) {
            Alert alert =
                    new Alert(Text.eurro,
                    Text.canNotAcc, null, AlertType.INFO);
            alert.setTimeout(Alert.FOREVER);
            Display.getDisplay(this).setCurrent(alert);
        }
    }

    void showProperties(String fileName) {
        try {
            if (fileName.equals(UP_DIRECTORY)) {
                return;
            }

            FileConnection fc =
                    (FileConnection) Connector.open("file://localhost/" + currDirName + fileName);

            if (!fc.exists()) {
                throw new IOException(Text.fileDoesNot);
            }

            Form props = new Form(Text.profi + fileName);
            ChoiceGroup attrs = new ChoiceGroup(Text.attributes, Choice.MULTIPLE, attrList, null);

            attrs.setSelectedFlags(new boolean[]{fc.canRead(), fc.canWrite(), fc.isHidden()});

            props.append(new StringItem(Text.location, currDirName));
            props.append(new StringItem(Text.type, fc.isDirectory() ? Text.director : Text.regular));
            props.append(new StringItem(Text.modified, myDate(fc.lastModified())));
            props.append(attrs);

//            props.addCommand(back);
            props.addCommand(chonProf);
            //props.addCommand(exit);
            props.setCommandListener(this);

            fc.close();

            Display.getDisplay(this).setCurrent(props);
        } catch (Exception e) {
            Alert alert =
                    new Alert(Text.eurro,
                    Text.canNotAcc, null, AlertType.INFO);
            alert.setTimeout(Alert.FOREVER);
            Display.getDisplay(this).setCurrent(alert);
        }
    }

    void createFile() {
        Form creator = new Form(Text.newFile);
        nameInput = new TextField(Text.enterName, null, 256, TextField.ANY);
        typeInput = new ChoiceGroup(Text.enterFileType, Choice.EXCLUSIVE, typeList, iconList);
        creator.append(nameInput);
        creator.append(typeInput);
        creator.addCommand(creatOK);
        creator.addCommand(back);
        creator.addCommand(exit);
        creator.setCommandListener(this);
        Display.getDisplay(this).setCurrent(creator);
    }

    void createFile(String newName, boolean isDirectory) {
        try {
            FileConnection fc = (FileConnection) Connector.open("file:///" + currDirName + newName);

            if (isDirectory) {
                fc.mkdir();
            } else {
                fc.create();
            }

            //showCurrDir();
            build();
        } catch (Exception e) {
            String s = Text.canNotCreatFile + newName + "'";

            if ((e.getMessage() != null) && (e.getMessage().length() > 0)) {
                s += ("\n" + e);
            }

            Alert alert = new Alert(Text.eurro, s, null, AlertType.INFO);
            alert.setTimeout(Alert.FOREVER);
            Display.getDisplay(this).setCurrent(alert);
            // Restore the commands that were removed in commandAction()
            Display.getDisplay(this).getCurrent().addCommand(creatOK);
            Display.getDisplay(this).getCurrent().addCommand(back);
        }
    }

    private String myDate(long time) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date(time));

        StringBuffer sb = new StringBuffer();

        sb.append(cal.get(Calendar.HOUR_OF_DAY));
        sb.append(':');
        sb.append(cal.get(Calendar.MINUTE));
        sb.append(':');
        sb.append(cal.get(Calendar.SECOND));
        sb.append(',');
        sb.append(' ');
        sb.append(cal.get(Calendar.DAY_OF_MONTH));
        sb.append(' ');
        sb.append(monthList[cal.get(Calendar.MONTH)]);
        sb.append(' ');
        sb.append(cal.get(Calendar.YEAR));

        return sb.toString();
    }

    public void xuat(byte[] imageData2) {

        InputName ten1 = new InputName(2,imageData2, this);
        ten1.start();
        ds.setCurrent(ten1);
        //ds.setCurrent(ten1);
        ten1 = null;
    }
}

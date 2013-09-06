/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.ElementListener;
import com.nokia.mid.ui.IconCommand;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import event.Event;
import java.io.DataOutputStream;
import java.util.Enumeration;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import models.Text;
import views.About;
import views.Camera;
import views.Custom;
import views.LoadScreen;
import views.Setting;

/**
 *
 * @author TRITUEVIET
 */
public class Controller {
    String nameRecord= "tritueviet";
    private static Controller instance = null;
    public static Resources theme = null, theme1 = null;
    public CategoryBar categoryBar;
    private Image icon, icon2;
    public MakeGif main;
    private Camera came;
    private boolean chayCamera = true;
    public static int with = 0;
    public static int height = 0;

    private Controller() {
        // Init here
        // getCurrentLocation();
        
    }

    public static com.sun.lwuit.Image convert(Image img) {
        com.sun.lwuit.Image imag = null;
        return imag;
    }

    public static Image makeScale6(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 20) | (grey << 8) | grey;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale5(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 8) | (grey) | grey << 8;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale4(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 8) | (grey << 8) | grey << 8;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale3(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 16) | (grey << 8) | grey << 8;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale2(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 130) / 100) + ((green * 159) / 100) + ((blue * 111) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 16) | (grey << 8) | grey;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale1(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 16) | (grey << 8) | grey;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public void init() {
        IconCommand[] iconCommands = new IconCommand[4];

        for (int i = 0; i < iconCommands.length; i++) {
            try {
                System.out.println("height: "+height);
                if (height>350) icon = Image.createImage("/images/icon" + (i + 1) + ".png");
                else icon = Image.createImage("/images/I" + (i + 1) + ".png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            iconCommands[i] = new IconCommand("", icon, null, Command.SCREEN, 1);

        }
        categoryBar = new CategoryBar(iconCommands, true);
        // categoryBar.setHighlightColour(bankId);

        categoryBar.setElementListener(new CategoryElementListener());

        ///categoryBar.setVisibility(true);

    }

    public void gause() {
        //Gauge aGauge = new Gauge("", false, 20, 0);
        Alert ale = new Alert(Text.wait);
        //ale.setTimeout(500);
        Gauge gauge = new Gauge(null, false, Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING);
        ale.setIndicator(gauge);

        javax.microedition.lcdui.Display.getDisplay(main).setCurrent(ale);

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void chay(MakeGif main) {

        this.main = main;
        if (0 == 0) {
            LoadScreen load = new LoadScreen(main);
            javax.microedition.lcdui.Display.getDisplay(main).setCurrent(load);
            load.start();

            load = null;

            //categoryBar.setVisibility(false);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
        init();
        loadTheme();
        categoryBar.setVisibility(true);
        thongbao();

        showCamera();
    }

    public void handleEvent(int eventType, Event evt) {
        switch (eventType) {
            case Event.SECLECT_LANGUAGES: {
                showSetting();
            }
            break;

        }
    }

    public void showCamera() {
        came = new Camera();
        chayCamera = true;
        came.show();

    }

    public void showAbout() {
        //huyCamera();
        About about = new About();
        about.show();
    }

    public void showSetting() {
        //cài đặt
        Setting setting = new Setting();
        setting.show();
    }
    
    public void showCustume() {
        //
        Custom cus= new Custom();
        cus.showForm();
    }
    
//    public void huyCamera(){
//        Camera cam= new Camera();
//                    cam.huy();
//                    cam= null;
//                    Runtime.getRuntime().freeMemory();
//    }

    public void exit() {
        //   saveConfig();
        main.destroyApp(true);
    }

    public static void loadTheme() {
        try {
//            if (theme == null) {
//                theme = Resources.open("/themes/full_touch_theme.res");
//            }
//            UIManager.getInstance().setThemeProps(theme1.getTheme(theme1.getThemeResourceNames()[0]));
            System.out.println("  cao: " + height);
            System.out.println("  rong: " + with);
            if (height > 350) {
                if (theme1 == null) {
                    System.out.println("chay");
                    theme1 = Resources.open("/themes/full_touch_theme.res");
                }
                UIManager.getInstance().setThemeProps(theme1.getTheme(theme1.getThemeResourceNames()[0]));
            }
        } catch (Throwable ex) {
            //Dialog.show("Exception", ex.getMessage(), "OK", null);
        }

        //refreshTheme();
    }

    public void thongbao() {

        Alert thongBao = new Alert(Text.info, Text.thongbao+Text.numberTake+Text.thongbao1, null, AlertType.INFO);
        thongBao.setTimeout(3000);
        javax.microedition.lcdui.Display.getDisplay(main).setCurrent(thongBao);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void createRecord() {
        try {

            RecordStore rs = RecordStore.openRecordStore(nameRecord, true);

            // language
            byte[] data;
            data = Integer.toString(Text.languages).getBytes();
            rs.addRecord(data, 0, data.length);
            //
            data = Integer.toString(Text.numberTake).getBytes();
            rs.addRecord(data, 0, data.length);
            // update serach advance
            data = Integer.toString(Text.effect).getBytes();
            rs.addRecord(data, 0, data.length);

            data = Integer.toString(Text.imageNumber).getBytes();
            rs.addRecord(data, 0, data.length);
            
            data = Integer.toString(Text.value).getBytes();
            rs.addRecord(data, 0, data.length);
            
            data = Integer.toString(Text.typeEfect).getBytes();
            rs.addRecord(data, 0, data.length);
            
            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public void loadConfig() {
        try {
            RecordStore rs = RecordStore.openRecordStore(nameRecord, true);
            if (rs.getNumRecords() == 0) {
                System.out.println("creat");
                createRecord();
                return;
            }
            byte[] data;
            //Read language
            data = rs.getRecord(1);
            Text.languages = Integer.parseInt(new String(data));
            
            Text text = new Text();
            text.doiNgonNgu(Text.languages);
            // Read search advance
            data = rs.getRecord(2);
            Text.numberTake = Integer.parseInt(new String(data));
            
            data = rs.getRecord(3);
            Text.effect = Integer.parseInt(new String(data));
            
            data = rs.getRecord(4);
            Text.imageNumber = Integer.parseInt(new String(data));
            data = rs.getRecord(5);
            Text.value = Integer.parseInt(new String(data));
            data = rs.getRecord(6);
            Text.typeEfect = Integer.parseInt(new String(data));
            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
            System.out.println("loi doc recod");
            ex.printStackTrace();
        }
    }

    public void updateConfig() {

        try {
            RecordStore rs = RecordStore.openRecordStore(nameRecord, true);

            // Update language
            byte[] data;
            data = Integer.toString(Text.languages).getBytes();
            rs.setRecord(1, data, 0, data.length);
            //
            data = Integer.toString(Text.numberTake).getBytes();
            rs.setRecord(2, data, 0, data.length);
            // update serach advance
            data = Integer.toString(Text.effect).getBytes();
            rs.setRecord(3, data, 0, data.length);

            data = Integer.toString(Text.imageNumber).getBytes();
            rs.setRecord(4, data, 0, data.length);
            data = Integer.toString(Text.value).getBytes();
            rs.setRecord(5, data, 0, data.length);
            data = Integer.toString(Text.typeEfect).getBytes();
            rs.setRecord(6, data, 0, data.length);
            rs.closeRecordStore();

        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    class CategoryElementListener implements ElementListener {

        public void notifyElementSelected(CategoryBar bar, int selectedIndex) {
            if (bar == categoryBar) {
                if (selectedIndex == 0) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                    thongbao();
                    showCamera();
                } else if (selectedIndex == 1) {
                    if (chayCamera == true) {
                        if (came != null) {
                            came.huy();
                        }
                        chayCamera = false;
                    }
                    new Thread(new Runnable() {

                        public void run() {
                          //saveImage3File();
                            showCurrDir();
                        }
                    }).start();
                    main.KhoiChay();
                    main.build2();



                } else if (selectedIndex == 2) {
                    com.sun.lwuit.Display.init(this);
                    if (chayCamera == true) {
                        if (came != null) {
                            came.huy();
                        }
                        chayCamera = false;
                    }
                    showSetting();
                } else if (selectedIndex == 3) {
                    com.sun.lwuit.Display.init(this);
                    if (chayCamera == true) {
                        if (came != null) {
                            came.huy();
                        }
                        chayCamera = false;
                    }
                    showAbout();
                } else {
                    try {
                        exit();
                    } catch (Exception ex) {
                        System.out.println("k thoats ddc ");
                    }
                }

            }
        }
    }
//    void saveImage3File() {
//        // Receive a photo as byte array
//        // Save Image to file
//        
//        byte[] photo= new byte[100];
//        photo[0]=1;
//        
//        FileConnection fileConn = null;
//        DataOutputStream dos = null;
//
//        try {
//            //fileConn = (FileConnection) Connector.open("file:///E:/"+text+".gif");
//             fileConn = (FileConnection) Connector.open(System.getProperty("fileconn.dir.photos") + "tritueviet.gif");
////            if (!fileConn.exists()) {
////                fileConn.create();
////            }
////            dos = new DataOutputStream(fileConn.openOutputStream());
////            
////            dos.close();
//            fileConn.close();
//
//        } catch (Exception ioe) {
//           // System.out.println("Error!" + ioe+  "k loi ui mung qua");
//        }
//    }
    public void showCurrDir() {
        System.out.println("4");
        Enumeration eee;
        FileConnection currDir = null;
        List browser;
        System.out.println("3");
        try {
            
                eee = FileSystemRegistry.listRoots();
              
        } catch (Exception ioe) {
            
        }
    }
    
}
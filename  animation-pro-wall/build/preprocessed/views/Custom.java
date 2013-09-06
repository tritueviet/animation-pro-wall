/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.BlendImage;
import Control.Controller;
import java.io.IOException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.sensor.Condition;
import models.Text;

/**
 *
 * @author TRITUEVIET
 */
public class Custom {
    
    Command cmdBack= new Command(Text.Back, Command.BACK, 0);
    ChoiceGroup choi1, choi2, choi3;
    public Custom() {
        if (Controller.getInstance().categoryBar.getVisibility()==true){
            Controller.getInstance().categoryBar.setVisibility(false);
        }
    }
    
    public void showForm (){
        Form form = new Form(Text.setUpEffect);
        choi1= new ChoiceGroup(Text.blendImage, ChoiceGroup.POPUP);
        for (int i =0 ; i< 8; i++){
            try {
                if (Text.languages==0)choi1.append(Text.custom0[i],Image.createImage("/images/effect"+i+".png"));
                else choi1.append(Text.custom1[i],Image.createImage("/images/effect"+i+".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        choi1.setSelectedIndex(Text.imageNumber, true);
        
        
        choi2= new ChoiceGroup(Text.valuee, ChoiceGroup.POPUP);
        for (int i =0 ; i<256; i++){
            choi2.append(i+"", null);
        }
        choi2.setSelectedIndex(Text.value, true);
        
        
        choi3= new ChoiceGroup(Text.typee, ChoiceGroup.POPUP);
        for (int i =0 ; i< 20; i++ ){
            choi3.append(i+"", null);
        }
        choi3.setSelectedIndex(Text.typeEfect, true);
        BlendImage blend= new BlendImage();
        
        
        
        Image img;
        try {
            img = Image.createImage("/images/effect0.png");
            
            ImageItem im= new ImageItem("",blend.blend(img, Image.createImage("/images/effect"+Text.imageNumber+".png"), Text.value, Text.typeEfect) , ImageItem.LAYOUT_CENTER, "");
            form.append(im);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        form.append(choi1);
        form.append(choi2);
        form.append(choi3);
        
        form.addCommand(cmdBack);
        form.setItemStateListener(new ItemStateListener() {

            public void itemStateChanged(Item item) {
                Text.imageNumber= choi1.getSelectedIndex();
                Text.value=choi2.getSelectedIndex();
                Text.typeEfect=choi3.getSelectedIndex();
                Controller.getInstance().showCustume();
                Runtime.getRuntime().gc();
            }
        });
        
        form.setCommandListener(new CommandListener() {

            public void commandAction(Command c, Displayable d) {
                if (c==cmdBack){
                    Alert a= new Alert("", Text.done, null, AlertType.INFO);
                    a.setTimeout(2000);
                    Display.getDisplay(Controller.getInstance().main).setCurrent(a);
                    
                    Controller.getInstance().showSetting();
                    Runtime.getRuntime().gc();
                }
            }
        });
        
        Display.getDisplay(Controller.getInstance().main).setCurrent(form);
        
        Runtime.getRuntime().gc();
    }

}

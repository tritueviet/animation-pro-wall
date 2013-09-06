package views;

import java.io.IOException;
import models.Text;
import Control.Controller;
import com.sun.lwuit.Button;
import com.sun.lwuit.ButtonGroup;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.RadioButton;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.GenericListCellRenderer;
import event.Event;
import java.util.Hashtable;

/**
 *
 * @author WALL
 */
public class Setting extends Form implements ActionListener {

    public Command back2;
    Text text = new Text();
    public ButtonGroup radioButtonGroup, radioButtonGroup2;
    public Image img;
    //int so=7;
    private String strCmbBox[] = {"1", "2", "3", "4", "5"};
    ComboBox comboRdoBox;
    private final Button btnSetUp;

    public Setting() {

        if (Controller.getInstance().categoryBar.getVisibility()==false){
            Controller.getInstance().categoryBar.setVisibility(true);
        }
        setTitle(Text.setting);
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        Container con1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label lang = new Label(Text.lang);
        con1.addComponent(lang);

        radioButtonGroup = new ButtonGroup();
        RadioButton radioButton = new RadioButton("    English");

        radioButton.setUIID("ListItem");
        radioButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                Text.languages = 0;
                text.doiNgonNgu(0);
                Control.Controller.getInstance().handleEvent(Event.SECLECT_LANGUAGES, null);
            }
        });

        radioButtonGroup.add(radioButton);
        //addComponent(radioButton);

        RadioButton radioButton1 = new RadioButton("    Tiếng Việt");
        radioButton1.setUIID("ListItem");

        radioButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                text.doiNgonNgu(1);
                Text.languages = 1;
                //Event evt = new Event();
                //evt.setData(text.NgonNgu, ae);
                Control.Controller.getInstance().handleEvent(Event.SECLECT_LANGUAGES, null);
            }
        });


        radioButtonGroup.add(radioButton1);
        radioButtonGroup.setSelected(Text.languages);

        con1.addComponent(radioButton);
        con1.addComponent(radioButton1);

        con1.getStyle().setMargin(15, 10, 10, 10);


        addComponent(con1);
        //==============  
        Container con3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label lang1 = new Label("  " + Text.numberTakePhotho);
        con3.addComponent(lang1);
        String[] select = new String[4];
        if (Controller.height > 350) {
            for (int i = 0; i < strCmbBox.length - 1; i++) {
                select[i] = strCmbBox[i];
            }
        }
        if (Controller.height > 350) {
            comboRdoBox = new ComboBox(select);
        } else {
            comboRdoBox = new ComboBox(strCmbBox);
        }

        comboRdoBox.setSelectedIndex(Text.numberTake - 1);

        comboRdoBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Text.numberTake = comboRdoBox.getSelectedIndex() + 1;
            }
        });

        con3.addComponent(comboRdoBox);
        con3.getStyle().setMargin(15, 10, 10, 10);
        addComponent(con3);


        btnSetUp = new Button(Text.setUpEffect);

        //=================
        Container con2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label lang2 = new Label(Text.efect);
        con2.addComponent(lang2);

        radioButtonGroup2 = new ButtonGroup();
        RadioButton radio = null;
        for (int i = 0; i < Text.so; i++) {

            try {
                if (Text.languages == 0) {
                    radio = new RadioButton(Text.hieuUng0[i], Image.createImage("/" + i + ".png"));
                } else {
                    radio = new RadioButton(Text.hieuUng1[i], Image.createImage("/" + i + ".png"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            radio.getStyle().setPadding(0, 0, 10, 0);
            radio.setUIID("ListItem");
            radioButtonGroup2.add(radio);
            con2.addComponent(radio);

            radio.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    Text.effect = radioButtonGroup2.getSelectedIndex();
                    btnSetUp.setVisible(false);
                }
            });
        }
        //  so 8
        try {
            if (Text.languages == 0) {
                radio = new RadioButton(Text.hieuUng0[Text.so], Image.createImage("/setup.png"));
            } else {
                radio = new RadioButton(Text.hieuUng1[Text.so], Image.createImage("/setup.png"));
            }
        } catch (Exception e) {
        }
        radio.getStyle().setPadding(0, 0, 10, 0);
        radio.setUIID("ListItem");
        radioButtonGroup2.add(radio);
        con2.addComponent(radio);

        radio.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Text.effect = radioButtonGroup2.getSelectedIndex();
                btnSetUp.setVisible(true);
                repaint();

            }
        });


        radioButtonGroup2.setSelected(Text.effect);

        if (Text.effect == 7) {
            btnSetUp.setVisible(true);
        } else {
            btnSetUp.setVisible(false);
        }
        btnSetUp.addActionListener(this);
        con2.addComponent(btnSetUp);


        con2.getStyle().setMargin(15, 10, 10, 10);

        addComponent(con2);
        addCommandListener(this);

        layoutContainer();
        Runtime.getRuntime().gc();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSetUp) {
            Controller.getInstance().showCustume();
        }

    }
}

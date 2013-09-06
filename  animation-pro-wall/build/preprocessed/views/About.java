package views;

import Control.Controller;
import com.sun.lwuit.events.ActionEvent;
import models.Text;
import com.sun.lwuit.Command;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionListener;

/**
 *
 * @author WALL
 */
public class About extends Form implements ActionListener{

    private Command backCommand ;
    private String backView;
      
    
    public About() {
        setTitle(Text.about);
        
       //if (Controller.height>350) setScrollable(false);
        Font font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
    
      //  setLayout(new BoxLayout(CENTER));
        //TextArea ta = new TextArea("Nội dung giới thiệu aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

       // ta.getStyle().setFgColor(0xFFFFFF);
      
       // ta.setUIID("Label");
        TextArea textArea=null;
        if (Text.languages==1)
            textArea = new TextArea("Giúp đỡ:"
                    + "\n\nAnimation Pro cho phép xây dựng ảnh động chuyên nghiệp trên điện thoại."
                    + "\nMục cài đặt giúp lựa chọn ngôn ngữ và hiệu ứng khi chụp ảnh tạo ảnh động. Chức năng thứ hai làm cho ứng dụng có thể tạo ảnh từ ảnh có sẵn trong bộ nhớ."
        + "\nPhần mềm được  xây dựng và cập nhật thường xuyên bởi WALL"
        + "\n\nThông tin:"
        + "\n\nFacebook: www.facebook.com/tritueviet01"
        + "\nEmail: tritueviet01@yahoo.com "
        + "\n\nNhà phát triển: Vu Van Tuong "
        + "\nTên ứng dụng: AnimationPro "
        + "\nPhiên bản: 2.1"
        + "\nCopyright  ©2013 WALL. All rights reversed", 2, 10);
         
        else  textArea = new TextArea("Help:"
                +"\n\nAnimation Pro allows building professional animations on your mobile device."
                + "\nThe installation help choose the language and photographic effects, animate. The second function makes possible imaging applications from existing images in memory."
        + "\nThe application has been developed and updated by WALL "
        + "\n\nAbout:"
        + "\n\nFacebook: www.facebook.com/tritueviet01"
        + "\nEmail: tritueviet01@yahoo.com "
        + "\n\nDeveloper name: Vu Van Tuong "
        + "\nApplication name: AnimationPro "
        + "\nThe version number: 2.1"
        + "\nCopyright  ©2013 WALL. All rights reversed", 2, 10);
        
        textArea.setEditable(false);
        textArea.setGrowByContent(true);
        textArea.setUIID("Form");
        textArea.getStyle().setFont(font);
        addComponent(textArea);
       // ta.setEditable(false);
        //setLayout(new BoxLayout(BoxLayout.Y_AXIS));
       
       // addComponent(ta);
       show();
    }

    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}

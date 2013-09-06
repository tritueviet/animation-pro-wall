package views;

import Control.Controller;
import Control.MakeGif;
import java.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.GameCanvas;

/**
 * @WAll
 */
public class LoadScreen extends GameCanvas{
    private Graphics g;
    MakeGif main;
    
    
    public LoadScreen(MakeGif main) {
        super(false);
        setFullScreenMode(true);
        Controller.with= getWidth();
        Controller.height= getHeight();
        this.g = this.getGraphics();
        this.main= main;
        
    }

    public void paint() {
        g.setColor(0xffffff);
        g.fillRect(0, 0, getWidth(), getHeight());
        try {
            
            g.drawImage(Image.createImage("/images/conga.png"), getWidth() / 2, getHeight() / 2, Graphics.VCENTER | Graphics.HCENTER);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.flushGraphics();

    }

    public void start() {
       
            paint();
            
    }
}

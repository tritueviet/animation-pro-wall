
package views;
import Control.Controller;
import Control.MakeGif;
import java.io.IOException;
import java.util.Random;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.GameCanvas;
import models.Text;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wall
 */
 class Resuit extends GameCanvas implements Runnable,CommandListener {
     private   Random     nn = new Random();
     private MakeGif midlet;
    private Command exit;
    
    boolean run;
    private Image im;
    int dem =0;
    private int h=25;
    private int w=10;
    int dau=0, cuoi=0;
    
  //  private final boolean run;
    private Display display;
    private Form mf;
    private String text;
    private boolean daung;
    int quay=1;
    public Resuit(int quay,boolean suppressKeyEvents,MakeGif midlet,boolean daung,byte[] photo,String text) {
        
        super(suppressKeyEvents);
        setTitle(Text.results);
        this.quay=quay;
        setFullScreenMode(false);
        run = true;
        
        this.daung = daung;
        this.midlet = midlet;
        try {
            this.im = Image.createImage(photo, 0, photo.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.text= text;
        
        
        
        exit=new Command(Text.reset,Command.OK,1);
        addCommand(exit);
        updateGameScreen(getGraphics());
        setCommandListener(this);
  }

   
    public void run() {
       while (run){
      // update game elements, positions, collisions, etc..
      updateGameState();
      // render screen
      updateGameScreen(getGraphics());
      // redraws screen
      this.flushGraphics();
      // controls at which rate the updates are done
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {  
        e.printStackTrace();
      }
    }
    }
   
   // start Thread
  public void start() {
    run = true;
    Thread t = new Thread(this);
    t.start();
    
  }
  
  // stop Thread
  public void stop() {
   // run = false;
  }

    public void commandAction(Command c, Displayable d) {
        if(c== exit){
            if(quay==1) Controller.getInstance().showCamera();
            else midlet.build2();
        }
        
    }
     protected void pointerPressed(int x, int y) {
//        w=x;
//        h=y;
        dau = x;
        cuoi = y;
    }
     protected void pointerDragged(int x, int y) {
        w=w+ x - dau;
        h=h+ y - cuoi;
        dau = x;
        cuoi = y;
    }
     
    private void updateGameState() {
        int keyStates = getKeyStates();
        if ((keyStates & LEFT_PRESSED) != 0){
            w-=4;
        }
        else if((keyStates & RIGHT_PRESSED) != 0){
            w+=4;
        }
        else  if ((keyStates & UP_PRESSED) != 0){
            h-=4;
        }
        else if((keyStates & DOWN_PRESSED) != 0){
            h+=4;
        }
    }

    private void updateGameScreen(Graphics g) {
       g.setColor(0x000000);
       g.fillRect(0, 0,getWidth(),getHeight());
       g.setColor(0xffffff);
      for (int j=0; j< getHeight(); j++){
            int x =( nn.nextInt() % ( 3 * getWidth() ) ) / 2;
            if( x >= getWidth() ){
                x = -1;
            }
            g.drawLine( x, j, x, j );
      }
      if (daung== true){
      g.drawString(Text.successful, 5, 5, Graphics.TOP|Graphics.LEFT);
      }
      else {g.drawString(Text.failed, 5, 5, Graphics.TOP|Graphics.LEFT);}
       g.drawImage(im,w,h,Graphics.TOP | Graphics.LEFT);
    }

   
}

package Main;

import GameHelper.Helper;
import GameState.GameStateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public class GameWindow extends Frame implements Runnable, KeyListener {
    private boolean isRunning = true;
    private Image backImage;
    private Graphics backGraphics;
    GameStateManager gsm = new GameStateManager();

    public GameWindow(){
        this.setGame();
        this.init();
        this.setFocusable(true);


    }

    public void setGame(){
        this.setTitle("Tich Chu saves her grandmother");
        this.setSize(Helper.WIDTH,Helper.HEIGHT);
        this.setVisible(true);
        this.setLocation(200,100);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.addKeyListener(this);
        this.setFocusable(true);
    }

    public void init(){

        GameManager.getInstance().setWindowWidth(1600);
        GameManager.getInstance().setWindowHeight(900);
    }

    public void update(){
        gsm.update();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.clearRect(0,0,Helper.WIDTH,Helper.HEIGHT);
        gsm.draw(g);
    }

    @Override
    public void run() {
        while(isRunning){
            gsm.update();
            repaint();
            try {
                Thread.sleep(Helper.FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Graphics g) {
        //    super.update(g); //To change body of generated methods, choose Tools | Templates.
        if (backImage == null) {
            backImage = createImage(this.getWidth(), this.getHeight());
            backGraphics = backImage.getGraphics();
        }
        backGraphics.setColor(getBackground());
        backGraphics.fillRect(0, 0, getWidth(), getHeight());
        backGraphics.setColor(getForeground());
        paint(backGraphics);
        g.drawImage(backImage, 0, 0, null);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        gsm.keyTyped(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.keyRelased(e.getKeyCode());
}
}

package GameState;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class About extends GameState {
    private BufferedImage sprite;

    public About(GameStateManager gsm) {
        super(gsm);
        try{
            this.sprite = ImageIO.read(new File(Helper.ABOUT_STATE));
        }catch(Exception e){}
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,0,0,null);
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_B){
            gsm.states.pop();
        }
    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }

    @Override
    public void mouseClicked(int k) {

    }

    @Override
    public void mouseReleased(int k) {

    }
}

package Entities.Player;

import Entities.Animation;
import Main.GameManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public class Player extends PlayerAbstract {
    private int direction;
    protected Animation animation;

    public Player(double positionX, double positionY) {
        super(positionX, positionY);
        direction = 0;
        animation = new Animation("Resources/Image/run_right.png",32,32,100);

    }

    @Override
    public void move() {
        switch(direction){
            case 1:
                this.positionX += this.speed;
                break;
            case 2:
                this.positionX -= this.speed;
                break;
        }
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_RIGHT){
            this.direction = 1;
        }else if(k == KeyEvent.VK_LEFT){
            this.direction = 2;
        }
    }

    @Override
    public void keyRelased(int k) {
        this.direction = 0;
    }

    @Override
    public void keyTyped(int k) {

    }

    @Override
    public void shot() {

    }

    @Override
    public void mouseClicked(int k) {

    }

    @Override
    public void mouseReleased(int k) {

    }

    @Override
    public void fireRocket() {

    }

    public void draw(Graphics g){
        if(direction == 1){
            animation.draw(g,(int)positionX + GameManager.getInstance().getLocationX(),
                           (int)positionY + GameManager.getInstance().getLocationY());
            if(getPositionX() > GameManager.getInstance().getWindowWidth()/2){
                int loX = GameManager.getInstance().getLocationX();
                GameManager.getInstance().setLocationX(loX - this.speed);
            }
        }else if(direction == 0){
            g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
        }

    }
}

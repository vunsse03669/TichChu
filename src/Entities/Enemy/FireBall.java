package Entities.Enemy;

import Entities.Player.PlayerManager;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class FireBall {
    private BufferedImage sprite;
    private int positionX;
    private int positionY;
    private int angle = 0;
    private int speed;

    public FireBall(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = 2;
        try{
            this.sprite = ImageIO.read(new File(Helper.FIRE_BALL));
        }catch (Exception e){}
    }
    public void update(){
        this.move();
    }
    public void move() {
        angle++;
        this.positionX +=  (15 * Math.sin(angle * 0.09));
        this.positionY +=  (15 * Math.cos(angle * 0.09));
        positionX-= this.speed;
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getWidth(){
        return sprite.getWidth();
    }
    public int getHeight(){
        return sprite.getHeight();
    }
    public boolean collisionPlayer(){
        Rectangle rectBall = new Rectangle(this.positionX,this.positionY,this.getWidth(),this.getHeight());
        Rectangle rectPlayer = new Rectangle((int) PlayerManager.getInstance().getPlayerFly().getPositionX(),
                (int)PlayerManager.getInstance().getPlayerFly().getPositionY(),
                (int)PlayerManager.getInstance().getPlayerFly().getWidth(),
                (int)PlayerManager.getInstance().getPlayerFly().getHeight());

        return rectBall.intersects(rectPlayer);
    }
}

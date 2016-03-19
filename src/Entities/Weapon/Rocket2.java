package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class Rocket2{
    private int count = 0;
    private double positionX;
    private double getPositionY;
    private BufferedImage sprite;
    public Rocket2(double positionX, double positionY) {
        this.positionX = positionX;
        this.getPositionY = positionY;
        try{
            this.sprite = ImageIO.read(new File(Helper.ROCKET));
        }catch(Exception e){}
    }

    public void move() {
        if(this.positionX <= 500){
            this.positionX += Helper.PLAYER_BULLET_SPEED;
        }else{
            count++;
            if(count == 1){


            }
        }
    }
    public void update(){
        this.move();
    }
    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionX,null);
    }

    public double getPositionX() {
        return positionX;
    }

    public double getGetPositionY() {
        return getPositionY;
    }
}

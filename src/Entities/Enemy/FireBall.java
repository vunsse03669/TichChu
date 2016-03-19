package Entities.Enemy;

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
    private double positionX;
    private double positionY;
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
        System.out.println(this.positionX);
    }
    public void move() {
        angle++;
        this.positionX += (double) (15 * Math.sin(angle * 0.09));
        this.positionY += (double) (15 * Math.cos(angle * 0.09));
        positionX-= this.speed;
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }
}

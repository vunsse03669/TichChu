package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class BossLevel1 extends EnemyAbstract {
    private int angle;
    Animation animation;
    private int speedX = 15;
    private int speedY = 15;

    public BossLevel1(int positionX, int positionY) {
        super(positionX, positionY);
        this.hp = 100;
        animation = new Animation(Helper.BOSS_LV1,135,148,100);
        imageHeight = 148;
        imageWidth = 135;
        this.speed = 10;
        angle = 0;
    }

    @Override
    public void move() {
        if(this.hp >= 50){
            this.positionY += this.speed;
            if(this.positionY >= Helper.HEIGHT || this.positionY <= 0){
                this.speed =- this.speed;
            }
        }

//


    }

    public void draw(Graphics g){
        animation.draw(g,(int)positionX , (int)positionY );
        g.setColor(Color.GREEN);
        g.fillRect((int)this.positionX,(int)this.positionY,this.hp,10);
        g.drawRect((int)this.positionX,(int)this.positionY,this.hp,10);
    }

    public void update(){
        this.move();
    }

    public void shot(){}


}

package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/18/2016.
 */
public class Ruoi extends EnemyAbstract {
    Animation anim;

    public Ruoi(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.RUOI, 178, 149, 100);
        imageWidth = 178;
        imageHeight = 149;
        hp = 8;
        this.speed = Helper.ENEMY1_SPEED;
    }

    public void move() {
        //Di chuyen tu phai qua trai.
        this.positionX -= this.speed;
        if(this.positionY >= Helper.HEIGHT || this.positionY <= 0){
            this.speed = -this.speed;
        }
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}

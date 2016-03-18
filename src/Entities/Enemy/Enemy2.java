package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy2  extends EnemyAbstract {
    Animation anim, anim1;

    int e = 0;

    public Enemy2(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY2, 57, 36, 50);
        imageWidth = 57;
        imageHeight = 36;
        hp = 1;
        this.speed = Helper.ENEMY1_SPEED;

    }

    public void move() {
        //Di chuyen tu phai qua trai.
        e++;
        this.positionY += 2 * Math.sin(e * Math.PI/96);
        this.positionX -= this.speed;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}

package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/18/2016.
 */
public class Enemy8 extends EnemyAbstract {
    Animation anim;
    int e = 0;

    public Enemy8(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY8, 109, 123, 100);
        imageWidth = 109;
        imageHeight = 123;
        hp = 10;
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

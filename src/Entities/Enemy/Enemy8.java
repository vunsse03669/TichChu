package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/18/2016.
 */
public class Enemy8 extends EnemyAbstract {
    Animation anim;
    int speedX = 3;
    int speedY = 0;
    int e = 0;

    public Enemy8(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY8, 109, 123, 100);
        imageWidth = 109;
        imageHeight = 123;
        hp = 10;
    }

    public void move() {
        //Di chuyen tu phai qua trai.
        e++;
        this.positionY += 2 * Math.sin(e * Math.PI/96);
        this.positionX -= speedX;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}

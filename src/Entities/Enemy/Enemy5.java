package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy5 extends EnemyAbstract {
    Animation anim;

    public Enemy5(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY5, 90, 111, 100);
        imageWidth = 90;
        imageHeight = 111;
        hp = 2;
    }

    public void move() {
        //Di chuyen tu phai qua trai.
        this.positionX -= Helper.ENEMY5_SPEED;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}

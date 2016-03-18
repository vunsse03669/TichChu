package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/18/2016.
 */
public class Enemy9 extends EnemyAbstract {
    Animation anim;

    public Enemy9(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY9, 108, 110, 100);
        imageWidth = 108;
        imageHeight = 110;
        hp = 3;
        this.speed = Helper.ENEMY1_SPEED;
    }

    public void move() {
        //Di chuyen tu phai qua trai.
        this.positionX -= this.speed;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}

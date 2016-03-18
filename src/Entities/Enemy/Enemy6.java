package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy6  extends EnemyAbstract {
    Animation anim;

    public Enemy6(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY6, 166, 118, 100);
        imageWidth = 166;
        imageHeight = 118;
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

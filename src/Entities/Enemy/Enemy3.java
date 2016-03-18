package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy3 extends EnemyAbstract {
    Animation anim, anim1;
    public Enemy3(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY3, 88, 58, 100);
        imageWidth = 88;
        imageHeight = 58;
        hp = 2;
        this.speed = Helper.ENEMY1_SPEED;
    }

    @Override
    public void move() {
        this.positionY += 2;
        this.positionX -= this.speed;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}

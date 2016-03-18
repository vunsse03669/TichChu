package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy4 extends EnemyAbstract {
    Animation anim;

    public Enemy4(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY4, 144, 78, 100);
        imageWidth = 144;
        imageHeight = 78;
        hp = 2;
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

package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy5 extends EnemyAbstract {
    Animation anim;

    public Enemy5(int positionX, int positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY5, 90, 111, 100);
        imageWidth = 90;
        imageHeight = 111;
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

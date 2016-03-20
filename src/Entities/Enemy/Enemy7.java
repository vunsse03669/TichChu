package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/18/2016.
 */
public class Enemy7 extends EnemyAbstract {
    Animation anim;

    public Enemy7(int positionX, int positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY7, 167, 115, 100);
        imageWidth = 167;
        imageHeight = 115;
        hp = 10;
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

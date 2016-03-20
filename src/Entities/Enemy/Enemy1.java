package Entities.Enemy;

import Entities.Animation;
import Entities.Weapon.BulletAbstract;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy1 extends EnemyAbstract {


    public Enemy1(int positionX, int positionY) {
        super(positionX, positionY);

        try{
                anim = new Animation(Helper.ENEMY1, 65, 51, 100);
        }catch(Exception e){}
        imageWidth = 65;
        imageHeight = 51;
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


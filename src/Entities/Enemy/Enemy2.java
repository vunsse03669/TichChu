package Entities.Enemy;

import Entities.Animation;
import Entities.Weapon.BulletAbstract;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy2  extends EnemyAbstract {

    int e = 0;

    public Enemy2(int positionX, int positionY) {
        super(positionX, positionY);

        try{
            //anim = new Animation(Helper.ENEMY2_SLOW, 53, 36, 50);
                anim = new Animation(Helper.ENEMY2, 57, 36, 50);
        }catch(Exception e){}
        imageWidth = 57;
        imageHeight = 36;
        hp = 1;
        this.speed = Helper.ENEMY1_SPEED;

    }
    public void update(){
        this.move();
    }

    public void move() {
        //Di chuyen tu phai qua trai.

//        e++;
//        this.positionY += 2 * Math.sin(e * Math.PI/96);
        this.positionX -= this.speed;
    }

    @Override
    public void draw(Graphics g) {
            anim.draw(g, (int) this.positionX, (int) this.positionY);

    }


}

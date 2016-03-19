package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class BulletPlayerLv1 extends BulletAbstract{
    public BulletPlayerLv1(double positionX, double positionY) {
        super(positionX, positionY);
        damage = 1;
        try{
            this.sprite = ImageIO.read(new File(Helper.BULLET_LV1));
        }catch(Exception e){}
    }

    @Override
    public void move() {
        this.positionX += 10;
        System.out.println(positionX);
    }
}

package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class BulletPlayerLv4 extends BulletAbstract{
    public BulletPlayerLv4(double positionX, double positionY) {
        super(positionX, positionY);
        damage = 1;
        try{
            this.sprite = ImageIO.read(new File(Helper.BULLET_LV1));
        }catch(Exception e){}
    }

    @Override
    public void move() {
        this.positionX += Helper.PLAYER_BULLET_SPEED;
        this.positionY += Helper.PLAYER_BULLET_SPEED/2;
    }
}

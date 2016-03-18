package Entities.Weapon;

import GameHelper.Helper;
import GameState.Help;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/18/2016.
 */
public class BulletPlayerLv3 extends BulletAbstract {
    public BulletPlayerLv3(double positionX, double positionY) {
        super(positionX, positionY);
        this.damage = 3;
        try{
            this.sprite = ImageIO.read(new File(Helper.BULLET_LV3));
        }catch(Exception e){}
    }

    @Override
    public void move() {
        this.positionX += 10;
    }
}

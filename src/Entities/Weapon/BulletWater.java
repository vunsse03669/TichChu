package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class BulletWater extends BulletAbstract {
    public BulletWater(int positionX, int positionY) {
        super(positionX, positionY);
        try{
            this.sprite = ImageIO.read(new File(Helper.BULLET_WATER));
    }catch(Exception e){}
    }

    @Override
    public void move() {
        this.positionX += 10;
    }
}

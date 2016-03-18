package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class BulletPlayerLv2 extends BulletAbstract {
    public BulletPlayerLv2(double positionX, double positionY) {
        super(positionX, positionY);
        try{
            damage = 2;
            if(BulletAbstract.isSlow){
                this.sprite = ImageIO.read(new File(Helper.BULLET_LV4));
            }
            else{
                this.sprite = ImageIO.read(new File(Helper.BULLET_LV2));
            }
        }catch(Exception e){}
    }

    @Override
    public void move() {
        this.positionX += 10;
    }
}

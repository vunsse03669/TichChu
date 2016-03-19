package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by chtnnnmtgkyp on 3/19/2016.
 */
public class BulletRocket3 extends BulletAbstract {
    public BulletRocket3(double positionX, double positionY) {
        super(positionX, positionY);
        damage = 1;
        try{
            this.sprite = ImageIO.read(new File(Helper.BULLET_RK3));
        }catch(Exception e){}
    }

    @Override
    public void move() {
        this.positionY += 10;
    }
}

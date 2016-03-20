package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by chtnnnmtgkyp on 3/19/2016.
 */
public class BulletRocket1 extends BulletAbstract {
    public BulletRocket1(int positionX, int positionY) {
        super(positionX, positionY);
        damage = 1;
        try{
            this.sprite = ImageIO.read(new File(Helper.BULLET_RK1));
        }catch(Exception e){}
    }

    @Override
    public void move() {
        this.positionX -= 10;
    }
}

package Entities.Weapon;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class Rocket extends BulletAbstract {
    public Rocket(int positionX, int positionY) {
        super(positionX, positionY);
        damage = 100;
        try {
            this.sprite = ImageIO.read(new File(Helper.ROCKET));
        } catch (Exception e) {
        }
    }

    @Override
    public void move() {
        this.positionX += 10;
    }
}

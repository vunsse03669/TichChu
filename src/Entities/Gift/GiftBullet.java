package Entities.Gift;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class GiftBullet extends GiftAbstract  {
    public GiftBullet(double positionX, double positionY) {
        super(positionX, positionY);
        try{
            this.sprite = ImageIO.read(new File(Helper.GIFT_BULLET));
        }catch(Exception e){}
    }
}

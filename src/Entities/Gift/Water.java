package Entities.Gift;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class Water extends GiftAbstract {
    public Water(double positionX, double positionY) {
        super(positionX, positionY);
        try{
            this.sprite = ImageIO.read(new File(Helper.WATER));
        }catch (Exception e){}
    }
}

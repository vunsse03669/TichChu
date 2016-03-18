package Entities.Gift;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class Ice extends GiftAbstract {
    public Ice(double positionX, double positionY) {
        super(positionX, positionY);
        try{
            this.sprite = ImageIO.read(new File(Helper.ICE));
        }catch(Exception e){}
    }
}

package Entities.Gift;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/18/2016.
 */
public class Heart extends GiftAbstract {
    public Heart(int positionX, int positionY) {
        super(positionX, positionY);
        try{
            this.sprite = ImageIO.read(new File(Helper.HEART));
        }catch(Exception e){}
    }
}

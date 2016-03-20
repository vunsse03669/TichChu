package Entities.Gift;

import Entities.GameObject;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class Coin extends GiftAbstract {
    public Coin(int positionX, int positionY) {
        super(positionX, positionY);
        try{
            this.sprite = ImageIO.read(new File(Helper.COIN));
        }catch(Exception e){}
    }
}

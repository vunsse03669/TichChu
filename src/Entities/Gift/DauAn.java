package Entities.Gift;

import GameHelper.Helper;
import GameState.Help;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageInputStream;
import java.io.File;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class DauAn extends GiftAbstract {
    public DauAn(double positionX, double positionY) {
        super(positionX, positionY);
        try{
            this.sprite = ImageIO.read(new File(Helper.DAU_AN));
        }catch (Exception e){}
    }
}

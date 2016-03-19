package Entities.Gift;

import java.util.Vector;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class GiftManager {
    Vector<GiftAbstract> vectorGift;
    private static GiftManager sharePointer;

    private GiftManager(){
        vectorGift = new Vector<GiftAbstract>();
        vectorGift.add(new GiftBullet(1400,450));
        vectorGift.add(new Heart(1600,450));
        vectorGift.add(new Ice(1700,450));
        vectorGift.add(new GiftBullet(10000,700));
        vectorGift.add(new DauAn(1800,200));
        vectorGift.add(new Water(1800,500));
    }

    public static GiftManager getInstance(){
        if(sharePointer == null){
            sharePointer = new GiftManager();
        }
        return sharePointer;
    }

    public Vector<GiftAbstract> getVectorGift() {
        return vectorGift;
    }
}

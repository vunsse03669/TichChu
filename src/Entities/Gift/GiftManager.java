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
        vectorGift.add(new GiftBullet(10000,700));
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

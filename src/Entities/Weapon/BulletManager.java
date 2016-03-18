package Entities.Weapon;

import java.util.Vector;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class BulletManager {
    Vector<BulletAbstract> vectorBulelt;
    private static BulletManager sharePointer;

    private BulletManager(){
        vectorBulelt = new Vector<BulletAbstract>();
    }

    public static BulletManager getInstance(){
        if(sharePointer == null){
            sharePointer = new BulletManager();
        }
        return sharePointer;
    }

    public Vector<BulletAbstract> getVectorBulelt() {
        return vectorBulelt;
    }
}

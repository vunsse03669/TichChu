package Entities.Enemy;

import java.util.Vector;

/**
 * Created by Mr Hung on 3/19/2016.
 */
    public class FireBallManager {
    private Vector<FireBall>vectorFire;
    private static FireBallManager sharePointer;

   private FireBallManager(){
        vectorFire = new Vector<>();
       vectorFire.add(new FireBall(1000,300));
   }

   public static FireBallManager getInstance(){
       if(sharePointer == null){
           sharePointer = new FireBallManager();
       }
       return sharePointer;
   }

    public Vector<FireBall> getVectorFire() {
        return vectorFire;
    }
}

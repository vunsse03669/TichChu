package Entities.Weapon;

import java.util.Vector;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class RocketManager {
    private static RocketManager sharePointer;
    private Vector<Rocket2> vectorRocket;
    private RocketManager(){
        vectorRocket = new Vector<>();
    }

    public static RocketManager getInstance(){
        if(sharePointer == null){
            sharePointer = new RocketManager();
        }
        return sharePointer;
    }

    public Vector<Rocket2> getVectorRocket() {
        return vectorRocket;
    }
}

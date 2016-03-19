package Entities.Enemy;

import java.util.Vector;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class EnemyManager {
    private Vector<EnemyAbstract> vectorEnemy;
    private static EnemyManager sharePointer;

    private EnemyManager(){
        vectorEnemy = new Vector<>();
        vectorEnemy.add(new Dragon(3000,200));
        vectorEnemy.add(new Dragon(3500,800));
        vectorEnemy.add(new Dragon(4000,500));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                vectorEnemy.add(new Enemy3(500 +j*100,100 + i*100));
                vectorEnemy.add(new Enemy2(2000+j*100,100 + i*100));
               // vectorEnemy.add(new Enemy1(5500+j*100,100 + i*100));
                vectorEnemy.add(new Enemy8(13000+j*100,100 + i*100));
                vectorEnemy.add(new Enemy9(14000+j*100,100 + i*100));
            }
        }

        vectorEnemy.add(new Enemy4(6500, 100));
        vectorEnemy.add(new Enemy4(7000, 500));
        vectorEnemy.add(new Enemy4(6700, 800));
        vectorEnemy.add(new Enemy4(6800, 650));

        vectorEnemy.add(new Enemy5(7000,100));
        vectorEnemy.add(new Enemy5(6800,800));
        vectorEnemy.add(new Enemy5(7200,300));
        vectorEnemy.add(new Enemy5(7000,500));

        vectorEnemy.add(new Enemy6(7500,100));
        vectorEnemy.add(new Enemy6(7700,500));
        vectorEnemy.add(new Enemy6(7900,800));
        vectorEnemy.add(new Enemy6(8100,250));

        vectorEnemy.add(new Ruoi(8500,250));
        vectorEnemy.add(new Ruoi(8700,100));
        vectorEnemy.add(new Ruoi(9200,700));
        vectorEnemy.add(new Ruoi(8800,600));
        vectorEnemy.add(new Ruoi(9500,250));

        vectorEnemy.add(new Enemy7(10000,250));
        vectorEnemy.add(new Enemy7(10500,550));
        vectorEnemy.add(new Enemy7(11000,350));
        vectorEnemy.add(new Enemy7(11500,750));
        vectorEnemy.add(new Enemy7(11500,250));
        vectorEnemy.add(new Enemy7(10000,750));
        vectorEnemy.add(new Enemy7(10800,750));


    }

    public static EnemyManager getInstance(){
        if(sharePointer == null){
            sharePointer = new EnemyManager();
        }
        return sharePointer;
    }

    public Vector<EnemyAbstract> getVectorEnemy() {
        return vectorEnemy;
    }
}

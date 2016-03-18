package Entities.Weapon;

import Entities.Animation;
import Entities.Enemy.*;
import Entities.GameObject;
import Entities.Gift.Coin;
import Entities.Gift.GiftManager;
import Entities.Player.Player;
import Entities.Player.PlayerAbstract;
import Entities.Player.PlayerManager;
import Entities.Sound.AudioPlayer;
import GameHelper.Helper;


import java.awt.*;
import java.util.HashMap;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public abstract class BulletAbstract extends WeaponAbstract {
    private HashMap<String,AudioPlayer> sound;
    protected int speed;
    public static boolean isSlow = false;
    public BulletAbstract(double positionX, double positionY) {
        super(positionX, positionY);
        sound = new HashMap<>();
        sound.put("bang",new AudioPlayer(Helper.BANG));

    }
    public void update(){
        this.move();

    }
    public abstract void move();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    public boolean collisionEnemy(){

        boolean isCollision = false;
        Rectangle rectBullet = new Rectangle((int)this.positionX,(int)this.positionY,(int)this.getWidth(),(int)this.getHeight());
        for(EnemyAbstract enemy : EnemyManager.getInstance().getVectorEnemy()){
            Rectangle rectEnemy = new Rectangle((int)enemy.getPositionX(),(int)enemy.getPositionY(),
                    (int)enemy.getImageWidth(),(int)enemy.getImageHeight());
            if(rectBullet.intersects(rectEnemy)){
                if(this instanceof Rocket){
                    PlayerManager.getInstance().getPlayerFly().notifiObserver();
                    PlayerManager.getInstance().getPlayerMouse().notifiObserver();
                }
                else{
                    enemy.setHp(enemy.getHp()- this.damage);
                    if(isSlow){
                        Animation an = null;
                        enemy.setSpeed(enemy.getSpeed()-1);
                        if(enemy instanceof Enemy2){
                             an = new Animation(Helper.ENEMY2_SLOW, 53, 35, 50);
                        }else if(enemy instanceof Dragon){
                             an = new Animation(Helper.DRAGON_SLOW, 106, 89, 50);
                        }else if(enemy instanceof Enemy3){
                            an = new Animation(Helper.ENEMY3_SLOW, 88, 58, 50);
                        }
                        enemy.setAnim(an);
                    }
                    else if(enemy.getHp() <= 0){
                        //enemy.setSpeed(Helper.ENEMY1_SPEED);
                        sound.get("bang").play();
                        EnemyManager.getInstance().getVectorEnemy().remove(enemy);
                        Coin coin = new Coin(enemy.getPositionX(),enemy.getPositionY());
                        GiftManager.getInstance().getVectorGift().add(coin);
                        PlayerManager.getInstance().getPlayerFly().setScore( PlayerManager.getInstance().getPlayerFly().getScore()+10);
                        Helper.SCORE = PlayerManager.getInstance().getPlayerFly().getScore();

                    }
                }


                isCollision = true;
                break;
            }
        }
        return isCollision;
    }

}

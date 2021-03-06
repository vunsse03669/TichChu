package Entities.Enemy;

import Entities.Animation;
import Entities.GameObject;
import Entities.Observer.Observer;
import Entities.Player.Player;
import Entities.Player.PlayerManager;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public abstract class EnemyAbstract extends GameObject implements Observer{
    protected Animation anim;
    protected int speed;
    protected int imageWidth;
    protected int imageHeight;
    protected int hp;
    public EnemyAbstract(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        speed = Helper.ENEMY_SPEED;

    }
    @Override
    public void update() {
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        //g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }

    public abstract void move();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean collisionPlayer(){

        Rectangle rectPlayer = new Rectangle((int) PlayerManager.getInstance().getPlayerFly().getPositionX(),
                (int)PlayerManager.getInstance().getPlayerFly().getPositionY(),
                (int)PlayerManager.getInstance().getPlayerFly().getWidth(),
                (int)PlayerManager.getInstance().getPlayerFly().getHeight());

        Rectangle rectEnemy = new Rectangle((int)this.positionX,(int)this.positionY,(int)imageWidth,(int)imageHeight);

        return rectEnemy.intersects(rectPlayer);
    }

    @Override
        public void update(String msg){
        if(msg.equals("1")){
                    for(EnemyAbstract en : EnemyManager.getInstance().getVectorEnemy() ){
                        if(en.getPositionX() >= 0 && en.getPositionX() <= Helper.WIDTH){
                            EnemyManager.getInstance().getVectorEnemy().remove(en);
                            break;
                        }
                    }
        }
    }

    public Animation getAnim() {
        return anim;
    }

    public void setAnim(Animation anim) {
        this.anim = anim;
    }
}
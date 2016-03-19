package Entities.Player;

import Entities.Animation;
import Entities.Enemy.EnemyAbstract;
import Entities.Enemy.EnemyManager;
import Entities.GameObject;
import Entities.Gift.*;
import Entities.Observer.Observer;
import Entities.Observer.Subject;
import Entities.Sound.AudioPlayer;
import Entities.Weapon.*;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public abstract class PlayerAbstract extends GameObject implements Subject{
    protected HashMap<String,AudioPlayer> sound;
    protected int speed;
    protected int hp;
    protected BufferedImage heart;
    protected Vector<BulletAbstract> vectorBullet;
    protected Vector<Rocket2> vectorRocket;
    protected int score;
    protected int levelBullet;
    protected int coin;
    protected int rocket;
    protected boolean isWater;
    Vector<Observer> vectorObserver = new Vector<>();


    public PlayerAbstract(double positionX, double positionY){
        isWater = false;
        coin = 0;
        rocket = 5;
        this.score = 0;
        this.positionX = positionX;
        this.positionY = positionY;
        hp = Helper.PLAYER_HP;
        speed = Helper.PLAYER_SPEED;
        sound = new HashMap<>();
        sound.put("anqua",new AudioPlayer(Helper.GIFT_SOUND));
        sound.put("bang",new AudioPlayer(Helper.BANG));
        vectorBullet = BulletManager.getInstance().getVectorBulelt();
        vectorRocket = RocketManager.getInstance().getVectorRocket();
        try{
            this.sprite = ImageIO.read(new File("Resources/Image/TT1.png"));
            this.heart = ImageIO.read(new File(Helper.ROCKET1));
        }catch(Exception e){}
    }
    @Override
    public void update() {
        //fireRocket();
        if(coin >= 20){
            rocket++;
            coin = 0;
        }
        this.move();

        for(Rocket2 rocket2 : vectorRocket){
            rocket2.update();
            if(rocket2.getPositionX() == 500){
                vectorRocket.remove(rocket2);
                System.out.println("xxx");
                BulletManager.getInstance().getVectorBulelt().add(new BulletRocket1(Helper.WIDTH/2,Helper.HEIGHT/2));
                BulletManager.getInstance().getVectorBulelt().add(new BulletRocket2(Helper.WIDTH/2,Helper.HEIGHT/2));
                BulletManager.getInstance().getVectorBulelt().add(new BulletRocket3(Helper.WIDTH/2,Helper.HEIGHT/2));
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv1(Helper.WIDTH/2,Helper.HEIGHT/2));
                return;
            }
        }
        for(BulletAbstract bullet : BulletManager.getInstance().getVectorBulelt()){
            bullet.update();
            if(bullet.collisionEnemy()){
                BulletManager.getInstance().getVectorBulelt().remove(bullet);
                return;
            }
        }
        for(GiftAbstract gift : GiftManager.getInstance().getVectorGift()){
            if(gift.collision()){
                if(gift instanceof Heart){
                    this.hp++;
                    GiftManager.getInstance().getVectorGift().remove(gift);
                }else if(gift instanceof DauAn){
                    Helper.PLAYER_SPEED +=2;
                    for(EnemyAbstract enemy : EnemyManager.getInstance().getVectorEnemy()){
                        enemy.setSpeed(Helper.PLAYER_SPEED);
                    }
                }else if(gift instanceof Water){
                    isWater = true;
                }
                else if( gift instanceof Ice){
                    GiftManager.getInstance().getVectorGift().remove(gift);
                    BulletAbstract.isSlow = true;

                }else if( gift instanceof Coin){
                    int coint = 0;
                    if(this instanceof PlayerFly){
                        coint=PlayerManager.getInstance().getPlayerFly().getCoin();
                        PlayerManager.getInstance().getPlayerFly().setCoin(coint+1);
                    }else if(this instanceof PlayerMouse){
                        coint=PlayerManager.getInstance().getPlayerMouse().getCoin();
                        PlayerManager.getInstance().getPlayerMouse().setCoin(coint+1);
                    }

                }
                else if( gift instanceof GiftBullet){
                    int lv = 0;
                    if(this instanceof PlayerFly){
                        lv =  PlayerManager.getInstance().getPlayerFly().getLevelBullet();
                        PlayerManager.getInstance().getPlayerFly().setLevelBullet(lv+1);
                    }else if(this instanceof PlayerMouse){
                        lv =  PlayerManager.getInstance().getPlayerMouse().getLevelBullet();
                        PlayerManager.getInstance().getPlayerMouse().setLevelBullet(lv+1);
                    }

                }
                sound.get("anqua").play();
                GiftManager.getInstance().getVectorGift().remove(gift);
                return;
            }
        }
        for(EnemyAbstract enemy : EnemyManager.getInstance().getVectorEnemy()){
            if(enemy.collisionPlayer()){
                this.hp--;
                sound.get("bang").play();
                EnemyManager.getInstance().getVectorEnemy().remove(enemy);
                if(this.positionX >= 30){
                    this.positionX -= 30;
                }
                return;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);

    }

    public abstract void move();
    public abstract void keyPressed(int k);
    public abstract void keyRelased(int k);
    public abstract void keyTyped(int k);

    public void shot() {

        switch (levelBullet){
            case 1:
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv1(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                break;
            case 2:
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv2(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                break;
            case 3:
                //BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv3(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv5(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv1(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv4(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));

                break;
            default:
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv1(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                break;
        }
    }
    public abstract void mouseClicked(int k);
    public abstract void mouseReleased(int k);

    public abstract void fireRocket();


    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevelBullet() {
        return levelBullet;
    }

    public void setLevelBullet(int levelBullet) {
        this.levelBullet = levelBullet;
    }

    public int getCoin() {
        return coin;
    }

    public int getRocket() {
        return rocket;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setRocket(int rocket) {
        this.rocket = rocket;
    }

    public abstract void shotWater();


    @Override
    public void addObserver(Observer ob) {
        vectorObserver.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        vectorObserver.remove(ob);
    }

    @Override
    public void notifiObserver() {
        for(Observer ob : vectorObserver){
            ob.update("1");
        }
    }
}

package Entities.Player;

import Entities.Animation;
import Entities.Enemy.EnemyAbstract;
import Entities.Enemy.EnemyManager;
import Entities.GameObject;
import Entities.Gift.GiftAbstract;
import Entities.Gift.GiftManager;
import Entities.Gift.Heart;
import Entities.Gift.Ice;
import Entities.Sound.AudioPlayer;
import Entities.Weapon.BulletAbstract;
import Entities.Weapon.BulletManager;
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
public abstract class PlayerAbstract extends GameObject {
    protected HashMap<String,AudioPlayer> sound;
    protected int speed;
    protected int hp;
    protected BufferedImage heart;
    protected Vector<BulletAbstract> vectorBullet;
    protected int score;
    protected int levelBullet;


    public PlayerAbstract(double positionX, double positionY){
        this.score = 0;
        this.positionX = positionX;
        this.positionY = positionY;
        hp = Helper.PLAYER_HP;
        speed = Helper.PLAYER_SPEED;
        sound = new HashMap<>();
        sound.put("anqua",new AudioPlayer(Helper.GIFT_SOUND));
        sound.put("bang",new AudioPlayer(Helper.BANG));
        vectorBullet = BulletManager.getInstance().getVectorBulelt();
        try{
            this.sprite = ImageIO.read(new File("Resources/Image/TT1.png"));
            this.heart = ImageIO.read(new File(Helper.HEART));
        }catch(Exception e){}
    }
    @Override
    public void update() {
        System.out.println(BulletAbstract.isSlow);
        this.move();
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
                }
                else if( gift instanceof Ice){
                    GiftManager.getInstance().getVectorGift().remove(gift);
                    BulletAbstract.isSlow = true;
                }
                else{
                    this.levelBullet++;
                    sound.get("anqua").play();
                    GiftManager.getInstance().getVectorGift().remove(gift);
                }
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
    public abstract void shot();

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
}

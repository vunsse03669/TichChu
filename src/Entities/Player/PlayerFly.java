package Entities.Player;


import Entities.Animation;
import Entities.Sound.AudioPlayer;
import Entities.Weapon.*;
import GameHelper.Helper;
import GameState.Help;
import Main.GameManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Mr Hung on 3/15/2016.
 */
public class PlayerFly extends PlayerAbstract {
    private HashMap<String,AudioPlayer> sound;
    private boolean isFly;
    private int count = 0;
    private int speedY;
    private int speedX;
    Animation animation;
    public PlayerFly(double positionX, double positionY) {
        super(positionX, positionY);
        speedX = 0;
        speedY = 6;
        levelBullet = 1;
        animation = new Animation(Helper.PLAYER_FLY,216,200,100);
        sound = new HashMap<String,AudioPlayer>();
        sound.put("jump",new AudioPlayer(Helper.JUMP_SOUND));
        sound.put("shot",new AudioPlayer(Helper.PLAYER_SHOT));
    }

    @Override
    public void move(){

        positionX+=speedX;

        if(isFly){
            positionY -= speedY;
        }else{
            positionY += this.speedY-2;
        }
    }

    @Override
    public void keyPressed(int k) {
        count++;
        if(count <= 5){
            if(k == KeyEvent.VK_SPACE){
                isFly = true;
                sound.get("jump").play();
            }
        }
        else{
            isFly = false;
        }

        if(k == KeyEvent.VK_Q){
            if(count <= 5){
                this.shot();
                sound.get("shot").play();
            }
        }
    }

    public void draw(Graphics g){
        animation.draw(g,(int)positionX ,(int)positionY );
        for(int i = 0; i < this.hp; i++){
            g.drawImage(this.heart,20 + i*32,50,null);
        }
        for(BulletAbstract bullet : BulletManager.getInstance().getVectorBulelt()){
            bullet.draw(g);
        }
        g.setFont(new Font("Arial Black",Font.PLAIN,20));
        g.drawString("Score: "+this.score, Helper.WIDTH - 200, 100);
    }

    @Override
    public void keyRelased(int k) {
        isFly = false;
        count = 0;
    }

    @Override
    public void keyTyped(int k) {}

    @Override
    public void shot() {
        switch (levelBullet){
            case 1:
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv1(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                break;
            case 2:
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv2(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                break;
            case 3:
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv3(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                break;
            default:
                BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv1(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
                break;
        }
    }
}

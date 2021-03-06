package Entities.Player;

import Entities.Animation;
import Entities.Sound.AudioPlayer;
import Entities.Weapon.BulletAbstract;
import Entities.Weapon.BulletManager;
import GameHelper.Helper;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class PlayerMouse extends PlayerAbstract {
    private HashMap<String,AudioPlayer> sound;
    private boolean isFly;
    private int count = 0;
    private int speedY;
    private int speedX;
    Animation animation;

    public PlayerMouse(int positionX, int positionY) {
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
    public void move() {
        positionX+=speedX;

        if(isFly){
            positionY -= speedY;
        }else{
            positionY += this.speedY-2;
        }
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyRelased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }

    @Override
    public void mouseClicked(int k) {
        if(k == InputEvent.BUTTON1_MASK){
            isFly = true;
            sound.get("jump").play();
        }
        if(k == InputEvent.BUTTON3_MASK){
            this.shot();
            sound.get("shot").play();
        }
    }

    @Override
    public void mouseReleased(int k) {
        isFly = false;
    }

    @Override
    public void fireRocket() {

    }

    @Override
    public void shotWater() {

    }

    public void draw(Graphics g){
        animation.draw(g,(int)positionX ,(int)positionY );
        for(int i = 0; i < this.rocket; i++){
            g.drawImage(this.heart,40 + i*32,100,null);
        }
        for(BulletAbstract bullet : BulletManager.getInstance().getVectorBulelt()){
            bullet.draw(g);
        }
        g.setFont(new Font("Arial Black",Font.PLAIN,20));
        g.drawString("Score2: "+this.score, Helper.WIDTH - 200,200);
        g.drawString("Coin2: "+this.coin, Helper.WIDTH - 200, 230);
        g.setColor(Color.green);
        g.fillRect((int)this.positionX-5,(int)this.positionY-20,hp*50,5);
        g.drawRect((int)this.positionX-5,(int)this.positionY-20,hp*50,5);
    }
}

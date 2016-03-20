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
    public PlayerFly(int positionX, int positionY) {
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
        //ban ten lua
        if(k == KeyEvent.VK_W){
            if(count <= 5){
                if(this.rocket > 0){
                    this.fireRocket();
                    this.rocket--;
                    sound.get("shot").play();
                }
            }
        }
        if(k == KeyEvent.VK_E){
            if(count <= 5){
                if(this.isWater){
                    this.shotWater();
                }
            }
        }

    }

    public void draw(Graphics g){
        animation.draw(g,(int)positionX ,(int)positionY );
        for(int i = 0; i < this.rocket; i++){
            g.drawImage(this.heart,20 + i*32,50,null);
        }
        for(BulletAbstract bullet : BulletManager.getInstance().getVectorBulelt()){
            bullet.draw(g);
        }
        g.setFont(new Font("Arial Black",Font.PLAIN,20));
        g.drawString("Score1: "+this.score, Helper.WIDTH - 200, 100);
        g.drawString("Coin1: "+this.coin, Helper.WIDTH - 200, 130);
        g.setColor(Color.green);
        g.fillRect((int)this.positionX-5,(int)this.positionY-20,hp*50,5);
        g.drawRect((int)this.positionX-5,(int)this.positionY-20,hp*50,5);
        for(Rocket2 rocket2 : vectorRocket){
            rocket2.draw(g);
        }
    }

    @Override
    public void keyRelased(int k) {
        isFly = false;
        count = 0;
    }

    @Override
    public void keyTyped(int k) {}



    @Override
    public void mouseClicked(int k) {

    }

    @Override
    public void mouseReleased(int k) {

    }

    @Override
    public void fireRocket() {
        //vectorBullet.add(new Rocket(this.positionX+100,this.positionY+100));
        vectorRocket.add(new Rocket2(this.positionX+100,this.positionY+100));
    }

    @Override
    public void shotWater() {
        vectorBullet.add(new BulletWater(this.positionX+100,this.positionY+100));
    }
}

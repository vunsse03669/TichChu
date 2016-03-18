package Entities.Enemy;

import Entities.Animation;
import Entities.Player.PlayerManager;
import GameHelper.Helper;
import Main.GameManager;

import java.awt.*;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class Dragon extends EnemyAbstract {
    private int angle = 0;
    Animation animation;

    public Dragon(double positionX, double positionY) {
        super(positionX, positionY);
        animation = new Animation(Helper.DRAGON,106,89,100);
        imageWidth = 106;
        imageHeight = 89;
        hp = 5;
        this.speed = Helper.ENEMY1_SPEED;
    }

    @Override
    public void move() {
        angle++;
        this.positionX += (double) (5 * Math.sin(angle * 0.09));
        this.positionY += (double) (5 * Math.cos(angle * 0.09));
        positionX-= this.speed;
    }
    public void draw(Graphics g){
        animation.draw(g,(int)positionX , (int)positionY );
    }

}

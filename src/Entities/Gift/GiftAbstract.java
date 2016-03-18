package Entities.Gift;

import Entities.GameObject;
import Entities.Player.PlayerManager;
import GameHelper.Helper;
import org.w3c.dom.css.Rect;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class GiftAbstract extends GameObject {

    public GiftAbstract(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;

    }

    @Override
    public void update() {
        this.move();
    }

    public void move(){
        this.positionX -= Helper.GIFT_SPEED;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }

    public boolean collision(){
        Rectangle rectGift = new Rectangle((int)this.positionX,(int)this.positionY,(int)this.getWidth(),(int)this.getHeight());
        Rectangle rectPlayer = new Rectangle((int) PlayerManager.getInstance().getPlayerFly().getPositionX(),
                (int)PlayerManager.getInstance().getPlayerFly().getPositionY(),
                (int)PlayerManager.getInstance().getPlayerFly().getWidth(),
                (int)PlayerManager.getInstance().getPlayerFly().getHeight());
        Rectangle rectPlayer2 = new Rectangle((int) PlayerManager.getInstance().getPlayerMouse().getPositionX(),
                (int)PlayerManager.getInstance().getPlayerMouse().getPositionY(),
                (int)PlayerManager.getInstance().getPlayerMouse().getWidth(),
                (int)PlayerManager.getInstance().getPlayerMouse().getHeight());
        return rectGift.intersects(rectPlayer) || rectGift.intersects(rectPlayer2);
    }
}

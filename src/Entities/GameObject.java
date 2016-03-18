package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public abstract class GameObject {
    protected double positionX;
    protected double positionY;
    protected BufferedImage sprite;

    public abstract void update();

    public abstract void draw(Graphics g);

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public double getWidth(){
        return this.sprite.getWidth();
    }

    public double getHeight(){
        return this.sprite.getHeight();
    }
}

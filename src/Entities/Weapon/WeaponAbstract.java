package Entities.Weapon;

import Entities.GameObject;

import java.awt.*;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public abstract class WeaponAbstract extends GameObject {
    protected int damage;

    public WeaponAbstract(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }
    @Override
    public void update() {

    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

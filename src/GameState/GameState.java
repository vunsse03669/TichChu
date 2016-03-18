package GameState;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public abstract class GameState {
    protected GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
        this.init();
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
    public abstract void keyTyped(int k);
    public abstract void mouseClicked(int k);
    public abstract void mouseReleased(int k) ;


}

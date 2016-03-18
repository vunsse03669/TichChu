package GameState;

import java.awt.*;
import java.util.Stack;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class GameStateManager {
    public Stack<GameState> states;

    public GameStateManager(){
        states = new Stack<GameState>();
        states.push(new MenuState(this));
    }

    public void draw(Graphics g){
        states.peek().draw(g);
    }

    public void update(){
        states.peek().update();
    }

    public void keyPressed(int k){
        states.peek().keyPressed(k);
    }

    public void keyRelased(int k){
        states.peek().keyReleased(k);
    }

    public void keyTyped(int k){
        states.peek().keyTyped(k);
    }
}

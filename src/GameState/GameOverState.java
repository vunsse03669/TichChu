package GameState;

import Entities.Player.PlayerManager;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class GameOverState extends GameState {

    private String [] options = {"CONTINUED","EXIT"};
    private int currentSelection = 0;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        int score = PlayerManager.getInstance().getPlayer().getScore();
        int width = g.getFontMetrics().stringWidth("Game Over");
        g.setFont(new Font("Arial Black",Font.BOLD,50));
        g.drawString("Game Over", Helper.WIDTH/2-width/2, Helper.HEIGHT/2 - 100 );
        g.setFont(new Font("Arial Black",Font.PLAIN,30));
        g.drawString("" + Helper.SCORE, Helper.WIDTH/2-100, Helper.HEIGHT/2  );

        for(int i = 0; i < options.length;i++){
            if(i == currentSelection){
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.green.BLACK);
            }
            int swidth = g.getFontMetrics().stringWidth(options[i]);
            g.setFont(new Font("Arial Black",Font.PLAIN,50));
            g.drawString(options[i], Helper.WIDTH/2 -swidth/2, Helper.HEIGHT/2 + 100 + i*100);

        }
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }
}

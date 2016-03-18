package GameState;

import Entities.Player.PlayerManager;
import Entities.Sound.AudioPlayer;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class GameOverState extends GameState {
    //private HashMap<String,AudioPlayer> sound;
    private String [] options = {"CONTINUE","EXIT"};
    private BufferedImage sprite;
    private int currentSelection = 0;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
       // sound.put("select",new AudioPlayer(Helper.SELECT_SOUND));
        try{
            sprite = ImageIO.read(new File(Helper.GAMEOVER));
        }catch(Exception e){}
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,0,0,null);
        int score = PlayerManager.getInstance().getPlayer().getScore();
        int width = g.getFontMetrics().stringWidth("Game Over");
        g.setFont(new Font("Arial Black",Font.BOLD,50));
        g.drawString("Game Over", Helper.WIDTH/2-width/2, Helper.HEIGHT/2 - 200 );
        g.setFont(new Font("Arial Black",Font.PLAIN,30));
        g.drawString("Score: " + Helper.SCORE, Helper.WIDTH/2-140, Helper.HEIGHT/2 - 100  );


        for(int i = 0; i < options.length;i++){
            if(i == currentSelection){
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.green.BLACK);
            }
            int swidth = g.getFontMetrics().stringWidth(options[i]);
            g.setFont(new Font("Arial Black",Font.PLAIN,50));
            g.drawString(options[i], Helper.WIDTH/2 -140, Helper.HEIGHT/2 + 100 + i*100);

        }
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN){
            //sound.get("select").play();
            currentSelection++;
            System.out.println(currentSelection);
            if(currentSelection > options.length-1){
                currentSelection = 0;
            }
        }else if(k == KeyEvent.VK_UP){
            currentSelection--;
           // sound.get("select").play();
            if(currentSelection < 0){
                currentSelection = options.length-1;
            }
        }
        if(k == KeyEvent.VK_ENTER){

            if(currentSelection == 0){
                gsm.states.pop();
                PlayerManager.getInstance().getPlayerFly().setPositionY(200);
                PlayerManager.getInstance().getPlayerFly().setPositionX(100);
                PlayerManager.getInstance().getPlayerFly().setHp(Helper.PLAYER_HP);
                gsm.states.push(new Level2State(gsm));
            }else if(currentSelection == 1){
                System.exit(0);

            }
        }
    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }

    @Override
    public void mouseClicked(int k) {

    }

    @Override
    public void mouseReleased(int k) {

    }
}

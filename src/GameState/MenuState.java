package GameState;

import Entities.Sound.AudioPlayer;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class MenuState extends GameState {
    private HashMap<String,AudioPlayer> sound;
    private String [] options = {"START","HELP","ABOUT","EXIT"};
    private int currentSelection = 0;
    private BufferedImage sprite;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        sound = new HashMap<String,AudioPlayer>();
        sound.put("sound_background",new AudioPlayer(Helper.MENU_SOUND));
        sound.put("select",new AudioPlayer(Helper.SELECT_SOUND));
        sound.get("sound_background").play();
        try {
            sprite = ImageIO.read(new File(Helper.MENU_STATE));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        for(int i = 0; i < options.length;i++){
            if(i == currentSelection){
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.green.WHITE);
            }
            int width = g.getFontMetrics().stringWidth(options[i]);
            g.setFont(new Font("Arial Black",Font.PLAIN,50));
            g.drawString(options[i], Helper.WIDTH/2 -width/2, Helper.HEIGHT/2 - 100 + i*100);
        }
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN){
            currentSelection++;
            sound.get("select").play();
            if(currentSelection > options.length-1){
                currentSelection = 0;
            }
        }else if(k == KeyEvent.VK_UP){
            currentSelection--;
            sound.get("select").play();
            if(currentSelection < 0){
                currentSelection = options.length-1;
            }
        }
        if(k == KeyEvent.VK_ENTER){
            if(currentSelection == 0){
                //gsm.states.pop();
                gsm.states.push(new Level2State(gsm));
                sound.get("sound_background").stop();
            }else if(currentSelection == 1){
                gsm.states.push(new Help(gsm));
            }else if(currentSelection == 2){
                gsm.states.push(new About(gsm));
            }else if(currentSelection == 3){
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

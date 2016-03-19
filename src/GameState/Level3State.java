package GameState;

import Entities.Enemy.*;
import Entities.Gift.GiftAbstract;
import Entities.Gift.GiftManager;
import Entities.Player.PlayerFly;
import Entities.Player.PlayerManager;
import Entities.Player.PlayerMouse;
import Entities.Sound.AudioPlayer;
import GameHelper.Helper;
import Main.GameManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/19/2016.
 */
public class Level3State extends GameState {
    private HashMap<String,AudioPlayer> sound;
    private BufferedImage background;
    private PlayerFly player;
    private PlayerMouse playerMouse;

    private BossLevel1 boss;
    private static int count = 0;
    public Level3State(GameStateManager gsm) {
        super(gsm);
        player = PlayerManager.getInstance().getPlayerFly();
        playerMouse = PlayerManager.getInstance().getPlayerMouse();
        try{
            this.background = ImageIO.read(new File(Helper.BACKGROUND_LV2));

        }catch(Exception e){}
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        player.update();
        playerMouse.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.background, GameManager.getInstance().getLocationX(),GameManager.getInstance().getLocationY(),null);
        player.draw(g);
        playerMouse.draw(g);
    }

    @Override
    public void keyPressed(int k) {
        player.keyPressed(k);
    }

    @Override
    public void keyReleased(int k) {
        player.keyRelased(k);
    }

    @Override
    public void keyTyped(int k) {
        player.keyTyped(k);
    }

    @Override
    public void mouseClicked(int k) {
        playerMouse.mouseClicked(k);
    }

    @Override
    public void mouseReleased(int k) {
        playerMouse.mouseReleased(k);
    }
}

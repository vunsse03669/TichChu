package GameState;

import Entities.Enemy.*;
import Entities.Gift.GiftAbstract;
import Entities.Gift.GiftManager;
import Entities.Player.PlayerFly;
import Entities.Player.PlayerManager;
import Entities.Player.PlayerMouse;
import Entities.Sound.AudioPlayer;
import Entities.Weapon.BulletAbstract;
import Entities.Weapon.BulletManager;
import GameHelper.Helper;
import Main.GameManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/15/2016.
 */
public class Level2State extends GameState {

    private HashMap<String,AudioPlayer> sound;
    private BufferedImage background;
    private PlayerFly player;
    //private PlayerMouse playerMouse;
    Vector<EnemyAbstract> vectorEnemy;
    Vector<GiftAbstract> vectorGift;
    Vector<FireBall> vectorFireBall;
    private BossLevel1 boss;
    private static int count = 0;

    public Level2State(GameStateManager gsm) {
        super(gsm);
        player = PlayerManager.getInstance().getPlayerFly();
        vectorEnemy = EnemyManager.getInstance().getVectorEnemy();
        vectorGift = GiftManager.getInstance().getVectorGift();
        vectorFireBall = FireBallManager.getInstance().getVectorFire();
        sound = new HashMap<>();
        sound.put("boss_background",new AudioPlayer(Helper.BOSS1_SOUND));
        try{
            this.background = ImageIO.read(new File(Helper.BACKGROUND_LV1));

        }catch(Exception e){}
    }

    @Override
    public void init() {
       //playerMouse = PlayerManager.getInstance().getPlayerMouse();
//        player = PlayerManager.getInstance().getPlayerFly();
//        vectorEnemy = EnemyManager.getInstance().getVectorEnemy();
//        vectorGift = GiftManager.getInstance().getVectorGift();
//        sound = new HashMap<>();
//        sound.put("boss_background",new AudioPlayer(Helper.BOSS1_SOUND));
//        for(EnemyAbstract enemy : EnemyManager.getInstance().getVectorEnemy()){
//            PlayerManager.getInstance().getPlayerFly().addObserver(enemy);
  //      }
    }

    @Override
    public void update() {
        if(Helper.isPass){
            System.out.println(Helper.isPass);
            //gsm.states.pop();
            gsm.states.push(new Level3State(gsm));
        }

        for(FireBall fire : vectorFireBall){
            fire.update();
        }
        player.update();
       // playerMouse.update();
        // dung man hinh va tao boss
        int loX = GameManager.getInstance().getLocationX();
        if(GameManager.getInstance().getLocationX() >= -background.getWidth()+Helper.WIDTH){
            GameManager.getInstance().setLocationX(loX - Helper.PLAYER_SPEED);
        }else{
            if(boss == null) {
                boss = new BossLevel1(Helper.WIDTH - 200, 450);
                EnemyManager.getInstance().getVectorEnemy().add(boss);
                sound.get("boss_background").play();
            }
        }
        //check va cham tren
        if(player.getPositionY() <= 0){
            player.setPositionY(player.getPositionY() + 10);
        }
        // gamve over
        if(player.getPositionY() + player.getSprite().getHeight() >= Helper.HEIGHT || player.getHp() <= 0){
            gsm.states.pop();
            gsm.states.push(new GameOverState(gsm));

        }
        for(EnemyAbstract enemy : vectorEnemy){
            enemy.update();
            if(enemy.getPositionX() <= 0){
                vectorEnemy.remove(enemy);
                return;
            }
        }
        for(BulletAbstract bullet : BulletManager.getInstance().getVectorBulelt()){
            if(bullet.getPositionX() >= 1700){
                BulletManager.getInstance().getVectorBulelt().remove(bullet);
                return;
            }
        }
        for(GiftAbstract gift : GiftManager.getInstance().getVectorGift()){
            gift.update();
        }
        if(BulletAbstract.isSlow){
            count++;
            if(count >= 600){
                BulletAbstract.isSlow = false;
                count = 0;
            }
        }
//        if(boss != null){
//            boss.update();
//        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.background, GameManager.getInstance().getLocationX(),GameManager.getInstance().getLocationY(),null);
        player.draw(g);
       // playerMouse.draw(g);
        for(EnemyAbstract enemy : vectorEnemy){
            enemy.draw(g);
        }
        for(GiftAbstract gift : GiftManager.getInstance().getVectorGift()){
            gift.draw(g);
        }
        for(FireBall fire : vectorFireBall){
            fire.draw(g);
        }
        if(boss != null){
            boss.draw(g);
        }
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
       //playerMouse.mouseClicked(k);
    }

    @Override
    public void mouseReleased(int k) {
       // playerMouse.mouseReleased(k);
    }
}

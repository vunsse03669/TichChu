//package GameState;
//
//import GameHelper.Helper;
//
//import TileMap.TileMap;
//
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//
///**
// * Created by Mr Hung on 3/14/2016.
// */
//public class Level1State extends GameState {
//    private TileMap tileMap;
//    public Level1State(GameStateManager gsm) {
//        super(gsm);
//       // this.init();
//    }
//
//    @Override
//    public void init() {
//
//        tileMap = new TileMap(30);
//        tileMap.loadTiles("Resources/TilesMap/ruinstileset.gif");
//
//        tileMap.loadMap("Resources/Map/level1a.map");
//
//        tileMap.setPosition(400, 100);
//        tileMap.setBounds(
//                tileMap.getWidth() - 1 * tileMap.getTileSize(),
//                tileMap.getHeight() - 2 * tileMap.getTileSize(),
//                0, 0
//        );
//        tileMap.setTween(1);
//
//    }
//
//    @Override
//    public void update() {
//
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        tileMap.draw(g);
//
//    }
//
//    @Override
//    public void keyPressed(int k) {
//
//    }
//
//    @Override
//    public void keyReleased(int k) {
//
//    }
//
//    @Override
//    public void keyTyped(int k) {
//
//    }
//
//}

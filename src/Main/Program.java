package Main;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public class Program {
    public static void main(String[] args){
        GameWindow game = new GameWindow();
        Thread t = new Thread(game);
        t.start();
    }
}

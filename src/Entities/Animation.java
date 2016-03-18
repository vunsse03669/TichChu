package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/15/2016.
 */
public class Animation {
    BufferedImage bigImage;
    Vector<Image> vecFrame;
    int index;
    int delta;
    int countTime = 0;

    public Animation(String dirImage, int width, int height, int delta){
        vecFrame = new Vector<>();
        this.index = 0;
        this.delta = delta;
        try{
            bigImage = ImageIO.read(new File(dirImage));
            for(int i = 0; i < (int)bigImage.getHeight()/height; i++){
                for(int j = 0; j < (int)bigImage.getWidth()/width;j++){
                    Image img = bigImage.getSubimage(j*width,i*height,width,height);
                    vecFrame.add(img);
                }
            }
        }catch(Exception e){}
    }

    public void draw(Graphics g, int x, int y){
        g.drawImage(vecFrame.get(index),x,y,null);
        countTime += 17;
        if(countTime >= delta){
            countTime = 0;
            index++;
            if(index >= vecFrame.size()){
                index = 0;
            }
        }
    }
}

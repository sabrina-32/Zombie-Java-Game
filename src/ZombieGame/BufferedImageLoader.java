/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZombieGame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Sabrina
 */
public class BufferedImageLoader {
    
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String path) {
        try{
                    image = ImageIO.read(getClass().getResource(path));

        } catch(IOException  e){
            e.printStackTrace();
        }
        return  image;
        
    }
    
}

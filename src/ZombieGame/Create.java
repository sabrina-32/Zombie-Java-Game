/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sabrina
 */
public class Create extends GameObject{
    
    private BufferedImage create_image;
    public  Create(int x,  int y,  ID id, SpriteSheet ss){
        super(x,y,id,ss);
        create_image = ss.grabImage(6, 2, 32, 32);
    }

    @Override
    public void tick() {
         
    }

    @Override
    public void render(Graphics g) {
  g.drawImage(create_image, x, y, null);
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
}

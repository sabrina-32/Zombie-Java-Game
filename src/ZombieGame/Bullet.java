/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Sabrina
 */
public class Bullet extends GameObject {
    
    
    private Handler  handler;
    
    public Bullet(int x,  int y, ID id,Handler  handler){
        super(x,y,id);
        this.handler =handler;
    }

    @Override
    public void tick() {
        
        x +=velX;
        y +=velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 8, 8);
    }

    @Override
    public Rectangle getBounds() {
        return new  Rectangle(x,y,8,8);
    }
    
}

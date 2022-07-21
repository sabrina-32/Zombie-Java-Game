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
    
    public Bullet(int x,  int y, ID id,Handler  handler, int mx,  int  my){
        super(x,y,id);
        this.handler =handler;
        
        velX = (mx - x)/10;
                velY = (my - y)/10;

    }

    @Override
    public void tick() {
        
        x +=velX;
        y +=velY;
        
        for(int  i = 0; i<handler.object.size();  i++){
            GameObject  tempObject  =  handler.object.get(i);
            
            if(tempObject.getId() == ID.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(this);
                }
            }
        }
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

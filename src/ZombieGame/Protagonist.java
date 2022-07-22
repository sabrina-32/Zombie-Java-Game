package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sabrina
 */
public class Protagonist extends GameObject {
    
    Handler handler;
    Game game;
private BufferedImage hero_image;    
    public Protagonist(int x,  int y, ID id, Handler handler,Game game, SpriteSheet ss){
        super(x,y,id,ss);
        this.handler = handler;
        this.game =game;
        hero_image = ss.grabImage(1, 1, 32,45);
        
    }

    @Override
    public void tick() {
        x +=velX;
        y +=velY;
        
        
//      Movement  
        if(handler.isUp()) velY = -5;
        else if(!handler.isDown()) velY =0;
        
        if(handler.isDown()) velY = 5;
        else if(!handler.isUp()) velY =0;
        
        if(handler.isRight()) velX =5;
        else if(!handler.isLeft()) velX =0;
        
        if(handler.isLeft()) velX = -5;
        else if(!handler.isRight()) velX =0;
        
        
        
    }
    
    private  void collision(){
        for(int  i=0;  i<handler.object.size();  i++){
            GameObject tempObject =  handler.object.get(i);
            if(tempObject.getId()== ID.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    x += velX * -1;
                    y +=velY * -1;
                }
            }
            
             if(tempObject.getId()== ID.Create){
                if(getBounds().intersects(tempObject.getBounds())){
                   game.ammo +=10;
                   handler.removeObject(tempObject);
                }
            }
               if(tempObject.getId()== ID.Enemy){
                if(getBounds().intersects(tempObject.getBounds())){
                   game.hp--;
                 }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        
       g.drawImage(hero_image, x, y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 33, 48);
    }
    
}
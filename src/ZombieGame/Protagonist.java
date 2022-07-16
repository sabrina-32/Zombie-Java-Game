
package ZombieGame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Sabrina
 */
public class Protagonist extends GameObject {
    
    Handler handler;
    public Protagonist(int x,  int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x +=velX;
        y +=velY;
        
        
//      Movement  
        if(handler.isUp()) velY = -5;
        else if(!handler.isDown()) velY =0;
        
        if(handler.isDown()) velY =5;
        else if(!handler.isUp()) velY =0;
        
        if(handler.isRight()) velX =5;
        else if(!handler.isLeft()) velX =0;
        
        if(handler.isLeft()) velX =5;
        else if(!handler.isRight()) velX =0;
        
        
        
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}

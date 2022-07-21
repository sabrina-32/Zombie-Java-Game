
package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Sabrina
 */
public class Enemy extends GameObject{

    private  Handler  handler;
    public Enemy(int  x,  int  y, ID  id, Handler  handler){
        super(x,y,id);
        this.handler =handler;

    }
    @Override
    public void tick() {
        x += velX;
        y +=velY;
    }

    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.yellow);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}

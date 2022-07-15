
package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Box extends GameObject {
    
    public  Box(int x, int y){
        super(x,y);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
        
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}

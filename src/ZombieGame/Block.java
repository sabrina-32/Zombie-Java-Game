
package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Sabrina
 */
public class Block extends GameObject{
    
    public Block(int x,  int y,  ID id){
        super(x,y,id);
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

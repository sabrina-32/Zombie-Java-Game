
package ZombieGame;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Sabrina
 */
public class Block extends GameObject{
    
    public Block(int x,  int y,  ID id, SpriteSheet ss){
        super(x,y,id,ss);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y, 32,32) ;
    }
    
}


// Class: Create

package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
/**
 *
 * @author Sabrina
 */

public class Create extends GameObject {
    
    public static int CREATE_WIDTH = 32;
    public static int CREATE_HEIGHT = 32;
    
    private BufferedImage m_Create;
    
    
//    bonus bullet
    public Create(int iX, int iY, ID id, SpriteSheet spriteSheet) {
        
        super(iX, iY, id, spriteSheet);
        
        m_Create = spriteSheet.grabImage(2, 6, Create.CREATE_WIDTH, 
                                                          Create.CREATE_HEIGHT);
        
    }
    
    public void tick() {
 
    }

    public void render(Graphics g) {
        
       // g.setColor(Color.cyan);
       // g.fillRect(m_iX, m_iY, Create.CRATE_WIDTH, Create.CRATE_HEIGHT);
        
       g.drawImage(m_Create, m_iX, m_iY, null);
        
    }

    public Rectangle getBounds() {
        
       return new Rectangle(m_iX, m_iY, Create.CREATE_WIDTH, Create.CREATE_HEIGHT);
       
    }
    
}

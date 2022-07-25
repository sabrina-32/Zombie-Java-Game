
// Class: SpriteSheet

package ZombieGame;

import java.awt.image.BufferedImage;

/**
 *
 * @author Sabrina
 */
public class SpriteSheet {
    
   private BufferedImage m_BuffImage;
   
   public SpriteSheet(BufferedImage BuffImage) {
   
      this.m_BuffImage = BuffImage; 
       
   }
   
   public BufferedImage grabImage(int iRow, int iCol, 
                                            int iWidth, int iHeight) {
       
      BufferedImage buffImage = m_BuffImage.getSubimage((iCol - 1) * 32, 
              (iRow - 1) * 32, iWidth, iHeight);
      
      return buffImage;
      
   }     
    
}

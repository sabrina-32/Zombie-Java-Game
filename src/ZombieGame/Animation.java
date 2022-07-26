
// Class: Animation

package ZombieGame;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sabrina
 */
public class Animation {

  
            this.m_Image[iCount] = pImage[iCount];
         }
         
      }
      
      // Wrong input data or wrong size on pImage.
      else {
          
         m_Image = null;
         m_iFrames = 0;
         
      }
       
   }   
   
   public void runAnimation() {
   
      ++m_iIndex;
      
      if (m_iIndex > m_iSpeed) {
          
         m_iIndex = 0;
         nextFrame();
         
      }
       
   }
   
   public void nextFrame() {
   
      m_CurrentImage = m_Image[m_iCount];
      
      ++m_iCount;
      
      if (m_iCount > m_iFrames - 1) {
         m_iCount = 0;
      }
   
   }
   
   public void drawAnimation(Graphics g, double iX, double iY, int iOffset) {
       
      g.drawImage(m_CurrentImage, (int) iX - iOffset, (int) iY, null);
      
   }
   
   public int getCount() {
      return m_iCount;
   }
   
   public void setCount(int iCount) {
      this.m_iCount = iCount;
   }
   
   public int getSpeed() {
      return m_iSpeed;
   }
   
   public void setSpeed(int iSpeed) {
      this.m_iSpeed = iSpeed;
   }   
   
}

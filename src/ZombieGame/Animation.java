
// Class: Animation

package ZombieGame;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sabrina
 */
public class Animation {

   private int m_iSpeed;
   private int m_iFrames;
   private int m_iIndex = 0;
   private int m_iCount = 0;
   
   private BufferedImage[] m_Image;    
    
   private BufferedImage m_CurrentImage;  
   
   public Animation(int iSpeed, BufferedImage[] pImage, int iFrames) {
      
      int iCount;  
      
      if (pImage.length >= iFrames) {
          
         this.m_Image = new BufferedImage[iFrames];
         
         this.m_iFrames = iFrames;
         
         for (iCount = 0; iCount < iFrames; ++iCount)
         {
            this.m_Image[iCount] = pImage[iCount];
         }
         
      }
      
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

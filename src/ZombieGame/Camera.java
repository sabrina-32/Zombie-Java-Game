
// Class: Camera

package ZombieGame;

/**
 *
 * @author Sabrina
 */
public class Camera {
    
  
         m_fY = 0;
      }
      
      if (m_fY >= 240 + 563 + 48) {
         m_fY = 240 + 563 + 48;
      }         
       
   }
   
   public float getX() {
      return m_fX;
   }
   
   public void setX(float fX) {
      this.m_fX = fX;
   }
   
   public float getY() {
      return m_fY;
   } 
   
   public void setY(float fY) {
      this.m_fY = fY;
   }
   
}

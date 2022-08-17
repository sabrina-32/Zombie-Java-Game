
// Class: MouseInput

package ZombieGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Sabrina
 */
public class MouseInput extends MouseAdapter {

   private Handler m_Handler;
   private Camera m_Camera;
   private ZombieKillingGame m_zombieKillingGame;
   private SpriteSheet m_SpriteSheet;
   
   
   public MouseInput(Handler newHandler, Camera newCamera, 
                               ZombieKillingGame zombieKillingGame, SpriteSheet spriteSheet) {
   
      this.m_Handler = newHandler;    
      this.m_Camera = newCamera;
      this.m_zombieKillingGame = zombieKillingGame;
      this.m_SpriteSheet = spriteSheet;
      
   }
   
   public void mousePressed(MouseEvent e) {
       
      int iMouseX = (int) (e.getX() + m_Camera.getX());    
      int iMouseY = (int) (e.getY() + m_Camera.getY());
      
      int iCount;
      
      
      for (iCount = 0; iCount < m_Handler.gameObjects.size(); ++iCount) {
       
         GameObject tempGameObject = m_Handler.gameObjects.get(iCount);
          
         if (tempGameObject.getID() == ID.Player 
                                              && m_zombieKillingGame.m_iAmmo >= 1) {
             
            m_Handler.addGameObject(new Bullet(tempGameObject.getX() + 16, 
                        tempGameObject.getY() + 24, ID.Bullet, m_Handler, 
                         iMouseX, iMouseY, m_SpriteSheet));
            
            --m_zombieKillingGame.m_iAmmo;
             
         }
                     
      }      

   }
 
    
    
    
}

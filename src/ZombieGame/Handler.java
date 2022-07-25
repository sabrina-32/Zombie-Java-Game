
// Class: Handler

package ZombieGame;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Sabrina
 */
public class Handler {

   LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
   
  
   
   public void tick() {
   
      int iCount;
      
      for (iCount = 0; iCount < gameObjects.size(); ++iCount) {
      
         GameObject tempGameObject = gameObjects.get(iCount);
         
         tempGameObject.tick();
          
      }
              
   }
   
   public void render(Graphics g) {
   
      int iCount;
      
      for (iCount = 0; iCount < gameObjects.size(); ++iCount) {
      
         GameObject tempGameObject = gameObjects.get(iCount);
         
         tempGameObject.render(g);
          
      }
      
   }
   
   public void addGameObject(GameObject tempGameObject) {
      gameObjects.add(tempGameObject);
   }
   
   public void removeGameObject(GameObject tempGameObject) {
      gameObjects.remove(tempGameObject);
   }   
   
   public boolean isUp() {
      return m_bUp;
   }
   
   public void setUp(boolean bUp) {
      this.m_bUp = bUp;    
   } 
   
   public boolean isDown() {
      return m_bDown;
   }
   
   public void setDown(boolean bDown) {
      this.m_bDown = bDown;    
   }    
   
   public boolean isRight() {
      return m_bRight;
   }
   
   public void setRight(boolean bRight) {
      this.m_bRight = bRight;    
   }    

   public boolean isLeft() {
      return m_bLeft;
   }
   
   public void setLeft(boolean bLeft) {
      this.m_bLeft = bLeft;    
   }    
   
}

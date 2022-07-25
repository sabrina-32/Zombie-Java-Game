
// Class: Hero

package ZombieGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sabrina
 */
public class Hero extends GameObject {
    
   
    

    public Hero(int iX, int iY, ID id, Handler newHandler, 
                              ZombieKillingGame  zombieKillingGame, SpriteSheet spriteSheet) {
      
        super(iX, iY, id, spriteSheet);
        
        int iCount;         
        
        this.m_Handler = newHandler;
        this.m_zombieKillingGame = zombieKillingGame;
        
        m_buffImg = new BufferedImage[3];
        
        for (iCount = 0; iCount < 3; ++iCount) {
            
           m_buffImg[iCount] = m_SpriteSheet.grabImage(1, 1 + iCount, 
                                         Hero.HERO_WIDTH, Hero.HERO_HEIGHT);
           
        }
        
        m_Animation = new Animation(1, m_buffImg, 3);
        
    }    
    
    public void tick() {

       m_iX += m_fVelX; 
       m_iY += m_fVelY;       
       
       collision();
       
       // Movement "up or down" or "right or left".
       if (m_Handler.isUp()) {
          m_fVelY = -5;
       }
       else if (!m_Handler.isDown()) {
          m_fVelY = 0;
       }
 
       if (m_Handler.isDown()) {
          m_fVelY = 5;
       }
       else if (!m_Handler.isUp()) {
          m_fVelY = 0;
       }   
       
       if (m_Handler.isRight()) {
          m_fVelX = 5;
       }
       else if (!m_Handler.isLeft()) {
          m_fVelX = 0;
       }
       
       if (m_Handler.isLeft()) {
          m_fVelX = -5;
       }
       else if (!m_Handler.isRight()) {
          m_fVelX = 0;
       }
       
       m_Animation.runAnimation();
       
    }

    private void collision() {
        
       int iCount;
       
       for (iCount = 0; iCount < m_Handler.gameObjects.size(); ++iCount) {
       
          GameObject tempGameObject = m_Handler.gameObjects.get(iCount);
          
          if (tempGameObject.getID() == ID.Block) {
             
             // Check if the player and a block intersects. 
             if (getBounds().intersects(tempGameObject.getBounds())) {
             
                m_iX += m_fVelX * -1;
                m_iY += m_fVelY * -1;
                 
             }
          
          }
 
          if (tempGameObject.getID() == ID.Create) {
             
             // Check if the player and a crate intersects. 
             if (getBounds().intersects(tempGameObject.getBounds())) {
             
                m_zombieKillingGame.m_iAmmo += 10;
                m_Handler.removeGameObject(tempGameObject);
                 
             }
          
          }  
          
          if (tempGameObject.getID() == ID.Enemy) {
             
             // Check if the player and an enemy intersects. 
             if (getBounds().intersects(tempGameObject.getBounds())) {
             
                m_zombieKillingGame.m_iHP--;
                
                if (m_zombieKillingGame.m_iHP <= 0) {
                    
                   m_zombieKillingGame.m_iHP = 0;
                   
                }
                 
             }
          
          }
          
       }
       
    }
        
    public void render(Graphics g) {
        
       // g.setColor(Color.blue);
       // g.fillRect(m_iX, m_iY, Hero.WIZ_WIDTH, Hero.WIZ_HEIGHT);
       
       // If Hero standing still, don't do any animation. 
       if (m_fVelX == 0 && m_fVelY == 0) { 
          g.drawImage(m_buffImg[0], m_iX, m_iY, null);
       }
       else {
          m_Animation.drawAnimation(g, m_iX, m_iY, 0);
       }
        
    }

    public Rectangle getBounds() {
        
       return new Rectangle(m_iX, m_iY, Hero.HERO_WIDTH, Hero.HERO_HEIGHT);
       
    }    
    
}

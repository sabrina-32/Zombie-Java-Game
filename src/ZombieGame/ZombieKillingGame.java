
// Class: ZombieKillingGame

package ZombieGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sabrina
 */
public class ZombieKillingGame extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    
    private boolean m_bIsRunning = false;
    private Thread m_Thread;
    private Thread screen;
    
    private Handler m_Handler;

    private Window m_Window;
    private Camera m_Camera;
    private SpriteSheet m_SpriteSheet;
   
    public static int WIDTH = 1000;
    public static int HEIGHT = 563;
    
    private BufferedImage m_Level = null;
        private BufferedImage m_Menu = null;

    private BufferedImage m_BuffImageSpriteSheet = null;    
    private BufferedImage m_Floor = null;
    public final int gameOverState=0;
    
    public int m_iAmmo = 130;
    public int m_iHP = 100;
    
    //SET GAME STATE//SET GAME STATE//SET GAME STATE//SET GAME STATE//SET GAME STATE//SET GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    
    
   
    public void setupGame(){
                gameState = titleState;

    }
    public ZombieKillingGame() {
        
       // Box newBox1 = new Box(100, 100, ID.Block);
       // Box newBox2 = new Box(200, 100, ID.Block);
    
       // newBox1.setVelocityX(1);
       // newBox2.setVelocityX(1);
             
      

       
       m_Window = new Window(ZombieKillingGame.WIDTH, ZombieKillingGame.HEIGHT, 
                                                         "Zombie Killing Game", this);
       
       start();
       
       m_Handler = new Handler();
       m_Camera = new Camera(0, 0);
       this.addKeyListener(new KeyInput(m_Handler));

       
       // m_Handler.addGameObject(newBox1);
       // m_Handler.addGameObject(newBox2);
       
       BufferedImageLoader m_BufferedImageLoader = new BufferedImageLoader();
       
       m_Level = m_BufferedImageLoader.loadImage("Res/Levels22.png");
              m_Menu = m_BufferedImageLoader.loadImage("Res/MENU.png");

       m_BuffImageSpriteSheet = 
                    m_BufferedImageLoader.loadImage("Res/SpriteSheet222.png");
       
       // m_Handler.addGameObject(new Hero(100, 100, ID.Player, m_Handler));
       
       m_SpriteSheet = new SpriteSheet(m_BuffImageSpriteSheet);
       
       m_Floor = m_SpriteSheet.grabImage(2, 4, 32, 32);

       this.addMouseListener(new MouseInput(m_Handler, m_Camera, this, 
                                                               m_SpriteSheet));       
       
       loadLevel(m_Level);
       
    }
    
    
    private void start() {
        
       m_bIsRunning = true;
       m_Thread = new Thread(this);
       m_Thread.start();
       
    }
    
    private void stop() {
    
       m_bIsRunning = false;
       
       try {
          m_Thread.join();
       }
       catch(InterruptedException e) {
          e.printStackTrace();
       }
        
    }
    
    public void run() {
               
       long lLastTime = System.nanoTime();
       double dAmountOfTicks = 60.0;
       double dNs = 1000000000 / dAmountOfTicks;
       double dDelta = 0;
       long lTimer = System.currentTimeMillis();
       int iFrames = 0;
       long lNow;
       
       this.requestFocus();
       
       while (m_bIsRunning) {
       
          lNow = System.nanoTime();
          dDelta += (lNow - lLastTime) / dNs;
          lLastTime = lNow;
          
          while (dDelta >= 1) {
             tick();
             // ++dUpdates;
             --dDelta;
          }
          
          render();
          ++iFrames;
          
          if (System.currentTimeMillis() - lTimer > 1000) {
              
             lTimer += 1000;
             iFrames = 0;
             // dUpdates = 0;
             
          }
           
       }   // End while(m_bIsRunning) ...
       
           
                            stop();

          

        
    }
    
    public void tick() {
     
       int iCount;
       
       for (iCount = 0; iCount < m_Handler.gameObjects.size(); ++iCount) {
       
          if (m_Handler.gameObjects.get(iCount).getID() == ID.Player) {
              
             m_Camera.tick(m_Handler.gameObjects.get(iCount));
             
          } 
           
       }

       m_Handler.tick();
      
        
    }
    
    public void render() {

      BufferStrategy buffStrategy = this.getBufferStrategy();
      
      if (buffStrategy == null) {      
         createBufferStrategy(3);
         return;         
      }
      
      
      Graphics g = buffStrategy.getDrawGraphics();
      
      Graphics2D g2d = (Graphics2D) g;
      //    TItleScreen

        if(gameState == titleState){
g.setColor(new Color(70,120,80));
g.fillRect(0, 0, WIDTH, HEIGHT);
g.setFont(g.getFont().deriveFont(Font.BOLD,70F));
   
String text = "Zombie Killing Game";
g.setColor(Color.WHITE);
        
g.drawString(text, 150, 270);

g.setFont(g.getFont().deriveFont(Font.ITALIC,30F));
   
String text2 = "Touch anywhere to  start the game";
g.setColor(Color.WHITE);
        
g.drawString(text2, 280, 320);


        }
        

             
      // Draw graphics in here.
      
      // Start drawing.
      
      // g.setColor(Color.red);
      // g.fillRect(0, 0, ZombieKillingGame.WIDTH, ZombieKillingGame.HEIGHT); 
         
//        else{
             g2d.translate(-m_Camera.getX(), -m_Camera.getY());
      
      int iX, iY;
      
      for (iX = 0; iX < 30 * 72; iX += 32) {
          
         for (iY = 0; iY < 30 * 72; iY += 32) {
             
            g.drawImage(m_Floor, iX, iY, null);
            
         }
         
      }
      
//       if(gameState==gameOverState){
//stop();    
//}
      m_Handler.render(g);

      g2d.translate(m_Camera.getX(), m_Camera.getY());      
      
      // Draw Health Bar after the "translate" call.
      
      // Create background for the Health Bar.
      g.setColor(Color.gray);
      g.fillRect(5, 5, 200, 32);
      
      g.setColor(Color.green);
      g.fillRect(5, 5, m_iHP * 2, 32);
      
      g.setColor(Color.black);
      g.drawRect(5, 5, 200, 32);
      
      // Draw ammo information.
      g.setColor(Color.white);
      g.setFont(g.getFont().deriveFont(Font.ITALIC,20F));

      g.drawString("Ammo : " + m_iAmmo + ".", 7, 56);      
            
//       


      // End drawing.
      
      g.dispose();
      buffStrategy.show();
        }
    
    
    
    // Loading the level.
    private void loadLevel(BufferedImage buffImage) {
        
       int iWidth = buffImage.getWidth();
       int iHeight = buffImage.getHeight();
       int iX;
       int iY;
       int iPixelColor;
       int iRed, iGreen, iBlue;
       
       System.out.println("Width: " + iWidth + ", Height: " + iHeight + ".\n");
       
       for (iX = 0; iX < iWidth; ++iX) {
           
          for (iY = 0; iY < iHeight; ++iY) {
              
             iPixelColor = buffImage.getRGB(iX, iY);
             iRed = (iPixelColor >> 16) & 0xff;
             iGreen = (iPixelColor >> 8) & 0xff;
             iBlue = (iPixelColor) & 0xff;             
             
             if (iRed == 255) {
                 
                m_Handler.addGameObject(new Block(iX * 32, iY * 32, ID.Block,
                                                               m_SpriteSheet));
                
             }
             
             if (iBlue == 255 && iGreen == 0) {
                 
                m_Handler.addGameObject(new Hero(iX * 32, iY * 32, ID.Player, 
                                             m_Handler, this, m_SpriteSheet));
                
             }
             
             if (iGreen == 255 && iBlue == 0) {
                 
                m_Handler.addGameObject(new Enemy(iX * 32, iY * 32, ID.Enemy, 
                                                   m_Handler, m_SpriteSheet));
                
             }
             
             if (iGreen == 255 && iBlue == 255) {
                 
                m_Handler.addGameObject(new Create(iX * 32, iY * 32, ID.Create,
                                                               m_SpriteSheet));
                
             }
             
          }
         
       }
      
           
    }
    
    public static void main(String[] args) {
       
       ZombieKillingGame zombieKillingGame = new ZombieKillingGame();  
       
        
        
    }
    
}

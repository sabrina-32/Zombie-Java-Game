
package ZombieGame;

import java.awt.Canvas;

/**
 *
 * @author Sabrina
 */
public class Game  extends Canvas implements Runnable{
    
    private  boolean isRunning = false;
    private Thread thread;
    
    
    public Game(){
        new Window(1000, 600, "Zombie Game", this );
        start();
    }
    
//    Game Start method
    private void start(){
      isRunning = true;
      thread = new Thread(this);
      thread.start();
    }
    
    //    Game Stop method
    private void stop(){
        isRunning = false;
       try{
          thread.join();
       } catch (InterruptedException e){
           e.printStackTrace();
       }
       
    }
    public static void main(String[] args) {
        
        new Game();
        
    }

    @Override
    public void run() {
        
    }
    
}

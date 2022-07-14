
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
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames =0;
        while(isRunning){
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime  = now;
            while(delta>=1){
                tick();
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis()- timer>1000){
                timer+= 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
    }

    private void render() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
 
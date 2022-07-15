
package ZombieGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Sabrina
 */
public class Game  extends Canvas implements Runnable{
    
    private  boolean isRunning = false;
    private Thread thread;
    
    private Handler handler;
    
    
    public Game(){
        new Window(1000, 600, "Zombie Game", this );
        start();
        handler = new Handler();
        
        handler.addObject(new Box(100, 100));
                handler.addObject(new Box(200, 100));

         
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

//   update everything
    private void tick() {
        handler.tick();
    }

//    render everything
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
                if(bs ==null){
                    this.createBufferStrategy(3);
                    return;
                    
                }
                Graphics g= bs.getDrawGraphics();
////////////////////////////////////////////     

                g.setColor(Color.red);
                g.fillRect(0, 0, 1000, 600);
                handler.render(g);


////////////////////////////////////////////                

                
                g.dispose();
                bs.show();
                
           

    }
    
} 
 
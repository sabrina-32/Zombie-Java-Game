
package ZombieGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sabrina
 */
public class Game  extends Canvas implements Runnable{
    
    private  boolean isRunning = false;
    private Thread thread;
    
    private Handler handler;
    private BufferedImage level = null;

    
    
    public Game(){
        new Window(1000, 600, "Zombie Killing Game", this );
        start(); 
        handler = new Handler();
        this.addKeyListener((new KeyInput(handler)));
        
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/zombie-game-board.png");

         loadLevel(level);
          
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
//    loading the level
    
    private void loadLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        
        for(int xx=0; xx<w; xx++){
            for(int yy =0;yy<h;  yy++  ){
                int pixel =  image.getRGB(xx, yy);
                int red = (pixel>>16) & 0xff;
                int green = (pixel>>8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red == 255)
                    handler.addObject(new Block(xx*32,  yy*32,  ID.Block));
                if(blue == 255)
                    handler.addObject(new Protagonist(xx*32,  yy*32,  ID.Player, handler));
                

            }
        }
        
    }
    
    public static void main(String[] args) {
        
        new Game();
        
    }
    
   
    
} 
 
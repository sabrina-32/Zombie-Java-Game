
package ZombieGame;

import java.awt.Canvas;

/**
 *
 * @author Sabrina
 */
public class Game  extends Canvas implements Runnable{
    
    
    public Game(){
        new Window(1000, 600, "Zombie Game", this );
    }
    public static void main(String[] args) {
        
        new Game();
        
    }

    @Override
    public void run() {
        
    }
    
}

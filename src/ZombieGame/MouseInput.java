
package ZombieGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Sabrina
 */
public class MouseInput  extends MouseAdapter{
   
    private Handler  handler;
    private Camera camera;
    
    public MouseInput(Handler  handler,Camera camera){
        this.handler = handler;
        this.camera = camera;
    }
    public void mousePresses(MouseEvent e){
       
        int mx =(int) (e.getX() + camera.getX());
        int my =(int) (e.getY() + camera.getY());

    }
}

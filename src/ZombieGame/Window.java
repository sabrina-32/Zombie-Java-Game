
// Class: Window

package ZombieGame;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Sabrina
 */
public class Window {

   public Window(int iWidth, int iHeight, String strTitle, 
                                                     ZombieKillingGame zombieKillingGame) {
   
      JFrame frame = new JFrame(strTitle);
      
      frame.setPreferredSize(new Dimension(iWidth, iHeight));
      frame.setMaximumSize(new Dimension(iWidth, iHeight));
      frame.setMinimumSize(new Dimension(iWidth, iHeight));
      
      frame.add(zombieKillingGame);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
   }    
    
}

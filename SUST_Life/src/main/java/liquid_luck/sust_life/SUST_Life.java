

package liquid_luck.sust_life;

import javax.swing.JFrame;

import liquid_luck.miniGamePong.PongGameFrame;

<<<<<<< HEAD
=======

>>>>>>> b6ea2ee7324ba1796c9b3d6541580cd66e5317d0

/**
 * SUST Life
 * Liquid Luck
 * @author Mehedi and Ataur
 * CSE, SUST
 * Bangladesh
 */
public class SUST_Life {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("SUST LIFE");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Running the Gameloop
        gamePanel.startGameThread();
<<<<<<< HEAD
        //PongGameFrame pongFrame = new PongGameFrame();
        new PongGameFrame();
=======

        //PongGameFrame pong = new PongGameFrame();
>>>>>>> b6ea2ee7324ba1796c9b3d6541580cd66e5317d0
        
    }
}

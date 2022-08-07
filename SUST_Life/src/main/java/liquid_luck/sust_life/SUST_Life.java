

package liquid_luck.sust_life;

import javax.swing.JFrame;



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
        //PongGameFrame p = new PongGameFrame();
    }

    
}

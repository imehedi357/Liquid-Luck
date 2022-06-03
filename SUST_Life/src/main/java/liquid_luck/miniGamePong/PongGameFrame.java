 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package liquid_luck.miniGamePong;

import java.awt.Color;

import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class PongGameFrame extends JFrame{
    
    PongGamePanel pongPanel;
    
    public PongGameFrame(){
        pongPanel = new PongGamePanel();
        this.add(pongPanel);
        this.setTitle("PongGame");
        this.setResizable(false);
        this.setBackground(new Color(12,29,65));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }
}

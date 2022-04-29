/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package liquid_luck.sust_life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 *
 * @author Mehedi and Ataur
 */

// Extending JPanel with some extra functions
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 32;
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    
    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
    }
    
    Thread gameThread;
    
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        while(gameThread != null) {

            System.out.println("The game is running!");
            // TODO:
            // 1. Update : update information
            update();
            // 2. Draw : to call the paintComponent method
            repaint();
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(100, 100, tileSize, tileSize);

        // To save memory;
        g2.dispose();
    }
    
    
}

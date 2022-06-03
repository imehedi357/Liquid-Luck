/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package liquid_luck.sust_life;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import liquid_luck.sprites.Player;
import liquid_luck.tile.TileManager;

/**
 *
 * @author Mehedi and Ataur
 */

// Extending JPanel with some extra functions
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16;
    public int scale = 3;
    final int FPS = 60;
    
    public  int tileSize = originalTileSize * scale;
    public int maxScreenCol = 26;
    public int maxScreenRow = 16;
    
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Player player = new Player(this, keyH);
    
    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    Thread gameThread;
    
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // FPS control
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawcount = 0;
        
        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                //System.out.println("The game is running!");
                // TODO:
                // 1. Update : update information
                update();
                // 2. Draw : to call the paintComponent method
                repaint();
                
                delta--;
                drawcount++;
            }

            // Show FPS every 1 second
            if(timer >= 1e9) {
                System.out.println("FPS: " + drawcount);
                drawcount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);

        // To save memory;
        g2.dispose();
    }
    
    
}

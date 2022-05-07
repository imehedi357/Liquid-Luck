package liquid_luck.sprites;

import java.awt.Color;
import java.awt.Graphics2D;

import liquid_luck.sust_life.GamePanel;
import liquid_luck.sust_life.KeyHandler;

public class Player extends Sprites {  

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) { 
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 5;
    }

    public void update() {
        if(keyH.up == true) {
            y -= speed;
        }
        else if(keyH.down == true) {
            y += speed;
        }
        else if(keyH.left == true) {
            x -= speed;
        }
        else if(keyH.right == true) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}

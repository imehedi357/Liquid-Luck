package liquid_luck.sprites;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import liquid_luck.sust_life.GamePanel;
import liquid_luck.sust_life.KeyHandler;

public class Player extends Sprites {  

    GamePanel gp;
    KeyHandler keyH;
    public int aniCnt = 0;
    public int aniIndex = 0;
    public int aniSpeed = 12;
    public int dir = 0;

    public Player(GamePanel gp, KeyHandler keyH) { 
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
    }
    

    public void getPlayerImage() {

        try {
            
            BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/player.png"));

            p = new BufferedImage[4][4];

            for(int i  = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    p[i][j] = img.getSubimage(j * 16, i * 32, 16, 32);
                }
            }


        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void updateAnimation(int x) {
        if(x == -1) {
            aniIndex = 0;
        }
        else {
            aniCnt++;
            if(aniCnt >= aniSpeed) {
                aniCnt = 0;
                aniIndex = (aniIndex + 1) % 4;
            }
            dir = x;
        }
    }

    public void update() {
        if(keyH.up == true) {
            y -= speed;
            updateAnimation(2);
        }
        else if(keyH.down == true) {
            y += speed;
            updateAnimation(0);
        }
        else if(keyH.left == true) {
            x -= speed;
            updateAnimation(3);
        }
        else if(keyH.right == true) {
            x += speed;
            updateAnimation(1);
        }
        else {
            updateAnimation(-1);
        }
    }

    BufferedImage startingBack;

    {
        try {
            startingBack = ImageIO.read(getClass().getResourceAsStream("/startScreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        g2.drawImage(startingBack, 0, 0,startingBack.getWidth() * gp.scale, startingBack.getHeight() * gp.scale, null);
        g2.drawImage(p[dir][aniIndex], x, y, 16 * 3, gp.tileSize, null);
    }
}

package liquid_luck.sprites;

import java.awt.image.BufferedImage;

// Super Class of the Player and NPCs
public class Sprites {
    
    public int x, y;
    public int speed;

    public int collusionAreaX1 = x + 0;
    public int collusionAreaY1 = y + 16 * 3;  // half * scale

    public int collusionAreaX2 = x + 16 * 3;
    public int collusionAreaY2 = y + 32 * 3;


    public BufferedImage[][] p;
}

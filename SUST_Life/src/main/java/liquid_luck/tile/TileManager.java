package liquid_luck.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import liquid_luck.sust_life.GamePanel;

public class TileManager {
    
    GamePanel gp;
    Tile[] tiles;
    int map[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tiles = new Tile[20];
        map = new int[gp.maxScreenRow][gp.maxScreenCol];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {

        try {
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/collusion.png"));
            tiles[1].collusion = true;

            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/noCollusion.png"));
            tiles[0].collusion = false;
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {

        try {
            InputStream is = getClass().getResourceAsStream("/startScreen.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for(int i = 0; i < gp.maxScreenRow; i++) {
                String line = br.readLine();
                String num[] = line.split(" ");

                for(int j = 0; j < gp.maxScreenCol; j++) {
                    map[i][j] = Integer.parseInt(num[j]);
                }
            }

            br.close();
            is.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for(int i = 0; i < gp.maxScreenRow; i++) {
            for(int j = 0; j < gp.maxScreenCol; j++) {
                g2.drawImage(tiles[map[i][j]].image, j * 16 * 3, i * 16 * 3, gp.tileSize, gp.tileSize, null );
            }
        }
    }
}

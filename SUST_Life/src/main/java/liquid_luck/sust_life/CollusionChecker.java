package liquid_luck.sust_life;

import liquid_luck.sprites.Sprites;

public class CollusionChecker {

    GamePanel gp;

    public CollusionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public boolean checkTile(Sprites sprite, int dir) {
        if(dir == 1) {
            int ULcol = sprite.x / gp.tileSize;
            int ULrow = (sprite.y + gp.tileSize - sprite.speed) / gp.tileSize;

            int URcol = (sprite.x + gp.tileSize - 8) / gp.tileSize;
            int URrow = (sprite.y + gp.tileSize - sprite.speed) / gp.tileSize;

            if(gp.tileM.tiles[gp.tileM.map[ULrow][ULcol]].collusion == true || gp.tileM.tiles[gp.tileM.map[URrow][URcol]].collusion == true) {
                return false;
            }
            else return true;
        }
        else if(dir == -1) {
            int ULcol = sprite.x / gp.tileSize;
            int ULrow = (sprite.y + gp.tileSize - sprite.speed) / gp.tileSize;

            int URcol = (sprite.x + gp.tileSize - 8) / gp.tileSize;
            int URrow = (sprite.y + gp.tileSize - sprite.speed) / gp.tileSize;

            if(gp.tileM.tiles[gp.tileM.map[ULrow][ULcol]].collusion == true || gp.tileM.tiles[gp.tileM.map[URrow][URcol]].collusion == true) {
                return false;
            }
            else return true;
        }
        else return false;

    }
}

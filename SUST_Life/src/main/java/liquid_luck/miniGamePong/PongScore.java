package liquid_luck.miniGamePong;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author HP
 */
public class PongScore extends Rectangle {
    
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;
    
    PongScore(int GAME_WIDTH, int GAME_HEIGHT){
        PongScore.GAME_WIDTH = GAME_WIDTH;
        PongScore.GAME_HEIGHT = GAME_HEIGHT;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.setFont(new Font("Consolas", Font.PLAIN, 50));
        g.drawString(String.valueOf(player1 / 10)+String.valueOf(player1 % 10), (GAME_WIDTH/2)-80, 50);
        g.drawString(String.valueOf(player2 / 10)+String.valueOf(player2 % 10), (GAME_WIDTH/2)+25, 50);
        
    }
}

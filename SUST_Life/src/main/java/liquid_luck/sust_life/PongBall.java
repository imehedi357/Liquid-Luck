/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package liquid_luck.sust_life;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author HP
 */
public class PongBall extends Rectangle {
    
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 3;
    
    PongBall(int x, int y, int width, int height){
        super(x, y, width, height);
        random = new Random();
        int randomXdirection = random.nextInt(2);
        if(randomXdirection == 0){
            randomXdirection--;
        }
        setXdirection(randomXdirection * initialSpeed);
        int randomYdirection = random.nextInt(2);
        if(randomYdirection == 0){
            randomYdirection--;
        }
        setYdirection(randomYdirection * initialSpeed);
    }
    
    public void setXdirection(int randomXdirection){
        xVelocity = randomXdirection;
    }
    
    public void setYdirection(int randomYdirection){
        yVelocity = randomYdirection;
    }
    
    public void move(){
        x += xVelocity;
        y += yVelocity;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
        
    }
    
}

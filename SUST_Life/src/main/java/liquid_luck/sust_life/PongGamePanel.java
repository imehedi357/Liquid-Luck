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
public class PongGamePanel extends JPanel implements Runnable{
    
    static final int GAME_WIDTH = 900;
    static final int GAME_HEIGHT = 500;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 20;
    static final int PADDLE_HEIGHT = 80;
    boolean runningGameLoop = true;
    int velocityDirectionduringHandle;
    Thread gameThread;
    Image image;
    Graphics graphics;
    PongPaddle paddle1;
    PongPaddle paddle2;
    PongBall ball;
    PongScore score;
    Random random;
    
    
    PongGamePanel(){
        newPaddle();
        newBall();
        score = new PongScore(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void newBall(){
        random = new Random();
        ball = new PongBall((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }
    
    public void newPaddle(){
        paddle1 = new PongPaddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new PongPaddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    
    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
        
    }
    
    public void draw(Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        score.draw(g);
        if(runningGameLoop){
            ball.draw(g);
            g.setColor(Color.yellow);
            g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

        }
        else{
            g.setColor(Color.red);
            g.setFont(new Font("Consolas", Font.BOLD, 50));
            g.drawString("Game Over", (GAME_WIDTH/3)+20, (GAME_HEIGHT/3)-20);
            g.setColor(Color.green);
            g.setFont(new Font("Consolas", Font.ITALIC, 50));
            if(score.player1>=5){
                g.drawString("Player 1 WINS", (GAME_WIDTH/2)-180, (GAME_HEIGHT/2));
            }
            if(score.player2>=5){
                g.drawString("Player 2 WINS", (GAME_WIDTH/2)-180, (GAME_HEIGHT/2));
            }
        }
    }
    
    public void move(){
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    
    public void checkCollision(){
        
        // Bounce ball off top & bottom wndow edge
        if(ball.y <= 0){
            ball.setYdirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER){
            ball.setYdirection(-ball.yVelocity);
        }
        
        // Bounces ball on paddles
        if(ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            // Optional
            ball.xVelocity++; 
            if(ball.yVelocity > 0) ball.yVelocity++;
            else ball.yVelocity--;
            ball.setXdirection(ball.xVelocity);
            ball.setYdirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            // Optional
            ball.xVelocity++; 
            if(ball.yVelocity > 0) ball.yVelocity++;
            else ball.yVelocity--;
            ball.setXdirection(-ball.xVelocity);
            ball.setYdirection(ball.yVelocity);
        }
        
        
        // Stop paddle at window edges
        if(paddle1.y<=0){
            paddle1.y=0;
        }
        if(paddle1.y>=GAME_HEIGHT-PADDLE_HEIGHT){
            paddle1.y=GAME_HEIGHT-PADDLE_HEIGHT;
        }
        if(paddle2.y<=0){
            paddle2.y=0;
        }
        if(paddle2.y>=GAME_HEIGHT-PADDLE_HEIGHT){
            paddle2.y=GAME_HEIGHT-PADDLE_HEIGHT;
        }
        
        // Give a player 1 point and creates new paddle and ball
        if(ball.x <= 0){
            score.player2++;
            newPaddle();
            newBall();
            System.out.println("Player2 : " + score.player2);
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER){
            score.player1++;
            newPaddle();
            newBall();
            System.out.println("Player1 : " + score.player1);
        }
        
        // Handle 2nd paddle
        // Still to fix some cases but i am both tired and bored
        int ycorBall=0;
        if(ball.x==650) ycorBall=ball.y;
        if(ball.xVelocity>=0 && ball.x>=610 && ball.x<=850){
            if(ball.yVelocity < 0){
                if(ycorBall>=0 && ycorBall<=150){
                    if(paddle2.y<=460){
                        paddle2.y-=3;
                        move();
                    }
                    else{
                        paddle2.y+=4;
                        move();
                    }
                }
                if(ycorBall>=151 && ycorBall<=320){
                    if(paddle2.y<=180){
                        paddle2.y-=3;
                        move();
                    }
                    else{
                        paddle2.y+=4;
                        move();
                    }
                }
                if(ycorBall>=321 && ycorBall<=490){
                    if(paddle2.y<=40){
                        paddle2.y+=4;
                        move();
                    }
                    else{
                        paddle2.y-=3;
                        move();
                    }
                }
            }
            else{
                if(ycorBall>=0 && ycorBall<=150){
                    if(paddle2.y>=460){
                        paddle2.y-=3;
                        move();
                    }
                    else{
                        paddle2.y+=4;
                        move();
                    }
                }
                if(ycorBall>=151 && ycorBall<=320){
                    if(paddle2.y<=180){
                        paddle2.y-=3;
                        move();
                    }
                    else{
                        paddle2.y+=4;
                        move();
                    }
                }
                if(ycorBall>=321 && ycorBall<=499){
                    if(paddle2.y<=40){
                        paddle2.y-=3;
                        move();
                    }
                    else{
                        paddle2.y+=4;
                        move();
                    }
                }
            }
        }
        
        
        
        
        // Game over
        if(score.player1 >= 5 || score.player2 >= 5){
            runningGameLoop = false;
            newPaddle();
        }
    }
    
    public void run(){
        // Game loop
        long lastTime = System.nanoTime();
        double amountOftics = 60.0;
        double ns = 1000000000 / amountOftics;
        double delta = 0;
        while(runningGameLoop){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.Controller;

import Pong.util.FPS;
import Pong.Model.Ball;
import Pong.Model.Padel;
import Pong.Model.Scores;
import Pong.View.GameView;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author A titkos mikkenty?
 */
public class GameController extends KeyAdapter{

    private Ball ball;
    private Padel p1;
    private Padel p2;
    private Scores scores;
    private GameView gameView;
    private Timer timer;

    public GameController() {
        Random rand = new Random();
        this.ball = new Ball(new Point(800, 450), new Point(18, 0));
        this.p1 = new Padel(new Point(100, 450));
        this.p2 = new Padel(new Point(1500, 450));
        this.scores = new Scores();
        this.gameView = new GameView();
        this.gameView.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W :
                p1.setSpeed(-15);
                break;
            case KeyEvent.VK_S :
                p1.setSpeed(15);
                break;
            case KeyEvent.VK_UP :
                p2.setSpeed(-15);
                break;
            case KeyEvent.VK_DOWN :
                p2.setSpeed(15);
                break;
            case KeyEvent.VK_SPACE :
                restart();
                break;
            case KeyEvent.VK_ESCAPE :
                System.exit(0);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_S :
                p1.setSpeed(0);
                break;
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN :
                p2.setSpeed(0);
                break;
        }
    }
    
    public GameView getGameView() {
        return gameView;
    }
    
    public void updateView() {
        gameView.update(ball.getPosition(), p1.getPosition(), p2.getPosition(), scores.getP1Score(), scores.getP2Score());
    }
    
    public void start() {
        gameView.requestFocusInWindow();
        updateView();
        
        timer = new Timer(1000/FPS.TARGET_FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FPS.calcDeltaTime();
                p1.move();
                p2.move();
                ball.move();
                switch(ball.checkWallCollision()) {
                    case 1 :
                        scores.incrementScore(1);
                        if(scores.getP1Score() == Scores.maxScore) stop();
                        ball.reset();
                        p1.reset();
                        p2.reset();
                        break;
                    case 2 :
                        scores.incrementScore(2);
                        if(scores.getP2Score() == Scores.maxScore) stop();
                        ball.reset();
                        p1.reset();
                        p2.reset();
                        break;
                    default : break;
                }
                ball.checkPadelCollision(p1.getPosition(), p2.getPosition());
                updateView();
            }
        });
        
        timer.start();
        FPS.calcBeginTime();
    }
    
    public void stop() {
        gameView.setGameOver(true);
        timer.stop();
    }
    
    public void restart() {
        if(timer.isRunning()) timer.stop();
        gameView.setGameOver(false);
        scores.resetScores();
        p1.reset();
        p2.reset();
        ball.reset();
        start();
    }
}

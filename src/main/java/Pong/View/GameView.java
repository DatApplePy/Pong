/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author A titkos mikkenty?
 */
public class GameView extends JPanel{
    
    private final BallView ballView;
    private final PadelView p1View;
    private final PadelView p2View;
    private int p1Score;
    private int p2Score;
    private boolean gameOver;

    public GameView() {
        super();
        setPreferredSize(new Dimension(1600, 900));
        ballView = new BallView();
        p1View = new PadelView();
        p2View = new PadelView();
        gameOver = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        for(int i = 0; i < 10; i++) {
            g.fillRect(getWidth()/2-4, i*90+20, 8, 50);
        }
        ballView.draw(g);
        p1View.draw(g);
        p2View.draw(g);
        g.setFont(new Font(null, Font.PLAIN, 100));
        g.drawString(Integer.toString(p1Score), 400, 100);
        g.drawString(Integer.toString(p2Score), 1200, 100);
        if(gameOver) {
            String text = "GAME OVER";
            Font font = new Font(null, Font.PLAIN, 150);
            FontMetrics fm = g.getFontMetrics(font);
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g.setFont(font);
            g.drawString(text, x, y);
        }
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void update(Point ballPos, Point p1Pos, Point p2Pos, int p1Score, int p2Score){
        ballView.setPosition(ballPos);
        p1View.setPosition(p1Pos);
        p2View.setPosition(p2Pos);
        this.p1Score = p1Score;
        this.p2Score = p2Score;
        repaint();
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}

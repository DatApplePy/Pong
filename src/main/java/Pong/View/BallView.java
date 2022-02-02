/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author A titkos mikkenty?
 */
public class BallView {
    private Point position;
    
    public BallView() {
    }
    
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(position.x-10, position.y-10, 20, 20);
    }
}

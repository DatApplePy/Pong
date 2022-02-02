/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.Model;

import Pong.util.FPS;
import java.awt.Point;

/**
 *
 * @author A titkos mikkenty?
 */
public class Padel {
    
    private Point initPosition;
    private Point position;
    private int speed = 0;
    private final int minY = 70;
    private final int maxY = 830;

    public Padel(Point position) {
        this.initPosition = new Point(position);
        this.position = new Point(position);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
        if(position.y < minY) {
            position.y = minY;
        }
        else if (position.y > maxY) {
            position.y = maxY;
        }
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void move() {
        position.y += speed * FPS.getDeltaTime() * FPS.TARGET_FPS;
        if(position.y < minY) {
            position.y = minY;
        }
        else if (position.y > maxY) {
            position.y = maxY;
        }
    }
    
    public void reset() {
        position = new Point(initPosition);
    }
}

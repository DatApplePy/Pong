/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.Model;

import Pong.util.FPS;
import java.awt.Point;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author A titkos mikkenty?
 */
public class Ball {
    
    private Point initPosition;
    private Point position;
    private Point motionVector;
    private int initSpeed;
    private Clip wallCollSound;
    private Clip paddleCollSound;
    private Clip scoringSound;

    public Ball(Point position, Point motionVector) {
        this.initPosition = new Point(position);
        this.position = new Point(position);
        this.motionVector = motionVector;
        this.initSpeed = motionVector.x;
        
        try {
            AudioInputStream sound; 
            sound = AudioSystem.getAudioInputStream(new File(".//resources//wallcollision.wav"));
            wallCollSound = AudioSystem.getClip();
            wallCollSound.open(sound);
            sound = AudioSystem.getAudioInputStream(new File(".//resources//paddlecollision.wav"));
            paddleCollSound = AudioSystem.getClip();
            paddleCollSound.open(sound);
            sound = AudioSystem.getAudioInputStream(new File(".//resources//scoring.wav"));
            scoringSound = AudioSystem.getClip();
            scoringSound.open(sound);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Point getPosition() {
        return position;
    }

    public void move() {
        position.x += motionVector.x * FPS.getDeltaTime() * FPS.TARGET_FPS;
        position.y += motionVector.y * FPS.getDeltaTime() * FPS.TARGET_FPS;
    }
    
    private void recalculateMotion(Point padelPosition) {
        double collisionAngle;
        collisionAngle = ((position.y - padelPosition.y) * (75/70)) / (180/Math.PI);
        motionVector.y = (int)(initSpeed*Math.sin(collisionAngle));
        motionVector.x = (int)(initSpeed*Math.cos(collisionAngle));
    }
    
    public int checkWallCollision() {
        if(position.y-10 <= 0) {
            position.y = 10;
            motionVector.y *= -1;
            playSound(wallCollSound);
        }
        else if(position.y+10 >= 900) {
            position.y = 890;
            motionVector.y *= -1;
            playSound(wallCollSound);
        }
        if(position.x-10 <= 0 ) {
            initSpeed = -1 * Math.abs(initSpeed);
            playSound(scoringSound);
            return 2;
        }
        if(position.x+10 >= 1600) {
            initSpeed = Math.abs(initSpeed);
            playSound(scoringSound);
            return 1;
        }
        return 0;
    }
    
    public void checkPadelCollision(Point p1Pos, Point p2Pos) {
        if(position.x-10 <= p1Pos.x+5 && position.x+10 >= p1Pos.x+5) {
            if(position.y > p1Pos.y-70 && position.y < p1Pos.y+70) {
                recalculateMotion(p1Pos);
                motionVector.x = Math.abs(motionVector.x);
                playSound(paddleCollSound);
            }
        }
        else if(position.x-10 <= p2Pos.x-5 && position.x+10 >= p2Pos.x-5) {
            if(position.y > p2Pos.y-70 && position.y < p2Pos.y+70) {
                recalculateMotion(p2Pos);
                motionVector.x = -Math.abs(motionVector.x);
                playSound(paddleCollSound);
            }
        }
    }
    
    public void reset() {
        position = new Point(initPosition);
        motionVector = new Point(initSpeed, 0);
    }
    
    private void playSound(Clip clip) {
        clip.setFramePosition(0);
        clip.start();
    }
}

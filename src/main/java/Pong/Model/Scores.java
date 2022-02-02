/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.Model;

/**
 *
 * @author A titkos mikkenty?
 */
public class Scores {
    
    private int p1Score;
    private int p2Score;
    public static int maxScore = 11;
    
    public Scores() {
        p1Score = 0;
        p2Score = 0;
    }
    
    public void incrementScore(int playerNumber) {
        if(playerNumber == 1) p1Score++;
        else p2Score++;
    }
    
    public void resetScores() {
        p1Score = 0;
        p2Score = 0;
    }
    
    public int getP1Score() {
        return p1Score;
    }
    
    public int getP2Score() {
        return p2Score;
    }
}

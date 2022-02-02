/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.util;

/**
 *
 * @author A titkos mikkenty?
 */
public class FPS {
    private FPS(){}
    
    private static long lastTime;
    private static long  beginTime;
    private static double deltaTime;
    public static final int TARGET_FPS = 60;
    
    public static void calcBeginTime() {
        beginTime = System.nanoTime();
    }
    
    public static void calcDeltaTime() {
        lastTime = System.nanoTime();
        deltaTime = lastTime - beginTime;
        beginTime = lastTime;
    }
    
    public static double getDeltaTime() {
        return deltaTime / 1000000000;
    }
}

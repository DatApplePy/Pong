/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.View;

import Pong.Controller.GameController;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author A titkos mikkenty?
 */
public class Window extends JFrame{
    
    private GameController gameCtrl;
    private MenuView menuView;
    
    public Window() {
        super();
        setTitle("PONG");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        gameCtrl = new GameController();
        menuView = new MenuView();
        add(menuView);
        
        menuView.playBtnListener((ActionEvent e) -> {
            remove(menuView);
            add(gameCtrl.getGameView());
            gameCtrl.start();
            revalidate();
            repaint();
        });
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

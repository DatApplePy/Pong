/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pong.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author A titkos mikkenty?
 */
public class MenuView extends JPanel{
    
    private JLabel gameName;
    private JButton playButton;
    private JButton exitButton;
    
    public MenuView() {
        super();
        initComponents();
        initLayout();
    }
    
    private void initComponents() {
        gameName = new JLabel("PONG");
        gameName.setFont(new Font(null, Font.PLAIN, 200));
        gameName.setForeground(Color.WHITE);
        
        playButton = new JButton("PLAY");
        playButton.setFont(new Font(null, Font.PLAIN, 50));
        playButton.setForeground(Color.WHITE);
        playButton.setPreferredSize(new Dimension (200, 100));
        playButton.setBackground(Color.BLACK);
        playButton.setFocusPainted(false);
        playButton.setBorder(BorderFactory.createEmptyBorder());
        
        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font(null, Font.PLAIN, 50));
        exitButton.setForeground(Color.WHITE);
        exitButton.setPreferredSize(new Dimension (200, 100));
        exitButton.setBackground(Color.BLACK);
        exitButton.setFocusPainted(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
    
    private void initLayout() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(1600, 900));
        
        SpringLayout rootLayout = new SpringLayout();
        setLayout(rootLayout);
        
        add(gameName);
        rootLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gameName, 0, SpringLayout.VERTICAL_CENTER, this);
        rootLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gameName, 0, SpringLayout.HORIZONTAL_CENTER, this);
        
        add(playButton);
        rootLayout.putConstraint(SpringLayout.NORTH, playButton, 10, SpringLayout.SOUTH, gameName);
        rootLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, playButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
        
        add(exitButton);
        rootLayout.putConstraint(SpringLayout.NORTH, exitButton, 10, SpringLayout.SOUTH, playButton);
        rootLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, exitButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
    }
    
    public void playBtnListener(ActionListener actListener) {
        playButton.addActionListener(actListener);
    }
    
}

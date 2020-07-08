package com.literdood.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    private int S_WIDTH = 512;
    private int S_HEIGHT = 512;

    public GamePanel() {
        addKeyListener(this);
        setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));

        setFocusable(true);
        requestFocus();

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        // clear screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                break;
            case KeyEvent.VK_A:
                break;
            case KeyEvent.VK_S:
                break;
            case KeyEvent.VK_D:
                break;
            case KeyEvent.VK_SPACE:
                break;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }
}
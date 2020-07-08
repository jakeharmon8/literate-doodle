package com.literdood.graphics;

import javax.swing.*;

import com.literdood.game.Nut;
import com.literdood.game.Projectile;
import com.literdood.game.Tower;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class GamePanel extends JPanel implements KeyListener, ActionListener, MouseListener {

    private int S_WIDTH = 512;
    private int S_HEIGHT = 512;
    
    ArrayList<Nut> nutList = new ArrayList<Nut>();
    LinkedList<Tower> towers = new LinkedList<Tower>();
    LinkedList<Projectile> projectiles = new LinkedList<Projectile>();

    public GamePanel() {
        addKeyListener(this);
        addMouseListener(this);
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
        
        for (int i = 0; i < nutList.size(); i++) {
        	nutList.get(i).draw(g);
        }
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

	@Override
	public void mouseClicked(MouseEvent e) {
		Nut nut1 = new Nut();
		nut1.c = Color.red;
		nut1.x = e.getX();
		nut1.y = e.getY();
		nutList.add(nut1);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
package com.literdood.graphics;

import javax.swing.*;

import com.literdood.game.BasicProjectile;
import com.literdood.game.BasicTower;
import com.literdood.game.Nut;
import com.literdood.game.Path;
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
    LinkedList<BasicTower> towers = new LinkedList<BasicTower>();
    public static LinkedList<BasicProjectile> projectiles = new LinkedList<BasicProjectile>();

    Path path = new Path();

    public GamePanel() {
        addKeyListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));

        nutList.add(new Nut(path));
        
        setFocusable(true);
        requestFocus();

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        // clear screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, S_WIDTH, S_HEIGHT);

        path.draw(g);
        
        // draw nuts
        for (int i = 0; i < nutList.size(); i++) {
        	nutList.get(i).draw(g);
        }
        
        // draw towers
        for (int i = 0; i < towers.size(); i++) {
        	towers.get(i).draw(g);
        }
        
        for (int i = 0; i < projectiles.size(); i++) {
        	projectiles.get(i).draw(g);
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
                this.actionPerformed(null);
                break;
        }

//        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent arg0) {
        for(Nut n : nutList) {
            n.update();
        }
        
        for (BasicProjectile p : projectiles) {
        	p.update();
        }

        repaint();
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		towers.add(new BasicTower(e.getX(), e.getY()));
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
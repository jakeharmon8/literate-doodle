package com.literdood.game;

import java.awt.Color;
import java.awt.Graphics;

import com.literdood.graphics.GamePanel;

public class BasicTower {
	int x,y; 
	int size = 30; 
	Color c = Color.blue;
	
	public BasicTower(int x, int y) {
		GamePanel.projectiles.add(new BasicProjectile(x, y - size/2, 10));
		this.x = x; 
		this.y = y;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawRect(x - size/2, y - size/2, size, size);
	}
	
	
	public void update() {
		
	}
}

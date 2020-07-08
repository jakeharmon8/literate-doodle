package com.literdood.game;

import java.awt.Color;
import java.awt.Graphics;

import com.literdood.graphics.GamePanel;
import com.literdood.math.Vector;

public class BasicTower {
	int x,y; 
	int size = 30;
	float projetileSpeed = 15;
	int fireRate = 4;
	Color c = Color.blue;
	Nut target = GamePanel.nutList.get(0);

	int frame = 0;

	public BasicTower(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawRect(x - size/2, y - size/2, size, size);
	}

	public void fire() {
		Vector v = (new Vector(target.x - x, target.y - y)).unit().multiply(projetileSpeed);
		GamePanel.projectiles.add(new BasicProjectile(x, y, v.x, v.y));
	}
	
	public void update() {
		frame++;
		if(frame > fireRate) {
			fire();
			frame = 0;
		}
	}
}

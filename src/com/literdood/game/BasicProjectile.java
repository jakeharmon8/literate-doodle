package com.literdood.game;

import java.awt.Color;
import java.awt.Graphics;

public class BasicProjectile {
	
	public int speed;
	int size = 6;
	double vx = 0;
	double vy = -1;
	Color c = Color.black;
	public double x, y;
	
	public BasicProjectile(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval((int)(x - size/2), (int)(y - size/2), size, size);
	}
	
	public void update() {
		x = x + vx * speed; 
		y = y + vy * speed;
	}
}

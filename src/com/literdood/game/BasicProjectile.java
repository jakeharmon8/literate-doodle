package com.literdood.game;

import java.awt.Color;
import java.awt.Graphics;

public class BasicProjectile {
	
	int size = 6;
	Color c = Color.black;
	public double x, y, vx, vy;
	
	public BasicProjectile(float x, float y, float vx, float vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval((int)(x - size/2), (int)(y - size/2), size, size);
	}
	
	public void update() {
		x = x + vx;
		y = y + vy;
	}
}

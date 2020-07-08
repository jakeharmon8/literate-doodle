package com.literdood.game;

import java.awt.Color;
import java.awt.Graphics;

public class Nut {
	
	public Color c;
	// center point
	public int x;
	public int y;
	public int size = 20;

	public Nut() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x - size/2, y - size/2, size, size);
	}

}

package com.literdood.game;

import java.awt.Color;
import java.awt.Graphics;

public class Nut {
	
	public Color c = Color.red;
	// center point
	public float x;
	public float y;
	public float size = 20;
	public float speed = 10;
	public Path path;

	private float pathProgress = 0;

	public Nut(Path path) {
		this.path = path;
	}

	// if this returns true, delete the nut
	public boolean update() {
		Path.PathInfo pi = path.getNextPosition(pathProgress, speed);

		if(pi.finished) {
			return true;
		} else {
			pathProgress = pi.nextProgress;
			x = pi.nextPosition.x;
			y = pi.nextPosition.y;
			return false;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval((int)(x - size/2), (int)(y - size/2), (int)size, (int)size);
	}

}

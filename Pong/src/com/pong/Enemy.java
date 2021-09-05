package com.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy{

	public boolean right, lefth;
	public int px, py;
	public int width, height;
	public Color cor;


	public Enemy(int px, int py) {
		this.px = px;
		this.py = py;
		this.width = 40;
		this.height = 10;
		this.cor = Color.red;
	}

	public void tick() {			
		px += (int) (MainGame.ball.px - px - 6) * 0.07;

		if(px + width > MainGame.width)
			px = MainGame.width - width;
		else if(px < 0)
			px = 0;
	}

	public void render(Graphics g) {
		g.setColor(cor);
		g.fillRect(px, py, width, height);		
	}
}

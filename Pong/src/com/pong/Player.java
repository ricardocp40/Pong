package com.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player{

	public boolean right, lefth;
	public int px, py, dx = 0;
	public int width, height;
	public Color cor;
	

	public Player(int px, int py) {
		this.px = px;
		this.py = py;
		this.width = 40;
		this.height = 10;
		this.cor = Color.blue;
		      
	}

	public void tick() { 		
		if(right) {
			//dx = 1;
			px += 1 * (int) (2 * 1.5);
		}
		if(lefth) {
			//dx = -1; 
			px -= 1 * (int) (2 * 1.5);
		}
		
//		aux =  dx * (int) (2 * 1.5);
//		px += aux;
		
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

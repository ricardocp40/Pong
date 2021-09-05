package com.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UIScore {

	int score = 0;
	boolean win = false;
	boolean gameOver = false;
	String text = "";
	int py;

	Font font;

	UIScore(int py) {
		this.py = py;		
		font = new Font("Courier New", Font.PLAIN, 12);		
		font = font.deriveFont(22f);
		text = "" + score;
	}
	
	void updateScor() {		
		text = "" + score;		
	}
	
	public void increaseScore(int scor) {
		score = scor;
		updateScor();
	}

	public void render(Graphics g) {				
		g.setColor(Color.white);
		g.setFont(font);		
		g.drawString(text, 5,	py);		

	}
}

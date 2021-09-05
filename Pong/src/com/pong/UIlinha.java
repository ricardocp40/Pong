package com.pong;

import java.awt.Color;
import java.awt.Graphics;

public class UIlinha {
	
	
	void render(Graphics g) {
		g.setColor(Color.white);
		g.drawLine((int)MainGame.width, (int)MainGame.height / 2,0, (int)MainGame.height / 2 );
	}

}

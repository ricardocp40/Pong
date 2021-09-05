package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball{

	public boolean right, lefth;
	public int px, py, dx = 1, dy = 1;
	public double vel = 0.25;
	public int diameter;
	public Color cor;

	public Ball(int px, int py) {
		this.px = px;
		this.py = py;
		this.diameter = 8;		
		this.cor = Color.orange;
	}

	public void tick() {

		Rectangle bounds = new Rectangle((int)(px+(dx*vel)),(int)(py+(dy*vel)),diameter, diameter);
		Rectangle boundsPlayer = new Rectangle(MainGame.player.px,MainGame.player.py,MainGame.player.width,MainGame.player.height);
		Rectangle boundsEnemy = new Rectangle(MainGame.enemy.px,MainGame.enemy.py,MainGame.enemy.width,MainGame.enemy.height);

		if(bounds.intersects(boundsPlayer)) {
			if((px + diameter) < MainGame.player.px ) {				
				dx *= -1;
			}
			if( px > (MainGame.player.px + MainGame.player.width) ) {
				dx *= -1;
			}
			dy *= -1;
			
		}else if(bounds.intersects(boundsEnemy)) {
			if((px + diameter) < MainGame.enemy.px ) {				
				dx *= -1;
			}
			if( px > (MainGame.enemy.px + MainGame.enemy.width) ) {
				dx *= -1;
			}
			dy *= -1;
		}


		px += dx * vel * (1000 / 120);
		py += dy * vel * (1000 / 60);

		// TEST COLLISION OF BALL WITH THE WALL
		if(px + diameter > MainGame.width) {
			dx *= -1;
		}
		else if(px < 0) {
			dx *= -1;			
		}
		if(py + diameter > MainGame.height) {
			dy *= -1;
			MainGame.EnemyScore.increaseScore(MainGame.escor += 1); 
		}
		else if(py < 0) {
			dy *= -1;
			MainGame.PlayerScore.increaseScore(MainGame.pscor += 1); 
		}

	}

	public void render(Graphics g) {
		g.setColor(cor);
		g.fillOval(px, py, diameter, diameter);		
	}
}

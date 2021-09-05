package com.pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MainGame extends Canvas implements Runnable, KeyListener {

	/**
	 * ygihoho     hhhoh
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 188, height = 242;
	public int scale = 3;
	static int pscor = 0, escor = 0;
	public BufferedImage layer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	static Player player;
	static Enemy enemy;
	static Ball ball, b2;
	static UIlinha linha;
	static UIScore PlayerScore;
	static UIScore EnemyScore;

	public MainGame() {
		this.setPreferredSize(new Dimension(width * scale, height * scale));
		this.addKeyListener(this);

		player = new Player((int)(width / 2) - 20, height - 10 - 2);
		enemy = new Enemy((int)(width / 2) - 20, 2);
		ball = new Ball((int) (width / 2 - 3.5),(int) (height / 2 - 3.5));		
		EnemyScore = new UIScore(116);
		linha = new UIlinha();
		PlayerScore = new UIScore(140);
		
	}

	public static void main(String[] args) {

		MainGame game = new MainGame();
		JFrame janela = new JFrame("Pong Game");
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.add(game);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		new Thread(game).start();

	}

	public void tick() {
		player.tick();
		enemy.tick();
		ball.tick();
	}

	public void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);

		player.render(g);
		enemy.render(g);
		ball.render(g);		
		EnemyScore.render(g);
		linha.render(g);
		PlayerScore.render(g);

		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, width * scale, height * scale, null);
		bs.show();

	}

	@Override
	public void run() {
		while(true) {

			tick();
			render();
			try {
				Thread.sleep(1000/60);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_A) {
			player.lefth = true;			
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_A) {
			player.lefth = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		}

	}
}

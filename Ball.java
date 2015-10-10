package Hack-NC-Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ball extends JPanel {
	private int x,y;
	
	private void moveBall() {
		
	}
	
	public void create(Graphics g) { //this should create the ball sprite
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillOval(x, y, 30, 30);
	}
}

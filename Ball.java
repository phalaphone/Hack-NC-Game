package Hack_NC_Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ball extends Projectile {
	private int x,y;
    private double speed, direction;
    private static final int radius = 5;
    
    public Ball(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        super(int avatar_x, int avatar_y, int mouse_x, int mouse_y);
        speed = 200;
    }
	public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public int getWidth(){
        return radius;
    }
    
	public void Draw(Graphics g) { //this should create the ball sprite
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillOval(x, y, radius, radius);
	}
    
    public void increaseSpeed(double factor){
        speed=factor*speed;
    }
}

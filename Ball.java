package Hack_NC_Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ball extends Projectile {
	
    private double speed;
    private static final int radius = 50;
    
    public Ball(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        super(avatar_x, avatar_y, mouse_x, mouse_y);
        speed = 200;
    }
	public int getX(){
        return this.getX();
    }
    public int getY(){
        return this.getY();
    }
    
    public int getWidth(){
        return radius;
    }
    public int getHeight(){
        return radius;
    }
    
	public void Draw(Graphics g) { //this should create the ball sprite
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.green);
		g.drawOval(this.getX(), this.getY(), radius, radius);
		g.fillOval(this.getX(), this.getY(), radius, radius);
	}
    
    public void increaseSpeed(double factor){
        speed=factor*speed;
    }
}

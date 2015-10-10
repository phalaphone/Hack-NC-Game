package Hack_NC_Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bar extends Projectile{

    private int x;
    private int y;
    private double speed, direction;
    
    public Bar(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        super(int avatar_x, int avatar_y, int mouse_x, int mouse_y);
        this.speed = 500;
    }
    
    public int getX(){
        return x+(int)3*Math.cos(direction);
    }
    public int getY(){
        return y+(int)3*Math.sin(direction);
    }
    
    public void create(Graphics g) { //this should create the bar sprite
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
        int endX = this.x + 3 * Math.sin(direction);
        int endY = this.y + 3 * Math.cos(direction);
        g.drawLine(this.x,this.y,endX,endY,Color.blue);
	}
	
}

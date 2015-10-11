package Hack_NC_Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bar extends Projectile{

    private double x;
    private double y;
    private double speed, direction;
    private BufferedImage barImg;
    
    public Bar(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        super(avatar_x, avatar_y, mouse_x, mouse_y);
        this.speed = 2;
        
        try
        {
            URL spriteImgUrl = this.getClass().getResource("/Hack_NC_Game/resources/images/sprite1.jpg");
            barImg	 = ImageIO.read(spriteImgUrl);


        }
        catch (IOException ex) {
            Logger.getLogger(Avatar.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
  
    
    public int getX(){
        return (int) (x+3*Math.cos(direction));
    }
    public int getY(){
        return (int) (y+3*Math.sin(direction));
    }
    
    public void Draw(Graphics g) { //this should create the bar sprite
    	
    	System.out.println("it does the thing");
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
        double endX = (this.x + 3* Math.sin(direction));
        double endY =  (this.y + 3 * Math.cos(direction));
        g.setColor(Color.blue);
        //g.drawLine(this.x,this.y,endX,endY);
        g2d.drawImage(barImg,(int) x, (int)y, 2,6, null);
        this.x = endX;
        this.y = endY;
	}
	
}

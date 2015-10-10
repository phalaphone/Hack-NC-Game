package Hack_NC_Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bar extends Projectile{

    private int x;
    private int y;
    private double speed;
    private int[] direction;
    
    public Bar(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        super(int avatar_x, int avatar_y, int mouse_x, int mouse_y);
        this.speed = 500;
    }
	
}

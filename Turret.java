package Hack_NC_Game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class Turret{
	private BufferedImage spriteImg;
	private int spriteImgWidth, spriteImgHeight, x, y;
	private int width, height;
	
	public Turret(int x, int y){
		this.x = x;
		this.y = y;
		width = 50;
		height = 50;
	}
	public void LoadContent(){

        try
        {
            URL spriteImgUrl = this.getClass().getResource("/Hack_NC_Game/resources/images/eyeofsauron.jpg");
            spriteImg	 = ImageIO.read(spriteImgUrl);
            spriteImgWidth = spriteImg.getWidth();
            spriteImgHeight = spriteImg.getHeight();

        }
        catch (IOException ex) {
            Logger.getLogger(Avatar.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public void Draw(Graphics2D g2d){
		g2d.setColor(Color.red);
		g2d.drawImage(spriteImg, (int)x, (int)y, (int)width,(int)height, null);
	}
}
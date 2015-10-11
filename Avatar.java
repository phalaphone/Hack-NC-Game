package Hack_NC_Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Random;

public class Avatar implements AvatarInterface{

	private double xCoordinate, yCoordinate, width, height;
	private final int frameWidth, frameHeight,
						xMin, xMax, yMin, yMax;
	private final int speed = 1;
	private BufferedImage avatarImage;
	private final boolean isEnemy;
	private final int color;
	private BufferedImage spriteImg;
	private int spriteImgHeight,spriteImgWidth;

	public Avatar(int x, int y, int frameWidth, int frameHeight, boolean isEnemy){

		xCoordinate = x;
		yCoordinate = y;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		width = frameHeight / 40;
		height = frameHeight / 40;
		xMin =  (int)(width);
		xMax =  frameWidth + (int)(width);
		yMin =  (int)(height);
		yMax =  frameHeight + (int)(height);
		this.isEnemy = isEnemy;

		Random rand = new Random();
		if (isEnemy){
			color = rand.nextInt(3) + 1;
		}
		else
			color = 0;
	}

	public void LoadContent(){

        try
        {
            URL spriteImgUrl = this.getClass().getResource("/Hack_NC_Game/resources/images/sprite"
            													+ color + ".png");
            spriteImg	 = ImageIO.read(spriteImgUrl);
            spriteImgWidth = spriteImg.getWidth();
            spriteImgHeight = spriteImg.getHeight();

        }
        catch (IOException ex) {
            Logger.getLogger(Avatar.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public double getX(){
		return xCoordinate;
	}

	public double getY(){
		return yCoordinate;
	}

	public double getWidth(){
		return width;
	}

	public double getHeight(){
		return height;
	}

	public void move(int xIncrement, int yIncrement){

		moveX(xIncrement);
		moveY(yIncrement);
	}

	private void moveX(double xIncrement){

		if (xMin <= xCoordinate + xIncrement  &&
				xMax >= xCoordinate + xIncrement){

			xCoordinate += xIncrement;
			return;
		}
		else if (xMin < xCoordinate + xIncrement){
			xCoordinate = xMin;
			return;
		}
		else {
			xCoordinate = xMax;
			return;
		}
	}

	private void moveY(double yIncrement){
		if (yMin <= yCoordinate + yIncrement  &&
				yMax >= yCoordinate + yIncrement){

			yCoordinate += yIncrement;
			return;
		}
		else if (yMin < yCoordinate + yIncrement){
			yCoordinate = yMin;
			return;
		}
		else {
			yCoordinate = yMax;
			return;
		}
	}

	public void Update() {
			
		System.out.println("Meme received");
	        if(Canvas.keyboardKeyState(KeyEvent.VK_W))
	            moveY(-speed);

	        if(Canvas.keyboardKeyState(KeyEvent.VK_A))
	        	moveX(-speed);

	        if(Canvas.keyboardKeyState(KeyEvent.VK_S))
	        	moveY(speed);

	        if(Canvas.keyboardKeyState(KeyEvent.VK_D))
	        	moveX(speed);
	    }

	    public void Draw(Graphics2D g2d)
	    {
	        g2d.setColor(Color.white);
	        g2d.drawImage(spriteImg,(int) xCoordinate, (int) yCoordinate, null);

	    }

}

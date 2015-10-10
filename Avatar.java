package Hack_NC_Game;
public class Avatar implements AvatarInterface{

	private double xCoordinate, yCoordinate, width, height;
	private final int frameWidth, frameHeight, 
						xMin, xMax, yMin, yMax;
	
	Avatar(int x, int y, int frameWidth, int frameHeight){

		xCoordinate = x;
		yCoordinate = y;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		width = frameHeight / 20;
		height = frameHeight / 20;
		xMin =  (int)(.5 * width);
		xMax =  frameWidth + (int)(.5 * width);
		yMin =  (int)(.5 * height);
		yMax =  frameHeight + (int)(.5 * height);
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
	
	private void moveX(int xIncrement){
		
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
	
	private void moveY(int yIncrement){
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
}	

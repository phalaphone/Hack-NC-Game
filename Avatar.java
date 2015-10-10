package Hack-NC-Game;
public class Avatar implements AvatarInterface.java{

	private static int xCoordinate, yCoordinate, size, 
	private static final int frameWidth, frameHeight;
	
	Avatar(int x, int y, int frameWidth, int frameHeight){

		xCoordinate = x;
		yCoordinate = y;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		size = .05 * frameHeight;
	}

	public int getX(){
		return xCoordinate;
	}

	public int getY(){
		return yCoordinate;
	}

	public int getSize(){
		return size;
	}

	public move(int xIncrement, int yIncrement){



	}
}	

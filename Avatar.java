package Hack-NC-Game;
public class Avatar implements AvatarInterface.java{

	private static int xCoordinate, yCoordinate,size;
	
	Avatar(int x, int y, int size){

		xCoordinate = x;
		yCoordinate = y;
		this.size = size;
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

	public setLocation(int x, int y){

		xCoordinate = x;
		yCoordinate = y;
	}
}

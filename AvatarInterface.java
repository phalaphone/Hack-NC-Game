package Hack_NC_Game;
public interface AvatarInterface{

	//Avatar(int x, int y, int frameWidth, int frameHeight);
	double getX();
	double getY();
	double getWidth();
	double getHeight();
	void move(int xIncrement, int yIncrement);
}
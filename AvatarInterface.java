package Hack-NC-Game;
public interface AvatarInterface{

	Avatar(int x, int y, int frameWidth, int frameHeight);
	int getX();
	int getY();
	int getSize();
	void move(int xIncrement, int yIncrement);
}
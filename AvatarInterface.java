package Hack-NC-Game;
public interface AvatarInterface{

	Avatar(int x, int y, int size);
	int getX();
	int getY();
	int getSize();
	void setLocation(int x, int y);
}
package Hack_NC_Game;
public interface AvatarInterface{

	//Avatar(int x, int y, int frameWidth, int frameHeight, boolean isEnemy);
	double getX();
	double getY();
	double getWidth();
	double getHeight();
	void move(int xIncrement, int yIncrement);
	void Update();  //moves itself if user is pressing WASD
	void Draw();    //draws itself to the canvas
	void LoadContent(); //loads images, to be run after construction 
}
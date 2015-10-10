package Hack-NC-Game;

abstract public class Projectile{

    private int x_coord;
    private int y_coord;
    private int[] direction;
    private int speed;
    
    public Projectile(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        this.x_coord = avatar_x;
        this.y_coord = avatar_y;
        Int[] direction = new Int[2];
        direction[0] = mouse_x - avatar_x;
        direction[1] = mouse_y - avatar_y;
    }
    
    abstract public int getSpeed();
    abstract public Projectile setSpeed();
}

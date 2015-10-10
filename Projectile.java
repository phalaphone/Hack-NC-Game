package Hack-NC-Game;

abstract public class Projectile{

    private int x;
    private int y;
    private int[] direction;
    private double speed;
    
    public Projectile(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        this.x = avatar_x;
        this.y = avatar_y;
        Int[] direction = new Int[2];
        direction[0] = mouse_x - avatar_x;
        direction[1] = mouse_y - avatar_y;
    }

    abstract public collision();
}

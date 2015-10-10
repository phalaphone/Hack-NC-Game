package Hack_NC_Game;

public class Projectile{

    private int x;
    private int y;
    private double speed, direction;
    
    public Projectile(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        this.x = avatar_x;
        this.y = avatar_y;
        direction[0] = mouse_x - avatar_x;
        direction[1] = mouse_y - avatar_y;
    }
    
    public int[] getDirection(){
        return this.direction;
    }
    
    public void setDirection(){
    
    }
}

package Hack_NC_Game;

import java.math;

public abstract class Projectile{

    private int x;
    private int y;
    private double speed, direction;
    
    public Projectile(int avatar_x, int avatar_y, int mouse_x, int mouse_y){
        this.x = avatar_x;
        this.y = avatar_y;
        int x_change = mouse_x - avatar_x;
        int y_change = mouse_y - avatar_y;
        direction = Math.atan(y_change/(float)x_change);
    }
    
    public double getDirection(){
        return this.direction;
    }
    abstract public int getX();
    abstract public int getY();
    
    public void setDirection(int angle_change){
        direction += angle_change;
    }
    abstract public void create();
    
    public void Update(){
        // Moves the projectile.
        double delta_x = speed*Math.cos(direction);
        double delta_y = speed*Math.sin(direction);
        
        x += (int)delta_x;
        y += (int)delta_y;
    }
}

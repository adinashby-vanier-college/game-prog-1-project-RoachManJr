import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BulletHorse1 extends Knight
{
    private int centerX;  
    private int centerY;  
    private float angle;  
    private float radius;  
    private float speed;   
    private int lifespan;
    public BulletHorse1(int centerX, int centerY, float radius, float speed) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.speed = speed;
        this.angle = 0; 
        this.lifespan = 7 * 60;
    }
    public void act()
    {
        angle += speed * Math.PI / 180; 
        int bulletX = centerX + (int)(radius * Math.cos(angle));
        int bulletY = centerY + (int)(radius * Math.sin(angle));
        setLocation(bulletX, bulletY);
    
        lifespan--;
        if (lifespan <= 0 || isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
    public void updateCenter(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    
    
    }
}



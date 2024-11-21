import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Boss_3_1 extends NPCs
{
    int shootCooldown;
    /**
     * Act - do whatever the Boss_3_1 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shoot();
    }
    private void shoot()
    {
        shootCooldown++;
        if (shootCooldown >= 40) {
            shootCooldown = 0; 
            
            RookBullet rightBullet = new RookBullet(0);
            RookBullet topBullet = new RookBullet(1);
            RookBullet bottomBullet = new RookBullet(2);
            RookBullet leftBullet = new RookBullet(3);
    
            
            getWorld().addObject(rightBullet, getX(), getY());
            getWorld().addObject(topBullet, getX(), getY());
            getWorld().addObject(bottomBullet, getX(), getY());
            getWorld().addObject(leftBullet, getX(), getY());
            
            BishopBullet bulletTL = new BishopBullet(-4, -4);  // Top-left
            getWorld().addObject(bulletTL, getX(), getY());

            BishopBullet bulletTR = new BishopBullet(4, -4);   // Top-right
            getWorld().addObject(bulletTR, getX(), getY());

            BishopBullet bulletBR = new BishopBullet(4, 4);    // Bottom-right
            getWorld().addObject(bulletBR, getX(), getY());

            BishopBullet bulletBL = new BishopBullet(-4, 4);   // Bottom-left
            getWorld().addObject(bulletBL, getX(), getY());
        }
    }
}

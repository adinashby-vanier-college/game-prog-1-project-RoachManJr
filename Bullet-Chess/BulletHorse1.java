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
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
            return;
        }

        checkForProjectileCollision2();
    }

    public void updateCenter(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    private void checkForProjectileCollision2()
    {
        if (getWorld() == null) {
            return; 
        }

        java.util.List<projectile> projectiles = getWorld().getObjects(projectile.class);
        for (projectile proj : projectiles)
        {
            if (isTouching(projectile.class)) 
            { 
                getWorld().removeObject(proj);
            }
        }

        java.util.List<AOE> AOES = getWorld().getObjects(AOE.class);
        for (AOE aoe : AOES)
        {
            if (isTouching(AOE.class)) 
            {
                getWorld().removeObject(aoe);
            }
        }

        java.util.List<BoomerangShot> BoomerangShots = getWorld().getObjects(BoomerangShot.class);
        for (BoomerangShot boomerangShot : BoomerangShots)
        {
            if (isTouching(BoomerangShot.class)) 
            { 
                getWorld().removeObject(boomerangShot);
            }
        }

        java.util.List<ReturningBoomerangShot> ReturningBoomerangShots = getWorld().getObjects(ReturningBoomerangShot.class);
        for (ReturningBoomerangShot returningBoomerangShot : ReturningBoomerangShots)
        {
            if (isTouching(ReturningBoomerangShot.class)) 
            {
                getWorld().removeObject(returningBoomerangShot);
            }
        }

        java.util.List<TripleShotProjectile> TripleShotProjectiles = getWorld().getObjects(TripleShotProjectile.class);
        for (TripleShotProjectile tripleshotProjectile : TripleShotProjectiles)
        {
            if (isTouching(TripleShotProjectile.class)) 
            { 
                getWorld().removeObject(tripleshotProjectile);
            }
        }
    }
}



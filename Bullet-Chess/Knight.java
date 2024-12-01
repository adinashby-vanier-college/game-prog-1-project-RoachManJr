import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class Knight extends NPCs
{
    private BulletHorse1 bulletHorse1; 
    private int x;
    private int y;
    private float radius = 75;    
    private float speed = 8;       
    private int step = 0;
    private int direction;
    int moveDelay = 50;
    int cooldownCounter = 0;
    int move1Delay = 800;
    int cooldownCounter1 = 0;
    int cooldownCounter2 = 0;
    private Player player;
    private int health = 75; 
    private HealthBarKnight healthBar; 
    
    public Knight()
    {
        healthBar = new HealthBarKnight(75);
    }

    public void act()
    {
        if (health <= 0) {
            if (healthBar.getWorld() != null) {
                getWorld().removeObject(healthBar);
                getWorld().removeObject(bulletHorse1);
            }
            getWorld().removeObject(this);
            return;
        }

        if (cooldownCounter1 <= 0) {
            move1();
            cooldownCounter1 = move1Delay;
        }
        if (cooldownCounter1 > 0) {
            cooldownCounter1--;
        }
        if (cooldownCounter <= 0) {
            move2();
            cooldownCounter = moveDelay;
        }
        if (cooldownCounter > 0) {
            cooldownCounter--;
        }
        if (bulletHorse1 != null) {
            bulletHorse1.updateCenter(getX(), getY());
        }
        move3();
        
        if (getWorld() != null) {
            if (healthBar.getWorld() == null) {
                getWorld().addObject(healthBar, 250 , 20); 
            }
            checkForProjectileCollision();
        }
    }

    public void move1()
    {
        bulletHorse1 = new BulletHorse1(getX(), getY(), radius, speed);
        getWorld().addObject(bulletHorse1, getX(), getY());
    }

    public void move2()
    {
        player = (Player) getWorld().getObjects(Player.class).get(0); 
        if (player != null) {
            int playerX = player.getX();
            int playerY = player.getY();
            double angle = Math.atan2(playerY - getY(), playerX - getX());
            BulletHorse2 bulletHorse2 = new BulletHorse2(getX(), getY(), angle, speed); 
            getWorld().addObject(bulletHorse2, getX(), getY()); 
        }
    }

    public void move3() 
    {
        cooldownCounter2++;
        if (cooldownCounter2 == 10) {
            cooldownCounter2 = 0;
            BulletHorse3 bullet = new BulletHorse3(); 
            int randomDirection = Greenfoot.getRandomNumber(360); 
            bullet.setRotation(randomDirection); 
            getWorld().addObject(bullet, getX(), getY());
        }
    }

    private void checkForProjectileCollision()
    {
        java.util.List<projectile> projectiles = getWorld().getObjects(projectile.class);
        for (projectile proj : projectiles)
        {
            if (isTouching(projectile.class)) 
            {
                health -= 1;
                healthBar.decreaseHealth(1); 
                getWorld().removeObject(proj);
            }
        }
        java.util.List<AOE> AOES = getWorld().getObjects(AOE.class);
        for (AOE aoe : AOES)
        {
            if (isTouching(AOE.class)) 
            {
                health -= 1;
                healthBar.decreaseHealth(1); 
                getWorld().removeObject(aoe);
            }
        }
        java.util.List<BoomerangShot> BoomerangShots = getWorld().getObjects(BoomerangShot.class);
        for (BoomerangShot boomerangShot : BoomerangShots)
        {
            if (isTouching(BoomerangShot.class)) 
            {
                health -= 3;
                healthBar.decreaseHealth(3); 
                getWorld().removeObject(boomerangShot);
            }
        }
        java.util.List<ReturningBoomerangShot> ReturningBoomerangShots = getWorld().getObjects(ReturningBoomerangShot.class);
        for (ReturningBoomerangShot returningBoomerangShot : ReturningBoomerangShots)
        {
            if (isTouching(ReturningBoomerangShot.class)) 
            {
                health -= 3;
                healthBar.decreaseHealth(3); 
                getWorld().removeObject(returningBoomerangShot);
            }
        }
        java.util.List<TripleShotProjectile> TripleShotProjectiles = getWorld().getObjects(TripleShotProjectile.class);
        for (TripleShotProjectile tripleshotProjectile : TripleShotProjectiles)
        {
            if (isTouching(TripleShotProjectile.class)) 
            {
                health -= 1;
                healthBar.decreaseHealth(1); 
                getWorld().removeObject(tripleshotProjectile);
            }
        }
    }
}




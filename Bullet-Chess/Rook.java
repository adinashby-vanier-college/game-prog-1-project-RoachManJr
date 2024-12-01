import greenfoot.*;
public class Rook extends NPCs
{
    private int targetX, targetY;
    private int speed = 2;  
    int shooting = 40;
    int cooldownShooting = 0;
    
    private int health = 45; 
    private HealthBarRook healthBar;
    public Rook()
    {
        
        targetX = 500;
        targetY = 350;
        
        healthBar = new HealthBarRook(45);
    }

    public void act()
    {
        
        if (health <= 0) {
            if (healthBar.getWorld() != null) {
                getWorld().removeObject(healthBar);
            }
            getWorld().removeObject(this);
            return;
        }
        
        moveToTarget();
        
        if (atTarget())
        {
            moveToRandomHorizontal();
        }
        if (cooldownShooting<= 0) {
            shoot();
            cooldownShooting= shooting;
            }
        if (cooldownShooting > 0) {
                cooldownShooting--;
            }
            
            if (getWorld() != null) {
            if (healthBar.getWorld() == null) {
                getWorld().addObject(healthBar, 700 , 20); 
            }
            checkForProjectileCollision();
        }
    }

    private void moveToTarget()
    {
        int currentX = getX();
        int currentY = getY();

        
        if (currentX < targetX)
            setLocation(currentX + speed, currentY);
        else if (currentX > targetX)
            setLocation(currentX - speed, currentY);

        if (currentY < targetY)
            setLocation(currentX, currentY + speed);
        else if (currentY > targetY)
            setLocation(currentX, currentY - speed);
    }

    
    private boolean atTarget()
    {
        return (Math.abs(getX() - targetX) <= speed) && (Math.abs(getY() - targetY) <= speed);
    }

    
    private void moveToRandomHorizontal()
    {
        
        int worldWidth = getWorld().getWidth();
        int worldHeight = getWorld().getHeight();

        if (worldWidth > 0 && worldHeight > 0)
        {
            
            int direction = Greenfoot.getRandomNumber(4); 
            switch (direction)
            {
                case 0:  // Top-left horizontal
                    targetX = 100;
                    targetY = 200;
                    break;
                case 1:  // Top-right horizontal
                    targetX = 900;
                    targetY = 200;
                    break;
                case 2:  // Bottom-left horizontal
                    targetX = 100;
                    targetY = 600;
                    break;
                case 3:  // Bottom-right horizontal
                    targetX = 900;
                    targetY = 600;
                    break;
            }
        }
        else
        {
            
            targetX = getWorld().getWidth() / 2;
            targetY = getWorld().getHeight() / 2;
        }
    }

    
    private void shoot()
    {
        
        RookBullet rightBullet = new RookBullet(0);
        RookBullet topBullet = new RookBullet(1);
        RookBullet bottomBullet = new RookBullet(2);
        RookBullet leftBullet = new RookBullet(3);

        
        getWorld().addObject(rightBullet, getX(), getY());
        getWorld().addObject(topBullet, getX(), getY());
        getWorld().addObject(bottomBullet, getX(), getY());
        getWorld().addObject(leftBullet, getX(), getY());
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
import greenfoot.*;  
import java.util.Random;  

public class Bishop extends NPCs {
    
    private int[] center = {500, 350}; 

    
    private int[][] corners = {
        {100, 200},      
        {900, 200},    
        {100, 600},    
        {900, 600}   
    };

    private int currentCornerIndex = 0;  
    private boolean isMoving = false;    
    private int[] targetPosition;        
    private int moveSpeed = 3;           
    private int shootCooldown = 0;
    
    private int health = 45; 
    private HealthBarBishop healthBar;
    
    public Bishop()
    {
        healthBar = new HealthBarBishop(45);
    }

    public void act() {
        
        if (health <= 0) {
            if (healthBar.getWorld() != null) {
                getWorld().removeObject(healthBar);
            }
            getWorld().removeObject(this);
            return;
        }
        
        
        if (getWorld() == null) return;  

        
        if (!isMoving) {
            if (targetPosition == null || targetPosition == center) {
                moveToNextCorner();  
            } else {
                moveToCenter(); 
            }
        }

        
        if (isMoving) {
            moveTowardsTarget();
        }

        
        if (reachedTarget()) {
            isMoving = false; 

            
            if (targetPosition == center) {
                currentCornerIndex = (currentCornerIndex + 1) % corners.length;  
            }
        }

        
        shootBullets();
        
        if (getWorld() != null) {
            if (healthBar.getWorld() == null) {
                getWorld().addObject(healthBar, 250 , 20); 
            }
            checkForProjectileCollision();
        }
    }

    
    private void moveToNextCorner() {
        targetPosition = corners[currentCornerIndex]; 
        isMoving = true;  
    }

    
    private void moveToCenter() {
        targetPosition = center;  
        isMoving = true;  
    }

    
    private void moveTowardsTarget() {
        int x = getX();
        int y = getY();
        int targetX = targetPosition[0];
        int targetY = targetPosition[1];

        
        double angle = Math.atan2(targetY - y, targetX - x);  
        double moveX = Math.cos(angle) * moveSpeed;  
        double moveY = Math.sin(angle) * moveSpeed;  

        
        setLocation(x + (int) moveX, y + (int) moveY);
    }

    
    private boolean reachedTarget() {
        
        return Math.abs(getX() - targetPosition[0]) <= moveSpeed && Math.abs(getY() - targetPosition[1]) <= moveSpeed;
    }

    
    private void shootBullets() {
        shootCooldown++;  
        if (shootCooldown >= 40) {  
            shootCooldown = 0;  

            
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

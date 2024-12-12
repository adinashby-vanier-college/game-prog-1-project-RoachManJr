import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class QueenPhase2 extends NPCs
{
    int shootCooldown;
    int shootCooldown2;
    int shootCooldown3;
    int shootCooldown4;
    int shootCooldown5;
    int shootCooldown6;
    
    private boolean isDead = false; // Flag to track if the Queen is dead
    
    
    private QueenShield queenShield;
    private QueenShield2 queenShield2;
    private float radius = 75;
    private float radius2 = 105;
    
    private float speed = 8;
    private float speed2 = 4;
    private Player player;
    private int x;
    private int y;
    
    
    private int[] center = {500, 400}; 

    
    private int[][] corners = {
        {100, 200}, // top left
        {500,200}, //top
        {900, 200}, //top right 
        {900,400}, //right
        {100, 600}, //bottom left 
        {500,600}, //bottom
        {900, 600},  //bottom right
        {100, 400} // left
        
    };

    private int currentCornerIndex = 0;  
    private boolean isMoving = false;    
    private int[] targetPosition;        
    private int moveSpeed = 3; 
    
    private int health = 100; 
    private HealthBarQueenPhase2 healthBar;
    
    
    
    public QueenPhase2()
    {
        healthBar = new HealthBarQueenPhase2(100);
    }
    /**
     * Act - do whatever the Boss_3_1 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkHealth(); // Check if the Queen has died
        if (health <= 0) {
            if (healthBar.getWorld() != null) {
                getWorld().removeObject(healthBar);
                getWorld().removeObject(queenShield);
            }
            getWorld().removeObject(this);
            return;
        }
        shoot1();
        shoot2();
        shoot3();
        shoot4();
        shoot5();
        shoot6();
        if (queenShield != null) {
            queenShield.updateCenter(getX(), getY());
        }
        if (queenShield2 != null) {
            queenShield2.updateCenter(getX(), getY());
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
        if (getWorld() != null) {
            if (healthBar.getWorld() == null) {
                getWorld().addObject(healthBar, 250 , 20); 
            }
            checkForProjectileCollision();
        }
    }
    /**
     * Checks the health of the Queen and transitions to GameWonScreen if health is 0.
     */
    private void checkHealth()
    {
        if (!isDead && getHealth() <= 0) // Assuming `getHealth()` is a method in the `Queen` class
        {
            isDead = true; // Mark the Queen as dead to prevent multiple triggers
            transitionToGameWonScreen();
        }
    }

    /**
     * Handles the transition to the GameWonScreen.
     */
    private void transitionToGameWonScreen()
    {
        Greenfoot.setWorld(new GameWonScreen()); // Assuming GameWonScreen is a World subclass
    }

    /**
     * Placeholder for getting health. Replace this with actual health logic from the `Queen` class.
     */
    public int getHealth()
    {
        // Replace this with the actual implementation to retrieve the Queen's health
        return health; // Example: Queen is dead
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
    private void shoot1()
    {
        shootCooldown++;
        if (shootCooldown >= 60) {
            shootCooldown = 0; 
            
            QueenBulletLines rightBullet = new QueenBulletLines(0);
            QueenBulletLines topBullet = new QueenBulletLines(1);
            QueenBulletLines bottomBullet = new QueenBulletLines(2);
            QueenBulletLines leftBullet = new QueenBulletLines(3);
    
            
            getWorld().addObject(rightBullet, getX(), getY());
            getWorld().addObject(topBullet, getX(), getY());
            getWorld().addObject(bottomBullet, getX(), getY());
            getWorld().addObject(leftBullet, getX(), getY());
            
        
        }
    }
    private void shoot2(){
        shootCooldown2++;
            if (shootCooldown2 >= 60) {
            shootCooldown2 = 0;   
                
                
            QueenBulletSides bulletTL = new QueenBulletSides(-5, -5);  // Top-left
            getWorld().addObject(bulletTL, getX(), getY());

            QueenBulletSides bulletTR = new QueenBulletSides(5, -5);   // Top-right
            getWorld().addObject(bulletTR, getX(), getY());

            QueenBulletSides bulletBR = new QueenBulletSides(5, 5);    // Bottom-right
            getWorld().addObject(bulletBR, getX(), getY());

            QueenBulletSides bulletBL = new QueenBulletSides(-5, 5);   // Bottom-left
            getWorld().addObject(bulletBL, getX(), getY());
        }
    }
    public void shoot3()
    {
        shootCooldown3++;
        if ( shootCooldown3 >= 550) {
            shootCooldown3 = 0;
            queenShield = new QueenShield(getX(), getY(), radius, speed);
            getWorld().addObject(queenShield, getX(), getY());
            
        }
    }

    /**
     * Second move: Shoot bullets at the Player.
     */
    public void shoot4()
    {
        shootCooldown4++;
        if (shootCooldown4 >= 100) {
            player = (Player) getWorld().getObjects(Player.class).get(0); 
            shootCooldown4 = 0;
            if (player != null) {
                
                int playerX = player.getX();
                int playerY = player.getY();
                
                double angle = Math.atan2(playerY - getY(), playerX - getX());
    
                QueenBulletTracker queenBulletTracker = new QueenBulletTracker(getX(), getY(), angle, speed); 
                getWorld().addObject(queenBulletTracker, getX(), getY()); 
                }
        }
    }
    
    public void shoot5(){
        shootCooldown5++;
        if (shootCooldown5 == 40) {
            shootCooldown5 = 0;
            QueenBulletRandom bullet = new QueenBulletRandom(); 
            int randomDirection = Greenfoot.getRandomNumber(360); 
            bullet.setRotation(randomDirection); 
            getWorld().addObject(bullet, getX(), getY());
        }
    }
    
    public void shoot6()
    {
        shootCooldown6++;
        if ( shootCooldown6 >= 550) {
            shootCooldown6 = 0;
            queenShield2 = new QueenShield2(getX(), getY(), radius2, speed2);
            getWorld().addObject(queenShield2, getX(), getY());
            
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

    

import greenfoot.*;  
import java.util.Random;  

public class MiniBishop_2M_D extends Bishop {
    private int[] center = {470, 500}; 

    private int[][] corners = {
        {280, 513},      // l
        {472, 407},      // u
        {660, 509},      // r
        {472, 636}       // d
    };

    private int currentCornerIndex = 0;  
    private boolean isMoving = false;    
    private int[] targetPosition;        
    private int moveSpeed = 3;           
    private int shootCooldown = 0;       

    private int health = 6; 
    private HealthBar healthBar;
    private int targetX, targetY;
    private int speed = 2;

    public MiniBishop_2M_D() {
        targetX = 830;
        targetY = 840;
        healthBar = new HealthBar(6);
        healthBar.setOwner(this); 
    }
    
    public void addedToWorld(World world) {
        world.addObject(healthBar, getX(), getY() - 30);
    }
    
    public void act() {
        if (health <= 0) {
            removeSelf();
            return; 
        }

        
        if (getWorld() == null) return;

        updateHealthBar();

        if (!isMoving) {
            moveToNextCorner();
        } else {
            moveTowardsTarget();
        }

        if (reachedTarget()) {
            isMoving = false;
            currentCornerIndex = (currentCornerIndex + 1) % corners.length;  
        }

        checkForProjectileCollision();
        shootBullets();
    }
    
    private void updateHealthBar() {
        if (healthBar.getWorld() != null) {
            healthBar.setLocation(getX(), getY() - 30); 
        }
    }

    private void removeSelf() {
        if (healthBar != null && healthBar.getWorld() != null) {
            getWorld().removeObject(healthBar);
        }
        if (getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
    
    private void moveToTarget() {
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
    
    private void moveToNextCorner() {
        targetPosition = corners[currentCornerIndex]; 
        isMoving = true;  
    }

    private void moveTowardsTarget() {
        if (getWorld() == null) return;  

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
    
    private void checkForProjectileCollision() {
        if (isTouching(projectile.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(projectile.class);
        }
        if (isTouching(AOE.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(AOE.class);
        }
        if (isTouching(BoomerangShot.class)) {
            health -= 3;
            healthBar.decreaseHealth(3); 
            removeTouching(BoomerangShot.class);
        }
        if (isTouching(ReturningBoomerangShot.class)) {
            health -= 3;
            healthBar.decreaseHealth(3); 
            removeTouching(ReturningBoomerangShot.class);
        }
        if (isTouching(TripleShotProjectile.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(TripleShotProjectile.class);
        }
    }
}

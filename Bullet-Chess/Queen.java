import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Queen extends NPCs
{
    int shootCooldown;
    int shootCooldown2;
    int shootCooldown3;
    int shootCooldown4;
    
    
    private BulletHorse1 bulletHorse1;
    private float radius = 75;    
    private float speed = 8; 
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
    /**
     * Act - do whatever the Boss_3_1 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shoot1();
        shoot2();
        shoot3();
        shoot4();
        if (bulletHorse1 != null) {
            bulletHorse1.updateCenter(getX(), getY());
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
            
        
        }
    }
    private void shoot2(){
        shootCooldown2++;
            if (shootCooldown2 >= 100) {
            shootCooldown2 = 0;   
                
                
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
    public void shoot3()
    {
        shootCooldown3++;
        if ( shootCooldown3 >= 550) {
            shootCooldown3 = 0;
            bulletHorse1 = new BulletHorse1(getX(), getY(), radius, speed);
            getWorld().addObject(bulletHorse1, getX(), getY());
        }
    }

    /**
     * Second move: Shoot bullets at the Player.
     */
    public void shoot4()
    {
        shootCooldown4++;
        if (shootCooldown4 >= 90) {
            player = (Player) getWorld().getObjects(Player.class).get(0); 
            shootCooldown4 = 0;
            if (player != null) {
                
                int playerX = player.getX();
                int playerY = player.getY();
                
                double angle = Math.atan2(playerY - getY(), playerX - getX());
    
                BulletHorse2 bulletHorse2 = new BulletHorse2(getX(), getY(), angle, speed); 
                getWorld().addObject(bulletHorse2, getX(), getY()); 
                }
        }
    }
}


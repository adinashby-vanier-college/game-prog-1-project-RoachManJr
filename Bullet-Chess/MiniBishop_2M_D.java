import greenfoot.*;  
import java.util.Random;  

public class MiniBishop_2M_D extends Bishop {
    
    private int[] center = {470, 500}; 

    
    private int[][] corners = {
        {280, 513},      //l
        {472, 407},    //u
        {660, 509},   //r
        {472, 636}      //d
    };

    private int currentCornerIndex = 0;  
    private boolean isMoving = false;    
    private int[] targetPosition;        
    private int moveSpeed = 3;           
    private int shootCooldown = 0;       

    public void act() {
        if (getWorld() == null) return;  

        
        if (!isMoving) {
            if (targetPosition == null || targetPosition == center) {
                moveToNextCorner();  
            } else {
                //moveToCenter(); 
                moveToNextCorner();  
            }
        }

        
        if (isMoving) {
            moveTowardsTarget();
        }

        
        if (reachedTarget()) {
            isMoving = false; 

            
            if (targetPosition == corners[currentCornerIndex]) {
                currentCornerIndex = (currentCornerIndex + 1) % corners.length;  
            }
        }

        
        shootBullets();
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
}

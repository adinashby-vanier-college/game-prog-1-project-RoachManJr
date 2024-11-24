import greenfoot.*;
public class MiniRook extends Rook
{
    private int targetX, targetY;
    private int speed = 2;  
    int shooting = 40;
    int cooldownShooting = -10;
    public MiniRook()
    {
        
        targetX = 500;
        targetY = 350;
    }

    public void act()
    {
        
        moveToTarget();
        
        if (atTarget())
        {
            moveToRandomHorizontal();
        }
        if (cooldownShooting<= -10) {
            shoot();
            cooldownShooting= shooting;
            }
        if (cooldownShooting > -10) {
                cooldownShooting--;
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
}

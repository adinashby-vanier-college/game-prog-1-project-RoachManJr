import greenfoot.*;
public class MiniRook_2_1_Bottom extends Rook
{
    private int targetX, targetY;
    private int speed = 2;  
    int shooting = 40;
    int cooldownShooting = -10;
    public MiniRook_2_1_Bottom()
    {
        
        targetX = 470;
        targetY = 547;
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
            
            int direction = Greenfoot.getRandomNumber(2); 
            switch (direction)
            {
                case 0:  // Top-left horizontal
                    targetX = 78;
                    targetY = 547;
                    break;
                case 1:  // Top-right horizontal
                    targetX = 460;
                    targetY = 547;
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

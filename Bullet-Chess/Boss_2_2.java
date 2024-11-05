import greenfoot.*;  // Importing the Greenfoot package

public class Boss_2_2 extends Actor
{
    private int targetX, targetY;
    private int speed = 2;  // Rook moves slowly at this speed

    
    public Boss_2_2()
    {
        // Set initial target to the center of the world
        targetX = 400;
        targetY = 300;
    }

    public void act()
    {
        // Move towards the current target (horizontal edge or center)
        moveToTarget();

        // If reached target, move to a random diagonal direction
        if (atTarget())
        {
            moveToRandomHorizontal();
        }
    }

    // Move the Rook towards the current target
    private void moveToTarget()
    {
        int currentX = getX();
        int currentY = getY();

        // Calculate movement towards the target in both x and y direction
        if (currentX < targetX)
            setLocation(currentX + speed, currentY);
        else if (currentX > targetX)
            setLocation(currentX - speed, currentY);

        if (currentY < targetY)
            setLocation(currentX, currentY + speed);
        else if (currentY > targetY)
            setLocation(currentX, currentY - speed);
    }

    // Check if the Rook has reached the target
    private boolean atTarget()
    {
        return (Math.abs(getX() - targetX) <= speed) && (Math.abs(getY() - targetY) <= speed);
    }

    // Move the Rook to a random horizontal direction (either top-left, top-right, bottom-left, or bottom-right)
    private void moveToRandomHorizontal()
    {
        // Get the world width and height to avoid null pointer issues
        int worldWidth = getWorld().getWidth();
        int worldHeight = getWorld().getHeight();

        // Ensure that worldWidth and worldHeight are valid
        if (worldWidth > 0 && worldHeight > 0)
        {
            // Randomly choose a horizontal direction
            int direction = Greenfoot.getRandomNumber(4);  // Picks a random number from 0 to 3

            switch (direction)
            {
                case 0:  // Top-left horizontal
                    targetX = 100;
                    targetY = 100;
                    break;
                case 1:  // Top-right horizontal
                    targetX = 700;
                    targetY = 100;
                    break;
                case 2:  // Bottom-left horizontal
                    targetX = 100;
                    targetY = 500;
                    break;
                case 3:  // Bottom-right horizontal
                    targetX = 500;
                    targetY = 500;
                    break;
            }
        }
        else
        {
            // If the world dimensions are invalid (shouldn't happen), use default center values
            targetX = getWorld().getWidth() / 2;
            targetY = getWorld().getHeight() / 2;
        }
    }
}
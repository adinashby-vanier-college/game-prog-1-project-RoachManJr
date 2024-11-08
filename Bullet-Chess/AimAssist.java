import lang.stride.*;
import java.util.*;
import greenfoot.*;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AimAssist extends Player
{
    private int speed = 5;     // Speed of the aim-assisted projectile
    private int accuracy = 10; // Accuracy factor for aim assist (higher = more precise)

    public AimAssist()
    {
        // Optional initialization code
    }

    public void act()
    {
        moveTowardsTarget();
    }

    private void moveTowardsTarget()
    {
        // Find the first target actor
        Actor target = (Actor) getWorld().getObjects(Knight.class).get(0);

        if (target != null)
        {
            // Get the current location of the aim-assist projectile and target
            int targetX = target.getX();
            int targetY = target.getY();
            int currentX = getX();
            int currentY = getY();

            // Calculates where the target is 
            double angle = Math.atan2(targetY - currentY, targetX - currentX);

            // Convert angle to degrees
            int targetRotation = (int) Math.toDegrees(angle);
            int currentRotation = getRotation();

            // Apply AimAssist
            if (Math.abs(targetRotation - currentRotation) < accuracy)
            {
                setRotation(targetRotation);
            }
            else if (targetRotation > currentRotation)
            {
                setRotation(currentRotation + accuracy);
            }
            else
            {
                setRotation(currentRotation - accuracy);
            }

            // Move the projectile forward
            move(speed);
        }
    }
}




/*
public class AimAssist extends Actor
{

    /
*/

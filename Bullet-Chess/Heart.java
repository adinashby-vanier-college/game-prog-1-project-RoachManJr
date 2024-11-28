import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    private boolean isFull;  // True if this heart is full, false if empty

    // Constructor: set whether the heart is full or empty
    public Heart(boolean isFull)
    {
        this.isFull = isFull;
        if (isFull)
        {
            setImage("fullHeart.png");  // Full heart image (ensure this image is available)
        }
        else
        {
            setImage("emptyHeart.png");  // Empty heart image (ensure this image is available)
        }
    }

    // Method to update the heart (if needed later)
    public void updateHeart(boolean isFull)
    {
        this.isFull = isFull;
        if (isFull)
        {
            setImage("fullHeart.png");
        }
        else
        {
            setImage("emptyHeart.png");
        }
    }
}

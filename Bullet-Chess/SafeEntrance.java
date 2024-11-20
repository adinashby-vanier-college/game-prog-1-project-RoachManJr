import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SafeEntrance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SafeEntrance extends Assets
{
    public SafeEntrance() {
        this(50,50);
    }
    public SafeEntrance(int width, int height) {
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }
    public void act()
    {
        // Act - do whatever the SafeEntrance wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class titleScreen.
     */
    public TitleScreen()
    {
        super(800, 800, 1);
    }
    /**
     * Action to transition from title to first level
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new HubWorld());
    }
}

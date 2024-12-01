import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfShoot extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfShoot()
    {
        super(800, 800, 1);
        showTextWithBigBlackFont("Left-mouse click to shoot.", 140, 200);
        showTextWithSmallBlackFont("Press SPACEBAR to continue!", 200, 700);
    }

    /**
     * 
     */
    public void showTextWithBigBlackFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new  Font(50);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message, x, y);
    }
    
    public void showTextWithSmallBlackFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new  Font(30);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message, x, y);
    }
    
    /**
     * Action to transition from SystemOf to the Hub.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new HubWorld());
    }
}
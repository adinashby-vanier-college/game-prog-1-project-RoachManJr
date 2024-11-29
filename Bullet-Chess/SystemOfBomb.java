import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfBomb extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfBomb()
    {
        super(800, 800, 1);
        showTextWithBigBlackFont("Press 5 to throw a bomb.", 150, 200);
        showTextWithSmallBlackFont("Press SPACEBAR to continue!", 200, 700);
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
    
    /**
     * Action to transition from SystemOf to the Hub.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new HubWorld());
    }
}

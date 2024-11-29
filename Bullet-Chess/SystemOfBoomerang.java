import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfBoomerang extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfBoomerang()
    {
        super(800, 800, 1);
        showTextWithBigBlackFont("Press 2 to throw a boomerang.", 75, 200);
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

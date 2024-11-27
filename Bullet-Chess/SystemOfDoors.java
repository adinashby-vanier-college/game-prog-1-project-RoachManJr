import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfDoors extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfDoors()
    {
        super(800, 800, 1);
        showTextWithBigBlackFont("The boss is on the left door.", 100, 200);
        showTextWithBigBlackFont("The extra challenge is on the right.", 20, 350);
        showTextWithBigBlackFont("You can't go back.", 200, 700);
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
}


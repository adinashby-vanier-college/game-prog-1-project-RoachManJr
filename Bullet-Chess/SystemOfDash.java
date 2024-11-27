import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfDash extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfDash()
    {
        super(800, 800, 1);
        showTextWithBigBlackFont("Press Q to dash.", 220, 200);
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

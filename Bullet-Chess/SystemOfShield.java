import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfShield extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfShield()
    {
        super(800, 800, 1);
        showTextWithBigBlackFont("You win", 180, 200);
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

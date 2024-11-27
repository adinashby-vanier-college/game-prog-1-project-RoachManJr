import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfTriple extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfTriple()
    {
        super(800, 800, 1);
        showTextWithBigBlackFont("Press 3 to shoot three bullets.", 85, 200);
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

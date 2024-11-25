// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SystemOfBombs extends World
{

    /**
     * Constructor for objects of class BombSystem.
     */
    public SystemOfBombs()
    {
        super(800, 800, 1);
        showTextWithBigWhiteFont("Press 5 to throw a bomb.", 180, 200);
    }

    /**
     * 
     */
    public void showTextWithBigWhiteFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new Font(50);
        bg.setFont(font);
        bg.setColor(Color.WHITE);
        bg.drawString(message, x, y);
    }
}

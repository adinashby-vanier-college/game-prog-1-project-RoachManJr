// WARNING: This file is auto-generated and any changes to it will be overwritten
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
        showTextWithBigWhiteFont("Press 3 to shoot three bullets.", 180, 200);
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

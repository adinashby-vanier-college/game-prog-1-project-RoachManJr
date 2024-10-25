// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameWonScreen extends World
{

    /**
     * Constructor for objects of class GameWonScreen.
     */
    public GameWonScreen()
    {
        super(560, 560, 1);
        showTextWithBigWhiteFont("You win", 180, 200);
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

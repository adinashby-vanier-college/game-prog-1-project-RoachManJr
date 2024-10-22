// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     */
    public GameOverScreen()
    {
        super(600, 400, 1);
        showTextWithBigRedFont("Game Over", 180, 200);
    }

    /**
     * 
     */
    public void showTextWithBigRedFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new  Font(50);
        bg.setFont(font);
        bg.setColor(Color.RED);
        bg.drawString(message, x, y);
    }
}

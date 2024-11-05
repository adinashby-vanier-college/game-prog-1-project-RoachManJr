// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class FlashCard extends World
{
    private int timer;

    /**
     * Constructor for objects of class FlashCard.
     */
    public FlashCard()
    {
        super(800, 800, 1);
        GreenfootImage background =  new  GreenfootImage("cd3333.png");
        setBackground(background);
        timer = 0;
        prepare();
        showTextWithBigWhiteFont("Game Programming 1 420-141-VA", 135, 760);
        showTextWithBigWhiteFont2("Ehsan Hussain", 250, 350);
        showTextWithBigWhiteFont2("Lucas Coveyduck", 250, 400);
        showTextWithBigWhiteFont2("Ravneet Singh", 250, 450);
        showTextWithBigWhiteFont2("Tegran Tamrazyan", 250, 500);
    }

    /**
     * 
     */
    public void act()
    {
        timer = timer + 1;
        if (timer >= 180) {
            Greenfoot.setWorld( new  TitleScreen());
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        VanierLogo vanierLogo =  new  VanierLogo();
        addObject(vanierLogo, 400, 150);
    }

    /**
     * 
     */
    public void showTextWithBigWhiteFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new  Font(35);
        bg.setFont(font);
        bg.setColor(Color.WHITE);
        bg.drawString(message, x, y);
    }

    /**
     * 
     */
    public void showTextWithBigWhiteFont2(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new  Font(40);
        bg.setFont(font);
        bg.setColor(Color.WHITE);
        bg.drawString(message, x, y);
    }
}

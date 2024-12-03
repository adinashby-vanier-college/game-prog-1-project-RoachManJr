import greenfoot.*;  

public class HealthBarQueenPhase2 extends Actor
{
    private int health;
    private int maxHealth;
    private GreenfootImage healthBarImage;
    private GreenfootImage finalImage;
    private static final int BAR_WIDTH = 400; 
    private static final int BAR_HEIGHT = 20; 
    private static final int TICK_SPACING = 20; 

    public HealthBarQueenPhase2(int maxHealth)
    {
        this.maxHealth = maxHealth;
        this.health = maxHealth;

        healthBarImage = new GreenfootImage(BAR_WIDTH, BAR_HEIGHT);
        finalImage = new GreenfootImage(BAR_WIDTH + 60, BAR_HEIGHT + 30); 

        updateHealthBar();
    }

        public void updateHealthBar()
    {
        healthBarImage.clear();
        finalImage.clear();
    
        healthBarImage.setColor(new Color(30, 30, 30));
        healthBarImage.fillRect(0, 0, BAR_WIDTH, BAR_HEIGHT);
    
        int fillWidth = (int) ((float) health / maxHealth * BAR_WIDTH);
        for (int x = 0; x < fillWidth; x++)
        {
            float ratio = (float) x / BAR_WIDTH;
            int red = 200 + (int) (55 * (1 - ratio));
            healthBarImage.setColor(new Color(red, 0, 0));
            healthBarImage.drawLine(x, 0, x, BAR_HEIGHT);
        }
    
        healthBarImage.setColor(Color.WHITE);
    
        healthBarImage.setColor(Color.BLACK);
        GreenfootImage fontImage = new GreenfootImage("The True Essence of Caïssa", 20, Color.WHITE, null);
        int textX = (BAR_WIDTH - fontImage.getWidth()) / 13;
        int textY = (BAR_HEIGHT - fontImage.getHeight()) ;
        healthBarImage.drawImage(fontImage, textX, textY);
    
        finalImage.drawImage(healthBarImage, 30, 10);
        setImage(finalImage);
    }


    /**
     * Decrease health by a given amount.
     */
    public void decreaseHealth(int amount)
    {
        health -= amount;
        if (health < 0) health = 0;
        updateHealthBar();
    }

    /**
     * Get the current health.
     */
    public int getHealth()
    {
        return health;
    }
}


import greenfoot.*; 

public class CooldownAbilityBarBoomerang extends Actor
{
    private int cooldown;
    private int maxCooldown;
    private GreenfootImage healthBarImage;
    private GreenfootImage finalImage;
    private static final int BAR_WIDTH = 100; 
    private static final int BAR_HEIGHT = 20; 
    private static final int TICK_SPACING = 20; 

    public CooldownAbilityBarBoomerang(int maxCooldown)
    {
        this.maxCooldown = maxCooldown;
        this.cooldown = maxCooldown;

        healthBarImage = new GreenfootImage(BAR_WIDTH, BAR_HEIGHT);
        finalImage = new GreenfootImage(BAR_WIDTH + 60, BAR_HEIGHT + 30); 

        updateCooldownBar();
    }

        public void updateCooldownBar()
    {
        healthBarImage.clear();
        finalImage.clear();
    
        healthBarImage.setColor(new Color(30, 30, 30));
        healthBarImage.fillRect(0, 0, BAR_WIDTH, BAR_HEIGHT);
    
        int fillWidth = (int) ((float) cooldown / maxCooldown * BAR_WIDTH);
        for (int x = 0; x < fillWidth; x++)
        {
            float ratio = (float) x / BAR_WIDTH;
            int red = 200 + (int) (55 * (1 - ratio));
            healthBarImage.setColor(new Color(red, 0, 0));
            healthBarImage.drawLine(x, 0, x, BAR_HEIGHT);
        }
    
        healthBarImage.setColor(Color.WHITE);
    
        healthBarImage.setColor(Color.BLACK);
        GreenfootImage fontImage = new GreenfootImage("Boomerang", 20, Color.WHITE, null);
        int textX = (BAR_WIDTH - fontImage.getWidth()) / 13;
        int textY = (BAR_HEIGHT - fontImage.getHeight()) ;
        healthBarImage.drawImage(fontImage, textX, textY);
    
        finalImage.drawImage(healthBarImage, 30, 10);
        setImage(finalImage);
    }
    public void resetCooldown() {
        this.cooldown = maxCooldown;
        updateCooldownBar();
    }
    
    public void decreaseCooldown(int amount)
    {
        cooldown -= amount;
        if (cooldown < 0) cooldown = 0;
        updateCooldownBar();
    }

    
    public int getCooldown()
    {
        return cooldown;
    }
}
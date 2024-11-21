import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BossLevel3 extends World
{

    /**
     * Constructor for objects of class BossLevel3.
     */
    public BossLevel3()
    {
        super(1000, 800, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Boss_3_1 boss_3_1 = new Boss_3_1();
        addObject(boss_3_1,504,362);
        boss_3_1.setLocation(490,347);
    }
}

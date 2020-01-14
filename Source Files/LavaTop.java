import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Simple LavaTop. Player will die upon contact as described in the player class.
 */
public class LavaTop extends Actor
{
    /**
     * Act - do whatever the Lava wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public LavaTop()
    {
        GreenfootImage l = new GreenfootImage("LavaTop.png");
        setImage(l);
    }
}

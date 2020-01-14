import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the ammo counter.
 */
public class Counter extends Actor
{
    private int ammo = 25;
    /**
     * Act - do whatever the counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Ammo : " + ammo, 24, Color.WHITE, new Color(0,0,0,0))); // displays ammo
    }    
    public void loseAmmo()
    {
        ammo--;
    }
}

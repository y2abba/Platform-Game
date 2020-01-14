import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Prevents the player from obtaining the first chest in the first world.
 */
public class Roots extends Block
{
    private Roots rr;
    /**
     * Act - do whatever the Roots wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWorld().getObjects(Key.class).isEmpty())
        {
            getWorld().removeObject(this);
        }
    }    
    public Roots()
    {
        GreenfootImage r = new GreenfootImage("roots.png");
        setImage(r);
    }
}

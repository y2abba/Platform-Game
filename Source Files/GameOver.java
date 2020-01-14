import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Introduced into the game whenever the player dies. Has the option to restart or not.
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /**Removes the projectiles from the game in order for the GameOver 
        *message to be clear.
        */
        getWorld().removeObjects(getWorld().getObjects(EnemyProjectile.class));
       
        //Key commands changing the world.
        if(Greenfoot.isKeyDown("m"))
        {
            Greenfoot.setWorld(new Menu());
        }
        if(Greenfoot.isKeyDown("g") && getWorld() instanceof WorldOne)
        {
            Greenfoot.setWorld(new WorldOne());
        }
        else if(Greenfoot.isKeyDown("g") && getWorld() instanceof WorldTwo)
        {
            Greenfoot.setWorld(new WorldTwo());
        }
        else if(Greenfoot.isKeyDown("g") && getWorld() instanceof WorldThree)
        {
            Greenfoot.setWorld(new WorldThree());
        }
    }   
    
    public GameOver()
    {
        GreenfootImage g = new GreenfootImage("gameover.png");
        this.setImage(g);
    }
}

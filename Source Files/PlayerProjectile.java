import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerProjectile extends Mover
{
    //Used to check how far projectile travels.
    private int distance = 0;
    
    public PlayerProjectile()
    {
        GreenfootImage fire = new GreenfootImage("PlayerProjectileImage.png");
        this.setImage(fire);
    }
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       distance++;
       move(6.0);
       removePP();
    }
    //Removes player projectile under certain circumstances.
    private void removePP() 
    {
        Actor p2 = getOneIntersectingObject(EnemyProjectile.class);
        if(this.atWorldEdge()) 
        {
           getWorld().removeObject(this);
        }
        else if (this.getOneIntersectingObject(Block.class) != null)
        {
            getWorld().removeObject(this);
        }
        else if (distance == 120)
        {
            getWorld().removeObject(this);
        }
         else if (p2 != null)
        {
            getWorld().removeObject(p2);
            getWorld().removeObject(this);
        }
        
    }    
}

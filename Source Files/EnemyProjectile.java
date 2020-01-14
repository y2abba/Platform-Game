import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyProjectile extends Mover
{
    private int speed = 0;
    /**
     * Act - do whatever the EnemyProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Determines how fast the projectile will move
        move(speed);
        //Will be removes based on whether it intersects a block, or is at world edge.
        remove();
    }   
    //Allows other classes to change its speed.
    public EnemyProjectile(int speed1)
    {
        speed = speed1;
        GreenfootImage EPI = new GreenfootImage("EnemyProjectileImage.png");
        setImage(EPI);
    }
    private void remove()
    {
        if (this.atWorldEdge()) 
        {
           getWorld().removeObject(this);
        }
        else if (getOneIntersectingObject(Block.class) != null)
        {
            getWorld().removeObject(this);
        }
    }  
}

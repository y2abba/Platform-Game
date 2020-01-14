import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is an enemy that is NOT moving.
 */
public class StillEnemy extends Actor
{
    GreenfootImage left = new GreenfootImage("EfaceLeft.png");
    GreenfootImage right = new GreenfootImage("EfaceRight.png");

    private int counter = 0;
    private int i = 0;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkPosition();
        counter++;
    }    
    //Checks to see where it is on the terrain, and faces right or left based on its x-coordinate.
    public void checkPosition()
    {
        if (getX() < 500)
        {
            i = 0;
            if (counter % 14 == 0)
            {
                setImage(right);
            }    
            if (counter % 140 == 0)
            {
                enemyShoot();
            }
        } 
        if (getX() >= 500)
        {
            i = 2;
            if (counter % 14 == 0)
            {
                setImage(left);
            }
            if (counter % 140 == 0)
            {
                enemyShoot();
            }
        }
    }
    //Simple shot.
    private void enemyShoot()
    {
        EnemyProjectile EP = new EnemyProjectile(1);
        getWorld().addObject(EP, getX(), getY());
        EP.setRotation(90*i);
    }    
}

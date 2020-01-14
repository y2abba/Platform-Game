import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingEnemy extends Actor
{
    GreenfootImage left = new GreenfootImage("EfaceLeft.png");
    GreenfootImage right = new GreenfootImage("EfaceRight.png");
    //Initial speeds.
    private double vspeed = 0;
    private double acceleration = 0.2;
    private int maximumX;
    private int minimumX;
    //Used to determine direction of movement
    private boolean movingRight;
    //Used to move left or right
    private int i = 0;
    private int counter = 0;
    /**
     * Act - do whatever the MovingEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Counter needed to decide when to shoot
        counter++;
        //Used to move right or left, and turn.
        checkDirection();
        //Checks to see if it has been killed.
        checkDeath();
    }   
    //Two parameters are used for checkDirection()
    public MovingEnemy(int x, int mx)
    {
        maximumX = mx;
        minimumX = x;
    }
    //Moves between the max and the min, alternating in image as well.
    public void checkDirection()
    {
        if(getX() < minimumX) 
        {
           movingRight = true;
        }
        else if(getX() > maximumX)
        {
            movingRight = false;
        }
        if(movingRight)
        { 
            setLocation( getX() + 1, getY());
            setImage(right);
            if (counter % 100 == 0)
            {
                i = 0;
                fire();
            }
        }
        else if(!movingRight)
        {
            setLocation( getX() - 1, getY());
            setImage(left);
             if (counter % 100 == 0)
            {
                 i = 2; 
                 fire();
            }
        }
    }
    public void checkDeath()
    {
       //If comes into contact with PlayerProjectile, it dies.
       Actor pp = getOneIntersectingObject(PlayerProjectile.class);
       if (pp != null)
       {
           getWorld().removeObject(pp);
           getWorld().removeObject(this);
        }
    }
    private void fire()
    {
        EnemyProjectile b = new EnemyProjectile(3);
        getWorld().addObject(b, getX(), getY());
        b.setRotation(90*i);
    }
}

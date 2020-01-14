import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This tile moves between two coordinates, it acts as terrain on which the player can move.
 */
public class LongTile extends Block
{
    private int minimumX;
    private int maximumX;
    private int rightOrLeft;
    
    /**
     * Act - do whatever the movingplatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 
    public void act()
    {
        //Allows the tile to move left/right.
        if(getX() == maximumX)
        {
            rightOrLeft = -1;
        }
        else if(getX() == minimumX)
        {
            rightOrLeft = 1;
        }
        move(rightOrLeft);
    }
    //Parameters enabling the long tile to move in between two coordinates.
    public LongTile(int xMin, int xMax)
    {
        GreenfootImage t = new GreenfootImage("longtile.png");
        setImage(t);
        minimumX = xMin;
        maximumX = xMax;
    }
    
}

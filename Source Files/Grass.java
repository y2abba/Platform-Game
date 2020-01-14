import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The grass, which is the terrain that the player comes into contact with the most.
 */
public class Grass extends Block
{
    /**
     * Act - do whatever the Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    public Grass()
    {
        GreenfootImage g = new GreenfootImage("tile_01.png");
        setImage(g);
    }
}

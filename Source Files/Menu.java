import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Menu class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 950x650 cells with a cell size of 1x1 pixels.
        super(980, 700, 1);

        //Spawns the necessary objects into the world.
        GreenfootImage menuBackground = new GreenfootImage("MenuPhoto.PNG");
        setBackground(menuBackground);
        prepare();
    }

    public void act()
    {
        if ("s".equals(Greenfoot.getKey()))
        {
            Greenfoot.setWorld(new Story());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}

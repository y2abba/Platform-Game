import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldThree extends World
{
    Counter count = new Counter();
    /**
     * Constructor for objects of class WorldThree.
     * 
     */
    public WorldThree()
    {    
        // Create a new world with 980x700 cells with a cell size of 1x1 pixels.
        super(980, 700, 1); 
        
        //Set Background Image
        GreenfootImage W3 = new GreenfootImage("WorldThreeBack.png");
        setBackground(W3);
        
        //Add Player
        addObject(new Player(), 40, 600);
        //Add keys and chest
        addKC();
        //Add ammo counter
        addObject(count, 250, 600);
        //Add Final Round
        addObject(new FinalRound(), 450, 600);
        
        //Add Terrain with Enemies and Ladders
        addTerrain();
        addLadders();
    }
    
    public Counter getCounter()
    {
        return count;
    }
    
    private void addKC()
    {
        addObject(new Key(), 25, 190);
        addObject(new Key(), 25, 340);
        addObject(new Key(), 25, 490);
        
        addObject(new Chest(), 25, 43);
    }
    private void addTerrain()
    {
        int a = 680;
        for(int x = 0; x < 10; x +=2)
        {
             for (int i = 0; i < 950 ; i += 32)
             {
                addObject(new Grass(), i, a);
             }
             a -= 150;
        }
        int b = 47;
        for(int x = 0; x < 4; x++)
        {
            addObject(new MovingEnemy(30, 300), 31, b);
            addObject(new MovingEnemy(300, 600), 301, b);
            addObject(new MovingEnemy(600, 900), 601, b);
            b += 150;
        }
        for (int i = -20; i < 1000; i +=32)
        {
            addObject(new Grass(), i, 650);
        }   

        for (int i = -20; i < 1000; i +=32)
        {
          addObject(new Dirt(), i, 700);
        }
        for (int i = -20; i < 1000; i +=32)
        {
          addObject(new Dirt(), i, 680);
        }
    }
    
    private void addLadders()
    {
        int b = 700;
        for(int i = 0; i <= 40; i++)
        {
            addObject(new Ladder(), 964, b);
            b -= 16;
        }
    }
}

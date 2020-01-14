import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldOne extends World
{
    Counter count = new Counter();
    /**
     * Constructor for objects of class WorldOne.
     * 
     */
    public WorldOne()
    {    
        // Create a new world with 950x650 cells with a cell size of 1x1 pixels.
        super(980, 700, 1); 
        //Add player
        addObject(new Player(), 15, 400);
        //Add terrain
        addTerrain();
        //Add enemies
        MovingEnemy e1 = new MovingEnemy(385, 680);
        addObject(e1, 385, 490);
        MovingEnemy e2 = new MovingEnemy(615, 895);
        addObject(e2, 615, 315);
        
        //Add moving platforms
        addObject(new LongTile(205,500), 205, 140);
        addObject(new LongTile(600,895), 895, 140);
        
        //Add ammo counter
        addObject(count, 60, 25);
        
        //Add key, roots and chest
        addKRC();
        
        //Add background image
        GreenfootImage WorldOne = new GreenfootImage("World1Back.png");
        setBackground(WorldOne);
    }
    
    public Counter getCounter()
    {
        return count;
    }
    private void addKRC()
    {
        Chest c = new Chest();
        addObject(c, 445, 560);
        Key k = new Key();
        addObject (k, 930, 40);
        Roots rr = new Roots();
        addObject(rr, 385, 555);
    }
    private void addTerrain()
    {

        //Add Grass Objects
        for (int i = 0; i < 210; i +=35)
        {
          addObject(new Grass(), i, 560);
        }
        
        for (int i = 315; i < 490; i +=35)
        {
             addObject(new Grass(), i, 595);
        }
        
        for (int i = 385; i < 700; i +=35)
        {
             addObject(new Grass(), i, 525);
        }
        
        for (int i = 770; i < 840; i +=35)
        {
             addObject(new Grass(), i, 525);
        }
        
        for (int i = 910; i <= 1000; i +=35)
        {
             addObject(new Grass(), i, 525);
        }
        
        for (int i = 615; i < 930; i +=35)
        { 
             addObject(new Grass(), i, 350);
        }
        
        for (int i = 385; i < 500; i +=23)
        {
             addObject(new Grass(), i, 350);
        }
        
        int h = 175;
        for (int i = 60; i < 270; i +=35)
        {
             addObject(new Grass(), i, h);
             h+=35;
        }
        
        //Add Dirt Objects
        int b = 595;
        for (int i = 0; i < 4; i++)
        {
            for (int x = 0; x < 210; x +=35)
            {
                addObject(new Dirt(), x, b);
            }
            b += 35;
        }
        
        int a = 630;
        for (int i = 0; i < 3; i++)
        {
            for (int x = 315; x <= 455; x +=35)
            {
                addObject(new Dirt(), x, a);
            }
            a += 35;
        }
        
        int c = 560;
        for (int i = 0; i < 5; i++)
        {
            for (int x = 490; x < 700; x +=35)
            {
                addObject(new Dirt(), x, c);
            }
            c += 35;
        }
        
        int e = 560;
        for (int i = 0; i < 6; i++)
        {
            for (int x = 770; x < 840; x +=35)
            {
                addObject(new Dirt(), x, e);
            }
            e += 35;
        }
        
        int f = 560;
        for (int i = 0; i < 6; i++)
        {
            for (int x = 910; x <= 1000; x +=35)
            {
                addObject(new Dirt(), x, f);
            }
            f += 35;
        }
        
        //Add Lava Top
        for (int i = 840; i < 910; i +=35)
        {
             addObject(new LavaTop(), i, 595);
        }    
        for (int i = 700; i < 770; i +=35)
        {
             addObject(new LavaTop(), i, 595);
        }    
        for (int i = 210; i < 315; i +=35)
        {
             addObject(new LavaTop(), i, 595);
        }
        
        //Add Lava
        int j = 620;
        for (int x = 0; x < 3; x++) 
        {
            for (int i = 210; i < 315; i +=35)
            {
                 addObject(new Lava(), i, j);
            }
            for (int i = 700; i < 770; i +=35)
            {
                 addObject(new Lava(), i, j);
            }   
            for (int i = 840; i < 910; i +=35)
            {
                 addObject(new Lava(), i, j);
            }    
            j+=35;
        }
        //Add Ladders
        int p = 294;
        for (int i = 0; i < 8; i++)
        {
            addObject(new Ladder(), 930, p);
            p += 26;
        }
        
    }
    
    
}
    
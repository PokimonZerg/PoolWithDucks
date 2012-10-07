package pool;

import duck.DuckBuilder;

import system.Warehouse;

public class Main
{
    public static void main(String[] args)
    {
        Warehouse warehouse     = new Warehouse();
        DuckBuilder duckBuilder = new DuckBuilder(warehouse);
        Pool pool               = new Pool(warehouse);
        
        pool.addDuck(duckBuilder
                     .setGender(true)
                     .setPosition(200.0f, -100.0f)
                     .setDirection(30)
                     .setTexture("duck_man.png")
                     .getDuck());
        
        pool.addDuck(duckBuilder
                     .setGender(true)
                     .setPosition(250.0f, 200.0f)
                     .setDirection(60)
                     .setTexture("duck_man.png")
                     .getDuck());
        
        pool.addDuck(duckBuilder
                     .setGender(true)
                     .setPosition(-200.0f, -100.0f)
                     .setDirection(270)
                     .setTexture("duck_man.png")
                     .getDuck());
        
        pool.addDuck(duckBuilder
                     .setGender(false)
                     .setPosition(-300.0f, -0.0f)
                     .setDirection(50)
                     .setTexture("duck_wooman.png")
                     .getDuck());
        
        pool.addDuck(duckBuilder
                     .setGender(false)
                     .setPosition(0.0f, .0f)
                     .setDirection(180)
                     .setTexture("duck_wooman.png")
                     .getDuck());
        
        pool.animatePool();
    }
}

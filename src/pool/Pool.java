package pool;

import duck.Duck;

import duck.DuckBuilder;

import graphic.Sprite;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Random;

import math.Circle;
import math.Ellipse;
import math.Vector2D;

import org.lwjgl.opengl.GL11;

import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import system.Timer;
import system.Warehouse;
import system.Window;

public class Pool
{
    public Pool(Warehouse wh)
    {
        warehouse    = wh;
        timer        = new Timer();
        window       = new Window(1280, 720);
        ducks        = new ArrayList<>();
        poolPosition = new Vector2D(window.getLeft(), window.getTop());
        pool         = new Ellipse(window.getRight() - 80, window.getDown() - 45);
        poolSprite   = new Sprite(warehouse.loadTexture("pool.png"));
    }
    
    public void animatePool()
    {
        while(window.isOpen())
        { 
            poolSprite.draw(poolPosition, false);
            
            checkDuckLove();
            
            for(Duck duck: ducks)
            {
                duck.swim(timer.getDeltaTime(), pool);
                
                duck.draw();
            }
            
            window.updateSystem();
            timer.updateTime();
        }
    }
    
    public void addDuck(Duck duck)
    {
        ducks.add(duck);
    }
    
    private boolean checkDuckLove()
    {
        for(Duck oneDuck: ducks)
        {
            for(Duck twoDuck: ducks)
            {
                if(oneDuck != twoDuck)
                {
                    if(Circle.checkIntersection(oneDuck.getBoundingCircle(), oneDuck.getCenter(),
                                                twoDuck.getBoundingCircle(), twoDuck.getCenter()))
                    {
                        oneDuck.setDirection(oneDuck.getDirection() + 180.0f);
                    }
                }
            }
        }
        
        return false;
    }
    
    private Window          window;
    private ArrayList<Duck> ducks;
    private Vector2D        poolPosition;
    private Sprite          poolSprite;
    private Warehouse       warehouse;
    private Ellipse         pool;
    private Timer           timer;
}

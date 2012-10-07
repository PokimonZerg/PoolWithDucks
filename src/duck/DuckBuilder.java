package duck;

import graphic.Sprite;

import math.Circle;
import math.Vector2D;

import org.newdawn.slick.opengl.Texture;

import system.Warehouse;

public class DuckBuilder
{
    public DuckBuilder(Warehouse wh)
    {
        warehouse            = wh;
        gender               = false;
        speed                = 128.0f;
        direction            = 0;
        position             = new Vector2D();
        boundingRadius       = 64.0f;
    }
    
    public DuckBuilder setGender(boolean newGender)
    {
        gender = newGender;
        
        return this;
    }
    
    public DuckBuilder setSpeed(float newSpeed)
    {
        speed = newSpeed;
        
        return this;
    }
    
    public DuckBuilder setDirection(float newDirection)
    {
        direction = newDirection;
        
        return this;
    }
    
    public DuckBuilder setPosition(float x, float y)
    {
        position = new Vector2D(x, y);
        
        return this;
    }
    
    public DuckBuilder setBoundingRadius(float newRadius)
    {
        boundingRadius = newRadius;
        
        return this;
    }
    
    public DuckBuilder setTexture(String newTexture)
    {
        texture = newTexture;
        
        return this;
    }
    
    public Duck getDuck()
    {
        Duck duck = new Duck();
        
        duck.gender         = gender;
        duck.speed          = speed;
        duck.direction      = direction;
        duck.position       = new Vector2D(position);
        duck.boundingCircle = new Circle(boundingRadius);
        duck.sprite         = new Sprite(warehouse.loadTexture(texture));
        
        return duck;
    }
    
    private boolean   gender;
    private float     speed;
    private float     direction;
    private Vector2D  position;
    private float     boundingRadius;
    private String    texture;
    private Warehouse warehouse;
}

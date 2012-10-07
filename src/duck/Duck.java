package duck;

import graphic.Sprite;

import java.util.Random;

import math.Circle;
import math.Ellipse;
import math.Vector2D;

import org.lwjgl.opengl.GL11;

public class Duck
{
    Duck()
    {
        randomGenerator = new Random(System.nanoTime());
        directionVector = new Vector2D(1.0f, 0.0f);
    }
    
    public void draw()
    {
        sprite.draw(position, !(direction > 90.0f && direction < 270.0f));
    }
    
    public void quak()
    {
        
    }
    
    public void swim(double time, Ellipse pool)
    {
        float angle = (float)Math.toRadians((float)direction);
        float s     = (float)Math.sin(angle);
        float c     = (float)Math.cos(angle);
        
        Vector2D dir  = new Vector2D(directionVector.x * c - directionVector.y * s,
                                     directionVector.x * s + directionVector.y * c);
        
        Vector2D temp = new Vector2D(position.x + sprite.getCenterX(), position.y + sprite.getCenterY());
        temp.Add(Vector2D.Mul(dir, (float)(speed * time)));
        
        if(!pool.includePoint(temp))
        {
            position.Add(Vector2D.Mul(dir, (float)(speed * time)));
        }
        else
        {
            direction = (float)randomGenerator.nextInt(360);
        }
        
        calculateScale(pool);
        
        //drawCircle((int)getCenterX(), (int)getCenterY(), boundingCircle.getRadius());
    }
    
    private void drawCircle(int x, int y, float radius) { 
        double angle; 
        GL11.glLoadIdentity(); 
        GL11.glDisable(GL11.GL_TEXTURE_2D); 
        GL11.glColor3f(0.0f, 1.0f, 0.0f); 
        GL11.glLineWidth(3.0f); 
        GL11.glBegin(GL11.GL_LINE_LOOP); 
        for(double i = 0; i < 100; i++) { 
            angle = i * 2 * Math.PI / 100; 
            GL11.glVertex2f((float)(x + (Math.cos(angle) * radius)), (float)(y + (Math.sin(angle) * radius))); 
        } 
        GL11.glEnd(); 
        GL11.glEnable(GL11.GL_TEXTURE_2D); 
    } 
    
    public float getCenterX()
    {
        return position.x + sprite.getCenterX();
    }
    
    public float getCenterY()
    {
        return position.y + sprite.getCenterY();
    }
    
    public Vector2D getCenter()
    {
        return new Vector2D(getCenterX(), getCenterY());
    }
    
    public Vector2D getPosition()
    {
        return position;
    }
    
    public Circle getBoundingCircle()
    {
        return boundingCircle;
    }
    
    public float getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(float newSpeed)
    {
        speed = newSpeed;
    }
    
    public float getDirection()
    {
        return direction;
    }
    
    public void setDirection(float newDirection)
    {
        direction = (newDirection > 360.0f) ? newDirection - 360.0f : newDirection;
    }
    
    public Vector2D getDirectionVector()
    {
        return directionVector;
    }
    
    public boolean getGender()
    {
        return gender;
    }
    
    private void calculateScale(Ellipse pool)
    {
        float distance = Math.abs(position.y) / (pool.getYAxis() * 4.0f); // 4 random scale factor
              distance = (position.y > 0) ? 1 + distance : 1 - distance;
              
        boundingCircle.setRadius(64 * distance);
        
        sprite.setScale(distance, distance);
    }
    
    boolean  gender;
    float    direction;
    float    speed;
    Vector2D position;
    Circle   boundingCircle;
    Sprite   sprite;
    
    private Vector2D directionVector;
    private Random   randomGenerator;
}

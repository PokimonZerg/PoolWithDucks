package math;

/**
 * Standart 2d vector class
 */
public class Vector2D
{
    public float x;
    public float y;
    
    public Vector2D()
    {
        x = 0;
        y = 0;
    }
    
    public Vector2D(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Vector2D(Vector2D v)
    {
        x = v.x;
        y = v.y;
    }
    
    public Vector2D Add(Vector2D v)
    {
        x += v.x;
        y += v.y;
        
        return this;
    }
    
    public static Vector2D Sub(Vector2D v1, Vector2D v2)
    {
        return new Vector2D(v1.x - v2.x, v1.y - v2.y);
    }
    
    public static Vector2D Mul(Vector2D v, float s)
    {
        return new Vector2D(v.x * s, v.y * s);
    }
    
    public float Length()
    {
        return (float)Math.sqrt(x * x + y * y);
    }
}

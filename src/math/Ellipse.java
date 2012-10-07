package math;

public class Ellipse
{
    public Ellipse(float a, float b)
    {
        this.a = a;
        this.b = b;
    }
    
    public boolean includePoint(Vector2D point)
    {
        float result = (point.x * point.x) / (a * a) + (point.y * point.y) / (b * b);
        
        return result > 1;
    }
    
    public float getXAxis()
    {
        return a;
    }
    
    public float getYAxis()
    {
        return b;
    }
    
    private float a;
    private float b;
}

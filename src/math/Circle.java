package math;

public class Circle
{
    public Circle(float radius)
    {
        this.radius = radius;
    }
    
    public static boolean checkIntersection(Circle c1, Vector2D v1, Circle c2, Vector2D v2)
    {
        if(Vector2D.Sub(v2, v1).Length() <= c1.radius + c2.radius)
            return true;
        else
            return false;
    }
    
    public float getRadius()
    {
        return radius;
    }
    
    public void setRadius(float newRadius)
    {
        radius = newRadius;
    }
    
    private float radius;
}

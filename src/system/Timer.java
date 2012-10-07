package system;

public class Timer
{
    public Timer()
    {
        delta    = 0;
        lastTime = System.nanoTime();
    }
    
    public void updateTime()
    {
        long time = System.nanoTime();
        
        delta = (time - lastTime) / 1_000_000_000.0f;
                                     
        lastTime = time;
    }
    
    public double getDeltaTime()
    {
        return delta;
    }
    
    private long   lastTime;
    private double delta;
}

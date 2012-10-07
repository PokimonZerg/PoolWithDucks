package system;

import math.Vector2D;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Window
{
    public Window(int width, int height)
    {
        this.width  = width;
        this.height = height;
        
        createDisplay();
        
        initOpenGL();
    }
    
    public void updateSystem()
    {
        Display.sync(100);
        Display.update();
    }
    
    public boolean isOpen()
    {
        return !Display.isCloseRequested();
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getLeft()
    {
        return -width / 2;
    }
    
    public int getRight()
    {
        return width / 2;
    }
    
    public int getTop()
    {
        return -height / 2;
    }
    
    public int getDown()
    {
        return height / 2;
    }
    
    private void initOpenGL()
    {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, width, height);
        GL11.glOrtho(getLeft(), getRight(), getDown(), getTop(), 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0f);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
    }
    
    private void createDisplay()
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(1280, 720));
            Display.setLocation(64, 64);
            Display.setFullscreen(false);
            Display.setResizable(false);
            Display.setTitle("Pool with ducks");
            Display.create();
        }
        catch(LWJGLException e)
        {
            e.printStackTrace();
        }
    }
    
    private int width;
    private int height;
}

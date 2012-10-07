package graphic;

import math.Vector2D;

import org.lwjgl.opengl.GL11;

import org.newdawn.slick.opengl.Texture;

public class Sprite
{
    public Sprite(Texture texture)
    {
        this.texture = texture;
        scale        = new Vector2D(1.0f, 1.0f);
        
        buildList();
    }
    
    public void setScale(float x, float y)
    {
        scale.x = x;
        scale.y = y;
    }
    
    public void draw(Vector2D position, boolean rotate)
    {
        texture.bind();
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        
        GL11.glLoadIdentity();
        GL11.glTranslatef(position.x + (rotate ? texture.getImageWidth() : 0), position.y, 0);
        GL11.glScalef(scale.x, scale.y, 1.0f);
        
        if(rotate)
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        
        GL11.glCallList(glList);
    }
    
    public float getCenterX()
    {
        return texture.getImageWidth() / 2.0f;
    }
    
    public float getCenterY()
    {
        return texture.getImageHeight() / 2.0f;
    }
    
    private void buildList()
    {
        glList = GL11.glGenLists(1);
        
        GL11.glNewList(glList, GL11.GL_COMPILE);
        
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(0, 0);
            GL11.glTexCoord2f(texture.getWidth(),0);
            GL11.glVertex2f(texture.getImageWidth(), 0);
            GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
            GL11.glVertex2f(texture.getImageWidth(), texture.getImageHeight());
            GL11.glTexCoord2f(0, texture.getHeight());
            GL11.glVertex2f(0, texture.getImageHeight());
        GL11.glEnd();
        
        GL11.glEndList();
    }
    
    @Override
    public void finalize()
    {
        GL11.glDeleteLists(glList, 1);
    }
    
    int              glList;
    private Vector2D scale;
    private Texture  texture;
}

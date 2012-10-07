package system;

import java.io.IOException;

import java.util.TreeMap;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Warehouse
{
    public Warehouse()
    {
        textures = new TreeMap<>();
    }
    
    public Texture loadTexture(String texture)
    {
        Texture result;
        
        if(textures.containsKey(texture))
        {
            result = textures.get(texture);
        }
        else
        {
            try
            {
                result = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(texture));
                
                textures.put(texture, result);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        
        return result;
    }
    
    private TreeMap<String, Texture> textures;
}

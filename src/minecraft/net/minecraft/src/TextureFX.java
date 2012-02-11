package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class TextureFX
{
    public byte imageData[];
    public int iconIndex;
    public boolean anaglyphEnabled;
    public int textureId;
    public int tileSize;
    public int tileImage;

    public TextureFX(int i)
    {
        imageData = new byte[1024 /*GL_FRONT_LEFT*/];
        anaglyphEnabled = false;
        textureId = 0;
        tileSize = 1;
        tileImage = 0;
        iconIndex = i;
    }

    public void onTick()
    {
    }

    public void bindImage(RenderEngine renderengine)
    {
        if (tileImage == 0)
        {
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, renderengine.getTexture("/terrain.png"));
        }
        else if (tileImage == 1)
        {
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, renderengine.getTexture("/gui/items.png"));
        }
    }
}

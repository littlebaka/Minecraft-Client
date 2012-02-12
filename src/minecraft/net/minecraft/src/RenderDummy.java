package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderDummy extends Render
{

    private ModelDummy modelDummy;

    public RenderDummy()
    {
        shadowSize = 1.0F;
        modelDummy = new ModelDummy();
    }

    public void renderDummy(EntityDummy entitydummy, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1 - 0.4F, (float)d2);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        float f2 = (float)entitydummy.dummyTimeSinceHit - f1;
        float f3 = (float)entitydummy.dummyCurrentDamage - f1;
        if(f3 < 0.0F)
        {
            f3 = 0.0F;
        }
        if(f2 > 0.0F)
        {
            GL11.glRotatef((((MathHelper.sin(f2) * f2 * f3) / 10F) * (float)entitydummy.dummyRockDirection) / 5F, 0.0F, 0.0F, 1.0F);
        }
        loadTexture("/item/dummy.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        modelDummy.render(entitydummy, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderDummy((EntityDummy)entity, d, d1, d2, f, f1);
    }
}

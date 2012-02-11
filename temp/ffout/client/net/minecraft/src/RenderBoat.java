// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelBoat, EntityBoat, MathHelper, 
//            ModelBase, Entity

public class RenderBoat extends Render
{

    protected ModelBase field_198_d;

    public RenderBoat()
    {
        field_9246_c = 0.5F;
        field_198_d = new ModelBoat();
    }

    public void func_157_a(EntityBoat entityboat, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        float f2 = (float)entityboat.func_41018_h() - f1;
        float f3 = (float)entityboat.func_41020_g() - f1;
        if(f3 < 0.0F)
        {
            f3 = 0.0F;
        }
        if(f2 > 0.0F)
        {
            GL11.glRotatef(((MathHelper.func_1106_a(f2) * f2 * f3) / 10F) * (float)entityboat.func_41016_i(), 1.0F, 0.0F, 0.0F);
        }
        func_151_a("/terrain.png");
        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        func_151_a("/item/boat.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        field_198_d.func_864_b(entityboat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_157_a((EntityBoat)entity, d, d1, d2, f, f1);
    }
}

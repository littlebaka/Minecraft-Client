// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, Tessellator, RenderManager, EntityFireball, 
//            Entity

public class RenderFireball extends Render
{

    private float field_40269_a;

    public RenderFireball(float f)
    {
        field_40269_a = f;
    }

    public void func_4012_a(EntityFireball entityfireball, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glEnable(32826);
        float f2 = field_40269_a;
        GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
        byte byte0 = 46;
        func_151_a("/gui/items.png");
        Tessellator tessellator = Tessellator.field_1512_a;
        float f3 = (float)((byte0 % 16) * 16 + 0) / 256F;
        float f4 = (float)((byte0 % 16) * 16 + 16) / 256F;
        float f5 = (float)((byte0 / 16) * 16 + 0) / 256F;
        float f6 = (float)((byte0 / 16) * 16 + 16) / 256F;
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glRotatef(180F - field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_977_b();
        tessellator.func_980_b(0.0F, 1.0F, 0.0F);
        tessellator.func_983_a(0.0F - f8, 0.0F - f9, 0.0D, f3, f6);
        tessellator.func_983_a(f7 - f8, 0.0F - f9, 0.0D, f4, f6);
        tessellator.func_983_a(f7 - f8, 1.0F - f9, 0.0D, f4, f5);
        tessellator.func_983_a(0.0F - f8, 1.0F - f9, 0.0D, f3, f5);
        tessellator.func_982_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_4012_a((EntityFireball)entity, d, d1, d2, f, f1);
    }
}

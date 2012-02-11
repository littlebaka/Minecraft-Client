// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, Tessellator, EntityPotion, PotionHelper, 
//            RenderManager, Entity

public class RenderSnowball extends Render
{

    private int field_20003_a;

    public RenderSnowball(int i)
    {
        field_20003_a = i;
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        func_151_a("/gui/items.png");
        Tessellator tessellator = Tessellator.field_1512_a;
        if(field_20003_a == 154)
        {
            int i = PotionHelper.func_40358_a(((EntityPotion)entity).func_40088_g(), false);
            float f2 = (float)(i >> 16 & 0xff) / 255F;
            float f3 = (float)(i >> 8 & 0xff) / 255F;
            float f4 = (float)(i & 0xff) / 255F;
            GL11.glColor3f(f2, f3, f4);
            GL11.glPushMatrix();
            func_40265_a(tessellator, 141);
            GL11.glPopMatrix();
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
        }
        func_40265_a(tessellator, field_20003_a);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_40265_a(Tessellator tessellator, int i)
    {
        float f = (float)((i % 16) * 16 + 0) / 256F;
        float f1 = (float)((i % 16) * 16 + 16) / 256F;
        float f2 = (float)((i / 16) * 16 + 0) / 256F;
        float f3 = (float)((i / 16) * 16 + 16) / 256F;
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180F - field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_977_b();
        tessellator.func_980_b(0.0F, 1.0F, 0.0F);
        tessellator.func_983_a(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
        tessellator.func_983_a(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
        tessellator.func_983_a(f4 - f5, f4 - f6, 0.0D, f1, f2);
        tessellator.func_983_a(0.0F - f5, f4 - f6, 0.0D, f, f2);
        tessellator.func_982_a();
    }
}

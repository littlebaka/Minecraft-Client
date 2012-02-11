// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, EntityArrow, Tessellator, MathHelper, 
//            Entity

public class RenderArrow extends Render
{

    public RenderArrow()
    {
    }

    public void func_154_a(EntityArrow entityarrow, double d, double d1, double d2, 
            float f, float f1)
    {
        func_151_a("/item/arrows.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef((entityarrow.field_603_as + (entityarrow.field_605_aq - entityarrow.field_603_as) * f1) - 90F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entityarrow.field_602_at + (entityarrow.field_604_ar - entityarrow.field_602_at) * f1, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = 0;
        float f2 = 0.0F;
        float f3 = 0.5F;
        float f4 = (float)(0 + i * 10) / 32F;
        float f5 = (float)(5 + i * 10) / 32F;
        float f6 = 0.0F;
        float f7 = 0.15625F;
        float f8 = (float)(5 + i * 10) / 32F;
        float f9 = (float)(10 + i * 10) / 32F;
        float f10 = 0.05625F;
        GL11.glEnable(32826);
        float f11 = (float)entityarrow.field_688_a - f1;
        if(f11 > 0.0F)
        {
            float f12 = -MathHelper.func_1106_a(f11 * 3F) * f11;
            GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
        }
        GL11.glRotatef(45F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4F, 0.0F, 0.0F);
        GL11.glNormal3f(f10, 0.0F, 0.0F);
        tessellator.func_977_b();
        tessellator.func_983_a(-7D, -2D, -2D, f6, f8);
        tessellator.func_983_a(-7D, -2D, 2D, f7, f8);
        tessellator.func_983_a(-7D, 2D, 2D, f7, f9);
        tessellator.func_983_a(-7D, 2D, -2D, f6, f9);
        tessellator.func_982_a();
        GL11.glNormal3f(-f10, 0.0F, 0.0F);
        tessellator.func_977_b();
        tessellator.func_983_a(-7D, 2D, -2D, f6, f8);
        tessellator.func_983_a(-7D, 2D, 2D, f7, f8);
        tessellator.func_983_a(-7D, -2D, 2D, f7, f9);
        tessellator.func_983_a(-7D, -2D, -2D, f6, f9);
        tessellator.func_982_a();
        for(int j = 0; j < 4; j++)
        {
            GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f10);
            tessellator.func_977_b();
            tessellator.func_983_a(-8D, -2D, 0.0D, f2, f4);
            tessellator.func_983_a(8D, -2D, 0.0D, f3, f4);
            tessellator.func_983_a(8D, 2D, 0.0D, f3, f5);
            tessellator.func_983_a(-8D, 2D, 0.0D, f2, f5);
            tessellator.func_982_a();
        }

        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_154_a((EntityArrow)entity, d, d1, d2, f, f1);
    }
}

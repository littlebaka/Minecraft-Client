// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, EntityXPOrb, Tessellator, 
//            OpenGlHelper, MathHelper, RenderManager, Entity

public class RenderXPOrb extends Render
{

    private RenderBlocks field_35439_b;
    public boolean field_35440_a;

    public RenderXPOrb()
    {
        field_35439_b = new RenderBlocks();
        field_35440_a = true;
        field_9246_c = 0.15F;
        field_194_c = 0.75F;
    }

    public void func_35438_a(EntityXPOrb entityxporb, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        int i = entityxporb.func_35120_i();
        func_151_a("/item/xporb.png");
        Tessellator tessellator = Tessellator.field_1512_a;
        float f2 = (float)((i % 4) * 16 + 0) / 64F;
        float f3 = (float)((i % 4) * 16 + 16) / 64F;
        float f4 = (float)((i / 4) * 16 + 0) / 64F;
        float f5 = (float)((i / 4) * 16 + 16) / 64F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.25F;
        float f9 = entityxporb.func_35115_a(f1);
        float f10 = f9 % 0x10000;
        int j = f9 / 0x10000;
        OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)f10 / 1.0F, (float)j / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        f9 = 255F;
        f10 = ((float)entityxporb.field_35127_a + f1) / 2.0F;
        j = (int)((MathHelper.func_1106_a(f10 + 0.0F) + 1.0F) * 0.5F * f9);
        int k = (int)f9;
        int l = (int)((MathHelper.func_1106_a(f10 + 4.18879F) + 1.0F) * 0.1F * f9);
        int i1 = j << 16 | k << 8 | l;
        GL11.glRotatef(180F - field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        float f11 = 0.3F;
        GL11.glScalef(f11, f11, f11);
        tessellator.func_977_b();
        tessellator.func_6513_a(i1, 128);
        tessellator.func_980_b(0.0F, 1.0F, 0.0F);
        tessellator.func_983_a(0.0F - f7, 0.0F - f8, 0.0D, f2, f5);
        tessellator.func_983_a(f6 - f7, 0.0F - f8, 0.0D, f3, f5);
        tessellator.func_983_a(f6 - f7, 1.0F - f8, 0.0D, f3, f4);
        tessellator.func_983_a(0.0F - f7, 1.0F - f8, 0.0D, f2, f4);
        tessellator.func_982_a();
        GL11.glDisable(3042);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_35438_a((EntityXPOrb)entity, d, d1, d2, f, f1);
    }
}

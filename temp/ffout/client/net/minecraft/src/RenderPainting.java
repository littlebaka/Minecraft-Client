// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, EntityPainting, EnumArt, Tessellator, 
//            MathHelper, RenderManager, World, OpenGlHelper, 
//            Entity

public class RenderPainting extends Render
{

    private Random field_199_d;

    public RenderPainting()
    {
        field_199_d = new Random();
    }

    public void func_158_a(EntityPainting entitypainting, double d, double d1, double d2, 
            float f, float f1)
    {
        field_199_d.setSeed(187L);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
        GL11.glEnable(32826);
        func_151_a("/art/kz.png");
        EnumArt enumart = entitypainting.field_690_b;
        float f2 = 0.0625F;
        GL11.glScalef(f2, f2, f2);
        func_159_a(entitypainting, enumart.field_1623_z, enumart.field_1636_A, enumart.field_1634_B, enumart.field_1632_C);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_159_a(EntityPainting entitypainting, int i, int j, int k, int l)
    {
        float f = (float)(-i) / 2.0F;
        float f1 = (float)(-j) / 2.0F;
        float f2 = -0.5F;
        float f3 = 0.5F;
        for(int i1 = 0; i1 < i / 16; i1++)
        {
            for(int j1 = 0; j1 < j / 16; j1++)
            {
                float f4 = f + (float)((i1 + 1) * 16);
                float f5 = f + (float)(i1 * 16);
                float f6 = f1 + (float)((j1 + 1) * 16);
                float f7 = f1 + (float)(j1 * 16);
                func_160_a(entitypainting, (f4 + f5) / 2.0F, (f6 + f7) / 2.0F);
                float f8 = (float)((k + i) - i1 * 16) / 256F;
                float f9 = (float)((k + i) - (i1 + 1) * 16) / 256F;
                float f10 = (float)((l + j) - j1 * 16) / 256F;
                float f11 = (float)((l + j) - (j1 + 1) * 16) / 256F;
                float f12 = 0.75F;
                float f13 = 0.8125F;
                float f14 = 0.0F;
                float f15 = 0.0625F;
                float f16 = 0.75F;
                float f17 = 0.8125F;
                float f18 = 0.001953125F;
                float f19 = 0.001953125F;
                float f20 = 0.7519531F;
                float f21 = 0.7519531F;
                float f22 = 0.0F;
                float f23 = 0.0625F;
                Tessellator tessellator = Tessellator.field_1512_a;
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 0.0F, -1F);
                tessellator.func_983_a(f4, f7, f2, f9, f10);
                tessellator.func_983_a(f5, f7, f2, f8, f10);
                tessellator.func_983_a(f5, f6, f2, f8, f11);
                tessellator.func_983_a(f4, f6, f2, f9, f11);
                tessellator.func_980_b(0.0F, 0.0F, 1.0F);
                tessellator.func_983_a(f4, f6, f3, f12, f14);
                tessellator.func_983_a(f5, f6, f3, f13, f14);
                tessellator.func_983_a(f5, f7, f3, f13, f15);
                tessellator.func_983_a(f4, f7, f3, f12, f15);
                tessellator.func_980_b(0.0F, 1.0F, 0.0F);
                tessellator.func_983_a(f4, f6, f2, f16, f18);
                tessellator.func_983_a(f5, f6, f2, f17, f18);
                tessellator.func_983_a(f5, f6, f3, f17, f19);
                tessellator.func_983_a(f4, f6, f3, f16, f19);
                tessellator.func_980_b(0.0F, -1F, 0.0F);
                tessellator.func_983_a(f4, f7, f3, f16, f18);
                tessellator.func_983_a(f5, f7, f3, f17, f18);
                tessellator.func_983_a(f5, f7, f2, f17, f19);
                tessellator.func_983_a(f4, f7, f2, f16, f19);
                tessellator.func_980_b(-1F, 0.0F, 0.0F);
                tessellator.func_983_a(f4, f6, f3, f21, f22);
                tessellator.func_983_a(f4, f7, f3, f21, f23);
                tessellator.func_983_a(f4, f7, f2, f20, f23);
                tessellator.func_983_a(f4, f6, f2, f20, f22);
                tessellator.func_980_b(1.0F, 0.0F, 0.0F);
                tessellator.func_983_a(f5, f6, f2, f21, f22);
                tessellator.func_983_a(f5, f7, f2, f21, f23);
                tessellator.func_983_a(f5, f7, f3, f20, f23);
                tessellator.func_983_a(f5, f6, f3, f20, f22);
                tessellator.func_982_a();
            }

        }

    }

    private void func_160_a(EntityPainting entitypainting, float f, float f1)
    {
        int i = MathHelper.func_1108_b(entitypainting.field_611_ak);
        int j = MathHelper.func_1108_b(entitypainting.field_610_al + (double)(f1 / 16F));
        int k = MathHelper.func_1108_b(entitypainting.field_609_am);
        if(entitypainting.field_691_a == 0)
        {
            i = MathHelper.func_1108_b(entitypainting.field_611_ak + (double)(f / 16F));
        }
        if(entitypainting.field_691_a == 1)
        {
            k = MathHelper.func_1108_b(entitypainting.field_609_am - (double)(f / 16F));
        }
        if(entitypainting.field_691_a == 2)
        {
            i = MathHelper.func_1108_b(entitypainting.field_611_ak - (double)(f / 16F));
        }
        if(entitypainting.field_691_a == 3)
        {
            k = MathHelper.func_1108_b(entitypainting.field_609_am + (double)(f / 16F));
        }
        int l = field_191_a.field_1227_g.func_35451_b(i, j, k, 0);
        int i1 = l % 0x10000;
        int j1 = l / 0x10000;
        OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, i1, j1);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_158_a((EntityPainting)entity, d, d1, d2, f, f1);
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, Tessellator, RenderManager, EntityFishHook, 
//            EntityPlayer, MathHelper, Vec3D, GameSettings, 
//            Entity

public class RenderFish extends Render
{

    public RenderFish()
    {
    }

    public void func_4011_a(EntityFishHook entityfishhook, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        int i = 1;
        byte byte0 = 2;
        func_151_a("/particles.png");
        Tessellator tessellator = Tessellator.field_1512_a;
        float f2 = (float)(i * 8 + 0) / 128F;
        float f3 = (float)(i * 8 + 8) / 128F;
        float f4 = (float)(byte0 * 8 + 0) / 128F;
        float f5 = (float)(byte0 * 8 + 8) / 128F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.5F;
        GL11.glRotatef(180F - field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_977_b();
        tessellator.func_980_b(0.0F, 1.0F, 0.0F);
        tessellator.func_983_a(0.0F - f7, 0.0F - f8, 0.0D, f2, f5);
        tessellator.func_983_a(f6 - f7, 0.0F - f8, 0.0D, f3, f5);
        tessellator.func_983_a(f6 - f7, 1.0F - f8, 0.0D, f3, f4);
        tessellator.func_983_a(0.0F - f7, 1.0F - f8, 0.0D, f2, f4);
        tessellator.func_982_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        if(entityfishhook.field_4097_b != null)
        {
            float f9 = ((entityfishhook.field_4097_b.field_603_as + (entityfishhook.field_4097_b.field_605_aq - entityfishhook.field_4097_b.field_603_as) * f1) * 3.141593F) / 180F;
            double d3 = MathHelper.func_1106_a(f9);
            double d5 = MathHelper.func_1114_b(f9);
            float f11 = entityfishhook.field_4097_b.func_431_d(f1);
            float f12 = MathHelper.func_1106_a(MathHelper.func_1113_c(f11) * 3.141593F);
            Vec3D vec3d = Vec3D.func_1248_b(-0.5D, 0.029999999999999999D, 0.80000000000000004D);
            vec3d.func_1258_a((-(entityfishhook.field_4097_b.field_602_at + (entityfishhook.field_4097_b.field_604_ar - entityfishhook.field_4097_b.field_602_at) * f1) * 3.141593F) / 180F);
            vec3d.func_1249_b((-(entityfishhook.field_4097_b.field_603_as + (entityfishhook.field_4097_b.field_605_aq - entityfishhook.field_4097_b.field_603_as) * f1) * 3.141593F) / 180F);
            vec3d.func_1249_b(f12 * 0.5F);
            vec3d.func_1258_a(-f12 * 0.7F);
            double d7 = entityfishhook.field_4097_b.field_9285_at + (entityfishhook.field_4097_b.field_611_ak - entityfishhook.field_4097_b.field_9285_at) * (double)f1 + vec3d.field_1776_a;
            double d8 = entityfishhook.field_4097_b.field_9284_au + (entityfishhook.field_4097_b.field_610_al - entityfishhook.field_4097_b.field_9284_au) * (double)f1 + vec3d.field_1775_b;
            double d9 = entityfishhook.field_4097_b.field_9283_av + (entityfishhook.field_4097_b.field_609_am - entityfishhook.field_4097_b.field_9283_av) * (double)f1 + vec3d.field_1779_c;
            if(field_191_a.field_1223_k.field_1560_x > 0)
            {
                float f10 = ((entityfishhook.field_4097_b.field_734_o + (entityfishhook.field_4097_b.field_735_n - entityfishhook.field_4097_b.field_734_o) * f1) * 3.141593F) / 180F;
                double d4 = MathHelper.func_1106_a(f10);
                double d6 = MathHelper.func_1114_b(f10);
                d7 = (entityfishhook.field_4097_b.field_9285_at + (entityfishhook.field_4097_b.field_611_ak - entityfishhook.field_4097_b.field_9285_at) * (double)f1) - d6 * 0.34999999999999998D - d4 * 0.84999999999999998D;
                d8 = (entityfishhook.field_4097_b.field_9284_au + (entityfishhook.field_4097_b.field_610_al - entityfishhook.field_4097_b.field_9284_au) * (double)f1) - 0.45000000000000001D;
                d9 = ((entityfishhook.field_4097_b.field_9283_av + (entityfishhook.field_4097_b.field_609_am - entityfishhook.field_4097_b.field_9283_av) * (double)f1) - d4 * 0.34999999999999998D) + d6 * 0.84999999999999998D;
            }
            double d10 = entityfishhook.field_9285_at + (entityfishhook.field_611_ak - entityfishhook.field_9285_at) * (double)f1;
            double d11 = entityfishhook.field_9284_au + (entityfishhook.field_610_al - entityfishhook.field_9284_au) * (double)f1 + 0.25D;
            double d12 = entityfishhook.field_9283_av + (entityfishhook.field_609_am - entityfishhook.field_9283_av) * (double)f1;
            double d13 = (float)(d7 - d10);
            double d14 = (float)(d8 - d11);
            double d15 = (float)(d9 - d12);
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            tessellator.func_992_a(3);
            tessellator.func_990_b(0);
            int j = 16;
            for(int k = 0; k <= j; k++)
            {
                float f13 = (float)k / (float)j;
                tessellator.func_991_a(d + d13 * (double)f13, d1 + d14 * (double)(f13 * f13 + f13) * 0.5D + 0.25D, d2 + d15 * (double)f13);
            }

            tessellator.func_982_a();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_4011_a((EntityFishHook)entity, d, d1, d2, f, f1);
    }
}

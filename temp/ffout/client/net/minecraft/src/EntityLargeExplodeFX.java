// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntityFX, RenderEngine, RenderHelper, Tessellator, 
//            World

public class EntityLargeExplodeFX extends EntityFX
{

    private int field_35130_a;
    private int field_35129_ay;
    private RenderEngine field_35128_az;
    private float field_35131_aA;

    public EntityLargeExplodeFX(RenderEngine renderengine, World world, double d, double d1, double d2, double d3, double d4, double d5)
    {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        field_35130_a = 0;
        field_35129_ay = 0;
        field_35128_az = renderengine;
        field_35129_ay = 6 + field_9312_bd.nextInt(4);
        field_663_i = field_662_j = field_661_k = field_9312_bd.nextFloat() * 0.6F + 0.4F;
        field_35131_aA = 1.0F - (float)d3 * 0.5F;
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        int i = (int)((((float)field_35130_a + f) * 15F) / (float)field_35129_ay);
        if(i > 15)
        {
            return;
        } else
        {
            field_35128_az.func_1076_b(field_35128_az.func_1070_a("/misc/explosion.png"));
            float f6 = (float)(i % 4) / 4F;
            float f7 = f6 + 0.24975F;
            float f8 = (float)(i / 4) / 4F;
            float f9 = f8 + 0.24975F;
            float f10 = 2.0F * field_35131_aA;
            float f11 = (float)((field_9285_at + (field_611_ak - field_9285_at) * (double)f) - field_660_l);
            float f12 = (float)((field_9284_au + (field_610_al - field_9284_au) * (double)f) - field_659_m);
            float f13 = (float)((field_9283_av + (field_609_am - field_9283_av) * (double)f) - field_658_n);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(2896);
            RenderHelper.func_1159_a();
            tessellator.func_977_b();
            tessellator.func_986_a(field_663_i, field_662_j, field_661_k, 1.0F);
            tessellator.func_980_b(0.0F, 1.0F, 0.0F);
            tessellator.func_35835_b(240);
            tessellator.func_983_a(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f7, f9);
            tessellator.func_983_a((f11 - f1 * f10) + f4 * f10, f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f7, f8);
            tessellator.func_983_a(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f6, f8);
            tessellator.func_983_a((f11 + f1 * f10) - f4 * f10, f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f6, f9);
            tessellator.func_982_a();
            GL11.glPolygonOffset(0.0F, 0.0F);
            GL11.glEnable(2896);
            return;
        }
    }

    public int func_35115_a(float f)
    {
        return 61680;
    }

    public void func_370_e_()
    {
        field_9285_at = field_611_ak;
        field_9284_au = field_610_al;
        field_9283_av = field_609_am;
        field_35130_a++;
        if(field_35130_a == field_35129_ay)
        {
            func_395_F();
        }
    }

    public int func_404_c()
    {
        return 3;
    }
}

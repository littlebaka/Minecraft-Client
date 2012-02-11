// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityPortalFX extends EntityFX
{

    private float field_4083_a;
    private double field_4086_p;
    private double field_4085_q;
    private double field_4084_r;

    public EntityPortalFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world, d, d1, d2, d3, d4, d5);
        field_608_an = d3;
        field_607_ao = d4;
        field_606_ap = d5;
        field_4086_p = field_611_ak = d;
        field_4085_q = field_610_al = d1;
        field_4084_r = field_609_am = d2;
        float f = field_9312_bd.nextFloat() * 0.6F + 0.4F;
        field_4083_a = field_665_g = field_9312_bd.nextFloat() * 0.2F + 0.5F;
        field_663_i = field_662_j = field_661_k = 1.0F * f;
        field_662_j *= 0.3F;
        field_663_i *= 0.9F;
        field_666_f = (int)(Math.random() * 10D) + 40;
        field_9314_ba = true;
        func_40099_c((int)(Math.random() * 8D));
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)field_20923_e + f) / (float)field_666_f;
        f6 = 1.0F - f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        field_665_g = field_4083_a * f6;
        super.func_406_a(tessellator, f, f1, f2, f3, f4, f5);
    }

    public int func_35115_a(float f)
    {
        int i = super.func_35115_a(f);
        float f1 = (float)field_20923_e / (float)field_666_f;
        f1 *= f1;
        f1 *= f1;
        int j = i & 0xff;
        int k = i >> 16 & 0xff;
        k += (int)(f1 * 15F * 16F);
        if(k > 240)
        {
            k = 240;
        }
        return j | k << 16;
    }

    public float func_382_a(float f)
    {
        float f1 = super.func_382_a(f);
        float f2 = (float)field_20923_e / (float)field_666_f;
        f2 *= f2;
        f2 *= f2;
        return f1 * (1.0F - f2) + f2;
    }

    public void func_370_e_()
    {
        field_9285_at = field_611_ak;
        field_9284_au = field_610_al;
        field_9283_av = field_609_am;
        float f = (float)field_20923_e / (float)field_666_f;
        float f1 = f;
        f = -f + f * f * 2.0F;
        f = 1.0F - f;
        field_611_ak = field_4086_p + field_608_an * (double)f;
        field_610_al = field_4085_q + field_607_ao * (double)f + (double)(1.0F - f1);
        field_609_am = field_4084_r + field_606_ap * (double)f;
        if(field_20923_e++ >= field_666_f)
        {
            func_395_F();
        }
    }
}

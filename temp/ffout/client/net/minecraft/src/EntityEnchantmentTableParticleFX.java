// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityEnchantmentTableParticleFX extends EntityFX
{

    private float field_40107_a;
    private double field_40109_aw;
    private double field_40108_ax;
    private double field_40106_ay;

    public EntityEnchantmentTableParticleFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world, d, d1, d2, d3, d4, d5);
        field_608_an = d3;
        field_607_ao = d4;
        field_606_ap = d5;
        field_40109_aw = field_611_ak = d;
        field_40108_ax = field_610_al = d1;
        field_40106_ay = field_609_am = d2;
        float f = field_9312_bd.nextFloat() * 0.6F + 0.4F;
        field_40107_a = field_665_g = field_9312_bd.nextFloat() * 0.5F + 0.2F;
        field_663_i = field_662_j = field_661_k = 1.0F * f;
        field_662_j *= 0.9F;
        field_663_i *= 0.9F;
        field_666_f = (int)(Math.random() * 10D) + 30;
        field_9314_ba = true;
        func_40099_c((int)(Math.random() * 26D + 1.0D + 224D));
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
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
        f = 1.0F - f;
        float f1 = 1.0F - f;
        f1 *= f1;
        f1 *= f1;
        field_611_ak = field_40109_aw + field_608_an * (double)f;
        field_610_al = (field_40108_ax + field_607_ao * (double)f) - (double)(f1 * 1.2F);
        field_609_am = field_40106_ay + field_606_ap * (double)f;
        if(field_20923_e++ >= field_666_f)
        {
            func_395_F();
        }
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityFlameFX extends EntityFX
{

    private float field_672_a;

    public EntityFlameFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world, d, d1, d2, d3, d4, d5);
        field_608_an = field_608_an * 0.0099999997764825821D + d3;
        field_607_ao = field_607_ao * 0.0099999997764825821D + d4;
        field_606_ap = field_606_ap * 0.0099999997764825821D + d5;
        d += (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.05F;
        d1 += (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.05F;
        d2 += (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.05F;
        field_672_a = field_665_g;
        field_663_i = field_662_j = field_661_k = 1.0F;
        field_666_f = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D)) + 4;
        field_9314_ba = true;
        func_40099_c(48);
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)field_20923_e + f) / (float)field_666_f;
        field_665_g = field_672_a * (1.0F - f6 * f6 * 0.5F);
        super.func_406_a(tessellator, f, f1, f2, f3, f4, f5);
    }

    public int func_35115_a(float f)
    {
        float f1 = ((float)field_20923_e + f) / (float)field_666_f;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        int i = super.func_35115_a(f);
        int j = i & 0xff;
        int k = i >> 16 & 0xff;
        j += (int)(f1 * 15F * 16F);
        if(j > 240)
        {
            j = 240;
        }
        return j | k << 16;
    }

    public float func_382_a(float f)
    {
        float f1 = ((float)field_20923_e + f) / (float)field_666_f;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        float f2 = super.func_382_a(f);
        return f2 * f1 + (1.0F - f1);
    }

    public void func_370_e_()
    {
        field_9285_at = field_611_ak;
        field_9284_au = field_610_al;
        field_9283_av = field_609_am;
        if(field_20923_e++ >= field_666_f)
        {
            func_395_F();
        }
        func_349_c(field_608_an, field_607_ao, field_606_ap);
        field_608_an *= 0.95999997854232788D;
        field_607_ao *= 0.95999997854232788D;
        field_606_ap *= 0.95999997854232788D;
        if(field_9298_aH)
        {
            field_608_an *= 0.69999998807907104D;
            field_606_ap *= 0.69999998807907104D;
        }
    }
}

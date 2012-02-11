// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, Tessellator, World, 
//            NBTTagCompound

public class EntityFX extends Entity
{

    private int field_670_b;
    protected float field_669_c;
    protected float field_668_d;
    protected int field_20923_e;
    protected int field_666_f;
    protected float field_665_g;
    protected float field_664_h;
    protected float field_663_i;
    protected float field_662_j;
    protected float field_661_k;
    public static double field_660_l;
    public static double field_659_m;
    public static double field_658_n;

    public EntityFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world);
        field_20923_e = 0;
        field_666_f = 0;
        func_371_a(0.2F, 0.2F);
        field_9292_aO = field_643_aD / 2.0F;
        func_347_a(d, d1, d2);
        field_663_i = field_662_j = field_661_k = 1.0F;
        field_608_an = d3 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        field_607_ao = d4 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        field_606_ap = d5 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        float f = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
        float f1 = MathHelper.func_1109_a(field_608_an * field_608_an + field_607_ao * field_607_ao + field_606_ap * field_606_ap);
        field_608_an = (field_608_an / (double)f1) * (double)f * 0.40000000596046448D;
        field_607_ao = (field_607_ao / (double)f1) * (double)f * 0.40000000596046448D + 0.10000000149011612D;
        field_606_ap = (field_606_ap / (double)f1) * (double)f * 0.40000000596046448D;
        field_669_c = field_9312_bd.nextFloat() * 3F;
        field_668_d = field_9312_bd.nextFloat() * 3F;
        field_665_g = (field_9312_bd.nextFloat() * 0.5F + 0.5F) * 2.0F;
        field_666_f = (int)(4F / (field_9312_bd.nextFloat() * 0.9F + 0.1F));
        field_20923_e = 0;
    }

    public EntityFX func_407_b(float f)
    {
        field_608_an *= f;
        field_607_ao = (field_607_ao - 0.10000000149011612D) * (double)f + 0.10000000149011612D;
        field_606_ap *= f;
        return this;
    }

    public EntityFX func_405_d(float f)
    {
        func_371_a(0.2F * f, 0.2F * f);
        field_665_g *= f;
        return this;
    }

    public void func_40097_b(float f, float f1, float f2)
    {
        field_663_i = f;
        field_662_j = f1;
        field_661_k = f2;
    }

    public float func_40098_n()
    {
        return field_663_i;
    }

    public float func_40101_o()
    {
        return field_662_j;
    }

    public float func_40102_p()
    {
        return field_661_k;
    }

    protected boolean func_25021_m()
    {
        return false;
    }

    protected void func_21057_b()
    {
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
        field_607_ao -= 0.040000000000000001D * (double)field_664_h;
        func_349_c(field_608_an, field_607_ao, field_606_ap);
        field_608_an *= 0.98000001907348633D;
        field_607_ao *= 0.98000001907348633D;
        field_606_ap *= 0.98000001907348633D;
        if(field_9298_aH)
        {
            field_608_an *= 0.69999998807907104D;
            field_606_ap *= 0.69999998807907104D;
        }
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = (float)(field_670_b % 16) / 16F;
        float f7 = f6 + 0.0624375F;
        float f8 = (float)(field_670_b / 16) / 16F;
        float f9 = f8 + 0.0624375F;
        float f10 = 0.1F * field_665_g;
        float f11 = (float)((field_9285_at + (field_611_ak - field_9285_at) * (double)f) - field_660_l);
        float f12 = (float)((field_9284_au + (field_610_al - field_9284_au) * (double)f) - field_659_m);
        float f13 = (float)((field_9283_av + (field_609_am - field_9283_av) * (double)f) - field_658_n);
        float f14 = 1.0F;
        tessellator.func_987_a(field_663_i * f14, field_662_j * f14, field_661_k * f14);
        tessellator.func_983_a(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f7, f9);
        tessellator.func_983_a((f11 - f1 * f10) + f4 * f10, f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f7, f8);
        tessellator.func_983_a(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f6, f8);
        tessellator.func_983_a((f11 + f1 * f10) - f4 * f10, f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f6, f9);
    }

    public int func_404_c()
    {
        return 0;
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
    }

    public void func_40099_c(int i)
    {
        field_670_b = i;
    }

    public int func_40100_q()
    {
        return field_670_b;
    }
}

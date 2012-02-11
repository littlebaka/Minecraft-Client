// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, AxisAlignedBB, MathHelper, World, 
//            EntityItem, ItemStack, Item, NBTTagCompound, 
//            EntityPlayer

public class EntityEnderEye extends Entity
{

    public int field_40096_a;
    private double field_40094_b;
    private double field_40095_c;
    private double field_40091_d;
    private int field_40092_e;
    private boolean field_40093_ao;

    public EntityEnderEye(World world)
    {
        super(world);
        field_40096_a = 0;
        func_371_a(0.25F, 0.25F);
    }

    protected void func_21057_b()
    {
    }

    public boolean func_384_a(double d)
    {
        double d1 = field_601_au.func_1164_b() * 4D;
        d1 *= 64D;
        return d < d1 * d1;
    }

    public EntityEnderEye(World world, double d, double d1, double d2)
    {
        super(world);
        field_40096_a = 0;
        field_40092_e = 0;
        func_371_a(0.25F, 0.25F);
        func_347_a(d, d1, d2);
        field_9292_aO = 0.0F;
    }

    public void func_40090_a(double d, int i, double d1)
    {
        double d2 = d - field_611_ak;
        double d3 = d1 - field_609_am;
        float f = MathHelper.func_1109_a(d2 * d2 + d3 * d3);
        if(f > 12F)
        {
            field_40094_b = field_611_ak + (d2 / (double)f) * 12D;
            field_40091_d = field_609_am + (d3 / (double)f) * 12D;
            field_40095_c = field_610_al + 8D;
        } else
        {
            field_40094_b = d;
            field_40095_c = i;
            field_40091_d = d1;
        }
        field_40092_e = 0;
        field_40093_ao = field_9312_bd.nextInt(5) > 0;
    }

    public void func_6375_a(double d, double d1, double d2)
    {
        field_608_an = d;
        field_607_ao = d1;
        field_606_ap = d2;
        if(field_602_at == 0.0F && field_603_as == 0.0F)
        {
            float f = MathHelper.func_1109_a(d * d + d2 * d2);
            field_603_as = field_605_aq = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
            field_602_at = field_604_ar = (float)((Math.atan2(d1, f) * 180D) / 3.1415927410125732D);
        }
    }

    public void func_370_e_()
    {
        field_638_aI = field_611_ak;
        field_637_aJ = field_610_al;
        field_636_aK = field_609_am;
        super.func_370_e_();
        field_611_ak += field_608_an;
        field_610_al += field_607_ao;
        field_609_am += field_606_ap;
        float f = MathHelper.func_1109_a(field_608_an * field_608_an + field_606_ap * field_606_ap);
        field_605_aq = (float)((Math.atan2(field_608_an, field_606_ap) * 180D) / 3.1415927410125732D);
        for(field_604_ar = (float)((Math.atan2(field_607_ao, f) * 180D) / 3.1415927410125732D); field_604_ar - field_602_at < -180F; field_602_at -= 360F) { }
        for(; field_604_ar - field_602_at >= 180F; field_602_at += 360F) { }
        for(; field_605_aq - field_603_as < -180F; field_603_as -= 360F) { }
        for(; field_605_aq - field_603_as >= 180F; field_603_as += 360F) { }
        field_604_ar = field_602_at + (field_604_ar - field_602_at) * 0.2F;
        field_605_aq = field_603_as + (field_605_aq - field_603_as) * 0.2F;
        if(!field_615_ag.field_1026_y)
        {
            double d = field_40094_b - field_611_ak;
            double d1 = field_40091_d - field_609_am;
            float f2 = (float)Math.sqrt(d * d + d1 * d1);
            float f3 = (float)Math.atan2(d1, d);
            double d2 = (double)f + (double)(f2 - f) * 0.0025000000000000001D;
            if(f2 < 1.0F)
            {
                d2 *= 0.80000000000000004D;
                field_607_ao *= 0.80000000000000004D;
            }
            field_608_an = Math.cos(f3) * d2;
            field_606_ap = Math.sin(f3) * d2;
            if(field_610_al < field_40095_c)
            {
                field_607_ao = field_607_ao + (1.0D - field_607_ao) * 0.014999999664723873D;
            } else
            {
                field_607_ao = field_607_ao + (-1D - field_607_ao) * 0.014999999664723873D;
            }
        }
        float f1 = 0.25F;
        if(func_27013_ag())
        {
            for(int i = 0; i < 4; i++)
            {
                field_615_ag.func_694_a("bubble", field_611_ak - field_608_an * (double)f1, field_610_al - field_607_ao * (double)f1, field_609_am - field_606_ap * (double)f1, field_608_an, field_607_ao, field_606_ap);
            }

        } else
        {
            field_615_ag.func_694_a("portal", ((field_611_ak - field_608_an * (double)f1) + field_9312_bd.nextDouble() * 0.59999999999999998D) - 0.29999999999999999D, field_610_al - field_607_ao * (double)f1 - 0.5D, ((field_609_am - field_606_ap * (double)f1) + field_9312_bd.nextDouble() * 0.59999999999999998D) - 0.29999999999999999D, field_608_an, field_607_ao, field_606_ap);
        }
        if(!field_615_ag.field_1026_y)
        {
            func_347_a(field_611_ak, field_610_al, field_609_am);
            field_40092_e++;
            if(field_40092_e > 80 && !field_615_ag.field_1026_y)
            {
                func_395_F();
                if(field_40093_ao)
                {
                    field_615_ag.func_674_a(new EntityItem(field_615_ag, field_611_ak, field_610_al, field_609_am, new ItemStack(Item.field_40420_bA)));
                } else
                {
                    field_615_ag.func_28106_e(2003, (int)Math.round(field_611_ak), (int)Math.round(field_610_al), (int)Math.round(field_609_am), 0);
                }
            }
        }
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
    }

    public void func_6378_b(EntityPlayer entityplayer)
    {
    }

    public float func_392_h_()
    {
        return 0.0F;
    }

    public float func_382_a(float f)
    {
        return 1.0F;
    }

    public int func_35115_a(float f)
    {
        return 0xf000f0;
    }
}

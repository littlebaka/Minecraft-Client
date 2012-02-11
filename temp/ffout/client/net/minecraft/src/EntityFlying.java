// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, MathHelper, AxisAlignedBB, World, 
//            Block

public abstract class EntityFlying extends EntityLiving
{

    public EntityFlying(World world)
    {
        super(world);
    }

    protected void func_400_c(float f)
    {
    }

    public void func_435_b(float f, float f1)
    {
        if(func_27013_ag())
        {
            func_351_a(f, f1, 0.02F);
            func_349_c(field_608_an, field_607_ao, field_606_ap);
            field_608_an *= 0.80000001192092896D;
            field_607_ao *= 0.80000001192092896D;
            field_606_ap *= 0.80000001192092896D;
        } else
        if(func_359_G())
        {
            func_351_a(f, f1, 0.02F);
            func_349_c(field_608_an, field_607_ao, field_606_ap);
            field_608_an *= 0.5D;
            field_607_ao *= 0.5D;
            field_606_ap *= 0.5D;
        } else
        {
            float f2 = 0.91F;
            if(field_9298_aH)
            {
                f2 = 0.5460001F;
                int i = field_615_ag.func_600_a(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(field_609_am));
                if(i > 0)
                {
                    f2 = Block.field_345_n[i].field_355_bo * 0.91F;
                }
            }
            float f3 = 0.1627714F / (f2 * f2 * f2);
            func_351_a(f, f1, field_9298_aH ? 0.1F * f3 : 0.02F);
            f2 = 0.91F;
            if(field_9298_aH)
            {
                f2 = 0.5460001F;
                int j = field_615_ag.func_600_a(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(field_609_am));
                if(j > 0)
                {
                    f2 = Block.field_345_n[j].field_355_bo * 0.91F;
                }
            }
            func_349_c(field_608_an, field_607_ao, field_606_ap);
            field_608_an *= f2;
            field_607_ao *= f2;
            field_606_ap *= f2;
        }
        field_705_Q = field_704_R;
        double d = field_611_ak - field_9285_at;
        double d1 = field_609_am - field_9283_av;
        float f4 = MathHelper.func_1109_a(d * d + d1 * d1) * 4F;
        if(f4 > 1.0F)
        {
            f4 = 1.0F;
        }
        field_704_R += (f4 - field_704_R) * 0.4F;
        field_703_S += field_704_R;
    }

    public boolean func_429_A()
    {
        return false;
    }
}

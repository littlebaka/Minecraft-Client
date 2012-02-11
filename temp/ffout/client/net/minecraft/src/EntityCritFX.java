// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityCritFX extends EntityFX
{

    private boolean field_35136_ay;
    float field_35137_a;

    public EntityCritFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        this(world, d, d1, d2, d3, d4, d5, 1.0F);
    }

    public EntityCritFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5, float f)
    {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        field_35136_ay = true;
        field_608_an *= 0.10000000149011612D;
        field_607_ao *= 0.10000000149011612D;
        field_606_ap *= 0.10000000149011612D;
        field_608_an += d3 * 0.40000000000000002D;
        field_607_ao += d4 * 0.40000000000000002D;
        field_606_ap += d5 * 0.40000000000000002D;
        field_663_i = field_662_j = field_661_k = (float)(Math.random() * 0.30000001192092896D + 0.60000002384185791D);
        field_665_g *= 0.75F;
        field_665_g *= f;
        field_35137_a = field_665_g;
        field_666_f = (int)(6D / (Math.random() * 0.80000000000000004D + 0.59999999999999998D));
        field_666_f *= f;
        field_9314_ba = false;
        func_40099_c(65);
        func_370_e_();
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        if(!field_35136_ay)
        {
            return;
        }
        float f6 = (((float)field_20923_e + f) / (float)field_666_f) * 32F;
        if(f6 < 0.0F)
        {
            f6 = 0.0F;
        }
        if(f6 > 1.0F)
        {
            f6 = 1.0F;
        }
        field_665_g = field_35137_a * f6;
        super.func_406_a(tessellator, f, f1, f2, f3, f4, f5);
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
        field_662_j *= 0.95999999999999996D;
        field_661_k *= 0.90000000000000002D;
        field_608_an *= 0.69999998807907104D;
        field_607_ao *= 0.69999998807907104D;
        field_606_ap *= 0.69999998807907104D;
        field_607_ao -= 0.019999999552965164D;
        if(field_9298_aH)
        {
            field_608_an *= 0.69999998807907104D;
            field_606_ap *= 0.69999998807907104D;
        }
    }
}

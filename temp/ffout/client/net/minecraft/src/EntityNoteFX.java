// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, MathHelper, World, Tessellator

public class EntityNoteFX extends EntityFX
{

    float field_21065_a;

    public EntityNoteFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        this(world, d, d1, d2, d3, d4, d5, 2.0F);
    }

    public EntityNoteFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5, float f)
    {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        field_608_an *= 0.0099999997764825821D;
        field_607_ao *= 0.0099999997764825821D;
        field_606_ap *= 0.0099999997764825821D;
        field_607_ao += 0.20000000000000001D;
        field_663_i = MathHelper.func_1106_a(((float)d3 + 0.0F) * 3.141593F * 2.0F) * 0.65F + 0.35F;
        field_662_j = MathHelper.func_1106_a(((float)d3 + 0.3333333F) * 3.141593F * 2.0F) * 0.65F + 0.35F;
        field_661_k = MathHelper.func_1106_a(((float)d3 + 0.6666667F) * 3.141593F * 2.0F) * 0.65F + 0.35F;
        field_665_g *= 0.75F;
        field_665_g *= f;
        field_21065_a = field_665_g;
        field_666_f = 6;
        field_9314_ba = false;
        func_40099_c(64);
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = (((float)field_20923_e + f) / (float)field_666_f) * 32F;
        if(f6 < 0.0F)
        {
            f6 = 0.0F;
        }
        if(f6 > 1.0F)
        {
            f6 = 1.0F;
        }
        field_665_g = field_21065_a * f6;
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
        if(field_610_al == field_9284_au)
        {
            field_608_an *= 1.1000000000000001D;
            field_606_ap *= 1.1000000000000001D;
        }
        field_608_an *= 0.6600000262260437D;
        field_607_ao *= 0.6600000262260437D;
        field_606_ap *= 0.6600000262260437D;
        if(field_9298_aH)
        {
            field_608_an *= 0.69999998807907104D;
            field_606_ap *= 0.69999998807907104D;
        }
    }
}

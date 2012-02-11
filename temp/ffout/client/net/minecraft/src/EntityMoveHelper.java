// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, AxisAlignedBB, MathHelper

public class EntityMoveHelper
{

    private EntityLiving field_46041_a;
    private double field_46039_b;
    private double field_46040_c;
    private double field_46037_d;
    private float field_46038_e;
    private boolean field_46036_f;

    public EntityMoveHelper(EntityLiving entityliving, float f)
    {
        field_46036_f = false;
        field_46041_a = entityliving;
        field_46039_b = entityliving.field_611_ak;
        field_46040_c = entityliving.field_610_al;
        field_46037_d = entityliving.field_609_am;
        field_46038_e = f;
    }

    public void func_46035_a(double d, double d1, double d2)
    {
        field_46039_b = d;
        field_46040_c = d1;
        field_46037_d = d2;
        field_46036_f = true;
    }

    public void func_46033_a(float f)
    {
        field_46038_e = f;
    }

    public void func_46034_a()
    {
        field_46041_a.func_46010_f(0.0F);
        if(!field_46036_f)
        {
            return;
        }
        field_46036_f = false;
        int i = MathHelper.func_1108_b(field_46041_a.field_601_au.field_1697_b + 0.5D);
        double d = field_46039_b - field_46041_a.field_611_ak;
        double d1 = field_46037_d - field_46041_a.field_609_am;
        double d2 = field_46040_c - (double)i;
        float f = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
        float f1;
        for(f1 = f - field_46041_a.field_605_aq; f1 < -180F; f1 += 360F) { }
        for(; f1 >= 180F; f1 -= 360F) { }
        if(f1 > 30F)
        {
            f1 = 30F;
        }
        if(f1 < -30F)
        {
            f1 = -30F;
        }
        field_46041_a.field_605_aq += f1;
        field_46041_a.func_46010_f(field_46038_e);
        field_46041_a.func_46003_g(d2 > 0.0D);
    }
}

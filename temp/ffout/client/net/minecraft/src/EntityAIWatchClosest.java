// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityLiving, World, EntityLookHelper

public class EntityAIWatchClosest extends EntityAIBase
{

    private EntityLiving field_46105_a;
    private EntityLiving field_46103_b;
    private World field_46104_c;
    private float field_46101_d;
    private int field_46102_e;

    public EntityAIWatchClosest(EntityLiving entityliving, World world, float f)
    {
        field_46105_a = entityliving;
        field_46104_c = world;
        field_46101_d = f;
        func_46079_a(3);
    }

    public boolean func_46082_a()
    {
        if(field_46105_a.func_46004_aK().nextFloat() >= 0.02F)
        {
            return false;
        }
        field_46103_b = field_46104_c.func_609_a(field_46105_a, field_46101_d);
        return field_46103_b != null;
    }

    public boolean func_46084_g()
    {
        if(!field_46103_b.func_354_B())
        {
            return false;
        }
        if(field_46105_a.func_387_e(field_46103_b) > (double)(field_46101_d * field_46101_d))
        {
            return false;
        } else
        {
            return field_46102_e > 0;
        }
    }

    public void func_46080_e()
    {
        field_46102_e = 40 + field_46105_a.func_46004_aK().nextInt(40);
    }

    public void func_46077_d()
    {
        field_46103_b = null;
    }

    public void func_46081_b()
    {
        field_46105_a.func_46008_aG().func_46143_a(field_46103_b.field_611_ak, field_46103_b.field_610_al + (double)field_46103_b.func_373_s(), field_46103_b.field_609_am, 10F, field_46105_a.func_25026_x());
        field_46102_e--;
    }

    public int func_46083_c()
    {
        return super.func_46083_c();
    }

    public void func_46079_a(int i)
    {
        super.func_46079_a(i);
    }

    public boolean func_46078_f()
    {
        return super.func_46078_f();
    }
}

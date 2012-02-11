// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityThrowable, MovingObjectPosition, DamageSource, Entity, 
//            World, EntityLiving

public class EntityEnderPearl extends EntityThrowable
{

    public EntityEnderPearl(World world)
    {
        super(world);
    }

    public EntityEnderPearl(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public EntityEnderPearl(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    protected void func_40078_a(MovingObjectPosition movingobjectposition)
    {
        if(movingobjectposition.field_1168_g != null)
        {
            if(!movingobjectposition.field_1168_g.func_396_a(DamageSource.func_35524_a(this, field_40083_c), 0));
        }
        for(int i = 0; i < 32; i++)
        {
            field_615_ag.func_694_a("portal", field_611_ak, field_610_al + field_9312_bd.nextDouble() * 2D, field_609_am, field_9312_bd.nextGaussian(), 0.0D, field_9312_bd.nextGaussian());
        }

        if(!field_615_ag.field_1026_y)
        {
            if(field_40083_c != null)
            {
                field_40083_c.func_40113_j(field_611_ak, field_610_al, field_609_am);
                field_40083_c.field_9288_aU = 0.0F;
                field_40083_c.func_396_a(DamageSource.field_35549_h, 5);
            }
            func_395_F();
        }
    }
}

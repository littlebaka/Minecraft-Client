// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityThrowable, MovingObjectPosition, EntityBlaze, DamageSource, 
//            Entity, World, EntityLiving

public class EntitySnowball extends EntityThrowable
{

    public EntitySnowball(World world)
    {
        super(world);
    }

    public EntitySnowball(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public EntitySnowball(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    protected void func_40078_a(MovingObjectPosition movingobjectposition)
    {
        if(movingobjectposition.field_1168_g != null)
        {
            byte byte0 = 0;
            if(movingobjectposition.field_1168_g instanceof EntityBlaze)
            {
                byte0 = 3;
            }
            if(!movingobjectposition.field_1168_g.func_396_a(DamageSource.func_35524_a(this, field_40083_c), byte0));
        }
        for(int i = 0; i < 8; i++)
        {
            field_615_ag.func_694_a("snowballpoof", field_611_ak, field_610_al, field_609_am, 0.0D, 0.0D, 0.0D);
        }

        if(!field_615_ag.field_1026_y)
        {
            func_395_F();
        }
    }
}

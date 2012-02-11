// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFireball, World, MovingObjectPosition, Entity, 
//            DamageSource, Block, BlockFire, EntityLiving

public class EntitySmallFireball extends EntityFireball
{

    public EntitySmallFireball(World world)
    {
        super(world);
        func_371_a(0.3125F, 0.3125F);
    }

    public EntitySmallFireball(World world, EntityLiving entityliving, double d, double d1, double d2)
    {
        super(world, entityliving, d, d1, d2);
        func_371_a(0.3125F, 0.3125F);
    }

    public EntitySmallFireball(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world, d, d1, d2, d3, d4, d5);
        func_371_a(0.3125F, 0.3125F);
    }

    protected void func_40071_a(MovingObjectPosition movingobjectposition)
    {
        if(!field_615_ag.field_1026_y)
        {
            if(movingobjectposition.field_1168_g != null)
            {
                if(!movingobjectposition.field_1168_g.func_40047_D() && movingobjectposition.field_1168_g.func_396_a(DamageSource.func_35530_a(this, field_9397_j), 5))
                {
                    movingobjectposition.field_1168_g.func_40046_d(5);
                }
            } else
            {
                int i = movingobjectposition.field_1166_b;
                int j = movingobjectposition.field_1172_c;
                int k = movingobjectposition.field_1171_d;
                switch(movingobjectposition.field_1170_e)
                {
                case 1: // '\001'
                    j++;
                    break;

                case 0: // '\0'
                    j--;
                    break;

                case 2: // '\002'
                    k--;
                    break;

                case 3: // '\003'
                    k++;
                    break;

                case 5: // '\005'
                    i++;
                    break;

                case 4: // '\004'
                    i--;
                    break;
                }
                if(field_615_ag.func_20084_d(i, j, k))
                {
                    field_615_ag.func_690_d(i, j, k, Block.field_402_as.field_376_bc);
                }
            }
            func_395_F();
        }
    }

    public boolean func_401_c_()
    {
        return false;
    }

    public boolean func_396_a(DamageSource damagesource, int i)
    {
        return false;
    }
}

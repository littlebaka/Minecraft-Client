// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, EntityAISwimming, EntityAITasks, EntityAIAttackOnCollide, 
//            EntityAIWander, EntityAIWatchClosest, EntityAILookIdle, World, 
//            MathHelper, Item, EnumCreatureAttribute

public class EntityZombie extends EntityMob
{

    public EntityZombie(World world)
    {
        super(world);
        field_9357_z = "/mob/zombie.png";
        field_9333_am = 0.5F;
        field_762_e = 4;
        field_46019_bU.func_46118_a(1, new EntityAISwimming(this));
        field_46019_bU.func_46118_a(2, new EntityAIAttackOnCollide(this, world, 16F));
        field_46019_bU.func_46118_a(3, new EntityAIWander(this));
        field_46019_bU.func_46118_a(4, new EntityAIWatchClosest(this, world, 8F));
        field_46019_bU.func_46118_a(4, new EntityAILookIdle(this));
    }

    public int func_40117_c()
    {
        return 20;
    }

    public int func_40119_ar()
    {
        return 2;
    }

    protected boolean func_46006_aR()
    {
        return false;
    }

    public void func_425_j()
    {
        if(field_615_ag.func_624_b() && !field_615_ag.field_1026_y)
        {
            float f = func_382_a(1.0F);
            if(f > 0.5F && field_615_ag.func_647_i(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_610_al), MathHelper.func_1108_b(field_609_am)) && field_9312_bd.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                func_40046_d(8);
            }
        }
        super.func_425_j();
    }

    protected String func_6389_d()
    {
        return "mob.zombie";
    }

    protected String func_6394_f_()
    {
        return "mob.zombiehurt";
    }

    protected String func_6390_f()
    {
        return "mob.zombiedeath";
    }

    protected int func_422_g()
    {
        return Item.field_35415_bn.field_291_aS;
    }

    public EnumCreatureAttribute func_40124_t()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
}

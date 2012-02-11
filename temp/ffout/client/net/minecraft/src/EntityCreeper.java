// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, DataWatcher, NBTTagCompound, World, 
//            DamageSource, EntitySkeleton, Item, Entity, 
//            EntityLightningBolt

public class EntityCreeper extends EntityMob
{

    int field_764_a;
    int field_763_b;

    public EntityCreeper(World world)
    {
        super(world);
        field_9357_z = "/mob/creeper.png";
    }

    public int func_40117_c()
    {
        return 20;
    }

    protected void func_21057_b()
    {
        super.func_21057_b();
        field_21064_bx.func_21124_a(16, Byte.valueOf((byte)-1));
        field_21064_bx.func_21124_a(17, Byte.valueOf((byte)0));
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
        if(field_21064_bx.func_21130_a(17) == 1)
        {
            nbttagcompound.func_748_a("powered", true);
        }
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
        field_21064_bx.func_21129_b(17, Byte.valueOf((byte)(nbttagcompound.func_760_m("powered") ? 1 : 0)));
    }

    protected void func_28022_b(Entity entity, float f)
    {
        if(field_615_ag.field_1026_y)
        {
            return;
        }
        if(field_764_a > 0)
        {
            func_21090_e(-1);
            field_764_a--;
            if(field_764_a < 0)
            {
                field_764_a = 0;
            }
        }
    }

    public void func_370_e_()
    {
        field_763_b = field_764_a;
        if(field_615_ag.field_1026_y)
        {
            int i = func_21091_q();
            if(i > 0 && field_764_a == 0)
            {
                field_615_ag.func_623_a(this, "random.fuse", 1.0F, 0.5F);
            }
            field_764_a += i;
            if(field_764_a < 0)
            {
                field_764_a = 0;
            }
            if(field_764_a >= 30)
            {
                field_764_a = 30;
            }
        }
        super.func_370_e_();
        if(field_751_f == null && field_764_a > 0)
        {
            func_21090_e(-1);
            field_764_a--;
            if(field_764_a < 0)
            {
                field_764_a = 0;
            }
        }
    }

    protected String func_6394_f_()
    {
        return "mob.creeper";
    }

    protected String func_6390_f()
    {
        return "mob.creeperdeath";
    }

    public void func_419_b(DamageSource damagesource)
    {
        super.func_419_b(damagesource);
        if(damagesource.func_35532_a() instanceof EntitySkeleton)
        {
            func_367_b(Item.field_293_aQ.field_291_aS + field_9312_bd.nextInt(10), 1);
        }
    }

    protected void func_437_a(Entity entity, float f)
    {
        if(field_615_ag.field_1026_y)
        {
            return;
        }
        int i = func_21091_q();
        if(i <= 0 && f < 3F || i > 0 && f < 7F)
        {
            if(field_764_a == 0)
            {
                field_615_ag.func_623_a(this, "random.fuse", 1.0F, 0.5F);
            }
            func_21090_e(1);
            field_764_a++;
            if(field_764_a >= 30)
            {
                if(func_27022_s())
                {
                    field_615_ag.func_12243_a(this, field_611_ak, field_610_al, field_609_am, 6F);
                } else
                {
                    field_615_ag.func_12243_a(this, field_611_ak, field_610_al, field_609_am, 3F);
                }
                func_395_F();
            }
            field_750_g = true;
        } else
        {
            func_21090_e(-1);
            field_764_a--;
            if(field_764_a < 0)
            {
                field_764_a = 0;
            }
        }
    }

    public boolean func_27022_s()
    {
        return field_21064_bx.func_21130_a(17) == 1;
    }

    public float func_440_b(float f)
    {
        return ((float)field_763_b + (float)(field_764_a - field_763_b) * f) / 28F;
    }

    protected int func_422_g()
    {
        return Item.field_250_K.field_291_aS;
    }

    private int func_21091_q()
    {
        return field_21064_bx.func_21130_a(16);
    }

    private void func_21090_e(int i)
    {
        field_21064_bx.func_21129_b(16, Byte.valueOf((byte)i));
    }

    public void func_27014_a(EntityLightningBolt entitylightningbolt)
    {
        super.func_27014_a(entitylightningbolt);
        field_21064_bx.func_21129_b(17, Byte.valueOf((byte)1));
    }
}

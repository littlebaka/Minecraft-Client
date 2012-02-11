// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class EntityPig extends EntityAnimal
{

    public EntityPig(World world)
    {
        super(world);
        field_9357_z = "/mob/pig.png";
        func_371_a(0.9F, 0.9F);
    }

    public int func_40117_c()
    {
        return 10;
    }

    protected void func_21057_b()
    {
        super.func_21057_b();
        field_21064_bx.func_21124_a(16, Byte.valueOf((byte)0));
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
        nbttagcompound.func_748_a("Saddle", func_21068_q());
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
        func_21069_a(nbttagcompound.func_760_m("Saddle"));
    }

    protected String func_6389_d()
    {
        return "mob.pig";
    }

    protected String func_6394_f_()
    {
        return "mob.pig";
    }

    protected String func_6390_f()
    {
        return "mob.pigdeath";
    }

    public boolean func_353_a(EntityPlayer entityplayer)
    {
        if(!super.func_353_a(entityplayer))
        {
            if(func_21068_q() && !field_615_ag.field_1026_y && (field_617_ae == null || field_617_ae == entityplayer))
            {
                entityplayer.func_6377_h(this);
                return true;
            } else
            {
                return false;
            }
        } else
        {
            return true;
        }
    }

    protected int func_422_g()
    {
        if(func_21062_U())
        {
            return Item.field_4017_ap.field_291_aS;
        } else
        {
            return Item.field_272_ao.field_291_aS;
        }
    }

    public boolean func_21068_q()
    {
        return (field_21064_bx.func_21130_a(16) & 1) != 0;
    }

    public void func_21069_a(boolean flag)
    {
        if(flag)
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)1));
        } else
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)0));
        }
    }

    public void func_27014_a(EntityLightningBolt entitylightningbolt)
    {
        if(field_615_ag.field_1026_y)
        {
            return;
        } else
        {
            EntityPigZombie entitypigzombie = new EntityPigZombie(field_615_ag);
            entitypigzombie.func_365_c(field_611_ak, field_610_al, field_609_am, field_605_aq, field_604_ar);
            field_615_ag.func_674_a(entitypigzombie);
            func_395_F();
            return;
        }
    }

    protected void func_400_c(float f)
    {
        super.func_400_c(f);
        if(f > 5F && (field_617_ae instanceof EntityPlayer))
        {
            ((EntityPlayer)field_617_ae).func_27026_a(AchievementList.field_27375_u);
        }
    }

    protected EntityAnimal func_40145_a(EntityAnimal entityanimal)
    {
        return new EntityPig(field_615_ag);
    }
}

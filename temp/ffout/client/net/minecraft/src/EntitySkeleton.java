// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, DamageSource, EntityArrow, EntityPlayer, 
//            AchievementList, World, MathHelper, Entity, 
//            Item, EnumCreatureAttribute, ItemStack, NBTTagCompound

public class EntitySkeleton extends EntityMob
{

    private static final ItemStack field_4119_a;

    public EntitySkeleton(World world)
    {
        super(world);
        field_9357_z = "/mob/skeleton.png";
    }

    public int func_40117_c()
    {
        return 20;
    }

    protected String func_6389_d()
    {
        return "mob.skeleton";
    }

    protected String func_6394_f_()
    {
        return "mob.skeletonhurt";
    }

    protected String func_6390_f()
    {
        return "mob.skeletonhurt";
    }

    public boolean func_396_a(DamageSource damagesource, int i)
    {
        return super.func_396_a(damagesource, i);
    }

    public void func_419_b(DamageSource damagesource)
    {
        super.func_419_b(damagesource);
        if((damagesource.func_35526_e() instanceof EntityArrow) && (damagesource.func_35532_a() instanceof EntityPlayer))
        {
            EntityPlayer entityplayer = (EntityPlayer)damagesource.func_35532_a();
            double d = entityplayer.field_611_ak - field_611_ak;
            double d1 = entityplayer.field_609_am - field_609_am;
            if(d * d + d1 * d1 >= 2500D)
            {
                entityplayer.func_27026_a(AchievementList.field_35608_v);
            }
        }
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

    protected void func_437_a(Entity entity, float f)
    {
        if(f < 10F)
        {
            double d = entity.field_611_ak - field_611_ak;
            double d1 = entity.field_609_am - field_609_am;
            if(field_9330_P == 0)
            {
                EntityArrow entityarrow = new EntityArrow(field_615_ag, this, 1.0F);
                double d2 = (entity.field_610_al + (double)entity.func_373_s()) - 0.69999998807907104D - entityarrow.field_610_al;
                float f1 = MathHelper.func_1109_a(d * d + d1 * d1) * 0.2F;
                field_615_ag.func_623_a(this, "random.bow", 1.0F, 1.0F / (field_9312_bd.nextFloat() * 0.4F + 0.8F));
                field_615_ag.func_674_a(entityarrow);
                entityarrow.func_408_a(d, d2 + (double)f1, d1, 1.6F, 12F);
                field_9330_P = 60;
            }
            field_605_aq = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
            field_750_g = true;
        }
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
    }

    protected int func_422_g()
    {
        return Item.field_226_j.field_291_aS;
    }

    protected void func_21066_o(boolean flag, int i)
    {
        int j = field_9312_bd.nextInt(3 + i);
        for(int k = 0; k < j; k++)
        {
            func_367_b(Item.field_226_j.field_291_aS, 1);
        }

        j = field_9312_bd.nextInt(3 + i);
        for(int l = 0; l < j; l++)
        {
            func_367_b(Item.field_21020_aV.field_291_aS, 1);
        }

    }

    public ItemStack func_4045_l()
    {
        return field_4119_a;
    }

    public EnumCreatureAttribute func_40124_t()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    static 
    {
        field_4119_a = new ItemStack(Item.field_227_i, 1);
    }
}

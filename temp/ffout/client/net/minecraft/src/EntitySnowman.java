// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntitySnowmanBase, World, EntityMob, AxisAlignedBB, 
//            Entity, MathHelper, WorldChunkManager, DamageSource, 
//            Block, EntitySnowball, Item, NBTTagCompound

public class EntitySnowman extends EntitySnowmanBase
{

    public EntitySnowman(World world)
    {
        super(world);
        field_9357_z = "/mob/snowman.png";
        func_371_a(0.4F, 1.8F);
    }

    public int func_40117_c()
    {
        return 4;
    }

    public void func_425_j()
    {
        super.func_425_j();
        if(field_751_f == null && !func_25031_E() && field_615_ag.field_1037_n.nextInt(100) == 0)
        {
            List list = field_615_ag.func_657_a(net.minecraft.src.EntityMob.class, AxisAlignedBB.func_1161_b(field_611_ak, field_610_al, field_609_am, field_611_ak + 1.0D, field_610_al + 1.0D, field_609_am + 1.0D).func_1177_b(16D, 4D, 16D));
            if(!list.isEmpty())
            {
                func_25032_c((Entity)list.get(field_615_ag.field_1037_n.nextInt(list.size())));
            }
        }
        int i = MathHelper.func_1108_b(field_611_ak);
        int k = MathHelper.func_1108_b(field_610_al);
        int i1 = MathHelper.func_1108_b(field_609_am);
        if(field_615_ag.func_4075_a().func_35554_b(i, k, i1) > 1.0F)
        {
            func_396_a(DamageSource.field_35540_b, 1);
        }
        for(int j = 0; j < 4; j++)
        {
            int l = MathHelper.func_1108_b(field_611_ak + (double)((float)((j % 2) * 2 - 1) * 0.25F));
            int j1 = MathHelper.func_1108_b(field_610_al);
            int k1 = MathHelper.func_1108_b(field_609_am + (double)((float)(((j / 2) % 2) * 2 - 1) * 0.25F));
            if(field_615_ag.func_600_a(l, j1, k1) == 0 && field_615_ag.func_4075_a().func_35554_b(l, j1, k1) < 0.8F && Block.field_428_aT.func_243_a(field_615_ag, l, j1, k1))
            {
                field_615_ag.func_690_d(l, j1, k1, Block.field_428_aT.field_376_bc);
            }
        }

    }

    protected void func_437_a(Entity entity, float f)
    {
        if(f < 10F)
        {
            double d = entity.field_611_ak - field_611_ak;
            double d1 = entity.field_609_am - field_609_am;
            if(field_9330_P == 0)
            {
                EntitySnowball entitysnowball = new EntitySnowball(field_615_ag, this);
                double d2 = (entity.field_610_al + (double)entity.func_373_s()) - 1.1000000238418579D - entitysnowball.field_610_al;
                float f1 = MathHelper.func_1109_a(d * d + d1 * d1) * 0.2F;
                field_615_ag.func_623_a(this, "random.bow", 1.0F, 1.0F / (field_9312_bd.nextFloat() * 0.4F + 0.8F));
                field_615_ag.func_674_a(entitysnowball);
                entitysnowball.func_40076_a(d, d2 + (double)f1, d1, 1.6F, 12F);
                field_9330_P = 10;
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
        return Item.field_308_aB.field_291_aS;
    }

    protected void func_21066_o(boolean flag, int i)
    {
        int j = field_9312_bd.nextInt(16);
        for(int k = 0; k < j; k++)
        {
            func_367_b(Item.field_308_aB.field_291_aS, 1);
        }

    }
}

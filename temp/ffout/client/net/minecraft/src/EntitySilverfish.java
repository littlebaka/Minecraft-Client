// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, EntityDamageSource, Entity, 
//            AxisAlignedBB, DamageSource, MathHelper, Block, 
//            Facing, BlockSilverfish, EnumCreatureAttribute, NBTTagCompound

public class EntitySilverfish extends EntityMob
{

    private int field_35189_a;

    public EntitySilverfish(World world)
    {
        super(world);
        field_9357_z = "/mob/silverfish.png";
        func_371_a(0.3F, 0.7F);
        field_9333_am = 0.6F;
        field_762_e = 1;
    }

    public int func_40117_c()
    {
        return 8;
    }

    protected boolean func_25021_m()
    {
        return false;
    }

    protected Entity func_438_i()
    {
        double d = 8D;
        return field_615_ag.func_40480_b(this, d);
    }

    protected String func_6389_d()
    {
        return "mob.silverfish.say";
    }

    protected String func_6394_f_()
    {
        return "mob.silverfish.hit";
    }

    protected String func_6390_f()
    {
        return "mob.silverfish.kill";
    }

    public boolean func_396_a(DamageSource damagesource, int i)
    {
        if(field_35189_a <= 0 && (damagesource instanceof EntityDamageSource))
        {
            field_35189_a = 20;
        }
        return super.func_396_a(damagesource, i);
    }

    protected void func_437_a(Entity entity, float f)
    {
        if(field_9330_P <= 0 && f < 1.2F && entity.field_601_au.field_1702_e > field_601_au.field_1697_b && entity.field_601_au.field_1697_b < field_601_au.field_1702_e)
        {
            field_9330_P = 20;
            entity.func_396_a(DamageSource.func_35525_a(this), field_762_e);
        }
    }

    protected void func_41002_a(int i, int j, int k, int l)
    {
        field_615_ag.func_623_a(this, "mob.silverfish.step", 1.0F, 1.0F);
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
        return 0;
    }

    public void func_370_e_()
    {
        field_735_n = field_605_aq;
        super.func_370_e_();
    }

    protected void func_418_b_()
    {
        super.func_418_b_();
        if(field_615_ag.field_1026_y)
        {
            return;
        }
        if(field_35189_a > 0)
        {
            field_35189_a--;
            if(field_35189_a == 0)
            {
                int i = MathHelper.func_1108_b(field_611_ak);
                int k = MathHelper.func_1108_b(field_610_al);
                int i1 = MathHelper.func_1108_b(field_609_am);
                boolean flag = false;
                for(int l1 = 0; !flag && l1 <= 5 && l1 >= -5; l1 = l1 > 0 ? 0 - l1 : 1 - l1)
                {
                    for(int j2 = 0; !flag && j2 <= 10 && j2 >= -10; j2 = j2 > 0 ? 0 - j2 : 1 - j2)
                    {
                        for(int k2 = 0; !flag && k2 <= 10 && k2 >= -10; k2 = k2 > 0 ? 0 - k2 : 1 - k2)
                        {
                            int l2 = field_615_ag.func_600_a(i + j2, k + l1, i1 + k2);
                            if(l2 != Block.field_35289_bm.field_376_bc)
                            {
                                continue;
                            }
                            field_615_ag.func_28106_e(2001, i + j2, k + l1, i1 + k2, Block.field_35289_bm.field_376_bc + field_615_ag.func_602_e(i + j2, k + l1, i1 + k2) * 256);
                            field_615_ag.func_690_d(i + j2, k + l1, i1 + k2, 0);
                            Block.field_35289_bm.func_252_b(field_615_ag, i + j2, k + l1, i1 + k2, 0);
                            if(!field_9312_bd.nextBoolean())
                            {
                                continue;
                            }
                            flag = true;
                            break;
                        }

                    }

                }

            }
        }
        if(field_751_f == null && !func_25031_E())
        {
            int j = MathHelper.func_1108_b(field_611_ak);
            int l = MathHelper.func_1108_b(field_610_al + 0.5D);
            int j1 = MathHelper.func_1108_b(field_609_am);
            int k1 = field_9312_bd.nextInt(6);
            int i2 = field_615_ag.func_600_a(j + Facing.field_31056_b[k1], l + Facing.field_31059_c[k1], j1 + Facing.field_31058_d[k1]);
            if(BlockSilverfish.func_35305_d(i2))
            {
                field_615_ag.func_688_b(j + Facing.field_31056_b[k1], l + Facing.field_31059_c[k1], j1 + Facing.field_31058_d[k1], Block.field_35289_bm.field_376_bc, BlockSilverfish.func_35304_f(i2));
                func_415_z();
                func_395_F();
            } else
            {
                func_31026_E();
            }
        } else
        if(field_751_f != null && !func_25031_E())
        {
            field_751_f = null;
        }
    }

    public float func_439_a(int i, int j, int k)
    {
        if(field_615_ag.func_600_a(i, j - 1, k) == Block.field_338_u.field_376_bc)
        {
            return 10F;
        } else
        {
            return super.func_439_a(i, j, k);
        }
    }

    protected boolean func_40147_Y()
    {
        return true;
    }

    public boolean func_433_a()
    {
        if(super.func_433_a())
        {
            EntityPlayer entityplayer = field_615_ag.func_609_a(this, 5D);
            return entityplayer == null;
        } else
        {
            return false;
        }
    }

    public EnumCreatureAttribute func_40124_t()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }
}

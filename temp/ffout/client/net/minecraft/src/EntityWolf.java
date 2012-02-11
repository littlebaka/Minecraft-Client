// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, EntitySheep, AxisAlignedBB, Entity, 
//            InventoryPlayer, ItemStack, Item, ItemFood, 
//            MathHelper, DamageSource, EntityArrow, EntityLiving

public class EntityWolf extends EntityAnimal
{

    private boolean field_25049_a;
    private float field_25048_b;
    private float field_25054_c;
    private boolean field_25053_f;
    private boolean field_25052_g;
    private float field_25051_h;
    private float field_25050_i;

    public EntityWolf(World world)
    {
        super(world);
        field_25049_a = false;
        field_9357_z = "/mob/wolf.png";
        func_371_a(0.8F, 0.8F);
        field_9333_am = 1.1F;
    }

    public int func_40117_c()
    {
        return !func_25047_D() ? 8 : 20;
    }

    protected void func_21057_b()
    {
        super.func_21057_b();
        field_21064_bx.func_21124_a(16, Byte.valueOf((byte)0));
        field_21064_bx.func_21124_a(17, "");
        field_21064_bx.func_21124_a(18, new Integer(func_40114_aH()));
    }

    protected boolean func_25021_m()
    {
        return false;
    }

    public String func_6376_z()
    {
        if(func_25047_D())
        {
            return "/mob/wolf_tame.png";
        }
        if(func_25040_C())
        {
            return "/mob/wolf_angry.png";
        } else
        {
            return super.func_6376_z();
        }
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
        nbttagcompound.func_748_a("Angry", func_25040_C());
        nbttagcompound.func_748_a("Sitting", func_25034_B());
        if(func_25045_A() == null)
        {
            nbttagcompound.func_754_a("Owner", "");
        } else
        {
            nbttagcompound.func_754_a("Owner", func_25045_A());
        }
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
        func_25041_c(nbttagcompound.func_760_m("Angry"));
        func_25046_b(nbttagcompound.func_760_m("Sitting"));
        String s = nbttagcompound.func_755_i("Owner");
        if(s.length() > 0)
        {
            func_25036_a(s);
            func_25038_d(true);
        }
    }

    protected boolean func_25023_u()
    {
        return func_25040_C();
    }

    protected String func_6389_d()
    {
        if(func_25040_C())
        {
            return "mob.wolf.growl";
        }
        if(field_9312_bd.nextInt(3) == 0)
        {
            if(func_25047_D() && field_21064_bx.func_25115_b(18) < 10)
            {
                return "mob.wolf.whine";
            } else
            {
                return "mob.wolf.panting";
            }
        } else
        {
            return "mob.wolf.bark";
        }
    }

    protected String func_6394_f_()
    {
        return "mob.wolf.hurt";
    }

    protected String func_6390_f()
    {
        return "mob.wolf.death";
    }

    protected float func_6393_h()
    {
        return 0.4F;
    }

    protected int func_422_g()
    {
        return -1;
    }

    protected void func_418_b_()
    {
        super.func_418_b_();
        if(!field_750_g && !func_25031_E() && func_25047_D() && field_616_af == null)
        {
            EntityPlayer entityplayer = field_615_ag.func_25099_a(func_25045_A());
            if(entityplayer != null)
            {
                float f = entityplayer.func_379_d(this);
                if(f > 5F)
                {
                    func_25044_b(entityplayer, f);
                }
            } else
            if(!func_27013_ag())
            {
                func_25046_b(true);
            }
        } else
        if(field_751_f == null && !func_25031_E() && !func_25047_D() && field_615_ag.field_1037_n.nextInt(100) == 0)
        {
            List list = field_615_ag.func_657_a(net.minecraft.src.EntitySheep.class, AxisAlignedBB.func_1161_b(field_611_ak, field_610_al, field_609_am, field_611_ak + 1.0D, field_610_al + 1.0D, field_609_am + 1.0D).func_1177_b(16D, 4D, 16D));
            if(!list.isEmpty())
            {
                func_25032_c((Entity)list.get(field_615_ag.field_1037_n.nextInt(list.size())));
            }
        }
        if(func_27013_ag())
        {
            func_25046_b(false);
        }
        if(!field_615_ag.field_1026_y)
        {
            field_21064_bx.func_21129_b(18, Integer.valueOf(func_40114_aH()));
        }
    }

    public void func_425_j()
    {
        super.func_425_j();
        field_25049_a = false;
        if(func_25025_V() && !func_25031_E() && !func_25040_C())
        {
            Entity entity = func_25024_W();
            if(entity instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                ItemStack itemstack = entityplayer.field_778_b.func_494_a();
                if(itemstack != null)
                {
                    if(!func_25047_D() && itemstack.field_1617_c == Item.field_21020_aV.field_291_aS)
                    {
                        field_25049_a = true;
                    } else
                    if(func_25047_D() && (Item.field_233_c[itemstack.field_1617_c] instanceof ItemFood))
                    {
                        field_25049_a = ((ItemFood)Item.field_233_c[itemstack.field_1617_c]).func_25012_m();
                    }
                }
            }
        }
        if(!field_615_ag.field_1026_y && field_25053_f && !field_25052_g && !func_25031_E() && field_9298_aH)
        {
            field_25052_g = true;
            field_25051_h = 0.0F;
            field_25050_i = 0.0F;
            field_615_ag.func_9425_a(this, (byte)8);
        }
    }

    public void func_370_e_()
    {
        super.func_370_e_();
        field_25054_c = field_25048_b;
        if(field_25049_a)
        {
            field_25048_b = field_25048_b + (1.0F - field_25048_b) * 0.4F;
        } else
        {
            field_25048_b = field_25048_b + (0.0F - field_25048_b) * 0.4F;
        }
        if(field_25049_a)
        {
            field_4127_c = 10;
        }
        if(func_27012_af())
        {
            field_25053_f = true;
            field_25052_g = false;
            field_25051_h = 0.0F;
            field_25050_i = 0.0F;
        } else
        if((field_25053_f || field_25052_g) && field_25052_g)
        {
            if(field_25051_h == 0.0F)
            {
                field_615_ag.func_623_a(this, "mob.wolf.shake", func_6393_h(), (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.2F + 1.0F);
            }
            field_25050_i = field_25051_h;
            field_25051_h += 0.05F;
            if(field_25050_i >= 2.0F)
            {
                field_25053_f = false;
                field_25052_g = false;
                field_25050_i = 0.0F;
                field_25051_h = 0.0F;
            }
            if(field_25051_h > 0.4F)
            {
                float f = (float)field_601_au.field_1697_b;
                int i = (int)(MathHelper.func_1106_a((field_25051_h - 0.4F) * 3.141593F) * 7F);
                for(int j = 0; j < i; j++)
                {
                    float f1 = (field_9312_bd.nextFloat() * 2.0F - 1.0F) * field_644_aC * 0.5F;
                    float f2 = (field_9312_bd.nextFloat() * 2.0F - 1.0F) * field_644_aC * 0.5F;
                    field_615_ag.func_694_a("splash", field_611_ak + (double)f1, f + 0.8F, field_609_am + (double)f2, field_608_an, field_607_ao, field_606_ap);
                }

            }
        }
    }

    public boolean func_25039_v()
    {
        return field_25053_f;
    }

    public float func_25043_b_(float f)
    {
        return 0.75F + ((field_25050_i + (field_25051_h - field_25050_i) * f) / 2.0F) * 0.25F;
    }

    public float func_25042_a(float f, float f1)
    {
        float f2 = (field_25050_i + (field_25051_h - field_25050_i) * f + f1) / 1.8F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        } else
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        return MathHelper.func_1106_a(f2 * 3.141593F) * MathHelper.func_1106_a(f2 * 3.141593F * 11F) * 0.15F * 3.141593F;
    }

    public float func_25033_c(float f)
    {
        return (field_25054_c + (field_25048_b - field_25054_c) * f) * 0.15F * 3.141593F;
    }

    public float func_373_s()
    {
        return field_643_aD * 0.8F;
    }

    public int func_25026_x()
    {
        if(func_25034_B())
        {
            return 20;
        } else
        {
            return super.func_25026_x();
        }
    }

    private void func_25044_b(Entity entity, float f)
    {
        PathEntity pathentity = field_615_ag.func_702_a(this, entity, 16F);
        if(pathentity == null && f > 12F)
        {
            int i = MathHelper.func_1108_b(entity.field_611_ak) - 2;
            int j = MathHelper.func_1108_b(entity.field_609_am) - 2;
            int k = MathHelper.func_1108_b(entity.field_601_au.field_1697_b);
            for(int l = 0; l <= 4; l++)
            {
                for(int i1 = 0; i1 <= 4; i1++)
                {
                    if((l < 1 || i1 < 1 || l > 3 || i1 > 3) && field_615_ag.func_28100_h(i + l, k - 1, j + i1) && !field_615_ag.func_28100_h(i + l, k, j + i1) && !field_615_ag.func_28100_h(i + l, k + 1, j + i1))
                    {
                        func_365_c((float)(i + l) + 0.5F, k, (float)(j + i1) + 0.5F, field_605_aq, field_604_ar);
                        return;
                    }
                }

            }

        } else
        {
            func_25029_a(pathentity);
        }
    }

    protected boolean func_25028_d_()
    {
        return func_25034_B() || field_25052_g;
    }

    public boolean func_396_a(DamageSource damagesource, int i)
    {
        Entity entity = damagesource.func_35532_a();
        func_25046_b(false);
        if(entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
        {
            i = (i + 1) / 2;
        }
        if(super.func_396_a(damagesource, i))
        {
            if(!func_25047_D() && !func_25040_C())
            {
                if(entity instanceof EntityPlayer)
                {
                    func_25041_c(true);
                    field_751_f = entity;
                }
                if((entity instanceof EntityArrow) && ((EntityArrow)entity).field_682_g != null)
                {
                    entity = ((EntityArrow)entity).field_682_g;
                }
                if(entity instanceof EntityLiving)
                {
                    List list = field_615_ag.func_657_a(net.minecraft.src.EntityWolf.class, AxisAlignedBB.func_1161_b(field_611_ak, field_610_al, field_609_am, field_611_ak + 1.0D, field_610_al + 1.0D, field_609_am + 1.0D).func_1177_b(16D, 4D, 16D));
                    Iterator iterator = list.iterator();
                    do
                    {
                        if(!iterator.hasNext())
                        {
                            break;
                        }
                        Entity entity1 = (Entity)iterator.next();
                        EntityWolf entitywolf = (EntityWolf)entity1;
                        if(!entitywolf.func_25047_D() && entitywolf.field_751_f == null)
                        {
                            entitywolf.field_751_f = entity;
                            if(entity instanceof EntityPlayer)
                            {
                                entitywolf.func_25041_c(true);
                            }
                        }
                    } while(true);
                }
            } else
            if(entity != this && entity != null)
            {
                if(func_25047_D() && (entity instanceof EntityPlayer) && ((EntityPlayer)entity).field_771_i.equalsIgnoreCase(func_25045_A()))
                {
                    return true;
                }
                field_751_f = entity;
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected Entity func_438_i()
    {
        if(func_25040_C())
        {
            return field_615_ag.func_609_a(this, 16D);
        } else
        {
            return null;
        }
    }

    protected void func_437_a(Entity entity, float f)
    {
        if(f > 2.0F && f < 6F && field_9312_bd.nextInt(10) == 0)
        {
            if(field_9298_aH)
            {
                double d = entity.field_611_ak - field_611_ak;
                double d1 = entity.field_609_am - field_609_am;
                float f1 = MathHelper.func_1109_a(d * d + d1 * d1);
                field_608_an = (d / (double)f1) * 0.5D * 0.80000001192092896D + field_608_an * 0.20000000298023224D;
                field_606_ap = (d1 / (double)f1) * 0.5D * 0.80000001192092896D + field_606_ap * 0.20000000298023224D;
                field_607_ao = 0.40000000596046448D;
            }
        } else
        if((double)f < 1.5D && entity.field_601_au.field_1702_e > field_601_au.field_1697_b && entity.field_601_au.field_1697_b < field_601_au.field_1702_e)
        {
            field_9330_P = 20;
            byte byte0 = 2;
            if(func_25047_D())
            {
                byte0 = 4;
            }
            entity.func_396_a(DamageSource.func_35525_a(this), byte0);
        }
    }

    public boolean func_353_a(EntityPlayer entityplayer)
    {
        ItemStack itemstack = entityplayer.field_778_b.func_494_a();
        if(!func_25047_D())
        {
            if(itemstack != null && itemstack.field_1617_c == Item.field_21020_aV.field_291_aS && !func_25040_C())
            {
                itemstack.field_1615_a--;
                if(itemstack.field_1615_a <= 0)
                {
                    entityplayer.field_778_b.func_472_a(entityplayer.field_778_b.field_847_d, null);
                }
                if(!field_615_ag.field_1026_y)
                {
                    if(field_9312_bd.nextInt(3) == 0)
                    {
                        func_25038_d(true);
                        func_25029_a(null);
                        func_25046_b(true);
                        func_40121_k(20);
                        func_25036_a(entityplayer.field_771_i);
                        func_25035_a(true);
                        field_615_ag.func_9425_a(this, (byte)7);
                    } else
                    {
                        func_25035_a(false);
                        field_615_ag.func_9425_a(this, (byte)6);
                    }
                }
                return true;
            }
        } else
        {
            if(itemstack != null && (Item.field_233_c[itemstack.field_1617_c] instanceof ItemFood))
            {
                ItemFood itemfood = (ItemFood)Item.field_233_c[itemstack.field_1617_c];
                if(itemfood.func_25012_m() && field_21064_bx.func_25115_b(18) < 20)
                {
                    itemstack.field_1615_a--;
                    func_432_b(itemfood.func_25011_l());
                    if(itemstack.field_1615_a <= 0)
                    {
                        entityplayer.field_778_b.func_472_a(entityplayer.field_778_b.field_847_d, null);
                    }
                    return true;
                }
            }
            if(entityplayer.field_771_i.equalsIgnoreCase(func_25045_A()))
            {
                if(!field_615_ag.field_1026_y)
                {
                    func_25046_b(!func_25034_B());
                    field_9336_ak = false;
                    func_25029_a(null);
                }
                return true;
            }
        }
        return super.func_353_a(entityplayer);
    }

    void func_25035_a(boolean flag)
    {
        String s = "heart";
        if(!flag)
        {
            s = "smoke";
        }
        for(int i = 0; i < 7; i++)
        {
            double d = field_9312_bd.nextGaussian() * 0.02D;
            double d1 = field_9312_bd.nextGaussian() * 0.02D;
            double d2 = field_9312_bd.nextGaussian() * 0.02D;
            field_615_ag.func_694_a(s, (field_611_ak + (double)(field_9312_bd.nextFloat() * field_644_aC * 2.0F)) - (double)field_644_aC, field_610_al + 0.5D + (double)(field_9312_bd.nextFloat() * field_643_aD), (field_609_am + (double)(field_9312_bd.nextFloat() * field_644_aC * 2.0F)) - (double)field_644_aC, d, d1, d2);
        }

    }

    public void func_9282_a(byte byte0)
    {
        if(byte0 == 7)
        {
            func_25035_a(true);
        } else
        if(byte0 == 6)
        {
            func_25035_a(false);
        } else
        if(byte0 == 8)
        {
            field_25052_g = true;
            field_25051_h = 0.0F;
            field_25050_i = 0.0F;
        } else
        {
            super.func_9282_a(byte0);
        }
    }

    public float func_25037_z()
    {
        if(func_25040_C())
        {
            return 1.53938F;
        }
        if(func_25047_D())
        {
            return (0.55F - (float)(20 - field_21064_bx.func_25115_b(18)) * 0.02F) * 3.141593F;
        } else
        {
            return 0.6283185F;
        }
    }

    public int func_6391_i()
    {
        return 8;
    }

    public String func_25045_A()
    {
        return field_21064_bx.func_25116_c(17);
    }

    public void func_25036_a(String s)
    {
        field_21064_bx.func_21129_b(17, s);
    }

    public boolean func_25034_B()
    {
        return (field_21064_bx.func_21130_a(16) & 1) != 0;
    }

    public void func_25046_b(boolean flag)
    {
        byte byte0 = field_21064_bx.func_21130_a(16);
        if(flag)
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 | 1)));
        } else
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 & -2)));
        }
    }

    public boolean func_25040_C()
    {
        return (field_21064_bx.func_21130_a(16) & 2) != 0;
    }

    public void func_25041_c(boolean flag)
    {
        byte byte0 = field_21064_bx.func_21130_a(16);
        if(flag)
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 | 2)));
        } else
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 & -3)));
        }
    }

    public boolean func_25047_D()
    {
        return (field_21064_bx.func_21130_a(16) & 4) != 0;
    }

    public void func_25038_d(boolean flag)
    {
        byte byte0 = field_21064_bx.func_21130_a(16);
        if(flag)
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 | 4)));
        } else
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 & -5)));
        }
    }

    protected EntityAnimal func_40145_a(EntityAnimal entityanimal)
    {
        return new EntityWolf(field_615_ag);
    }
}

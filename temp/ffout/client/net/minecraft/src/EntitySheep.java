// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, ItemStack, Block, 
//            MathHelper, World, BlockTallGrass, BlockGrass, 
//            EntityPlayer, InventoryPlayer, Item, ItemShears, 
//            EntityItem, NBTTagCompound

public class EntitySheep extends EntityAnimal
{

    public static final float field_21075_a[][] = {
        {
            1.0F, 1.0F, 1.0F
        }, {
            0.95F, 0.7F, 0.2F
        }, {
            0.9F, 0.5F, 0.85F
        }, {
            0.6F, 0.7F, 0.95F
        }, {
            0.9F, 0.9F, 0.2F
        }, {
            0.5F, 0.8F, 0.1F
        }, {
            0.95F, 0.7F, 0.8F
        }, {
            0.3F, 0.3F, 0.3F
        }, {
            0.6F, 0.6F, 0.6F
        }, {
            0.3F, 0.6F, 0.7F
        }, {
            0.7F, 0.4F, 0.9F
        }, {
            0.2F, 0.4F, 0.8F
        }, {
            0.5F, 0.4F, 0.3F
        }, {
            0.4F, 0.5F, 0.2F
        }, {
            0.8F, 0.3F, 0.3F
        }, {
            0.1F, 0.1F, 0.1F
        }
    };
    private int field_44004_b;

    public EntitySheep(World world)
    {
        super(world);
        field_9357_z = "/mob/sheep.png";
        func_371_a(0.9F, 1.3F);
    }

    public int func_40117_c()
    {
        return 8;
    }

    protected void func_21057_b()
    {
        super.func_21057_b();
        field_21064_bx.func_21124_a(16, new Byte((byte)0));
    }

    protected void func_21066_o(boolean flag, int i)
    {
        if(!func_21072_p())
        {
            func_21058_a(new ItemStack(Block.field_419_ac.field_376_bc, 1, func_21074_p_()), 0.0F);
        }
    }

    protected int func_422_g()
    {
        return Block.field_419_ac.field_376_bc;
    }

    public void func_425_j()
    {
        super.func_425_j();
        if(field_44004_b > 0)
        {
            field_44004_b--;
        }
    }

    protected void func_424_C()
    {
        if(field_44004_b <= 0)
        {
            super.func_424_C();
        }
    }

    protected void func_418_b_()
    {
        super.func_418_b_();
        if(!func_25031_E() && field_44004_b <= 0 && (func_40127_l() && field_9312_bd.nextInt(50) == 0 || field_9312_bd.nextInt(1000) == 0))
        {
            int i = MathHelper.func_1108_b(field_611_ak);
            int k = MathHelper.func_1108_b(field_610_al);
            int i1 = MathHelper.func_1108_b(field_609_am);
            if(field_615_ag.func_600_a(i, k, i1) == Block.field_9257_X.field_376_bc && field_615_ag.func_602_e(i, k, i1) == 1 || field_615_ag.func_600_a(i, k - 1, i1) == Block.field_337_v.field_376_bc)
            {
                field_44004_b = 40;
                field_615_ag.func_9425_a(this, (byte)10);
            }
        } else
        if(field_44004_b == 4)
        {
            int j = MathHelper.func_1108_b(field_611_ak);
            int l = MathHelper.func_1108_b(field_610_al);
            int j1 = MathHelper.func_1108_b(field_609_am);
            boolean flag = false;
            if(field_615_ag.func_600_a(j, l, j1) == Block.field_9257_X.field_376_bc)
            {
                field_615_ag.func_28106_e(2001, j, l, j1, Block.field_9257_X.field_376_bc + 256);
                field_615_ag.func_690_d(j, l, j1, 0);
                flag = true;
            } else
            if(field_615_ag.func_600_a(j, l - 1, j1) == Block.field_337_v.field_376_bc)
            {
                field_615_ag.func_28106_e(2001, j, l - 1, j1, Block.field_337_v.field_376_bc);
                field_615_ag.func_690_d(j, l - 1, j1, Block.field_336_w.field_376_bc);
                flag = true;
            }
            if(flag)
            {
                func_21073_a(false);
                if(func_40127_l())
                {
                    int k1 = func_40146_g() + 1200;
                    if(k1 > 0)
                    {
                        k1 = 0;
                    }
                    func_40142_a_(k1);
                }
            }
        }
    }

    public void func_9282_a(byte byte0)
    {
        if(byte0 == 10)
        {
            field_44004_b = 40;
        } else
        {
            super.func_9282_a(byte0);
        }
    }

    protected boolean func_25028_d_()
    {
        return field_44004_b > 0;
    }

    public float func_44003_c(float f)
    {
        if(field_44004_b <= 0)
        {
            return 0.0F;
        }
        if(field_44004_b >= 4 && field_44004_b <= 36)
        {
            return 1.0F;
        }
        if(field_44004_b < 4)
        {
            return ((float)field_44004_b - f) / 4F;
        } else
        {
            return -((float)(field_44004_b - 40) - f) / 4F;
        }
    }

    public float func_44002_d(float f)
    {
        if(field_44004_b > 4 && field_44004_b <= 36)
        {
            float f1 = ((float)(field_44004_b - 4) - f) / 32F;
            return 0.6283185F + 0.2199115F * MathHelper.func_1106_a(f1 * 28.7F);
        }
        if(field_44004_b > 0)
        {
            return 0.6283185F;
        } else
        {
            return field_604_ar / 57.29578F;
        }
    }

    public boolean func_353_a(EntityPlayer entityplayer)
    {
        ItemStack itemstack = entityplayer.field_778_b.func_494_a();
        if(itemstack != null && itemstack.field_1617_c == Item.field_31001_bc.field_291_aS && !func_21072_p() && !func_40127_l())
        {
            if(!field_615_ag.field_1026_y)
            {
                func_21073_a(true);
                int i = 1 + field_9312_bd.nextInt(3);
                for(int j = 0; j < i; j++)
                {
                    EntityItem entityitem = func_21058_a(new ItemStack(Block.field_419_ac.field_376_bc, 1, func_21074_p_()), 1.0F);
                    entityitem.field_607_ao += field_9312_bd.nextFloat() * 0.05F;
                    entityitem.field_608_an += (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.1F;
                    entityitem.field_606_ap += (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.1F;
                }

            }
            itemstack.func_25190_a(1, entityplayer);
        }
        return super.func_353_a(entityplayer);
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
        nbttagcompound.func_748_a("Sheared", func_21072_p());
        nbttagcompound.func_761_a("Color", (byte)func_21074_p_());
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
        func_21073_a(nbttagcompound.func_760_m("Sheared"));
        func_21071_b_(nbttagcompound.func_746_c("Color"));
    }

    protected String func_6389_d()
    {
        return "mob.sheep";
    }

    protected String func_6394_f_()
    {
        return "mob.sheep";
    }

    protected String func_6390_f()
    {
        return "mob.sheep";
    }

    public int func_21074_p_()
    {
        return field_21064_bx.func_21130_a(16) & 0xf;
    }

    public void func_21071_b_(int i)
    {
        byte byte0 = field_21064_bx.func_21130_a(16);
        field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 & 0xf0 | i & 0xf)));
    }

    public boolean func_21072_p()
    {
        return (field_21064_bx.func_21130_a(16) & 0x10) != 0;
    }

    public void func_21073_a(boolean flag)
    {
        byte byte0 = field_21064_bx.func_21130_a(16);
        if(flag)
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 | 0x10)));
        } else
        {
            field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(byte0 & 0xffffffef)));
        }
    }

    public static int func_21070_a(Random random)
    {
        int i = random.nextInt(100);
        if(i < 5)
        {
            return 15;
        }
        if(i < 10)
        {
            return 7;
        }
        if(i < 15)
        {
            return 8;
        }
        if(i < 18)
        {
            return 12;
        }
        return random.nextInt(500) != 0 ? 0 : 6;
    }

    protected EntityAnimal func_40145_a(EntityAnimal entityanimal)
    {
        EntitySheep entitysheep = (EntitySheep)entityanimal;
        EntitySheep entitysheep1 = new EntitySheep(field_615_ag);
        if(field_9312_bd.nextBoolean())
        {
            entitysheep1.func_21071_b_(func_21074_p_());
        } else
        {
            entitysheep1.func_21071_b_(entitysheep.func_21074_p_());
        }
        return entitysheep1;
    }

}

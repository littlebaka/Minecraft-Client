// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, MathHelper, ItemStack, EntityPlayer, 
//            World, Block, BlockSapling, BlockFlower, 
//            BlockMushroom, BlockStem, BlockCrops, BlockGrass, 
//            BlockTallGrass, EntitySheep, BlockCloth, EntityLiving

public class ItemDye extends Item
{

    public static final String field_21023_a[] = {
        "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", 
        "lime", "yellow", "lightBlue", "magenta", "orange", "white"
    };
    public static final int field_31002_bk[] = {
        0x1e1b1b, 0xb3312c, 0x3b511a, 0x51301a, 0x253192, 0x7b2fbe, 0x287697, 0x287697, 0x434343, 0xd88198, 
        0x41cd34, 0xdecf2a, 0x6689d3, 0xc354cd, 0xeb8844, 0xf0f0f0
    };

    public ItemDye(int i)
    {
        super(i);
        func_21015_a(true);
        func_21013_d(0);
    }

    public int func_27009_a(int i)
    {
        int j = MathHelper.func_41084_a(i, 0, 15);
        return field_4018_aZ + (j % 8) * 16 + j / 8;
    }

    public String func_21011_b(ItemStack itemstack)
    {
        int i = MathHelper.func_41084_a(itemstack.func_21181_i(), 0, 15);
        return (new StringBuilder()).append(super.func_20009_a()).append(".").append(field_21023_a[i]).toString();
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(!entityplayer.func_35190_e(i, j, k))
        {
            return false;
        }
        if(itemstack.func_21181_i() == 15)
        {
            int i1 = world.func_600_a(i, j, k);
            if(i1 == Block.field_333_z.field_376_bc)
            {
                if(!world.field_1026_y)
                {
                    ((BlockSapling)Block.field_333_z).func_21028_c(world, i, j, k, world.field_1037_n);
                    itemstack.field_1615_a--;
                }
                return true;
            }
            if(i1 == Block.field_415_ag.field_376_bc || i1 == Block.field_414_ah.field_376_bc)
            {
                if(!world.field_1026_y && ((BlockMushroom)Block.field_345_n[i1]).func_35293_c(world, i, j, k, world.field_1037_n))
                {
                    itemstack.field_1615_a--;
                }
                return true;
            }
            if(i1 == Block.field_35283_bu.field_376_bc || i1 == Block.field_35284_bt.field_376_bc)
            {
                if(!world.field_1026_y)
                {
                    ((BlockStem)Block.field_345_n[i1]).func_35294_i(world, i, j, k);
                    itemstack.field_1615_a--;
                }
                return true;
            }
            if(i1 == Block.field_447_aA.field_376_bc)
            {
                if(!world.field_1026_y)
                {
                    ((BlockCrops)Block.field_447_aA).func_21027_c_(world, i, j, k);
                    itemstack.field_1615_a--;
                }
                return true;
            }
            if(i1 == Block.field_337_v.field_376_bc)
            {
                if(!world.field_1026_y)
                {
                    itemstack.field_1615_a--;
label0:
                    for(int j1 = 0; j1 < 128; j1++)
                    {
                        int k1 = i;
                        int l1 = j + 1;
                        int i2 = k;
                        for(int j2 = 0; j2 < j1 / 16; j2++)
                        {
                            k1 += field_4015_b.nextInt(3) - 1;
                            l1 += ((field_4015_b.nextInt(3) - 1) * field_4015_b.nextInt(3)) / 2;
                            i2 += field_4015_b.nextInt(3) - 1;
                            if(world.func_600_a(k1, l1 - 1, i2) != Block.field_337_v.field_376_bc || world.func_28100_h(k1, l1, i2))
                            {
                                continue label0;
                            }
                        }

                        if(world.func_600_a(k1, l1, i2) != 0)
                        {
                            continue;
                        }
                        if(field_4015_b.nextInt(10) != 0)
                        {
                            world.func_688_b(k1, l1, i2, Block.field_9257_X.field_376_bc, 1);
                            continue;
                        }
                        if(field_4015_b.nextInt(3) != 0)
                        {
                            world.func_690_d(k1, l1, i2, Block.field_417_ae.field_376_bc);
                        } else
                        {
                            world.func_690_d(k1, l1, i2, Block.field_416_af.field_376_bc);
                        }
                    }

                }
                return true;
            }
        }
        return false;
    }

    public void func_4019_b(ItemStack itemstack, EntityLiving entityliving)
    {
        if(entityliving instanceof EntitySheep)
        {
            EntitySheep entitysheep = (EntitySheep)entityliving;
            int i = BlockCloth.func_21034_c(itemstack.func_21181_i());
            if(!entitysheep.func_21072_p() && entitysheep.func_21074_p_() != i)
            {
                entitysheep.func_21071_b_(i);
                itemstack.field_1615_a--;
            }
        }
    }

}

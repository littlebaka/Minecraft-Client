// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, Block, World, 
//            IBlockAccess, TileEntityDispenser, EntityPlayer, ItemStack, 
//            Item, EntityArrow, EntityEgg, EntitySnowball, 
//            ItemPotion, EntityPotion, EntityItem, EntityLiving, 
//            MathHelper, IInventory, TileEntity

public class BlockDispenser extends BlockContainer
{

    private Random field_28035_a;

    protected BlockDispenser(int i)
    {
        super(i, Material.field_1334_d);
        field_28035_a = new Random();
        field_378_bb = 45;
    }

    public int func_4025_d()
    {
        return 4;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Block.field_9265_P.field_376_bc;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        super.func_235_e(world, i, j, k);
        func_21032_h(world, i, j, k);
    }

    private void func_21032_h(World world, int i, int j, int k)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int l = world.func_600_a(i, j, k - 1);
        int i1 = world.func_600_a(i, j, k + 1);
        int j1 = world.func_600_a(i - 1, j, k);
        int k1 = world.func_600_a(i + 1, j, k);
        byte byte0 = 3;
        if(Block.field_343_p[l] && !Block.field_343_p[i1])
        {
            byte0 = 3;
        }
        if(Block.field_343_p[i1] && !Block.field_343_p[l])
        {
            byte0 = 2;
        }
        if(Block.field_343_p[j1] && !Block.field_343_p[k1])
        {
            byte0 = 5;
        }
        if(Block.field_343_p[k1] && !Block.field_343_p[j1])
        {
            byte0 = 4;
        }
        world.func_691_b(i, j, k, byte0);
    }

    public int func_211_a(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return field_378_bb + 17;
        }
        if(l == 0)
        {
            return field_378_bb + 17;
        }
        int i1 = iblockaccess.func_602_e(i, j, k);
        if(l != i1)
        {
            return field_378_bb;
        } else
        {
            return field_378_bb + 1;
        }
    }

    public int func_218_a(int i)
    {
        if(i == 1)
        {
            return field_378_bb + 17;
        }
        if(i == 0)
        {
            return field_378_bb + 17;
        }
        if(i == 3)
        {
            return field_378_bb + 1;
        } else
        {
            return field_378_bb;
        }
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        }
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.func_603_b(i, j, k);
        if(tileentitydispenser != null)
        {
            entityplayer.func_21092_a(tileentitydispenser);
        }
        return true;
    }

    private void func_21033_c(World world, int i, int j, int k, Random random)
    {
        int l = world.func_602_e(i, j, k);
        int i1 = 0;
        int j1 = 0;
        if(l == 3)
        {
            j1 = 1;
        } else
        if(l == 2)
        {
            j1 = -1;
        } else
        if(l == 5)
        {
            i1 = 1;
        } else
        {
            i1 = -1;
        }
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.func_603_b(i, j, k);
        if(tileentitydispenser != null)
        {
            ItemStack itemstack = tileentitydispenser.func_21100_b();
            double d = (double)i + (double)i1 * 0.59999999999999998D + 0.5D;
            double d1 = (double)j + 0.5D;
            double d2 = (double)k + (double)j1 * 0.59999999999999998D + 0.5D;
            if(itemstack == null)
            {
                world.func_28106_e(1001, i, j, k, 0);
            } else
            {
                if(itemstack.field_1617_c == Item.field_226_j.field_291_aS)
                {
                    EntityArrow entityarrow = new EntityArrow(world, d, d1, d2);
                    entityarrow.func_408_a(i1, 0.10000000149011612D, j1, 1.1F, 6F);
                    entityarrow.field_28020_a = true;
                    world.func_674_a(entityarrow);
                    world.func_28106_e(1002, i, j, k, 0);
                } else
                if(itemstack.field_1617_c == Item.field_296_aN.field_291_aS)
                {
                    EntityEgg entityegg = new EntityEgg(world, d, d1, d2);
                    entityegg.func_40076_a(i1, 0.10000000149011612D, j1, 1.1F, 6F);
                    world.func_674_a(entityegg);
                    world.func_28106_e(1002, i, j, k, 0);
                } else
                if(itemstack.field_1617_c == Item.field_308_aB.field_291_aS)
                {
                    EntitySnowball entitysnowball = new EntitySnowball(world, d, d1, d2);
                    entitysnowball.func_40076_a(i1, 0.10000000149011612D, j1, 1.1F, 6F);
                    world.func_674_a(entitysnowball);
                    world.func_28106_e(1002, i, j, k, 0);
                } else
                if(itemstack.field_1617_c == Item.field_40413_bs.field_291_aS && ItemPotion.func_40433_c(itemstack.func_21181_i()))
                {
                    EntityPotion entitypotion = new EntityPotion(world, d, d1, d2, itemstack.func_21181_i());
                    entitypotion.func_40076_a(i1, 0.10000000149011612D, j1, 1.375F, 3F);
                    world.func_674_a(entitypotion);
                    world.func_28106_e(1002, i, j, k, 0);
                } else
                {
                    EntityItem entityitem = new EntityItem(world, d, d1 - 0.29999999999999999D, d2, itemstack);
                    double d3 = random.nextDouble() * 0.10000000000000001D + 0.20000000000000001D;
                    entityitem.field_608_an = (double)i1 * d3;
                    entityitem.field_607_ao = 0.20000000298023224D;
                    entityitem.field_606_ap = (double)j1 * d3;
                    entityitem.field_608_an += random.nextGaussian() * 0.0074999998323619366D * 6D;
                    entityitem.field_607_ao += random.nextGaussian() * 0.0074999998323619366D * 6D;
                    entityitem.field_606_ap += random.nextGaussian() * 0.0074999998323619366D * 6D;
                    world.func_674_a(entityitem);
                    world.func_28106_e(1000, i, j, k, 0);
                }
                world.func_28106_e(2000, i, j, k, i1 + 1 + (j1 + 1) * 3);
            }
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(l > 0 && Block.field_345_n[l].func_209_d())
        {
            boolean flag = world.func_625_o(i, j, k) || world.func_625_o(i, j + 1, k);
            if(flag)
            {
                world.func_22136_c(i, j, k, field_376_bc, func_4025_d());
            }
        }
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(!world.field_1026_y && (world.func_625_o(i, j, k) || world.func_625_o(i, j + 1, k)))
        {
            func_21033_c(world, i, j, k, random);
        }
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityDispenser();
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.func_1108_b((double)((entityliving.field_605_aq * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.func_691_b(i, j, k, 2);
        }
        if(l == 1)
        {
            world.func_691_b(i, j, k, 5);
        }
        if(l == 2)
        {
            world.func_691_b(i, j, k, 3);
        }
        if(l == 3)
        {
            world.func_691_b(i, j, k, 4);
        }
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)world.func_603_b(i, j, k);
        if(tileentitydispenser != null)
        {
label0:
            for(int l = 0; l < tileentitydispenser.func_469_c(); l++)
            {
                ItemStack itemstack = tileentitydispenser.func_468_c(l);
                if(itemstack == null)
                {
                    continue;
                }
                float f = field_28035_a.nextFloat() * 0.8F + 0.1F;
                float f1 = field_28035_a.nextFloat() * 0.8F + 0.1F;
                float f2 = field_28035_a.nextFloat() * 0.8F + 0.1F;
                do
                {
                    if(itemstack.field_1615_a <= 0)
                    {
                        continue label0;
                    }
                    int i1 = field_28035_a.nextInt(21) + 10;
                    if(i1 > itemstack.field_1615_a)
                    {
                        i1 = itemstack.field_1615_a;
                    }
                    itemstack.field_1615_a -= i1;
                    EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.field_1617_c, i1, itemstack.func_21181_i()));
                    float f3 = 0.05F;
                    entityitem.field_608_an = (float)field_28035_a.nextGaussian() * f3;
                    entityitem.field_607_ao = (float)field_28035_a.nextGaussian() * f3 + 0.2F;
                    entityitem.field_606_ap = (float)field_28035_a.nextGaussian() * f3;
                    world.func_674_a(entityitem);
                } while(true);
            }

        }
        super.func_214_b(world, i, j, k);
    }
}

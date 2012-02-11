// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, Block, World, 
//            IBlockAccess, TileEntityFurnace, EntityPlayer, TileEntity, 
//            EntityLiving, MathHelper, IInventory, ItemStack, 
//            EntityItem

public class BlockFurnace extends BlockContainer
{

    private Random field_28036_a;
    private final boolean field_456_a;
    private static boolean field_28037_c = false;

    protected BlockFurnace(int i, boolean flag)
    {
        super(i, Material.field_1334_d);
        field_28036_a = new Random();
        field_456_a = flag;
        field_378_bb = 45;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Block.field_445_aC.field_376_bc;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        super.func_235_e(world, i, j, k);
        func_284_h(world, i, j, k);
    }

    private void func_284_h(World world, int i, int j, int k)
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
        }
        if(field_456_a)
        {
            return field_378_bb + 16;
        } else
        {
            return field_378_bb - 1;
        }
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        if(!field_456_a)
        {
            return;
        }
        int l = world.func_602_e(i, j, k);
        float f = (float)i + 0.5F;
        float f1 = (float)j + 0.0F + (random.nextFloat() * 6F) / 16F;
        float f2 = (float)k + 0.5F;
        float f3 = 0.52F;
        float f4 = random.nextFloat() * 0.6F - 0.3F;
        if(l == 4)
        {
            world.func_694_a("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 5)
        {
            world.func_694_a("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 2)
        {
            world.func_694_a("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 3)
        {
            world.func_694_a("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
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
            return field_378_bb - 1;
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
        TileEntityFurnace tileentityfurnace = (TileEntityFurnace)world.func_603_b(i, j, k);
        if(tileentityfurnace != null)
        {
            entityplayer.func_453_a(tileentityfurnace);
        }
        return true;
    }

    public static void func_285_a(boolean flag, World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        TileEntity tileentity = world.func_603_b(i, j, k);
        field_28037_c = true;
        if(flag)
        {
            world.func_690_d(i, j, k, Block.field_444_aD.field_376_bc);
        } else
        {
            world.func_690_d(i, j, k, Block.field_445_aC.field_376_bc);
        }
        field_28037_c = false;
        world.func_691_b(i, j, k, l);
        if(tileentity != null)
        {
            tileentity.func_31004_j();
            world.func_654_a(i, j, k, tileentity);
        }
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityFurnace();
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
        if(!field_28037_c)
        {
            TileEntityFurnace tileentityfurnace = (TileEntityFurnace)world.func_603_b(i, j, k);
            if(tileentityfurnace != null)
            {
label0:
                for(int l = 0; l < tileentityfurnace.func_469_c(); l++)
                {
                    ItemStack itemstack = tileentityfurnace.func_468_c(l);
                    if(itemstack == null)
                    {
                        continue;
                    }
                    float f = field_28036_a.nextFloat() * 0.8F + 0.1F;
                    float f1 = field_28036_a.nextFloat() * 0.8F + 0.1F;
                    float f2 = field_28036_a.nextFloat() * 0.8F + 0.1F;
                    do
                    {
                        if(itemstack.field_1615_a <= 0)
                        {
                            continue label0;
                        }
                        int i1 = field_28036_a.nextInt(21) + 10;
                        if(i1 > itemstack.field_1615_a)
                        {
                            i1 = itemstack.field_1615_a;
                        }
                        itemstack.field_1615_a -= i1;
                        EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.field_1617_c, i1, itemstack.func_21181_i()));
                        float f3 = 0.05F;
                        entityitem.field_608_an = (float)field_28036_a.nextGaussian() * f3;
                        entityitem.field_607_ao = (float)field_28036_a.nextGaussian() * f3 + 0.2F;
                        entityitem.field_606_ap = (float)field_28036_a.nextGaussian() * f3;
                        world.func_674_a(entityitem);
                    } while(true);
                }

            }
        }
        super.func_214_b(world, i, j, k);
    }

}

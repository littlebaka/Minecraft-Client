// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, World, EntityLiving, 
//            MathHelper, Block, IBlockAccess, TileEntityChest, 
//            IInventory, ItemStack, EntityItem, NBTTagCompound, 
//            InventoryLargeChest, EntityPlayer, TileEntity

public class BlockChest extends BlockContainer
{

    private Random field_457_a;

    protected BlockChest(int i)
    {
        super(i, Material.field_1335_c);
        field_457_a = new Random();
        field_378_bb = 26;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_210_f()
    {
        return 22;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        super.func_235_e(world, i, j, k);
        func_35306_h(world, i, j, k);
        int l = world.func_600_a(i, j, k - 1);
        int i1 = world.func_600_a(i, j, k + 1);
        int j1 = world.func_600_a(i - 1, j, k);
        int k1 = world.func_600_a(i + 1, j, k);
        if(l == field_376_bc)
        {
            func_35306_h(world, i, j, k - 1);
        }
        if(i1 == field_376_bc)
        {
            func_35306_h(world, i, j, k + 1);
        }
        if(j1 == field_376_bc)
        {
            func_35306_h(world, i - 1, j, k);
        }
        if(k1 == field_376_bc)
        {
            func_35306_h(world, i + 1, j, k);
        }
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = world.func_600_a(i, j, k - 1);
        int i1 = world.func_600_a(i, j, k + 1);
        int j1 = world.func_600_a(i - 1, j, k);
        int k1 = world.func_600_a(i + 1, j, k);
        byte byte0 = 0;
        int l1 = MathHelper.func_1108_b((double)((entityliving.field_605_aq * 4F) / 360F) + 0.5D) & 3;
        if(l1 == 0)
        {
            byte0 = 2;
        }
        if(l1 == 1)
        {
            byte0 = 5;
        }
        if(l1 == 2)
        {
            byte0 = 3;
        }
        if(l1 == 3)
        {
            byte0 = 4;
        }
        if(l != field_376_bc && i1 != field_376_bc && j1 != field_376_bc && k1 != field_376_bc)
        {
            world.func_691_b(i, j, k, byte0);
        } else
        {
            if((l == field_376_bc || i1 == field_376_bc) && (byte0 == 4 || byte0 == 5))
            {
                if(l == field_376_bc)
                {
                    world.func_691_b(i, j, k - 1, byte0);
                } else
                {
                    world.func_691_b(i, j, k + 1, byte0);
                }
                world.func_691_b(i, j, k, byte0);
            }
            if((j1 == field_376_bc || k1 == field_376_bc) && (byte0 == 2 || byte0 == 3))
            {
                if(j1 == field_376_bc)
                {
                    world.func_691_b(i - 1, j, k, byte0);
                } else
                {
                    world.func_691_b(i + 1, j, k, byte0);
                }
                world.func_691_b(i, j, k, byte0);
            }
        }
    }

    public void func_35306_h(World world, int i, int j, int k)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int l = world.func_600_a(i, j, k - 1);
        int i1 = world.func_600_a(i, j, k + 1);
        int j1 = world.func_600_a(i - 1, j, k);
        int k1 = world.func_600_a(i + 1, j, k);
        byte byte0 = 4;
        if(l == field_376_bc || i1 == field_376_bc)
        {
            int l1 = world.func_600_a(i - 1, j, l != field_376_bc ? k + 1 : k - 1);
            int j2 = world.func_600_a(i + 1, j, l != field_376_bc ? k + 1 : k - 1);
            byte0 = 5;
            int l2 = -1;
            if(l == field_376_bc)
            {
                l2 = world.func_602_e(i, j, k - 1);
            } else
            {
                l2 = world.func_602_e(i, j, k + 1);
            }
            if(l2 == 4)
            {
                byte0 = 4;
            }
            if((Block.field_343_p[j1] || Block.field_343_p[l1]) && !Block.field_343_p[k1] && !Block.field_343_p[j2])
            {
                byte0 = 5;
            }
            if((Block.field_343_p[k1] || Block.field_343_p[j2]) && !Block.field_343_p[j1] && !Block.field_343_p[l1])
            {
                byte0 = 4;
            }
        } else
        if(j1 == field_376_bc || k1 == field_376_bc)
        {
            int i2 = world.func_600_a(j1 != field_376_bc ? i + 1 : i - 1, j, k - 1);
            int k2 = world.func_600_a(j1 != field_376_bc ? i + 1 : i - 1, j, k + 1);
            byte0 = 3;
            int i3 = -1;
            if(j1 == field_376_bc)
            {
                i3 = world.func_602_e(i - 1, j, k);
            } else
            {
                i3 = world.func_602_e(i + 1, j, k);
            }
            if(i3 == 2)
            {
                byte0 = 2;
            }
            if((Block.field_343_p[l] || Block.field_343_p[i2]) && !Block.field_343_p[i1] && !Block.field_343_p[k2])
            {
                byte0 = 3;
            }
            if((Block.field_343_p[i1] || Block.field_343_p[k2]) && !Block.field_343_p[l] && !Block.field_343_p[i2])
            {
                byte0 = 2;
            }
        } else
        {
            byte0 = 3;
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
        }
        world.func_691_b(i, j, k, byte0);
    }

    public int func_211_a(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return field_378_bb - 1;
        }
        if(l == 0)
        {
            return field_378_bb - 1;
        }
        int i1 = iblockaccess.func_600_a(i, j, k - 1);
        int j1 = iblockaccess.func_600_a(i, j, k + 1);
        int k1 = iblockaccess.func_600_a(i - 1, j, k);
        int l1 = iblockaccess.func_600_a(i + 1, j, k);
        if(i1 == field_376_bc || j1 == field_376_bc)
        {
            if(l == 2 || l == 3)
            {
                return field_378_bb;
            }
            int i2 = 0;
            if(i1 == field_376_bc)
            {
                i2 = -1;
            }
            int k2 = iblockaccess.func_600_a(i - 1, j, i1 != field_376_bc ? k + 1 : k - 1);
            int i3 = iblockaccess.func_600_a(i + 1, j, i1 != field_376_bc ? k + 1 : k - 1);
            if(l == 4)
            {
                i2 = -1 - i2;
            }
            byte byte1 = 5;
            if((Block.field_343_p[k1] || Block.field_343_p[k2]) && !Block.field_343_p[l1] && !Block.field_343_p[i3])
            {
                byte1 = 5;
            }
            if((Block.field_343_p[l1] || Block.field_343_p[i3]) && !Block.field_343_p[k1] && !Block.field_343_p[k2])
            {
                byte1 = 4;
            }
            return (l != byte1 ? field_378_bb + 32 : field_378_bb + 16) + i2;
        }
        if(k1 == field_376_bc || l1 == field_376_bc)
        {
            if(l == 4 || l == 5)
            {
                return field_378_bb;
            }
            int j2 = 0;
            if(k1 == field_376_bc)
            {
                j2 = -1;
            }
            int l2 = iblockaccess.func_600_a(k1 != field_376_bc ? i + 1 : i - 1, j, k - 1);
            int j3 = iblockaccess.func_600_a(k1 != field_376_bc ? i + 1 : i - 1, j, k + 1);
            if(l == 3)
            {
                j2 = -1 - j2;
            }
            byte byte2 = 3;
            if((Block.field_343_p[i1] || Block.field_343_p[l2]) && !Block.field_343_p[j1] && !Block.field_343_p[j3])
            {
                byte2 = 3;
            }
            if((Block.field_343_p[j1] || Block.field_343_p[j3]) && !Block.field_343_p[i1] && !Block.field_343_p[l2])
            {
                byte2 = 2;
            }
            return (l != byte2 ? field_378_bb + 32 : field_378_bb + 16) + j2;
        }
        byte byte0 = 3;
        if(Block.field_343_p[i1] && !Block.field_343_p[j1])
        {
            byte0 = 3;
        }
        if(Block.field_343_p[j1] && !Block.field_343_p[i1])
        {
            byte0 = 2;
        }
        if(Block.field_343_p[k1] && !Block.field_343_p[l1])
        {
            byte0 = 5;
        }
        if(Block.field_343_p[l1] && !Block.field_343_p[k1])
        {
            byte0 = 4;
        }
        return l != byte0 ? field_378_bb : field_378_bb + 1;
    }

    public int func_218_a(int i)
    {
        if(i == 1)
        {
            return field_378_bb - 1;
        }
        if(i == 0)
        {
            return field_378_bb - 1;
        }
        if(i == 3)
        {
            return field_378_bb + 1;
        } else
        {
            return field_378_bb;
        }
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        int l = 0;
        if(world.func_600_a(i - 1, j, k) == field_376_bc)
        {
            l++;
        }
        if(world.func_600_a(i + 1, j, k) == field_376_bc)
        {
            l++;
        }
        if(world.func_600_a(i, j, k - 1) == field_376_bc)
        {
            l++;
        }
        if(world.func_600_a(i, j, k + 1) == field_376_bc)
        {
            l++;
        }
        if(l > 1)
        {
            return false;
        }
        if(func_286_h(world, i - 1, j, k))
        {
            return false;
        }
        if(func_286_h(world, i + 1, j, k))
        {
            return false;
        }
        if(func_286_h(world, i, j, k - 1))
        {
            return false;
        }
        return !func_286_h(world, i, j, k + 1);
    }

    private boolean func_286_h(World world, int i, int j, int k)
    {
        if(world.func_600_a(i, j, k) != field_376_bc)
        {
            return false;
        }
        if(world.func_600_a(i - 1, j, k) == field_376_bc)
        {
            return true;
        }
        if(world.func_600_a(i + 1, j, k) == field_376_bc)
        {
            return true;
        }
        if(world.func_600_a(i, j, k - 1) == field_376_bc)
        {
            return true;
        }
        return world.func_600_a(i, j, k + 1) == field_376_bc;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        super.func_226_a(world, i, j, k, l);
        TileEntityChest tileentitychest = (TileEntityChest)world.func_603_b(i, j, k);
        if(tileentitychest != null)
        {
            tileentitychest.func_35144_b();
        }
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        TileEntityChest tileentitychest = (TileEntityChest)world.func_603_b(i, j, k);
        if(tileentitychest != null)
        {
            for(int l = 0; l < tileentitychest.func_469_c(); l++)
            {
                ItemStack itemstack = tileentitychest.func_468_c(l);
                if(itemstack == null)
                {
                    continue;
                }
                float f = field_457_a.nextFloat() * 0.8F + 0.1F;
                float f1 = field_457_a.nextFloat() * 0.8F + 0.1F;
                float f2 = field_457_a.nextFloat() * 0.8F + 0.1F;
                while(itemstack.field_1615_a > 0) 
                {
                    int i1 = field_457_a.nextInt(21) + 10;
                    if(i1 > itemstack.field_1615_a)
                    {
                        i1 = itemstack.field_1615_a;
                    }
                    itemstack.field_1615_a -= i1;
                    EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.field_1617_c, i1, itemstack.func_21181_i()));
                    float f3 = 0.05F;
                    entityitem.field_608_an = (float)field_457_a.nextGaussian() * f3;
                    entityitem.field_607_ao = (float)field_457_a.nextGaussian() * f3 + 0.2F;
                    entityitem.field_606_ap = (float)field_457_a.nextGaussian() * f3;
                    if(itemstack.func_40710_n())
                    {
                        entityitem.field_801_a.func_40706_d((NBTTagCompound)itemstack.func_40709_o().func_40195_b());
                    }
                    world.func_674_a(entityitem);
                }
            }

        }
        super.func_214_b(world, i, j, k);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        Object obj = (TileEntityChest)world.func_603_b(i, j, k);
        if(obj == null)
        {
            return true;
        }
        if(world.func_28100_h(i, j + 1, k))
        {
            return true;
        }
        if(world.func_600_a(i - 1, j, k) == field_376_bc && world.func_28100_h(i - 1, j + 1, k))
        {
            return true;
        }
        if(world.func_600_a(i + 1, j, k) == field_376_bc && world.func_28100_h(i + 1, j + 1, k))
        {
            return true;
        }
        if(world.func_600_a(i, j, k - 1) == field_376_bc && world.func_28100_h(i, j + 1, k - 1))
        {
            return true;
        }
        if(world.func_600_a(i, j, k + 1) == field_376_bc && world.func_28100_h(i, j + 1, k + 1))
        {
            return true;
        }
        if(world.func_600_a(i - 1, j, k) == field_376_bc)
        {
            obj = new InventoryLargeChest("Large chest", (TileEntityChest)world.func_603_b(i - 1, j, k), ((IInventory) (obj)));
        }
        if(world.func_600_a(i + 1, j, k) == field_376_bc)
        {
            obj = new InventoryLargeChest("Large chest", ((IInventory) (obj)), (TileEntityChest)world.func_603_b(i + 1, j, k));
        }
        if(world.func_600_a(i, j, k - 1) == field_376_bc)
        {
            obj = new InventoryLargeChest("Large chest", (TileEntityChest)world.func_603_b(i, j, k - 1), ((IInventory) (obj)));
        }
        if(world.func_600_a(i, j, k + 1) == field_376_bc)
        {
            obj = new InventoryLargeChest("Large chest", ((IInventory) (obj)), (TileEntityChest)world.func_603_b(i, j, k + 1));
        }
        if(world.field_1026_y)
        {
            return true;
        } else
        {
            entityplayer.func_452_a(((IInventory) (obj)));
            return true;
        }
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityChest();
    }
}

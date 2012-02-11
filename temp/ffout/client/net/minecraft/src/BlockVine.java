// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World, 
//            Direction, ColorizerFoliage, WorldChunkManager, BiomeGenBase, 
//            EntityPlayer, ItemStack, Item, ItemShears, 
//            StatList, AxisAlignedBB

public class BlockVine extends Block
{

    public BlockVine(int i)
    {
        super(i, 143, Material.field_35495_k);
        func_253_b(true);
    }

    public void func_237_e()
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public int func_210_f()
    {
        return 20;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        float f = 1.0F;
        float f1 = 1.0F;
        float f2 = 1.0F;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        boolean flag = l > 0;
        if((l & 2) != 0)
        {
            f3 = Math.max(f3, 0.0625F);
            f = 0.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }
        if((l & 8) != 0)
        {
            f = Math.min(f, 0.9375F);
            f3 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }
        if((l & 4) != 0)
        {
            f5 = Math.max(f5, 0.0625F);
            f2 = 0.0F;
            f = 0.0F;
            f3 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            flag = true;
        }
        if((l & 1) != 0)
        {
            f2 = Math.min(f2, 0.9375F);
            f5 = 1.0F;
            f = 0.0F;
            f3 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            flag = true;
        }
        if(!flag && func_35302_d(iblockaccess.func_600_a(i, j + 1, k)))
        {
            f1 = Math.min(f1, 0.9375F);
            f4 = 1.0F;
            f = 0.0F;
            f3 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
        }
        func_213_a(f, f1, f2, f3, f4, f5);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean func_28030_e(World world, int i, int j, int k, int l)
    {
        switch(l)
        {
        default:
            return false;

        case 1: // '\001'
            return func_35302_d(world.func_600_a(i, j + 1, k));

        case 2: // '\002'
            return func_35302_d(world.func_600_a(i, j, k + 1));

        case 3: // '\003'
            return func_35302_d(world.func_600_a(i, j, k - 1));

        case 5: // '\005'
            return func_35302_d(world.func_600_a(i - 1, j, k));

        case 4: // '\004'
            return func_35302_d(world.func_600_a(i + 1, j, k));
        }
    }

    private boolean func_35302_d(int i)
    {
        if(i == 0)
        {
            return false;
        }
        Block block = Block.field_345_n[i];
        return block.func_242_c() && block.field_356_bn.func_880_c();
    }

    private boolean func_35301_h(World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        int i1 = l;
        if(i1 > 0)
        {
            for(int j1 = 0; j1 <= 3; j1++)
            {
                int k1 = 1 << j1;
                if((l & k1) != 0 && !func_35302_d(world.func_600_a(i + Direction.field_35871_a[j1], j, k + Direction.field_35870_b[j1])) && (world.func_600_a(i, j + 1, k) != field_376_bc || (world.func_602_e(i, j + 1, k) & k1) == 0))
                {
                    i1 &= ~k1;
                }
            }

        }
        if(i1 == 0 && !func_35302_d(world.func_600_a(i, j + 1, k)))
        {
            return false;
        }
        if(i1 != l)
        {
            world.func_691_b(i, j, k, i1);
        }
        return true;
    }

    public int func_35274_i()
    {
        return ColorizerFoliage.func_31073_c();
    }

    public int func_31030_b(int i)
    {
        return ColorizerFoliage.func_31073_c();
    }

    public int func_207_d(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return iblockaccess.func_4075_a().func_4073_a(i, k).func_40255_b(iblockaccess, i, j, k);
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(!world.field_1026_y && !func_35301_h(world, i, j, k))
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
        }
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(!world.field_1026_y && world.field_1037_n.nextInt(4) == 0)
        {
            byte byte0 = 4;
            int l = 5;
            boolean flag = false;
            int i1 = i - byte0;
label0:
            do
            {
                if(i1 > i + byte0)
                {
                    break;
                }
label1:
                for(int j1 = k - byte0; j1 <= k + byte0; j1++)
                {
                    int l1 = j - 1;
                    do
                    {
                        if(l1 > j + 1)
                        {
                            continue label1;
                        }
                        if(world.func_600_a(i1, l1, j1) == field_376_bc && --l <= 0)
                        {
                            flag = true;
                            break label0;
                        }
                        l1++;
                    } while(true);
                }

                i1++;
            } while(true);
            i1 = world.func_602_e(i, j, k);
            int k1 = world.field_1037_n.nextInt(6);
            int i2 = Direction.field_35869_d[k1];
            if(k1 == 1 && j < world.field_35472_c - 1 && world.func_20084_d(i, j + 1, k))
            {
                if(flag)
                {
                    return;
                }
                int j2 = world.field_1037_n.nextInt(16) & i1;
                if(j2 > 0)
                {
                    for(int i3 = 0; i3 <= 3; i3++)
                    {
                        if(!func_35302_d(world.func_600_a(i + Direction.field_35871_a[i3], j + 1, k + Direction.field_35870_b[i3])))
                        {
                            j2 &= ~(1 << i3);
                        }
                    }

                    if(j2 > 0)
                    {
                        world.func_688_b(i, j + 1, k, field_376_bc, j2);
                    }
                }
            } else
            if(k1 >= 2 && k1 <= 5 && (i1 & 1 << i2) == 0)
            {
                if(flag)
                {
                    return;
                }
                int k2 = world.func_600_a(i + Direction.field_35871_a[i2], j, k + Direction.field_35870_b[i2]);
                if(k2 == 0 || Block.field_345_n[k2] == null)
                {
                    int j3 = i2 + 1 & 3;
                    int i4 = i2 + 3 & 3;
                    if((i1 & 1 << j3) != 0 && func_35302_d(world.func_600_a(i + Direction.field_35871_a[i2] + Direction.field_35871_a[j3], j, k + Direction.field_35870_b[i2] + Direction.field_35870_b[j3])))
                    {
                        world.func_688_b(i + Direction.field_35871_a[i2], j, k + Direction.field_35870_b[i2], field_376_bc, 1 << j3);
                    } else
                    if((i1 & 1 << i4) != 0 && func_35302_d(world.func_600_a(i + Direction.field_35871_a[i2] + Direction.field_35871_a[i4], j, k + Direction.field_35870_b[i2] + Direction.field_35870_b[i4])))
                    {
                        world.func_688_b(i + Direction.field_35871_a[i2], j, k + Direction.field_35870_b[i2], field_376_bc, 1 << i4);
                    } else
                    if((i1 & 1 << j3) != 0 && world.func_20084_d(i + Direction.field_35871_a[i2] + Direction.field_35871_a[j3], j, k + Direction.field_35870_b[i2] + Direction.field_35870_b[j3]) && func_35302_d(world.func_600_a(i + Direction.field_35871_a[j3], j, k + Direction.field_35870_b[j3])))
                    {
                        world.func_688_b(i + Direction.field_35871_a[i2] + Direction.field_35871_a[j3], j, k + Direction.field_35870_b[i2] + Direction.field_35870_b[j3], field_376_bc, 1 << (i2 + 2 & 3));
                    } else
                    if((i1 & 1 << i4) != 0 && world.func_20084_d(i + Direction.field_35871_a[i2] + Direction.field_35871_a[i4], j, k + Direction.field_35870_b[i2] + Direction.field_35870_b[i4]) && func_35302_d(world.func_600_a(i + Direction.field_35871_a[i4], j, k + Direction.field_35870_b[i4])))
                    {
                        world.func_688_b(i + Direction.field_35871_a[i2] + Direction.field_35871_a[i4], j, k + Direction.field_35870_b[i2] + Direction.field_35870_b[i4], field_376_bc, 1 << (i2 + 2 & 3));
                    } else
                    if(func_35302_d(world.func_600_a(i + Direction.field_35871_a[i2], j + 1, k + Direction.field_35870_b[i2])))
                    {
                        world.func_688_b(i + Direction.field_35871_a[i2], j, k + Direction.field_35870_b[i2], field_376_bc, 0);
                    }
                } else
                if(Block.field_345_n[k2].field_356_bn.func_28126_h() && Block.field_345_n[k2].func_242_c())
                {
                    world.func_691_b(i, j, k, i1 | 1 << i2);
                }
            } else
            if(j > 1)
            {
                int l2 = world.func_600_a(i, j - 1, k);
                if(l2 == 0)
                {
                    int k3 = world.field_1037_n.nextInt(16) & i1;
                    if(k3 > 0)
                    {
                        world.func_688_b(i, j - 1, k, field_376_bc, k3);
                    }
                } else
                if(l2 == field_376_bc)
                {
                    int l3 = world.field_1037_n.nextInt(16) & i1;
                    int j4 = world.func_602_e(i, j - 1, k);
                    if(j4 != (j4 | l3))
                    {
                        world.func_691_b(i, j - 1, k, j4 | l3);
                    }
                }
            }
        }
    }

    public void func_258_d(World world, int i, int j, int k, int l)
    {
        byte byte0 = 0;
        switch(l)
        {
        case 2: // '\002'
            byte0 = 1;
            break;

        case 3: // '\003'
            byte0 = 4;
            break;

        case 4: // '\004'
            byte0 = 8;
            break;

        case 5: // '\005'
            byte0 = 2;
            break;
        }
        if(byte0 != 0)
        {
            world.func_691_b(i, j, k, byte0);
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        return 0;
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public void func_220_a_(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.field_1026_y && entityplayer.func_6416_v() != null && entityplayer.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS)
        {
            entityplayer.func_25058_a(StatList.field_25159_y[field_376_bc], 1);
            func_31027_a(world, i, j, k, new ItemStack(Block.field_35278_bv, 1, 0));
        } else
        {
            super.func_220_a_(world, entityplayer, i, j, k, l);
        }
    }
}

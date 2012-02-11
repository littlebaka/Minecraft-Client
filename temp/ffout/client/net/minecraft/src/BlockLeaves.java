// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockLeavesBase, Material, ColorizerFoliage, IBlockAccess, 
//            WorldChunkManager, BiomeGenBase, World, Block, 
//            ItemStack, Item, EntityPlayer, ItemShears, 
//            StatList, Entity

public class BlockLeaves extends BlockLeavesBase
{

    private int field_463_b;
    int field_20017_a[];

    protected BlockLeaves(int i, int j)
    {
        super(i, j, Material.field_4265_h, false);
        field_463_b = j;
        func_253_b(true);
    }

    public int func_35274_i()
    {
        double d = 0.5D;
        double d1 = 1.0D;
        return ColorizerFoliage.func_4146_a(d, d1);
    }

    public int func_31030_b(int i)
    {
        if((i & 1) == 1)
        {
            return ColorizerFoliage.func_21175_a();
        }
        if((i & 2) == 2)
        {
            return ColorizerFoliage.func_21174_b();
        } else
        {
            return ColorizerFoliage.func_31073_c();
        }
    }

    public int func_207_d(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        if((l & 1) == 1)
        {
            return ColorizerFoliage.func_21175_a();
        }
        if((l & 2) == 2)
        {
            return ColorizerFoliage.func_21174_b();
        }
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        for(int l1 = -1; l1 <= 1; l1++)
        {
            for(int i2 = -1; i2 <= 1; i2++)
            {
                int j2 = iblockaccess.func_4075_a().func_4073_a(i + i2, k + l1).func_40255_b(iblockaccess, i + i2, j, k + l1);
                i1 += (j2 & 0xff0000) >> 16;
                j1 += (j2 & 0xff00) >> 8;
                k1 += j2 & 0xff;
            }

        }

        return (i1 / 9 & 0xff) << 16 | (j1 / 9 & 0xff) << 8 | k1 / 9 & 0xff;
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        int l = 1;
        int i1 = l + 1;
        if(world.func_640_a(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
        {
            for(int j1 = -l; j1 <= l; j1++)
            {
                for(int k1 = -l; k1 <= l; k1++)
                {
                    for(int l1 = -l; l1 <= l; l1++)
                    {
                        int i2 = world.func_600_a(i + j1, j + k1, k + l1);
                        if(i2 == Block.field_384_L.field_376_bc)
                        {
                            int j2 = world.func_602_e(i + j1, j + k1, k + l1);
                            world.func_635_c(i + j1, j + k1, k + l1, j2 | 8);
                        }
                    }

                }

            }

        }
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int l = world.func_602_e(i, j, k);
        if((l & 8) != 0 && (l & 4) == 0)
        {
            byte byte0 = 4;
            int i1 = byte0 + 1;
            byte byte1 = 32;
            int j1 = byte1 * byte1;
            int k1 = byte1 / 2;
            if(field_20017_a == null)
            {
                field_20017_a = new int[byte1 * byte1 * byte1];
            }
            if(world.func_640_a(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
            {
                for(int l1 = -byte0; l1 <= byte0; l1++)
                {
                    for(int k2 = -byte0; k2 <= byte0; k2++)
                    {
                        for(int i3 = -byte0; i3 <= byte0; i3++)
                        {
                            int k3 = world.func_600_a(i + l1, j + k2, k + i3);
                            if(k3 == Block.field_385_K.field_376_bc)
                            {
                                field_20017_a[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = 0;
                                continue;
                            }
                            if(k3 == Block.field_384_L.field_376_bc)
                            {
                                field_20017_a[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -2;
                            } else
                            {
                                field_20017_a[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -1;
                            }
                        }

                    }

                }

                for(int i2 = 1; i2 <= 4; i2++)
                {
                    for(int l2 = -byte0; l2 <= byte0; l2++)
                    {
                        for(int j3 = -byte0; j3 <= byte0; j3++)
                        {
                            for(int l3 = -byte0; l3 <= byte0; l3++)
                            {
                                if(field_20017_a[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] != i2 - 1)
                                {
                                    continue;
                                }
                                if(field_20017_a[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
                                {
                                    field_20017_a[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(field_20017_a[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
                                {
                                    field_20017_a[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(field_20017_a[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] == -2)
                                {
                                    field_20017_a[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(field_20017_a[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] == -2)
                                {
                                    field_20017_a[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(field_20017_a[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] == -2)
                                {
                                    field_20017_a[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] = i2;
                                }
                                if(field_20017_a[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] == -2)
                                {
                                    field_20017_a[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] = i2;
                                }
                            }

                        }

                    }

                }

            }
            int j2 = field_20017_a[k1 * j1 + k1 * byte1 + k1];
            if(j2 >= 0)
            {
                world.func_635_c(i, j, k, l & -9);
            } else
            {
                func_6360_i(world, i, j, k);
            }
        }
    }

    private void func_6360_i(World world, int i, int j, int k)
    {
        func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
        world.func_690_d(i, j, k, 0);
    }

    public int func_229_a(Random random)
    {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Block.field_333_z.field_376_bc;
    }

    public void func_216_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.func_216_a(world, i, j, k, l, f, i1);
        if(!world.field_1026_y && (l & 3) == 0 && world.field_1037_n.nextInt(200) == 0)
        {
            func_31027_a(world, i, j, k, new ItemStack(Item.field_228_h, 1, 0));
        }
    }

    public void func_220_a_(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.field_1026_y && entityplayer.func_6416_v() != null && entityplayer.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS)
        {
            entityplayer.func_25058_a(StatList.field_25159_y[field_376_bc], 1);
            func_31027_a(world, i, j, k, new ItemStack(Block.field_384_L.field_376_bc, 1, l & 3));
        } else
        {
            super.func_220_a_(world, entityplayer, i, j, k, l);
        }
    }

    protected int func_21025_b(int i)
    {
        return i & 3;
    }

    public boolean func_217_b()
    {
        return !field_6359_a;
    }

    public int func_232_a(int i, int j)
    {
        if((j & 3) == 1)
        {
            return field_378_bb + 80;
        } else
        {
            return field_378_bb;
        }
    }

    public void func_310_a(boolean flag)
    {
        field_6359_a = flag;
        field_378_bb = field_463_b + (flag ? 0 : 1);
    }

    public void func_254_a(World world, int i, int j, int k, Entity entity)
    {
        super.func_254_a(world, i, j, k, entity);
    }
}

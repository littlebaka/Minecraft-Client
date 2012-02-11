// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, BlockLeaves, BlockTallGrass, 
//            World, WorldProviderEnd, IBlockAccess, WorldProvider, 
//            BlockPortal, AxisAlignedBB

public class BlockFire extends Block
{

    private int field_449_a[];
    private int field_448_b[];

    protected BlockFire(int i, int j)
    {
        super(i, j, Material.field_1326_l);
        field_449_a = new int[256];
        field_448_b = new int[256];
        func_253_b(true);
    }

    public void func_28028_i()
    {
        func_264_a(Block.field_334_y.field_376_bc, 5, 20);
        func_264_a(Block.field_4057_ba.field_376_bc, 5, 20);
        func_264_a(Block.field_4059_au.field_376_bc, 5, 20);
        func_264_a(Block.field_385_K.field_376_bc, 5, 5);
        func_264_a(Block.field_384_L.field_376_bc, 30, 60);
        func_264_a(Block.field_407_ao.field_376_bc, 30, 20);
        func_264_a(Block.field_408_an.field_376_bc, 15, 100);
        func_264_a(Block.field_9257_X.field_376_bc, 60, 100);
        func_264_a(Block.field_419_ac.field_376_bc, 30, 60);
        func_264_a(Block.field_35278_bv.field_376_bc, 15, 100);
    }

    private void func_264_a(int i, int j, int k)
    {
        field_449_a[i] = j;
        field_448_b[i] = k;
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
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
        return 3;
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public int func_4025_d()
    {
        return 40;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        boolean flag = world.func_600_a(i, j - 1, k) == Block.field_4053_bc.field_376_bc;
        if((world.field_4209_q instanceof WorldProviderEnd) && world.func_600_a(i, j - 1, k) == Block.field_403_A.field_376_bc)
        {
            flag = true;
        }
        if(!func_243_a(world, i, j, k))
        {
            world.func_690_d(i, j, k, 0);
        }
        if(!flag && world.func_27161_C() && (world.func_27167_r(i, j, k) || world.func_27167_r(i - 1, j, k) || world.func_27167_r(i + 1, j, k) || world.func_27167_r(i, j, k - 1) || world.func_27167_r(i, j, k + 1)))
        {
            world.func_690_d(i, j, k, 0);
            return;
        }
        int l = world.func_602_e(i, j, k);
        if(l < 15)
        {
            world.func_635_c(i, j, k, l + random.nextInt(3) / 2);
        }
        world.func_22136_c(i, j, k, field_376_bc, func_4025_d());
        if(!flag && !func_263_h(world, i, j, k))
        {
            if(!world.func_28100_h(i, j - 1, k) || l > 3)
            {
                world.func_690_d(i, j, k, 0);
            }
            return;
        }
        if(!flag && !func_261_b(world, i, j - 1, k) && l == 15 && random.nextInt(4) == 0)
        {
            world.func_690_d(i, j, k, 0);
            return;
        }
        func_266_a(world, i + 1, j, k, 300, random, l);
        func_266_a(world, i - 1, j, k, 300, random, l);
        func_266_a(world, i, j - 1, k, 250, random, l);
        func_266_a(world, i, j + 1, k, 250, random, l);
        func_266_a(world, i, j, k - 1, 300, random, l);
        func_266_a(world, i, j, k + 1, 300, random, l);
        for(int i1 = i - 1; i1 <= i + 1; i1++)
        {
            for(int j1 = k - 1; j1 <= k + 1; j1++)
            {
                for(int k1 = j - 1; k1 <= j + 4; k1++)
                {
                    if(i1 == i && k1 == j && j1 == k)
                    {
                        continue;
                    }
                    int l1 = 100;
                    if(k1 > j + 1)
                    {
                        l1 += (k1 - (j + 1)) * 100;
                    }
                    int i2 = func_262_i(world, i1, k1, j1);
                    if(i2 <= 0)
                    {
                        continue;
                    }
                    int j2 = (i2 + 40) / (l + 30);
                    if(j2 <= 0 || random.nextInt(l1) > j2 || world.func_27161_C() && world.func_27167_r(i1, k1, j1) || world.func_27167_r(i1 - 1, k1, k) || world.func_27167_r(i1 + 1, k1, j1) || world.func_27167_r(i1, k1, j1 - 1) || world.func_27167_r(i1, k1, j1 + 1))
                    {
                        continue;
                    }
                    int k2 = l + random.nextInt(5) / 4;
                    if(k2 > 15)
                    {
                        k2 = 15;
                    }
                    world.func_688_b(i1, k1, j1, field_376_bc, k2);
                }

            }

        }

    }

    private void func_266_a(World world, int i, int j, int k, int l, Random random, int i1)
    {
        int j1 = field_448_b[world.func_600_a(i, j, k)];
        if(random.nextInt(l) < j1)
        {
            boolean flag = world.func_600_a(i, j, k) == Block.field_408_an.field_376_bc;
            if(random.nextInt(i1 + 10) < 5 && !world.func_27167_r(i, j, k))
            {
                int k1 = i1 + random.nextInt(5) / 4;
                if(k1 > 15)
                {
                    k1 = 15;
                }
                world.func_688_b(i, j, k, field_376_bc, k1);
            } else
            {
                world.func_690_d(i, j, k, 0);
            }
            if(flag)
            {
                Block.field_408_an.func_252_b(world, i, j, k, 1);
            }
        }
    }

    private boolean func_263_h(World world, int i, int j, int k)
    {
        if(func_261_b(world, i + 1, j, k))
        {
            return true;
        }
        if(func_261_b(world, i - 1, j, k))
        {
            return true;
        }
        if(func_261_b(world, i, j - 1, k))
        {
            return true;
        }
        if(func_261_b(world, i, j + 1, k))
        {
            return true;
        }
        if(func_261_b(world, i, j, k - 1))
        {
            return true;
        }
        return func_261_b(world, i, j, k + 1);
    }

    private int func_262_i(World world, int i, int j, int k)
    {
        int l = 0;
        if(!world.func_20084_d(i, j, k))
        {
            return 0;
        } else
        {
            l = func_265_g(world, i + 1, j, k, l);
            l = func_265_g(world, i - 1, j, k, l);
            l = func_265_g(world, i, j - 1, k, l);
            l = func_265_g(world, i, j + 1, k, l);
            l = func_265_g(world, i, j, k - 1, l);
            l = func_265_g(world, i, j, k + 1, l);
            return l;
        }
    }

    public boolean func_245_h()
    {
        return false;
    }

    public boolean func_261_b(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return field_449_a[iblockaccess.func_600_a(i, j, k)] > 0;
    }

    public int func_265_g(World world, int i, int j, int k, int l)
    {
        int i1 = field_449_a[world.func_600_a(i, j, k)];
        if(i1 > l)
        {
            return i1;
        } else
        {
            return l;
        }
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return world.func_28100_h(i, j - 1, k) || func_263_h(world, i, j, k);
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(!world.func_28100_h(i, j - 1, k) && !func_263_h(world, i, j, k))
        {
            world.func_690_d(i, j, k, 0);
            return;
        } else
        {
            return;
        }
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        if(world.field_4209_q.field_4218_e <= 0 && world.func_600_a(i, j - 1, k) == Block.field_405_aq.field_376_bc && Block.field_4047_bf.func_4032_a_(world, i, j, k))
        {
            return;
        }
        if(!world.func_28100_h(i, j - 1, k) && !func_263_h(world, i, j, k))
        {
            world.func_690_d(i, j, k, 0);
            return;
        } else
        {
            world.func_22136_c(i, j, k, field_376_bc, func_4025_d());
            return;
        }
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        if(random.nextInt(24) == 0)
        {
            world.func_684_a((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F);
        }
        if(world.func_28100_h(i, j - 1, k) || Block.field_402_as.func_261_b(world, i, j - 1, k))
        {
            for(int l = 0; l < 3; l++)
            {
                float f = (float)i + random.nextFloat();
                float f6 = (float)j + random.nextFloat() * 0.5F + 0.5F;
                float f12 = (float)k + random.nextFloat();
                world.func_694_a("largesmoke", f, f6, f12, 0.0D, 0.0D, 0.0D);
            }

        } else
        {
            if(Block.field_402_as.func_261_b(world, i - 1, j, k))
            {
                for(int i1 = 0; i1 < 2; i1++)
                {
                    float f1 = (float)i + random.nextFloat() * 0.1F;
                    float f7 = (float)j + random.nextFloat();
                    float f13 = (float)k + random.nextFloat();
                    world.func_694_a("largesmoke", f1, f7, f13, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_402_as.func_261_b(world, i + 1, j, k))
            {
                for(int j1 = 0; j1 < 2; j1++)
                {
                    float f2 = (float)(i + 1) - random.nextFloat() * 0.1F;
                    float f8 = (float)j + random.nextFloat();
                    float f14 = (float)k + random.nextFloat();
                    world.func_694_a("largesmoke", f2, f8, f14, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_402_as.func_261_b(world, i, j, k - 1))
            {
                for(int k1 = 0; k1 < 2; k1++)
                {
                    float f3 = (float)i + random.nextFloat();
                    float f9 = (float)j + random.nextFloat();
                    float f15 = (float)k + random.nextFloat() * 0.1F;
                    world.func_694_a("largesmoke", f3, f9, f15, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_402_as.func_261_b(world, i, j, k + 1))
            {
                for(int l1 = 0; l1 < 2; l1++)
                {
                    float f4 = (float)i + random.nextFloat();
                    float f10 = (float)j + random.nextFloat();
                    float f16 = (float)(k + 1) - random.nextFloat() * 0.1F;
                    world.func_694_a("largesmoke", f4, f10, f16, 0.0D, 0.0D, 0.0D);
                }

            }
            if(Block.field_402_as.func_261_b(world, i, j + 1, k))
            {
                for(int i2 = 0; i2 < 2; i2++)
                {
                    float f5 = (float)i + random.nextFloat();
                    float f11 = (float)(j + 1) - random.nextFloat() * 0.1F;
                    float f17 = (float)k + random.nextFloat();
                    world.func_694_a("largesmoke", f5, f11, f17, 0.0D, 0.0D, 0.0D);
                }

            }
        }
    }
}

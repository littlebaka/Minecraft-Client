// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass, BlockMycelium, BlockFlower

public class WorldGenBigMushroom extends WorldGenerator
{

    private int field_35266_a;

    public WorldGenBigMushroom(int i)
    {
        field_35266_a = -1;
        field_35266_a = i;
    }

    public WorldGenBigMushroom()
    {
        field_35266_a = -1;
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        int l = random.nextInt(2);
        if(field_35266_a >= 0)
        {
            l = field_35266_a;
        }
        int i1 = random.nextInt(3) + 4;
        boolean flag = true;
        if(j < 1 || j + i1 + 1 > world.field_35472_c)
        {
            return false;
        }
        for(int j1 = j; j1 <= j + 1 + i1; j1++)
        {
            byte byte0 = 3;
            if(j1 == j)
            {
                byte0 = 0;
            }
            for(int i2 = i - byte0; i2 <= i + byte0 && flag; i2++)
            {
                for(int l2 = k - byte0; l2 <= k + byte0 && flag; l2++)
                {
                    if(j1 >= 0 && j1 < world.field_35472_c)
                    {
                        int k3 = world.func_600_a(i2, j1, l2);
                        if(k3 != 0 && k3 != Block.field_384_L.field_376_bc)
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                }

            }

        }

        if(!flag)
        {
            return false;
        }
        int k1 = world.func_600_a(i, j - 1, k);
        if(k1 != Block.field_336_w.field_376_bc && k1 != Block.field_337_v.field_376_bc && k1 != Block.field_40199_bz.field_376_bc)
        {
            return false;
        }
        if(!Block.field_415_ag.func_243_a(world, i, j, k))
        {
            return false;
        }
        world.func_634_a(i, j - 1, k, Block.field_336_w.field_376_bc);
        int l1 = j + i1;
        if(l == 1)
        {
            l1 = (j + i1) - 3;
        }
        for(int j2 = l1; j2 <= j + i1; j2++)
        {
            int i3 = 1;
            if(j2 < j + i1)
            {
                i3++;
            }
            if(l == 0)
            {
                i3 = 3;
            }
            for(int l3 = i - i3; l3 <= i + i3; l3++)
            {
                for(int i4 = k - i3; i4 <= k + i3; i4++)
                {
                    int j4 = 5;
                    if(l3 == i - i3)
                    {
                        j4--;
                    }
                    if(l3 == i + i3)
                    {
                        j4++;
                    }
                    if(i4 == k - i3)
                    {
                        j4 -= 3;
                    }
                    if(i4 == k + i3)
                    {
                        j4 += 3;
                    }
                    if(l == 0 || j2 < j + i1)
                    {
                        if((l3 == i - i3 || l3 == i + i3) && (i4 == k - i3 || i4 == k + i3))
                        {
                            continue;
                        }
                        if(l3 == i - (i3 - 1) && i4 == k - i3)
                        {
                            j4 = 1;
                        }
                        if(l3 == i - i3 && i4 == k - (i3 - 1))
                        {
                            j4 = 1;
                        }
                        if(l3 == i + (i3 - 1) && i4 == k - i3)
                        {
                            j4 = 3;
                        }
                        if(l3 == i + i3 && i4 == k - (i3 - 1))
                        {
                            j4 = 3;
                        }
                        if(l3 == i - (i3 - 1) && i4 == k + i3)
                        {
                            j4 = 7;
                        }
                        if(l3 == i - i3 && i4 == k + (i3 - 1))
                        {
                            j4 = 7;
                        }
                        if(l3 == i + (i3 - 1) && i4 == k + i3)
                        {
                            j4 = 9;
                        }
                        if(l3 == i + i3 && i4 == k + (i3 - 1))
                        {
                            j4 = 9;
                        }
                    }
                    if(j4 == 5 && j2 < j + i1)
                    {
                        j4 = 0;
                    }
                    if((j4 != 0 || j >= (j + i1) - 1) && !Block.field_343_p[world.func_600_a(l3, j2, i4)])
                    {
                        world.func_643_a(l3, j2, i4, Block.field_35286_bo.field_376_bc + l, j4);
                    }
                }

            }

        }

        for(int k2 = 0; k2 < i1; k2++)
        {
            int j3 = world.func_600_a(i, j + k2, k);
            if(!Block.field_343_p[j3])
            {
                world.func_643_a(i, j + k2, k, Block.field_35286_bo.field_376_bc + l, 10);
            }
        }

        return true;
    }
}

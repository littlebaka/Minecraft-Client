// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockLeaves, 
//            EntityPlayer

public class BlockLog extends Block
{

    protected BlockLog(int i)
    {
        super(i, Material.field_1335_c);
        field_378_bb = 20;
    }

    public int func_229_a(Random random)
    {
        return 1;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Block.field_385_K.field_376_bc;
    }

    public void func_220_a_(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.func_220_a_(world, entityplayer, i, j, k, l);
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        byte byte0 = 4;
        int l = byte0 + 1;
        if(world.func_640_a(i - l, j - l, k - l, i + l, j + l, k + l))
        {
            for(int i1 = -byte0; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0; j1 <= byte0; j1++)
                {
                    for(int k1 = -byte0; k1 <= byte0; k1++)
                    {
                        int l1 = world.func_600_a(i + i1, j + j1, k + k1);
                        if(l1 != Block.field_384_L.field_376_bc)
                        {
                            continue;
                        }
                        int i2 = world.func_602_e(i + i1, j + j1, k + k1);
                        if((i2 & 8) == 0)
                        {
                            world.func_635_c(i + i1, j + j1, k + k1, i2 | 8);
                        }
                    }

                }

            }

        }
    }

    public int func_232_a(int i, int j)
    {
        if(i == 1)
        {
            return 21;
        }
        if(i == 0)
        {
            return 21;
        }
        if(j == 1)
        {
            return 116;
        }
        return j != 2 ? 20 : 117;
    }

    protected int func_21025_b(int i)
    {
        return i;
    }
}

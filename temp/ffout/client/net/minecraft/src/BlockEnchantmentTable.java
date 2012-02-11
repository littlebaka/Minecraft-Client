// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, World, Block, 
//            TileEntityEnchantmentTable, EntityPlayer, TileEntity

public class BlockEnchantmentTable extends BlockContainer
{

    protected BlockEnchantmentTable(int i)
    {
        super(i, 166, Material.field_1334_d);
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        func_256_d(0);
    }

    public boolean func_242_c()
    {
        return false;
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        super.func_247_b(world, i, j, k, random);
        for(int l = i - 2; l <= i + 2; l++)
        {
            for(int i1 = k - 2; i1 <= k + 2; i1++)
            {
                if(l > i - 2 && l < i + 2 && i1 == k - 1)
                {
                    i1 = k + 2;
                }
                if(random.nextInt(16) != 0)
                {
                    continue;
                }
                for(int j1 = j; j1 <= j + 1; j1++)
                {
                    if(world.func_600_a(l, j1, i1) != Block.field_407_ao.field_376_bc)
                    {
                        continue;
                    }
                    if(!world.func_20084_d((l - i) / 2 + i, j1, (i1 - k) / 2 + k))
                    {
                        break;
                    }
                    world.func_694_a("enchantmenttable", (double)i + 0.5D, (double)j + 2D, (double)k + 0.5D, (double)((float)(l - i) + random.nextFloat()) - 0.5D, (float)(j1 - j) - random.nextFloat() - 1.0F, (double)((float)(i1 - k) + random.nextFloat()) - 0.5D);
                }

            }

        }

    }

    public boolean func_217_b()
    {
        return false;
    }

    public int func_232_a(int i, int j)
    {
        return func_218_a(i);
    }

    public int func_218_a(int i)
    {
        if(i == 0)
        {
            return field_378_bb + 17;
        }
        if(i == 1)
        {
            return field_378_bb;
        } else
        {
            return field_378_bb + 16;
        }
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityEnchantmentTable();
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        } else
        {
            entityplayer.func_40181_c(i, j, k);
            return true;
        }
    }
}

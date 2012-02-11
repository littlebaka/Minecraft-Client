// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, ColorizerGrass, ColorizerFoliage, IBlockAccess, 
//            WorldChunkManager, BiomeGenBase, Item, World, 
//            EntityPlayer, ItemStack, ItemShears, StatList, 
//            Block

public class BlockTallGrass extends BlockFlower
{

    protected BlockTallGrass(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    public int func_232_a(int i, int j)
    {
        if(j == 1)
        {
            return field_378_bb;
        }
        if(j == 2)
        {
            return field_378_bb + 16 + 1;
        }
        if(j == 0)
        {
            return field_378_bb + 16;
        } else
        {
            return field_378_bb;
        }
    }

    public int func_35274_i()
    {
        double d = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.func_4147_a(d, d1);
    }

    public int func_31030_b(int i)
    {
        if(i == 0)
        {
            return 0xffffff;
        } else
        {
            return ColorizerFoliage.func_31073_c();
        }
    }

    public int func_207_d(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        if(l == 0)
        {
            return 0xffffff;
        } else
        {
            return iblockaccess.func_4075_a().func_4073_a(i, k).func_40254_a(iblockaccess, i, j, k);
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        if(random.nextInt(8) == 0)
        {
            return Item.field_244_Q.field_291_aS;
        } else
        {
            return -1;
        }
    }

    public int func_40198_a(int i, Random random)
    {
        return 1 + random.nextInt(i * 2 + 1);
    }

    public void func_220_a_(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.field_1026_y && entityplayer.func_6416_v() != null && entityplayer.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS)
        {
            entityplayer.func_25058_a(StatList.field_25159_y[field_376_bc], 1);
            func_31027_a(world, i, j, k, new ItemStack(Block.field_9257_X, 1, l));
        } else
        {
            super.func_220_a_(world, entityplayer, i, j, k, l);
        }
    }
}

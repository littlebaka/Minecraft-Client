// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World

public class BlockLockedChest extends Block
{

    protected BlockLockedChest(int i)
    {
        super(i, Material.field_1335_c);
        field_378_bb = 26;
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
        return true;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        world.func_690_d(i, j, k, 0);
    }
}

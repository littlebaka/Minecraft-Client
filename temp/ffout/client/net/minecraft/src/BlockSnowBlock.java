// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item, EnumSkyBlock, 
//            World

public class BlockSnowBlock extends Block
{

    protected BlockSnowBlock(int i, int j)
    {
        super(i, j, Material.field_1318_t);
        func_253_b(true);
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_308_aB.field_291_aS;
    }

    public int func_229_a(Random random)
    {
        return 4;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.func_641_a(EnumSkyBlock.Block, i, j, k) > 11)
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
        }
    }
}

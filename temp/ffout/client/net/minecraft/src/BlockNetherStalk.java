// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Block, World, WorldChunkManager, 
//            BiomeGenHell, ItemStack, Item

public class BlockNetherStalk extends BlockFlower
{

    protected BlockNetherStalk(int i)
    {
        super(i, 226);
        func_253_b(true);
        float f = 0.5F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    protected boolean func_269_b(int i)
    {
        return i == Block.field_4051_bd.field_376_bc;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        int l = world.func_602_e(i, j, k);
        if(l < 3)
        {
            WorldChunkManager worldchunkmanager = world.func_4075_a();
            if(worldchunkmanager != null)
            {
                BiomeGenBase biomegenbase = worldchunkmanager.func_4073_a(i, k);
                if((biomegenbase instanceof BiomeGenHell) && random.nextInt(15) == 0)
                {
                    l++;
                    world.func_691_b(i, j, k, l);
                }
            }
        }
        super.func_208_a(world, i, j, k, random);
    }

    public int func_232_a(int i, int j)
    {
        if(j >= 3)
        {
            return field_378_bb + 2;
        }
        if(j > 0)
        {
            return field_378_bb + 1;
        } else
        {
            return field_378_bb;
        }
    }

    public int func_210_f()
    {
        return 6;
    }

    public void func_216_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int j1 = 1;
        if(l >= 3)
        {
            j1 = 2 + world.field_1037_n.nextInt(3);
            if(i1 > 0)
            {
                j1 += world.field_1037_n.nextInt(i1 + 1);
            }
        }
        for(int k1 = 0; k1 < j1; k1++)
        {
            func_31027_a(world, i, j, k, new ItemStack(Item.field_40414_br));
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
}

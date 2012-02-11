// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntityTNTPrimed, 
//            ItemStack, EntityPlayer, Item

public class BlockTNT extends Block
{

    public BlockTNT(int i, int j)
    {
        super(i, j, Material.field_1322_p);
    }

    public int func_218_a(int i)
    {
        if(i == 0)
        {
            return field_378_bb + 2;
        }
        if(i == 1)
        {
            return field_378_bb + 1;
        } else
        {
            return field_378_bb;
        }
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        super.func_235_e(world, i, j, k);
        if(world.func_625_o(i, j, k))
        {
            func_252_b(world, i, j, k, 1);
            world.func_690_d(i, j, k, 0);
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(l > 0 && Block.field_345_n[l].func_209_d() && world.func_625_o(i, j, k))
        {
            func_252_b(world, i, j, k, 1);
            world.func_690_d(i, j, k, 0);
        }
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public void func_4027_c(World world, int i, int j, int k)
    {
        EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
        entitytntprimed.field_689_a = world.field_1037_n.nextInt(entitytntprimed.field_689_a / 4) + entitytntprimed.field_689_a / 8;
        world.func_674_a(entitytntprimed);
    }

    public void func_252_b(World world, int i, int j, int k, int l)
    {
        if(world.field_1026_y)
        {
            return;
        }
        if((l & 1) == 0)
        {
            func_31027_a(world, i, j, k, new ItemStack(Block.field_408_an.field_376_bc, 1, 0));
        } else
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
            world.func_674_a(entitytntprimed);
            world.func_623_a(entitytntprimed, "random.fuse", 1.0F, 1.0F);
        }
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(entityplayer.func_6416_v() != null && entityplayer.func_6416_v().field_1617_c == Item.field_4014_g.field_291_aS)
        {
            world.func_635_c(i, j, k, 1);
        }
        super.func_233_b(world, i, j, k, entityplayer);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return super.func_250_a(world, i, j, k, entityplayer);
    }

    protected ItemStack func_41049_c_(int i)
    {
        return null;
    }
}

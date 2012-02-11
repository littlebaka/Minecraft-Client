// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntitySilverfish, 
//            ItemStack, EntityPlayer

public class BlockSilverfish extends Block
{

    public BlockSilverfish(int i)
    {
        super(i, 1, Material.field_1316_v);
        func_222_c(0.0F);
    }

    public void func_220_a_(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.func_220_a_(world, entityplayer, i, j, k, l);
    }

    public int func_232_a(int i, int j)
    {
        if(j == 1)
        {
            return Block.field_335_x.field_378_bb;
        }
        if(j == 2)
        {
            return Block.field_35285_bn.field_378_bb;
        } else
        {
            return Block.field_338_u.field_378_bb;
        }
    }

    public void func_252_b(World world, int i, int j, int k, int l)
    {
        if(!world.field_1026_y)
        {
            EntitySilverfish entitysilverfish = new EntitySilverfish(world);
            entitysilverfish.func_365_c((double)i + 0.5D, j, (double)k + 0.5D, 0.0F, 0.0F);
            world.func_674_a(entitysilverfish);
            entitysilverfish.func_415_z();
        }
        super.func_252_b(world, i, j, k, l);
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public static boolean func_35305_d(int i)
    {
        return i == Block.field_338_u.field_376_bc || i == Block.field_335_x.field_376_bc || i == Block.field_35285_bn.field_376_bc;
    }

    public static int func_35304_f(int i)
    {
        if(i == Block.field_335_x.field_376_bc)
        {
            return 1;
        }
        return i != Block.field_35285_bn.field_376_bc ? 0 : 2;
    }

    protected ItemStack func_41049_c_(int i)
    {
        Block block = Block.field_338_u;
        if(i == 1)
        {
            block = Block.field_335_x;
        }
        if(i == 2)
        {
            block = Block.field_35285_bn;
        }
        return new ItemStack(block);
    }
}

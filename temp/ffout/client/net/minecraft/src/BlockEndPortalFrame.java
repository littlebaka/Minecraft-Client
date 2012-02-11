// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntityLiving, 
//            MathHelper, AxisAlignedBB

public class BlockEndPortalFrame extends Block
{

    public BlockEndPortalFrame(int i)
    {
        super(i, 159, Material.field_4263_o);
    }

    public int func_232_a(int i, int j)
    {
        if(i == 1)
        {
            return field_378_bb - 1;
        }
        if(i == 0)
        {
            return field_378_bb + 16;
        } else
        {
            return field_378_bb;
        }
    }

    public boolean func_217_b()
    {
        return false;
    }

    public int func_210_f()
    {
        return 26;
    }

    public void func_237_e()
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        int l = world.func_602_e(i, j, k);
        if(func_40212_d(l))
        {
            func_213_a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        }
        func_237_e();
    }

    public static boolean func_40212_d(int i)
    {
        return (i & 4) != 0;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return 0;
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = ((MathHelper.func_1108_b((double)((entityliving.field_605_aq * 4F) / 360F) + 0.5D) & 3) + 2) % 4;
        world.func_691_b(i, j, k, l);
    }
}

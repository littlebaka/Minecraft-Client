// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, Facing, 
//            BlockPistonBase, IBlockAccess, AxisAlignedBB

public class BlockPistonExtension extends Block
{

    private int field_31053_a;

    public BlockPistonExtension(int i, int j)
    {
        super(i, j, Material.field_31067_B);
        field_31053_a = -1;
        func_4024_a(field_9251_h);
        func_222_c(0.5F);
    }

    public void func_31052_a_(int i)
    {
        field_31053_a = i;
    }

    public void func_31051_a()
    {
        field_31053_a = -1;
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        super.func_214_b(world, i, j, k);
        int l = world.func_602_e(i, j, k);
        int j1 = Facing.field_31057_a[func_31050_c(l)];
        i += Facing.field_31056_b[j1];
        j += Facing.field_31059_c[j1];
        k += Facing.field_31058_d[j1];
        int k1 = world.func_600_a(i, j, k);
        if(k1 == Block.field_9255_Z.field_376_bc || k1 == Block.field_9259_V.field_376_bc)
        {
            int i1 = world.func_602_e(i, j, k);
            if(BlockPistonBase.func_31046_e(i1))
            {
                Block.field_345_n[k1].func_259_b_(world, i, j, k, i1, 0);
                world.func_690_d(i, j, k, 0);
            }
        }
    }

    public int func_232_a(int i, int j)
    {
        int k = func_31050_c(j);
        if(i == k)
        {
            if(field_31053_a >= 0)
            {
                return field_31053_a;
            }
            if((j & 8) != 0)
            {
                return field_378_bb - 1;
            } else
            {
                return field_378_bb;
            }
        }
        return i != Facing.field_31057_a[k] ? 108 : 107;
    }

    public int func_210_f()
    {
        return 17;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return false;
    }

    public boolean func_28030_e(World world, int i, int j, int k, int l)
    {
        return false;
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        int l = world.func_602_e(i, j, k);
        switch(func_31050_c(l))
        {
        case 0: // '\0'
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 1: // '\001'
            func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 2: // '\002'
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 3: // '\003'
            func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 4: // '\004'
            func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 5: // '\005'
            func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            break;
        }
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        switch(func_31050_c(l))
        {
        case 0: // '\0'
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;

        case 1: // '\001'
            func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;

        case 2: // '\002'
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;

        case 3: // '\003'
            func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;

        case 4: // '\004'
            func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;

        case 5: // '\005'
            func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        int i1 = func_31050_c(world.func_602_e(i, j, k));
        int j1 = world.func_600_a(i - Facing.field_31056_b[i1], j - Facing.field_31059_c[i1], k - Facing.field_31058_d[i1]);
        if(j1 != Block.field_9255_Z.field_376_bc && j1 != Block.field_9259_V.field_376_bc)
        {
            world.func_690_d(i, j, k, 0);
        } else
        {
            Block.field_345_n[j1].func_226_a(world, i - Facing.field_31056_b[i1], j - Facing.field_31059_c[i1], k - Facing.field_31058_d[i1], l);
        }
    }

    public static int func_31050_c(int i)
    {
        return i & 7;
    }
}

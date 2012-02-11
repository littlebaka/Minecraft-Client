// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, World, EntityLiving, MathHelper, 
//            IBlockAccess, AxisAlignedBB, EntityPlayer, Entity, 
//            Vec3D

public class BlockStairs extends Block
{

    private Block field_452_a;

    protected BlockStairs(int i, Block block)
    {
        super(i, block.field_378_bb, block.field_356_bn);
        field_452_a = block;
        func_222_c(block.field_374_bd);
        func_219_b(block.field_372_be / 3F);
        func_4024_a(block.field_358_bl);
        func_256_d(255);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return super.func_221_d(world, i, j, k);
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_210_f()
    {
        return 10;
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.func_260_c(iblockaccess, i, j, k, l);
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        int l = world.func_602_e(i, j, k);
        if(l == 0)
        {
            func_213_a(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 1)
        {
            func_213_a(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 2)
        {
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 3)
        {
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
            func_213_a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        }
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        field_452_a.func_247_b(world, i, j, k, random);
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        field_452_a.func_233_b(world, i, j, k, entityplayer);
    }

    public void func_252_b(World world, int i, int j, int k, int l)
    {
        field_452_a.func_252_b(world, i, j, k, l);
    }

    public int func_35275_c(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return field_452_a.func_35275_c(iblockaccess, i, j, k);
    }

    public float func_241_c(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return field_452_a.func_241_c(iblockaccess, i, j, k);
    }

    public float func_227_a(Entity entity)
    {
        return field_452_a.func_227_a(entity);
    }

    public int func_234_g()
    {
        return field_452_a.func_234_g();
    }

    public int func_232_a(int i, int j)
    {
        return field_452_a.func_232_a(i, 0);
    }

    public int func_218_a(int i)
    {
        return field_452_a.func_232_a(i, 0);
    }

    public int func_4025_d()
    {
        return field_452_a.func_4025_d();
    }

    public AxisAlignedBB func_246_f(World world, int i, int j, int k)
    {
        return field_452_a.func_246_f(world, i, j, k);
    }

    public void func_257_a(World world, int i, int j, int k, Entity entity, Vec3D vec3d)
    {
        field_452_a.func_257_a(world, i, j, k, entity, vec3d);
    }

    public boolean func_245_h()
    {
        return field_452_a.func_245_h();
    }

    public boolean func_224_a(int i, boolean flag)
    {
        return field_452_a.func_224_a(i, flag);
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return field_452_a.func_243_a(world, i, j, k);
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        func_226_a(world, i, j, k, 0);
        field_452_a.func_235_e(world, i, j, k);
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        field_452_a.func_214_b(world, i, j, k);
    }

    public void func_254_a(World world, int i, int j, int k, Entity entity)
    {
        field_452_a.func_254_a(world, i, j, k, entity);
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        field_452_a.func_208_a(world, i, j, k, random);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return field_452_a.func_250_a(world, i, j, k, entityplayer);
    }

    public void func_4027_c(World world, int i, int j, int k)
    {
        field_452_a.func_4027_c(world, i, j, k);
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.func_1108_b((double)((entityliving.field_605_aq * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.func_691_b(i, j, k, 2);
        }
        if(l == 1)
        {
            world.func_691_b(i, j, k, 1);
        }
        if(l == 2)
        {
            world.func_691_b(i, j, k, 3);
        }
        if(l == 3)
        {
            world.func_691_b(i, j, k, 0);
        }
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Block, World, BlockGrass, 
//            IBlockAccess, Item, EntityItem, ItemStack

public class BlockStem extends BlockFlower
{

    private Block field_35297_a;

    protected BlockStem(int i, Block block)
    {
        super(i, 111);
        field_35297_a = block;
        func_253_b(true);
        float f = 0.125F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    protected boolean func_269_b(int i)
    {
        return i == Block.field_446_aB.field_376_bc;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        super.func_208_a(world, i, j, k, random);
        if(world.func_618_j(i, j + 1, k) >= 9)
        {
            float f = func_35295_j(world, i, j, k);
            if(random.nextInt((int)(25F / f) + 1) == 0)
            {
                int l = world.func_602_e(i, j, k);
                if(l < 7)
                {
                    l++;
                    world.func_691_b(i, j, k, l);
                } else
                {
                    if(world.func_600_a(i - 1, j, k) == field_35297_a.field_376_bc)
                    {
                        return;
                    }
                    if(world.func_600_a(i + 1, j, k) == field_35297_a.field_376_bc)
                    {
                        return;
                    }
                    if(world.func_600_a(i, j, k - 1) == field_35297_a.field_376_bc)
                    {
                        return;
                    }
                    if(world.func_600_a(i, j, k + 1) == field_35297_a.field_376_bc)
                    {
                        return;
                    }
                    int i1 = random.nextInt(4);
                    int j1 = i;
                    int k1 = k;
                    if(i1 == 0)
                    {
                        j1--;
                    }
                    if(i1 == 1)
                    {
                        j1++;
                    }
                    if(i1 == 2)
                    {
                        k1--;
                    }
                    if(i1 == 3)
                    {
                        k1++;
                    }
                    int l1 = world.func_600_a(j1, j - 1, k1);
                    if(world.func_600_a(j1, j, k1) == 0 && (l1 == Block.field_446_aB.field_376_bc || l1 == Block.field_336_w.field_376_bc || l1 == Block.field_337_v.field_376_bc))
                    {
                        world.func_690_d(j1, j, k1, field_35297_a.field_376_bc);
                    }
                }
            }
        }
    }

    public void func_35294_i(World world, int i, int j, int k)
    {
        world.func_691_b(i, j, k, 7);
    }

    private float func_35295_j(World world, int i, int j, int k)
    {
        float f = 1.0F;
        int l = world.func_600_a(i, j, k - 1);
        int i1 = world.func_600_a(i, j, k + 1);
        int j1 = world.func_600_a(i - 1, j, k);
        int k1 = world.func_600_a(i + 1, j, k);
        int l1 = world.func_600_a(i - 1, j, k - 1);
        int i2 = world.func_600_a(i + 1, j, k - 1);
        int j2 = world.func_600_a(i + 1, j, k + 1);
        int k2 = world.func_600_a(i - 1, j, k + 1);
        boolean flag = j1 == field_376_bc || k1 == field_376_bc;
        boolean flag1 = l == field_376_bc || i1 == field_376_bc;
        boolean flag2 = l1 == field_376_bc || i2 == field_376_bc || j2 == field_376_bc || k2 == field_376_bc;
        for(int l2 = i - 1; l2 <= i + 1; l2++)
        {
            for(int i3 = k - 1; i3 <= k + 1; i3++)
            {
                int j3 = world.func_600_a(l2, j - 1, i3);
                float f1 = 0.0F;
                if(j3 == Block.field_446_aB.field_376_bc)
                {
                    f1 = 1.0F;
                    if(world.func_602_e(l2, j - 1, i3) > 0)
                    {
                        f1 = 3F;
                    }
                }
                if(l2 != i || i3 != k)
                {
                    f1 /= 4F;
                }
                f += f1;
            }

        }

        if(flag2 || flag && flag1)
        {
            f /= 2.0F;
        }
        return f;
    }

    public int func_31030_b(int i)
    {
        int j = i * 32;
        int k = 255 - i * 8;
        int l = i * 4;
        return j << 16 | k << 8 | l;
    }

    public int func_207_d(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return func_31030_b(iblockaccess.func_602_e(i, j, k));
    }

    public int func_232_a(int i, int j)
    {
        return field_378_bb;
    }

    public void func_237_e()
    {
        float f = 0.125F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        field_362_bj = (float)(iblockaccess.func_602_e(i, j, k) * 2 + 2) / 16F;
        float f = 0.125F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float)field_362_bj, 0.5F + f);
    }

    public int func_210_f()
    {
        return 19;
    }

    public int func_35296_f(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        if(l < 7)
        {
            return -1;
        }
        if(iblockaccess.func_600_a(i - 1, j, k) == field_35297_a.field_376_bc)
        {
            return 0;
        }
        if(iblockaccess.func_600_a(i + 1, j, k) == field_35297_a.field_376_bc)
        {
            return 1;
        }
        if(iblockaccess.func_600_a(i, j, k - 1) == field_35297_a.field_376_bc)
        {
            return 2;
        }
        return iblockaccess.func_600_a(i, j, k + 1) != field_35297_a.field_376_bc ? -1 : 3;
    }

    public void func_216_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.func_216_a(world, i, j, k, l, f, i1);
        if(world.field_1026_y)
        {
            return;
        }
        Item item = null;
        if(field_35297_a == Block.field_4055_bb)
        {
            item = Item.field_35422_bh;
        }
        if(field_35297_a == Block.field_35281_bs)
        {
            item = Item.field_35423_bi;
        }
        for(int j1 = 0; j1 < 3; j1++)
        {
            if(world.field_1037_n.nextInt(15) <= l)
            {
                float f1 = 0.7F;
                float f2 = world.field_1037_n.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f3 = world.field_1037_n.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f4 = world.field_1037_n.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                EntityItem entityitem = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(item));
                entityitem.field_805_c = 10;
                world.func_674_a(entityitem);
            }
        }

    }

    public int func_240_a(int i, Random random, int j)
    {
        if(i != 7);
        return -1;
    }

    public int func_229_a(Random random)
    {
        return 1;
    }
}

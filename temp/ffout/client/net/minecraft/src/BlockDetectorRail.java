// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockRail, World, IBlockAccess, EntityMinecart, 
//            AxisAlignedBB, Entity

public class BlockDetectorRail extends BlockRail
{

    public BlockDetectorRail(int i, int j)
    {
        super(i, j, true);
        func_253_b(true);
    }

    public int func_4025_d()
    {
        return 20;
    }

    public boolean func_209_d()
    {
        return true;
    }

    public void func_236_b(World world, int i, int j, int k, Entity entity)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int l = world.func_602_e(i, j, k);
        if((l & 8) != 0)
        {
            return;
        } else
        {
            func_27046_f(world, i, j, k, l);
            return;
        }
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int l = world.func_602_e(i, j, k);
        if((l & 8) == 0)
        {
            return;
        } else
        {
            func_27046_f(world, i, j, k, l);
            return;
        }
    }

    public boolean func_231_b(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return (iblockaccess.func_602_e(i, j, k) & 8) != 0;
    }

    public boolean func_228_c(World world, int i, int j, int k, int l)
    {
        if((world.func_602_e(i, j, k) & 8) == 0)
        {
            return false;
        } else
        {
            return l == 1;
        }
    }

    private void func_27046_f(World world, int i, int j, int k, int l)
    {
        boolean flag = (l & 8) != 0;
        boolean flag1 = false;
        float f = 0.125F;
        List list = world.func_657_a(net.minecraft.src.EntityMinecart.class, AxisAlignedBB.func_1161_b((float)i + f, j, (float)k + f, (float)(i + 1) - f, (float)(j + 1) - f, (float)(k + 1) - f));
        if(list.size() > 0)
        {
            flag1 = true;
        }
        if(flag1 && !flag)
        {
            world.func_691_b(i, j, k, l | 8);
            world.func_611_g(i, j, k, field_376_bc);
            world.func_611_g(i, j - 1, k, field_376_bc);
            world.func_701_b(i, j, k, i, j, k);
        }
        if(!flag1 && flag)
        {
            world.func_691_b(i, j, k, l & 7);
            world.func_611_g(i, j, k, field_376_bc);
            world.func_611_g(i, j - 1, k, field_376_bc);
            world.func_701_b(i, j, k, i, j, k);
        }
        if(flag1)
        {
            world.func_22136_c(i, j, k, field_376_bc, func_4025_d());
        }
    }
}

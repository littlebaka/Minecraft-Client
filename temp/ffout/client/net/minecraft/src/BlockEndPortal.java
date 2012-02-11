// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, TileEntityEndPortal, Entity, EntityPlayer, 
//            World, WorldProvider, Material, TileEntity, 
//            IBlockAccess, AxisAlignedBB

public class BlockEndPortal extends BlockContainer
{

    public static boolean field_41051_a = false;

    protected BlockEndPortal(int i, Material material)
    {
        super(i, 0, material);
        func_215_a(1.0F);
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityEndPortal();
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        float f = 0.0625F;
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l != 0)
        {
            return false;
        } else
        {
            return super.func_260_c(iblockaccess, i, j, k, l);
        }
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public void func_236_b(World world, int i, int j, int k, Entity entity)
    {
        if(entity.field_616_af == null && entity.field_617_ae == null && (entity instanceof EntityPlayer) && !world.field_1026_y)
        {
            ((EntityPlayer)entity).func_40182_b(1);
        }
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        double d = (float)i + random.nextFloat();
        double d1 = (float)j + 0.8F;
        double d2 = (float)k + random.nextFloat();
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;
        world.func_694_a("smoke", d, d1, d2, d3, d4, d5);
    }

    public int func_210_f()
    {
        return -1;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        if(field_41051_a)
        {
            return;
        }
        if(world.field_4209_q.field_4218_e != 0)
        {
            world.func_690_d(i, j, k, 0);
            return;
        } else
        {
            return;
        }
    }

}

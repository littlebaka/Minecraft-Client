// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, World, TileEntityRecordPlayer, 
//            EntityItem, ItemStack, EntityPlayer, TileEntity

public class BlockJukeBox extends BlockContainer
{

    protected BlockJukeBox(int i, int j)
    {
        super(i, j, Material.field_1335_c);
    }

    public int func_218_a(int i)
    {
        return field_378_bb + (i != 1 ? 0 : 1);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.func_602_e(i, j, k) == 0)
        {
            return false;
        } else
        {
            func_28038_b_(world, i, j, k);
            return true;
        }
    }

    public void func_317_e(World world, int i, int j, int k, int l)
    {
        if(world.field_1026_y)
        {
            return;
        }
        TileEntityRecordPlayer tileentityrecordplayer = (TileEntityRecordPlayer)world.func_603_b(i, j, k);
        if(tileentityrecordplayer == null)
        {
            return;
        } else
        {
            tileentityrecordplayer.field_28017_a = l;
            tileentityrecordplayer.func_474_j_();
            world.func_691_b(i, j, k, 1);
            return;
        }
    }

    public void func_28038_b_(World world, int i, int j, int k)
    {
        if(world.field_1026_y)
        {
            return;
        }
        TileEntityRecordPlayer tileentityrecordplayer = (TileEntityRecordPlayer)world.func_603_b(i, j, k);
        if(tileentityrecordplayer == null)
        {
            return;
        }
        int l = tileentityrecordplayer.field_28017_a;
        if(l == 0)
        {
            return;
        } else
        {
            world.func_28106_e(1005, i, j, k, 0);
            world.func_670_a(null, i, j, k);
            tileentityrecordplayer.field_28017_a = 0;
            tileentityrecordplayer.func_474_j_();
            world.func_691_b(i, j, k, 0);
            int i1 = l;
            float f = 0.7F;
            double d = (double)(world.field_1037_n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(world.field_1037_n.nextFloat() * f) + (double)(1.0F - f) * 0.20000000000000001D + 0.59999999999999998D;
            double d2 = (double)(world.field_1037_n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(i1, 1, 0));
            entityitem.field_805_c = 10;
            world.func_674_a(entityitem);
            return;
        }
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        func_28038_b_(world, i, j, k);
        super.func_214_b(world, i, j, k);
    }

    public void func_216_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        if(world.field_1026_y)
        {
            return;
        } else
        {
            super.func_216_a(world, i, j, k, l, f, 0);
            return;
        }
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityRecordPlayer();
    }
}

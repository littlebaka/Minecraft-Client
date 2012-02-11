// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, World, TileEntity, Material

public abstract class BlockContainer extends Block
{

    protected BlockContainer(int i, Material material)
    {
        super(i, material);
        field_342_q[field_376_bc] = true;
    }

    protected BlockContainer(int i, int j, Material material)
    {
        super(i, j, material);
        field_342_q[field_376_bc] = true;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        super.func_235_e(world, i, j, k);
        world.func_654_a(i, j, k, func_283_a_());
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        super.func_214_b(world, i, j, k);
        world.func_692_l(i, j, k);
    }

    public abstract TileEntity func_283_a_();

    public void func_21024_a(World world, int i, int j, int k, int l, int i1)
    {
        super.func_21024_a(world, i, j, k, l, i1);
        TileEntity tileentity = world.func_603_b(i, j, k);
        if(tileentity != null)
        {
            tileentity.func_35143_b(l, i1);
        }
    }
}

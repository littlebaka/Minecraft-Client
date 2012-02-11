// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, AxisAlignedBB, Entity, 
//            World

public class BlockSoulSand extends Block
{

    public BlockSoulSand(int i, int j)
    {
        super(i, j, Material.field_1325_m);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        float f = 0.125F;
        return AxisAlignedBB.func_1161_b(i, j, k, i + 1, (float)(j + 1) - f, k + 1);
    }

    public void func_236_b(World world, int i, int j, int k, Entity entity)
    {
        entity.field_608_an *= 0.40000000000000002D;
        entity.field_606_ap *= 0.40000000000000002D;
    }
}

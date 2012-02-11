// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Chunk, World, EnumSkyBlock, Entity, 
//            TileEntity, AxisAlignedBB

public class EmptyChunk extends Chunk
{

    public EmptyChunk(World world, int i, int j)
    {
        super(world, i, j);
        field_1525_p = true;
    }

    public EmptyChunk(World world, byte abyte0[], int i, int j)
    {
        super(world, abyte0, i, j);
        field_1525_p = true;
    }

    public boolean func_1017_a(int i, int j)
    {
        return i == field_1531_j && j == field_1530_k;
    }

    public int func_999_b(int i, int j)
    {
        return 0;
    }

    public void func_1014_a()
    {
    }

    public void func_1018_b()
    {
    }

    public void func_1024_c()
    {
    }

    public void func_4143_d()
    {
    }

    public int func_1008_a(int i, int j, int k)
    {
        return 0;
    }

    public boolean func_1010_a(int i, int j, int k, int l, int i1)
    {
        return true;
    }

    public boolean func_1022_a(int i, int j, int k, int l)
    {
        return true;
    }

    public int func_1021_b(int i, int j, int k)
    {
        return 0;
    }

    public boolean func_1009_b(int i, int j, int k, int l)
    {
        return false;
    }

    public int func_1025_a(EnumSkyBlock enumskyblock, int i, int j, int k)
    {
        return 0;
    }

    public void func_1011_a(EnumSkyBlock enumskyblock, int i, int j, int k, int l)
    {
    }

    public int func_1019_c(int i, int j, int k, int l)
    {
        return 0;
    }

    public void func_1000_a(Entity entity)
    {
    }

    public void func_1015_b(Entity entity)
    {
    }

    public void func_1016_a(Entity entity, int i)
    {
    }

    public boolean func_1007_c(int i, int j, int k)
    {
        return false;
    }

    public TileEntity func_1002_d(int i, int j, int k)
    {
        return null;
    }

    public void func_1001_a(TileEntity tileentity)
    {
    }

    public void func_1005_a(int i, int j, int k, TileEntity tileentity)
    {
    }

    public void func_1023_e(int i, int j, int k)
    {
    }

    public void func_995_d()
    {
    }

    public void func_998_e()
    {
    }

    public void func_1006_f()
    {
    }

    public void func_994_a(Entity entity, AxisAlignedBB axisalignedbb, List list)
    {
    }

    public void func_1013_a(Class class1, AxisAlignedBB axisalignedbb, List list)
    {
    }

    public boolean func_1012_a(boolean flag)
    {
        return false;
    }

    public int func_1004_a(byte abyte0[], int i, int j, int k, int l, int i1, int j1, 
            int k1)
    {
        int l1 = l - i;
        int i2 = i1 - j;
        int j2 = j1 - k;
        int k2 = l1 * i2 * j2;
        return k2 + (k2 / 2) * 3;
    }

    public Random func_997_a(long l)
    {
        return new Random(field_1537_d.func_22138_q() + (long)(field_1531_j * field_1531_j * 0x4c1906) + (long)(field_1531_j * 0x5ac0db) + (long)(field_1530_k * field_1530_k) * 0x4307a7L + (long)(field_1530_k * 0x5f24f) ^ l);
    }

    public boolean func_21167_h()
    {
        return true;
    }
}

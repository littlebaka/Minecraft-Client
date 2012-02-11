// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            WorldProvider, WorldChunkManagerHell, BiomeGenBase, ChunkProviderEnd, 
//            World, MathHelper, Vec3D, Block, 
//            Material, ChunkCoordinates, IChunkProvider

public class WorldProviderEnd extends WorldProvider
{

    public WorldProviderEnd()
    {
    }

    public void func_4098_a()
    {
        field_4215_b = new WorldChunkManagerHell(BiomeGenBase.field_28057_m, 0.5F, 0.0F);
        field_4218_e = 1;
        field_6478_e = true;
        field_4220_c = true;
    }

    public IChunkProvider func_4094_c()
    {
        return new ChunkProviderEnd(field_4216_a, field_4216_a.func_22138_q());
    }

    public float func_4100_a(long l, float f)
    {
        return 0.0F;
    }

    public float[] func_4097_b(float f, float f1)
    {
        return null;
    }

    public Vec3D func_4096_a(float f, float f1)
    {
        int i = 0x8080a0;
        float f2 = MathHelper.func_1114_b(f * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = (float)(i >> 16 & 0xff) / 255F;
        float f4 = (float)(i >> 8 & 0xff) / 255F;
        float f5 = (float)(i & 0xff) / 255F;
        f3 *= f2 * 0.0F + 0.15F;
        f4 *= f2 * 0.0F + 0.15F;
        f5 *= f2 * 0.0F + 0.15F;
        return Vec3D.func_1248_b(f3, f4, f5);
    }

    public boolean func_28112_c()
    {
        return false;
    }

    public boolean func_6477_d()
    {
        return false;
    }

    public float func_28111_d()
    {
        return 8F;
    }

    public boolean func_4102_a(int i, int j)
    {
        int k = field_4216_a.func_614_g(i, j);
        if(k == 0)
        {
            return false;
        } else
        {
            return Block.field_345_n[k].field_356_bn.func_880_c();
        }
    }

    public ChunkCoordinates func_40469_f()
    {
        return new ChunkCoordinates(100, 50, 0);
    }

    public int func_46066_g()
    {
        return 50;
    }
}

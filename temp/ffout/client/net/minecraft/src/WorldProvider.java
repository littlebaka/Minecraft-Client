// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            World, WorldInfo, EnumWorldType, WorldChunkManagerHell, 
//            BiomeGenBase, WorldChunkManager, ChunkProviderFlat, ChunkProviderGenerate, 
//            Block, BlockGrass, MathHelper, Vec3D, 
//            WorldProviderHell, WorldProviderSurface, WorldProviderEnd, IChunkProvider, 
//            ChunkCoordinates

public abstract class WorldProvider
{

    public World field_4216_a;
    public EnumWorldType field_46067_b;
    public WorldChunkManager field_4215_b;
    public boolean field_4220_c;
    public boolean field_6479_d;
    public boolean field_6478_e;
    public float field_4219_d[];
    public int field_4218_e;
    private float field_4217_f[];

    public WorldProvider()
    {
        field_4220_c = false;
        field_6479_d = false;
        field_6478_e = false;
        field_4219_d = new float[16];
        field_4218_e = 0;
        field_4217_f = new float[4];
    }

    public final void func_4095_a(World world)
    {
        field_4216_a = world;
        field_46067_b = world.func_22144_v().func_46133_t();
        func_4098_a();
        func_4093_b();
    }

    protected void func_4093_b()
    {
        float f = 0.0F;
        for(int i = 0; i <= 15; i++)
        {
            float f1 = 1.0F - (float)i / 15F;
            field_4219_d[i] = ((1.0F - f1) / (f1 * 3F + 1.0F)) * (1.0F - f) + f;
        }

    }

    protected void func_4098_a()
    {
        if(field_4216_a.func_22144_v().func_46133_t() == EnumWorldType.FLAT)
        {
            field_4215_b = new WorldChunkManagerHell(BiomeGenBase.field_35485_c, 0.5F, 0.5F);
        } else
        {
            field_4215_b = new WorldChunkManager(field_4216_a);
        }
    }

    public IChunkProvider func_4094_c()
    {
        if(field_46067_b == EnumWorldType.FLAT)
        {
            return new ChunkProviderFlat(field_4216_a, field_4216_a.func_22138_q(), field_4216_a.func_22144_v().func_35917_r());
        } else
        {
            return new ChunkProviderGenerate(field_4216_a, field_4216_a.func_22138_q(), field_4216_a.func_22144_v().func_35917_r());
        }
    }

    public boolean func_4102_a(int i, int j)
    {
        int k = field_4216_a.func_614_g(i, j);
        return k == Block.field_337_v.field_376_bc;
    }

    public float func_4100_a(long l, float f)
    {
        int i = (int)(l % 24000L);
        float f1 = ((float)i + f) / 24000F - 0.25F;
        if(f1 < 0.0F)
        {
            f1++;
        }
        if(f1 > 1.0F)
        {
            f1--;
        }
        float f2 = f1;
        f1 = 1.0F - (float)((Math.cos((double)f1 * 3.1415926535897931D) + 1.0D) / 2D);
        f1 = f2 + (f1 - f2) / 3F;
        return f1;
    }

    public int func_40470_b(long l, float f)
    {
        return (int)(l / 24000L) % 8;
    }

    public float[] func_4097_b(float f, float f1)
    {
        float f2 = 0.4F;
        float f3 = MathHelper.func_1114_b(f * 3.141593F * 2.0F) - 0.0F;
        float f4 = -0F;
        if(f3 >= f4 - f2 && f3 <= f4 + f2)
        {
            float f5 = ((f3 - f4) / f2) * 0.5F + 0.5F;
            float f6 = 1.0F - (1.0F - MathHelper.func_1106_a(f5 * 3.141593F)) * 0.99F;
            f6 *= f6;
            field_4217_f[0] = f5 * 0.3F + 0.7F;
            field_4217_f[1] = f5 * f5 * 0.7F + 0.2F;
            field_4217_f[2] = f5 * f5 * 0.0F + 0.2F;
            field_4217_f[3] = f6;
            return field_4217_f;
        } else
        {
            return null;
        }
    }

    public Vec3D func_4096_a(float f, float f1)
    {
        float f2 = MathHelper.func_1114_b(f * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = 0.7529412F;
        float f4 = 0.8470588F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return Vec3D.func_1248_b(f3, f4, f5);
    }

    public boolean func_6477_d()
    {
        return true;
    }

    public static WorldProvider func_4101_a(int i)
    {
        if(i == -1)
        {
            return new WorldProviderHell();
        }
        if(i == 0)
        {
            return new WorldProviderSurface();
        }
        if(i == 1)
        {
            return new WorldProviderEnd();
        } else
        {
            return null;
        }
    }

    public float func_28111_d()
    {
        return (float)field_4216_a.field_35472_c;
    }

    public boolean func_28112_c()
    {
        return true;
    }

    public ChunkCoordinates func_40469_f()
    {
        return null;
    }

    public int func_46066_g()
    {
        if(field_46067_b == EnumWorldType.FLAT)
        {
            return 4;
        } else
        {
            return field_4216_a.field_35472_c / 2;
        }
    }

    public boolean func_46064_i()
    {
        return field_46067_b != EnumWorldType.FLAT && !field_6478_e;
    }

    public double func_46065_j()
    {
        return field_46067_b != EnumWorldType.FLAT ? 0.03125D : 1.0D;
    }
}

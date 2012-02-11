// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, BiomeDecorator, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, ColorizerFoliage, WorldGenerator

public class BiomeGenSwamp extends BiomeGenBase
{

    protected BiomeGenSwamp(int i)
    {
        super(i);
        field_35488_u.field_35911_r = 2;
        field_35488_u.field_35910_s = -999;
        field_35488_u.field_35908_u = 1;
        field_35488_u.field_35907_v = 8;
        field_35488_u.field_35906_w = 10;
        field_35488_u.field_35888_A = 1;
        field_35488_u.field_40721_y = 4;
        field_40256_A = 0xe0ffae;
    }

    public WorldGenerator func_21107_a(Random random)
    {
        return field_35482_C;
    }

    public int func_40254_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        double d = iblockaccess.func_4075_a().func_35554_b(i, j, k);
        double d1 = iblockaccess.func_4075_a().func_35558_c(i, k);
        return ((ColorizerGrass.func_4147_a(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }

    public int func_40255_b(IBlockAccess iblockaccess, int i, int j, int k)
    {
        double d = iblockaccess.func_4075_a().func_35554_b(i, j, k);
        double d1 = iblockaccess.func_4075_a().func_35558_c(i, k);
        return ((ColorizerFoliage.func_4146_a(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }
}

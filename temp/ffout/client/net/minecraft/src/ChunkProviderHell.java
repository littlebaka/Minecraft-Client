// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, MapGenNetherBridge, MapGenCavesHell, NoiseGeneratorOctaves, 
//            World, Block, MapGenBase, Chunk, 
//            BlockSand, WorldGenHellLava, WorldGenFire, WorldGenGlowStone1, 
//            WorldGenGlowStone2, WorldGenFlowers, BlockFlower, EnumCreatureType, 
//            ChunkCoordIntPair, WorldChunkManager, BiomeGenBase, IProgressUpdate, 
//            ChunkPosition

public class ChunkProviderHell
    implements IChunkProvider
{

    private Random field_4170_h;
    private NoiseGeneratorOctaves field_4169_i;
    private NoiseGeneratorOctaves field_4168_j;
    private NoiseGeneratorOctaves field_4167_k;
    private NoiseGeneratorOctaves field_4166_l;
    private NoiseGeneratorOctaves field_4165_m;
    public NoiseGeneratorOctaves field_4177_a;
    public NoiseGeneratorOctaves field_4176_b;
    private World field_4164_n;
    private double field_4163_o[];
    public MapGenNetherBridge field_40378_c;
    private double field_4162_p[];
    private double field_4161_q[];
    private double field_4160_r[];
    private MapGenBase field_4159_s;
    double field_4175_c[];
    double field_4174_d[];
    double field_4173_e[];
    double field_4172_f[];
    double field_4171_g[];

    public ChunkProviderHell(World world, long l)
    {
        field_40378_c = new MapGenNetherBridge();
        field_4162_p = new double[256];
        field_4161_q = new double[256];
        field_4160_r = new double[256];
        field_4159_s = new MapGenCavesHell();
        field_4164_n = world;
        field_4170_h = new Random(l);
        field_4169_i = new NoiseGeneratorOctaves(field_4170_h, 16);
        field_4168_j = new NoiseGeneratorOctaves(field_4170_h, 16);
        field_4167_k = new NoiseGeneratorOctaves(field_4170_h, 8);
        field_4166_l = new NoiseGeneratorOctaves(field_4170_h, 4);
        field_4165_m = new NoiseGeneratorOctaves(field_4170_h, 4);
        field_4177_a = new NoiseGeneratorOctaves(field_4170_h, 10);
        field_4176_b = new NoiseGeneratorOctaves(field_4170_h, 16);
    }

    public void func_4059_a(int i, int j, byte abyte0[])
    {
        byte byte0 = 4;
        byte byte1 = 32;
        int k = byte0 + 1;
        int l = field_4164_n.field_35472_c / 8 + 1;
        int i1 = byte0 + 1;
        field_4163_o = func_4057_a(field_4163_o, i * byte0, 0, j * byte0, k, l, i1);
        for(int j1 = 0; j1 < byte0; j1++)
        {
            for(int k1 = 0; k1 < byte0; k1++)
            {
                for(int l1 = 0; l1 < field_4164_n.field_35472_c / 8; l1++)
                {
                    double d = 0.125D;
                    double d1 = field_4163_o[((j1 + 0) * i1 + (k1 + 0)) * l + (l1 + 0)];
                    double d2 = field_4163_o[((j1 + 0) * i1 + (k1 + 1)) * l + (l1 + 0)];
                    double d3 = field_4163_o[((j1 + 1) * i1 + (k1 + 0)) * l + (l1 + 0)];
                    double d4 = field_4163_o[((j1 + 1) * i1 + (k1 + 1)) * l + (l1 + 0)];
                    double d5 = (field_4163_o[((j1 + 0) * i1 + (k1 + 0)) * l + (l1 + 1)] - d1) * d;
                    double d6 = (field_4163_o[((j1 + 0) * i1 + (k1 + 1)) * l + (l1 + 1)] - d2) * d;
                    double d7 = (field_4163_o[((j1 + 1) * i1 + (k1 + 0)) * l + (l1 + 1)] - d3) * d;
                    double d8 = (field_4163_o[((j1 + 1) * i1 + (k1 + 1)) * l + (l1 + 1)] - d4) * d;
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for(int j2 = 0; j2 < 4; j2++)
                        {
                            int k2 = j2 + j1 * 4 << field_4164_n.field_35471_b | 0 + k1 * 4 << field_4164_n.field_35473_a | l1 * 8 + i2;
                            int l2 = 1 << field_4164_n.field_35473_a;
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for(int i3 = 0; i3 < 4; i3++)
                            {
                                int j3 = 0;
                                if(l1 * 8 + i2 < byte1)
                                {
                                    j3 = Block.field_395_E.field_376_bc;
                                }
                                if(d15 > 0.0D)
                                {
                                    j3 = Block.field_4053_bc.field_376_bc;
                                }
                                abyte0[k2] = (byte)j3;
                                k2 += l2;
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }

                }

            }

        }

    }

    public void func_4058_b(int i, int j, byte abyte0[])
    {
        int k = field_4164_n.field_35472_c - 64;
        double d = 0.03125D;
        field_4162_p = field_4166_l.func_807_a(field_4162_p, i * 16, j * 16, 0, 16, 16, 1, d, d, 1.0D);
        field_4161_q = field_4166_l.func_807_a(field_4161_q, i * 16, 109, j * 16, 16, 1, 16, d, 1.0D, d);
        field_4160_r = field_4165_m.func_807_a(field_4160_r, i * 16, j * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);
        for(int l = 0; l < 16; l++)
        {
            for(int i1 = 0; i1 < 16; i1++)
            {
                boolean flag = field_4162_p[l + i1 * 16] + field_4170_h.nextDouble() * 0.20000000000000001D > 0.0D;
                boolean flag1 = field_4161_q[l + i1 * 16] + field_4170_h.nextDouble() * 0.20000000000000001D > 0.0D;
                int j1 = (int)(field_4160_r[l + i1 * 16] / 3D + 3D + field_4170_h.nextDouble() * 0.25D);
                int k1 = -1;
                byte byte0 = (byte)Block.field_4053_bc.field_376_bc;
                byte byte1 = (byte)Block.field_4053_bc.field_376_bc;
                for(int l1 = field_4164_n.field_35469_d; l1 >= 0; l1--)
                {
                    int i2 = (i1 * 16 + l) * field_4164_n.field_35472_c + l1;
                    if(l1 >= field_4164_n.field_35469_d - field_4170_h.nextInt(5))
                    {
                        abyte0[i2] = (byte)Block.field_403_A.field_376_bc;
                        continue;
                    }
                    if(l1 <= 0 + field_4170_h.nextInt(5))
                    {
                        abyte0[i2] = (byte)Block.field_403_A.field_376_bc;
                        continue;
                    }
                    byte byte2 = abyte0[i2];
                    if(byte2 == 0)
                    {
                        k1 = -1;
                        continue;
                    }
                    if(byte2 != Block.field_4053_bc.field_376_bc)
                    {
                        continue;
                    }
                    if(k1 == -1)
                    {
                        if(j1 <= 0)
                        {
                            byte0 = 0;
                            byte1 = (byte)Block.field_4053_bc.field_376_bc;
                        } else
                        if(l1 >= k - 4 && l1 <= k + 1)
                        {
                            byte0 = (byte)Block.field_4053_bc.field_376_bc;
                            byte1 = (byte)Block.field_4053_bc.field_376_bc;
                            if(flag1)
                            {
                                byte0 = (byte)Block.field_392_G.field_376_bc;
                            }
                            if(flag1)
                            {
                                byte1 = (byte)Block.field_4053_bc.field_376_bc;
                            }
                            if(flag)
                            {
                                byte0 = (byte)Block.field_4051_bd.field_376_bc;
                            }
                            if(flag)
                            {
                                byte1 = (byte)Block.field_4051_bd.field_376_bc;
                            }
                        }
                        if(l1 < k && byte0 == 0)
                        {
                            byte0 = (byte)Block.field_395_E.field_376_bc;
                        }
                        k1 = j1;
                        if(l1 >= k - 1)
                        {
                            abyte0[i2] = byte0;
                        } else
                        {
                            abyte0[i2] = byte1;
                        }
                        continue;
                    }
                    if(k1 > 0)
                    {
                        k1--;
                        abyte0[i2] = byte1;
                    }
                }

            }

        }

    }

    public Chunk func_538_d(int i, int j)
    {
        return func_533_b(i, j);
    }

    public Chunk func_533_b(int i, int j)
    {
        field_4170_h.setSeed((long)i * 0x4f9939f508L + (long)j * 0x1ef1565bd5L);
        byte abyte0[] = new byte[16 * field_4164_n.field_35472_c * 16];
        func_4059_a(i, j, abyte0);
        func_4058_b(i, j, abyte0);
        field_4159_s.func_867_a(this, field_4164_n, i, j, abyte0);
        field_40378_c.func_867_a(this, field_4164_n, i, j, abyte0);
        Chunk chunk = new Chunk(field_4164_n, abyte0, i, j);
        return chunk;
    }

    private double[] func_4057_a(double ad[], int i, int j, int k, int l, int i1, int j1)
    {
        if(ad == null)
        {
            ad = new double[l * i1 * j1];
        }
        double d = 684.41200000000003D;
        double d1 = 2053.2359999999999D;
        field_4172_f = field_4177_a.func_807_a(field_4172_f, i, j, k, l, 1, j1, 1.0D, 0.0D, 1.0D);
        field_4171_g = field_4176_b.func_807_a(field_4171_g, i, j, k, l, 1, j1, 100D, 0.0D, 100D);
        field_4175_c = field_4167_k.func_807_a(field_4175_c, i, j, k, l, i1, j1, d / 80D, d1 / 60D, d / 80D);
        field_4174_d = field_4169_i.func_807_a(field_4174_d, i, j, k, l, i1, j1, d, d1, d);
        field_4173_e = field_4168_j.func_807_a(field_4173_e, i, j, k, l, i1, j1, d, d1, d);
        int k1 = 0;
        int l1 = 0;
        double ad1[] = new double[i1];
        for(int i2 = 0; i2 < i1; i2++)
        {
            ad1[i2] = Math.cos(((double)i2 * 3.1415926535897931D * 6D) / (double)i1) * 2D;
            double d2 = i2;
            if(i2 > i1 / 2)
            {
                d2 = i1 - 1 - i2;
            }
            if(d2 < 4D)
            {
                d2 = 4D - d2;
                ad1[i2] -= d2 * d2 * d2 * 10D;
            }
        }

        for(int j2 = 0; j2 < l; j2++)
        {
            for(int k2 = 0; k2 < j1; k2++)
            {
                double d3 = (field_4172_f[l1] + 256D) / 512D;
                if(d3 > 1.0D)
                {
                    d3 = 1.0D;
                }
                double d4 = 0.0D;
                double d5 = field_4171_g[l1] / 8000D;
                if(d5 < 0.0D)
                {
                    d5 = -d5;
                }
                d5 = d5 * 3D - 3D;
                if(d5 < 0.0D)
                {
                    d5 /= 2D;
                    if(d5 < -1D)
                    {
                        d5 = -1D;
                    }
                    d5 /= 1.3999999999999999D;
                    d5 /= 2D;
                    d3 = 0.0D;
                } else
                {
                    if(d5 > 1.0D)
                    {
                        d5 = 1.0D;
                    }
                    d5 /= 6D;
                }
                d3 += 0.5D;
                d5 = (d5 * (double)i1) / 16D;
                l1++;
                for(int l2 = 0; l2 < i1; l2++)
                {
                    double d6 = 0.0D;
                    double d7 = ad1[l2];
                    double d8 = field_4174_d[k1] / 512D;
                    double d9 = field_4173_e[k1] / 512D;
                    double d10 = (field_4175_c[k1] / 10D + 1.0D) / 2D;
                    if(d10 < 0.0D)
                    {
                        d6 = d8;
                    } else
                    if(d10 > 1.0D)
                    {
                        d6 = d9;
                    } else
                    {
                        d6 = d8 + (d9 - d8) * d10;
                    }
                    d6 -= d7;
                    if(l2 > i1 - 4)
                    {
                        double d11 = (float)(l2 - (i1 - 4)) / 3F;
                        d6 = d6 * (1.0D - d11) + -10D * d11;
                    }
                    if((double)l2 < d4)
                    {
                        double d12 = (d4 - (double)l2) / 4D;
                        if(d12 < 0.0D)
                        {
                            d12 = 0.0D;
                        }
                        if(d12 > 1.0D)
                        {
                            d12 = 1.0D;
                        }
                        d6 = d6 * (1.0D - d12) + -10D * d12;
                    }
                    ad[k1] = d6;
                    k1++;
                }

            }

        }

        return ad;
    }

    public boolean func_537_a(int i, int j)
    {
        return true;
    }

    public void func_534_a(IChunkProvider ichunkprovider, int i, int j)
    {
        BlockSand.field_466_a = true;
        int k = i * 16;
        int l = j * 16;
        field_40378_c.func_35629_a(field_4164_n, field_4170_h, i, j);
        for(int i1 = 0; i1 < 8; i1++)
        {
            int k1 = k + field_4170_h.nextInt(16) + 8;
            int i3 = field_4170_h.nextInt(field_4164_n.field_35472_c - 8) + 4;
            int k4 = l + field_4170_h.nextInt(16) + 8;
            (new WorldGenHellLava(Block.field_397_D.field_376_bc)).func_516_a(field_4164_n, field_4170_h, k1, i3, k4);
        }

        int j1 = field_4170_h.nextInt(field_4170_h.nextInt(10) + 1) + 1;
        for(int l1 = 0; l1 < j1; l1++)
        {
            int j3 = k + field_4170_h.nextInt(16) + 8;
            int l4 = field_4170_h.nextInt(field_4164_n.field_35472_c - 8) + 4;
            int i6 = l + field_4170_h.nextInt(16) + 8;
            (new WorldGenFire()).func_516_a(field_4164_n, field_4170_h, j3, l4, i6);
        }

        j1 = field_4170_h.nextInt(field_4170_h.nextInt(10) + 1);
        for(int i2 = 0; i2 < j1; i2++)
        {
            int k3 = k + field_4170_h.nextInt(16) + 8;
            int i5 = field_4170_h.nextInt(field_4164_n.field_35472_c - 8) + 4;
            int j6 = l + field_4170_h.nextInt(16) + 8;
            (new WorldGenGlowStone1()).func_516_a(field_4164_n, field_4170_h, k3, i5, j6);
        }

        for(int j2 = 0; j2 < 10; j2++)
        {
            int l3 = k + field_4170_h.nextInt(16) + 8;
            int j5 = field_4170_h.nextInt(field_4164_n.field_35472_c);
            int k6 = l + field_4170_h.nextInt(16) + 8;
            (new WorldGenGlowStone2()).func_516_a(field_4164_n, field_4170_h, l3, j5, k6);
        }

        if(field_4170_h.nextInt(1) == 0)
        {
            int k2 = k + field_4170_h.nextInt(16) + 8;
            int i4 = field_4170_h.nextInt(field_4164_n.field_35472_c);
            int k5 = l + field_4170_h.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_415_ag.field_376_bc)).func_516_a(field_4164_n, field_4170_h, k2, i4, k5);
        }
        if(field_4170_h.nextInt(1) == 0)
        {
            int l2 = k + field_4170_h.nextInt(16) + 8;
            int j4 = field_4170_h.nextInt(field_4164_n.field_35472_c);
            int l5 = l + field_4170_h.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_414_ah.field_376_bc)).func_516_a(field_4164_n, field_4170_h, l2, j4, l5);
        }
        BlockSand.field_466_a = false;
    }

    public boolean func_535_a(boolean flag, IProgressUpdate iprogressupdate)
    {
        return true;
    }

    public boolean func_532_a()
    {
        return false;
    }

    public boolean func_536_b()
    {
        return true;
    }

    public String func_21109_c()
    {
        return "HellRandomLevelSource";
    }

    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        if(enumcreaturetype == EnumCreatureType.monster && field_40378_c.func_40483_a(i, j, k))
        {
            return field_40378_c.func_40485_b();
        }
        WorldChunkManager worldchunkmanager = field_4164_n.func_4075_a();
        if(worldchunkmanager == null)
        {
            return null;
        }
        BiomeGenBase biomegenbase = worldchunkmanager.func_4074_a(new ChunkCoordIntPair(i >> 4, k >> 4));
        if(biomegenbase == null)
        {
            return null;
        } else
        {
            return biomegenbase.func_25063_a(enumcreaturetype);
        }
    }

    public ChunkPosition func_40376_a(World world, String s, int i, int j, int k)
    {
        return null;
    }
}

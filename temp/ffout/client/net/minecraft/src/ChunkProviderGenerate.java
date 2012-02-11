// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, MapGenCaves, MapGenStronghold, MapGenVillage, 
//            MapGenMineshaft, MapGenRavine, NoiseGeneratorOctaves, World, 
//            WorldChunkManager, Block, BiomeGenBase, Chunk, 
//            MapGenBase, MathHelper, BlockSand, WorldGenLakes, 
//            WorldGenDungeons, SpawnerAnimals, ChunkCoordIntPair, IProgressUpdate, 
//            EnumCreatureType, ChunkPosition

public class ChunkProviderGenerate
    implements IChunkProvider
{

    private Random field_913_j;
    private NoiseGeneratorOctaves field_912_k;
    private NoiseGeneratorOctaves field_911_l;
    private NoiseGeneratorOctaves field_910_m;
    private NoiseGeneratorOctaves field_908_o;
    public NoiseGeneratorOctaves field_922_a;
    public NoiseGeneratorOctaves field_921_b;
    public NoiseGeneratorOctaves field_920_c;
    private World field_907_p;
    private final boolean field_35389_t;
    private double field_4180_q[];
    private double field_903_t[];
    private MapGenBase field_902_u;
    private MapGenStronghold field_35386_d;
    private MapGenVillage field_35387_e;
    private MapGenMineshaft field_35385_f;
    private MapGenBase field_35390_x;
    private BiomeGenBase field_4179_v[];
    double field_4185_d[];
    double field_4184_e[];
    double field_4183_f[];
    double field_4182_g[];
    double field_4181_h[];
    float field_35388_l[];
    int field_914_i[][];

    public ChunkProviderGenerate(World world, long l, boolean flag)
    {
        field_903_t = new double[256];
        field_902_u = new MapGenCaves();
        field_35386_d = new MapGenStronghold();
        field_35387_e = new MapGenVillage(0);
        field_35385_f = new MapGenMineshaft();
        field_35390_x = new MapGenRavine();
        field_914_i = new int[32][32];
        field_907_p = world;
        field_35389_t = flag;
        field_913_j = new Random(l);
        field_912_k = new NoiseGeneratorOctaves(field_913_j, 16);
        field_911_l = new NoiseGeneratorOctaves(field_913_j, 16);
        field_910_m = new NoiseGeneratorOctaves(field_913_j, 8);
        field_908_o = new NoiseGeneratorOctaves(field_913_j, 4);
        field_922_a = new NoiseGeneratorOctaves(field_913_j, 10);
        field_921_b = new NoiseGeneratorOctaves(field_913_j, 16);
        field_920_c = new NoiseGeneratorOctaves(field_913_j, 8);
    }

    public void func_4060_a(int i, int j, byte abyte0[])
    {
        byte byte0 = 4;
        int k = field_907_p.field_35472_c / 8;
        int l = field_907_p.field_35470_e;
        int i1 = byte0 + 1;
        int j1 = field_907_p.field_35472_c / 8 + 1;
        int k1 = byte0 + 1;
        field_4179_v = field_907_p.func_4075_a().func_35557_b(field_4179_v, i * 4 - 2, j * 4 - 2, i1 + 5, k1 + 5);
        field_4180_q = func_4061_a(field_4180_q, i * byte0, 0, j * byte0, i1, j1, k1);
        for(int l1 = 0; l1 < byte0; l1++)
        {
            for(int i2 = 0; i2 < byte0; i2++)
            {
                for(int j2 = 0; j2 < k; j2++)
                {
                    double d = 0.125D;
                    double d1 = field_4180_q[((l1 + 0) * k1 + (i2 + 0)) * j1 + (j2 + 0)];
                    double d2 = field_4180_q[((l1 + 0) * k1 + (i2 + 1)) * j1 + (j2 + 0)];
                    double d3 = field_4180_q[((l1 + 1) * k1 + (i2 + 0)) * j1 + (j2 + 0)];
                    double d4 = field_4180_q[((l1 + 1) * k1 + (i2 + 1)) * j1 + (j2 + 0)];
                    double d5 = (field_4180_q[((l1 + 0) * k1 + (i2 + 0)) * j1 + (j2 + 1)] - d1) * d;
                    double d6 = (field_4180_q[((l1 + 0) * k1 + (i2 + 1)) * j1 + (j2 + 1)] - d2) * d;
                    double d7 = (field_4180_q[((l1 + 1) * k1 + (i2 + 0)) * j1 + (j2 + 1)] - d3) * d;
                    double d8 = (field_4180_q[((l1 + 1) * k1 + (i2 + 1)) * j1 + (j2 + 1)] - d4) * d;
                    for(int k2 = 0; k2 < 8; k2++)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for(int l2 = 0; l2 < 4; l2++)
                        {
                            int i3 = l2 + l1 * 4 << field_907_p.field_35471_b | 0 + i2 * 4 << field_907_p.field_35473_a | j2 * 8 + k2;
                            int j3 = 1 << field_907_p.field_35473_a;
                            i3 -= j3;
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            d15 -= d16;
                            for(int k3 = 0; k3 < 4; k3++)
                            {
                                if((d15 += d16) > 0.0D)
                                {
                                    abyte0[i3 += j3] = (byte)Block.field_338_u.field_376_bc;
                                    continue;
                                }
                                if(j2 * 8 + k2 < l)
                                {
                                    abyte0[i3 += j3] = (byte)Block.field_399_C.field_376_bc;
                                } else
                                {
                                    abyte0[i3 += j3] = 0;
                                }
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

    public void func_4062_a(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[])
    {
        int k = field_907_p.field_35470_e;
        double d = 0.03125D;
        field_903_t = field_908_o.func_807_a(field_903_t, i * 16, j * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);
        float af[] = field_907_p.func_4075_a().func_40539_b(i * 16, j * 16, 16, 16);
        for(int l = 0; l < 16; l++)
        {
            for(int i1 = 0; i1 < 16; i1++)
            {
                float f = af[i1 + l * 16];
                BiomeGenBase biomegenbase = abiomegenbase[i1 + l * 16];
                int j1 = (int)(field_903_t[l + i1 * 16] / 3D + 3D + field_913_j.nextDouble() * 0.25D);
                int k1 = -1;
                byte byte0 = biomegenbase.field_4242_o;
                byte byte1 = biomegenbase.field_4241_p;
                for(int l1 = field_907_p.field_35469_d; l1 >= 0; l1--)
                {
                    int i2 = (i1 * 16 + l) * field_907_p.field_35472_c + l1;
                    if(l1 <= 0 + field_913_j.nextInt(5))
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
                    if(byte2 != Block.field_338_u.field_376_bc)
                    {
                        continue;
                    }
                    if(k1 == -1)
                    {
                        if(j1 <= 0)
                        {
                            byte0 = 0;
                            byte1 = (byte)Block.field_338_u.field_376_bc;
                        } else
                        if(l1 >= k - 4 && l1 <= k + 1)
                        {
                            byte0 = biomegenbase.field_4242_o;
                            byte1 = biomegenbase.field_4241_p;
                        }
                        if(l1 < k && byte0 == 0)
                        {
                            if(f < 0.15F)
                            {
                                byte0 = (byte)Block.field_4063_aU.field_376_bc;
                            } else
                            {
                                byte0 = (byte)Block.field_399_C.field_376_bc;
                            }
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
                    if(k1 <= 0)
                    {
                        continue;
                    }
                    k1--;
                    abyte0[i2] = byte1;
                    if(k1 == 0 && byte1 == Block.field_393_F.field_376_bc)
                    {
                        k1 = field_913_j.nextInt(4);
                        byte1 = (byte)Block.field_9264_Q.field_376_bc;
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
        field_913_j.setSeed((long)i * 0x4f9939f508L + (long)j * 0x1ef1565bd5L);
        byte abyte0[] = new byte[16 * field_907_p.field_35472_c * 16];
        Chunk chunk = new Chunk(field_907_p, abyte0, i, j);
        func_4060_a(i, j, abyte0);
        field_4179_v = field_907_p.func_4075_a().func_4070_a(field_4179_v, i * 16, j * 16, 16, 16);
        func_4062_a(i, j, abyte0, field_4179_v);
        field_902_u.func_867_a(this, field_907_p, i, j, abyte0);
        field_35390_x.func_867_a(this, field_907_p, i, j, abyte0);
        if(field_35389_t)
        {
            field_35385_f.func_867_a(this, field_907_p, i, j, abyte0);
            field_35387_e.func_867_a(this, field_907_p, i, j, abyte0);
            field_35386_d.func_867_a(this, field_907_p, i, j, abyte0);
        }
        chunk.func_1024_c();
        return chunk;
    }

    private double[] func_4061_a(double ad[], int i, int j, int k, int l, int i1, int j1)
    {
        if(ad == null)
        {
            ad = new double[l * i1 * j1];
        }
        if(field_35388_l == null)
        {
            field_35388_l = new float[25];
            for(int k1 = -2; k1 <= 2; k1++)
            {
                for(int l1 = -2; l1 <= 2; l1++)
                {
                    float f = 10F / MathHelper.func_1113_c((float)(k1 * k1 + l1 * l1) + 0.2F);
                    field_35388_l[k1 + 2 + (l1 + 2) * 5] = f;
                }

            }

        }
        double d = 684.41200000000003D;
        double d1 = 684.41200000000003D;
        field_4182_g = field_922_a.func_4109_a(field_4182_g, i, k, l, j1, 1.121D, 1.121D, 0.5D);
        field_4181_h = field_921_b.func_4109_a(field_4181_h, i, k, l, j1, 200D, 200D, 0.5D);
        field_4185_d = field_910_m.func_807_a(field_4185_d, i, j, k, l, i1, j1, d / 80D, d1 / 160D, d / 80D);
        field_4184_e = field_912_k.func_807_a(field_4184_e, i, j, k, l, i1, j1, d, d1, d);
        field_4183_f = field_911_l.func_807_a(field_4183_f, i, j, k, l, i1, j1, d, d1, d);
        i = k = 0;
        int i2 = 0;
        int j2 = 0;
        for(int k2 = 0; k2 < l; k2++)
        {
            for(int l2 = 0; l2 < j1; l2++)
            {
                float f1 = 0.0F;
                float f2 = 0.0F;
                float f3 = 0.0F;
                byte byte0 = 2;
                BiomeGenBase biomegenbase = field_4179_v[k2 + 2 + (l2 + 2) * (l + 5)];
                for(int i3 = -byte0; i3 <= byte0; i3++)
                {
                    for(int j3 = -byte0; j3 <= byte0; j3++)
                    {
                        BiomeGenBase biomegenbase1 = field_4179_v[k2 + i3 + 2 + (l2 + j3 + 2) * (l + 5)];
                        float f4 = field_35388_l[i3 + 2 + (j3 + 2) * 5] / (biomegenbase1.field_35492_q + 2.0F);
                        if(biomegenbase1.field_35492_q > biomegenbase.field_35492_q)
                        {
                            f4 /= 2.0F;
                        }
                        f1 += biomegenbase1.field_35491_r * f4;
                        f2 += biomegenbase1.field_35492_q * f4;
                        f3 += f4;
                    }

                }

                f1 /= f3;
                f2 /= f3;
                f1 = f1 * 0.9F + 0.1F;
                f2 = (f2 * 4F - 1.0F) / 8F;
                double d2 = field_4181_h[j2] / 8000D;
                if(d2 < 0.0D)
                {
                    d2 = -d2 * 0.29999999999999999D;
                }
                d2 = d2 * 3D - 2D;
                if(d2 < 0.0D)
                {
                    d2 /= 2D;
                    if(d2 < -1D)
                    {
                        d2 = -1D;
                    }
                    d2 /= 1.3999999999999999D;
                    d2 /= 2D;
                } else
                {
                    if(d2 > 1.0D)
                    {
                        d2 = 1.0D;
                    }
                    d2 /= 8D;
                }
                j2++;
                for(int k3 = 0; k3 < i1; k3++)
                {
                    double d3 = f2;
                    double d4 = f1;
                    d3 += d2 * 0.20000000000000001D;
                    d3 = (d3 * (double)i1) / 16D;
                    double d5 = (double)i1 / 2D + d3 * 4D;
                    double d6 = 0.0D;
                    double d7 = (((double)k3 - d5) * 12D * 128D) / (double)field_907_p.field_35472_c / d4;
                    if(d7 < 0.0D)
                    {
                        d7 *= 4D;
                    }
                    double d8 = field_4184_e[i2] / 512D;
                    double d9 = field_4183_f[i2] / 512D;
                    double d10 = (field_4185_d[i2] / 10D + 1.0D) / 2D;
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
                    if(k3 > i1 - 4)
                    {
                        double d11 = (float)(k3 - (i1 - 4)) / 3F;
                        d6 = d6 * (1.0D - d11) + -10D * d11;
                    }
                    ad[i2] = d6;
                    i2++;
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
        BiomeGenBase biomegenbase = field_907_p.func_4075_a().func_4073_a(k + 16, l + 16);
        field_913_j.setSeed(field_907_p.func_22138_q());
        long l1 = (field_913_j.nextLong() / 2L) * 2L + 1L;
        long l2 = (field_913_j.nextLong() / 2L) * 2L + 1L;
        field_913_j.setSeed((long)i * l1 + (long)j * l2 ^ field_907_p.func_22138_q());
        boolean flag = false;
        if(field_35389_t)
        {
            field_35385_f.func_35629_a(field_907_p, field_913_j, i, j);
            flag = field_35387_e.func_35629_a(field_907_p, field_913_j, i, j);
            field_35386_d.func_35629_a(field_907_p, field_913_j, i, j);
        }
        if(!flag && field_913_j.nextInt(4) == 0)
        {
            int i1 = k + field_913_j.nextInt(16) + 8;
            int j2 = field_913_j.nextInt(field_907_p.field_35472_c);
            int k3 = l + field_913_j.nextInt(16) + 8;
            (new WorldGenLakes(Block.field_399_C.field_376_bc)).func_516_a(field_907_p, field_913_j, i1, j2, k3);
        }
        if(!flag && field_913_j.nextInt(8) == 0)
        {
            int j1 = k + field_913_j.nextInt(16) + 8;
            int k2 = field_913_j.nextInt(field_913_j.nextInt(field_907_p.field_35472_c - 8) + 8);
            int l3 = l + field_913_j.nextInt(16) + 8;
            if(k2 < field_907_p.field_35470_e || field_913_j.nextInt(10) == 0)
            {
                (new WorldGenLakes(Block.field_395_E.field_376_bc)).func_516_a(field_907_p, field_913_j, j1, k2, l3);
            }
        }
        for(int k1 = 0; k1 < 8; k1++)
        {
            int i3 = k + field_913_j.nextInt(16) + 8;
            int i4 = field_913_j.nextInt(field_907_p.field_35472_c);
            int k4 = l + field_913_j.nextInt(16) + 8;
            if(!(new WorldGenDungeons()).func_516_a(field_907_p, field_913_j, i3, i4, k4));
        }

        biomegenbase.func_35477_a(field_907_p, field_913_j, k, l);
        SpawnerAnimals.func_35957_a(field_907_p, biomegenbase, k + 8, l + 8, 16, 16, field_913_j);
        k += 8;
        l += 8;
        for(int i2 = 0; i2 < 16; i2++)
        {
            for(int j3 = 0; j3 < 16; j3++)
            {
                int j4 = field_907_p.func_35461_e(k + i2, l + j3);
                if(field_907_p.func_40471_p(i2 + k, j4 - 1, j3 + l))
                {
                    field_907_p.func_690_d(i2 + k, j4 - 1, j3 + l, Block.field_4063_aU.field_376_bc);
                }
                if(field_907_p.func_40478_r(i2 + k, j4, j3 + l))
                {
                    field_907_p.func_690_d(i2 + k, j4, j3 + l, Block.field_428_aT.field_376_bc);
                }
            }

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
        return "RandomLevelSource";
    }

    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        WorldChunkManager worldchunkmanager = field_907_p.func_4075_a();
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
        if("Stronghold".equals(s) && field_35386_d != null)
        {
            return field_35386_d.func_40484_a(world, i, j, k);
        } else
        {
            return null;
        }
    }
}

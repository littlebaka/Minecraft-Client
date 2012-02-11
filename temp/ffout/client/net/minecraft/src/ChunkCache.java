// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IBlockAccess, World, Chunk, WorldProvider, 
//            EnumSkyBlock, Block, Material, TileEntity, 
//            WorldChunkManager

public class ChunkCache
    implements IBlockAccess
{

    private int field_1060_a;
    private int field_1059_b;
    private Chunk field_1062_c[][];
    private World field_1061_d;

    public ChunkCache(World world, int i, int j, int k, int l, int i1, int j1)
    {
        field_1061_d = world;
        field_1060_a = i >> 4;
        field_1059_b = k >> 4;
        int k1 = l >> 4;
        int l1 = j1 >> 4;
        field_1062_c = new Chunk[(k1 - field_1060_a) + 1][(l1 - field_1059_b) + 1];
        for(int i2 = field_1060_a; i2 <= k1; i2++)
        {
            for(int j2 = field_1059_b; j2 <= l1; j2++)
            {
                field_1062_c[i2 - field_1060_a][j2 - field_1059_b] = world.func_704_b(i2, j2);
            }

        }

    }

    public int func_600_a(int i, int j, int k)
    {
        if(j < 0)
        {
            return 0;
        }
        if(j >= field_1061_d.field_35472_c)
        {
            return 0;
        }
        int l = (i >> 4) - field_1060_a;
        int i1 = (k >> 4) - field_1059_b;
        if(l < 0 || l >= field_1062_c.length || i1 < 0 || i1 >= field_1062_c[l].length)
        {
            return 0;
        }
        Chunk chunk = field_1062_c[l][i1];
        if(chunk == null)
        {
            return 0;
        } else
        {
            return chunk.func_1008_a(i & 0xf, j, k & 0xf);
        }
    }

    public TileEntity func_603_b(int i, int j, int k)
    {
        int l = (i >> 4) - field_1060_a;
        int i1 = (k >> 4) - field_1059_b;
        return field_1062_c[l][i1].func_1002_d(i & 0xf, j, k & 0xf);
    }

    public float func_28099_a(int i, int j, int k, int l)
    {
        int i1 = func_4086_d(i, j, k);
        if(i1 < l)
        {
            i1 = l;
        }
        return field_1061_d.field_4209_q.field_4219_d[i1];
    }

    public int func_35451_b(int i, int j, int k, int l)
    {
        int i1 = func_35454_a(EnumSkyBlock.Sky, i, j, k);
        int j1 = func_35454_a(EnumSkyBlock.Block, i, j, k);
        if(j1 < l)
        {
            j1 = l;
        }
        return i1 << 20 | j1 << 4;
    }

    public float func_598_c(int i, int j, int k)
    {
        return field_1061_d.field_4209_q.field_4219_d[func_4086_d(i, j, k)];
    }

    public int func_4086_d(int i, int j, int k)
    {
        return func_716_a(i, j, k, true);
    }

    public int func_716_a(int i, int j, int k, boolean flag)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k > 0x1c9c380)
        {
            return 15;
        }
        if(flag)
        {
            int l = func_600_a(i, j, k);
            if(l == Block.field_410_al.field_376_bc || l == Block.field_446_aB.field_376_bc || l == Block.field_4059_au.field_376_bc || l == Block.field_4069_aI.field_376_bc)
            {
                int k1 = func_716_a(i, j + 1, k, false);
                int i2 = func_716_a(i + 1, j, k, false);
                int j2 = func_716_a(i - 1, j, k, false);
                int k2 = func_716_a(i, j, k + 1, false);
                int l2 = func_716_a(i, j, k - 1, false);
                if(i2 > k1)
                {
                    k1 = i2;
                }
                if(j2 > k1)
                {
                    k1 = j2;
                }
                if(k2 > k1)
                {
                    k1 = k2;
                }
                if(l2 > k1)
                {
                    k1 = l2;
                }
                return k1;
            }
        }
        if(j < 0)
        {
            return 0;
        }
        if(j >= field_1061_d.field_35472_c)
        {
            int i1 = 15 - field_1061_d.field_1046_e;
            if(i1 < 0)
            {
                i1 = 0;
            }
            return i1;
        } else
        {
            int j1 = (i >> 4) - field_1060_a;
            int l1 = (k >> 4) - field_1059_b;
            return field_1062_c[j1][l1].func_1019_c(i & 0xf, j, k & 0xf, field_1061_d.field_1046_e);
        }
    }

    public int func_602_e(int i, int j, int k)
    {
        if(j < 0)
        {
            return 0;
        }
        if(j >= field_1061_d.field_35472_c)
        {
            return 0;
        } else
        {
            int l = (i >> 4) - field_1060_a;
            int i1 = (k >> 4) - field_1059_b;
            return field_1062_c[l][i1].func_1021_b(i & 0xf, j, k & 0xf);
        }
    }

    public Material func_599_f(int i, int j, int k)
    {
        int l = func_600_a(i, j, k);
        if(l == 0)
        {
            return Material.field_1337_a;
        } else
        {
            return Block.field_345_n[l].field_356_bn;
        }
    }

    public WorldChunkManager func_4075_a()
    {
        return field_1061_d.func_4075_a();
    }

    public boolean func_601_g(int i, int j, int k)
    {
        Block block = Block.field_345_n[func_600_a(i, j, k)];
        if(block == null)
        {
            return false;
        } else
        {
            return block.func_217_b();
        }
    }

    public boolean func_28100_h(int i, int j, int k)
    {
        Block block = Block.field_345_n[func_600_a(i, j, k)];
        if(block == null)
        {
            return false;
        } else
        {
            return block.field_356_bn.func_880_c() && block.func_242_c();
        }
    }

    public boolean func_20084_d(int i, int j, int k)
    {
        Block block = Block.field_345_n[func_600_a(i, j, k)];
        return block == null;
    }

    public int func_35454_a(EnumSkyBlock enumskyblock, int i, int j, int k)
    {
        if(j < 0)
        {
            j = 0;
        }
        if(j >= field_1061_d.field_35472_c)
        {
            j = field_1061_d.field_35472_c - 1;
        }
        if(j < 0 || j >= field_1061_d.field_35472_c || i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k > 0x1c9c380)
        {
            return enumskyblock.field_1722_c;
        }
        if(Block.field_40201_bL[func_600_a(i, j, k)])
        {
            int l = func_35453_b(enumskyblock, i, j + 1, k);
            int j1 = func_35453_b(enumskyblock, i + 1, j, k);
            int l1 = func_35453_b(enumskyblock, i - 1, j, k);
            int i2 = func_35453_b(enumskyblock, i, j, k + 1);
            int j2 = func_35453_b(enumskyblock, i, j, k - 1);
            if(j1 > l)
            {
                l = j1;
            }
            if(l1 > l)
            {
                l = l1;
            }
            if(i2 > l)
            {
                l = i2;
            }
            if(j2 > l)
            {
                l = j2;
            }
            return l;
        } else
        {
            int i1 = (i >> 4) - field_1060_a;
            int k1 = (k >> 4) - field_1059_b;
            return field_1062_c[i1][k1].func_1025_a(enumskyblock, i & 0xf, j, k & 0xf);
        }
    }

    public int func_35453_b(EnumSkyBlock enumskyblock, int i, int j, int k)
    {
        if(j < 0)
        {
            j = 0;
        }
        if(j >= field_1061_d.field_35472_c)
        {
            j = field_1061_d.field_35472_c - 1;
        }
        if(j < 0 || j >= field_1061_d.field_35472_c || i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k > 0x1c9c380)
        {
            return enumskyblock.field_1722_c;
        } else
        {
            int l = (i >> 4) - field_1060_a;
            int i1 = (k >> 4) - field_1059_b;
            return field_1062_c[l][i1].func_1025_a(enumskyblock, i & 0xf, j, k & 0xf);
        }
    }

    public int func_35452_b()
    {
        return field_1061_d.field_35472_c;
    }
}

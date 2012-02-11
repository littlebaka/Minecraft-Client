// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, NibbleArray, Block, WorldProvider, 
//            EnumSkyBlock, BlockContainer, TileEntity, Entity, 
//            MathHelper, ChunkPosition, AxisAlignedBB, ChunkBlockMap, 
//            IChunkProvider, Material, ChunkCoordIntPair

public class Chunk
{

    public static boolean field_1540_a;
    public byte field_1539_b[];
    public int field_35845_c[];
    public boolean field_35844_d[];
    public boolean field_1538_c;
    public World field_1537_d;
    public NibbleArray field_1536_e;
    public NibbleArray field_1535_f;
    public NibbleArray field_1534_g;
    public byte field_1533_h[];
    public int field_1532_i;
    public final int field_1531_j;
    public final int field_1530_k;
    private boolean field_40741_v;
    public Map field_1529_l;
    public List field_1528_m[];
    public boolean field_1527_n;
    public boolean field_1526_o;
    public boolean field_1525_p;
    public boolean field_1523_r;
    public long field_1522_s;
    boolean field_35846_u;

    public Chunk(World world, int i, int j)
    {
        field_35845_c = new int[256];
        field_35844_d = new boolean[256];
        field_40741_v = false;
        field_1529_l = new HashMap();
        field_1527_n = false;
        field_1526_o = false;
        field_1523_r = false;
        field_1522_s = 0L;
        field_35846_u = false;
        field_1528_m = new List[world.field_35472_c / 16];
        field_1537_d = world;
        field_1531_j = i;
        field_1530_k = j;
        field_1533_h = new byte[256];
        for(int k = 0; k < field_1528_m.length; k++)
        {
            field_1528_m[k] = new ArrayList();
        }

        Arrays.fill(field_35845_c, -999);
    }

    public Chunk(World world, byte abyte0[], int i, int j)
    {
        this(world, i, j);
        field_1539_b = abyte0;
        field_1536_e = new NibbleArray(abyte0.length, world.field_35473_a);
        field_1535_f = new NibbleArray(abyte0.length, world.field_35473_a);
        field_1534_g = new NibbleArray(abyte0.length, world.field_35473_a);
    }

    public boolean func_1017_a(int i, int j)
    {
        return i == field_1531_j && j == field_1530_k;
    }

    public int func_999_b(int i, int j)
    {
        return field_1533_h[j << 4 | i] & 0xff;
    }

    public void func_1014_a()
    {
    }

    public void func_1018_b()
    {
        int i = field_1537_d.field_35472_c - 1;
        for(int j = 0; j < 16; j++)
        {
            for(int k = 0; k < 16; k++)
            {
                field_35845_c[j + (k << 4)] = -999;
                int l = field_1537_d.field_35472_c - 1;
                for(int i1 = j << field_1537_d.field_35471_b | k << field_1537_d.field_35473_a; l > 0 && Block.field_341_r[field_1539_b[(i1 + l) - 1] & 0xff] == 0; l--) { }
                field_1533_h[k << 4 | j] = (byte)l;
                if(l < i)
                {
                    i = l;
                }
            }

        }

        field_1532_i = i;
        field_1526_o = true;
    }

    public void func_1024_c()
    {
        int i = field_1537_d.field_35472_c - 1;
        for(int j = 0; j < 16; j++)
        {
            for(int l = 0; l < 16; l++)
            {
                int j1 = field_1537_d.field_35472_c - 1;
                int k1;
                for(k1 = j << field_1537_d.field_35471_b | l << field_1537_d.field_35473_a; j1 > 0 && Block.field_341_r[field_1539_b[(k1 + j1) - 1] & 0xff] == 0; j1--) { }
                field_1533_h[l << 4 | j] = (byte)j1;
                if(j1 < i)
                {
                    i = j1;
                }
                if(field_1537_d.field_4209_q.field_6478_e)
                {
                    continue;
                }
                int l1 = 15;
                int i2 = field_1537_d.field_35472_c - 1;
                do
                {
                    l1 -= Block.field_341_r[field_1539_b[k1 + i2] & 0xff];
                    if(l1 > 0)
                    {
                        field_1535_f.func_770_a(j, i2, l, l1);
                    }
                } while(--i2 > 0 && l1 > 0);
            }

        }

        field_1532_i = i;
        for(int k = 0; k < 16; k++)
        {
            for(int i1 = 0; i1 < 16; i1++)
            {
                func_996_c(k, i1);
            }

        }

        field_1526_o = true;
    }

    public void func_4143_d()
    {
    }

    private void func_996_c(int i, int j)
    {
        field_35844_d[i + j * 16] = true;
        field_40741_v = true;
    }

    private void func_35839_k()
    {
        if(field_1537_d.func_21117_a(field_1531_j * 16 + 8, field_1537_d.field_35472_c / 2, field_1530_k * 16 + 8, 16))
        {
            for(int i = 0; i < 16; i++)
            {
                for(int j = 0; j < 16; j++)
                {
                    if(!field_35844_d[i + j * 16])
                    {
                        continue;
                    }
                    field_35844_d[i + j * 16] = false;
                    int k = func_999_b(i, j);
                    int l = field_1531_j * 16 + i;
                    int i1 = field_1530_k * 16 + j;
                    int j1 = field_1537_d.func_666_c(l - 1, i1);
                    int k1 = field_1537_d.func_666_c(l + 1, i1);
                    int l1 = field_1537_d.func_666_c(l, i1 - 1);
                    int i2 = field_1537_d.func_666_c(l, i1 + 1);
                    if(k1 < j1)
                    {
                        j1 = k1;
                    }
                    if(l1 < j1)
                    {
                        j1 = l1;
                    }
                    if(i2 < j1)
                    {
                        j1 = i2;
                    }
                    func_1020_f(l, i1, j1);
                    func_1020_f(l - 1, i1, k);
                    func_1020_f(l + 1, i1, k);
                    func_1020_f(l, i1 - 1, k);
                    func_1020_f(l, i1 + 1, k);
                    field_40741_v = false;
                }

            }

        }
    }

    private void func_1020_f(int i, int j, int k)
    {
        int l = field_1537_d.func_666_c(i, j);
        if(l > k)
        {
            func_35842_d(i, j, k, l + 1);
        } else
        if(l < k)
        {
            func_35842_d(i, j, l, k + 1);
        }
    }

    private void func_35842_d(int i, int j, int k, int l)
    {
        if(l > k && field_1537_d.func_21117_a(i, field_1537_d.field_35472_c / 2, j, 16))
        {
            for(int i1 = k; i1 < l; i1++)
            {
                field_1537_d.func_35459_c(EnumSkyBlock.Sky, i, i1, j);
            }

            field_1526_o = true;
        }
    }

    private void func_1003_g(int i, int j, int k)
    {
        int l = field_1533_h[k << 4 | i] & 0xff;
        int i1 = l;
        if(j > l)
        {
            i1 = j;
        }
        for(int j1 = i << field_1537_d.field_35471_b | k << field_1537_d.field_35473_a; i1 > 0 && Block.field_341_r[field_1539_b[(j1 + i1) - 1] & 0xff] == 0; i1--) { }
        if(i1 == l)
        {
            return;
        }
        field_1537_d.func_680_f(i, k, i1, l);
        field_1533_h[k << 4 | i] = (byte)i1;
        if(i1 < field_1532_i)
        {
            field_1532_i = i1;
        } else
        {
            int k1 = field_1537_d.field_35472_c - 1;
            for(int i2 = 0; i2 < 16; i2++)
            {
                for(int k2 = 0; k2 < 16; k2++)
                {
                    if((field_1533_h[k2 << 4 | i2] & 0xff) < k1)
                    {
                        k1 = field_1533_h[k2 << 4 | i2] & 0xff;
                    }
                }

            }

            field_1532_i = k1;
        }
        int l1 = field_1531_j * 16 + i;
        int j2 = field_1530_k * 16 + k;
        if(!field_1537_d.field_4209_q.field_6478_e)
        {
            if(i1 < l)
            {
                for(int l2 = i1; l2 < l; l2++)
                {
                    field_1535_f.func_770_a(i, l2, k, 15);
                }

            } else
            {
                for(int i3 = l; i3 < i1; i3++)
                {
                    field_1535_f.func_770_a(i, i3, k, 0);
                }

            }
            for(int j3 = 15; i1 > 0 && j3 > 0;)
            {
                i1--;
                int k3 = Block.field_341_r[func_1008_a(i, i1, k)];
                if(k3 == 0)
                {
                    k3 = 1;
                }
                j3 -= k3;
                if(j3 < 0)
                {
                    j3 = 0;
                }
                field_1535_f.func_770_a(i, i1, k, j3);
            }

        }
        byte byte0 = field_1533_h[k << 4 | i];
        int l3 = l;
        int i4 = byte0;
        if(i4 < l3)
        {
            int j4 = l3;
            l3 = i4;
            i4 = j4;
        }
        if(!field_1537_d.field_4209_q.field_6478_e)
        {
            func_35842_d(l1 - 1, j2, l3, i4);
            func_35842_d(l1 + 1, j2, l3, i4);
            func_35842_d(l1, j2 - 1, l3, i4);
            func_35842_d(l1, j2 + 1, l3, i4);
            func_35842_d(l1, j2, l3, i4);
        }
        field_1526_o = true;
    }

    public int func_1008_a(int i, int j, int k)
    {
        return field_1539_b[i << field_1537_d.field_35471_b | k << field_1537_d.field_35473_a | j] & 0xff;
    }

    public boolean func_1010_a(int i, int j, int k, int l, int i1)
    {
        byte byte0 = (byte)l;
        int j1 = k << 4 | i;
        if(j >= field_35845_c[j1] - 1)
        {
            field_35845_c[j1] = -999;
        }
        int k1 = field_1533_h[k << 4 | i] & 0xff;
        int l1 = field_1539_b[i << field_1537_d.field_35471_b | k << field_1537_d.field_35473_a | j] & 0xff;
        if(l1 == l && field_1536_e.func_771_a(i, j, k) == i1)
        {
            return false;
        }
        int i2 = field_1531_j * 16 + i;
        int j2 = field_1530_k * 16 + k;
        field_1539_b[i << field_1537_d.field_35471_b | k << field_1537_d.field_35473_a | j] = (byte)(byte0 & 0xff);
        if(l1 != 0)
        {
            if(!field_1537_d.field_1026_y)
            {
                Block.field_345_n[l1].func_214_b(field_1537_d, i2, j, j2);
            } else
            if((Block.field_345_n[l1] instanceof BlockContainer) && l1 != l)
            {
                field_1537_d.func_692_l(i2, j, j2);
            }
        }
        field_1536_e.func_770_a(i, j, k, i1);
        if(!field_1537_d.field_4209_q.field_6478_e)
        {
            if(Block.field_341_r[byte0 & 0xff] != 0)
            {
                if(j >= k1)
                {
                    func_1003_g(i, j + 1, k);
                }
            } else
            if(j == k1 - 1)
            {
                func_1003_g(i, j, k);
            }
            field_1537_d.func_616_a(EnumSkyBlock.Sky, i2, j, j2, i2, j, j2);
        }
        field_1537_d.func_616_a(EnumSkyBlock.Block, i2, j, j2, i2, j, j2);
        func_996_c(i, k);
        field_1536_e.func_770_a(i, j, k, i1);
        if(l != 0)
        {
            if(!field_1537_d.field_1026_y)
            {
                Block.field_345_n[l].func_235_e(field_1537_d, i2, j, j2);
            }
            if(Block.field_345_n[l] instanceof BlockContainer)
            {
                TileEntity tileentity = func_1002_d(i, j, k);
                if(tileentity == null)
                {
                    tileentity = ((BlockContainer)Block.field_345_n[l]).func_283_a_();
                    field_1537_d.func_654_a(i2, j, j2, tileentity);
                }
                if(tileentity != null)
                {
                    tileentity.func_35144_b();
                }
            }
        } else
        if(l1 > 0 && (Block.field_345_n[l1] instanceof BlockContainer))
        {
            TileEntity tileentity1 = func_1002_d(i, j, k);
            if(tileentity1 != null)
            {
                tileentity1.func_35144_b();
            }
        }
        field_1526_o = true;
        return true;
    }

    public boolean func_1022_a(int i, int j, int k, int l)
    {
        byte byte0 = (byte)l;
        int i1 = k << 4 | i;
        if(j >= field_35845_c[i1] - 1)
        {
            field_35845_c[i1] = -999;
        }
        int j1 = field_1533_h[i1] & 0xff;
        int k1 = field_1539_b[i << field_1537_d.field_35471_b | k << field_1537_d.field_35473_a | j] & 0xff;
        if(k1 == l)
        {
            return false;
        }
        int l1 = field_1531_j * 16 + i;
        int i2 = field_1530_k * 16 + k;
        field_1539_b[i << field_1537_d.field_35471_b | k << field_1537_d.field_35473_a | j] = (byte)(byte0 & 0xff);
        if(k1 != 0)
        {
            Block.field_345_n[k1].func_214_b(field_1537_d, l1, j, i2);
        }
        field_1536_e.func_770_a(i, j, k, 0);
        if(Block.field_341_r[byte0 & 0xff] != 0)
        {
            if(j >= j1)
            {
                func_1003_g(i, j + 1, k);
            }
        } else
        if(j == j1 - 1)
        {
            func_1003_g(i, j, k);
        }
        field_1537_d.func_616_a(EnumSkyBlock.Sky, l1, j, i2, l1, j, i2);
        field_1537_d.func_616_a(EnumSkyBlock.Block, l1, j, i2, l1, j, i2);
        func_996_c(i, k);
        if(l != 0)
        {
            if(!field_1537_d.field_1026_y)
            {
                Block.field_345_n[l].func_235_e(field_1537_d, l1, j, i2);
            }
            if(l > 0 && (Block.field_345_n[l] instanceof BlockContainer))
            {
                TileEntity tileentity = func_1002_d(i, j, k);
                if(tileentity == null)
                {
                    tileentity = ((BlockContainer)Block.field_345_n[l]).func_283_a_();
                    field_1537_d.func_654_a(l1, j, i2, tileentity);
                }
                if(tileentity != null)
                {
                    tileentity.func_35144_b();
                }
            }
        } else
        if(k1 > 0 && (Block.field_345_n[k1] instanceof BlockContainer))
        {
            TileEntity tileentity1 = func_1002_d(i, j, k);
            if(tileentity1 != null)
            {
                tileentity1.func_35144_b();
            }
        }
        field_1526_o = true;
        return true;
    }

    public int func_1021_b(int i, int j, int k)
    {
        return field_1536_e.func_771_a(i, j, k);
    }

    public boolean func_1009_b(int i, int j, int k, int l)
    {
        field_1526_o = true;
        int i1 = field_1536_e.func_771_a(i, j, k);
        if(i1 == l)
        {
            return false;
        }
        field_1536_e.func_770_a(i, j, k, l);
        int j1 = func_1008_a(i, j, k);
        if(j1 > 0 && (Block.field_345_n[j1] instanceof BlockContainer))
        {
            TileEntity tileentity = func_1002_d(i, j, k);
            if(tileentity != null)
            {
                tileentity.func_35144_b();
                tileentity.field_35145_n = l;
            }
        }
        return true;
    }

    public int func_1025_a(EnumSkyBlock enumskyblock, int i, int j, int k)
    {
        if(enumskyblock == EnumSkyBlock.Sky)
        {
            return field_1535_f.func_771_a(i, j, k);
        }
        if(enumskyblock == EnumSkyBlock.Block)
        {
            return field_1534_g.func_771_a(i, j, k);
        } else
        {
            return 0;
        }
    }

    public void func_1011_a(EnumSkyBlock enumskyblock, int i, int j, int k, int l)
    {
        field_1526_o = true;
        if(enumskyblock == EnumSkyBlock.Sky)
        {
            if(!field_1537_d.field_4209_q.field_6478_e)
            {
                field_1535_f.func_770_a(i, j, k, l);
            }
        } else
        if(enumskyblock == EnumSkyBlock.Block)
        {
            field_1534_g.func_770_a(i, j, k, l);
        } else
        {
            return;
        }
    }

    public int func_1019_c(int i, int j, int k, int l)
    {
        int i1 = field_1537_d.field_4209_q.field_6478_e ? 0 : field_1535_f.func_771_a(i, j, k);
        if(i1 > 0)
        {
            field_1540_a = true;
        }
        i1 -= l;
        int j1 = field_1534_g.func_771_a(i, j, k);
        if(j1 > i1)
        {
            i1 = j1;
        }
        return i1;
    }

    public void func_1000_a(Entity entity)
    {
        field_1523_r = true;
        int i = MathHelper.func_1108_b(entity.field_611_ak / 16D);
        int j = MathHelper.func_1108_b(entity.field_609_am / 16D);
        if(i != field_1531_j || j != field_1530_k)
        {
            System.out.println((new StringBuilder()).append("Wrong location! ").append(entity).toString());
            Thread.dumpStack();
        }
        int k = MathHelper.func_1108_b(entity.field_610_al / 16D);
        if(k < 0)
        {
            k = 0;
        }
        if(k >= field_1528_m.length)
        {
            k = field_1528_m.length - 1;
        }
        entity.field_621_aZ = true;
        entity.field_657_ba = field_1531_j;
        entity.field_656_bb = k;
        entity.field_654_bc = field_1530_k;
        field_1528_m[k].add(entity);
    }

    public void func_1015_b(Entity entity)
    {
        func_1016_a(entity, entity.field_656_bb);
    }

    public void func_1016_a(Entity entity, int i)
    {
        if(i < 0)
        {
            i = 0;
        }
        if(i >= field_1528_m.length)
        {
            i = field_1528_m.length - 1;
        }
        field_1528_m[i].remove(entity);
    }

    public boolean func_1007_c(int i, int j, int k)
    {
        return j >= (field_1533_h[k << 4 | i] & 0xff);
    }

    public TileEntity func_1002_d(int i, int j, int k)
    {
        ChunkPosition chunkposition = new ChunkPosition(i, j, k);
        TileEntity tileentity = (TileEntity)field_1529_l.get(chunkposition);
        if(tileentity == null)
        {
            int l = func_1008_a(i, j, k);
            if(!Block.field_342_q[l])
            {
                return null;
            }
            if(tileentity == null)
            {
                tileentity = ((BlockContainer)Block.field_345_n[l]).func_283_a_();
                field_1537_d.func_654_a(field_1531_j * 16 + i, j, field_1530_k * 16 + k, tileentity);
            }
            tileentity = (TileEntity)field_1529_l.get(chunkposition);
        }
        if(tileentity != null && tileentity.func_31006_g())
        {
            field_1529_l.remove(chunkposition);
            return null;
        } else
        {
            return tileentity;
        }
    }

    public void func_1001_a(TileEntity tileentity)
    {
        int i = tileentity.field_823_f - field_1531_j * 16;
        int j = tileentity.field_822_g;
        int k = tileentity.field_821_h - field_1530_k * 16;
        func_1005_a(i, j, k, tileentity);
        if(field_1538_c)
        {
            field_1537_d.field_1049_b.add(tileentity);
        }
    }

    public void func_1005_a(int i, int j, int k, TileEntity tileentity)
    {
        ChunkPosition chunkposition = new ChunkPosition(i, j, k);
        tileentity.field_824_e = field_1537_d;
        tileentity.field_823_f = field_1531_j * 16 + i;
        tileentity.field_822_g = j;
        tileentity.field_821_h = field_1530_k * 16 + k;
        if(func_1008_a(i, j, k) == 0 || !(Block.field_345_n[func_1008_a(i, j, k)] instanceof BlockContainer))
        {
            return;
        } else
        {
            tileentity.func_31004_j();
            field_1529_l.put(chunkposition, tileentity);
            return;
        }
    }

    public void func_1023_e(int i, int j, int k)
    {
        ChunkPosition chunkposition = new ChunkPosition(i, j, k);
        if(field_1538_c)
        {
            TileEntity tileentity = (TileEntity)field_1529_l.remove(chunkposition);
            if(tileentity != null)
            {
                tileentity.func_31005_i();
            }
        }
    }

    public void func_995_d()
    {
        field_1538_c = true;
        field_1537_d.func_31054_a(field_1529_l.values());
        for(int i = 0; i < field_1528_m.length; i++)
        {
            field_1537_d.func_636_a(field_1528_m[i]);
        }

    }

    public void func_998_e()
    {
        field_1538_c = false;
        TileEntity tileentity;
        for(Iterator iterator = field_1529_l.values().iterator(); iterator.hasNext(); field_1537_d.func_35455_a(tileentity))
        {
            tileentity = (TileEntity)iterator.next();
        }

        for(int i = 0; i < field_1528_m.length; i++)
        {
            field_1537_d.func_632_b(field_1528_m[i]);
        }

    }

    public void func_1006_f()
    {
        field_1526_o = true;
    }

    public void func_994_a(Entity entity, AxisAlignedBB axisalignedbb, List list)
    {
        int i = MathHelper.func_1108_b((axisalignedbb.field_1697_b - 2D) / 16D);
        int j = MathHelper.func_1108_b((axisalignedbb.field_1702_e + 2D) / 16D);
        if(i < 0)
        {
            i = 0;
        }
        if(j >= field_1528_m.length)
        {
            j = field_1528_m.length - 1;
        }
        for(int k = i; k <= j; k++)
        {
            List list1 = field_1528_m[k];
            for(int l = 0; l < list1.size(); l++)
            {
                Entity entity1 = (Entity)list1.get(l);
                if(entity1 == entity || !entity1.field_601_au.func_1178_a(axisalignedbb))
                {
                    continue;
                }
                list.add(entity1);
                Entity aentity[] = entity1.func_40048_X();
                if(aentity == null)
                {
                    continue;
                }
                for(int i1 = 0; i1 < aentity.length; i1++)
                {
                    Entity entity2 = aentity[i1];
                    if(entity2 != entity && entity2.field_601_au.func_1178_a(axisalignedbb))
                    {
                        list.add(entity2);
                    }
                }

            }

        }

    }

    public void func_1013_a(Class class1, AxisAlignedBB axisalignedbb, List list)
    {
        int i = MathHelper.func_1108_b((axisalignedbb.field_1697_b - 2D) / 16D);
        int j = MathHelper.func_1108_b((axisalignedbb.field_1702_e + 2D) / 16D);
        if(i < 0)
        {
            i = 0;
        } else
        if(i >= field_1528_m.length)
        {
            i = field_1528_m.length - 1;
        }
        if(j >= field_1528_m.length)
        {
            j = field_1528_m.length - 1;
        } else
        if(j < 0)
        {
            j = 0;
        }
        for(int k = i; k <= j; k++)
        {
            List list1 = field_1528_m[k];
            for(int l = 0; l < list1.size(); l++)
            {
                Entity entity = (Entity)list1.get(l);
                if(class1.isAssignableFrom(entity.getClass()) && entity.field_601_au.func_1178_a(axisalignedbb))
                {
                    list.add(entity);
                }
            }

        }

    }

    public boolean func_1012_a(boolean flag)
    {
        if(field_1525_p)
        {
            return false;
        }
        if(flag)
        {
            if(field_1523_r && field_1537_d.func_22139_r() != field_1522_s)
            {
                return true;
            }
        } else
        if(field_1523_r && field_1537_d.func_22139_r() >= field_1522_s + 600L)
        {
            return true;
        }
        return field_1526_o;
    }

    public int func_1004_a(byte abyte0[], int i, int j, int k, int l, int i1, int j1, 
            int k1)
    {
        for(int l1 = i; l1 < l; l1++)
        {
            for(int l2 = k; l2 < j1; l2++)
            {
                int l3 = l1 << field_1537_d.field_35471_b | l2 << field_1537_d.field_35473_a | j;
                int l4 = i1 - j;
                System.arraycopy(abyte0, k1, field_1539_b, l3, l4);
                k1 += l4;
            }

        }

        func_1018_b();
        for(int i2 = i; i2 < l; i2++)
        {
            for(int i3 = k; i3 < j1; i3++)
            {
                int i4 = (i2 << field_1537_d.field_35471_b | i3 << field_1537_d.field_35473_a | j) >> 1;
                int i5 = (i1 - j) / 2;
                System.arraycopy(abyte0, k1, field_1536_e.field_1109_a, i4, i5);
                k1 += i5;
            }

        }

        for(int j2 = i; j2 < l; j2++)
        {
            for(int j3 = k; j3 < j1; j3++)
            {
                int j4 = (j2 << field_1537_d.field_35471_b | j3 << field_1537_d.field_35473_a | j) >> 1;
                int j5 = (i1 - j) / 2;
                System.arraycopy(abyte0, k1, field_1534_g.field_1109_a, j4, j5);
                k1 += j5;
            }

        }

        for(int k2 = i; k2 < l; k2++)
        {
            for(int k3 = k; k3 < j1; k3++)
            {
                int k4 = (k2 << field_1537_d.field_35471_b | k3 << field_1537_d.field_35473_a | j) >> 1;
                int k5 = (i1 - j) / 2;
                System.arraycopy(abyte0, k1, field_1535_f.field_1109_a, k4, k5);
                k1 += k5;
            }

        }

        TileEntity tileentity;
        for(Iterator iterator = field_1529_l.values().iterator(); iterator.hasNext(); tileentity.func_35144_b())
        {
            tileentity = (TileEntity)iterator.next();
        }

        return k1;
    }

    public Random func_997_a(long l)
    {
        return new Random(field_1537_d.func_22138_q() + (long)(field_1531_j * field_1531_j * 0x4c1906) + (long)(field_1531_j * 0x5ac0db) + (long)(field_1530_k * field_1530_k) * 0x4307a7L + (long)(field_1530_k * 0x5f24f) ^ l);
    }

    public boolean func_21167_h()
    {
        return false;
    }

    public void func_25124_i()
    {
        ChunkBlockMap.func_26002_a(field_1539_b);
    }

    public void func_35843_a(IChunkProvider ichunkprovider, IChunkProvider ichunkprovider1, int i, int j)
    {
        if(!field_1527_n && ichunkprovider.func_537_a(i + 1, j + 1) && ichunkprovider.func_537_a(i, j + 1) && ichunkprovider.func_537_a(i + 1, j))
        {
            ichunkprovider.func_534_a(ichunkprovider1, i, j);
        }
        if(ichunkprovider.func_537_a(i - 1, j) && !ichunkprovider.func_533_b(i - 1, j).field_1527_n && ichunkprovider.func_537_a(i - 1, j + 1) && ichunkprovider.func_537_a(i, j + 1) && ichunkprovider.func_537_a(i - 1, j + 1))
        {
            ichunkprovider.func_534_a(ichunkprovider1, i - 1, j);
        }
        if(ichunkprovider.func_537_a(i, j - 1) && !ichunkprovider.func_533_b(i, j - 1).field_1527_n && ichunkprovider.func_537_a(i + 1, j - 1) && ichunkprovider.func_537_a(i + 1, j - 1) && ichunkprovider.func_537_a(i + 1, j))
        {
            ichunkprovider.func_534_a(ichunkprovider1, i, j - 1);
        }
        if(ichunkprovider.func_537_a(i - 1, j - 1) && !ichunkprovider.func_533_b(i - 1, j - 1).field_1527_n && ichunkprovider.func_537_a(i, j - 1) && ichunkprovider.func_537_a(i - 1, j))
        {
            ichunkprovider.func_534_a(ichunkprovider1, i - 1, j - 1);
        }
    }

    public int func_35840_c(int i, int j)
    {
        int k = i | j << 4;
        int l = field_35845_c[k];
        if(l == -999)
        {
            int i1 = field_1537_d.field_35472_c - 1;
            for(l = -1; i1 > 0 && l == -1;)
            {
                int j1 = func_1008_a(i, i1, j);
                Material material = j1 != 0 ? Block.field_345_n[j1].field_356_bn : Material.field_1337_a;
                if(!material.func_880_c() && !material.func_879_d())
                {
                    i1--;
                } else
                {
                    l = i1 + 1;
                }
            }

            field_35845_c[k] = l;
        }
        return l;
    }

    public void func_35841_j()
    {
        if(field_40741_v && !field_1537_d.field_4209_q.field_6478_e)
        {
            func_35839_k();
        }
    }

    public ChunkCoordIntPair func_40740_k()
    {
        return new ChunkCoordIntPair(field_1531_j, field_1530_k);
    }
}

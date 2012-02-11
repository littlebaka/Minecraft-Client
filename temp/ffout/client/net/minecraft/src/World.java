// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IBlockAccess, WorldProvider, WorldInfo, MapStorage, 
//            ISaveHandler, ChunkProvider, WorldChunkManager, ChunkPosition, 
//            EntityPlayer, ChunkProviderLoadOrGenerate, MathHelper, IChunkProvider, 
//            IProgressUpdate, Chunk, Material, Block, 
//            IWorldAccess, EnumSkyBlock, Vec3D, Entity, 
//            AxisAlignedBB, BiomeGenBase, NextTickListEntry, Profiler, 
//            TileEntity, BlockFire, BlockFluid, Explosion, 
//            ThreadedFileIOBase, SpawnerAnimals, ChunkCoordIntPair, EntityLightningBolt, 
//            ChunkCache, PathFinder, PlayerCapabilities, ChunkCoordinates, 
//            WeightedRandom, SpawnListEntry, EnumWorldType, WorldSettings, 
//            MovingObjectPosition, PathEntity, WorldSavedData, EnumCreatureType

public class World
    implements IBlockAccess
{

    public int field_35473_a;
    public int field_35471_b;
    public int field_35472_c;
    public int field_35469_d;
    public int field_35470_e;
    public boolean field_4214_a;
    public List field_1050_a;
    private List field_1024_A;
    private TreeSet field_1058_B;
    private Set field_1056_C;
    public List field_1049_b;
    private List field_30900_E;
    private List field_34900_Q;
    public List field_1040_k;
    public List field_27173_e;
    private long field_1019_F;
    public int field_1046_e;
    protected int field_9437_g;
    protected final int field_9436_h = 0x3c6ef35f;
    protected float field_26901_B;
    protected float field_27171_C;
    protected float field_27170_D;
    protected float field_27169_E;
    protected int field_27168_F;
    public int field_27172_i;
    public boolean field_1043_h;
    private long field_1054_E;
    protected int field_9435_j;
    public int field_1039_l;
    public Random field_1037_n;
    public boolean field_1033_r;
    public final WorldProvider field_4209_q;
    protected List field_9434_r;
    protected IChunkProvider field_1017_H;
    protected final ISaveHandler field_22147_p;
    protected WorldInfo field_22145_q;
    public boolean field_9430_x;
    private boolean field_22146_A;
    public MapStorage field_28108_z;
    private ArrayList field_9428_I;
    private boolean field_31055_L;
    protected boolean field_21121_K;
    protected boolean field_21120_L;
    private Set field_9427_K;
    private int field_9426_L;
    int field_35466_H[];
    private List field_1012_M;
    public boolean field_1026_y;

    public WorldChunkManager func_4075_a()
    {
        return field_4209_q.field_4215_b;
    }

    public World(ISaveHandler isavehandler, String s, WorldProvider worldprovider, WorldSettings worldsettings)
    {
        field_35473_a = 7;
        field_35471_b = field_35473_a + 4;
        field_35472_c = 1 << field_35473_a;
        field_35469_d = field_35472_c - 1;
        field_35470_e = field_35472_c / 2 - 1;
        field_4214_a = false;
        field_1050_a = new ArrayList();
        field_1024_A = new ArrayList();
        field_1058_B = new TreeSet();
        field_1056_C = new HashSet();
        field_1049_b = new ArrayList();
        field_30900_E = new ArrayList();
        field_34900_Q = new ArrayList();
        field_1040_k = new ArrayList();
        field_27173_e = new ArrayList();
        field_1019_F = 0xffffffL;
        field_1046_e = 0;
        field_9437_g = (new Random()).nextInt();
        field_27168_F = 0;
        field_27172_i = 0;
        field_1043_h = false;
        field_1054_E = System.currentTimeMillis();
        field_9435_j = 40;
        field_1037_n = new Random();
        field_1033_r = false;
        field_9434_r = new ArrayList();
        field_9428_I = new ArrayList();
        field_21121_K = true;
        field_21120_L = true;
        field_9427_K = new HashSet();
        field_9426_L = field_1037_n.nextInt(12000);
        field_35466_H = new int[32768];
        field_1012_M = new ArrayList();
        field_1026_y = false;
        field_22147_p = isavehandler;
        field_22145_q = new WorldInfo(worldsettings, s);
        field_4209_q = worldprovider;
        field_28108_z = new MapStorage(isavehandler);
        worldprovider.func_4095_a(this);
        field_1017_H = func_4081_a();
        func_644_f();
        func_27163_E();
    }

    public World(World world, WorldProvider worldprovider)
    {
        field_35473_a = 7;
        field_35471_b = field_35473_a + 4;
        field_35472_c = 1 << field_35473_a;
        field_35469_d = field_35472_c - 1;
        field_35470_e = field_35472_c / 2 - 1;
        field_4214_a = false;
        field_1050_a = new ArrayList();
        field_1024_A = new ArrayList();
        field_1058_B = new TreeSet();
        field_1056_C = new HashSet();
        field_1049_b = new ArrayList();
        field_30900_E = new ArrayList();
        field_34900_Q = new ArrayList();
        field_1040_k = new ArrayList();
        field_27173_e = new ArrayList();
        field_1019_F = 0xffffffL;
        field_1046_e = 0;
        field_9437_g = (new Random()).nextInt();
        field_27168_F = 0;
        field_27172_i = 0;
        field_1043_h = false;
        field_1054_E = System.currentTimeMillis();
        field_9435_j = 40;
        field_1037_n = new Random();
        field_1033_r = false;
        field_9434_r = new ArrayList();
        field_9428_I = new ArrayList();
        field_21121_K = true;
        field_21120_L = true;
        field_9427_K = new HashSet();
        field_9426_L = field_1037_n.nextInt(12000);
        field_35466_H = new int[32768];
        field_1012_M = new ArrayList();
        field_1026_y = false;
        field_1054_E = world.field_1054_E;
        field_22147_p = world.field_22147_p;
        field_22145_q = new WorldInfo(world.field_22145_q);
        field_28108_z = new MapStorage(field_22147_p);
        field_4209_q = worldprovider;
        worldprovider.func_4095_a(this);
        field_1017_H = func_4081_a();
        func_644_f();
        func_27163_E();
    }

    public World(ISaveHandler isavehandler, String s, WorldSettings worldsettings)
    {
        this(isavehandler, s, worldsettings, ((WorldProvider) (null)));
    }

    public World(ISaveHandler isavehandler, String s, WorldSettings worldsettings, WorldProvider worldprovider)
    {
        field_35473_a = 7;
        field_35471_b = field_35473_a + 4;
        field_35472_c = 1 << field_35473_a;
        field_35469_d = field_35472_c - 1;
        field_35470_e = field_35472_c / 2 - 1;
        field_4214_a = false;
        field_1050_a = new ArrayList();
        field_1024_A = new ArrayList();
        field_1058_B = new TreeSet();
        field_1056_C = new HashSet();
        field_1049_b = new ArrayList();
        field_30900_E = new ArrayList();
        field_34900_Q = new ArrayList();
        field_1040_k = new ArrayList();
        field_27173_e = new ArrayList();
        field_1019_F = 0xffffffL;
        field_1046_e = 0;
        field_9437_g = (new Random()).nextInt();
        field_27168_F = 0;
        field_27172_i = 0;
        field_1043_h = false;
        field_1054_E = System.currentTimeMillis();
        field_9435_j = 40;
        field_1037_n = new Random();
        field_1033_r = false;
        field_9434_r = new ArrayList();
        field_9428_I = new ArrayList();
        field_21121_K = true;
        field_21120_L = true;
        field_9427_K = new HashSet();
        field_9426_L = field_1037_n.nextInt(12000);
        field_35466_H = new int[32768];
        field_1012_M = new ArrayList();
        field_1026_y = false;
        field_22147_p = isavehandler;
        field_28108_z = new MapStorage(isavehandler);
        field_22145_q = isavehandler.func_22151_c();
        field_1033_r = field_22145_q == null;
        if(worldprovider != null)
        {
            field_4209_q = worldprovider;
        } else
        if(field_22145_q != null && field_22145_q.func_22290_i() != 0)
        {
            field_4209_q = WorldProvider.func_4101_a(field_22145_q.func_22290_i());
        } else
        {
            field_4209_q = WorldProvider.func_4101_a(0);
        }
        boolean flag = false;
        if(field_22145_q == null)
        {
            field_22145_q = new WorldInfo(worldsettings, s);
            flag = true;
        } else
        {
            field_22145_q.func_22287_a(s);
        }
        field_4209_q.func_4095_a(this);
        field_1017_H = func_4081_a();
        if(flag)
        {
            func_25098_c();
        }
        func_644_f();
        func_27163_E();
    }

    protected IChunkProvider func_4081_a()
    {
        IChunkLoader ichunkloader = field_22147_p.func_22149_a(field_4209_q);
        return new ChunkProvider(this, ichunkloader, field_4209_q.func_4094_c());
    }

    protected void func_25098_c()
    {
        if(!field_4209_q.func_6477_d())
        {
            field_22145_q.func_22292_a(0, field_4209_q.func_46066_g(), 0);
            return;
        }
        field_9430_x = true;
        WorldChunkManager worldchunkmanager = func_4075_a();
        List list = worldchunkmanager.func_35559_a();
        Random random = new Random(func_22138_q());
        ChunkPosition chunkposition = worldchunkmanager.func_35556_a(0, 0, 256, list, random);
        int i = 0;
        int j = field_4209_q.func_46066_g();
        int k = 0;
        if(chunkposition != null)
        {
            i = chunkposition.field_1111_a;
            k = chunkposition.field_1112_c;
        } else
        {
            System.out.println("Unable to find spawn biome");
        }
        int l = 0;
        do
        {
            if(field_4209_q.func_4102_a(i, k))
            {
                break;
            }
            i += random.nextInt(64) - random.nextInt(64);
            k += random.nextInt(64) - random.nextInt(64);
        } while(++l != 1000);
        field_22145_q.func_22292_a(i, j, k);
        field_9430_x = false;
    }

    public ChunkCoordinates func_40472_j()
    {
        return field_4209_q.func_40469_f();
    }

    public void func_4076_b()
    {
        if(field_22145_q.func_22295_d() <= 0)
        {
            field_22145_q.func_22308_b(field_35472_c / 2);
        }
        int i = field_22145_q.func_22293_c();
        int j = field_22145_q.func_22300_e();
        int k = 0;
        do
        {
            if(func_614_g(i, j) != 0)
            {
                break;
            }
            i += field_1037_n.nextInt(8) - field_1037_n.nextInt(8);
            j += field_1037_n.nextInt(8) - field_1037_n.nextInt(8);
        } while(++k != 10000);
        field_22145_q.func_22294_a(i);
        field_22145_q.func_22298_c(j);
    }

    public int func_614_g(int i, int j)
    {
        int k;
        for(k = field_35470_e; !func_20084_d(i, k + 1, j); k++) { }
        return func_600_a(i, k, j);
    }

    public void func_6464_c()
    {
    }

    public void func_608_a(EntityPlayer entityplayer)
    {
        try
        {
            NBTTagCompound nbttagcompound = field_22145_q.func_22303_h();
            if(nbttagcompound != null)
            {
                entityplayer.func_368_e(nbttagcompound);
                field_22145_q.func_22309_a(null);
            }
            if(field_1017_H instanceof ChunkProviderLoadOrGenerate)
            {
                ChunkProviderLoadOrGenerate chunkproviderloadorgenerate = (ChunkProviderLoadOrGenerate)field_1017_H;
                int i = MathHelper.func_1110_d((int)entityplayer.field_611_ak) >> 4;
                int j = MathHelper.func_1110_d((int)entityplayer.field_609_am) >> 4;
                chunkproviderloadorgenerate.func_21110_c(i, j);
            }
            func_674_a(entityplayer);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_639_a(boolean flag, IProgressUpdate iprogressupdate)
    {
        if(!field_1017_H.func_536_b())
        {
            return;
        }
        if(iprogressupdate != null)
        {
            iprogressupdate.func_594_b("Saving level");
        }
        func_669_m();
        if(iprogressupdate != null)
        {
            iprogressupdate.func_595_d("Saving chunks");
        }
        field_1017_H.func_535_a(flag, iprogressupdate);
    }

    private void func_669_m()
    {
        func_663_l();
        field_22147_p.func_22148_a(field_22145_q, field_1040_k);
        field_28108_z.func_28188_a();
    }

    public boolean func_650_a(int i)
    {
        if(!field_1017_H.func_536_b())
        {
            return true;
        }
        if(i == 0)
        {
            func_669_m();
        }
        return field_1017_H.func_535_a(false, null);
    }

    public int func_600_a(int i, int j, int k)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return 0;
        }
        if(j < 0)
        {
            return 0;
        }
        if(j >= field_35472_c)
        {
            return 0;
        } else
        {
            return func_704_b(i >> 4, k >> 4).func_1008_a(i & 0xf, j, k & 0xf);
        }
    }

    public boolean func_20084_d(int i, int j, int k)
    {
        return func_600_a(i, j, k) == 0;
    }

    public boolean func_630_d(int i, int j, int k)
    {
        if(j < 0 || j >= field_35472_c)
        {
            return false;
        } else
        {
            return func_620_h(i >> 4, k >> 4);
        }
    }

    public boolean func_21117_a(int i, int j, int k, int l)
    {
        return func_640_a(i - l, j - l, k - l, i + l, j + l, k + l);
    }

    public boolean func_640_a(int i, int j, int k, int l, int i1, int j1)
    {
        if(i1 < 0 || j >= field_35472_c)
        {
            return false;
        }
        i >>= 4;
        j >>= 4;
        k >>= 4;
        l >>= 4;
        i1 >>= 4;
        j1 >>= 4;
        for(int k1 = i; k1 <= l; k1++)
        {
            for(int l1 = k; l1 <= j1; l1++)
            {
                if(!func_620_h(k1, l1))
                {
                    return false;
                }
            }

        }

        return true;
    }

    private boolean func_620_h(int i, int j)
    {
        return field_1017_H.func_537_a(i, j);
    }

    public Chunk func_673_a(int i, int j)
    {
        return func_704_b(i >> 4, j >> 4);
    }

    public Chunk func_704_b(int i, int j)
    {
        return field_1017_H.func_533_b(i, j);
    }

    public boolean func_643_a(int i, int j, int k, int l, int i1)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return false;
        }
        if(j < 0)
        {
            return false;
        }
        if(j >= field_35472_c)
        {
            return false;
        } else
        {
            Chunk chunk = func_704_b(i >> 4, k >> 4);
            boolean flag = chunk.func_1010_a(i & 0xf, j, k & 0xf, l, i1);
            func_35463_p(i, j, k);
            return flag;
        }
    }

    public boolean func_634_a(int i, int j, int k, int l)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return false;
        }
        if(j < 0)
        {
            return false;
        }
        if(j >= field_35472_c)
        {
            return false;
        } else
        {
            Chunk chunk = func_704_b(i >> 4, k >> 4);
            boolean flag = chunk.func_1022_a(i & 0xf, j, k & 0xf, l);
            func_35463_p(i, j, k);
            return flag;
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

    public int func_602_e(int i, int j, int k)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return 0;
        }
        if(j < 0)
        {
            return 0;
        }
        if(j >= field_35472_c)
        {
            return 0;
        } else
        {
            Chunk chunk = func_704_b(i >> 4, k >> 4);
            i &= 0xf;
            k &= 0xf;
            return chunk.func_1021_b(i, j, k);
        }
    }

    public void func_691_b(int i, int j, int k, int l)
    {
        if(func_635_c(i, j, k, l))
        {
            int i1 = func_600_a(i, j, k);
            if(Block.field_28032_t[i1 & 0xff])
            {
                func_617_e(i, j, k, i1);
            } else
            {
                func_611_g(i, j, k, i1);
            }
        }
    }

    public boolean func_635_c(int i, int j, int k, int l)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return false;
        }
        if(j < 0)
        {
            return false;
        }
        if(j >= field_35472_c)
        {
            return false;
        } else
        {
            Chunk chunk = func_704_b(i >> 4, k >> 4);
            i &= 0xf;
            k &= 0xf;
            return chunk.func_1009_b(i, j, k, l);
        }
    }

    public boolean func_690_d(int i, int j, int k, int l)
    {
        if(func_634_a(i, j, k, l))
        {
            func_617_e(i, j, k, l);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_688_b(int i, int j, int k, int l, int i1)
    {
        if(func_643_a(i, j, k, l, i1))
        {
            func_617_e(i, j, k, l);
            return true;
        } else
        {
            return false;
        }
    }

    public void func_665_h(int i, int j, int k)
    {
        for(int l = 0; l < field_9434_r.size(); l++)
        {
            ((IWorldAccess)field_9434_r.get(l)).func_934_a(i, j, k);
        }

    }

    protected void func_617_e(int i, int j, int k, int l)
    {
        func_665_h(i, j, k);
        func_611_g(i, j, k, l);
    }

    public void func_680_f(int i, int j, int k, int l)
    {
        if(k > l)
        {
            int i1 = l;
            l = k;
            k = i1;
        }
        if(!field_4209_q.field_6478_e)
        {
            for(int j1 = k; j1 <= l; j1++)
            {
                func_35459_c(EnumSkyBlock.Sky, i, j1, j);
            }

        }
        func_701_b(i, k, j, i, l, j);
    }

    public void func_21115_j(int i, int j, int k)
    {
        for(int l = 0; l < field_9434_r.size(); l++)
        {
            ((IWorldAccess)field_9434_r.get(l)).func_937_b(i, j, k, i, j, k);
        }

    }

    public void func_701_b(int i, int j, int k, int l, int i1, int j1)
    {
        for(int k1 = 0; k1 < field_9434_r.size(); k1++)
        {
            ((IWorldAccess)field_9434_r.get(k1)).func_937_b(i, j, k, l, i1, j1);
        }

    }

    public void func_611_g(int i, int j, int k, int l)
    {
        func_655_l(i - 1, j, k, l);
        func_655_l(i + 1, j, k, l);
        func_655_l(i, j - 1, k, l);
        func_655_l(i, j + 1, k, l);
        func_655_l(i, j, k - 1, l);
        func_655_l(i, j, k + 1, l);
    }

    private void func_655_l(int i, int j, int k, int l)
    {
        if(field_1043_h || field_1026_y)
        {
            return;
        }
        Block block = Block.field_345_n[func_600_a(i, j, k)];
        if(block != null)
        {
            block.func_226_a(this, i, j, k, l);
        }
    }

    public boolean func_647_i(int i, int j, int k)
    {
        return func_704_b(i >> 4, k >> 4).func_1007_c(i & 0xf, j, k & 0xf);
    }

    public int func_28104_m(int i, int j, int k)
    {
        if(j < 0)
        {
            return 0;
        }
        if(j >= field_35472_c)
        {
            j = field_35472_c - 1;
        }
        return func_704_b(i >> 4, k >> 4).func_1019_c(i & 0xf, j, k & 0xf, 0);
    }

    public int func_618_j(int i, int j, int k)
    {
        return func_699_a(i, j, k, true);
    }

    public int func_699_a(int i, int j, int k, boolean flag)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return 15;
        }
        if(flag)
        {
            int l = func_600_a(i, j, k);
            if(l == Block.field_410_al.field_376_bc || l == Block.field_446_aB.field_376_bc || l == Block.field_4069_aI.field_376_bc || l == Block.field_4059_au.field_376_bc)
            {
                int i1 = func_699_a(i, j + 1, k, false);
                int j1 = func_699_a(i + 1, j, k, false);
                int k1 = func_699_a(i - 1, j, k, false);
                int l1 = func_699_a(i, j, k + 1, false);
                int i2 = func_699_a(i, j, k - 1, false);
                if(j1 > i1)
                {
                    i1 = j1;
                }
                if(k1 > i1)
                {
                    i1 = k1;
                }
                if(l1 > i1)
                {
                    i1 = l1;
                }
                if(i2 > i1)
                {
                    i1 = i2;
                }
                return i1;
            }
        }
        if(j < 0)
        {
            return 0;
        }
        if(j >= field_35472_c)
        {
            j = field_35472_c - 1;
        }
        Chunk chunk = func_704_b(i >> 4, k >> 4);
        i &= 0xf;
        k &= 0xf;
        return chunk.func_1019_c(i, j, k, field_1046_e);
    }

    public int func_666_c(int i, int j)
    {
        if(i < 0xfe363c80 || j < 0xfe363c80 || i >= 0x1c9c380 || j >= 0x1c9c380)
        {
            return 0;
        }
        if(!func_620_h(i >> 4, j >> 4))
        {
            return 0;
        } else
        {
            Chunk chunk = func_704_b(i >> 4, j >> 4);
            return chunk.func_999_b(i & 0xf, j & 0xf);
        }
    }

    public int func_35457_a(EnumSkyBlock enumskyblock, int i, int j, int k)
    {
        if(field_4209_q.field_6478_e && enumskyblock == EnumSkyBlock.Sky)
        {
            return 0;
        }
        if(j < 0)
        {
            j = 0;
        }
        if(j >= field_35472_c && enumskyblock == EnumSkyBlock.Sky)
        {
            return 15;
        }
        if(j < 0 || j >= field_35472_c || i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return enumskyblock.field_1722_c;
        }
        int l = i >> 4;
        int i1 = k >> 4;
        if(!func_620_h(l, i1))
        {
            return 0;
        }
        if(Block.field_40201_bL[func_600_a(i, j, k)])
        {
            int j1 = func_641_a(enumskyblock, i, j + 1, k);
            int k1 = func_641_a(enumskyblock, i + 1, j, k);
            int l1 = func_641_a(enumskyblock, i - 1, j, k);
            int i2 = func_641_a(enumskyblock, i, j, k + 1);
            int j2 = func_641_a(enumskyblock, i, j, k - 1);
            if(k1 > j1)
            {
                j1 = k1;
            }
            if(l1 > j1)
            {
                j1 = l1;
            }
            if(i2 > j1)
            {
                j1 = i2;
            }
            if(j2 > j1)
            {
                j1 = j2;
            }
            return j1;
        } else
        {
            Chunk chunk = func_704_b(l, i1);
            return chunk.func_1025_a(enumskyblock, i & 0xf, j, k & 0xf);
        }
    }

    public int func_641_a(EnumSkyBlock enumskyblock, int i, int j, int k)
    {
        if(j < 0)
        {
            j = 0;
        }
        if(j >= field_35472_c)
        {
            j = field_35472_c - 1;
        }
        if(j < 0 || j >= field_35472_c || i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return enumskyblock.field_1722_c;
        }
        int l = i >> 4;
        int i1 = k >> 4;
        if(!func_620_h(l, i1))
        {
            return 0;
        } else
        {
            Chunk chunk = func_704_b(l, i1);
            return chunk.func_1025_a(enumskyblock, i & 0xf, j, k & 0xf);
        }
    }

    public void func_664_b(EnumSkyBlock enumskyblock, int i, int j, int k, int l)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return;
        }
        if(j < 0)
        {
            return;
        }
        if(j >= field_35472_c)
        {
            return;
        }
        if(!func_620_h(i >> 4, k >> 4))
        {
            return;
        }
        Chunk chunk = func_704_b(i >> 4, k >> 4);
        chunk.func_1011_a(enumskyblock, i & 0xf, j, k & 0xf, l);
        for(int i1 = 0; i1 < field_9434_r.size(); i1++)
        {
            ((IWorldAccess)field_9434_r.get(i1)).func_934_a(i, j, k);
        }

    }

    public int func_35451_b(int i, int j, int k, int l)
    {
        int i1 = func_35457_a(EnumSkyBlock.Sky, i, j, k);
        int j1 = func_35457_a(EnumSkyBlock.Block, i, j, k);
        if(j1 < l)
        {
            j1 = l;
        }
        return i1 << 20 | j1 << 4;
    }

    public float func_28099_a(int i, int j, int k, int l)
    {
        int i1 = func_618_j(i, j, k);
        if(i1 < l)
        {
            i1 = l;
        }
        return field_4209_q.field_4219_d[i1];
    }

    public float func_598_c(int i, int j, int k)
    {
        return field_4209_q.field_4219_d[func_618_j(i, j, k)];
    }

    public boolean func_624_b()
    {
        return field_1046_e < 4;
    }

    public MovingObjectPosition func_645_a(Vec3D vec3d, Vec3D vec3d1)
    {
        return func_28105_a(vec3d, vec3d1, false, false);
    }

    public MovingObjectPosition func_642_a(Vec3D vec3d, Vec3D vec3d1, boolean flag)
    {
        return func_28105_a(vec3d, vec3d1, flag, false);
    }

    public MovingObjectPosition func_28105_a(Vec3D vec3d, Vec3D vec3d1, boolean flag, boolean flag1)
    {
        if(Double.isNaN(vec3d.field_1776_a) || Double.isNaN(vec3d.field_1775_b) || Double.isNaN(vec3d.field_1779_c))
        {
            return null;
        }
        if(Double.isNaN(vec3d1.field_1776_a) || Double.isNaN(vec3d1.field_1775_b) || Double.isNaN(vec3d1.field_1779_c))
        {
            return null;
        }
        int i = MathHelper.func_1108_b(vec3d1.field_1776_a);
        int j = MathHelper.func_1108_b(vec3d1.field_1775_b);
        int k = MathHelper.func_1108_b(vec3d1.field_1779_c);
        int l = MathHelper.func_1108_b(vec3d.field_1776_a);
        int i1 = MathHelper.func_1108_b(vec3d.field_1775_b);
        int j1 = MathHelper.func_1108_b(vec3d.field_1779_c);
        int k1 = func_600_a(l, i1, j1);
        int i2 = func_602_e(l, i1, j1);
        Block block = Block.field_345_n[k1];
        if((!flag1 || block == null || block.func_221_d(this, l, i1, j1) != null) && k1 > 0 && block.func_224_a(i2, flag))
        {
            MovingObjectPosition movingobjectposition = block.func_255_a(this, l, i1, j1, vec3d, vec3d1);
            if(movingobjectposition != null)
            {
                return movingobjectposition;
            }
        }
        for(int l1 = 200; l1-- >= 0;)
        {
            if(Double.isNaN(vec3d.field_1776_a) || Double.isNaN(vec3d.field_1775_b) || Double.isNaN(vec3d.field_1779_c))
            {
                return null;
            }
            if(l == i && i1 == j && j1 == k)
            {
                return null;
            }
            boolean flag2 = true;
            boolean flag3 = true;
            boolean flag4 = true;
            double d = 999D;
            double d1 = 999D;
            double d2 = 999D;
            if(i > l)
            {
                d = (double)l + 1.0D;
            } else
            if(i < l)
            {
                d = (double)l + 0.0D;
            } else
            {
                flag2 = false;
            }
            if(j > i1)
            {
                d1 = (double)i1 + 1.0D;
            } else
            if(j < i1)
            {
                d1 = (double)i1 + 0.0D;
            } else
            {
                flag3 = false;
            }
            if(k > j1)
            {
                d2 = (double)j1 + 1.0D;
            } else
            if(k < j1)
            {
                d2 = (double)j1 + 0.0D;
            } else
            {
                flag4 = false;
            }
            double d3 = 999D;
            double d4 = 999D;
            double d5 = 999D;
            double d6 = vec3d1.field_1776_a - vec3d.field_1776_a;
            double d7 = vec3d1.field_1775_b - vec3d.field_1775_b;
            double d8 = vec3d1.field_1779_c - vec3d.field_1779_c;
            if(flag2)
            {
                d3 = (d - vec3d.field_1776_a) / d6;
            }
            if(flag3)
            {
                d4 = (d1 - vec3d.field_1775_b) / d7;
            }
            if(flag4)
            {
                d5 = (d2 - vec3d.field_1779_c) / d8;
            }
            byte byte0 = 0;
            if(d3 < d4 && d3 < d5)
            {
                if(i > l)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 5;
                }
                vec3d.field_1776_a = d;
                vec3d.field_1775_b += d7 * d3;
                vec3d.field_1779_c += d8 * d3;
            } else
            if(d4 < d5)
            {
                if(j > i1)
                {
                    byte0 = 0;
                } else
                {
                    byte0 = 1;
                }
                vec3d.field_1776_a += d6 * d4;
                vec3d.field_1775_b = d1;
                vec3d.field_1779_c += d8 * d4;
            } else
            {
                if(k > j1)
                {
                    byte0 = 2;
                } else
                {
                    byte0 = 3;
                }
                vec3d.field_1776_a += d6 * d5;
                vec3d.field_1775_b += d7 * d5;
                vec3d.field_1779_c = d2;
            }
            Vec3D vec3d2 = Vec3D.func_1248_b(vec3d.field_1776_a, vec3d.field_1775_b, vec3d.field_1779_c);
            l = (int)(vec3d2.field_1776_a = MathHelper.func_1108_b(vec3d.field_1776_a));
            if(byte0 == 5)
            {
                l--;
                vec3d2.field_1776_a++;
            }
            i1 = (int)(vec3d2.field_1775_b = MathHelper.func_1108_b(vec3d.field_1775_b));
            if(byte0 == 1)
            {
                i1--;
                vec3d2.field_1775_b++;
            }
            j1 = (int)(vec3d2.field_1779_c = MathHelper.func_1108_b(vec3d.field_1779_c));
            if(byte0 == 3)
            {
                j1--;
                vec3d2.field_1779_c++;
            }
            int j2 = func_600_a(l, i1, j1);
            int k2 = func_602_e(l, i1, j1);
            Block block1 = Block.field_345_n[j2];
            if((!flag1 || block1 == null || block1.func_221_d(this, l, i1, j1) != null) && j2 > 0 && block1.func_224_a(k2, flag))
            {
                MovingObjectPosition movingobjectposition1 = block1.func_255_a(this, l, i1, j1, vec3d, vec3d1);
                if(movingobjectposition1 != null)
                {
                    return movingobjectposition1;
                }
            }
        }

        return null;
    }

    public void func_623_a(Entity entity, String s, float f, float f1)
    {
        for(int i = 0; i < field_9434_r.size(); i++)
        {
            ((IWorldAccess)field_9434_r.get(i)).func_940_a(s, entity.field_611_ak, entity.field_610_al - (double)entity.field_9292_aO, entity.field_609_am, f, f1);
        }

    }

    public void func_684_a(double d, double d1, double d2, String s, 
            float f, float f1)
    {
        for(int i = 0; i < field_9434_r.size(); i++)
        {
            ((IWorldAccess)field_9434_r.get(i)).func_940_a(s, d, d1, d2, f, f1);
        }

    }

    public void func_670_a(String s, int i, int j, int k)
    {
        for(int l = 0; l < field_9434_r.size(); l++)
        {
            ((IWorldAccess)field_9434_r.get(l)).func_933_a(s, i, j, k);
        }

    }

    public void func_694_a(String s, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        for(int i = 0; i < field_9434_r.size(); i++)
        {
            ((IWorldAccess)field_9434_r.get(i)).func_939_a(s, d, d1, d2, d3, d4, d5);
        }

    }

    public boolean func_27159_a(Entity entity)
    {
        field_27173_e.add(entity);
        return true;
    }

    public boolean func_674_a(Entity entity)
    {
        int i = MathHelper.func_1108_b(entity.field_611_ak / 16D);
        int j = MathHelper.func_1108_b(entity.field_609_am / 16D);
        boolean flag = false;
        if(entity instanceof EntityPlayer)
        {
            flag = true;
        }
        if(flag || func_620_h(i, j))
        {
            if(entity instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                field_1040_k.add(entityplayer);
                func_22140_w();
            }
            func_704_b(i, j).func_1000_a(entity);
            field_1050_a.add(entity);
            func_606_b(entity);
            return true;
        } else
        {
            return false;
        }
    }

    protected void func_606_b(Entity entity)
    {
        for(int i = 0; i < field_9434_r.size(); i++)
        {
            ((IWorldAccess)field_9434_r.get(i)).func_941_a(entity);
        }

    }

    protected void func_678_c(Entity entity)
    {
        for(int i = 0; i < field_9434_r.size(); i++)
        {
            ((IWorldAccess)field_9434_r.get(i)).func_938_b(entity);
        }

    }

    public void func_607_d(Entity entity)
    {
        if(entity.field_617_ae != null)
        {
            entity.field_617_ae.func_6377_h(null);
        }
        if(entity.field_616_af != null)
        {
            entity.func_6377_h(null);
        }
        entity.func_395_F();
        if(entity instanceof EntityPlayer)
        {
            field_1040_k.remove((EntityPlayer)entity);
            func_22140_w();
        }
    }

    public void func_613_a(IWorldAccess iworldaccess)
    {
        field_9434_r.add(iworldaccess);
    }

    public void func_672_b(IWorldAccess iworldaccess)
    {
        field_9434_r.remove(iworldaccess);
    }

    public List func_697_a(Entity entity, AxisAlignedBB axisalignedbb)
    {
        field_9428_I.clear();
        int i = MathHelper.func_1108_b(axisalignedbb.field_1698_a);
        int j = MathHelper.func_1108_b(axisalignedbb.field_1703_d + 1.0D);
        int k = MathHelper.func_1108_b(axisalignedbb.field_1697_b);
        int l = MathHelper.func_1108_b(axisalignedbb.field_1702_e + 1.0D);
        int i1 = MathHelper.func_1108_b(axisalignedbb.field_1704_c);
        int j1 = MathHelper.func_1108_b(axisalignedbb.field_1701_f + 1.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = i1; l1 < j1; l1++)
            {
                if(!func_630_d(k1, field_35472_c / 2, l1))
                {
                    continue;
                }
                for(int i2 = k - 1; i2 < l; i2++)
                {
                    Block block = Block.field_345_n[func_600_a(k1, i2, l1)];
                    if(block != null)
                    {
                        block.func_230_a(this, k1, i2, l1, axisalignedbb, field_9428_I);
                    }
                }

            }

        }

        double d = 0.25D;
        List list = func_659_b(entity, axisalignedbb.func_1177_b(d, d, d));
        for(int j2 = 0; j2 < list.size(); j2++)
        {
            AxisAlignedBB axisalignedbb1 = ((Entity)list.get(j2)).func_372_f_();
            if(axisalignedbb1 != null && axisalignedbb1.func_1178_a(axisalignedbb))
            {
                field_9428_I.add(axisalignedbb1);
            }
            axisalignedbb1 = entity.func_383_b_((Entity)list.get(j2));
            if(axisalignedbb1 != null && axisalignedbb1.func_1178_a(axisalignedbb))
            {
                field_9428_I.add(axisalignedbb1);
            }
        }

        return field_9428_I;
    }

    public int func_671_a(float f)
    {
        float f1 = func_619_c(f);
        float f2 = 1.0F - (MathHelper.func_1114_b(f1 * 3.141593F * 2.0F) * 2.0F + 0.5F);
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        f2 = 1.0F - f2;
        f2 = (float)((double)f2 * (1.0D - (double)(func_27162_g(f) * 5F) / 16D));
        f2 = (float)((double)f2 * (1.0D - (double)(func_27166_f(f) * 5F) / 16D));
        f2 = 1.0F - f2;
        return (int)(f2 * 11F);
    }

    public float func_35464_b(float f)
    {
        float f1 = func_619_c(f);
        float f2 = 1.0F - (MathHelper.func_1114_b(f1 * 3.141593F * 2.0F) * 2.0F + 0.2F);
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        f2 = 1.0F - f2;
        f2 = (float)((double)f2 * (1.0D - (double)(func_27162_g(f) * 5F) / 16D));
        f2 = (float)((double)f2 * (1.0D - (double)(func_27166_f(f) * 5F) / 16D));
        return f2 * 0.8F + 0.2F;
    }

    public Vec3D func_4079_a(Entity entity, float f)
    {
        float f1 = func_619_c(f);
        float f2 = MathHelper.func_1114_b(f1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        int i = MathHelper.func_1108_b(entity.field_611_ak);
        int j = MathHelper.func_1108_b(entity.field_609_am);
        float f3 = func_4075_a().func_35554_b(i, 64, j);
        int k = func_4075_a().func_4073_a(i, j).func_4126_a(f3);
        float f4 = (float)(k >> 16 & 0xff) / 255F;
        float f5 = (float)(k >> 8 & 0xff) / 255F;
        float f6 = (float)(k & 0xff) / 255F;
        f4 *= f2;
        f5 *= f2;
        f6 *= f2;
        float f7 = func_27162_g(f);
        if(f7 > 0.0F)
        {
            float f8 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.6F;
            float f10 = 1.0F - f7 * 0.75F;
            f4 = f4 * f10 + f8 * (1.0F - f10);
            f5 = f5 * f10 + f8 * (1.0F - f10);
            f6 = f6 * f10 + f8 * (1.0F - f10);
        }
        float f9 = func_27166_f(f);
        if(f9 > 0.0F)
        {
            float f11 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.2F;
            float f13 = 1.0F - f9 * 0.75F;
            f4 = f4 * f13 + f11 * (1.0F - f13);
            f5 = f5 * f13 + f11 * (1.0F - f13);
            f6 = f6 * f13 + f11 * (1.0F - f13);
        }
        if(field_27172_i > 0)
        {
            float f12 = (float)field_27172_i - f;
            if(f12 > 1.0F)
            {
                f12 = 1.0F;
            }
            f12 *= 0.45F;
            f4 = f4 * (1.0F - f12) + 0.8F * f12;
            f5 = f5 * (1.0F - f12) + 0.8F * f12;
            f6 = f6 * (1.0F - f12) + 1.0F * f12;
        }
        return Vec3D.func_1248_b(f4, f5, f6);
    }

    public float func_619_c(float f)
    {
        return field_4209_q.func_4100_a(field_22145_q.func_22304_f(), f);
    }

    public int func_40475_d(float f)
    {
        return field_4209_q.func_40470_b(field_22145_q.func_22304_f(), f);
    }

    public float func_35456_d(float f)
    {
        float f1 = func_619_c(f);
        return f1 * 3.141593F * 2.0F;
    }

    public Vec3D func_628_d(float f)
    {
        float f1 = func_619_c(f);
        float f2 = MathHelper.func_1114_b(f1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = (float)(field_1019_F >> 16 & 255L) / 255F;
        float f4 = (float)(field_1019_F >> 8 & 255L) / 255F;
        float f5 = (float)(field_1019_F & 255L) / 255F;
        float f6 = func_27162_g(f);
        if(f6 > 0.0F)
        {
            float f7 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.6F;
            float f9 = 1.0F - f6 * 0.95F;
            f3 = f3 * f9 + f7 * (1.0F - f9);
            f4 = f4 * f9 + f7 * (1.0F - f9);
            f5 = f5 * f9 + f7 * (1.0F - f9);
        }
        f3 *= f2 * 0.9F + 0.1F;
        f4 *= f2 * 0.9F + 0.1F;
        f5 *= f2 * 0.85F + 0.15F;
        float f8 = func_27166_f(f);
        if(f8 > 0.0F)
        {
            float f10 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.2F;
            float f11 = 1.0F - f8 * 0.95F;
            f3 = f3 * f11 + f10 * (1.0F - f11);
            f4 = f4 * f11 + f10 * (1.0F - f11);
            f5 = f5 * f11 + f10 * (1.0F - f11);
        }
        return Vec3D.func_1248_b(f3, f4, f5);
    }

    public Vec3D func_4082_d(float f)
    {
        float f1 = func_619_c(f);
        return field_4209_q.func_4096_a(f1, f);
    }

    public int func_35461_e(int i, int j)
    {
        return func_673_a(i, j).func_35840_c(i & 0xf, j & 0xf);
    }

    public int func_4083_e(int i, int j)
    {
        Chunk chunk = func_673_a(i, j);
        int k = field_35472_c - 1;
        i &= 0xf;
        j &= 0xf;
        while(k > 0) 
        {
            int l = chunk.func_1008_a(i, k, j);
            if(l == 0 || !Block.field_345_n[l].field_356_bn.func_880_c() || Block.field_345_n[l].field_356_bn == Material.field_4265_h)
            {
                k--;
            } else
            {
                return k + 1;
            }
        }
        return -1;
    }

    public float func_679_f(float f)
    {
        float f1 = func_619_c(f);
        float f2 = 1.0F - (MathHelper.func_1114_b(f1 * 3.141593F * 2.0F) * 2.0F + 0.75F);
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        return f2 * f2 * 0.5F;
    }

    public void func_22136_c(int i, int j, int k, int l, int i1)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(i, j, k, l);
        byte byte0 = 8;
        if(field_4214_a)
        {
            if(func_640_a(nextticklistentry.field_1361_a - byte0, nextticklistentry.field_1360_b - byte0, nextticklistentry.field_1366_c - byte0, nextticklistentry.field_1361_a + byte0, nextticklistentry.field_1360_b + byte0, nextticklistentry.field_1366_c + byte0))
            {
                int j1 = func_600_a(nextticklistentry.field_1361_a, nextticklistentry.field_1360_b, nextticklistentry.field_1366_c);
                if(j1 == nextticklistentry.field_1365_d && j1 > 0)
                {
                    Block.field_345_n[j1].func_208_a(this, nextticklistentry.field_1361_a, nextticklistentry.field_1360_b, nextticklistentry.field_1366_c, field_1037_n);
                }
            }
            return;
        }
        if(func_640_a(i - byte0, j - byte0, k - byte0, i + byte0, j + byte0, k + byte0))
        {
            if(l > 0)
            {
                nextticklistentry.func_900_a((long)i1 + field_22145_q.func_22304_f());
            }
            if(!field_1056_C.contains(nextticklistentry))
            {
                field_1056_C.add(nextticklistentry);
                field_1058_B.add(nextticklistentry);
            }
        }
    }

    public void func_41083_e(int i, int j, int k, int l, int i1)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(i, j, k, l);
        if(l > 0)
        {
            nextticklistentry.func_900_a((long)i1 + field_22145_q.func_22304_f());
        }
        if(!field_1056_C.contains(nextticklistentry))
        {
            field_1056_C.add(nextticklistentry);
            field_1058_B.add(nextticklistentry);
        }
    }

    public void func_633_c()
    {
        Profiler.func_40663_a("entities");
        Profiler.func_40663_a("global");
        for(int i = 0; i < field_27173_e.size(); i++)
        {
            Entity entity = (Entity)field_27173_e.get(i);
            entity.func_370_e_();
            if(entity.field_646_aA)
            {
                field_27173_e.remove(i--);
            }
        }

        Profiler.func_40661_c("remove");
        field_1050_a.removeAll(field_1024_A);
        for(int j = 0; j < field_1024_A.size(); j++)
        {
            Entity entity1 = (Entity)field_1024_A.get(j);
            int i1 = entity1.field_657_ba;
            int k1 = entity1.field_654_bc;
            if(entity1.field_621_aZ && func_620_h(i1, k1))
            {
                func_704_b(i1, k1).func_1015_b(entity1);
            }
        }

        for(int k = 0; k < field_1024_A.size(); k++)
        {
            func_678_c((Entity)field_1024_A.get(k));
        }

        field_1024_A.clear();
        Profiler.func_40661_c("regular");
        for(int l = 0; l < field_1050_a.size(); l++)
        {
            Entity entity2 = (Entity)field_1050_a.get(l);
            if(entity2.field_616_af != null)
            {
                if(!entity2.field_616_af.field_646_aA && entity2.field_616_af.field_617_ae == entity2)
                {
                    continue;
                }
                entity2.field_616_af.field_617_ae = null;
                entity2.field_616_af = null;
            }
            if(!entity2.field_646_aA)
            {
                func_667_e(entity2);
            }
            Profiler.func_40663_a("remove");
            if(entity2.field_646_aA)
            {
                int j1 = entity2.field_657_ba;
                int l1 = entity2.field_654_bc;
                if(entity2.field_621_aZ && func_620_h(j1, l1))
                {
                    func_704_b(j1, l1).func_1015_b(entity2);
                }
                field_1050_a.remove(l--);
                func_678_c(entity2);
            }
            Profiler.func_40662_b();
        }

        Profiler.func_40661_c("tileEntities");
        field_31055_L = true;
        Iterator iterator = field_1049_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            TileEntity tileentity = (TileEntity)iterator.next();
            if(!tileentity.func_31006_g() && tileentity.field_824_e != null && func_630_d(tileentity.field_823_f, tileentity.field_822_g, tileentity.field_821_h))
            {
                tileentity.func_475_b();
            }
            if(tileentity.func_31006_g())
            {
                iterator.remove();
                if(func_620_h(tileentity.field_823_f >> 4, tileentity.field_821_h >> 4))
                {
                    Chunk chunk = func_704_b(tileentity.field_823_f >> 4, tileentity.field_821_h >> 4);
                    if(chunk != null)
                    {
                        chunk.func_1023_e(tileentity.field_823_f & 0xf, tileentity.field_822_g, tileentity.field_821_h & 0xf);
                    }
                }
            }
        } while(true);
        field_31055_L = false;
        if(!field_34900_Q.isEmpty())
        {
            field_1049_b.removeAll(field_34900_Q);
            field_34900_Q.clear();
        }
        Profiler.func_40661_c("pendingTileEntities");
        if(!field_30900_E.isEmpty())
        {
            Iterator iterator1 = field_30900_E.iterator();
            do
            {
                if(!iterator1.hasNext())
                {
                    break;
                }
                TileEntity tileentity1 = (TileEntity)iterator1.next();
                if(!tileentity1.func_31006_g())
                {
                    if(!field_1049_b.contains(tileentity1))
                    {
                        field_1049_b.add(tileentity1);
                    }
                    if(func_620_h(tileentity1.field_823_f >> 4, tileentity1.field_821_h >> 4))
                    {
                        Chunk chunk1 = func_704_b(tileentity1.field_823_f >> 4, tileentity1.field_821_h >> 4);
                        if(chunk1 != null)
                        {
                            chunk1.func_1005_a(tileentity1.field_823_f & 0xf, tileentity1.field_822_g, tileentity1.field_821_h & 0xf, tileentity1);
                        }
                    }
                    func_665_h(tileentity1.field_823_f, tileentity1.field_822_g, tileentity1.field_821_h);
                }
            } while(true);
            field_30900_E.clear();
        }
        Profiler.func_40662_b();
        Profiler.func_40662_b();
    }

    public void func_31054_a(Collection collection)
    {
        if(field_31055_L)
        {
            field_30900_E.addAll(collection);
        } else
        {
            field_1049_b.addAll(collection);
        }
    }

    public void func_667_e(Entity entity)
    {
        func_4084_a(entity, true);
    }

    public void func_4084_a(Entity entity, boolean flag)
    {
        int i = MathHelper.func_1108_b(entity.field_611_ak);
        int j = MathHelper.func_1108_b(entity.field_609_am);
        byte byte0 = 32;
        if(flag && !func_640_a(i - byte0, 0, j - byte0, i + byte0, field_35472_c, j + byte0))
        {
            return;
        }
        entity.field_638_aI = entity.field_611_ak;
        entity.field_637_aJ = entity.field_610_al;
        entity.field_636_aK = entity.field_609_am;
        entity.field_603_as = entity.field_605_aq;
        entity.field_602_at = entity.field_604_ar;
        if(flag && entity.field_621_aZ)
        {
            if(entity.field_616_af != null)
            {
                entity.func_350_p();
            } else
            {
                entity.func_370_e_();
            }
        }
        Profiler.func_40663_a("chunkCheck");
        if(Double.isNaN(entity.field_611_ak) || Double.isInfinite(entity.field_611_ak))
        {
            entity.field_611_ak = entity.field_638_aI;
        }
        if(Double.isNaN(entity.field_610_al) || Double.isInfinite(entity.field_610_al))
        {
            entity.field_610_al = entity.field_637_aJ;
        }
        if(Double.isNaN(entity.field_609_am) || Double.isInfinite(entity.field_609_am))
        {
            entity.field_609_am = entity.field_636_aK;
        }
        if(Double.isNaN(entity.field_604_ar) || Double.isInfinite(entity.field_604_ar))
        {
            entity.field_604_ar = entity.field_602_at;
        }
        if(Double.isNaN(entity.field_605_aq) || Double.isInfinite(entity.field_605_aq))
        {
            entity.field_605_aq = entity.field_603_as;
        }
        int k = MathHelper.func_1108_b(entity.field_611_ak / 16D);
        int l = MathHelper.func_1108_b(entity.field_610_al / 16D);
        int i1 = MathHelper.func_1108_b(entity.field_609_am / 16D);
        if(!entity.field_621_aZ || entity.field_657_ba != k || entity.field_656_bb != l || entity.field_654_bc != i1)
        {
            if(entity.field_621_aZ && func_620_h(entity.field_657_ba, entity.field_654_bc))
            {
                func_704_b(entity.field_657_ba, entity.field_654_bc).func_1016_a(entity, entity.field_656_bb);
            }
            if(func_620_h(k, i1))
            {
                entity.field_621_aZ = true;
                func_704_b(k, i1).func_1000_a(entity);
            } else
            {
                entity.field_621_aZ = false;
            }
        }
        Profiler.func_40662_b();
        if(flag && entity.field_621_aZ && entity.field_617_ae != null)
        {
            if(entity.field_617_ae.field_646_aA || entity.field_617_ae.field_616_af != entity)
            {
                entity.field_617_ae.field_616_af = null;
                entity.field_617_ae = null;
            } else
            {
                func_667_e(entity.field_617_ae);
            }
        }
    }

    public boolean func_604_a(AxisAlignedBB axisalignedbb)
    {
        List list = func_659_b(null, axisalignedbb);
        for(int i = 0; i < list.size(); i++)
        {
            Entity entity = (Entity)list.get(i);
            if(!entity.field_646_aA && entity.field_618_ad)
            {
                return false;
            }
        }

        return true;
    }

    public boolean func_662_b(AxisAlignedBB axisalignedbb)
    {
        int i = MathHelper.func_1108_b(axisalignedbb.field_1698_a);
        int j = MathHelper.func_1108_b(axisalignedbb.field_1703_d + 1.0D);
        int k = MathHelper.func_1108_b(axisalignedbb.field_1697_b);
        int l = MathHelper.func_1108_b(axisalignedbb.field_1702_e + 1.0D);
        int i1 = MathHelper.func_1108_b(axisalignedbb.field_1704_c);
        int j1 = MathHelper.func_1108_b(axisalignedbb.field_1701_f + 1.0D);
        if(axisalignedbb.field_1698_a < 0.0D)
        {
            i--;
        }
        if(axisalignedbb.field_1697_b < 0.0D)
        {
            k--;
        }
        if(axisalignedbb.field_1704_c < 0.0D)
        {
            i1--;
        }
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_345_n[func_600_a(k1, l1, i2)];
                    if(block != null && block.field_356_bn.func_879_d())
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean func_605_c(AxisAlignedBB axisalignedbb)
    {
        int i = MathHelper.func_1108_b(axisalignedbb.field_1698_a);
        int j = MathHelper.func_1108_b(axisalignedbb.field_1703_d + 1.0D);
        int k = MathHelper.func_1108_b(axisalignedbb.field_1697_b);
        int l = MathHelper.func_1108_b(axisalignedbb.field_1702_e + 1.0D);
        int i1 = MathHelper.func_1108_b(axisalignedbb.field_1704_c);
        int j1 = MathHelper.func_1108_b(axisalignedbb.field_1701_f + 1.0D);
        if(func_640_a(i, k, i1, j, l, j1))
        {
            for(int k1 = i; k1 < j; k1++)
            {
                for(int l1 = k; l1 < l; l1++)
                {
                    for(int i2 = i1; i2 < j1; i2++)
                    {
                        int j2 = func_600_a(k1, l1, i2);
                        if(j2 == Block.field_402_as.field_376_bc || j2 == Block.field_397_D.field_376_bc || j2 == Block.field_395_E.field_376_bc)
                        {
                            return true;
                        }
                    }

                }

            }

        }
        return false;
    }

    public boolean func_682_a(AxisAlignedBB axisalignedbb, Material material, Entity entity)
    {
        int i = MathHelper.func_1108_b(axisalignedbb.field_1698_a);
        int j = MathHelper.func_1108_b(axisalignedbb.field_1703_d + 1.0D);
        int k = MathHelper.func_1108_b(axisalignedbb.field_1697_b);
        int l = MathHelper.func_1108_b(axisalignedbb.field_1702_e + 1.0D);
        int i1 = MathHelper.func_1108_b(axisalignedbb.field_1704_c);
        int j1 = MathHelper.func_1108_b(axisalignedbb.field_1701_f + 1.0D);
        if(!func_640_a(i, k, i1, j, l, j1))
        {
            return false;
        }
        boolean flag = false;
        Vec3D vec3d = Vec3D.func_1248_b(0.0D, 0.0D, 0.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_345_n[func_600_a(k1, l1, i2)];
                    if(block == null || block.field_356_bn != material)
                    {
                        continue;
                    }
                    double d1 = (float)(l1 + 1) - BlockFluid.func_288_b(func_602_e(k1, l1, i2));
                    if((double)l >= d1)
                    {
                        flag = true;
                        block.func_257_a(this, k1, l1, i2, entity, vec3d);
                    }
                }

            }

        }

        if(vec3d.func_1253_c() > 0.0D)
        {
            vec3d = vec3d.func_1252_b();
            double d = 0.014D;
            entity.field_608_an += vec3d.field_1776_a * d;
            entity.field_607_ao += vec3d.field_1775_b * d;
            entity.field_606_ap += vec3d.field_1779_c * d;
        }
        return flag;
    }

    public boolean func_689_a(AxisAlignedBB axisalignedbb, Material material)
    {
        int i = MathHelper.func_1108_b(axisalignedbb.field_1698_a);
        int j = MathHelper.func_1108_b(axisalignedbb.field_1703_d + 1.0D);
        int k = MathHelper.func_1108_b(axisalignedbb.field_1697_b);
        int l = MathHelper.func_1108_b(axisalignedbb.field_1702_e + 1.0D);
        int i1 = MathHelper.func_1108_b(axisalignedbb.field_1704_c);
        int j1 = MathHelper.func_1108_b(axisalignedbb.field_1701_f + 1.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_345_n[func_600_a(k1, l1, i2)];
                    if(block != null && block.field_356_bn == material)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean func_707_b(AxisAlignedBB axisalignedbb, Material material)
    {
        int i = MathHelper.func_1108_b(axisalignedbb.field_1698_a);
        int j = MathHelper.func_1108_b(axisalignedbb.field_1703_d + 1.0D);
        int k = MathHelper.func_1108_b(axisalignedbb.field_1697_b);
        int l = MathHelper.func_1108_b(axisalignedbb.field_1702_e + 1.0D);
        int i1 = MathHelper.func_1108_b(axisalignedbb.field_1704_c);
        int j1 = MathHelper.func_1108_b(axisalignedbb.field_1701_f + 1.0D);
        for(int k1 = i; k1 < j; k1++)
        {
            for(int l1 = k; l1 < l; l1++)
            {
                for(int i2 = i1; i2 < j1; i2++)
                {
                    Block block = Block.field_345_n[func_600_a(k1, l1, i2)];
                    if(block == null || block.field_356_bn != material)
                    {
                        continue;
                    }
                    int j2 = func_602_e(k1, l1, i2);
                    double d = l1 + 1;
                    if(j2 < 8)
                    {
                        d = (double)(l1 + 1) - (double)j2 / 8D;
                    }
                    if(d >= axisalignedbb.field_1697_b)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public Explosion func_12243_a(Entity entity, double d, double d1, double d2, 
            float f)
    {
        return func_12244_a(entity, d, d1, d2, f, false);
    }

    public Explosion func_12244_a(Entity entity, double d, double d1, double d2, 
            float f, boolean flag)
    {
        Explosion explosion = new Explosion(this, entity, d, d1, d2, f);
        explosion.field_12257_a = flag;
        explosion.func_12248_a();
        explosion.func_12247_b(true);
        return explosion;
    }

    public float func_675_a(Vec3D vec3d, AxisAlignedBB axisalignedbb)
    {
        double d = 1.0D / ((axisalignedbb.field_1703_d - axisalignedbb.field_1698_a) * 2D + 1.0D);
        double d1 = 1.0D / ((axisalignedbb.field_1702_e - axisalignedbb.field_1697_b) * 2D + 1.0D);
        double d2 = 1.0D / ((axisalignedbb.field_1701_f - axisalignedbb.field_1704_c) * 2D + 1.0D);
        int i = 0;
        int j = 0;
        for(float f = 0.0F; f <= 1.0F; f = (float)((double)f + d))
        {
            for(float f1 = 0.0F; f1 <= 1.0F; f1 = (float)((double)f1 + d1))
            {
                for(float f2 = 0.0F; f2 <= 1.0F; f2 = (float)((double)f2 + d2))
                {
                    double d3 = axisalignedbb.field_1698_a + (axisalignedbb.field_1703_d - axisalignedbb.field_1698_a) * (double)f;
                    double d4 = axisalignedbb.field_1697_b + (axisalignedbb.field_1702_e - axisalignedbb.field_1697_b) * (double)f1;
                    double d5 = axisalignedbb.field_1704_c + (axisalignedbb.field_1701_f - axisalignedbb.field_1704_c) * (double)f2;
                    if(func_645_a(Vec3D.func_1248_b(d3, d4, d5), vec3d) == null)
                    {
                        i++;
                    }
                    j++;
                }

            }

        }

        return (float)i / (float)j;
    }

    public void func_612_i(EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(l == 0)
        {
            j--;
        }
        if(l == 1)
        {
            j++;
        }
        if(l == 2)
        {
            k--;
        }
        if(l == 3)
        {
            k++;
        }
        if(l == 4)
        {
            i--;
        }
        if(l == 5)
        {
            i++;
        }
        if(func_600_a(i, j, k) == Block.field_402_as.field_376_bc)
        {
            func_28107_a(entityplayer, 1004, i, j, k, 0);
            func_690_d(i, j, k, 0);
        }
    }

    public Entity func_4085_a(Class class1)
    {
        return null;
    }

    public String func_687_d()
    {
        return (new StringBuilder()).append("All: ").append(field_1050_a.size()).toString();
    }

    public String func_21119_g()
    {
        return field_1017_H.func_21109_c();
    }

    public TileEntity func_603_b(int i, int j, int k)
    {
label0:
        {
            TileEntity tileentity;
label1:
            {
                Chunk chunk = func_704_b(i >> 4, k >> 4);
                if(chunk == null)
                {
                    break label0;
                }
                tileentity = chunk.func_1002_d(i & 0xf, j, k & 0xf);
                if(tileentity != null)
                {
                    break label1;
                }
                Iterator iterator = field_30900_E.iterator();
                TileEntity tileentity1;
                do
                {
                    if(!iterator.hasNext())
                    {
                        break label1;
                    }
                    tileentity1 = (TileEntity)iterator.next();
                } while(tileentity1.func_31006_g() || tileentity1.field_823_f != i || tileentity1.field_822_g != j || tileentity1.field_821_h != k);
                tileentity = tileentity1;
            }
            return tileentity;
        }
        return null;
    }

    public void func_654_a(int i, int j, int k, TileEntity tileentity)
    {
        if(tileentity != null && !tileentity.func_31006_g())
        {
            if(field_31055_L)
            {
                tileentity.field_823_f = i;
                tileentity.field_822_g = j;
                tileentity.field_821_h = k;
                field_30900_E.add(tileentity);
            } else
            {
                field_1049_b.add(tileentity);
                Chunk chunk = func_704_b(i >> 4, k >> 4);
                if(chunk != null)
                {
                    chunk.func_1005_a(i & 0xf, j, k & 0xf, tileentity);
                }
            }
        }
    }

    public void func_692_l(int i, int j, int k)
    {
        TileEntity tileentity = func_603_b(i, j, k);
        if(tileentity != null && field_31055_L)
        {
            tileentity.func_31005_i();
            field_30900_E.remove(tileentity);
        } else
        {
            if(tileentity != null)
            {
                field_30900_E.remove(tileentity);
                field_1049_b.remove(tileentity);
            }
            Chunk chunk = func_704_b(i >> 4, k >> 4);
            if(chunk != null)
            {
                chunk.func_1023_e(i & 0xf, j, k & 0xf);
            }
        }
    }

    public void func_35455_a(TileEntity tileentity)
    {
        field_34900_Q.add(tileentity);
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
            return block.field_356_bn.func_28126_h() && block.func_242_c();
        }
    }

    public boolean func_41082_b(int i, int j, int k, boolean flag)
    {
        if(i < 0xfe363c80 || k < 0xfe363c80 || i >= 0x1c9c380 || k >= 0x1c9c380)
        {
            return flag;
        }
        Chunk chunk = field_1017_H.func_533_b(i >> 4, k >> 4);
        if(chunk == null || chunk.func_21167_h())
        {
            return flag;
        }
        Block block = Block.field_345_n[func_600_a(i, j, k)];
        if(block == null)
        {
            return false;
        } else
        {
            return block.field_356_bn.func_28126_h() && block.func_242_c();
        }
    }

    public void func_651_a(IProgressUpdate iprogressupdate)
    {
        func_639_a(true, iprogressupdate);
        try
        {
            ThreadedFileIOBase.field_40573_a.func_40566_a();
        }
        catch(InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

    public void func_644_f()
    {
        int i = func_671_a(1.0F);
        if(i != field_1046_e)
        {
            field_1046_e = i;
        }
    }

    public void func_21114_a(boolean flag, boolean flag1)
    {
        field_21121_K = flag;
        field_21120_L = flag1;
    }

    public void func_649_g()
    {
        if(func_22144_v().func_40724_s() && field_1039_l < 3)
        {
            field_1039_l = 3;
        }
        func_4075_a().func_35561_b();
        func_27165_m();
        if(func_22142_y())
        {
            boolean flag = false;
            if(field_21121_K)
            {
                if(field_1039_l < 1);
            }
            if(!flag)
            {
                long l = field_22145_q.func_22304_f() + 24000L;
                field_22145_q.func_22307_a(l - l % 24000L);
                func_22141_x();
            }
        }
        Profiler.func_40663_a("mobSpawner");
        SpawnerAnimals.func_4154_a(this, field_21121_K, field_21120_L && field_22145_q.func_22304_f() % 400L == 0L);
        Profiler.func_40661_c("chunkSource");
        field_1017_H.func_532_a();
        int i = func_671_a(1.0F);
        if(i != field_1046_e)
        {
            field_1046_e = i;
        }
        long l1 = field_22145_q.func_22304_f() + 1L;
        if(l1 % (long)field_9435_j == 0L)
        {
            Profiler.func_40661_c("save");
            func_639_a(false, null);
        }
        field_22145_q.func_22307_a(l1);
        Profiler.func_40661_c("tickPending");
        func_700_a(false);
        Profiler.func_40661_c("tickTiles");
        func_4080_j();
        Profiler.func_40662_b();
    }

    private void func_27163_E()
    {
        if(field_22145_q.func_27397_o())
        {
            field_27171_C = 1.0F;
            if(field_22145_q.func_27396_m())
            {
                field_27169_E = 1.0F;
            }
        }
    }

    protected void func_27165_m()
    {
        if(field_4209_q.field_6478_e)
        {
            return;
        }
        if(field_27168_F > 0)
        {
            field_27168_F--;
        }
        int i = field_22145_q.func_27400_n();
        if(i <= 0)
        {
            if(field_22145_q.func_27396_m())
            {
                field_22145_q.func_27399_e(field_1037_n.nextInt(12000) + 3600);
            } else
            {
                field_22145_q.func_27399_e(field_1037_n.nextInt(0x29040) + 12000);
            }
        } else
        {
            i--;
            field_22145_q.func_27399_e(i);
            if(i <= 0)
            {
                field_22145_q.func_27398_a(!field_22145_q.func_27396_m());
            }
        }
        int j = field_22145_q.func_27393_p();
        if(j <= 0)
        {
            if(field_22145_q.func_27397_o())
            {
                field_22145_q.func_27395_f(field_1037_n.nextInt(12000) + 12000);
            } else
            {
                field_22145_q.func_27395_f(field_1037_n.nextInt(0x29040) + 12000);
            }
        } else
        {
            j--;
            field_22145_q.func_27395_f(j);
            if(j <= 0)
            {
                field_22145_q.func_27394_b(!field_22145_q.func_27397_o());
            }
        }
        field_26901_B = field_27171_C;
        if(field_22145_q.func_27397_o())
        {
            field_27171_C += 0.01D;
        } else
        {
            field_27171_C -= 0.01D;
        }
        if(field_27171_C < 0.0F)
        {
            field_27171_C = 0.0F;
        }
        if(field_27171_C > 1.0F)
        {
            field_27171_C = 1.0F;
        }
        field_27170_D = field_27169_E;
        if(field_22145_q.func_27396_m())
        {
            field_27169_E += 0.01D;
        } else
        {
            field_27169_E -= 0.01D;
        }
        if(field_27169_E < 0.0F)
        {
            field_27169_E = 0.0F;
        }
        if(field_27169_E > 1.0F)
        {
            field_27169_E = 1.0F;
        }
    }

    private void func_27164_F()
    {
        field_22145_q.func_27395_f(0);
        field_22145_q.func_27394_b(false);
        field_22145_q.func_27399_e(0);
        field_22145_q.func_27398_a(false);
    }

    protected void func_4080_j()
    {
        field_9427_K.clear();
        Profiler.func_40663_a("buildList");
        for(int i = 0; i < field_1040_k.size(); i++)
        {
            EntityPlayer entityplayer = (EntityPlayer)field_1040_k.get(i);
            int l = MathHelper.func_1108_b(entityplayer.field_611_ak / 16D);
            int i1 = MathHelper.func_1108_b(entityplayer.field_609_am / 16D);
            byte byte0 = 7;
            for(int k1 = -byte0; k1 <= byte0; k1++)
            {
                for(int i2 = -byte0; i2 <= byte0; i2++)
                {
                    field_9427_K.add(new ChunkCoordIntPair(k1 + l, i2 + i1));
                }

            }

        }

        if(field_9426_L > 0)
        {
            field_9426_L--;
        }
        int j = 0;
        int k = 0;
        Profiler.func_40662_b();
        for(Iterator iterator = field_9427_K.iterator(); iterator.hasNext(); Profiler.func_40662_b())
        {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            int j1 = chunkcoordintpair.field_189_a * 16;
            int l1 = chunkcoordintpair.field_188_b * 16;
            Profiler.func_40663_a("getChunk");
            Chunk chunk = func_704_b(chunkcoordintpair.field_189_a, chunkcoordintpair.field_188_b);
            Profiler.func_40661_c("tickChunk");
            chunk.func_35841_j();
            Profiler.func_40661_c("moodSound");
            if(field_9426_L == 0)
            {
                field_9437_g = field_9437_g * 3 + 0x3c6ef35f;
                int j2 = field_9437_g >> 2;
                int j3 = j2 & 0xf;
                int j4 = j2 >> 8 & 0xf;
                int j5 = j2 >> 16 & field_35469_d;
                int j6 = chunk.func_1008_a(j3, j5, j4);
                j3 += j1;
                j4 += l1;
                if(j6 == 0 && func_28104_m(j3, j5, j4) <= field_1037_n.nextInt(8) && func_641_a(EnumSkyBlock.Sky, j3, j5, j4) <= 0)
                {
                    EntityPlayer entityplayer1 = func_683_a((double)j3 + 0.5D, (double)j5 + 0.5D, (double)j4 + 0.5D, 8D);
                    if(entityplayer1 != null && entityplayer1.func_360_d((double)j3 + 0.5D, (double)j5 + 0.5D, (double)j4 + 0.5D) > 4D)
                    {
                        func_684_a((double)j3 + 0.5D, (double)j5 + 0.5D, (double)j4 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + field_1037_n.nextFloat() * 0.2F);
                        field_9426_L = field_1037_n.nextInt(12000) + 6000;
                    }
                }
            }
            Profiler.func_40661_c("thunder");
            if(field_1037_n.nextInt(0x186a0) == 0 && func_27161_C() && func_27160_B())
            {
                field_9437_g = field_9437_g * 3 + 0x3c6ef35f;
                int k2 = field_9437_g >> 2;
                int k3 = j1 + (k2 & 0xf);
                int k4 = l1 + (k2 >> 8 & 0xf);
                int k5 = func_35461_e(k3, k4);
                if(func_27167_r(k3, k5, k4))
                {
                    func_27159_a(new EntityLightningBolt(this, k3, k5, k4));
                    field_27168_F = 2;
                }
            }
            Profiler.func_40661_c("iceandsnow");
            if(field_1037_n.nextInt(16) == 0)
            {
                field_9437_g = field_9437_g * 3 + 0x3c6ef35f;
                int l2 = field_9437_g >> 2;
                int l3 = l2 & 0xf;
                int l4 = l2 >> 8 & 0xf;
                int l5 = func_35461_e(l3 + j1, l4 + l1);
                if(func_40481_q(l3 + j1, l5 - 1, l4 + l1))
                {
                    func_690_d(l3 + j1, l5 - 1, l4 + l1, Block.field_4063_aU.field_376_bc);
                }
                if(func_27161_C() && func_40478_r(l3 + j1, l5, l4 + l1))
                {
                    func_690_d(l3 + j1, l5, l4 + l1, Block.field_428_aT.field_376_bc);
                }
            }
            Profiler.func_40661_c("checkLight");
            func_35463_p(j1 + field_1037_n.nextInt(16), field_1037_n.nextInt(field_35472_c), l1 + field_1037_n.nextInt(16));
            Profiler.func_40661_c("tickTiles");
            for(int i3 = 0; i3 < 20; i3++)
            {
                field_9437_g = field_9437_g * 3 + 0x3c6ef35f;
                int i4 = field_9437_g >> 2;
                int i5 = i4 & 0xf;
                int i6 = i4 >> 8 & 0xf;
                int k6 = i4 >> 16 & field_35469_d;
                int l6 = chunk.field_1539_b[i5 << field_35471_b | i6 << field_35473_a | k6] & 0xff;
                k++;
                if(Block.field_344_o[l6])
                {
                    j++;
                    Block.field_345_n[l6].func_208_a(this, i5 + j1, k6, i6 + l1, field_1037_n);
                }
            }

        }

    }

    public boolean func_40471_p(int i, int j, int k)
    {
        return func_40476_b(i, j, k, false);
    }

    public boolean func_40481_q(int i, int j, int k)
    {
        return func_40476_b(i, j, k, true);
    }

    public boolean func_40476_b(int i, int j, int k, boolean flag)
    {
        float f = func_4075_a().func_35554_b(i, j, k);
        if(f > 0.15F)
        {
            return false;
        }
        if(j >= 0 && j < field_35472_c && func_641_a(EnumSkyBlock.Block, i, j, k) < 10)
        {
            int l = func_600_a(i, j, k);
            if((l == Block.field_399_C.field_376_bc || l == Block.field_401_B.field_376_bc) && func_602_e(i, j, k) == 0)
            {
                if(!flag)
                {
                    return true;
                }
                boolean flag1 = true;
                if(flag1 && func_599_f(i - 1, j, k) != Material.field_1332_f)
                {
                    flag1 = false;
                }
                if(flag1 && func_599_f(i + 1, j, k) != Material.field_1332_f)
                {
                    flag1 = false;
                }
                if(flag1 && func_599_f(i, j, k - 1) != Material.field_1332_f)
                {
                    flag1 = false;
                }
                if(flag1 && func_599_f(i, j, k + 1) != Material.field_1332_f)
                {
                    flag1 = false;
                }
                if(!flag1)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean func_40478_r(int i, int j, int k)
    {
        float f = func_4075_a().func_35554_b(i, j, k);
        if(f > 0.15F)
        {
            return false;
        }
        if(j >= 0 && j < field_35472_c && func_641_a(EnumSkyBlock.Block, i, j, k) < 10)
        {
            int l = func_600_a(i, j - 1, k);
            int i1 = func_600_a(i, j, k);
            if(i1 == 0 && Block.field_428_aT.func_243_a(this, i, j, k) && l != 0 && l != Block.field_4063_aU.field_376_bc && Block.field_345_n[l].field_356_bn.func_880_c())
            {
                return true;
            }
        }
        return false;
    }

    public void func_35463_p(int i, int j, int k)
    {
        if(!field_4209_q.field_6478_e)
        {
            func_35459_c(EnumSkyBlock.Sky, i, j, k);
        }
        func_35459_c(EnumSkyBlock.Block, i, j, k);
    }

    private int func_35460_a(int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = 0;
        if(func_647_i(j, k, l))
        {
            k1 = 15;
        } else
        {
            if(j1 == 0)
            {
                j1 = 1;
            }
            for(int l1 = 0; l1 < 6; l1++)
            {
                int i2 = (l1 % 2) * 2 - 1;
                int j2 = j + (((l1 / 2) % 3) / 2) * i2;
                int k2 = k + (((l1 / 2 + 1) % 3) / 2) * i2;
                int l2 = l + (((l1 / 2 + 2) % 3) / 2) * i2;
                int i3 = func_641_a(EnumSkyBlock.Sky, j2, k2, l2) - j1;
                if(i3 > k1)
                {
                    k1 = i3;
                }
            }

        }
        return k1;
    }

    private int func_35458_d(int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = Block.field_339_t[i1];
        int l1 = func_641_a(EnumSkyBlock.Block, j - 1, k, l) - j1;
        int i2 = func_641_a(EnumSkyBlock.Block, j + 1, k, l) - j1;
        int j2 = func_641_a(EnumSkyBlock.Block, j, k - 1, l) - j1;
        int k2 = func_641_a(EnumSkyBlock.Block, j, k + 1, l) - j1;
        int l2 = func_641_a(EnumSkyBlock.Block, j, k, l - 1) - j1;
        int i3 = func_641_a(EnumSkyBlock.Block, j, k, l + 1) - j1;
        if(l1 > k1)
        {
            k1 = l1;
        }
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
        if(i3 > k1)
        {
            k1 = i3;
        }
        return k1;
    }

    public void func_35459_c(EnumSkyBlock enumskyblock, int i, int j, int k)
    {
        if(!func_21117_a(i, j, k, 17))
        {
            return;
        }
        int l = 0;
        int i1 = 0;
        int j1 = func_641_a(enumskyblock, i, j, k);
        int l1 = 0;
        int j2 = j1;
        int i3 = func_600_a(i, j, k);
        int l3 = Block.field_341_r[i3];
        if(l3 == 0)
        {
            l3 = 1;
        }
        int k4 = 0;
        if(enumskyblock == EnumSkyBlock.Sky)
        {
            k4 = func_35460_a(j2, i, j, k, i3, l3);
        } else
        {
            k4 = func_35458_d(j2, i, j, k, i3, l3);
        }
        l1 = k4;
        if(l1 > j1)
        {
            field_35466_H[i1++] = 0x20820;
        } else
        if(l1 < j1)
        {
            if(enumskyblock == EnumSkyBlock.Block);
            field_35466_H[i1++] = 0x20820 + (j1 << 18);
            do
            {
                if(l >= i1)
                {
                    break;
                }
                int k2 = field_35466_H[l++];
                int j3 = ((k2 & 0x3f) - 32) + i;
                int i4 = ((k2 >> 6 & 0x3f) - 32) + j;
                int l4 = ((k2 >> 12 & 0x3f) - 32) + k;
                int j5 = k2 >> 18 & 0xf;
                int l5 = func_641_a(enumskyblock, j3, i4, l4);
                if(l5 == j5)
                {
                    func_664_b(enumskyblock, j3, i4, l4, 0);
                    if(j5 > 0)
                    {
                        int k6 = j3 - i;
                        int i7 = i4 - j;
                        int k7 = l4 - k;
                        if(k6 < 0)
                        {
                            k6 = -k6;
                        }
                        if(i7 < 0)
                        {
                            i7 = -i7;
                        }
                        if(k7 < 0)
                        {
                            k7 = -k7;
                        }
                        if(k6 + i7 + k7 < 17)
                        {
                            int i8 = 0;
                            while(i8 < 6) 
                            {
                                int j8 = (i8 % 2) * 2 - 1;
                                int k8 = j3 + (((i8 / 2) % 3) / 2) * j8;
                                int l8 = i4 + (((i8 / 2 + 1) % 3) / 2) * j8;
                                int i9 = l4 + (((i8 / 2 + 2) % 3) / 2) * j8;
                                int i6 = func_641_a(enumskyblock, k8, l8, i9);
                                int j9 = Block.field_341_r[func_600_a(k8, l8, i9)];
                                if(j9 == 0)
                                {
                                    j9 = 1;
                                }
                                if(i6 == j5 - j9)
                                {
                                    field_35466_H[i1++] = (k8 - i) + 32 + ((l8 - j) + 32 << 6) + ((i9 - k) + 32 << 12) + (j5 - j9 << 18);
                                }
                                i8++;
                            }
                        }
                    }
                }
            } while(true);
            l = 0;
        }
        do
        {
            if(l >= i1)
            {
                break;
            }
            int k1 = field_35466_H[l++];
            int i2 = ((k1 & 0x3f) - 32) + i;
            int l2 = ((k1 >> 6 & 0x3f) - 32) + j;
            int k3 = ((k1 >> 12 & 0x3f) - 32) + k;
            int j4 = func_641_a(enumskyblock, i2, l2, k3);
            int i5 = func_600_a(i2, l2, k3);
            int k5 = Block.field_341_r[i5];
            if(k5 == 0)
            {
                k5 = 1;
            }
            int j6 = 0;
            if(enumskyblock == EnumSkyBlock.Sky)
            {
                j6 = func_35460_a(j4, i2, l2, k3, i5, k5);
            } else
            {
                j6 = func_35458_d(j4, i2, l2, k3, i5, k5);
            }
            if(j6 != j4)
            {
                func_664_b(enumskyblock, i2, l2, k3, j6);
                if(j6 > j4)
                {
                    int l6 = i2 - i;
                    int j7 = l2 - j;
                    int l7 = k3 - k;
                    if(l6 < 0)
                    {
                        l6 = -l6;
                    }
                    if(j7 < 0)
                    {
                        j7 = -j7;
                    }
                    if(l7 < 0)
                    {
                        l7 = -l7;
                    }
                    if(l6 + j7 + l7 < 17 && i1 < field_35466_H.length - 6)
                    {
                        if(func_641_a(enumskyblock, i2 - 1, l2, k3) < j6)
                        {
                            field_35466_H[i1++] = (i2 - 1 - i) + 32 + ((l2 - j) + 32 << 6) + ((k3 - k) + 32 << 12);
                        }
                        if(func_641_a(enumskyblock, i2 + 1, l2, k3) < j6)
                        {
                            field_35466_H[i1++] = ((i2 + 1) - i) + 32 + ((l2 - j) + 32 << 6) + ((k3 - k) + 32 << 12);
                        }
                        if(func_641_a(enumskyblock, i2, l2 - 1, k3) < j6)
                        {
                            field_35466_H[i1++] = (i2 - i) + 32 + ((l2 - 1 - j) + 32 << 6) + ((k3 - k) + 32 << 12);
                        }
                        if(func_641_a(enumskyblock, i2, l2 + 1, k3) < j6)
                        {
                            field_35466_H[i1++] = (i2 - i) + 32 + (((l2 + 1) - j) + 32 << 6) + ((k3 - k) + 32 << 12);
                        }
                        if(func_641_a(enumskyblock, i2, l2, k3 - 1) < j6)
                        {
                            field_35466_H[i1++] = (i2 - i) + 32 + ((l2 - j) + 32 << 6) + ((k3 - 1 - k) + 32 << 12);
                        }
                        if(func_641_a(enumskyblock, i2, l2, k3 + 1) < j6)
                        {
                            field_35466_H[i1++] = (i2 - i) + 32 + ((l2 - j) + 32 << 6) + (((k3 + 1) - k) + 32 << 12);
                        }
                    }
                }
            }
        } while(true);
    }

    public boolean func_700_a(boolean flag)
    {
        int i = field_1058_B.size();
        if(i != field_1056_C.size())
        {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if(i > 1000)
        {
            i = 1000;
        }
        for(int j = 0; j < i; j++)
        {
            NextTickListEntry nextticklistentry = (NextTickListEntry)field_1058_B.first();
            if(!flag && nextticklistentry.field_1364_e > field_22145_q.func_22304_f())
            {
                break;
            }
            field_1058_B.remove(nextticklistentry);
            field_1056_C.remove(nextticklistentry);
            byte byte0 = 8;
            if(!func_640_a(nextticklistentry.field_1361_a - byte0, nextticklistentry.field_1360_b - byte0, nextticklistentry.field_1366_c - byte0, nextticklistentry.field_1361_a + byte0, nextticklistentry.field_1360_b + byte0, nextticklistentry.field_1366_c + byte0))
            {
                continue;
            }
            int k = func_600_a(nextticklistentry.field_1361_a, nextticklistentry.field_1360_b, nextticklistentry.field_1366_c);
            if(k == nextticklistentry.field_1365_d && k > 0)
            {
                Block.field_345_n[k].func_208_a(this, nextticklistentry.field_1361_a, nextticklistentry.field_1360_b, nextticklistentry.field_1366_c, field_1037_n);
            }
        }

        return field_1058_B.size() != 0;
    }

    public List func_41081_a(Chunk chunk, boolean flag)
    {
        ArrayList arraylist = null;
        ChunkCoordIntPair chunkcoordintpair = chunk.func_40740_k();
        int i = chunkcoordintpair.field_189_a << 4;
        int j = i + 16;
        int k = chunkcoordintpair.field_188_b << 4;
        int l = k + 16;
        Iterator iterator = field_1056_C.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            NextTickListEntry nextticklistentry = (NextTickListEntry)iterator.next();
            if(nextticklistentry.field_1361_a >= i && nextticklistentry.field_1361_a < j && nextticklistentry.field_1366_c >= k && nextticklistentry.field_1366_c < l)
            {
                if(flag)
                {
                    field_1058_B.remove(nextticklistentry);
                    iterator.remove();
                }
                if(arraylist == null)
                {
                    arraylist = new ArrayList();
                }
                arraylist.add(nextticklistentry);
            }
        } while(true);
        return arraylist;
    }

    public void func_677_m(int i, int j, int k)
    {
        byte byte0 = 16;
        Random random = new Random();
        for(int l = 0; l < 1000; l++)
        {
            int i1 = (i + field_1037_n.nextInt(byte0)) - field_1037_n.nextInt(byte0);
            int j1 = (j + field_1037_n.nextInt(byte0)) - field_1037_n.nextInt(byte0);
            int k1 = (k + field_1037_n.nextInt(byte0)) - field_1037_n.nextInt(byte0);
            int l1 = func_600_a(i1, j1, k1);
            if(l1 == 0 && field_1037_n.nextInt(8) > j1 && field_4209_q.func_46064_i())
            {
                func_694_a("depthsuspend", (float)i1 + field_1037_n.nextFloat(), (float)j1 + field_1037_n.nextFloat(), (float)k1 + field_1037_n.nextFloat(), 0.0D, 0.0D, 0.0D);
                continue;
            }
            if(l1 > 0)
            {
                Block.field_345_n[l1].func_247_b(this, i1, j1, k1, random);
            }
        }

    }

    public List func_659_b(Entity entity, AxisAlignedBB axisalignedbb)
    {
        field_1012_M.clear();
        int i = MathHelper.func_1108_b((axisalignedbb.field_1698_a - 2D) / 16D);
        int j = MathHelper.func_1108_b((axisalignedbb.field_1703_d + 2D) / 16D);
        int k = MathHelper.func_1108_b((axisalignedbb.field_1704_c - 2D) / 16D);
        int l = MathHelper.func_1108_b((axisalignedbb.field_1701_f + 2D) / 16D);
        for(int i1 = i; i1 <= j; i1++)
        {
            for(int j1 = k; j1 <= l; j1++)
            {
                if(func_620_h(i1, j1))
                {
                    func_704_b(i1, j1).func_994_a(entity, axisalignedbb, field_1012_M);
                }
            }

        }

        return field_1012_M;
    }

    public List func_657_a(Class class1, AxisAlignedBB axisalignedbb)
    {
        int i = MathHelper.func_1108_b((axisalignedbb.field_1698_a - 2D) / 16D);
        int j = MathHelper.func_1108_b((axisalignedbb.field_1703_d + 2D) / 16D);
        int k = MathHelper.func_1108_b((axisalignedbb.field_1704_c - 2D) / 16D);
        int l = MathHelper.func_1108_b((axisalignedbb.field_1701_f + 2D) / 16D);
        ArrayList arraylist = new ArrayList();
        for(int i1 = i; i1 <= j; i1++)
        {
            for(int j1 = k; j1 <= l; j1++)
            {
                if(func_620_h(i1, j1))
                {
                    func_704_b(i1, j1).func_1013_a(class1, axisalignedbb, arraylist);
                }
            }

        }

        return arraylist;
    }

    public List func_658_i()
    {
        return field_1050_a;
    }

    public void func_698_b(int i, int j, int k, TileEntity tileentity)
    {
        if(func_630_d(i, j, k))
        {
            func_673_a(i, k).func_1006_f();
        }
        for(int l = 0; l < field_9434_r.size(); l++)
        {
            ((IWorldAccess)field_9434_r.get(l)).func_935_a(i, j, k, tileentity);
        }

    }

    public int func_621_b(Class class1)
    {
        int i = 0;
        for(int j = 0; j < field_1050_a.size(); j++)
        {
            Entity entity = (Entity)field_1050_a.get(j);
            if(class1.isAssignableFrom(entity.getClass()))
            {
                i++;
            }
        }

        return i;
    }

    public void func_636_a(List list)
    {
        field_1050_a.addAll(list);
        for(int i = 0; i < list.size(); i++)
        {
            func_606_b((Entity)list.get(i));
        }

    }

    public void func_632_b(List list)
    {
        field_1024_A.addAll(list);
    }

    public void func_656_j()
    {
        while(field_1017_H.func_532_a()) ;
    }

    public boolean func_695_a(int i, int j, int k, int l, boolean flag, int i1)
    {
        int j1 = func_600_a(j, k, l);
        Block block = Block.field_345_n[j1];
        Block block1 = Block.field_345_n[i];
        AxisAlignedBB axisalignedbb = block1.func_221_d(this, j, k, l);
        if(flag)
        {
            axisalignedbb = null;
        }
        if(axisalignedbb != null && !func_604_a(axisalignedbb))
        {
            return false;
        }
        if(block == Block.field_401_B || block == Block.field_399_C || block == Block.field_397_D || block == Block.field_395_E || block == Block.field_402_as || block == Block.field_428_aT || block == Block.field_35278_bv)
        {
            block = null;
        }
        return i > 0 && block == null && block1.func_28030_e(this, j, k, l, i1);
    }

    public PathEntity func_702_a(Entity entity, Entity entity1, float f)
    {
        Profiler.func_40663_a("pathfind");
        int i = MathHelper.func_1108_b(entity.field_611_ak);
        int j = MathHelper.func_1108_b(entity.field_610_al);
        int k = MathHelper.func_1108_b(entity.field_609_am);
        int l = (int)(f + 16F);
        int i1 = i - l;
        int j1 = j - l;
        int k1 = k - l;
        int l1 = i + l;
        int i2 = j + l;
        int j2 = k + l;
        ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i2, j2);
        PathEntity pathentity = (new PathFinder(chunkcache)).func_1137_a(entity, entity1, f);
        Profiler.func_40662_b();
        return pathentity;
    }

    public PathEntity func_637_a(Entity entity, int i, int j, int k, float f)
    {
        Profiler.func_40663_a("pathfind");
        int l = MathHelper.func_1108_b(entity.field_611_ak);
        int i1 = MathHelper.func_1108_b(entity.field_610_al);
        int j1 = MathHelper.func_1108_b(entity.field_609_am);
        int k1 = (int)(f + 8F);
        int l1 = l - k1;
        int i2 = i1 - k1;
        int j2 = j1 - k1;
        int k2 = l + k1;
        int l2 = i1 + k1;
        int i3 = j1 + k1;
        ChunkCache chunkcache = new ChunkCache(this, l1, i2, j2, k2, l2, i3);
        PathEntity pathentity = (new PathFinder(chunkcache)).func_1131_a(entity, i, j, k, f);
        Profiler.func_40662_b();
        return pathentity;
    }

    public boolean func_668_j(int i, int j, int k, int l)
    {
        int i1 = func_600_a(i, j, k);
        if(i1 == 0)
        {
            return false;
        } else
        {
            return Block.field_345_n[i1].func_228_c(this, i, j, k, l);
        }
    }

    public boolean func_646_n(int i, int j, int k)
    {
        if(func_668_j(i, j - 1, k, 0))
        {
            return true;
        }
        if(func_668_j(i, j + 1, k, 1))
        {
            return true;
        }
        if(func_668_j(i, j, k - 1, 2))
        {
            return true;
        }
        if(func_668_j(i, j, k + 1, 3))
        {
            return true;
        }
        if(func_668_j(i - 1, j, k, 4))
        {
            return true;
        }
        return func_668_j(i + 1, j, k, 5);
    }

    public boolean func_706_k(int i, int j, int k, int l)
    {
        if(func_28100_h(i, j, k))
        {
            return func_646_n(i, j, k);
        }
        int i1 = func_600_a(i, j, k);
        if(i1 == 0)
        {
            return false;
        } else
        {
            return Block.field_345_n[i1].func_231_b(this, i, j, k, l);
        }
    }

    public boolean func_625_o(int i, int j, int k)
    {
        if(func_706_k(i, j - 1, k, 0))
        {
            return true;
        }
        if(func_706_k(i, j + 1, k, 1))
        {
            return true;
        }
        if(func_706_k(i, j, k - 1, 2))
        {
            return true;
        }
        if(func_706_k(i, j, k + 1, 3))
        {
            return true;
        }
        if(func_706_k(i - 1, j, k, 4))
        {
            return true;
        }
        return func_706_k(i + 1, j, k, 5);
    }

    public EntityPlayer func_609_a(Entity entity, double d)
    {
        return func_683_a(entity.field_611_ak, entity.field_610_al, entity.field_609_am, d);
    }

    public EntityPlayer func_683_a(double d, double d1, double d2, double d3)
    {
        double d4 = -1D;
        EntityPlayer entityplayer = null;
        for(int i = 0; i < field_1040_k.size(); i++)
        {
            EntityPlayer entityplayer1 = (EntityPlayer)field_1040_k.get(i);
            double d5 = entityplayer1.func_360_d(d, d1, d2);
            if((d3 < 0.0D || d5 < d3 * d3) && (d4 == -1D || d5 < d4))
            {
                d4 = d5;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public EntityPlayer func_40480_b(Entity entity, double d)
    {
        return func_40473_b(entity.field_611_ak, entity.field_610_al, entity.field_609_am, d);
    }

    public EntityPlayer func_40473_b(double d, double d1, double d2, double d3)
    {
        double d4 = -1D;
        EntityPlayer entityplayer = null;
        for(int i = 0; i < field_1040_k.size(); i++)
        {
            EntityPlayer entityplayer1 = (EntityPlayer)field_1040_k.get(i);
            if(entityplayer1.field_35212_aW.field_35759_a)
            {
                continue;
            }
            double d5 = entityplayer1.func_360_d(d, d1, d2);
            if((d3 < 0.0D || d5 < d3 * d3) && (d4 == -1D || d5 < d4))
            {
                d4 = d5;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public EntityPlayer func_25099_a(String s)
    {
        for(int i = 0; i < field_1040_k.size(); i++)
        {
            if(s.equals(((EntityPlayer)field_1040_k.get(i)).field_771_i))
            {
                return (EntityPlayer)field_1040_k.get(i);
            }
        }

        return null;
    }

    public void func_693_a(int i, int j, int k, int l, int i1, int j1, byte abyte0[])
    {
        int k1 = i >> 4;
        int l1 = k >> 4;
        int i2 = (i + l) - 1 >> 4;
        int j2 = (k + j1) - 1 >> 4;
        int k2 = 0;
        int l2 = j;
        int i3 = j + i1;
        if(l2 < 0)
        {
            l2 = 0;
        }
        if(i3 > field_35472_c)
        {
            i3 = field_35472_c;
        }
        for(int j3 = k1; j3 <= i2; j3++)
        {
            int k3 = i - j3 * 16;
            int l3 = (i + l) - j3 * 16;
            if(k3 < 0)
            {
                k3 = 0;
            }
            if(l3 > 16)
            {
                l3 = 16;
            }
            for(int i4 = l1; i4 <= j2; i4++)
            {
                int j4 = k - i4 * 16;
                int k4 = (k + j1) - i4 * 16;
                if(j4 < 0)
                {
                    j4 = 0;
                }
                if(k4 > 16)
                {
                    k4 = 16;
                }
                k2 = func_704_b(j3, i4).func_1004_a(abyte0, k3, l2, j4, l3, i3, k4, k2);
                func_701_b(j3 * 16 + k3, l2, i4 * 16 + j4, j3 * 16 + l3, i3, i4 * 16 + k4);
            }

        }

    }

    public void func_660_k()
    {
    }

    public void func_663_l()
    {
        field_22147_p.func_22150_b();
    }

    public void func_648_a(long l)
    {
        field_22145_q.func_22307_a(l);
    }

    public long func_22138_q()
    {
        return field_22145_q.func_22288_b();
    }

    public long func_22139_r()
    {
        return field_22145_q.func_22304_f();
    }

    public ChunkCoordinates func_22137_s()
    {
        return new ChunkCoordinates(field_22145_q.func_22293_c(), field_22145_q.func_22295_d(), field_22145_q.func_22300_e());
    }

    public void func_22143_a(ChunkCoordinates chunkcoordinates)
    {
        field_22145_q.func_22292_a(chunkcoordinates.field_22395_a, chunkcoordinates.field_22394_b, chunkcoordinates.field_22396_c);
    }

    public void func_705_f(Entity entity)
    {
        int i = MathHelper.func_1108_b(entity.field_611_ak / 16D);
        int j = MathHelper.func_1108_b(entity.field_609_am / 16D);
        byte byte0 = 2;
        for(int k = i - byte0; k <= i + byte0; k++)
        {
            for(int l = j - byte0; l <= j + byte0; l++)
            {
                func_704_b(k, l);
            }

        }

        if(!field_1050_a.contains(entity))
        {
            field_1050_a.add(entity);
        }
    }

    public boolean func_6466_a(EntityPlayer entityplayer, int i, int j, int k)
    {
        return true;
    }

    public void func_9425_a(Entity entity, byte byte0)
    {
    }

    public void func_9424_o()
    {
        field_1050_a.removeAll(field_1024_A);
        for(int i = 0; i < field_1024_A.size(); i++)
        {
            Entity entity = (Entity)field_1024_A.get(i);
            int l = entity.field_657_ba;
            int j1 = entity.field_654_bc;
            if(entity.field_621_aZ && func_620_h(l, j1))
            {
                func_704_b(l, j1).func_1015_b(entity);
            }
        }

        for(int j = 0; j < field_1024_A.size(); j++)
        {
            func_678_c((Entity)field_1024_A.get(j));
        }

        field_1024_A.clear();
        for(int k = 0; k < field_1050_a.size(); k++)
        {
            Entity entity1 = (Entity)field_1050_a.get(k);
            if(entity1.field_616_af != null)
            {
                if(!entity1.field_616_af.field_646_aA && entity1.field_616_af.field_617_ae == entity1)
                {
                    continue;
                }
                entity1.field_616_af.field_617_ae = null;
                entity1.field_616_af = null;
            }
            if(!entity1.field_646_aA)
            {
                continue;
            }
            int i1 = entity1.field_657_ba;
            int k1 = entity1.field_654_bc;
            if(entity1.field_621_aZ && func_620_h(i1, k1))
            {
                func_704_b(i1, k1).func_1015_b(entity1);
            }
            field_1050_a.remove(k--);
            func_678_c(entity1);
        }

    }

    public IChunkProvider func_21118_q()
    {
        return field_1017_H;
    }

    public void func_21116_c(int i, int j, int k, int l, int i1)
    {
        int j1 = func_600_a(i, j, k);
        if(j1 > 0)
        {
            Block.field_345_n[j1].func_21024_a(this, i, j, k, l, i1);
        }
    }

    public ISaveHandler func_40479_y()
    {
        return field_22147_p;
    }

    public WorldInfo func_22144_v()
    {
        return field_22145_q;
    }

    public void func_22140_w()
    {
        field_22146_A = !field_1040_k.isEmpty();
        Iterator iterator = field_1040_k.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();
            if(entityplayer.func_22051_K())
            {
                continue;
            }
            field_22146_A = false;
            break;
        } while(true);
    }

    protected void func_22141_x()
    {
        field_22146_A = false;
        Iterator iterator = field_1040_k.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();
            if(entityplayer.func_22051_K())
            {
                entityplayer.func_22056_a(false, false, true);
            }
        } while(true);
        func_27164_F();
    }

    public boolean func_22142_y()
    {
        if(field_22146_A && !field_1026_y)
        {
            for(Iterator iterator = field_1040_k.iterator(); iterator.hasNext();)
            {
                EntityPlayer entityplayer = (EntityPlayer)iterator.next();
                if(!entityplayer.func_22054_L())
                {
                    return false;
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

    public float func_27166_f(float f)
    {
        return (field_27170_D + (field_27169_E - field_27170_D) * f) * func_27162_g(f);
    }

    public float func_27162_g(float f)
    {
        return field_26901_B + (field_27171_C - field_26901_B) * f;
    }

    public void func_27158_h(float f)
    {
        field_26901_B = f;
        field_27171_C = f;
    }

    public boolean func_27160_B()
    {
        return (double)func_27166_f(1.0F) > 0.90000000000000002D;
    }

    public boolean func_27161_C()
    {
        return (double)func_27162_g(1.0F) > 0.20000000000000001D;
    }

    public boolean func_27167_r(int i, int j, int k)
    {
        if(!func_27161_C())
        {
            return false;
        }
        if(!func_647_i(i, j, k))
        {
            return false;
        }
        if(func_35461_e(i, k) > j)
        {
            return false;
        }
        BiomeGenBase biomegenbase = func_4075_a().func_4073_a(i, k);
        if(biomegenbase.func_27078_c())
        {
            return false;
        } else
        {
            return biomegenbase.func_27077_d();
        }
    }

    public void func_28102_a(String s, WorldSavedData worldsaveddata)
    {
        field_28108_z.func_28184_a(s, worldsaveddata);
    }

    public WorldSavedData func_28103_a(Class class1, String s)
    {
        return field_28108_z.func_28185_a(class1, s);
    }

    public int func_28101_b(String s)
    {
        return field_28108_z.func_28186_a(s);
    }

    public void func_28106_e(int i, int j, int k, int l, int i1)
    {
        func_28107_a(null, i, j, k, l, i1);
    }

    public void func_28107_a(EntityPlayer entityplayer, int i, int j, int k, int l, int i1)
    {
        for(int j1 = 0; j1 < field_9434_r.size(); j1++)
        {
            ((IWorldAccess)field_9434_r.get(j1)).func_28136_a(entityplayer, i, j, k, l, i1);
        }

    }

    public int func_35452_b()
    {
        return field_35472_c;
    }

    public Random func_35462_u(int i, int j, int k)
    {
        long l = (long)i * 0x4f9939f508L + (long)j * 0x1ef1565bd5L + func_22144_v().func_22288_b() + (long)k;
        field_1037_n.setSeed(l);
        return field_1037_n;
    }

    public boolean func_6465_g()
    {
        return false;
    }

    public void func_616_a(EnumSkyBlock enumskyblock, int i, int j, int k, int l, int i1, int j1)
    {
    }

    public SpawnListEntry func_40474_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        List list = func_21118_q().func_40377_a(enumcreaturetype, i, j, k);
        if(list == null || list.isEmpty())
        {
            return null;
        } else
        {
            return (SpawnListEntry)WeightedRandom.func_35733_a(field_1037_n, list);
        }
    }

    public ChunkPosition func_40477_b(String s, int i, int j, int k)
    {
        return func_21118_q().func_40376_a(this, s, i, j, k);
    }

    public double func_46068_G()
    {
        return field_22145_q.func_46133_t() != EnumWorldType.FLAT ? 63D : 0.0D;
    }
}

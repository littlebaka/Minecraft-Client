// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, SaveHandlerMP, WorldProvider, IntHashMap, 
//            ChunkCoordinates, NetClientHandler, Entity, WorldBlockPositionType, 
//            ChunkProviderClient, Packet255KickDisconnect, WorldInfo, WorldSettings, 
//            IChunkProvider

public class WorldClient extends World
{

    private LinkedList field_1057_z;
    private NetClientHandler field_1052_A;
    private ChunkProviderClient field_20915_C;
    private IntHashMap field_1055_D;
    private Set field_20914_E;
    private Set field_1053_F;

    public WorldClient(NetClientHandler netclienthandler, WorldSettings worldsettings, int i, int j)
    {
        super(new SaveHandlerMP(), "MpServer", WorldProvider.func_4101_a(i), worldsettings);
        field_1057_z = new LinkedList();
        field_1055_D = new IntHashMap();
        field_20914_E = new HashSet();
        field_1053_F = new HashSet();
        field_1052_A = netclienthandler;
        field_1039_l = j;
        func_22143_a(new ChunkCoordinates(8, 64, 8));
        field_28108_z = netclienthandler.field_28118_b;
    }

    public void func_649_g()
    {
        func_648_a(func_22139_r() + 1L);
        for(int i = 0; i < 10 && !field_1053_F.isEmpty(); i++)
        {
            Entity entity = (Entity)field_1053_F.iterator().next();
            field_1053_F.remove(entity);
            if(!field_1050_a.contains(entity))
            {
                func_674_a(entity);
            }
        }

        field_1052_A.func_848_a();
        for(int j = 0; j < field_1057_z.size(); j++)
        {
            WorldBlockPositionType worldblockpositiontype = (WorldBlockPositionType)field_1057_z.get(j);
            if(--worldblockpositiontype.field_1206_d == 0)
            {
                super.func_643_a(worldblockpositiontype.field_1202_a, worldblockpositiontype.field_1201_b, worldblockpositiontype.field_1207_c, worldblockpositiontype.field_1205_e, worldblockpositiontype.field_1204_f);
                super.func_665_h(worldblockpositiontype.field_1202_a, worldblockpositiontype.field_1201_b, worldblockpositiontype.field_1207_c);
                field_1057_z.remove(j--);
            }
        }

    }

    public void func_711_c(int i, int j, int k, int l, int i1, int j1)
    {
        for(int k1 = 0; k1 < field_1057_z.size(); k1++)
        {
            WorldBlockPositionType worldblockpositiontype = (WorldBlockPositionType)field_1057_z.get(k1);
            if(worldblockpositiontype.field_1202_a >= i && worldblockpositiontype.field_1201_b >= j && worldblockpositiontype.field_1207_c >= k && worldblockpositiontype.field_1202_a <= l && worldblockpositiontype.field_1201_b <= i1 && worldblockpositiontype.field_1207_c <= j1)
            {
                field_1057_z.remove(k1--);
            }
        }

    }

    protected IChunkProvider func_4081_a()
    {
        field_20915_C = new ChunkProviderClient(this);
        return field_20915_C;
    }

    public void func_4076_b()
    {
        func_22143_a(new ChunkCoordinates(8, 64, 8));
    }

    protected void func_4080_j()
    {
    }

    public void func_22136_c(int i, int j, int k, int l, int i1)
    {
    }

    public boolean func_700_a(boolean flag)
    {
        return false;
    }

    public void func_713_a(int i, int j, boolean flag)
    {
        if(flag)
        {
            field_20915_C.func_538_d(i, j);
        } else
        {
            field_20915_C.func_539_c(i, j);
        }
        if(!flag)
        {
            func_701_b(i * 16, 0, j * 16, i * 16 + 15, field_35472_c, j * 16 + 15);
        }
    }

    public boolean func_674_a(Entity entity)
    {
        boolean flag = super.func_674_a(entity);
        field_20914_E.add(entity);
        if(!flag)
        {
            field_1053_F.add(entity);
        }
        return flag;
    }

    public void func_607_d(Entity entity)
    {
        super.func_607_d(entity);
        field_20914_E.remove(entity);
    }

    protected void func_606_b(Entity entity)
    {
        super.func_606_b(entity);
        if(field_1053_F.contains(entity))
        {
            field_1053_F.remove(entity);
        }
    }

    protected void func_678_c(Entity entity)
    {
        super.func_678_c(entity);
        if(field_20914_E.contains(entity))
        {
            field_1053_F.add(entity);
        }
    }

    public void func_712_a(int i, Entity entity)
    {
        Entity entity1 = func_709_b(i);
        if(entity1 != null)
        {
            func_607_d(entity1);
        }
        field_20914_E.add(entity);
        entity.field_620_ab = i;
        if(!func_674_a(entity))
        {
            field_1053_F.add(entity);
        }
        field_1055_D.func_1061_a(i, entity);
    }

    public Entity func_709_b(int i)
    {
        return (Entity)field_1055_D.func_1057_a(i);
    }

    public Entity func_710_c(int i)
    {
        Entity entity = (Entity)field_1055_D.func_1052_b(i);
        if(entity != null)
        {
            field_20914_E.remove(entity);
            func_607_d(entity);
        }
        return entity;
    }

    public boolean func_635_c(int i, int j, int k, int l)
    {
        int i1 = func_600_a(i, j, k);
        int j1 = func_602_e(i, j, k);
        if(super.func_635_c(i, j, k, l))
        {
            field_1057_z.add(new WorldBlockPositionType(this, i, j, k, i1, j1));
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_643_a(int i, int j, int k, int l, int i1)
    {
        int j1 = func_600_a(i, j, k);
        int k1 = func_602_e(i, j, k);
        if(super.func_643_a(i, j, k, l, i1))
        {
            field_1057_z.add(new WorldBlockPositionType(this, i, j, k, j1, k1));
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_634_a(int i, int j, int k, int l)
    {
        int i1 = func_600_a(i, j, k);
        int j1 = func_602_e(i, j, k);
        if(super.func_634_a(i, j, k, l))
        {
            field_1057_z.add(new WorldBlockPositionType(this, i, j, k, i1, j1));
            return true;
        } else
        {
            return false;
        }
    }

    public boolean func_714_c(int i, int j, int k, int l, int i1)
    {
        func_711_c(i, j, k, i, j, k);
        if(super.func_643_a(i, j, k, l, i1))
        {
            func_617_e(i, j, k, l);
            return true;
        } else
        {
            return false;
        }
    }

    public void func_660_k()
    {
        field_1052_A.func_28117_a(new Packet255KickDisconnect("Quitting"));
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
}

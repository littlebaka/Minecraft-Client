// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EnumWorldType, NBTTagCompound, WorldSettings, EntityPlayer

public class WorldInfo
{

    private long field_22320_a;
    private EnumWorldType field_46134_b;
    private int field_22319_b;
    private int field_22318_c;
    private int field_22317_d;
    private long field_22316_e;
    private long field_22315_f;
    private long field_22314_g;
    private NBTTagCompound field_22313_h;
    private int field_22312_i;
    private String field_22311_j;
    private int field_22310_k;
    private boolean field_27404_l;
    private int field_27403_m;
    private boolean field_27402_n;
    private int field_27401_o;
    private int field_35920_p;
    private boolean field_35919_q;
    private boolean field_40725_r;

    public WorldInfo(NBTTagCompound nbttagcompound)
    {
        field_46134_b = EnumWorldType.DEFAULT;
        field_40725_r = false;
        field_22320_a = nbttagcompound.func_764_f("RandomSeed");
        if(nbttagcompound.func_751_b("generatorName"))
        {
            String s = nbttagcompound.func_755_i("generatorName");
            field_46134_b = EnumWorldType.func_46135_a(s);
            if(field_46134_b == null)
            {
                field_46134_b = EnumWorldType.DEFAULT;
            }
        }
        field_35920_p = nbttagcompound.func_756_e("GameType");
        if(nbttagcompound.func_751_b("MapFeatures"))
        {
            field_35919_q = nbttagcompound.func_760_m("MapFeatures");
        } else
        {
            field_35919_q = true;
        }
        field_22319_b = nbttagcompound.func_756_e("SpawnX");
        field_22318_c = nbttagcompound.func_756_e("SpawnY");
        field_22317_d = nbttagcompound.func_756_e("SpawnZ");
        field_22316_e = nbttagcompound.func_764_f("Time");
        field_22315_f = nbttagcompound.func_764_f("LastPlayed");
        field_22314_g = nbttagcompound.func_764_f("SizeOnDisk");
        field_22311_j = nbttagcompound.func_755_i("LevelName");
        field_22310_k = nbttagcompound.func_756_e("version");
        field_27403_m = nbttagcompound.func_756_e("rainTime");
        field_27404_l = nbttagcompound.func_760_m("raining");
        field_27401_o = nbttagcompound.func_756_e("thunderTime");
        field_27402_n = nbttagcompound.func_760_m("thundering");
        field_40725_r = nbttagcompound.func_760_m("hardcore");
        if(nbttagcompound.func_751_b("Player"))
        {
            field_22313_h = nbttagcompound.func_743_k("Player");
            field_22312_i = field_22313_h.func_756_e("Dimension");
        }
    }

    public WorldInfo(WorldSettings worldsettings, String s)
    {
        field_46134_b = EnumWorldType.DEFAULT;
        field_40725_r = false;
        field_22320_a = worldsettings.func_35518_a();
        field_35920_p = worldsettings.func_35519_b();
        field_35919_q = worldsettings.func_35520_c();
        field_22311_j = s;
        field_40725_r = worldsettings.func_40557_c();
        field_46134_b = worldsettings.func_46107_e();
    }

    public WorldInfo(WorldInfo worldinfo)
    {
        field_46134_b = EnumWorldType.DEFAULT;
        field_40725_r = false;
        field_22320_a = worldinfo.field_22320_a;
        field_46134_b = worldinfo.field_46134_b;
        field_35920_p = worldinfo.field_35920_p;
        field_35919_q = worldinfo.field_35919_q;
        field_22319_b = worldinfo.field_22319_b;
        field_22318_c = worldinfo.field_22318_c;
        field_22317_d = worldinfo.field_22317_d;
        field_22316_e = worldinfo.field_22316_e;
        field_22315_f = worldinfo.field_22315_f;
        field_22314_g = worldinfo.field_22314_g;
        field_22313_h = worldinfo.field_22313_h;
        field_22312_i = worldinfo.field_22312_i;
        field_22311_j = worldinfo.field_22311_j;
        field_22310_k = worldinfo.field_22310_k;
        field_27403_m = worldinfo.field_27403_m;
        field_27404_l = worldinfo.field_27404_l;
        field_27401_o = worldinfo.field_27401_o;
        field_27402_n = worldinfo.field_27402_n;
        field_40725_r = worldinfo.field_40725_r;
    }

    public NBTTagCompound func_22299_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        func_22291_a(nbttagcompound, field_22313_h);
        return nbttagcompound;
    }

    public NBTTagCompound func_22305_a(List list)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        EntityPlayer entityplayer = null;
        NBTTagCompound nbttagcompound1 = null;
        if(list.size() > 0)
        {
            entityplayer = (EntityPlayer)list.get(0);
        }
        if(entityplayer != null)
        {
            nbttagcompound1 = new NBTTagCompound();
            entityplayer.func_363_d(nbttagcompound1);
        }
        func_22291_a(nbttagcompound, nbttagcompound1);
        return nbttagcompound;
    }

    private void func_22291_a(NBTTagCompound nbttagcompound, NBTTagCompound nbttagcompound1)
    {
        nbttagcompound.func_750_a("RandomSeed", field_22320_a);
        nbttagcompound.func_754_a("generatorName", field_46134_b.name());
        nbttagcompound.func_758_a("GameType", field_35920_p);
        nbttagcompound.func_748_a("MapFeatures", field_35919_q);
        nbttagcompound.func_758_a("SpawnX", field_22319_b);
        nbttagcompound.func_758_a("SpawnY", field_22318_c);
        nbttagcompound.func_758_a("SpawnZ", field_22317_d);
        nbttagcompound.func_750_a("Time", field_22316_e);
        nbttagcompound.func_750_a("SizeOnDisk", field_22314_g);
        nbttagcompound.func_750_a("LastPlayed", System.currentTimeMillis());
        nbttagcompound.func_754_a("LevelName", field_22311_j);
        nbttagcompound.func_758_a("version", field_22310_k);
        nbttagcompound.func_758_a("rainTime", field_27403_m);
        nbttagcompound.func_748_a("raining", field_27404_l);
        nbttagcompound.func_758_a("thunderTime", field_27401_o);
        nbttagcompound.func_748_a("thundering", field_27402_n);
        nbttagcompound.func_748_a("hardcore", field_40725_r);
        if(nbttagcompound1 != null)
        {
            nbttagcompound.func_763_a("Player", nbttagcompound1);
        }
    }

    public long func_22288_b()
    {
        return field_22320_a;
    }

    public int func_22293_c()
    {
        return field_22319_b;
    }

    public int func_22295_d()
    {
        return field_22318_c;
    }

    public int func_22300_e()
    {
        return field_22317_d;
    }

    public long func_22304_f()
    {
        return field_22316_e;
    }

    public long func_22306_g()
    {
        return field_22314_g;
    }

    public NBTTagCompound func_22303_h()
    {
        return field_22313_h;
    }

    public int func_22290_i()
    {
        return field_22312_i;
    }

    public void func_22294_a(int i)
    {
        field_22319_b = i;
    }

    public void func_22308_b(int i)
    {
        field_22318_c = i;
    }

    public void func_22298_c(int i)
    {
        field_22317_d = i;
    }

    public void func_22307_a(long l)
    {
        field_22316_e = l;
    }

    public void func_22297_b(long l)
    {
        field_22314_g = l;
    }

    public void func_22309_a(NBTTagCompound nbttagcompound)
    {
        field_22313_h = nbttagcompound;
    }

    public void func_22292_a(int i, int j, int k)
    {
        field_22319_b = i;
        field_22318_c = j;
        field_22317_d = k;
    }

    public String func_22302_j()
    {
        return field_22311_j;
    }

    public void func_22287_a(String s)
    {
        field_22311_j = s;
    }

    public int func_22296_k()
    {
        return field_22310_k;
    }

    public void func_22289_d(int i)
    {
        field_22310_k = i;
    }

    public long func_22301_l()
    {
        return field_22315_f;
    }

    public boolean func_27396_m()
    {
        return field_27402_n;
    }

    public void func_27398_a(boolean flag)
    {
        field_27402_n = flag;
    }

    public int func_27400_n()
    {
        return field_27401_o;
    }

    public void func_27399_e(int i)
    {
        field_27401_o = i;
    }

    public boolean func_27397_o()
    {
        return field_27404_l;
    }

    public void func_27394_b(boolean flag)
    {
        field_27404_l = flag;
    }

    public int func_27393_p()
    {
        return field_27403_m;
    }

    public void func_27395_f(int i)
    {
        field_27403_m = i;
    }

    public int func_35918_q()
    {
        return field_35920_p;
    }

    public boolean func_35917_r()
    {
        return field_35919_q;
    }

    public boolean func_40724_s()
    {
        return field_40725_r;
    }

    public EnumWorldType func_46133_t()
    {
        return field_46134_b;
    }
}

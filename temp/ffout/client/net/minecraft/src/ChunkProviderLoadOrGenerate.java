// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, Chunk, World, IChunkLoader, 
//            IProgressUpdate, EnumCreatureType, ChunkPosition

public class ChunkProviderLoadOrGenerate
    implements IChunkProvider
{

    private Chunk field_897_c;
    private IChunkProvider field_896_d;
    private IChunkLoader field_895_e;
    private Chunk field_894_f[];
    private World field_893_g;
    int field_891_a;
    int field_890_b;
    private Chunk field_892_h;
    private int field_21113_i;
    private int field_21112_j;

    public void func_21110_c(int i, int j)
    {
        field_21113_i = i;
        field_21112_j = j;
    }

    public boolean func_21111_d(int i, int j)
    {
        byte byte0 = 15;
        return i >= field_21113_i - byte0 && j >= field_21112_j - byte0 && i <= field_21113_i + byte0 && j <= field_21112_j + byte0;
    }

    public boolean func_537_a(int i, int j)
    {
        if(!func_21111_d(i, j))
        {
            return false;
        }
        if(i == field_891_a && j == field_890_b && field_892_h != null)
        {
            return true;
        } else
        {
            int k = i & 0x1f;
            int l = j & 0x1f;
            int i1 = k + l * 32;
            return field_894_f[i1] != null && (field_894_f[i1] == field_897_c || field_894_f[i1].func_1017_a(i, j));
        }
    }

    public Chunk func_538_d(int i, int j)
    {
        return func_533_b(i, j);
    }

    public Chunk func_533_b(int i, int j)
    {
        if(i == field_891_a && j == field_890_b && field_892_h != null)
        {
            return field_892_h;
        }
        if(!field_893_g.field_9430_x && !func_21111_d(i, j))
        {
            return field_897_c;
        }
        int k = i & 0x1f;
        int l = j & 0x1f;
        int i1 = k + l * 32;
        if(!func_537_a(i, j))
        {
            if(field_894_f[i1] != null)
            {
                field_894_f[i1].func_998_e();
                func_540_b(field_894_f[i1]);
                func_541_a(field_894_f[i1]);
            }
            Chunk chunk = func_542_c(i, j);
            if(chunk == null)
            {
                if(field_896_d == null)
                {
                    chunk = field_897_c;
                } else
                {
                    chunk = field_896_d.func_533_b(i, j);
                    chunk.func_25124_i();
                }
            }
            field_894_f[i1] = chunk;
            chunk.func_4143_d();
            if(field_894_f[i1] != null)
            {
                field_894_f[i1].func_995_d();
            }
            field_894_f[i1].func_35843_a(this, this, i, j);
        }
        field_891_a = i;
        field_890_b = j;
        field_892_h = field_894_f[i1];
        return field_894_f[i1];
    }

    private Chunk func_542_c(int i, int j)
    {
        if(field_895_e == null)
        {
            return field_897_c;
        }
        try
        {
            Chunk chunk = field_895_e.func_813_a(field_893_g, i, j);
            if(chunk != null)
            {
                chunk.field_1522_s = field_893_g.func_22139_r();
            }
            return chunk;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return field_897_c;
    }

    private void func_541_a(Chunk chunk)
    {
        if(field_895_e == null)
        {
            return;
        }
        try
        {
            field_895_e.func_815_b(field_893_g, chunk);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_540_b(Chunk chunk)
    {
        if(field_895_e == null)
        {
            return;
        }
        try
        {
            chunk.field_1522_s = field_893_g.func_22139_r();
            field_895_e.func_812_a(field_893_g, chunk);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void func_534_a(IChunkProvider ichunkprovider, int i, int j)
    {
        Chunk chunk = func_533_b(i, j);
        if(!chunk.field_1527_n)
        {
            chunk.field_1527_n = true;
            if(field_896_d != null)
            {
                field_896_d.func_534_a(ichunkprovider, i, j);
                chunk.func_1006_f();
            }
        }
    }

    public boolean func_535_a(boolean flag, IProgressUpdate iprogressupdate)
    {
        int i = 0;
        int j = 0;
        if(iprogressupdate != null)
        {
            for(int k = 0; k < field_894_f.length; k++)
            {
                if(field_894_f[k] != null && field_894_f[k].func_1012_a(flag))
                {
                    j++;
                }
            }

        }
        int l = 0;
        for(int i1 = 0; i1 < field_894_f.length; i1++)
        {
            if(field_894_f[i1] == null)
            {
                continue;
            }
            if(flag && !field_894_f[i1].field_1525_p)
            {
                func_541_a(field_894_f[i1]);
            }
            if(!field_894_f[i1].func_1012_a(flag))
            {
                continue;
            }
            func_540_b(field_894_f[i1]);
            field_894_f[i1].field_1526_o = false;
            if(++i == 2 && !flag)
            {
                return false;
            }
            if(iprogressupdate != null && ++l % 10 == 0)
            {
                iprogressupdate.func_593_a((l * 100) / j);
            }
        }

        if(flag)
        {
            if(field_895_e == null)
            {
                return true;
            }
            field_895_e.func_811_b();
        }
        return true;
    }

    public boolean func_532_a()
    {
        if(field_895_e != null)
        {
            field_895_e.func_814_a();
        }
        return field_896_d.func_532_a();
    }

    public boolean func_536_b()
    {
        return true;
    }

    public String func_21109_c()
    {
        return (new StringBuilder()).append("ChunkCache: ").append(field_894_f.length).toString();
    }

    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        return field_896_d.func_40377_a(enumcreaturetype, i, j, k);
    }

    public ChunkPosition func_40376_a(World world, String s, int i, int j, int k)
    {
        return field_896_d.func_40376_a(world, s, i, j, k);
    }
}

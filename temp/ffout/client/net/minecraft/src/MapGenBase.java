// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            World, IChunkProvider

public class MapGenBase
{

    protected int field_1306_a;
    protected Random field_1305_b;
    protected World field_35625_d;

    public MapGenBase()
    {
        field_1306_a = 8;
        field_1305_b = new Random();
    }

    public void func_867_a(IChunkProvider ichunkprovider, World world, int i, int j, byte abyte0[])
    {
        int k = field_1306_a;
        field_35625_d = world;
        field_1305_b.setSeed(world.func_22138_q());
        long l = field_1305_b.nextLong();
        long l1 = field_1305_b.nextLong();
        for(int i1 = i - k; i1 <= i + k; i1++)
        {
            for(int j1 = j - k; j1 <= j + k; j1++)
            {
                long l2 = (long)i1 * l;
                long l3 = (long)j1 * l1;
                field_1305_b.setSeed(l2 ^ l3 ^ world.func_22138_q());
                func_868_a(world, i1, j1, i, j, abyte0);
            }

        }

    }

    protected void func_868_a(World world, int i, int j, int k, int l, byte abyte0[])
    {
    }
}

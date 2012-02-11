// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.ByteArrayOutputStream;

// Referenced classes of package net.minecraft.src:
//            RegionFile

class RegionFileChunkBuffer extends ByteArrayOutputStream
{

    private int field_22283_b;
    private int field_22285_c;
    final RegionFile field_22284_a; /* synthetic field */

    public RegionFileChunkBuffer(RegionFile regionfile, int i, int j)
    {
        field_22284_a = regionfile;
        super(8096);
        field_22283_b = i;
        field_22285_c = j;
    }

    public void close()
    {
        field_22284_a.func_22203_a(field_22283_b, field_22285_c, buf, count);
    }
}

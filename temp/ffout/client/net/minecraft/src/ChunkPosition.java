// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Vec3D, MathHelper

public class ChunkPosition
{

    public final int field_1111_a;
    public final int field_1110_b;
    public final int field_1112_c;

    public ChunkPosition(int i, int j, int k)
    {
        field_1111_a = i;
        field_1110_b = j;
        field_1112_c = k;
    }

    public ChunkPosition(Vec3D vec3d)
    {
        this(MathHelper.func_1108_b(vec3d.field_1776_a), MathHelper.func_1108_b(vec3d.field_1775_b), MathHelper.func_1108_b(vec3d.field_1779_c));
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof ChunkPosition)
        {
            ChunkPosition chunkposition = (ChunkPosition)obj;
            return chunkposition.field_1111_a == field_1111_a && chunkposition.field_1110_b == field_1110_b && chunkposition.field_1112_c == field_1112_c;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return field_1111_a * 0x88f9fa + field_1110_b * 0xef88b + field_1112_c;
    }
}

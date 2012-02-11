// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PathPoint, Entity, Vec3D

public class PathEntity
{

    private final PathPoint field_1764_b[];
    public final int field_1765_a;
    private int field_1766_c;

    public PathEntity(PathPoint apathpoint[])
    {
        field_1764_b = apathpoint;
        field_1765_a = apathpoint.length;
    }

    public void func_1206_a()
    {
        field_1766_c++;
    }

    public boolean func_1207_b()
    {
        return field_1766_c >= field_1764_b.length;
    }

    public Vec3D func_1205_a(Entity entity)
    {
        double d = (double)field_1764_b[field_1766_c].field_1718_a + (double)(int)(entity.field_644_aC + 1.0F) * 0.5D;
        double d1 = field_1764_b[field_1766_c].field_1717_b;
        double d2 = (double)field_1764_b[field_1766_c].field_1716_c + (double)(int)(entity.field_644_aC + 1.0F) * 0.5D;
        return Vec3D.func_1248_b(d, d1, d2);
    }
}

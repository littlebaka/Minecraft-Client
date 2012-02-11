// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EnumMovingObjectType, Vec3D, Entity

public class MovingObjectPosition
{

    public EnumMovingObjectType field_1167_a;
    public int field_1166_b;
    public int field_1172_c;
    public int field_1171_d;
    public int field_1170_e;
    public Vec3D field_1169_f;
    public Entity field_1168_g;

    public MovingObjectPosition(int i, int j, int k, int l, Vec3D vec3d)
    {
        field_1167_a = EnumMovingObjectType.TILE;
        field_1166_b = i;
        field_1172_c = j;
        field_1171_d = k;
        field_1170_e = l;
        field_1169_f = Vec3D.func_1248_b(vec3d.field_1776_a, vec3d.field_1775_b, vec3d.field_1779_c);
    }

    public MovingObjectPosition(Entity entity)
    {
        field_1167_a = EnumMovingObjectType.ENTITY;
        field_1168_g = entity;
        field_1169_f = Vec3D.func_1248_b(entity.field_611_ak, entity.field_610_al, entity.field_609_am);
    }
}

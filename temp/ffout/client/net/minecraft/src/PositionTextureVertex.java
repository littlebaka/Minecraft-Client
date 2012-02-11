// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Vec3D

public class PositionTextureVertex
{

    public Vec3D field_1655_a;
    public float field_1654_b;
    public float field_1656_c;

    public PositionTextureVertex(float f, float f1, float f2, float f3, float f4)
    {
        this(Vec3D.func_1260_a(f, f1, f2), f3, f4);
    }

    public PositionTextureVertex func_1115_a(float f, float f1)
    {
        return new PositionTextureVertex(this, f, f1);
    }

    public PositionTextureVertex(PositionTextureVertex positiontexturevertex, float f, float f1)
    {
        field_1655_a = positiontexturevertex.field_1655_a;
        field_1654_b = f;
        field_1656_c = f1;
    }

    public PositionTextureVertex(Vec3D vec3d, float f, float f1)
    {
        field_1655_a = vec3d;
        field_1654_b = f;
        field_1656_c = f1;
    }
}

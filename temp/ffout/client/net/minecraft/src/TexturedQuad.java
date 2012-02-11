// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PositionTextureVertex, Vec3D, Tessellator

public class TexturedQuad
{

    public PositionTextureVertex field_1195_a[];
    public int field_1194_b;
    private boolean field_1196_c;

    public TexturedQuad(PositionTextureVertex apositiontexturevertex[])
    {
        field_1194_b = 0;
        field_1196_c = false;
        field_1195_a = apositiontexturevertex;
        field_1194_b = apositiontexturevertex.length;
    }

    public TexturedQuad(PositionTextureVertex apositiontexturevertex[], int i, int j, int k, int l, float f, float f1)
    {
        this(apositiontexturevertex);
        float f2 = 0.0F / f;
        float f3 = 0.0F / f1;
        apositiontexturevertex[0] = apositiontexturevertex[0].func_1115_a((float)k / f - f2, (float)j / f1 + f3);
        apositiontexturevertex[1] = apositiontexturevertex[1].func_1115_a((float)i / f + f2, (float)j / f1 + f3);
        apositiontexturevertex[2] = apositiontexturevertex[2].func_1115_a((float)i / f + f2, (float)l / f1 - f3);
        apositiontexturevertex[3] = apositiontexturevertex[3].func_1115_a((float)k / f - f2, (float)l / f1 - f3);
    }

    public void func_809_a()
    {
        PositionTextureVertex apositiontexturevertex[] = new PositionTextureVertex[field_1195_a.length];
        for(int i = 0; i < field_1195_a.length; i++)
        {
            apositiontexturevertex[i] = field_1195_a[field_1195_a.length - i - 1];
        }

        field_1195_a = apositiontexturevertex;
    }

    public void func_808_a(Tessellator tessellator, float f)
    {
        Vec3D vec3d = field_1195_a[1].field_1655_a.func_1262_a(field_1195_a[0].field_1655_a);
        Vec3D vec3d1 = field_1195_a[1].field_1655_a.func_1262_a(field_1195_a[2].field_1655_a);
        Vec3D vec3d2 = vec3d1.func_1246_b(vec3d).func_1252_b();
        tessellator.func_977_b();
        if(field_1196_c)
        {
            tessellator.func_980_b(-(float)vec3d2.field_1776_a, -(float)vec3d2.field_1775_b, -(float)vec3d2.field_1779_c);
        } else
        {
            tessellator.func_980_b((float)vec3d2.field_1776_a, (float)vec3d2.field_1775_b, (float)vec3d2.field_1779_c);
        }
        for(int i = 0; i < 4; i++)
        {
            PositionTextureVertex positiontexturevertex = field_1195_a[i];
            tessellator.func_983_a((float)positiontexturevertex.field_1655_a.field_1776_a * f, (float)positiontexturevertex.field_1655_a.field_1775_b * f, (float)positiontexturevertex.field_1655_a.field_1779_c * f, positiontexturevertex.field_1654_b, positiontexturevertex.field_1656_c);
        }

        tessellator.func_982_a();
    }
}

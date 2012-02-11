// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelMagmaCube, EntityMagmaCube, EntityLiving, 
//            Entity

public class RenderMagmaCube extends RenderLiving
{

    private int field_40276_c;

    public RenderMagmaCube()
    {
        super(new ModelMagmaCube(), 0.25F);
        field_40276_c = ((ModelMagmaCube)field_20920_e).func_40343_a();
    }

    public void func_40275_a(EntityMagmaCube entitymagmacube, double d, double d1, double d2, 
            float f, float f1)
    {
        int i = ((ModelMagmaCube)field_20920_e).func_40343_a();
        if(i != field_40276_c)
        {
            field_40276_c = i;
            field_20920_e = new ModelMagmaCube();
            System.out.println("new lava slime model");
        }
        super.func_171_a(entitymagmacube, d, d1, d2, f, f1);
    }

    protected void func_40274_a(EntityMagmaCube entitymagmacube, float f)
    {
        int i = entitymagmacube.func_25027_v();
        float f1 = (entitymagmacube.field_767_b + (entitymagmacube.field_768_a - entitymagmacube.field_767_b) * f) / ((float)i * 0.5F + 1.0F);
        float f2 = 1.0F / (f1 + 1.0F);
        float f3 = i;
        GL11.glScalef(f2 * f3, (1.0F / f2) * f3, f2 * f3);
    }

    protected void func_6330_a(EntityLiving entityliving, float f)
    {
        func_40274_a((EntityMagmaCube)entityliving, f);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40275_a((EntityMagmaCube)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40275_a((EntityMagmaCube)entity, d, d1, d2, f, f1);
    }
}

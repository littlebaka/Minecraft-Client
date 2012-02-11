// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelBlaze, EntityBlaze, EntityLiving, 
//            Entity

public class RenderBlaze extends RenderLiving
{

    private int field_40278_c;

    public RenderBlaze()
    {
        super(new ModelBlaze(), 0.5F);
        field_40278_c = ((ModelBlaze)field_20920_e).func_40321_a();
    }

    public void func_40277_a(EntityBlaze entityblaze, double d, double d1, double d2, 
            float f, float f1)
    {
        int i = ((ModelBlaze)field_20920_e).func_40321_a();
        if(i != field_40278_c)
        {
            field_40278_c = i;
            field_20920_e = new ModelBlaze();
        }
        super.func_171_a(entityblaze, d, d1, d2, f, f1);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40277_a((EntityBlaze)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40277_a((EntityBlaze)entity, d, d1, d2, f, f1);
    }
}

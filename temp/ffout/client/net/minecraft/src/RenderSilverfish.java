// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelSilverfish, EntitySilverfish, EntityLiving, 
//            Entity

public class RenderSilverfish extends RenderLiving
{

    public RenderSilverfish()
    {
        super(new ModelSilverfish(), 0.3F);
    }

    protected float func_35447_a(EntitySilverfish entitysilverfish)
    {
        return 180F;
    }

    public void func_35448_a(EntitySilverfish entitysilverfish, double d, double d1, double d2, 
            float f, float f1)
    {
        super.func_171_a(entitysilverfish, d, d1, d2, f, f1);
    }

    protected int func_35449_a(EntitySilverfish entitysilverfish, int i, float f)
    {
        return -1;
    }

    protected float func_172_a(EntityLiving entityliving)
    {
        return func_35447_a((EntitySilverfish)entityliving);
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return func_35449_a((EntitySilverfish)entityliving, i, f);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_35448_a((EntitySilverfish)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_35448_a((EntitySilverfish)entity, d, d1, d2, f, f1);
    }
}

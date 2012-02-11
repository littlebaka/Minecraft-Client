// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySheep, ModelBase, EntityLiving, 
//            Entity

public class RenderSheep extends RenderLiving
{

    public RenderSheep(ModelBase modelbase, ModelBase modelbase1, float f)
    {
        super(modelbase, f);
        func_4013_a(modelbase1);
    }

    protected int func_176_a(EntitySheep entitysheep, int i, float f)
    {
        if(i == 0 && !entitysheep.func_21072_p())
        {
            func_151_a("/mob/sheep_fur.png");
            float f1 = 1.0F;
            int j = entitysheep.func_21074_p_();
            GL11.glColor3f(f1 * EntitySheep.field_21075_a[j][0], f1 * EntitySheep.field_21075_a[j][1], f1 * EntitySheep.field_21075_a[j][2]);
            return 1;
        } else
        {
            return -1;
        }
    }

    public void func_40271_a(EntitySheep entitysheep, double d, double d1, double d2, 
            float f, float f1)
    {
        super.func_171_a(entitysheep, d, d1, d2, f, f1);
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return func_176_a((EntitySheep)entityliving, i, f);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40271_a((EntitySheep)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40271_a((EntitySheep)entity, d, d1, d2, f, f1);
    }
}

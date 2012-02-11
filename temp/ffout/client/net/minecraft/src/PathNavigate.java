// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            INavigate, World, EntityLiving, PathEntity, 
//            Vec3D, EntityMoveHelper

public class PathNavigate
    implements INavigate
{

    private EntityLiving field_46076_a;
    private World field_46074_b;
    private PathEntity field_46075_c;
    private float field_46073_d;

    public PathNavigate(EntityLiving entityliving, World world)
    {
        field_46076_a = entityliving;
        field_46074_b = world;
    }

    public void func_46071_a(double d, double d1, double d2, float f)
    {
        field_46075_c = field_46074_b.func_637_a(field_46076_a, (int)d, (int)d1, (int)d2, 10F);
        field_46073_d = f;
    }

    public void func_46070_a(EntityLiving entityliving, float f)
    {
        field_46075_c = field_46074_b.func_702_a(field_46076_a, entityliving, 16F);
        field_46073_d = f;
    }

    public void func_46069_a()
    {
        if(field_46075_c == null)
        {
            return;
        }
        float f = field_46076_a.field_644_aC;
        Vec3D vec3d;
        for(vec3d = field_46075_c.func_1205_a(field_46076_a); vec3d != null && vec3d.func_1255_d(field_46076_a.field_611_ak, vec3d.field_1775_b, field_46076_a.field_609_am) < (double)(f * f);)
        {
            field_46075_c.func_1206_a();
            if(field_46075_c.func_1207_b())
            {
                vec3d = null;
                field_46075_c = null;
            } else
            {
                vec3d = field_46075_c.func_1205_a(field_46076_a);
            }
        }

        if(vec3d == null)
        {
            return;
        } else
        {
            field_46076_a.func_46009_aH().func_46033_a(field_46073_d);
            field_46076_a.func_46009_aH().func_46035_a(vec3d.field_1776_a, vec3d.field_1775_b, vec3d.field_1779_c);
            return;
        }
    }

    public boolean func_46072_b()
    {
        return field_46075_c == null || field_46075_c.func_1207_b();
    }
}

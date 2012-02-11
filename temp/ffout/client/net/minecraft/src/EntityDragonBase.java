// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, World, DragonPart, DamageSource

public class EntityDragonBase extends EntityLiving
{

    protected int field_40157_aB;

    public EntityDragonBase(World world)
    {
        super(world);
        field_40157_aB = 100;
    }

    public int func_40117_c()
    {
        return field_40157_aB;
    }

    public boolean func_40156_a(DragonPart dragonpart, DamageSource damagesource, int i)
    {
        return func_396_a(damagesource, i);
    }

    public boolean func_396_a(DamageSource damagesource, int i)
    {
        return false;
    }

    protected boolean func_40155_e(DamageSource damagesource, int i)
    {
        return super.func_396_a(damagesource, i);
    }
}

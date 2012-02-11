// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDamageSource, Entity

public class EntityDamageSourceIndirect extends EntityDamageSource
{

    private Entity field_35553_n;

    public EntityDamageSourceIndirect(String s, Entity entity, Entity entity1)
    {
        super(s, entity);
        field_35553_n = entity1;
    }

    public Entity func_35526_e()
    {
        return field_35552_n;
    }

    public Entity func_35532_a()
    {
        return field_35553_n;
    }
}

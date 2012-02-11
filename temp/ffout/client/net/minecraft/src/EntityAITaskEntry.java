// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAIBase, EntityAITasks

class EntityAITaskEntry
{

    public EntityAIBase field_46114_a;
    public int field_46112_b;
    final EntityAITasks field_46113_c; /* synthetic field */

    public EntityAITaskEntry(EntityAITasks entityaitasks, int i, EntityAIBase entityaibase)
    {
        field_46113_c = entityaitasks;
        super();
        field_46112_b = i;
        field_46114_a = entityaibase;
    }
}

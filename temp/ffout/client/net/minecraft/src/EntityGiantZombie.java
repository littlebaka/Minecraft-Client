// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityMob, World

public class EntityGiantZombie extends EntityMob
{

    public EntityGiantZombie(World world)
    {
        super(world);
        field_9357_z = "/mob/zombie.png";
        field_9333_am = 0.5F;
        field_762_e = 50;
        field_9292_aO *= 6F;
        func_371_a(field_644_aC * 6F, field_643_aD * 6F);
    }

    public int func_40117_c()
    {
        return 100;
    }

    public float func_439_a(int i, int j, int k)
    {
        return field_615_ag.func_598_c(i, j, k) - 0.5F;
    }
}

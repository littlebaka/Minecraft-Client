// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityCreature, NBTTagCompound, World

public class EntityVillager extends EntityCreature
{

    private int field_40141_a;

    public EntityVillager(World world)
    {
        this(world, 0);
    }

    public EntityVillager(World world, int i)
    {
        super(world);
        field_40141_a = i;
        func_40140_ac();
        field_9333_am = 0.5F;
    }

    public int func_40117_c()
    {
        return 20;
    }

    public void func_425_j()
    {
        super.func_425_j();
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
        nbttagcompound.func_758_a("Profession", field_40141_a);
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
        field_40141_a = nbttagcompound.func_756_e("Profession");
        func_40140_ac();
    }

    private void func_40140_ac()
    {
        field_9357_z = "/mob/villager/villager.png";
        if(field_40141_a == 0)
        {
            field_9357_z = "/mob/villager/farmer.png";
        }
        if(field_40141_a == 1)
        {
            field_9357_z = "/mob/villager/librarian.png";
        }
        if(field_40141_a == 2)
        {
            field_9357_z = "/mob/villager/priest.png";
        }
        if(field_40141_a == 3)
        {
            field_9357_z = "/mob/villager/smith.png";
        }
        if(field_40141_a == 4)
        {
            field_9357_z = "/mob/villager/butcher.png";
        }
    }

    protected boolean func_25023_u()
    {
        return false;
    }

    protected String func_6389_d()
    {
        return "mob.villager.default";
    }

    protected String func_6394_f_()
    {
        return "mob.villager.defaulthurt";
    }

    protected String func_6390_f()
    {
        return "mob.villager.defaultdeath";
    }
}

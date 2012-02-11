// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, Item, EntityPlayer, InventoryPlayer, 
//            ItemStack, World, NBTTagCompound

public class EntityCow extends EntityAnimal
{

    public EntityCow(World world)
    {
        super(world);
        field_9357_z = "/mob/cow.png";
        func_371_a(0.9F, 1.3F);
    }

    public int func_40117_c()
    {
        return 10;
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
    }

    protected String func_6389_d()
    {
        return "mob.cow";
    }

    protected String func_6394_f_()
    {
        return "mob.cowhurt";
    }

    protected String func_6390_f()
    {
        return "mob.cowhurt";
    }

    protected float func_6393_h()
    {
        return 0.4F;
    }

    protected int func_422_g()
    {
        return Item.field_306_aD.field_291_aS;
    }

    protected void func_21066_o(boolean flag, int i)
    {
        int j = field_9312_bd.nextInt(3) + field_9312_bd.nextInt(1 + i);
        for(int k = 0; k < j; k++)
        {
            func_367_b(Item.field_306_aD.field_291_aS, 1);
        }

        j = field_9312_bd.nextInt(3) + 1 + field_9312_bd.nextInt(1 + i);
        for(int l = 0; l < j; l++)
        {
            if(func_21062_U())
            {
                func_367_b(Item.field_35418_bk.field_291_aS, 1);
            } else
            {
                func_367_b(Item.field_35417_bj.field_291_aS, 1);
            }
        }

    }

    public boolean func_353_a(EntityPlayer entityplayer)
    {
        ItemStack itemstack = entityplayer.field_778_b.func_494_a();
        if(itemstack != null && itemstack.field_1617_c == Item.field_262_au.field_291_aS)
        {
            entityplayer.field_778_b.func_472_a(entityplayer.field_778_b.field_847_d, new ItemStack(Item.field_305_aE));
            return true;
        } else
        {
            return super.func_353_a(entityplayer);
        }
    }

    protected EntityAnimal func_40145_a(EntityAnimal entityanimal)
    {
        return new EntityCow(field_615_ag);
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, EntityFishHook, ItemStack, 
//            World

public class ItemFishingRod extends Item
{

    public ItemFishingRod(int i)
    {
        super(i);
        func_21013_d(64);
        func_21009_c(1);
    }

    public boolean func_4017_a()
    {
        return true;
    }

    public boolean func_4023_b()
    {
        return true;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.field_4128_n != null)
        {
            int i = entityplayer.field_4128_n.func_4043_i();
            itemstack.func_25190_a(i, entityplayer);
            entityplayer.func_457_w();
        } else
        {
            world.func_623_a(entityplayer, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
            if(!world.field_1026_y)
            {
                world.func_674_a(new EntityFishHook(world, entityplayer));
            }
            entityplayer.func_457_w();
        }
        return itemstack;
    }
}

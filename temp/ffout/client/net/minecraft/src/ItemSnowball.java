// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, PlayerCapabilities, ItemStack, 
//            World, EntitySnowball

public class ItemSnowball extends Item
{

    public ItemSnowball(int i)
    {
        super(i);
        field_290_aT = 16;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(!entityplayer.field_35212_aW.field_35756_d)
        {
            itemstack.field_1615_a--;
        }
        world.func_623_a(entityplayer, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
        if(!world.field_1026_y)
        {
            world.func_674_a(new EntitySnowball(world, entityplayer));
        }
        return itemstack;
    }
}

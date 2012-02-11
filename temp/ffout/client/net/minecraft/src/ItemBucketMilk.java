// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, World, EntityPlayer, 
//            EnumAction

public class ItemBucketMilk extends Item
{

    public ItemBucketMilk(int i)
    {
        super(i);
        func_21009_c(1);
    }

    public ItemStack func_35413_b(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.field_1615_a--;
        if(!world.field_1026_y)
        {
            entityplayer.func_40112_aN();
        }
        if(itemstack.field_1615_a <= 0)
        {
            return new ItemStack(Item.field_262_au);
        } else
        {
            return itemstack;
        }
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 32;
    }

    public EnumAction func_35412_b(ItemStack itemstack)
    {
        return EnumAction.drink;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.func_35199_b(itemstack, func_35411_c(itemstack));
        return itemstack;
    }
}

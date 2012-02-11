// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, MovingObjectPosition, EnumMovingObjectType, World, 
//            EntityPlayer, Material, ItemStack, InventoryPlayer, 
//            ItemPotion

public class ItemGlassBottle extends Item
{

    public ItemGlassBottle(int i)
    {
        super(i);
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        MovingObjectPosition movingobjectposition = func_40402_a(world, entityplayer, true);
        if(movingobjectposition == null)
        {
            return itemstack;
        }
        if(movingobjectposition.field_1167_a == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.field_1166_b;
            int j = movingobjectposition.field_1172_c;
            int k = movingobjectposition.field_1171_d;
            if(!world.func_6466_a(entityplayer, i, j, k))
            {
                return itemstack;
            }
            if(!entityplayer.func_35190_e(i, j, k))
            {
                return itemstack;
            }
            if(world.func_599_f(i, j, k) == Material.field_1332_f)
            {
                itemstack.field_1615_a--;
                if(itemstack.field_1615_a <= 0)
                {
                    return new ItemStack(Item.field_40413_bs);
                }
                if(!entityplayer.field_778_b.func_504_a(new ItemStack(Item.field_40413_bs)))
                {
                    entityplayer.func_449_a(new ItemStack(Item.field_40413_bs.field_291_aS, 1, 0));
                }
            }
        }
        return itemstack;
    }
}

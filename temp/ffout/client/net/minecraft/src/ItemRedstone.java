// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, World, Block, EntityPlayer, 
//            ItemStack

public class ItemRedstone extends Item
{

    public ItemRedstone(int i)
    {
        super(i);
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(world.func_600_a(i, j, k) != Block.field_428_aT.field_376_bc)
        {
            if(l == 0)
            {
                j--;
            }
            if(l == 1)
            {
                j++;
            }
            if(l == 2)
            {
                k--;
            }
            if(l == 3)
            {
                k++;
            }
            if(l == 4)
            {
                i--;
            }
            if(l == 5)
            {
                i++;
            }
            if(!world.func_20084_d(i, j, k))
            {
                return false;
            }
        }
        if(!entityplayer.func_35190_e(i, j, k))
        {
            return false;
        }
        if(Block.field_394_aw.func_243_a(world, i, j, k))
        {
            itemstack.field_1615_a--;
            world.func_690_d(i, j, k, Block.field_394_aw.field_376_bc);
        }
        return true;
    }
}

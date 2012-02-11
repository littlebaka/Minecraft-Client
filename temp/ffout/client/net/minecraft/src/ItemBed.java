// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, Block, BlockBed, EntityPlayer, 
//            MathHelper, World, ItemStack

public class ItemBed extends Item
{

    public ItemBed(int i)
    {
        super(i);
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l != 1)
        {
            return false;
        }
        j++;
        BlockBed blockbed = (BlockBed)Block.field_9262_S;
        int i1 = MathHelper.func_1108_b((double)((entityplayer.field_605_aq * 4F) / 360F) + 0.5D) & 3;
        byte byte0 = 0;
        byte byte1 = 0;
        if(i1 == 0)
        {
            byte1 = 1;
        }
        if(i1 == 1)
        {
            byte0 = -1;
        }
        if(i1 == 2)
        {
            byte1 = -1;
        }
        if(i1 == 3)
        {
            byte0 = 1;
        }
        if(!entityplayer.func_35190_e(i, j, k) || !entityplayer.func_35190_e(i + byte0, j, k + byte1))
        {
            return false;
        }
        if(world.func_20084_d(i, j, k) && world.func_20084_d(i + byte0, j, k + byte1) && world.func_28100_h(i, j - 1, k) && world.func_28100_h(i + byte0, j - 1, k + byte1))
        {
            world.func_688_b(i, j, k, blockbed.field_376_bc, i1);
            if(world.func_600_a(i, j, k) == blockbed.field_376_bc)
            {
                world.func_688_b(i + byte0, j, k + byte1, blockbed.field_376_bc, i1 + 8);
            }
            itemstack.field_1615_a--;
            return true;
        } else
        {
            return false;
        }
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, World, Material, EntityPlayer, 
//            Block, MathHelper, ItemStack, TileEntitySign

public class ItemSign extends Item
{

    public ItemSign(int i)
    {
        super(i);
        field_290_aT = 1;
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l == 0)
        {
            return false;
        }
        if(!world.func_599_f(i, j, k).func_878_a())
        {
            return false;
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
        if(!entityplayer.func_35190_e(i, j, k))
        {
            return false;
        }
        if(!Block.field_443_aE.func_243_a(world, i, j, k))
        {
            return false;
        }
        if(l == 1)
        {
            int i1 = MathHelper.func_1108_b((double)(((entityplayer.field_605_aq + 180F) * 16F) / 360F) + 0.5D) & 0xf;
            world.func_688_b(i, j, k, Block.field_443_aE.field_376_bc, i1);
        } else
        {
            world.func_688_b(i, j, k, Block.field_4068_aJ.field_376_bc, l);
        }
        itemstack.field_1615_a--;
        TileEntitySign tileentitysign = (TileEntitySign)world.func_603_b(i, j, k);
        if(tileentitysign != null)
        {
            entityplayer.func_4052_a(tileentitysign);
        }
        return true;
    }
}

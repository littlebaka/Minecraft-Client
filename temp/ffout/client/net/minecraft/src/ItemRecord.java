// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Item, World, Block, BlockJukeBox, 
//            ItemStack, EnumRarity, EntityPlayer

public class ItemRecord extends Item
{

    public final String field_316_a;

    protected ItemRecord(int i, String s)
    {
        super(i);
        field_316_a = s;
        field_290_aT = 1;
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(world.func_600_a(i, j, k) == Block.field_422_aZ.field_376_bc && world.func_602_e(i, j, k) == 0)
        {
            if(world.field_1026_y)
            {
                return true;
            } else
            {
                ((BlockJukeBox)Block.field_422_aZ).func_317_e(world, i, j, k, field_291_aS);
                world.func_28107_a(null, 1005, i, j, k, field_291_aS);
                itemstack.field_1615_a--;
                return true;
            }
        } else
        {
            return false;
        }
    }

    public void func_40404_a(ItemStack itemstack, List list)
    {
        list.add((new StringBuilder()).append("C418 - ").append(field_316_a).toString());
    }

    public EnumRarity func_40398_f(ItemStack itemstack)
    {
        return EnumRarity.rare;
    }
}

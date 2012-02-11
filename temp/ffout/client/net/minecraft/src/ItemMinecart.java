// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, World, BlockRail, EntityMinecart, 
//            ItemStack, EntityPlayer

public class ItemMinecart extends Item
{

    public int field_317_a;

    public ItemMinecart(int i, int j)
    {
        super(i);
        field_290_aT = 1;
        field_317_a = j;
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        int i1 = world.func_600_a(i, j, k);
        if(BlockRail.func_27041_c(i1))
        {
            if(!world.field_1026_y)
            {
                world.func_674_a(new EntityMinecart(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, field_317_a));
            }
            itemstack.field_1615_a--;
            return true;
        } else
        {
            return false;
        }
    }
}

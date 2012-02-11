// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, PlayerCapabilities, Enchantment, 
//            EnchantmentHelper, InventoryPlayer, EntityArrow, ItemStack, 
//            World, EnumAction

public class ItemBow extends Item
{

    public ItemBow(int i)
    {
        super(i);
        field_290_aT = 1;
        func_21013_d(384);
    }

    public void func_35414_a(ItemStack itemstack, World world, EntityPlayer entityplayer, int i)
    {
        boolean flag = entityplayer.field_35212_aW.field_35756_d || EnchantmentHelper.func_40634_b(Enchantment.field_46042_v.field_40516_s, itemstack) > 0;
        if(flag || entityplayer.field_778_b.func_35157_d(Item.field_226_j.field_291_aS))
        {
            int j = func_35411_c(itemstack) - i;
            float f = (float)j / 20F;
            f = (f * f + f * 2.0F) / 3F;
            if((double)f < 0.10000000000000001D)
            {
                return;
            }
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            EntityArrow entityarrow = new EntityArrow(world, entityplayer, f * 2.0F);
            if(f == 1.0F)
            {
                entityarrow.field_35140_d = true;
            }
            int k = EnchantmentHelper.func_40634_b(Enchantment.field_46045_s.field_40516_s, itemstack);
            if(k > 0)
            {
                entityarrow.func_46024_b(entityarrow.func_46025_l() + (double)k * 0.5D + 0.5D);
            }
            int l = EnchantmentHelper.func_40634_b(Enchantment.field_46044_t.field_40516_s, itemstack);
            if(l > 0)
            {
                entityarrow.func_46023_b(l);
            }
            if(EnchantmentHelper.func_40634_b(Enchantment.field_46043_u.field_40516_s, itemstack) > 0)
            {
                entityarrow.func_40046_d(100);
            }
            itemstack.func_25190_a(1, entityplayer);
            world.func_623_a(entityplayer, "random.bow", 1.0F, 1.0F / (field_4015_b.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            if(!flag)
            {
                entityplayer.field_778_b.func_510_b(Item.field_226_j.field_291_aS);
            } else
            {
                entityarrow.field_28020_a = false;
            }
            if(!world.field_1026_y)
            {
                world.func_674_a(entityarrow);
            }
        }
    }

    public ItemStack func_35413_b(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        return itemstack;
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 0x11940;
    }

    public EnumAction func_35412_b(ItemStack itemstack)
    {
        return EnumAction.bow;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.field_35212_aW.field_35756_d || entityplayer.field_778_b.func_35157_d(Item.field_226_j.field_291_aS))
        {
            entityplayer.func_35199_b(itemstack, func_35411_c(itemstack));
        }
        return itemstack;
    }

    public int func_40399_b()
    {
        return 1;
    }
}

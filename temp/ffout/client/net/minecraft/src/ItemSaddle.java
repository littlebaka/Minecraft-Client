// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EntityPig, ItemStack, EntityLiving

public class ItemSaddle extends Item
{

    public ItemSaddle(int i)
    {
        super(i);
        field_290_aT = 1;
    }

    public void func_4019_b(ItemStack itemstack, EntityLiving entityliving)
    {
        if(entityliving instanceof EntityPig)
        {
            EntityPig entitypig = (EntityPig)entityliving;
            if(!entitypig.func_21068_q())
            {
                entitypig.func_21069_a(true);
                itemstack.field_1615_a--;
            }
        }
    }

    public boolean func_4021_a(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        func_4019_b(itemstack, entityliving);
        return true;
    }
}

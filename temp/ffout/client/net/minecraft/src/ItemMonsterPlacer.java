// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.HashMap;

// Referenced classes of package net.minecraft.src:
//            Item, StatCollector, ItemStack, EntityList, 
//            EntityEggInfo, World, Facing, EntityPlayer, 
//            PlayerCapabilities, Entity

public class ItemMonsterPlacer extends Item
{

    public ItemMonsterPlacer(int i)
    {
        super(i);
        func_21009_c(1);
        func_21015_a(true);
    }

    public String func_40397_d(ItemStack itemstack)
    {
        String s = (new StringBuilder()).append("").append(StatCollector.func_25200_a((new StringBuilder()).append(func_20009_a()).append(".name").toString())).toString().trim();
        String s1 = EntityList.func_44040_a(itemstack.func_21181_i());
        if(s1 != null)
        {
            s = (new StringBuilder()).append(s).append(" ").append(StatCollector.func_25200_a((new StringBuilder()).append("entity.").append(s1).append(".name").toString())).toString();
        }
        return s;
    }

    public int func_27010_f(int i, int j)
    {
        EntityEggInfo entityegginfo = (EntityEggInfo)EntityList.field_44041_a.get(Integer.valueOf(i));
        if(entityegginfo != null)
        {
            if(j == 0)
            {
                return entityegginfo.field_46061_b;
            } else
            {
                return entityegginfo.field_46062_c;
            }
        } else
        {
            return 0xffffff;
        }
    }

    public boolean func_46058_c()
    {
        return true;
    }

    public int func_46057_a(int i, int j)
    {
        if(j > 0)
        {
            return super.func_46057_a(i, j) + 16;
        } else
        {
            return super.func_46057_a(i, j);
        }
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(world.field_1026_y)
        {
            return true;
        }
        i += Facing.field_31056_b[l];
        j += Facing.field_31059_c[l];
        k += Facing.field_31058_d[l];
        Entity entity = EntityList.func_1084_a(itemstack.func_21181_i(), world);
        if(entity != null)
        {
            if(!entityplayer.field_35212_aW.field_35756_d)
            {
                itemstack.field_1615_a--;
            }
            entity.func_365_c((double)i + 0.5D, j, (double)k + 0.5D, 0.0F, 0.0F);
            world.func_674_a(entity);
        }
        return true;
    }
}

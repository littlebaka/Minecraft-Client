package net.minecraft.src;

import java.util.HashMap;

public class ItemMonsterPlacer extends Item
{
    public ItemMonsterPlacer(int i)
    {
        super(i);
        setMaxStackSize(1);
        setHasSubtypes(true);
    }

    public String getItemDisplayName(ItemStack itemstack)
    {
        String s = (new StringBuilder()).append("").append(StatCollector.translateToLocal((new StringBuilder()).append(getItemName()).append(".name").toString())).toString().trim();
        String s1 = EntityList.func_44040_a(itemstack.getItemDamage());
        if (s1 != null)
        {
            s = (new StringBuilder()).append(s).append(" ").append(StatCollector.translateToLocal((new StringBuilder()).append("entity.").append(s1).append(".name").toString())).toString();
        }
        return s;
    }

    public int getColorFromDamage(int i, int j)
    {
        EntityEggInfo entityegginfo = (EntityEggInfo)EntityList.field_44041_a.get(Integer.valueOf(i));
        if (entityegginfo != null)
        {
            if (j == 0)
            {
                return entityegginfo.field_46061_b;
            }
            else
            {
                return entityegginfo.field_46062_c;
            }
        }
        else
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
        if (j > 0)
        {
            return super.func_46057_a(i, j) + 16;
        }
        else
        {
            return super.func_46057_a(i, j);
        }
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if (world.multiplayerWorld)
        {
            return true;
        }
        i += Facing.offsetsXForSide[l];
        j += Facing.offsetsYForSide[l];
        k += Facing.offsetsZForSide[l];
        Entity entity = EntityList.createEntity(itemstack.getItemDamage(), world);
        if (entity != null)
        {
            if (!entityplayer.capabilities.depleteBuckets)
            {
                itemstack.stackSize--;
            }
            entity.setLocationAndAngles((double)i + 0.5D, j, (double)k + 0.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entity);
        }
        return true;
    }
}

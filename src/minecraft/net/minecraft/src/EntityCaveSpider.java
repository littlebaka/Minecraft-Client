package net.minecraft.src;

public class EntityCaveSpider extends EntitySpider
{
    public EntityCaveSpider(World world)
    {
        super(world);
        texture = "/mob/cavespider.png";
        setSize(0.7F, 0.5F);
    }

    public int getMaxHealth()
    {
        return 12;
    }

    public float spiderScaleAmount()
    {
        return 0.7F;
    }

    public boolean attackEntityAsMob(Entity entity)
    {
        if (super.attackEntityAsMob(entity))
        {
            if (entity instanceof EntityLiving)
            {
                byte byte0 = 0;
                if (worldObj.difficultySetting > 1)
                {
                    if (worldObj.difficultySetting == 2)
                    {
                        byte0 = 7;
                    }
                    else if (worldObj.difficultySetting == 3)
                    {
                        byte0 = 15;
                    }
                }
                if (byte0 > 0)
                {
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.id, byte0 * 20, 0));
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}

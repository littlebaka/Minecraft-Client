package net.minecraft.src;

import java.util.Random;

public class EntityEgg extends EntityThrowable
{
    public EntityEgg(World world)
    {
        super(world);
    }

    public EntityEgg(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public EntityEgg(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    protected void onThrowableCollision(MovingObjectPosition movingobjectposition)
    {
        if (movingobjectposition.entityHit != null)
        {
            if (!movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, throwingEntity), 0));
        }
        if (!worldObj.multiplayerWorld && rand.nextInt(8) == 0)
        {
            byte byte0 = 1;
            if (rand.nextInt(32) == 0)
            {
                byte0 = 4;
            }
            for (int j = 0; j < byte0; j++)
            {
                EntityChicken entitychicken = new EntityChicken(worldObj);
                entitychicken.setDelay(-24000);
                entitychicken.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
                worldObj.spawnEntityInWorld(entitychicken);
            }
        }
        for (int i = 0; i < 8; i++)
        {
            worldObj.spawnParticle("snowballpoof", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!worldObj.multiplayerWorld)
        {
            setEntityDead();
        }
    }
}

package net.minecraft.src;

public class EntitySnowball extends EntityThrowable
{
    public EntitySnowball(World world)
    {
        super(world);
    }

    public EntitySnowball(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public EntitySnowball(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    protected void onThrowableCollision(MovingObjectPosition movingobjectposition)
    {
        if (movingobjectposition.entityHit != null)
        {
            byte byte0 = 0;
            if (movingobjectposition.entityHit instanceof EntityBlaze)
            {
                byte0 = 3;
            }
            if (!movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, throwingEntity), byte0));
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

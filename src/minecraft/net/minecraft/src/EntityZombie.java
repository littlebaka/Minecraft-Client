package net.minecraft.src;

import java.util.Random;

public class EntityZombie extends EntityMob
{
    public EntityZombie(World world)
    {
        super(world);
        texture = "/mob/zombie.png";
        moveSpeed = 0.5F;
        attackStrength = 4;
        field_46019_bU.func_46118_a(1, new EntityAISwimming(this));
        field_46019_bU.func_46118_a(2, new EntityAIAttackOnCollide(this, world, 16F));
        field_46019_bU.func_46118_a(3, new EntityAIWander(this));
        field_46019_bU.func_46118_a(4, new EntityAIWatchClosest(this, world, 8F));
        field_46019_bU.func_46118_a(4, new EntityAILookIdle(this));
    }

    public int getMaxHealth()
    {
        return 20;
    }

    public int getTotalArmorValue()
    {
        return 2;
    }

    protected boolean func_46006_aR()
    {
        return false;
    }

    public void onLivingUpdate()
    {
        if (worldObj.isDaytime() && !worldObj.multiplayerWorld)
        {
            float f = getEntityBrightness(1.0F);
            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                setFire(8);
            }
        }
        super.onLivingUpdate();
    }

    protected String getLivingSound()
    {
        return "mob.zombie";
    }

    protected String getHurtSound()
    {
        return "mob.zombiehurt";
    }

    protected String getDeathSound()
    {
        return "mob.zombiedeath";
    }

    protected int getDropItemId()
    {
        return Item.rottenFlesh.shiftedIndex;
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
}

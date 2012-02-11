package net.minecraft.src;

public class EntityGiantZombie extends EntityMob
{
    public EntityGiantZombie(World world)
    {
        super(world);
        texture = "/mob/zombie.png";
        moveSpeed = 0.5F;
        attackStrength = 50;
        yOffset *= 6F;
        setSize(width * 6F, height * 6F);
    }

    public int getMaxHealth()
    {
        return 100;
    }

    public float getBlockPathWeight(int i, int j, int k)
    {
        return worldObj.getLightBrightness(i, j, k) - 0.5F;
    }
}

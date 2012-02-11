package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class EntityMagmaCube extends EntitySlime
{
    public EntityMagmaCube(World world)
    {
        super(world);
        texture = "/mob/lava.png";
        isImmuneToFire = true;
        landMovementFactor = 0.2F;
    }

    public boolean getCanSpawnHere()
    {
        return worldObj.difficultySetting > 0 && worldObj.checkIfAABBIsClear(boundingBox) && worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.getIsAnyLiquid(boundingBox);
    }

    public int getTotalArmorValue()
    {
        return getSlimeSize() * 3;
    }

    public int getEntityBrightnessForRender(float f)
    {
        return 0xf000f0;
    }

    public float getEntityBrightness(float f)
    {
        return 1.0F;
    }

    protected String func_40135_ac()
    {
        return "flame";
    }

    protected EntitySlime func_40132_ae()
    {
        return new EntityMagmaCube(worldObj);
    }

    protected int getDropItemId()
    {
        return Item.magmaCream.shiftedIndex;
    }

    protected void dropFewItems(boolean flag, int i)
    {
        int j = getDropItemId();
        if (j > 0 && getSlimeSize() > 1)
        {
            int k = rand.nextInt(4) - 2;
            if (i > 0)
            {
                k += rand.nextInt(i + 1);
            }
            for (int l = 0; l < k; l++)
            {
                dropItem(j, 1);
            }
        }
    }

    public boolean isBurning()
    {
        return false;
    }

    protected int func_40131_af()
    {
        return super.func_40131_af() * 4;
    }

    protected void func_40136_ag()
    {
        field_40139_a = field_40139_a * 0.9F;
    }

    protected void jump()
    {
        motionY = 0.42F + (float)getSlimeSize() * 0.1F;
        isAirBorne = true;
    }

    protected void fall(float f)
    {
    }

    protected boolean func_40137_ah()
    {
        return true;
    }

    protected int func_40130_ai()
    {
        return super.func_40130_ai() + 2;
    }

    protected String getHurtSound()
    {
        return "mob.slime";
    }

    protected String getDeathSound()
    {
        return "mob.slime";
    }

    protected String func_40138_aj()
    {
        if (getSlimeSize() > 1)
        {
            return "mob.magmacube.big";
        }
        else
        {
            return "mob.magmacube.small";
        }
    }

    public boolean handleLavaMovement()
    {
        return false;
    }

    protected boolean func_40134_ak()
    {
        return true;
    }
}

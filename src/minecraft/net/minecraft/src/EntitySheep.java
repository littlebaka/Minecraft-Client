package net.minecraft.src;

import java.util.Random;

public class EntitySheep extends EntityAnimal
{
    public static final float fleeceColorTable[][] =
    {
        {
            1.0F, 1.0F, 1.0F
        }, {
            0.95F, 0.7F, 0.2F
        }, {
            0.9F, 0.5F, 0.85F
        }, {
            0.6F, 0.7F, 0.95F
        }, {
            0.9F, 0.9F, 0.2F
        }, {
            0.5F, 0.8F, 0.1F
        }, {
            0.95F, 0.7F, 0.8F
        }, {
            0.3F, 0.3F, 0.3F
        }, {
            0.6F, 0.6F, 0.6F
        }, {
            0.3F, 0.6F, 0.7F
        }, {
            0.7F, 0.4F, 0.9F
        }, {
            0.2F, 0.4F, 0.8F
        }, {
            0.5F, 0.4F, 0.3F
        }, {
            0.4F, 0.5F, 0.2F
        }, {
            0.8F, 0.3F, 0.3F
        }, {
            0.1F, 0.1F, 0.1F
        }
    };
    private int field_44004_b;

    public EntitySheep(World world)
    {
        super(world);
        texture = "/mob/sheep.png";
        setSize(0.9F, 1.3F);
    }

    public int getMaxHealth()
    {
        return 8;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)0));
    }

    protected void dropFewItems(boolean flag, int i)
    {
        if (!getSheared())
        {
            entityDropItem(new ItemStack(Block.cloth.blockID, 1, getFleeceColor()), 0.0F);
        }
    }

    protected int getDropItemId()
    {
        return Block.cloth.blockID;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if (field_44004_b > 0)
        {
            field_44004_b--;
        }
    }

    protected void jump()
    {
        if (field_44004_b <= 0)
        {
            super.jump();
        }
    }

    protected void updateEntityActionState()
    {
        super.updateEntityActionState();
        if (!hasPath() && field_44004_b <= 0 && (isChild() && rand.nextInt(50) == 0 || rand.nextInt(1000) == 0))
        {
            int i = MathHelper.floor_double(posX);
            int k = MathHelper.floor_double(posY);
            int i1 = MathHelper.floor_double(posZ);
            if (worldObj.getBlockId(i, k, i1) == Block.tallGrass.blockID && worldObj.getBlockMetadata(i, k, i1) == 1 || worldObj.getBlockId(i, k - 1, i1) == Block.grass.blockID)
            {
                field_44004_b = 40;
                worldObj.setEntityState(this, (byte)10);
            }
        }
        else if (field_44004_b == 4)
        {
            int j = MathHelper.floor_double(posX);
            int l = MathHelper.floor_double(posY);
            int j1 = MathHelper.floor_double(posZ);
            boolean flag = false;
            if (worldObj.getBlockId(j, l, j1) == Block.tallGrass.blockID)
            {
                worldObj.playAuxSFX(2001, j, l, j1, Block.tallGrass.blockID + 256);
                worldObj.setBlockWithNotify(j, l, j1, 0);
                flag = true;
            }
            else if (worldObj.getBlockId(j, l - 1, j1) == Block.grass.blockID)
            {
                worldObj.playAuxSFX(2001, j, l - 1, j1, Block.grass.blockID);
                worldObj.setBlockWithNotify(j, l - 1, j1, Block.dirt.blockID);
                flag = true;
            }
            if (flag)
            {
                setSheared(false);
                if (isChild())
                {
                    int k1 = getDelay() + 1200;
                    if (k1 > 0)
                    {
                        k1 = 0;
                    }
                    setDelay(k1);
                }
            }
        }
    }

    public void handleHealthUpdate(byte byte0)
    {
        if (byte0 == 10)
        {
            field_44004_b = 40;
        }
        else
        {
            super.handleHealthUpdate(byte0);
        }
    }

    protected boolean isMovementCeased()
    {
        return field_44004_b > 0;
    }

    public float func_44003_c(float f)
    {
        if (field_44004_b <= 0)
        {
            return 0.0F;
        }
        if (field_44004_b >= 4 && field_44004_b <= 36)
        {
            return 1.0F;
        }
        if (field_44004_b < 4)
        {
            return ((float)field_44004_b - f) / 4F;
        }
        else
        {
            return -((float)(field_44004_b - 40) - f) / 4F;
        }
    }

    public float func_44002_d(float f)
    {
        if (field_44004_b > 4 && field_44004_b <= 36)
        {
            float f1 = ((float)(field_44004_b - 4) - f) / 32F;
            return 0.6283185F + 0.2199115F * MathHelper.sin(f1 * 28.7F);
        }
        if (field_44004_b > 0)
        {
            return 0.6283185F;
        }
        else
        {
            return rotationPitch / 57.29578F;
        }
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if (itemstack != null && itemstack.itemID == Item.shears.shiftedIndex && !getSheared() && !isChild())
        {
            if (!worldObj.multiplayerWorld)
            {
                setSheared(true);
                int i = 1 + rand.nextInt(3);
                for (int j = 0; j < i; j++)
                {
                    EntityItem entityitem = entityDropItem(new ItemStack(Block.cloth.blockID, 1, getFleeceColor()), 1.0F);
                    entityitem.motionY += rand.nextFloat() * 0.05F;
                    entityitem.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    entityitem.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }
            }
            itemstack.damageItem(1, entityplayer);
        }
        return super.interact(entityplayer);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Sheared", getSheared());
        nbttagcompound.setByte("Color", (byte)getFleeceColor());
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        setSheared(nbttagcompound.getBoolean("Sheared"));
        setFleeceColor(nbttagcompound.getByte("Color"));
    }

    protected String getLivingSound()
    {
        return "mob.sheep";
    }

    protected String getHurtSound()
    {
        return "mob.sheep";
    }

    protected String getDeathSound()
    {
        return "mob.sheep";
    }

    public int getFleeceColor()
    {
        return dataWatcher.getWatchableObjectByte(16) & 0xf;
    }

    public void setFleeceColor(int i)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);
        dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 & 0xf0 | i & 0xf)));
    }

    public boolean getSheared()
    {
        return (dataWatcher.getWatchableObjectByte(16) & 0x10) != 0;
    }

    public void setSheared(boolean flag)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);
        if (flag)
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 | 0x10)));
        }
        else
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 & 0xffffffef)));
        }
    }

    public static int getRandomFleeceColor(Random random)
    {
        int i = random.nextInt(100);
        if (i < 5)
        {
            return 15;
        }
        if (i < 10)
        {
            return 7;
        }
        if (i < 15)
        {
            return 8;
        }
        if (i < 18)
        {
            return 12;
        }
        return random.nextInt(500) != 0 ? 0 : 6;
    }

    protected EntityAnimal spawnBabyAnimal(EntityAnimal entityanimal)
    {
        EntitySheep entitysheep = (EntitySheep)entityanimal;
        EntitySheep entitysheep1 = new EntitySheep(worldObj);
        if (rand.nextBoolean())
        {
            entitysheep1.setFleeceColor(getFleeceColor());
        }
        else
        {
            entitysheep1.setFleeceColor(entitysheep.getFleeceColor());
        }
        return entitysheep1;
    }
}

package net.minecraft.src;

import java.util.*;

public class EntityDragon extends EntityDragonBase
{
    public double targetX;
    public double targetY;
    public double targetZ;
    public double field_40162_d[][];
    public int field_40164_e;
    public DragonPart dragonPartArray[];
    public DragonPart dragonPartHead;
    public DragonPart dragonPartBody;
    public DragonPart field_40170_ar;
    public DragonPart field_40169_as;
    public DragonPart field_40168_at;
    public DragonPart field_40175_au;
    public DragonPart field_40174_av;
    public float field_40173_aw;
    public float field_40172_ax;
    public boolean field_40163_ay;
    public boolean field_40161_az;
    private Entity target;
    public int field_40178_aA;
    public EntityEnderCrystal healingEnderCrystal;

    public EntityDragon(World world)
    {
        super(world);
        field_40162_d = new double[64][3];
        field_40164_e = -1;
        field_40173_aw = 0.0F;
        field_40172_ax = 0.0F;
        field_40163_ay = false;
        field_40161_az = false;
        field_40178_aA = 0;
        healingEnderCrystal = null;
        dragonPartArray = (new DragonPart[]
                {
                    dragonPartHead = new DragonPart(this, "head", 6F, 6F), dragonPartBody = new DragonPart(this, "body", 8F, 8F), field_40170_ar = new DragonPart(this, "tail", 4F, 4F), field_40169_as = new DragonPart(this, "tail", 4F, 4F), field_40168_at = new DragonPart(this, "tail", 4F, 4F), field_40175_au = new DragonPart(this, "wing", 4F, 4F), field_40174_av = new DragonPart(this, "wing", 4F, 4F)
                });
        maxHealth = 200;
        setEntityHealth(maxHealth);
        texture = "/mob/enderdragon/ender.png";
        setSize(16F, 8F);
        noClip = true;
        isImmuneToFire = true;
        targetY = 100D;
        ignoreFrustumCheck = true;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Integer(maxHealth));
    }

    public double[] func_40160_a(int i, float f)
    {
        if (health <= 0)
        {
            f = 0.0F;
        }
        f = 1.0F - f;
        int j = field_40164_e - i * 1 & 0x3f;
        int k = field_40164_e - i * 1 - 1 & 0x3f;
        double ad[] = new double[3];
        double d = field_40162_d[j][0];
        double d1;
        for (d1 = field_40162_d[k][0] - d; d1 < -180D; d1 += 360D) { }
        for (; d1 >= 180D; d1 -= 360D) { }
        ad[0] = d + d1 * (double)f;
        d = field_40162_d[j][1];
        d1 = field_40162_d[k][1] - d;
        ad[1] = d + d1 * (double)f;
        ad[2] = field_40162_d[j][2] + (field_40162_d[k][2] - field_40162_d[j][2]) * (double)f;
        return ad;
    }

    public void onLivingUpdate()
    {
        field_40173_aw = field_40172_ax;
        if (!worldObj.multiplayerWorld)
        {
            dataWatcher.updateObject(16, Integer.valueOf(health));
        }
        if (health <= 0)
        {
            float f = (rand.nextFloat() - 0.5F) * 8F;
            float f2 = (rand.nextFloat() - 0.5F) * 4F;
            float f4 = (rand.nextFloat() - 0.5F) * 8F;
            worldObj.spawnParticle("largeexplode", posX + (double)f, posY + 2D + (double)f2, posZ + (double)f4, 0.0D, 0.0D, 0.0D);
            return;
        }
        func_41011_ay();
        float f1 = 0.2F / (MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ) * 10F + 1.0F);
        f1 *= (float)Math.pow(2D, motionY);
        if (field_40161_az)
        {
            field_40172_ax += f1 * 0.5F;
        }
        else
        {
            field_40172_ax += f1;
        }
        for (; rotationYaw >= 180F; rotationYaw -= 360F) { }
        for (; rotationYaw < -180F; rotationYaw += 360F) { }
        if (field_40164_e < 0)
        {
            for (int i = 0; i < field_40162_d.length; i++)
            {
                field_40162_d[i][0] = rotationYaw;
                field_40162_d[i][1] = posY;
            }
        }
        if (++field_40164_e == field_40162_d.length)
        {
            field_40164_e = 0;
        }
        field_40162_d[field_40164_e][0] = rotationYaw;
        field_40162_d[field_40164_e][1] = posY;
        if (worldObj.multiplayerWorld)
        {
            if (newPosRotationIncrements > 0)
            {
                double d = posX + (newPosX - posX) / (double)newPosRotationIncrements;
                double d2 = posY + (newPosY - posY) / (double)newPosRotationIncrements;
                double d4 = posZ + (newPosZ - posZ) / (double)newPosRotationIncrements;
                double d6;
                for (d6 = newRotationYaw - (double)rotationYaw; d6 < -180D; d6 += 360D) { }
                for (; d6 >= 180D; d6 -= 360D) { }
                rotationYaw += d6 / (double)newPosRotationIncrements;
                rotationPitch += (newRotationPitch - (double)rotationPitch) / (double)newPosRotationIncrements;
                newPosRotationIncrements--;
                setPosition(d, d2, d4);
                setRotation(rotationYaw, rotationPitch);
            }
        }
        else
        {
            double d1 = targetX - posX;
            double d3 = targetY - posY;
            double d5 = targetZ - posZ;
            double d7 = d1 * d1 + d3 * d3 + d5 * d5;
            if (target != null)
            {
                targetX = target.posX;
                targetZ = target.posZ;
                double d8 = targetX - posX;
                double d10 = targetZ - posZ;
                double d12 = Math.sqrt(d8 * d8 + d10 * d10);
                double d13 = (0.40000000596046448D + d12 / 80D) - 1.0D;
                if (d13 > 10D)
                {
                    d13 = 10D;
                }
                targetY = target.boundingBox.minY + d13;
            }
            else
            {
                targetX += rand.nextGaussian() * 2D;
                targetZ += rand.nextGaussian() * 2D;
            }
            if (field_40163_ay || d7 < 100D || d7 > 22500D || isCollidedHorizontally || isCollidedVertically)
            {
                func_41006_aA();
            }
            d3 /= MathHelper.sqrt_double(d1 * d1 + d5 * d5);
            float f10 = 0.6F;
            if (d3 < (double)(-f10))
            {
                d3 = -f10;
            }
            if (d3 > (double)f10)
            {
                d3 = f10;
            }
            motionY += d3 * 0.10000000149011612D;
            for (; rotationYaw < -180F; rotationYaw += 360F) { }
            for (; rotationYaw >= 180F; rotationYaw -= 360F) { }
            double d9 = 180D - (Math.atan2(d1, d5) * 180D) / 3.1415927410125732D;
            double d11;
            for (d11 = d9 - (double)rotationYaw; d11 < -180D; d11 += 360D) { }
            for (; d11 >= 180D; d11 -= 360D) { }
            if (d11 > 50D)
            {
                d11 = 50D;
            }
            if (d11 < -50D)
            {
                d11 = -50D;
            }
            Vec3D vec3d = Vec3D.createVector(targetX - posX, targetY - posY, targetZ - posZ).normalize();
            Vec3D vec3d1 = Vec3D.createVector(MathHelper.sin((rotationYaw * 3.141593F) / 180F), motionY, -MathHelper.cos((rotationYaw * 3.141593F) / 180F)).normalize();
            float f18 = (float)(vec3d1.dotProduct(vec3d) + 0.5D) / 1.5F;
            if (f18 < 0.0F)
            {
                f18 = 0.0F;
            }
            randomYawVelocity *= 0.8F;
            float f19 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ) * 1.0F + 1.0F;
            double d14 = Math.sqrt(motionX * motionX + motionZ * motionZ) * 1.0D + 1.0D;
            if (d14 > 40D)
            {
                d14 = 40D;
            }
            randomYawVelocity += d11 * (0.69999998807907104D / d14 / (double)f19);
            rotationYaw += randomYawVelocity * 0.1F;
            float f20 = (float)(2D / (d14 + 1.0D));
            float f21 = 0.06F;
            moveFlying(0.0F, -1F, f21 * (f18 * f20 + (1.0F - f20)));
            if (field_40161_az)
            {
                moveEntity(motionX * 0.80000001192092896D, motionY * 0.80000001192092896D, motionZ * 0.80000001192092896D);
            }
            else
            {
                moveEntity(motionX, motionY, motionZ);
            }
            Vec3D vec3d2 = Vec3D.createVector(motionX, motionY, motionZ).normalize();
            float f22 = (float)(vec3d2.dotProduct(vec3d1) + 1.0D) / 2.0F;
            f22 = 0.8F + 0.15F * f22;
            motionX *= f22;
            motionZ *= f22;
            motionY *= 0.9100000262260437D;
        }
        renderYawOffset = rotationYaw;
        dragonPartHead.width = dragonPartHead.height = 3F;
        field_40170_ar.width = field_40170_ar.height = 2.0F;
        field_40169_as.width = field_40169_as.height = 2.0F;
        field_40168_at.width = field_40168_at.height = 2.0F;
        dragonPartBody.height = 3F;
        dragonPartBody.width = 5F;
        field_40175_au.height = 2.0F;
        field_40175_au.width = 4F;
        field_40174_av.height = 3F;
        field_40174_av.width = 4F;
        float f3 = (((float)(func_40160_a(5, 1.0F)[1] - func_40160_a(10, 1.0F)[1]) * 10F) / 180F) * 3.141593F;
        float f5 = MathHelper.cos(f3);
        float f6 = -MathHelper.sin(f3);
        float f7 = (rotationYaw * 3.141593F) / 180F;
        float f8 = MathHelper.sin(f7);
        float f9 = MathHelper.cos(f7);
        dragonPartBody.onUpdate();
        dragonPartBody.setLocationAndAngles(posX + (double)(f8 * 0.5F), posY, posZ - (double)(f9 * 0.5F), 0.0F, 0.0F);
        field_40175_au.onUpdate();
        field_40175_au.setLocationAndAngles(posX + (double)(f9 * 4.5F), posY + 2D, posZ + (double)(f8 * 4.5F), 0.0F, 0.0F);
        field_40174_av.onUpdate();
        field_40174_av.setLocationAndAngles(posX - (double)(f9 * 4.5F), posY + 2D, posZ - (double)(f8 * 4.5F), 0.0F, 0.0F);
        if (!worldObj.multiplayerWorld)
        {
            func_41007_az();
        }
        if (!worldObj.multiplayerWorld && maxHurtTime == 0)
        {
            func_41008_a(worldObj.getEntitiesWithinAABBExcludingEntity(this, field_40175_au.boundingBox.expand(4D, 2D, 4D).offset(0.0D, -2D, 0.0D)));
            func_41008_a(worldObj.getEntitiesWithinAABBExcludingEntity(this, field_40174_av.boundingBox.expand(4D, 2D, 4D).offset(0.0D, -2D, 0.0D)));
            func_41009_b(worldObj.getEntitiesWithinAABBExcludingEntity(this, dragonPartHead.boundingBox.expand(1.0D, 1.0D, 1.0D)));
        }
        double ad[] = func_40160_a(5, 1.0F);
        double ad1[] = func_40160_a(0, 1.0F);
        float f11 = MathHelper.sin((rotationYaw * 3.141593F) / 180F - randomYawVelocity * 0.01F);
        float f12 = MathHelper.cos((rotationYaw * 3.141593F) / 180F - randomYawVelocity * 0.01F);
        dragonPartHead.onUpdate();
        dragonPartHead.setLocationAndAngles(posX + (double)(f11 * 5.5F * f5), posY + (ad1[1] - ad[1]) * 1.0D + (double)(f6 * 5.5F), posZ - (double)(f12 * 5.5F * f5), 0.0F, 0.0F);
        for (int j = 0; j < 3; j++)
        {
            DragonPart dragonpart = null;
            if (j == 0)
            {
                dragonpart = field_40170_ar;
            }
            if (j == 1)
            {
                dragonpart = field_40169_as;
            }
            if (j == 2)
            {
                dragonpart = field_40168_at;
            }
            double ad2[] = func_40160_a(12 + j * 2, 1.0F);
            float f13 = (rotationYaw * 3.141593F) / 180F + ((func_40159_b(ad2[0] - ad[0]) * 3.141593F) / 180F) * 1.0F;
            float f14 = MathHelper.sin(f13);
            float f15 = MathHelper.cos(f13);
            float f16 = 1.5F;
            float f17 = (float)(j + 1) * 2.0F;
            dragonpart.onUpdate();
            dragonpart.setLocationAndAngles(posX - (double)((f8 * f16 + f14 * f17) * f5), ((posY + (ad2[1] - ad[1]) * 1.0D) - (double)((f17 + f16) * f6)) + 1.5D, posZ + (double)((f9 * f16 + f15 * f17) * f5), 0.0F, 0.0F);
        }

        if (!worldObj.multiplayerWorld)
        {
            field_40161_az = func_40158_a(dragonPartHead.boundingBox) | func_40158_a(dragonPartBody.boundingBox);
        }
    }

    private void func_41011_ay()
    {
        if (healingEnderCrystal != null)
        {
            if (healingEnderCrystal.isDead)
            {
                if (!worldObj.multiplayerWorld)
                {
                    attackEntityFromPart(dragonPartHead, DamageSource.explosion, 10);
                }
                healingEnderCrystal = null;
            }
            else if (ticksExisted % 10 == 0 && health < maxHealth)
            {
                health++;
            }
        }
        if (rand.nextInt(10) == 0)
        {
            float f = 32F;
            List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityEnderCrystal.class, boundingBox.expand(f, f, f));
            EntityEnderCrystal entityendercrystal = null;
            double d = 1.7976931348623157E+308D;
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Entity entity = (Entity)iterator.next();
                double d1 = entity.getDistanceSqToEntity(this);
                if (d1 < d)
                {
                    d = d1;
                    entityendercrystal = (EntityEnderCrystal)entity;
                }
            }
            while (true);
            healingEnderCrystal = entityendercrystal;
        }
    }

    private void func_41007_az()
    {
        if (ticksExisted % 20 == 0)
        {
            Vec3D vec3d = getLook(1.0F);
            double d = 0.0D;
            double d1 = -1D;
            double d2 = 0.0D;
        }
    }

    private void func_41008_a(List list)
    {
        double d = (dragonPartBody.boundingBox.minX + dragonPartBody.boundingBox.maxX) / 2D;
        double d1 = (dragonPartBody.boundingBox.minZ + dragonPartBody.boundingBox.maxZ) / 2D;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            if (entity instanceof EntityLiving)
            {
                double d2 = entity.posX - d;
                double d3 = entity.posZ - d1;
                double d4 = d2 * d2 + d3 * d3;
                entity.addVelocity((d2 / d4) * 4D, 0.20000000298023224D, (d3 / d4) * 4D);
            }
        }
        while (true);
    }

    private void func_41009_b(List list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            Entity entity = (Entity)list.get(i);
            if (entity instanceof EntityLiving)
            {
                entity.attackEntityFrom(DamageSource.causeMobDamage(this), 10);
            }
        }
    }

    private void func_41006_aA()
    {
        field_40163_ay = false;
        if (rand.nextInt(2) == 0 && worldObj.playerEntities.size() > 0)
        {
            target = (Entity)worldObj.playerEntities.get(rand.nextInt(worldObj.playerEntities.size()));
        }
        else
        {
            boolean flag = false;
            do
            {
                targetX = 0.0D;
                targetY = 70F + rand.nextFloat() * 50F;
                targetZ = 0.0D;
                targetX += rand.nextFloat() * 120F - 60F;
                targetZ += rand.nextFloat() * 120F - 60F;
                double d = posX - targetX;
                double d1 = posY - targetY;
                double d2 = posZ - targetZ;
                flag = d * d + d1 * d1 + d2 * d2 > 100D;
            }
            while (!flag);
            target = null;
        }
    }

    private float func_40159_b(double d)
    {
        for (; d >= 180D; d -= 360D) { }
        for (; d < -180D; d += 360D) { }
        return (float)d;
    }

    private boolean func_40158_a(AxisAlignedBB axisalignedbb)
    {
        int i = MathHelper.floor_double(axisalignedbb.minX);
        int j = MathHelper.floor_double(axisalignedbb.minY);
        int k = MathHelper.floor_double(axisalignedbb.minZ);
        int l = MathHelper.floor_double(axisalignedbb.maxX);
        int i1 = MathHelper.floor_double(axisalignedbb.maxY);
        int j1 = MathHelper.floor_double(axisalignedbb.maxZ);
        boolean flag = false;
        boolean flag1 = false;
        for (int k1 = i; k1 <= l; k1++)
        {
            for (int l1 = j; l1 <= i1; l1++)
            {
                for (int i2 = k; i2 <= j1; i2++)
                {
                    int j2 = worldObj.getBlockId(k1, l1, i2);
                    if (j2 == 0)
                    {
                        continue;
                    }
                    if (j2 == Block.obsidian.blockID || j2 == Block.whiteStone.blockID || j2 == Block.bedrock.blockID)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag1 = true;
                        worldObj.setBlockWithNotify(k1, l1, i2, 0);
                    }
                }
            }
        }

        if (flag1)
        {
            double d = axisalignedbb.minX + (axisalignedbb.maxX - axisalignedbb.minX) * (double)rand.nextFloat();
            double d1 = axisalignedbb.minY + (axisalignedbb.maxY - axisalignedbb.minY) * (double)rand.nextFloat();
            double d2 = axisalignedbb.minZ + (axisalignedbb.maxZ - axisalignedbb.minZ) * (double)rand.nextFloat();
            worldObj.spawnParticle("largeexplode", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        return flag;
    }

    public boolean attackEntityFromPart(DragonPart dragonpart, DamageSource damagesource, int i)
    {
        if (dragonpart != dragonPartHead)
        {
            i = i / 4 + 1;
        }
        float f = (rotationYaw * 3.141593F) / 180F;
        float f1 = MathHelper.sin(f);
        float f2 = MathHelper.cos(f);
        targetX = posX + (double)(f1 * 5F) + (double)((rand.nextFloat() - 0.5F) * 2.0F);
        targetY = posY + (double)(rand.nextFloat() * 3F) + 1.0D;
        targetZ = (posZ - (double)(f2 * 5F)) + (double)((rand.nextFloat() - 0.5F) * 2.0F);
        target = null;
        if ((damagesource.getEntity() instanceof EntityPlayer) || damagesource == DamageSource.explosion)
        {
            superAttackFrom(damagesource, i);
        }
        return true;
    }

    protected void onDeathUpdate()
    {
        field_40178_aA++;
        if (field_40178_aA >= 180 && field_40178_aA <= 200)
        {
            float f = (rand.nextFloat() - 0.5F) * 8F;
            float f1 = (rand.nextFloat() - 0.5F) * 4F;
            float f2 = (rand.nextFloat() - 0.5F) * 8F;
            worldObj.spawnParticle("hugeexplosion", posX + (double)f, posY + 2D + (double)f1, posZ + (double)f2, 0.0D, 0.0D, 0.0D);
        }
        if (!worldObj.multiplayerWorld && field_40178_aA > 150 && field_40178_aA % 5 == 0)
        {
            for (int i = 1000; i > 0;)
            {
                int k = EntityXPOrb.getXPSplit(i);
                i -= k;
                worldObj.spawnEntityInWorld(new EntityXPOrb(worldObj, posX, posY, posZ, k));
            }
        }
        moveEntity(0.0D, 0.10000000149011612D, 0.0D);
        renderYawOffset = rotationYaw += 20F;
        if (field_40178_aA == 200)
        {
            for (int j = 10000; j > 0;)
            {
                int l = EntityXPOrb.getXPSplit(j);
                j -= l;
                worldObj.spawnEntityInWorld(new EntityXPOrb(worldObj, posX, posY, posZ, l));
            }

            int i1 = (5 + rand.nextInt(2) * 2) - 1;
            int j1 = (5 + rand.nextInt(2) * 2) - 1;
            if (rand.nextInt(2) == 0)
            {
                i1 = 0;
            }
            else
            {
                j1 = 0;
            }
            func_41012_a(MathHelper.floor_double(posX), MathHelper.floor_double(posZ));
            onEntityDeath();
            setEntityDead();
        }
    }

    private void func_41012_a(int i, int j)
    {
        int k = worldObj.worldHeight / 2;
        BlockEndPortal.bossDefeated = true;
        int l = 4;
        for (int i1 = k - 1; i1 <= k + 32; i1++)
        {
            for (int j1 = i - l; j1 <= i + l; j1++)
            {
                for (int k1 = j - l; k1 <= j + l; k1++)
                {
                    double d = j1 - i;
                    double d1 = k1 - j;
                    double d2 = MathHelper.sqrt_double(d * d + d1 * d1);
                    if (d2 > (double)l - 0.5D)
                    {
                        continue;
                    }
                    if (i1 < k)
                    {
                        if (d2 <= (double)(l - 1) - 0.5D)
                        {
                            worldObj.setBlockWithNotify(j1, i1, k1, Block.bedrock.blockID);
                        }
                        continue;
                    }
                    if (i1 > k)
                    {
                        worldObj.setBlockWithNotify(j1, i1, k1, 0);
                        continue;
                    }
                    if (d2 > (double)(l - 1) - 0.5D)
                    {
                        worldObj.setBlockWithNotify(j1, i1, k1, Block.bedrock.blockID);
                    }
                    else
                    {
                        worldObj.setBlockWithNotify(j1, i1, k1, Block.endPortal.blockID);
                    }
                }
            }
        }

        worldObj.setBlockWithNotify(i, k + 0, j, Block.bedrock.blockID);
        worldObj.setBlockWithNotify(i, k + 1, j, Block.bedrock.blockID);
        worldObj.setBlockWithNotify(i, k + 2, j, Block.bedrock.blockID);
        worldObj.setBlockWithNotify(i - 1, k + 2, j, Block.torchWood.blockID);
        worldObj.setBlockWithNotify(i + 1, k + 2, j, Block.torchWood.blockID);
        worldObj.setBlockWithNotify(i, k + 2, j - 1, Block.torchWood.blockID);
        worldObj.setBlockWithNotify(i, k + 2, j + 1, Block.torchWood.blockID);
        worldObj.setBlockWithNotify(i, k + 3, j, Block.bedrock.blockID);
        worldObj.setBlockWithNotify(i, k + 4, j, Block.dragonEgg.blockID);
        BlockEndPortal.bossDefeated = false;
    }

    protected void despawnEntity()
    {
    }

    public Entity[] getParts()
    {
        return dragonPartArray;
    }

    public boolean canBeCollidedWith()
    {
        return false;
    }

    public int func_41010_ax()
    {
        return dataWatcher.getWatchableObjectInt(16);
    }
}

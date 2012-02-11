// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Entity, DamageSource, mod_splashFX, SplashNames, 
//            SplashColors, SplashEffects, World, ModLoader, 
//            EntityPlayerSP, ItemStack, Item, SplashProperties, 
//            AxisAlignedBB, MathHelper, Block, NBTTagCompound

public class EntityDSplashFX extends Entity
{

    public int splashAge;
    public int damagePassed;
    public int colorForegroundPassed;
    public int colorBackgroundPassed;
    public int updateTick;
    public int fadeout;
    public String typePassed;
    public static EntityPlayer entityplayer;
    public static Minecraft mc;

    public EntityDSplashFX(World world)
    {
        super(world);
        splashAge = 0;
        updateTick = 0;
        typePassed = "";
    }

    public EntityDSplashFX(World world, DamageSource damagesource, int i, double d, double d1, 
            double d2)
    {
        super(world);
        splashAge = 0;
        updateTick = 0;
        typePassed = "";
        setPosition(d, d1, d2);
        setSize(0.15F, 0.15F);
        motionX = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        motionY = (float)(Math.random() * 0.20000000000000001D) * 2.0F;
        motionZ = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        damagePassed = i;
        if(damagesource.func_40545_l() == "inFire")
        {
            SplashNames _tmp = mod_splashFX.names;
            SplashColors _tmp1 = mod_splashFX.colors;
            SplashColors _tmp2 = mod_splashFX.colors;
            SplashEffects _tmp3 = mod_splashFX.effects;
            SplashEffects _tmp4 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameFire, SplashColors.fireForegroundColor, SplashColors.fireBackgroundColor, SplashEffects.toggleFireSecondary, SplashEffects.toggleFireMain);
        }
        if(damagesource.func_40545_l() == "onFire")
        {
            SplashNames _tmp5 = mod_splashFX.names;
            SplashColors _tmp6 = mod_splashFX.colors;
            SplashColors _tmp7 = mod_splashFX.colors;
            SplashEffects _tmp8 = mod_splashFX.effects;
            SplashEffects _tmp9 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameFire, SplashColors.fireForegroundColor, SplashColors.fireBackgroundColor, SplashEffects.toggleFireSecondary, SplashEffects.toggleFireMain);
        }
        if(damagesource.func_40545_l() == "lava")
        {
            SplashNames _tmp10 = mod_splashFX.names;
            SplashColors _tmp11 = mod_splashFX.colors;
            SplashColors _tmp12 = mod_splashFX.colors;
            SplashEffects _tmp13 = mod_splashFX.effects;
            SplashEffects _tmp14 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameFire, SplashColors.fireForegroundColor, SplashColors.fireBackgroundColor, SplashEffects.toggleFireSecondary, SplashEffects.toggleFireMain);
        }
        if(damagesource.func_40545_l() == "inWall")
        {
            SplashNames _tmp15 = mod_splashFX.names;
            SplashColors _tmp16 = mod_splashFX.colors;
            SplashColors _tmp17 = mod_splashFX.colors;
            SplashEffects _tmp18 = mod_splashFX.effects;
            SplashEffects _tmp19 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameGeneric, SplashColors.genericForegroundColor, SplashColors.genericBackgroundColor, SplashEffects.toggleGenericSecondary, SplashEffects.toggleGenericMain);
        }
        if(damagesource.func_40545_l() == "drown")
        {
            SplashNames _tmp20 = mod_splashFX.names;
            SplashColors _tmp21 = mod_splashFX.colors;
            SplashColors _tmp22 = mod_splashFX.colors;
            SplashEffects _tmp23 = mod_splashFX.effects;
            SplashEffects _tmp24 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameDrown, SplashColors.drownForegroundColor, SplashColors.drownBackgroundColor, SplashEffects.toggleDrownSecondary, SplashEffects.toggleDrownMain);
        }
        if(damagesource.func_40545_l() == "starve")
        {
            SplashNames _tmp25 = mod_splashFX.names;
            SplashColors _tmp26 = mod_splashFX.colors;
            SplashColors _tmp27 = mod_splashFX.colors;
            SplashEffects _tmp28 = mod_splashFX.effects;
            SplashEffects _tmp29 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameStarve, SplashColors.starveForegroundColor, SplashColors.starveBackgroundColor, SplashEffects.toggleStarvationSecondary, SplashEffects.toggleStarvationMain);
        }
        if(damagesource.func_40545_l() == "cactus")
        {
            SplashNames _tmp30 = mod_splashFX.names;
            SplashColors _tmp31 = mod_splashFX.colors;
            SplashColors _tmp32 = mod_splashFX.colors;
            SplashEffects _tmp33 = mod_splashFX.effects;
            SplashEffects _tmp34 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameCactus, SplashColors.cactusForegroundColor, SplashColors.cactusBackgroundColor, SplashEffects.toggleCactusSecondary, SplashEffects.toggleCactusMain);
        }
        if(damagesource.func_40545_l() == "fall")
        {
            SplashNames _tmp35 = mod_splashFX.names;
            SplashColors _tmp36 = mod_splashFX.colors;
            SplashColors _tmp37 = mod_splashFX.colors;
            SplashEffects _tmp38 = mod_splashFX.effects;
            SplashEffects _tmp39 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameFall, SplashColors.fallForegroundColor, SplashColors.fallBackgroundColor, SplashEffects.toggleFallSecondary, SplashEffects.toggleFallMain);
        }
        if(damagesource.func_40545_l() == "outOfWorld")
        {
            SplashNames _tmp40 = mod_splashFX.names;
            SplashColors _tmp41 = mod_splashFX.colors;
            SplashColors _tmp42 = mod_splashFX.colors;
            SplashEffects _tmp43 = mod_splashFX.effects;
            SplashEffects _tmp44 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameGeneric, SplashColors.genericForegroundColor, SplashColors.genericBackgroundColor, SplashEffects.toggleGenericSecondary, SplashEffects.toggleGenericMain);
        }
        if(damagesource.func_40545_l() == "generic")
        {
            SplashNames _tmp45 = mod_splashFX.names;
            SplashColors _tmp46 = mod_splashFX.colors;
            SplashColors _tmp47 = mod_splashFX.colors;
            SplashEffects _tmp48 = mod_splashFX.effects;
            SplashEffects _tmp49 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameGeneric, SplashColors.genericForegroundColor, SplashColors.genericBackgroundColor, SplashEffects.toggleGenericSecondary, SplashEffects.toggleGenericMain);
        }
        if(damagesource.func_40545_l() == "explosion")
        {
            SplashNames _tmp50 = mod_splashFX.names;
            SplashColors _tmp51 = mod_splashFX.colors;
            SplashColors _tmp52 = mod_splashFX.colors;
            SplashEffects _tmp53 = mod_splashFX.effects;
            SplashEffects _tmp54 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameExplosion, SplashColors.explosionForegroundColor, SplashColors.explosionBackgroundColor, SplashEffects.toggleExplosionSecondary, SplashEffects.toggleExplosionMain);
        }
        if(damagesource.func_40545_l() == "magic")
        {
            SplashNames _tmp55 = mod_splashFX.names;
            SplashColors _tmp56 = mod_splashFX.colors;
            SplashColors _tmp57 = mod_splashFX.colors;
            SplashEffects _tmp58 = mod_splashFX.effects;
            SplashEffects _tmp59 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameMagic, SplashColors.magicForegroundColor, SplashColors.magicBackgroundColor, SplashEffects.toggleMagicSecondary, SplashEffects.toggleMagicMain);
        }
        if(damagesource.func_40545_l() == "player")
        {
           // if(/*ModLoader.getMinecraftInstance()*/mc.thePlayer.getCurrentEquippedItem() != null)
            //{
              //  SplashColors _tmp60 = mod_splashFX.colors;
                //SplashColors _tmp61 = mod_splashFX.colors;
                //SplashEffects _tmp62 = mod_splashFX.effects;
                //SplashEffects _tmp63 = mod_splashFX.effects;
                //setDamage("-", i, /*ModLoader.getMinecraftInstance()*/mc.thePlayer.getCurrentEquippedItem().getItem().func_40397_d(/*ModLoader.getMinecraftInstance()*/mc.thePlayer.getCurrentEquippedItem()), SplashColors.meleeForegroundColor, SplashColors.meleeBackgroundColor, SplashEffects.toggleMeleeSecondary, SplashEffects.toggleMeleeMain);
            //} else
            {
                SplashNames _tmp64 = mod_splashFX.names;
                SplashColors _tmp65 = mod_splashFX.colors;
                SplashColors _tmp66 = mod_splashFX.colors;
                SplashEffects _tmp67 = mod_splashFX.effects;
                SplashEffects _tmp68 = mod_splashFX.effects;
                setDamage("-", i, SplashNames.nameMelee, SplashColors.meleeForegroundColor, SplashColors.meleeBackgroundColor, SplashEffects.toggleMeleeSecondary, SplashEffects.toggleMeleeMain);
            }
        }
        if(damagesource.func_40545_l() == "arrow")
        {
            SplashNames _tmp69 = mod_splashFX.names;
            SplashColors _tmp70 = mod_splashFX.colors;
            SplashColors _tmp71 = mod_splashFX.colors;
            SplashEffects _tmp72 = mod_splashFX.effects;
            SplashEffects _tmp73 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameArrow, SplashColors.arrowForegroundColor, SplashColors.arrowBackgroundColor, SplashEffects.toggleArrowSecondary, SplashEffects.toggleArrowMain);
        }
        if(damagesource.func_40545_l() == "mob")
        {
            SplashNames _tmp74 = mod_splashFX.names;
            SplashColors _tmp75 = mod_splashFX.colors;
            SplashColors _tmp76 = mod_splashFX.colors;
            SplashEffects _tmp77 = mod_splashFX.effects;
            SplashEffects _tmp78 = mod_splashFX.effects;
            setDamage("-", i, SplashNames.nameMob, SplashColors.mobForegroundColor, SplashColors.mobBackgroundColor, SplashEffects.toggleMobSecondary, SplashEffects.toggleMobMain);
        }
        System.out.println(damagesource.func_40545_l());
        System.out.println(typePassed);
    }

    public EntityDSplashFX(World world, int i, double d, double d1, double d2)
    {
        super(world);
        splashAge = 0;
        updateTick = 0;
        typePassed = "";
        setPosition(d, d1, d2);
        setSize(0.15F, 0.15F);
        motionX = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        motionY = (float)(Math.random() * 0.20000000000000001D) * 2.0F;
        motionZ = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        SplashNames _tmp = mod_splashFX.names;
        SplashColors _tmp1 = mod_splashFX.colors;
        SplashColors _tmp2 = mod_splashFX.colors;
        SplashEffects _tmp3 = mod_splashFX.effects;
        SplashEffects _tmp4 = mod_splashFX.effects;
        setDamage("+", i, SplashNames.nameHealing, SplashColors.healingForegroundColor, SplashColors.healingBackgroundColor, SplashEffects.toggleHealingSecondary, SplashEffects.toggleHealingMain);
    }

    public void setDamage(String s, int i, String s1, int j, int k, boolean flag, boolean flag1)
    {
        colorForegroundPassed = j;
        colorBackgroundPassed = k;
        if(flag1 && flag)
        {
            typePassed = (new StringBuilder()).append(s).append(i).append(" (").append(s1).append(")").toString();
        }
        if(flag1 && !flag)
        {
            typePassed = (new StringBuilder()).append(s).append(i).toString();
        } else
        if(!flag1)
        {
            System.out.println("Entity deaded");
            setEntityDead();
        }
    }

    public void onUpdate()
    {
        updateTick++;
        SplashProperties _tmp = mod_splashFX.splashprops;
        double d = (double)updateTick / (double)SplashProperties.maxAge;
        d = 1.0D - d;
        if(d < 0.0D)
        {
            d = 0.0D;
        }
        if(d > 1.0D)
        {
            d = 1.0D;
        }
        d *= d;
        int i = (int)(255D * d);
        if(i > 0)
        {
            fadeout = i << 24;
        }
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        SplashProperties _tmp1 = mod_splashFX.splashprops;
        if(splashAge++ >= SplashProperties.maxAge)
        {
            setEntityDead();
        }
        moveEntity(motionX, motionY, motionZ);
        pushOutOfBlocks(posX, (boundingBox.minY + boundingBox.maxY) / 2D, posZ);
        motionY -= 0.029999999329447746D;
        float f = 0.98F;
        if(onGround)
        {
            f = 0.5880001F;
            int j = worldObj.getBlockId(MathHelper.floor_double(posX), MathHelper.floor_double(boundingBox.minY) - 1, MathHelper.floor_double(posZ));
            if(j > 0)
            {
                f = Block.blocksList[j].slipperiness * 0.98F;
            }
        }
        motionX *= f;
        SplashProperties _tmp2 = mod_splashFX.splashprops;
        motionY *= SplashProperties.gravity;
        motionZ *= f;
        if(onGround)
        {
            motionY *= -0.89999997615814209D;
        }
    }

    protected void entityInit()
    {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }
}

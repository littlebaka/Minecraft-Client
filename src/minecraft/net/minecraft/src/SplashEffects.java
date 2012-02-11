// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AEPropSection, AEProps

public class SplashEffects extends AEPropSection
{

    public static boolean toggleCactusMain = true;
    public static boolean toggleCactusSecondary = true;
    public static boolean toggleFireMain = true;
    public static boolean toggleFireSecondary = true;
    public static boolean toggleFallMain = true;
    public static boolean toggleFallSecondary = true;
    public static boolean toggleDrownMain = true;
    public static boolean toggleDrownSecondary = true;
    public static boolean toggleHealingMain = true;
    public static boolean toggleHealingSecondary = true;
    public static boolean toggleExplosionMain = true;
    public static boolean toggleExplosionSecondary = true;
    public static boolean toggleMagicMain = true;
    public static boolean toggleMagicSecondary = true;
    public static boolean toggleMobMain = true;
    public static boolean toggleMobSecondary = true;
    public static boolean toggleStarvationMain = true;
    public static boolean toggleStarvationSecondary = true;
    public static boolean toggleArrowMain = true;
    public static boolean toggleArrowSecondary = true;
    public static boolean toggleMeleeMain = true;
    public static boolean toggleMeleeSecondary = true;
    public static boolean toggleGenericMain = true;
    public static boolean toggleGenericSecondary = true;
    public static boolean toggleMain = true;

   public SplashEffects(AEProps aeprops)
    {
        super(aeprops, "Effect properties", "The main value toggles whether the particle should be called at all \n(With only the main value enabled you will only get the damage output without \nthe source of the damage, which is the second value). Second value toggles if \nthe effect should be visible on the particle. Example with both values true: \n\"-3 (Cactus)\". Example with main value true and secondary value false: \"-3\". All \nvalues are true by default. Options: true and false.\ntoggleMain turns on and off the mod, true by default.");
    }

}

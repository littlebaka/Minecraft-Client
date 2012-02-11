// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AEPropSection, AEProps

public class SplashNames extends AEPropSection
{

    public static String nameCactus = "Cactus";
    public static String nameFire = "Fire";
    public static String nameFall = "Fall";
    public static String nameDrown = "Drowning";
    public static String nameHealing = "Heal";
    public static String nameExplosion = "Explosion";
    public static String nameMagic = "Magic";
    public static String nameStarve = "Starvation";
    public static String nameArrow = "Arrow";
    public static String nameMelee = "Melee";
    public static String nameGeneric = "Generic";
    public static String nameMob = "Mob";

    public SplashNames(AEProps aeprops)
    {
        super(aeprops, "Name properties", "These strings represent what the source of damage is.");
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AEPropSection, AEProps

public class SplashProperties extends AEPropSection
{

    public static int maxAge = 120;
    public static int renderDistance = 30;
    public static double gravity = 0.98000001907348633D;

    public SplashProperties(AEProps aeprops)
    {
        super(aeprops, "Misc properties", "maxAge decides how long the particle should be alive.\nmaxAge uses \"ticks\", there are 20 ticks per second.\ngravity decides how the particle should act after it\njoins the world. The particle's Y-axis multiplies the\ngravity value, so a value of \"0.9\" would make it\ngradually decrease. renderDistance decides at what distance\nthe particle should be rendered at. It is measured in blocks.");
    }

}

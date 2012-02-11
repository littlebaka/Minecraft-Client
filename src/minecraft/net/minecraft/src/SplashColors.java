// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AEPropSection, AEProps

public class SplashColors extends AEPropSection
{

    public static int cactusForegroundColor = 0xbebebe;
    public static int cactusBackgroundColor = 0;
    public static int fireForegroundColor = 0xff7f00;
    public static int fireBackgroundColor = 0;
    public static int fallForegroundColor = 0xbebebe;
    public static int fallBackgroundColor = 0;
    public static int drownForegroundColor = 0xbebebe;
    public static int drownBackgroundColor = 0;
    public static int explosionForegroundColor = 0xfe2712;
    public static int explosionBackgroundColor = 0;
    public static int magicForegroundColor = 0xa020f0;
    public static int magicBackgroundColor = 0;
    public static int starveForegroundColor = 0xbebebe;
    public static int starveBackgroundColor = 0;
    public static int meleeForegroundColor = 0xfe2712;
    public static int meleeBackgroundColor = 0;
    public static int healingForegroundColor = 42320;
    public static int healingBackgroundColor = 0;
    public static int arrowForegroundColor = 0xfe2712;
    public static int arrowBackgroundColor = 0;
    public static int genericForegroundColor = 0xbebebe;
    public static int genericBackgroundColor = 0;
    public static int mobForegroundColor = 0xfe2712;
    public static int mobBackgroundColor = 0;

    public SplashColors(AEProps aeprops)
    {
        super(aeprops, "Color properties", "Foreground colors change the color of the\nfrontmost number in the middle. Background colors change\nthe color surrounding the middle one. To get colors for\nthe color format used, check out www.colorpicker.com");
    }

}

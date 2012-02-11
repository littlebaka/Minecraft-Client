// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            BaseMod, EntityDSplashFX, ModLoader, RenderDSplashFX, 
//            AEProps, SplashEffects, SplashNames, SplashColors, 
//            SplashProperties

public class mod_splashFX //extends BaseMod
{

    public static AEProps props;
    public static SplashEffects effects;
    public static SplashNames names;
    public static SplashColors colors;
    public static SplashProperties splashprops;

    /*public mod_splashFX()
    {
        ModLoader.RegisterEntityID(net.minecraft.src.EntityDSplashFX.class, "splash", ModLoader.getUniqueEntityId());
    }*/

    /*public void AddRenderer(Map map)
    {
        map.put(net.minecraft.src.EntityDSplashFX.class, new RenderDSplashFX());
    }*/

    /*public String getVersion()
    {
        return "0.1a for Minecraft 1.0";
    }

    public void load()
    {
    }*/

    static 
    {
        props = new AEProps("mod_splashy.cfg", "Splash mod 0.1a", "Lines starting with # mean comment lines, DO NOT EDIT THEM, it won't do anything.");
        effects = new SplashEffects(props);
        names = new SplashNames(props);
        colors = new SplashColors(props);
        splashprops = new SplashProperties(props);
        props.load();
        SplashEffects _tmp = effects;
        if(!SplashEffects.toggleArrowMain)
        {
            SplashEffects _tmp1 = effects;
            SplashEffects.toggleArrowSecondary = false;
        }
        SplashEffects _tmp2 = effects;
        if(!SplashEffects.toggleCactusMain)
        {
            SplashEffects _tmp3 = effects;
            SplashEffects.toggleCactusSecondary = false;
        }
        SplashEffects _tmp4 = effects;
        if(!SplashEffects.toggleDrownMain)
        {
            SplashEffects _tmp5 = effects;
            SplashEffects.toggleDrownSecondary = false;
        }
        SplashEffects _tmp6 = effects;
        if(!SplashEffects.toggleMobMain)
        {
            SplashEffects _tmp7 = effects;
            SplashEffects.toggleMobSecondary = false;
        }
        SplashEffects _tmp8 = effects;
        if(!SplashEffects.toggleExplosionMain)
        {
            SplashEffects _tmp9 = effects;
            SplashEffects.toggleExplosionSecondary = false;
        }
        SplashEffects _tmp10 = effects;
        if(!SplashEffects.toggleFallMain)
        {
            SplashEffects _tmp11 = effects;
            SplashEffects.toggleFallSecondary = false;
        }
        SplashEffects _tmp12 = effects;
        if(!SplashEffects.toggleFireMain)
        {
            SplashEffects _tmp13 = effects;
            SplashEffects.toggleFireSecondary = false;
        }
        SplashEffects _tmp14 = effects;
        if(!SplashEffects.toggleHealingMain)
        {
            SplashEffects _tmp15 = effects;
            SplashEffects.toggleHealingSecondary = false;
        }
        SplashEffects _tmp16 = effects;
        if(!SplashEffects.toggleMagicMain)
        {
            SplashEffects _tmp17 = effects;
            SplashEffects.toggleMagicSecondary = false;
        }
        SplashEffects _tmp18 = effects;
        if(!SplashEffects.toggleMeleeMain)
        {
            SplashEffects _tmp19 = effects;
            SplashEffects.toggleMeleeSecondary = false;
        }
        SplashEffects _tmp20 = effects;
        if(!SplashEffects.toggleStarvationMain)
        {
            SplashEffects _tmp21 = effects;
            SplashEffects.toggleStarvationSecondary = false;
        }
    }
}

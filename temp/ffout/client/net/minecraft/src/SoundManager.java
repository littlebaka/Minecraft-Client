// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.io.PrintStream;
import java.util.Random;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

// Referenced classes of package net.minecraft.src:
//            SoundPool, GameSettings, CodecMus, SoundPoolEntry, 
//            EntityLiving, MathHelper

public class SoundManager
{

    private static SoundSystem field_591_a;
    private SoundPool field_590_b;
    private SoundPool field_589_c;
    private SoundPool field_588_d;
    private int field_587_e;
    private GameSettings field_586_f;
    private static boolean field_585_g = false;
    private Random field_584_h;
    private int field_583_i;

    public SoundManager()
    {
        field_590_b = new SoundPool();
        field_589_c = new SoundPool();
        field_588_d = new SoundPool();
        field_587_e = 0;
        field_584_h = new Random();
        field_583_i = field_584_h.nextInt(12000);
    }

    public void func_340_a(GameSettings gamesettings)
    {
        field_589_c.field_1657_b = false;
        field_586_f = gamesettings;
        if(!field_585_g && (gamesettings == null || gamesettings.field_1583_b != 0.0F || gamesettings.field_1584_a != 0.0F))
        {
            func_339_d();
        }
    }

    private void func_339_d()
    {
        try
        {
            float f = field_586_f.field_1583_b;
            float f1 = field_586_f.field_1584_a;
            field_586_f.field_1583_b = 0.0F;
            field_586_f.field_1584_a = 0.0F;
            field_586_f.func_1041_b();
            SoundSystemConfig.addLibrary(paulscode.sound.libraries.LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", paulscode.sound.codecs.CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", net.minecraft.src.CodecMus.class);
            SoundSystemConfig.setCodec("wav", paulscode.sound.codecs.CodecWav.class);
            field_591_a = new SoundSystem();
            field_586_f.field_1583_b = f;
            field_586_f.field_1584_a = f1;
            field_586_f.func_1041_b();
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        field_585_g = true;
    }

    public void func_335_a()
    {
        if(!field_585_g && (field_586_f.field_1583_b != 0.0F || field_586_f.field_1584_a != 0.0F))
        {
            func_339_d();
        }
        if(field_585_g)
        {
            if(field_586_f.field_1584_a == 0.0F)
            {
                field_591_a.stop("BgMusic");
            } else
            {
                field_591_a.setVolume("BgMusic", field_586_f.field_1584_a);
            }
        }
    }

    public void func_330_b()
    {
        if(field_585_g)
        {
            field_591_a.cleanup();
        }
    }

    public void func_6372_a(String s, File file)
    {
        field_590_b.func_1117_a(s, file);
    }

    public void func_6373_b(String s, File file)
    {
        field_589_c.func_1117_a(s, file);
    }

    public void func_6374_c(String s, File file)
    {
        field_588_d.func_1117_a(s, file);
    }

    public void func_4033_c()
    {
        if(!field_585_g || field_586_f.field_1584_a == 0.0F)
        {
            return;
        }
        if(!field_591_a.playing("BgMusic") && !field_591_a.playing("streaming"))
        {
            if(field_583_i > 0)
            {
                field_583_i--;
                return;
            }
            SoundPoolEntry soundpoolentry = field_588_d.func_1116_a();
            if(soundpoolentry != null)
            {
                field_583_i = field_584_h.nextInt(12000) + 12000;
                field_591_a.backgroundMusic("BgMusic", soundpoolentry.field_1780_b, soundpoolentry.field_1781_a, false);
                field_591_a.setVolume("BgMusic", field_586_f.field_1584_a);
                field_591_a.play("BgMusic");
            }
        }
    }

    public void func_338_a(EntityLiving entityliving, float f)
    {
        if(!field_585_g || field_586_f.field_1583_b == 0.0F)
        {
            return;
        }
        if(entityliving == null)
        {
            return;
        } else
        {
            float f1 = entityliving.field_603_as + (entityliving.field_605_aq - entityliving.field_603_as) * f;
            double d = entityliving.field_9285_at + (entityliving.field_611_ak - entityliving.field_9285_at) * (double)f;
            double d1 = entityliving.field_9284_au + (entityliving.field_610_al - entityliving.field_9284_au) * (double)f;
            double d2 = entityliving.field_9283_av + (entityliving.field_609_am - entityliving.field_9283_av) * (double)f;
            float f2 = MathHelper.func_1114_b(-f1 * 0.01745329F - 3.141593F);
            float f3 = MathHelper.func_1106_a(-f1 * 0.01745329F - 3.141593F);
            float f4 = -f3;
            float f5 = 0.0F;
            float f6 = -f2;
            float f7 = 0.0F;
            float f8 = 1.0F;
            float f9 = 0.0F;
            field_591_a.setListenerPosition((float)d, (float)d1, (float)d2);
            field_591_a.setListenerOrientation(f4, f5, f6, f7, f8, f9);
            return;
        }
    }

    public void func_331_a(String s, float f, float f1, float f2, float f3, float f4)
    {
        if(!field_585_g || field_586_f.field_1583_b == 0.0F)
        {
            return;
        }
        String s1 = "streaming";
        if(field_591_a.playing("streaming"))
        {
            field_591_a.stop("streaming");
        }
        if(s == null)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = field_589_c.func_1118_a(s);
        if(soundpoolentry != null && f3 > 0.0F)
        {
            if(field_591_a.playing("BgMusic"))
            {
                field_591_a.stop("BgMusic");
            }
            float f5 = 16F;
            field_591_a.newStreamingSource(true, s1, soundpoolentry.field_1780_b, soundpoolentry.field_1781_a, false, f, f1, f2, 2, f5 * 4F);
            field_591_a.setVolume(s1, 0.5F * field_586_f.field_1583_b);
            field_591_a.play(s1);
        }
    }

    public void func_336_b(String s, float f, float f1, float f2, float f3, float f4)
    {
        if(!field_585_g || field_586_f.field_1583_b == 0.0F)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = field_590_b.func_1118_a(s);
        if(soundpoolentry != null && f3 > 0.0F)
        {
            field_587_e = (field_587_e + 1) % 256;
            String s1 = (new StringBuilder()).append("sound_").append(field_587_e).toString();
            float f5 = 16F;
            if(f3 > 1.0F)
            {
                f5 *= f3;
            }
            field_591_a.newSource(f3 > 1.0F, s1, soundpoolentry.field_1780_b, soundpoolentry.field_1781_a, false, f, f1, f2, 2, f5);
            field_591_a.setPitch(s1, f4);
            if(f3 > 1.0F)
            {
                f3 = 1.0F;
            }
            field_591_a.setVolume(s1, f3 * field_586_f.field_1583_b);
            field_591_a.play(s1);
        }
    }

    public void func_337_a(String s, float f, float f1)
    {
        if(!field_585_g || field_586_f.field_1583_b == 0.0F)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = field_590_b.func_1118_a(s);
        if(soundpoolentry != null)
        {
            field_587_e = (field_587_e + 1) % 256;
            String s1 = (new StringBuilder()).append("sound_").append(field_587_e).toString();
            field_591_a.newSource(false, s1, soundpoolentry.field_1780_b, soundpoolentry.field_1781_a, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            f *= 0.25F;
            field_591_a.setPitch(s1, f1);
            field_591_a.setVolume(s1, f * field_586_f.field_1583_b);
            field_591_a.play(s1);
        }
    }

}

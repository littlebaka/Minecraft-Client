// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.*;

public class OpenGlHelper
{

    public static int field_40457_a;
    public static int field_40455_b;
    private static boolean field_40456_c = false;

    public OpenGlHelper()
    {
    }

    public static void func_40453_a()
    {
        field_40456_c = GLContext.getCapabilities().GL_ARB_multitexture && !GLContext.getCapabilities().OpenGL13;
        if(field_40456_c)
        {
            field_40457_a = 33984;
            field_40455_b = 33985;
        } else
        {
            field_40457_a = 33984;
            field_40455_b = 33985;
        }
    }

    public static void func_40452_a(int i)
    {
        if(field_40456_c)
        {
            ARBMultitexture.glActiveTextureARB(i);
        } else
        {
            GL13.glActiveTexture(i);
        }
    }

    public static void func_40451_b(int i)
    {
        if(field_40456_c)
        {
            ARBMultitexture.glClientActiveTextureARB(i);
        } else
        {
            GL13.glClientActiveTexture(i);
        }
    }

    public static void func_40454_a(int i, float f, float f1)
    {
        if(field_40456_c)
        {
            ARBMultitexture.glMultiTexCoord2fARB(i, f, f1);
        } else
        {
            GL13.glMultiTexCoord2f(i, f, f1);
        }
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.*;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class GLAllocation
{

    private static List field_1671_a = new ArrayList();
    private static List field_1670_b = new ArrayList();

    public GLAllocation()
    {
    }

    public static synchronized int func_1124_a(int i)
    {
        int j = GL11.glGenLists(i);
        field_1671_a.add(Integer.valueOf(j));
        field_1671_a.add(Integer.valueOf(i));
        return j;
    }

    public static synchronized void func_1128_a(IntBuffer intbuffer)
    {
        GL11.glGenTextures(intbuffer);
        for(int i = intbuffer.position(); i < intbuffer.limit(); i++)
        {
            field_1670_b.add(Integer.valueOf(intbuffer.get(i)));
        }

    }

    public static synchronized void func_28194_b(int i)
    {
        int j = field_1671_a.indexOf(Integer.valueOf(i));
        GL11.glDeleteLists(((Integer)field_1671_a.get(j)).intValue(), ((Integer)field_1671_a.get(j + 1)).intValue());
        field_1671_a.remove(j);
        field_1671_a.remove(j);
    }

    public static synchronized void func_1126_a()
    {
        for(int i = 0; i < field_1671_a.size(); i += 2)
        {
            GL11.glDeleteLists(((Integer)field_1671_a.get(i)).intValue(), ((Integer)field_1671_a.get(i + 1)).intValue());
        }

        IntBuffer intbuffer = func_1125_c(field_1670_b.size());
        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        for(int j = 0; j < field_1670_b.size(); j++)
        {
            intbuffer.put(((Integer)field_1670_b.get(j)).intValue());
        }

        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        field_1671_a.clear();
        field_1670_b.clear();
    }

    public static synchronized ByteBuffer func_1127_b(int i)
    {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        return bytebuffer;
    }

    public static IntBuffer func_1125_c(int i)
    {
        return func_1127_b(i << 2).asIntBuffer();
    }

    public static FloatBuffer func_1123_d(int i)
    {
        return func_1127_b(i << 2).asFloatBuffer();
    }

}

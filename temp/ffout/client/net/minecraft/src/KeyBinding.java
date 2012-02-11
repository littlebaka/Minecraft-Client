// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IntHashMap

public class KeyBinding
{

    public static List field_35967_a = new ArrayList();
    public static IntHashMap field_35966_b = new IntHashMap();
    public String field_1371_a;
    public int field_1370_b;
    public boolean field_35965_e;
    public int field_35964_f;

    public static void func_35960_a(int i)
    {
        KeyBinding keybinding = (KeyBinding)field_35966_b.func_1057_a(i);
        if(keybinding != null)
        {
            keybinding.field_35964_f++;
        }
    }

    public static void func_35963_a(int i, boolean flag)
    {
        KeyBinding keybinding = (KeyBinding)field_35966_b.func_1057_a(i);
        if(keybinding != null)
        {
            keybinding.field_35965_e = flag;
        }
    }

    public static void func_35959_a()
    {
        KeyBinding keybinding;
        for(Iterator iterator = field_35967_a.iterator(); iterator.hasNext(); keybinding.func_35958_d())
        {
            keybinding = (KeyBinding)iterator.next();
        }

    }

    public static void func_35961_b()
    {
        field_35966_b.func_1058_a();
        KeyBinding keybinding;
        for(Iterator iterator = field_35967_a.iterator(); iterator.hasNext(); field_35966_b.func_1061_a(keybinding.field_1370_b, keybinding))
        {
            keybinding = (KeyBinding)iterator.next();
        }

    }

    public KeyBinding(String s, int i)
    {
        field_35964_f = 0;
        field_1371_a = s;
        field_1370_b = i;
        field_35967_a.add(this);
        field_35966_b.func_1061_a(i, this);
    }

    public boolean func_35962_c()
    {
        if(field_35964_f == 0)
        {
            return false;
        } else
        {
            field_35964_f--;
            return true;
        }
    }

    private void func_35958_d()
    {
        field_35964_f = 0;
        field_35965_e = false;
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

// Referenced classes of package net.minecraft.src:
//            PanelCrashReport, UnexpectedThrowable

public class MinecraftAppletImpl extends Minecraft
{

    final MinecraftApplet field_186_a; /* synthetic field */

    public MinecraftAppletImpl(MinecraftApplet minecraftapplet, Component component, Canvas canvas, MinecraftApplet minecraftapplet1, int i, int j, boolean flag)
    {
        field_186_a = minecraftapplet;
        super(component, canvas, minecraftapplet1, i, j, flag);
    }

    public void func_4007_a(UnexpectedThrowable unexpectedthrowable)
    {
        field_186_a.removeAll();
        field_186_a.setLayout(new BorderLayout());
        field_186_a.add(new PanelCrashReport(unexpectedthrowable), "Center");
        field_186_a.validate();
    }
}

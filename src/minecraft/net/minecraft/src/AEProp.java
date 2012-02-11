// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.annotation.Annotation;

public interface AEProp
    extends Annotation
{

    public abstract String help();

    public abstract String[] choices();

    public abstract double min();

    public abstract double max();

    public abstract boolean isKeybinding();

    public abstract boolean isColor();
}

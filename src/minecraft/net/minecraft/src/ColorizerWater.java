package net.minecraft.src;

public class ColorizerWater
{
    private static int waterBuffer[] = new int[0x10000];

    public ColorizerWater()
    {
    }

    public static void setWaterBiomeColorizer(int ai[])
    {
        waterBuffer = ai;
    }
}

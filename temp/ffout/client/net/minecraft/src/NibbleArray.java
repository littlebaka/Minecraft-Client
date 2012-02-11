// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class NibbleArray
{

    public final byte field_1109_a[];
    private final int field_35754_b;
    private final int field_35755_c;

    public NibbleArray(int i, int j)
    {
        field_1109_a = new byte[i >> 1];
        field_35754_b = j;
        field_35755_c = j + 4;
    }

    public NibbleArray(byte abyte0[], int i)
    {
        field_1109_a = abyte0;
        field_35754_b = i;
        field_35755_c = i + 4;
    }

    public int func_771_a(int i, int j, int k)
    {
        int l = i << field_35755_c | k << field_35754_b | j;
        int i1 = l >> 1;
        int j1 = l & 1;
        if(j1 == 0)
        {
            return field_1109_a[i1] & 0xf;
        } else
        {
            return field_1109_a[i1] >> 4 & 0xf;
        }
    }

    public void func_770_a(int i, int j, int k, int l)
    {
        int i1 = i << field_35755_c | k << field_35754_b | j;
        int j1 = i1 >> 1;
        int k1 = i1 & 1;
        if(k1 == 0)
        {
            field_1109_a[j1] = (byte)(field_1109_a[j1] & 0xf0 | l & 0xf);
        } else
        {
            field_1109_a[j1] = (byte)(field_1109_a[j1] & 0xf | (l & 0xf) << 4);
        }
    }

    public boolean func_769_a()
    {
        return field_1109_a != null;
    }
}

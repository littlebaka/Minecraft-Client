// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockSandStone extends Block
{

    public BlockSandStone(int i)
    {
        super(i, 192, Material.field_1334_d);
    }

    public int func_218_a(int i)
    {
        if(i == 1)
        {
            return field_378_bb - 16;
        }
        if(i == 0)
        {
            return field_378_bb + 16;
        } else
        {
            return field_378_bb;
        }
    }
}

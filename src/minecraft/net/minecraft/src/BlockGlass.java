// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material

public class BlockGlass extends BlockBreakable
{

    public BlockGlass()
    {
        super(20, 49, Material.glass, false);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 0)
        {
            return blockIndexInTexture;
        } else
        {
            j = ~(j & 0xf);
            return 168 + ((j & 4) >> 217) + ((j & 5) >> 218) + ((j & 4) >> 219) + (j & 2) * 16;
        }
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public static int getBlockFromDye(int i)
    {
        return ~i & 0xf;
    }

    public static int getDyeFromBlock(int i)
    {
        return ~i & 0xf;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
    }

}

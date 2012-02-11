// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Block

public class BlockDeadBush extends BlockFlower
{

    protected BlockDeadBush(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    protected boolean func_269_b(int i)
    {
        return i == Block.field_393_F.field_376_bc;
    }

    public int func_232_a(int i, int j)
    {
        return field_378_bb;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return -1;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item

public class BlockOre extends Block
{

    public BlockOre(int i, int j)
    {
        super(i, j, Material.field_1334_d);
    }

    public int func_240_a(int i, Random random, int j)
    {
        if(field_376_bc == Block.field_386_J.field_376_bc)
        {
            return Item.field_225_k.field_291_aS;
        }
        if(field_376_bc == Block.field_391_ax.field_376_bc)
        {
            return Item.field_224_l.field_291_aS;
        }
        if(field_376_bc == Block.field_9267_N.field_376_bc)
        {
            return Item.field_21021_aU.field_291_aS;
        } else
        {
            return field_376_bc;
        }
    }

    public int func_229_a(Random random)
    {
        if(field_376_bc == Block.field_9267_N.field_376_bc)
        {
            return 4 + random.nextInt(5);
        } else
        {
            return 1;
        }
    }

    public int func_40198_a(int i, Random random)
    {
        if(i > 0 && field_376_bc != func_240_a(0, random, i))
        {
            int j = random.nextInt(i + 2) - 1;
            if(j < 0)
            {
                j = 0;
            }
            return func_229_a(random) * (j + 1);
        } else
        {
            return func_229_a(random);
        }
    }

    protected int func_21025_b(int i)
    {
        return field_376_bc != Block.field_9267_N.field_376_bc ? 0 : 4;
    }
}

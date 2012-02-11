// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentStrongholdCorridor extends ComponentStronghold
{

    private final int field_35052_a;

    public ComponentStrongholdCorridor(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
        field_35052_a = j != 2 && j != 0 ? structureboundingbox.func_35744_b() : structureboundingbox.func_35739_d();
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static StructureBoundingBox func_35051_a(List list, Random random, int i, int j, int k, int l)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -1, 0, 5, 5, 4, l);
        StructureComponent structurecomponent = StructureComponent.func_35020_a(list, structureboundingbox);
        if(structurecomponent == null)
        {
            return null;
        }
        if(structurecomponent.func_35021_b().field_35751_b == structureboundingbox.field_35751_b)
        {
            for(int i1 = 3; i1 >= 1; i1--)
            {
                StructureBoundingBox structureboundingbox1 = StructureBoundingBox.func_35747_a(i, j, k, -1, -1, 0, 5, 5, i1 - 1, l);
                if(!structurecomponent.func_35021_b().func_35740_a(structureboundingbox1))
                {
                    return StructureBoundingBox.func_35747_a(i, j, k, -1, -1, 0, 5, 5, i1, l);
                }
            }

        }
        return null;
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        for(int i = 0; i < field_35052_a; i++)
        {
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 0, 0, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 0, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 2, 0, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 3, 0, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 4, 0, i, structureboundingbox);
            for(int j = 1; j <= 3; j++)
            {
                func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 0, j, i, structureboundingbox);
                func_35018_a(world, 0, 0, 1, j, i, structureboundingbox);
                func_35018_a(world, 0, 0, 2, j, i, structureboundingbox);
                func_35018_a(world, 0, 0, 3, j, i, structureboundingbox);
                func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 4, j, i, structureboundingbox);
            }

            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 0, 4, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 4, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 2, 4, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 3, 4, i, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 4, 4, i, structureboundingbox);
        }

        return true;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, World

public class ComponentStrongholdStairsStraight extends ComponentStronghold
{

    private final EnumDoor field_35054_a;

    public ComponentStrongholdStairsStraight(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35054_a = func_35031_a(random);
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_35028_a((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
    }

    public static ComponentStrongholdStairsStraight func_35053_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -7, 0, 5, 11, 8, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdStairsStraight(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        func_35022_a(world, structureboundingbox, 0, 0, 0, 4, 10, 7, true, random, StructureStrongholdPieces.func_35852_b());
        func_35033_a(world, random, structureboundingbox, field_35054_a, 1, 7, 0);
        func_35033_a(world, random, structureboundingbox, EnumDoor.OPENING, 1, 1, 7);
        int i = func_35009_c(Block.field_4069_aI.field_376_bc, 2);
        for(int j = 0; j < 6; j++)
        {
            func_35018_a(world, Block.field_4069_aI.field_376_bc, i, 1, 6 - j, 1 + j, structureboundingbox);
            func_35018_a(world, Block.field_4069_aI.field_376_bc, i, 2, 6 - j, 1 + j, structureboundingbox);
            func_35018_a(world, Block.field_4069_aI.field_376_bc, i, 3, 6 - j, 1 + j, structureboundingbox);
            if(j < 5)
            {
                func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 5 - j, 1 + j, structureboundingbox);
                func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 2, 5 - j, 1 + j, structureboundingbox);
                func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 3, 5 - j, 1 + j, structureboundingbox);
            }
        }

        return true;
    }
}

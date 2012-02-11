// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, Block, EnumDoor, World

public class ComponentStrongholdPrison extends ComponentStronghold
{

    protected final EnumDoor field_35064_a;

    public ComponentStrongholdPrison(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35064_a = func_35031_a(random);
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_35028_a((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
    }

    public static ComponentStrongholdPrison func_35063_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -1, 0, 9, 5, 11, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdPrison(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        } else
        {
            func_35022_a(world, structureboundingbox, 0, 0, 0, 8, 4, 10, true, random, StructureStrongholdPieces.func_35852_b());
            func_35033_a(world, random, structureboundingbox, field_35064_a, 1, 1, 0);
            func_35011_a(world, structureboundingbox, 1, 1, 10, 3, 3, 10, 0, 0, false);
            func_35022_a(world, structureboundingbox, 4, 1, 1, 4, 3, 1, false, random, StructureStrongholdPieces.func_35852_b());
            func_35022_a(world, structureboundingbox, 4, 1, 3, 4, 3, 3, false, random, StructureStrongholdPieces.func_35852_b());
            func_35022_a(world, structureboundingbox, 4, 1, 7, 4, 3, 7, false, random, StructureStrongholdPieces.func_35852_b());
            func_35022_a(world, structureboundingbox, 4, 1, 9, 4, 3, 9, false, random, StructureStrongholdPieces.func_35852_b());
            func_35011_a(world, structureboundingbox, 4, 1, 4, 4, 3, 6, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 5, 1, 5, 7, 3, 5, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, 4, 3, 2, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, 4, 3, 8, structureboundingbox);
            func_35018_a(world, Block.field_435_aM.field_376_bc, func_35009_c(Block.field_435_aM.field_376_bc, 3), 4, 1, 2, structureboundingbox);
            func_35018_a(world, Block.field_435_aM.field_376_bc, func_35009_c(Block.field_435_aM.field_376_bc, 3) + 8, 4, 2, 2, structureboundingbox);
            func_35018_a(world, Block.field_435_aM.field_376_bc, func_35009_c(Block.field_435_aM.field_376_bc, 3), 4, 1, 8, structureboundingbox);
            func_35018_a(world, Block.field_435_aM.field_376_bc, func_35009_c(Block.field_435_aM.field_376_bc, 3) + 8, 4, 2, 8, structureboundingbox);
            return true;
        }
    }
}

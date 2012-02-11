// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCorridor2 extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCorridor2(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_40016_c((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 0, 1, true);
    }

    public static ComponentNetherBridgeCorridor2 func_40041_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, 0, 0, 5, 7, 5, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCorridor2(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35011_a(world, structureboundingbox, 0, 0, 0, 4, 1, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 4, 5, 4, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 0, 5, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 3, 1, 0, 4, 1, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 3, 3, 0, 4, 3, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 4, 2, 0, 4, 5, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 2, 4, 4, 5, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 3, 4, 1, 4, 4, Block.field_40207_bC.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 3, 3, 4, 3, 4, 4, Block.field_40207_bC.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 6, 0, 4, 6, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        for(int i = 0; i <= 4; i++)
        {
            for(int j = 0; j <= 4; j++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, i, -1, j, structureboundingbox);
            }

        }

        return true;
    }
}

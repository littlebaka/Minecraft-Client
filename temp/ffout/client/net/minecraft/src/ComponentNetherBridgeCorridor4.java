// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCorridor4 extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCorridor4(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        byte byte0 = 1;
        if(field_35025_h == 1 || field_35025_h == 2)
        {
            byte0 = 5;
        }
        func_40019_b((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 0, byte0, random.nextInt(8) > 0);
        func_40016_c((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 0, byte0, random.nextInt(8) > 0);
    }

    public static ComponentNetherBridgeCorridor4 func_40039_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -3, 0, 0, 9, 7, 9, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCorridor4(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35011_a(world, structureboundingbox, 0, 0, 0, 8, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 8, 5, 8, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 6, 0, 8, 6, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 2, 5, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 2, 0, 8, 5, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 3, 0, 1, 4, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 3, 0, 7, 4, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 4, 8, 2, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 1, 4, 2, 2, 4, 0, 0, false);
        func_35011_a(world, structureboundingbox, 6, 1, 4, 7, 2, 4, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 3, 8, 8, 3, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 3, 6, 0, 3, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 3, 6, 8, 3, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 3, 4, 0, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 3, 4, 8, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 3, 5, 2, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 3, 5, 7, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 4, 5, 1, 5, 5, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 4, 5, 7, 5, 5, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        for(int i = 0; i <= 5; i++)
        {
            for(int j = 0; j <= 8; j++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, j, -1, i, structureboundingbox);
            }

        }

        return true;
    }
}

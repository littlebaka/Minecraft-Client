// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCorridor3 extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCorridor3(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_40022_a((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 1, 0, true);
    }

    public static ComponentNetherBridgeCorridor3 func_40042_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -7, 0, 5, 14, 10, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCorridor3(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        int i = func_35009_c(Block.field_40204_bD.field_376_bc, 2);
        for(int j = 0; j <= 9; j++)
        {
            int k = Math.max(1, 7 - j);
            int l = Math.min(Math.max(k + 5, 14 - j), 13);
            int i1 = j;
            func_35011_a(world, structureboundingbox, 0, 0, i1, 4, k, i1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 1, k + 1, i1, 3, l - 1, i1, 0, 0, false);
            if(j <= 6)
            {
                func_35018_a(world, Block.field_40204_bD.field_376_bc, i, 1, k + 1, i1, structureboundingbox);
                func_35018_a(world, Block.field_40204_bD.field_376_bc, i, 2, k + 1, i1, structureboundingbox);
                func_35018_a(world, Block.field_40204_bD.field_376_bc, i, 3, k + 1, i1, structureboundingbox);
            }
            func_35011_a(world, structureboundingbox, 0, l, i1, 4, l, i1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 0, k + 1, i1, 0, l - 1, i1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 4, k + 1, i1, 4, l - 1, i1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
            if((j & 1) == 0)
            {
                func_35011_a(world, structureboundingbox, 0, k + 2, i1, 0, k + 3, i1, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
                func_35011_a(world, structureboundingbox, 4, k + 2, i1, 4, k + 3, i1, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            }
            for(int j1 = 0; j1 <= 4; j1++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, j1, -1, i1, structureboundingbox);
            }

        }

        return true;
    }
}

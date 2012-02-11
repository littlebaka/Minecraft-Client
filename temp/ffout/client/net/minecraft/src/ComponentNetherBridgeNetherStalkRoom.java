// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeNetherStalkRoom extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeNetherStalkRoom(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_40022_a((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 5, 3, true);
        func_40022_a((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 5, 11, true);
    }

    public static ComponentNetherBridgeNetherStalkRoom func_40040_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -5, -3, 0, 13, 14, 13, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeNetherStalkRoom(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35011_a(world, structureboundingbox, 0, 3, 0, 12, 4, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 5, 0, 12, 13, 12, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 5, 0, 1, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 11, 5, 0, 12, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 5, 11, 4, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 5, 11, 10, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 9, 11, 7, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 5, 0, 4, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 5, 0, 10, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 9, 0, 7, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 11, 2, 10, 12, 10, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        for(int i = 1; i <= 11; i += 2)
        {
            func_35011_a(world, structureboundingbox, i, 10, 0, i, 11, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(world, structureboundingbox, i, 10, 12, i, 11, 12, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 0, 10, i, 0, 11, i, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 12, 10, i, 12, 11, i, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35018_a(world, Block.field_40206_bB.field_376_bc, 0, i, 13, 0, structureboundingbox);
            func_35018_a(world, Block.field_40206_bB.field_376_bc, 0, i, 13, 12, structureboundingbox);
            func_35018_a(world, Block.field_40206_bB.field_376_bc, 0, 0, 13, i, structureboundingbox);
            func_35018_a(world, Block.field_40206_bB.field_376_bc, 0, 12, 13, i, structureboundingbox);
            func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, i + 1, 13, 0, structureboundingbox);
            func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, i + 1, 13, 12, structureboundingbox);
            func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 0, 13, i + 1, structureboundingbox);
            func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 12, 13, i + 1, structureboundingbox);
        }

        func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 0, 13, 0, structureboundingbox);
        func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 0, 13, 12, structureboundingbox);
        func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 0, 13, 0, structureboundingbox);
        func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 12, 13, 0, structureboundingbox);
        for(int j = 3; j <= 9; j += 2)
        {
            func_35011_a(world, structureboundingbox, 1, 7, j, 1, 8, j, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 11, 7, j, 11, 8, j, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        }

        int k = func_35009_c(Block.field_40204_bD.field_376_bc, 3);
        for(int l = 0; l <= 6; l++)
        {
            int k1 = l + 4;
            for(int i2 = 5; i2 <= 7; i2++)
            {
                func_35018_a(world, Block.field_40204_bD.field_376_bc, k, i2, 5 + l, k1, structureboundingbox);
            }

            if(k1 >= 5 && k1 <= 8)
            {
                func_35011_a(world, structureboundingbox, 5, 5, k1, 7, l + 4, k1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
            } else
            if(k1 >= 9 && k1 <= 10)
            {
                func_35011_a(world, structureboundingbox, 5, 8, k1, 7, l + 4, k1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
            }
            if(l >= 1)
            {
                func_35011_a(world, structureboundingbox, 5, 6 + l, k1, 7, 9 + l, k1, 0, 0, false);
            }
        }

        for(int i1 = 5; i1 <= 7; i1++)
        {
            func_35018_a(world, Block.field_40204_bD.field_376_bc, k, i1, 12, 11, structureboundingbox);
        }

        func_35011_a(world, structureboundingbox, 5, 6, 7, 5, 7, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 6, 7, 7, 7, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 13, 12, 7, 13, 12, 0, 0, false);
        func_35011_a(world, structureboundingbox, 2, 5, 2, 3, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 5, 9, 3, 5, 10, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 5, 4, 2, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 9, 5, 2, 10, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 9, 5, 9, 10, 5, 10, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 10, 5, 4, 10, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        int j1 = func_35009_c(Block.field_40204_bD.field_376_bc, 0);
        int l1 = func_35009_c(Block.field_40204_bD.field_376_bc, 1);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, l1, 4, 5, 2, structureboundingbox);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, l1, 4, 5, 3, structureboundingbox);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, l1, 4, 5, 9, structureboundingbox);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, l1, 4, 5, 10, structureboundingbox);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, j1, 8, 5, 2, structureboundingbox);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, j1, 8, 5, 3, structureboundingbox);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, j1, 8, 5, 9, structureboundingbox);
        func_35018_a(world, Block.field_40204_bD.field_376_bc, j1, 8, 5, 10, structureboundingbox);
        func_35011_a(world, structureboundingbox, 3, 4, 4, 4, 4, 8, Block.field_4051_bd.field_376_bc, Block.field_4051_bd.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 4, 4, 9, 4, 8, Block.field_4051_bd.field_376_bc, Block.field_4051_bd.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 3, 5, 4, 4, 5, 8, Block.field_40205_bE.field_376_bc, Block.field_40205_bE.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 5, 4, 9, 5, 8, Block.field_40205_bE.field_376_bc, Block.field_40205_bE.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 4, 2, 0, 8, 2, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 4, 12, 2, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 4, 0, 0, 8, 1, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 4, 0, 9, 8, 1, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 0, 4, 3, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 9, 0, 4, 12, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        for(int j2 = 4; j2 <= 8; j2++)
        {
            for(int l2 = 0; l2 <= 2; l2++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, j2, -1, l2, structureboundingbox);
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, j2, -1, 12 - l2, structureboundingbox);
            }

        }

        for(int k2 = 0; k2 <= 2; k2++)
        {
            for(int i3 = 4; i3 <= 8; i3++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, k2, -1, i3, structureboundingbox);
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, 12 - k2, -1, i3, structureboundingbox);
            }

        }

        return true;
    }
}

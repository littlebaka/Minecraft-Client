// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, StructureBoundingBox, ComponentNetherBridgeStartPiece, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCrossing3 extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCrossing3(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    protected ComponentNetherBridgeCrossing3(Random random, int i, int j)
    {
        super(0);
        field_35025_h = random.nextInt(4);
        switch(field_35025_h)
        {
        case 0: // '\0'
        case 2: // '\002'
            field_35024_g = new StructureBoundingBox(i, 64, j, (i + 19) - 1, 73, (j + 19) - 1);
            break;

        default:
            field_35024_g = new StructureBoundingBox(i, 64, j, (i + 19) - 1, 73, (j + 19) - 1);
            break;
        }
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_40022_a((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 8, 3, false);
        func_40019_b((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 3, 8, false);
        func_40016_c((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 3, 8, false);
    }

    public static ComponentNetherBridgeCrossing3 func_40033_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -8, -3, 0, 19, 10, 19, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCrossing3(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35011_a(world, structureboundingbox, 7, 3, 0, 11, 4, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 3, 7, 18, 4, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 5, 0, 10, 7, 18, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 5, 8, 18, 7, 10, 0, 0, false);
        func_35011_a(world, structureboundingbox, 7, 5, 0, 7, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 5, 11, 7, 5, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 11, 5, 0, 11, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 11, 5, 11, 11, 5, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 5, 7, 7, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 11, 5, 7, 18, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 5, 11, 7, 5, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 11, 5, 11, 18, 5, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 2, 0, 11, 2, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 2, 13, 11, 2, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 0, 0, 11, 1, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 0, 15, 11, 1, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        for(int i = 7; i <= 11; i++)
        {
            for(int k = 0; k <= 2; k++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, i, -1, k, structureboundingbox);
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, i, -1, 18 - k, structureboundingbox);
            }

        }

        func_35011_a(world, structureboundingbox, 0, 2, 7, 5, 2, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 13, 2, 7, 18, 2, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 0, 7, 3, 1, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 15, 0, 7, 18, 1, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        for(int j = 0; j <= 2; j++)
        {
            for(int l = 7; l <= 11; l++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, j, -1, l, structureboundingbox);
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, 18 - j, -1, l, structureboundingbox);
            }

        }

        return true;
    }
}

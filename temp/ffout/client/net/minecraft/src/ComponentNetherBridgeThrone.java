// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, StructureBoundingBox, StructureComponent, Block, 
//            World, TileEntityMobSpawner

public class ComponentNetherBridgeThrone extends ComponentNetherBridgePiece
{

    private boolean field_40027_a;

    public ComponentNetherBridgeThrone(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentNetherBridgeThrone func_40026_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -2, 0, 0, 7, 8, 9, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeThrone(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35011_a(world, structureboundingbox, 0, 2, 0, 6, 7, 7, 0, 0, false);
        func_35011_a(world, structureboundingbox, 1, 0, 0, 5, 1, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 2, 1, 5, 2, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 3, 2, 5, 3, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 4, 3, 5, 4, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 2, 0, 1, 4, 2, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 2, 0, 5, 4, 2, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 5, 2, 1, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 5, 2, 5, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 5, 3, 0, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 5, 3, 6, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 5, 8, 5, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 1, 6, 3, structureboundingbox);
        func_35018_a(world, Block.field_40207_bC.field_376_bc, 0, 5, 6, 3, structureboundingbox);
        func_35011_a(world, structureboundingbox, 0, 6, 3, 0, 6, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 6, 3, 6, 6, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 6, 8, 5, 7, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 8, 8, 4, 8, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        if(!field_40027_a)
        {
            int i = func_35008_a(5);
            int k = func_35017_a(3, 5);
            int i1 = func_35006_b(3, 5);
            if(structureboundingbox.func_35742_b(k, i, i1))
            {
                field_40027_a = true;
                world.func_690_d(k, i, i1, Block.field_400_at.field_376_bc);
                TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.func_603_b(k, i, i1);
                if(tileentitymobspawner != null)
                {
                    tileentitymobspawner.func_21098_a("Blaze");
                }
            }
        }
        for(int j = 0; j <= 6; j++)
        {
            for(int l = 0; l <= 6; l++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, j, -1, l, structureboundingbox);
            }

        }

        return true;
    }
}

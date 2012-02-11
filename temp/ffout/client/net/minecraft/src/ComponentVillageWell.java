// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, ComponentVillageStartPiece, StructureVillagePieces, 
//            Block, StructureComponent, World

public class ComponentVillageWell extends ComponentVillage
{

    private final boolean field_35104_a = true;
    private int field_35103_b;

    public ComponentVillageWell(int i, Random random, int j, int k)
    {
        super(i);
        field_35103_b = -1;
        field_35025_h = random.nextInt(4);
        switch(field_35025_h)
        {
        case 0: // '\0'
        case 2: // '\002'
            field_35024_g = new StructureBoundingBox(j, 64, k, (j + 6) - 1, 78, (k + 6) - 1);
            break;

        default:
            field_35024_g = new StructureBoundingBox(j, 64, k, (j + 6) - 1, 78, (k + 6) - 1);
            break;
        }
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35750_e - 4, field_35024_g.field_35752_c + 1, 1, func_35012_c());
        StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35750_e - 4, field_35024_g.field_35752_c + 1, 3, func_35012_c());
        StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35750_e - 4, field_35024_g.field_35752_c - 1, 2, func_35012_c());
        StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35750_e - 4, field_35024_g.field_35748_f + 1, 0, func_35012_c());
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35103_b < 0)
        {
            field_35103_b = func_35075_b(world, structureboundingbox);
            if(field_35103_b < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, (field_35103_b - field_35024_g.field_35750_e) + 3, 0);
        }
        if(!field_35104_a);
        func_35011_a(world, structureboundingbox, 1, 0, 1, 4, 12, 4, Block.field_335_x.field_376_bc, Block.field_401_B.field_376_bc, false);
        func_35018_a(world, 0, 0, 2, 12, 2, structureboundingbox);
        func_35018_a(world, 0, 0, 3, 12, 2, structureboundingbox);
        func_35018_a(world, 0, 0, 2, 12, 3, structureboundingbox);
        func_35018_a(world, 0, 0, 3, 12, 3, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 1, 13, 1, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 1, 14, 1, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 4, 13, 1, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 4, 14, 1, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 1, 13, 4, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 1, 14, 4, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 4, 13, 4, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 4, 14, 4, structureboundingbox);
        func_35011_a(world, structureboundingbox, 1, 15, 1, 4, 15, 4, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        for(int i = 0; i <= 5; i++)
        {
            for(int j = 0; j <= 5; j++)
            {
                if(j == 0 || j == 5 || i == 0 || i == 5)
                {
                    func_35018_a(world, Block.field_392_G.field_376_bc, 0, j, 11, i, structureboundingbox);
                    func_35016_b(world, j, 12, i, structureboundingbox);
                }
            }

        }

        return true;
    }
}

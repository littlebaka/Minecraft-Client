// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentVillageTorch extends ComponentVillage
{

    private int field_35100_a;

    public ComponentVillageTorch(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35100_a = -1;
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static StructureBoundingBox func_35099_a(List list, Random random, int i, int j, int k, int l)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 3, 4, 2, l);
        if(StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return structureboundingbox;
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35100_a < 0)
        {
            field_35100_a = func_35075_b(world, structureboundingbox);
            if(field_35100_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35100_a - field_35024_g.field_35750_e) + 4) - 1, 0);
        }
        func_35011_a(world, structureboundingbox, 0, 0, 0, 2, 3, 1, 0, 0, false);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 1, 0, 0, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 1, 1, 0, structureboundingbox);
        func_35018_a(world, Block.field_4057_ba.field_376_bc, 0, 1, 2, 0, structureboundingbox);
        func_35018_a(world, Block.field_419_ac.field_376_bc, 15, 1, 3, 0, structureboundingbox);
        func_35018_a(world, Block.field_404_ar.field_376_bc, 15, 0, 3, 0, structureboundingbox);
        func_35018_a(world, Block.field_404_ar.field_376_bc, 15, 1, 3, 1, structureboundingbox);
        func_35018_a(world, Block.field_404_ar.field_376_bc, 15, 2, 3, 0, structureboundingbox);
        func_35018_a(world, Block.field_404_ar.field_376_bc, 15, 1, 3, -1, structureboundingbox);
        return true;
    }
}

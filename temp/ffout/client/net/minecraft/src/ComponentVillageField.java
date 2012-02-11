// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            MathHelper, World

public class ComponentVillageField extends ComponentVillage
{

    private int field_35081_a;

    public ComponentVillageField(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35081_a = -1;
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentVillageField func_35080_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 13, 4, 9, l);
        if(!func_35074_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageField(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35081_a < 0)
        {
            field_35081_a = func_35075_b(world, structureboundingbox);
            if(field_35081_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35081_a - field_35024_g.field_35750_e) + 4) - 1, 0);
        }
        func_35011_a(world, structureboundingbox, 0, 1, 0, 12, 4, 8, 0, 0, false);
        func_35011_a(world, structureboundingbox, 1, 0, 1, 2, 0, 7, Block.field_446_aB.field_376_bc, Block.field_446_aB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 4, 0, 1, 5, 0, 7, Block.field_446_aB.field_376_bc, Block.field_446_aB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 0, 1, 8, 0, 7, Block.field_446_aB.field_376_bc, Block.field_446_aB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 10, 0, 1, 11, 0, 7, Block.field_446_aB.field_376_bc, Block.field_446_aB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 0, 0, 0, 0, 8, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 0, 0, 6, 0, 8, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 12, 0, 0, 12, 0, 8, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 0, 0, 11, 0, 0, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 0, 8, 11, 0, 8, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 3, 0, 1, 3, 0, 7, Block.field_401_B.field_376_bc, Block.field_401_B.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 9, 0, 1, 9, 0, 7, Block.field_401_B.field_376_bc, Block.field_401_B.field_376_bc, false);
        for(int i = 1; i <= 7; i++)
        {
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 1, 1, i, structureboundingbox);
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 2, 1, i, structureboundingbox);
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 4, 1, i, structureboundingbox);
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 5, 1, i, structureboundingbox);
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 7, 1, i, structureboundingbox);
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 8, 1, i, structureboundingbox);
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 10, 1, i, structureboundingbox);
            func_35018_a(world, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(random, 2, 7), 11, 1, i, structureboundingbox);
        }

        for(int j = 0; j < 9; j++)
        {
            for(int k = 0; k < 13; k++)
            {
                func_35016_b(world, k, 4, j, structureboundingbox);
                func_35005_b(world, Block.field_336_w.field_376_bc, 0, k, -1, j, structureboundingbox);
            }

        }

        return true;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentVillageHouse3 extends ComponentVillage
{

    private int field_35102_a;

    public ComponentVillageHouse3(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35102_a = -1;
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentVillageHouse3 func_35101_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 9, 7, 12, l);
        if(!func_35074_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageHouse3(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35102_a < 0)
        {
            field_35102_a = func_35075_b(world, structureboundingbox);
            if(field_35102_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35102_a - field_35024_g.field_35750_e) + 7) - 1, 0);
        }
        func_35011_a(world, structureboundingbox, 1, 1, 1, 7, 4, 4, 0, 0, false);
        func_35011_a(world, structureboundingbox, 2, 1, 6, 8, 4, 10, 0, 0, false);
        func_35011_a(world, structureboundingbox, 2, 0, 5, 8, 0, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 0, 1, 7, 0, 4, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 0, 0, 0, 3, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 8, 0, 0, 8, 3, 10, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 0, 0, 7, 2, 0, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 0, 5, 2, 1, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 0, 6, 2, 3, 10, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 3, 0, 10, 7, 3, 10, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 2, 0, 7, 3, 0, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 2, 5, 2, 3, 5, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 4, 1, 8, 4, 1, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 4, 4, 3, 4, 4, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 5, 2, 8, 5, 3, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 0, 4, 2, structureboundingbox);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 0, 4, 3, structureboundingbox);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 8, 4, 2, structureboundingbox);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 8, 4, 3, structureboundingbox);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 8, 4, 4, structureboundingbox);
        int i = func_35009_c(Block.field_4059_au.field_376_bc, 3);
        int j = func_35009_c(Block.field_4059_au.field_376_bc, 2);
        for(int k = -1; k <= 2; k++)
        {
            for(int i1 = 0; i1 <= 8; i1++)
            {
                func_35018_a(world, Block.field_4059_au.field_376_bc, i, i1, 4 + k, k, structureboundingbox);
                if((k > -1 || i1 <= 1) && (k > 0 || i1 <= 3) && (k > 1 || i1 <= 4 || i1 >= 6))
                {
                    func_35018_a(world, Block.field_4059_au.field_376_bc, j, i1, 4 + k, 5 - k, structureboundingbox);
                }
            }

        }

        func_35011_a(world, structureboundingbox, 3, 4, 5, 3, 4, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 7, 4, 2, 7, 4, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 4, 5, 4, 4, 5, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 5, 4, 6, 5, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 6, 3, 5, 6, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        int l = func_35009_c(Block.field_4059_au.field_376_bc, 0);
        for(int j1 = 4; j1 >= 1; j1--)
        {
            func_35018_a(world, Block.field_334_y.field_376_bc, 0, j1, 2 + j1, 7 - j1, structureboundingbox);
            for(int l1 = 8 - j1; l1 <= 10; l1++)
            {
                func_35018_a(world, Block.field_4059_au.field_376_bc, l, j1, 2 + j1, l1, structureboundingbox);
            }

        }

        int k1 = func_35009_c(Block.field_4059_au.field_376_bc, 1);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 6, 6, 3, structureboundingbox);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 7, 5, 4, structureboundingbox);
        func_35018_a(world, Block.field_4059_au.field_376_bc, k1, 6, 6, 4, structureboundingbox);
        for(int i2 = 6; i2 <= 8; i2++)
        {
            for(int l2 = 5; l2 <= 10; l2++)
            {
                func_35018_a(world, Block.field_4059_au.field_376_bc, k1, i2, 12 - i2, l2, structureboundingbox);
            }

        }

        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 0, 2, 1, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 0, 2, 4, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 0, 2, 2, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 0, 2, 3, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 4, 2, 0, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 5, 2, 0, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 6, 2, 0, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 8, 2, 1, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 8, 2, 2, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 8, 2, 3, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 8, 2, 4, structureboundingbox);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 8, 2, 5, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 8, 2, 6, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 8, 2, 7, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 8, 2, 8, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 8, 2, 9, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 2, 2, 6, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 2, 2, 7, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 2, 2, 8, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 2, 2, 9, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 4, 4, 10, structureboundingbox);
        func_35018_a(world, Block.field_35282_br.field_376_bc, 0, 5, 4, 10, structureboundingbox);
        func_35018_a(world, Block.field_385_K.field_376_bc, 0, 6, 4, 10, structureboundingbox);
        func_35018_a(world, Block.field_334_y.field_376_bc, 0, 5, 5, 10, structureboundingbox);
        func_35018_a(world, 0, 0, 2, 1, 0, structureboundingbox);
        func_35018_a(world, 0, 0, 2, 2, 0, structureboundingbox);
        func_35018_a(world, Block.field_404_ar.field_376_bc, 0, 2, 3, 1, structureboundingbox);
        func_35002_a(world, structureboundingbox, random, 2, 1, 0, func_35009_c(Block.field_442_aF.field_376_bc, 1));
        func_35011_a(world, structureboundingbox, 1, 0, -1, 3, 2, -1, 0, 0, false);
        if(func_35007_a(world, 2, 0, -1, structureboundingbox) == 0 && func_35007_a(world, 2, -1, -1, structureboundingbox) != 0)
        {
            func_35018_a(world, Block.field_4069_aI.field_376_bc, func_35009_c(Block.field_4069_aI.field_376_bc, 3), 2, 0, -1, structureboundingbox);
        }
        for(int j2 = 0; j2 < 5; j2++)
        {
            for(int i3 = 0; i3 < 9; i3++)
            {
                func_35016_b(world, i3, 7, j2, structureboundingbox);
                func_35005_b(world, Block.field_335_x.field_376_bc, 0, i3, -1, j2, structureboundingbox);
            }

        }

        for(int k2 = 5; k2 < 11; k2++)
        {
            for(int j3 = 2; j3 < 9; j3++)
            {
                func_35016_b(world, j3, 7, k2, structureboundingbox);
                func_35005_b(world, Block.field_335_x.field_376_bc, 0, j3, -1, k2, structureboundingbox);
            }

        }

        func_40044_a(world, structureboundingbox, 4, 1, 2, 2);
        return true;
    }
}

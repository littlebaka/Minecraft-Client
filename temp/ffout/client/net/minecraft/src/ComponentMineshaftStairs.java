// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureMineshaftPieces, World

public class ComponentMineshaftStairs extends StructureComponent
{

    public ComponentMineshaftStairs(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public static StructureBoundingBox func_35027_a(List list, Random random, int i, int j, int k, int l)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(i, j - 5, k, i, j + 2, k);
        switch(l)
        {
        case 2: // '\002'
            structureboundingbox.field_35749_d = i + 2;
            structureboundingbox.field_35752_c = k - 8;
            break;

        case 0: // '\0'
            structureboundingbox.field_35749_d = i + 2;
            structureboundingbox.field_35748_f = k + 8;
            break;

        case 1: // '\001'
            structureboundingbox.field_35753_a = i - 8;
            structureboundingbox.field_35748_f = k + 2;
            break;

        case 3: // '\003'
            structureboundingbox.field_35749_d = i + 8;
            structureboundingbox.field_35748_f = k + 2;
            break;
        }
        if(StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return structureboundingbox;
        }
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        int i = func_35012_c();
        switch(field_35025_h)
        {
        case 2: // '\002'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a, field_35024_g.field_35751_b, field_35024_g.field_35752_c - 1, 2, i);
            break;

        case 0: // '\0'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a, field_35024_g.field_35751_b, field_35024_g.field_35748_f + 1, 0, i);
            break;

        case 1: // '\001'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c, 1, i);
            break;

        case 3: // '\003'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c, 3, i);
            break;
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        func_35011_a(world, structureboundingbox, 0, 5, 0, 2, 7, 1, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 0, 7, 2, 2, 8, 0, 0, false);
        for(int i = 0; i < 5; i++)
        {
            func_35011_a(world, structureboundingbox, 0, 5 - i - (i >= 4 ? 0 : 1), 2 + i, 2, 7 - i, 2 + i, 0, 0, false);
        }

        return true;
    }
}

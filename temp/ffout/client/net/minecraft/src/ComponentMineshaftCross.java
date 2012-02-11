// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureMineshaftPieces, Block, 
//            World

public class ComponentMineshaftCross extends StructureComponent
{

    private final int field_35073_a;
    private final boolean field_35072_b;

    public ComponentMineshaftCross(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35073_a = j;
        field_35024_g = structureboundingbox;
        field_35072_b = structureboundingbox.func_35743_c() > 3;
    }

    public static StructureBoundingBox func_35071_a(List list, Random random, int i, int j, int k, int l)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(i, j, k, i, j + 2, k);
        if(random.nextInt(4) == 0)
        {
            structureboundingbox.field_35750_e += 4;
        }
        switch(l)
        {
        case 2: // '\002'
            structureboundingbox.field_35753_a = i - 1;
            structureboundingbox.field_35749_d = i + 3;
            structureboundingbox.field_35752_c = k - 4;
            break;

        case 0: // '\0'
            structureboundingbox.field_35753_a = i - 1;
            structureboundingbox.field_35749_d = i + 3;
            structureboundingbox.field_35748_f = k + 4;
            break;

        case 1: // '\001'
            structureboundingbox.field_35753_a = i - 4;
            structureboundingbox.field_35752_c = k - 1;
            structureboundingbox.field_35748_f = k + 3;
            break;

        case 3: // '\003'
            structureboundingbox.field_35749_d = i + 4;
            structureboundingbox.field_35752_c = k - 1;
            structureboundingbox.field_35748_f = k + 3;
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
        switch(field_35073_a)
        {
        case 2: // '\002'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c - 1, 2, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, 1, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, 3, i);
            break;

        case 0: // '\0'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35748_f + 1, 0, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, 1, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, 3, i);
            break;

        case 1: // '\001'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c - 1, 2, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35748_f + 1, 0, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, 1, i);
            break;

        case 3: // '\003'
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c - 1, 2, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35748_f + 1, 0, i);
            StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, 3, i);
            break;
        }
        if(field_35072_b)
        {
            if(random.nextBoolean())
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b + 3 + 1, field_35024_g.field_35752_c - 1, 2, i);
            }
            if(random.nextBoolean())
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + 3 + 1, field_35024_g.field_35752_c + 1, 1, i);
            }
            if(random.nextBoolean())
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + 3 + 1, field_35024_g.field_35752_c + 1, 3, i);
            }
            if(random.nextBoolean())
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b + 3 + 1, field_35024_g.field_35748_f + 1, 0, i);
            }
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        if(field_35072_b)
        {
            func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c, field_35024_g.field_35749_d - 1, (field_35024_g.field_35751_b + 3) - 1, field_35024_g.field_35748_f, 0, 0, false);
            func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, field_35024_g.field_35749_d, (field_35024_g.field_35751_b + 3) - 1, field_35024_g.field_35748_f - 1, 0, 0, false);
            func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a + 1, field_35024_g.field_35750_e - 2, field_35024_g.field_35752_c, field_35024_g.field_35749_d - 1, field_35024_g.field_35750_e, field_35024_g.field_35748_f, 0, 0, false);
            func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a, field_35024_g.field_35750_e - 2, field_35024_g.field_35752_c + 1, field_35024_g.field_35749_d, field_35024_g.field_35750_e, field_35024_g.field_35748_f - 1, 0, 0, false);
            func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b + 3, field_35024_g.field_35752_c + 1, field_35024_g.field_35749_d - 1, field_35024_g.field_35751_b + 3, field_35024_g.field_35748_f - 1, 0, 0, false);
        } else
        {
            func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c, field_35024_g.field_35749_d - 1, field_35024_g.field_35750_e, field_35024_g.field_35748_f, 0, 0, false);
            func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, field_35024_g.field_35749_d, field_35024_g.field_35750_e, field_35024_g.field_35748_f - 1, 0, 0, false);
        }
        func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, field_35024_g.field_35753_a + 1, field_35024_g.field_35750_e, field_35024_g.field_35752_c + 1, Block.field_334_y.field_376_bc, 0, false);
        func_35011_a(world, structureboundingbox, field_35024_g.field_35753_a + 1, field_35024_g.field_35751_b, field_35024_g.field_35748_f - 1, field_35024_g.field_35753_a + 1, field_35024_g.field_35750_e, field_35024_g.field_35748_f - 1, Block.field_334_y.field_376_bc, 0, false);
        func_35011_a(world, structureboundingbox, field_35024_g.field_35749_d - 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c + 1, field_35024_g.field_35749_d - 1, field_35024_g.field_35750_e, field_35024_g.field_35752_c + 1, Block.field_334_y.field_376_bc, 0, false);
        func_35011_a(world, structureboundingbox, field_35024_g.field_35749_d - 1, field_35024_g.field_35751_b, field_35024_g.field_35748_f - 1, field_35024_g.field_35749_d - 1, field_35024_g.field_35750_e, field_35024_g.field_35748_f - 1, Block.field_334_y.field_376_bc, 0, false);
        return true;
    }
}

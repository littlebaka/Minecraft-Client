// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, EnumDoor, StructureBoundingBox, ComponentStrongholdCrossing, 
//            StructureStrongholdPieces, ComponentStrongholdStairs2, StructureComponent, Block, 
//            World

public class ComponentStrongholdStairs extends ComponentStronghold
{

    private final boolean field_35036_a;
    private final EnumDoor field_35035_b;

    public ComponentStrongholdStairs(int i, Random random, int j, int k)
    {
        super(i);
        field_35036_a = true;
        field_35025_h = random.nextInt(4);
        field_35035_b = EnumDoor.OPENING;
        switch(field_35025_h)
        {
        case 0: // '\0'
        case 2: // '\002'
            field_35024_g = new StructureBoundingBox(j, 64, k, (j + 5) - 1, 74, (k + 5) - 1);
            break;

        default:
            field_35024_g = new StructureBoundingBox(j, 64, k, (j + 5) - 1, 74, (k + 5) - 1);
            break;
        }
    }

    public ComponentStrongholdStairs(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35036_a = false;
        field_35025_h = j;
        field_35035_b = func_35031_a(random);
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        if(field_35036_a)
        {
            StructureStrongholdPieces.func_40751_a(net.minecraft.src.ComponentStrongholdCrossing.class);
        }
        func_35028_a((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
    }

    public static ComponentStrongholdStairs func_35034_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -7, 0, 5, 11, 5, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdStairs(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        } else
        {
            if(!field_35036_a);
            func_35022_a(world, structureboundingbox, 0, 0, 0, 4, 10, 4, true, random, StructureStrongholdPieces.func_35852_b());
            func_35033_a(world, random, structureboundingbox, field_35035_b, 1, 7, 0);
            func_35033_a(world, random, structureboundingbox, EnumDoor.OPENING, 1, 1, 4);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 2, 6, 1, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 5, 1, structureboundingbox);
            func_35018_a(world, Block.field_410_al.field_376_bc, 0, 1, 6, 1, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 5, 2, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 4, 3, structureboundingbox);
            func_35018_a(world, Block.field_410_al.field_376_bc, 0, 1, 5, 3, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 2, 4, 3, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 3, 3, 3, structureboundingbox);
            func_35018_a(world, Block.field_410_al.field_376_bc, 0, 3, 4, 3, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 3, 3, 2, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 3, 2, 1, structureboundingbox);
            func_35018_a(world, Block.field_410_al.field_376_bc, 0, 3, 3, 1, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 2, 2, 1, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 1, 1, structureboundingbox);
            func_35018_a(world, Block.field_410_al.field_376_bc, 0, 1, 2, 1, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, 1, 1, 2, structureboundingbox);
            func_35018_a(world, Block.field_410_al.field_376_bc, 0, 1, 1, 3, structureboundingbox);
            return true;
        }
    }
}

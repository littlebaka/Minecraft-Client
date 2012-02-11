// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, World

public class ComponentStrongholdLeftTurn extends ComponentStronghold
{

    protected final EnumDoor field_35046_a;

    public ComponentStrongholdLeftTurn(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35046_a = func_35031_a(random);
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        if(field_35025_h == 2 || field_35025_h == 3)
        {
            func_35032_b((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
        } else
        {
            func_35029_c((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
        }
    }

    public static ComponentStrongholdLeftTurn func_35045_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -1, 0, 5, 5, 5, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdLeftTurn(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        func_35022_a(world, structureboundingbox, 0, 0, 0, 4, 4, 4, true, random, StructureStrongholdPieces.func_35852_b());
        func_35033_a(world, random, structureboundingbox, field_35046_a, 1, 1, 0);
        if(field_35025_h == 2 || field_35025_h == 3)
        {
            func_35011_a(world, structureboundingbox, 0, 1, 1, 0, 3, 3, 0, 0, false);
        } else
        {
            func_35011_a(world, structureboundingbox, 4, 1, 1, 4, 3, 3, 0, 0, false);
        }
        return true;
    }
}

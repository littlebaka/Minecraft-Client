// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureNetherBridgePieceWeight, ComponentNetherBridgeStartPiece, StructureNetherBridgePieces, 
//            StructureNetherBridgeEnd, StructureBoundingBox

abstract class ComponentNetherBridgePiece extends StructureComponent
{

    protected ComponentNetherBridgePiece(int i)
    {
        super(i);
    }

    private int func_40017_a(List list)
    {
        boolean flag = false;
        int i = 0;
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            StructureNetherBridgePieceWeight structurenetherbridgepieceweight = (StructureNetherBridgePieceWeight)iterator.next();
            if(structurenetherbridgepieceweight.field_40695_d > 0 && structurenetherbridgepieceweight.field_40698_c < structurenetherbridgepieceweight.field_40695_d)
            {
                flag = true;
            }
            i += structurenetherbridgepieceweight.field_40697_b;
        }

        return flag ? i : -1;
    }

    private ComponentNetherBridgePiece func_40020_a(ComponentNetherBridgeStartPiece componentnetherbridgestartpiece, List list, List list1, Random random, int i, int j, int k, 
            int l, int i1)
    {
        int j1;
        boolean flag;
        int k1;
        j1 = func_40017_a(list);
        flag = j1 > 0 && i1 <= 30;
        k1 = 0;
_L2:
        int l1;
        Iterator iterator;
        if(k1 >= 5 || !flag)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        k1++;
        l1 = random.nextInt(j1);
        iterator = list.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        StructureNetherBridgePieceWeight structurenetherbridgepieceweight;
        structurenetherbridgepieceweight = (StructureNetherBridgePieceWeight)iterator.next();
        l1 -= structurenetherbridgepieceweight.field_40697_b;
        if(l1 >= 0) goto _L4; else goto _L3
_L3:
        if(structurenetherbridgepieceweight.func_40693_a(i1) && (structurenetherbridgepieceweight != componentnetherbridgestartpiece.field_40037_a || structurenetherbridgepieceweight.field_40696_e)) goto _L5; else goto _L2
_L5:
        ComponentNetherBridgePiece componentnetherbridgepiece = StructureNetherBridgePieces.func_40688_a(structurenetherbridgepieceweight, list1, random, i, j, k, l, i1);
        if(componentnetherbridgepiece == null) goto _L4; else goto _L6
_L6:
        structurenetherbridgepieceweight.field_40698_c++;
        componentnetherbridgestartpiece.field_40037_a = structurenetherbridgepieceweight;
        if(!structurenetherbridgepieceweight.func_40694_a())
        {
            list.remove(structurenetherbridgepieceweight);
        }
        return componentnetherbridgepiece;
        StructureNetherBridgeEnd structurenetherbridgeend = StructureNetherBridgeEnd.func_40023_a(list1, random, i, j, k, l, i1);
        return structurenetherbridgeend;
    }

    private StructureComponent func_40018_a(ComponentNetherBridgeStartPiece componentnetherbridgestartpiece, List list, Random random, int i, int j, int k, int l, 
            int i1, boolean flag)
    {
        if(Math.abs(i - componentnetherbridgestartpiece.func_35021_b().field_35753_a) > 112 || Math.abs(k - componentnetherbridgestartpiece.func_35021_b().field_35752_c) > 112)
        {
            StructureNetherBridgeEnd structurenetherbridgeend = StructureNetherBridgeEnd.func_40023_a(list, random, i, j, k, l, i1);
            return structurenetherbridgeend;
        }
        List list1 = componentnetherbridgestartpiece.field_40035_b;
        if(flag)
        {
            list1 = componentnetherbridgestartpiece.field_40036_c;
        }
        ComponentNetherBridgePiece componentnetherbridgepiece = func_40020_a(componentnetherbridgestartpiece, list1, list, random, i, j, k, l, i1 + 1);
        if(componentnetherbridgepiece != null)
        {
            list.add(componentnetherbridgepiece);
            componentnetherbridgestartpiece.field_40034_d.add(componentnetherbridgepiece);
        }
        return componentnetherbridgepiece;
    }

    protected StructureComponent func_40022_a(ComponentNetherBridgeStartPiece componentnetherbridgestartpiece, List list, Random random, int i, int j, boolean flag)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a + i, field_35024_g.field_35751_b + j, field_35024_g.field_35752_c - 1, field_35025_h, func_35012_c(), flag);

        case 0: // '\0'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a + i, field_35024_g.field_35751_b + j, field_35024_g.field_35748_f + 1, field_35025_h, func_35012_c(), flag);

        case 1: // '\001'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + j, field_35024_g.field_35752_c + i, field_35025_h, func_35012_c(), flag);

        case 3: // '\003'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + j, field_35024_g.field_35752_c + i, field_35025_h, func_35012_c(), flag);
        }
        return null;
    }

    protected StructureComponent func_40019_b(ComponentNetherBridgeStartPiece componentnetherbridgestartpiece, List list, Random random, int i, int j, boolean flag)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 1, func_35012_c(), flag);

        case 0: // '\0'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 1, func_35012_c(), flag);

        case 1: // '\001'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c - 1, 2, func_35012_c(), flag);

        case 3: // '\003'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c - 1, 2, func_35012_c(), flag);
        }
        return null;
    }

    protected StructureComponent func_40016_c(ComponentNetherBridgeStartPiece componentnetherbridgestartpiece, List list, Random random, int i, int j, boolean flag)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 3, func_35012_c(), flag);

        case 0: // '\0'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 3, func_35012_c(), flag);

        case 1: // '\001'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35748_f + 1, 0, func_35012_c(), flag);

        case 3: // '\003'
            return func_40018_a(componentnetherbridgestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35748_f + 1, 0, func_35012_c(), flag);
        }
        return null;
    }

    protected static boolean func_40021_a(StructureBoundingBox structureboundingbox)
    {
        return structureboundingbox != null && structureboundingbox.field_35751_b > 10;
    }
}

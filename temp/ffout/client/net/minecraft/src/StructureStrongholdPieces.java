// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStrongholdPieceWeight, ComponentStrongholdStraight, ComponentStrongholdPrison, ComponentStrongholdLeftTurn, 
//            ComponentStrongholdRightTurn, ComponentStrongholdRoomCrossing, ComponentStrongholdStairsStraight, ComponentStrongholdStairs, 
//            ComponentStrongholdCrossing, ComponentStrongholdChestCorridor, ComponentStrongholdLibrary, ComponentStrongholdPortalRoom, 
//            ComponentStrongholdStairs2, ComponentStrongholdCorridor, StructureBoundingBox, StructureStrongholdPieceWeight2, 
//            StructureStrongholdPieceWeight3, StructureStrongholdStones, ComponentStronghold, StructureComponent

public class StructureStrongholdPieces
{

    private static final StructureStrongholdPieceWeight field_35855_b[];
    private static List field_35856_c;
    private static Class field_40752_d;
    static int field_35857_a = 0;
    private static final StructureStrongholdStones field_35854_d = new StructureStrongholdStones(null);

    public StructureStrongholdPieces()
    {
    }

    public static void func_35849_a()
    {
        field_35856_c = new ArrayList();
        StructureStrongholdPieceWeight astructurestrongholdpieceweight[] = field_35855_b;
        int i = astructurestrongholdpieceweight.length;
        for(int j = 0; j < i; j++)
        {
            StructureStrongholdPieceWeight structurestrongholdpieceweight = astructurestrongholdpieceweight[j];
            structurestrongholdpieceweight.field_35617_c = 0;
            field_35856_c.add(structurestrongholdpieceweight);
        }

        field_40752_d = null;
    }

    private static boolean func_35853_c()
    {
        boolean flag = false;
        field_35857_a = 0;
        for(Iterator iterator = field_35856_c.iterator(); iterator.hasNext();)
        {
            StructureStrongholdPieceWeight structurestrongholdpieceweight = (StructureStrongholdPieceWeight)iterator.next();
            if(structurestrongholdpieceweight.field_35615_d > 0 && structurestrongholdpieceweight.field_35617_c < structurestrongholdpieceweight.field_35615_d)
            {
                flag = true;
            }
            field_35857_a += structurestrongholdpieceweight.field_35616_b;
        }

        return flag;
    }

    private static ComponentStronghold func_35851_a(Class class1, List list, Random random, int i, int j, int k, int l, int i1)
    {
        Object obj = null;
        if(class1 == (net.minecraft.src.ComponentStrongholdStraight.class))
        {
            obj = ComponentStrongholdStraight.func_35047_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdPrison.class))
        {
            obj = ComponentStrongholdPrison.func_35063_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdLeftTurn.class))
        {
            obj = ComponentStrongholdLeftTurn.func_35045_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdRightTurn.class))
        {
            obj = ComponentStrongholdRightTurn.func_35045_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdRoomCrossing.class))
        {
            obj = ComponentStrongholdRoomCrossing.func_35059_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdStairsStraight.class))
        {
            obj = ComponentStrongholdStairsStraight.func_35053_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdStairs.class))
        {
            obj = ComponentStrongholdStairs.func_35034_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdCrossing.class))
        {
            obj = ComponentStrongholdCrossing.func_35039_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdChestCorridor.class))
        {
            obj = ComponentStrongholdChestCorridor.func_40010_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdLibrary.class))
        {
            obj = ComponentStrongholdLibrary.func_35055_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdPortalRoom.class))
        {
            obj = ComponentStrongholdPortalRoom.func_40014_a(list, random, i, j, k, l, i1);
        }
        return ((ComponentStronghold) (obj));
    }

    private static ComponentStronghold func_35847_b(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j, int k, int l, int i1)
    {
        int j1;
        if(!func_35853_c())
        {
            return null;
        }
        if(field_40752_d != null)
        {
            ComponentStronghold componentstronghold = func_35851_a(field_40752_d, list, random, i, j, k, l, i1);
            field_40752_d = null;
            if(componentstronghold != null)
            {
                return componentstronghold;
            }
        }
        j1 = 0;
_L2:
        int k1;
        Iterator iterator;
        if(j1 >= 5)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        j1++;
        k1 = random.nextInt(field_35857_a);
        iterator = field_35856_c.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        StructureStrongholdPieceWeight structurestrongholdpieceweight;
        structurestrongholdpieceweight = (StructureStrongholdPieceWeight)iterator.next();
        k1 -= structurestrongholdpieceweight.field_35616_b;
        if(k1 >= 0) goto _L4; else goto _L3
_L3:
        if(structurestrongholdpieceweight.func_35613_a(i1) && structurestrongholdpieceweight != componentstrongholdstairs2.field_35038_a) goto _L5; else goto _L2
_L5:
        ComponentStronghold componentstronghold1 = func_35851_a(structurestrongholdpieceweight.field_35618_a, list, random, i, j, k, l, i1);
        if(componentstronghold1 == null) goto _L4; else goto _L6
_L6:
        structurestrongholdpieceweight.field_35617_c++;
        componentstrongholdstairs2.field_35038_a = structurestrongholdpieceweight;
        if(!structurestrongholdpieceweight.func_35614_a())
        {
            field_35856_c.remove(structurestrongholdpieceweight);
        }
        return componentstronghold1;
        StructureBoundingBox structureboundingbox = ComponentStrongholdCorridor.func_35051_a(list, random, i, j, k, l);
        if(structureboundingbox != null && structureboundingbox.field_35751_b > 1)
        {
            return new ComponentStrongholdCorridor(i1, random, structureboundingbox, l);
        } else
        {
            return null;
        }
    }

    private static StructureComponent func_35848_c(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j, int k, int l, int i1)
    {
        if(i1 > 50)
        {
            return null;
        }
        if(Math.abs(i - componentstrongholdstairs2.func_35021_b().field_35753_a) > 112 || Math.abs(k - componentstrongholdstairs2.func_35021_b().field_35752_c) > 112)
        {
            return null;
        }
        ComponentStronghold componentstronghold = func_35847_b(componentstrongholdstairs2, list, random, i, j, k, l, i1 + 1);
        if(componentstronghold != null)
        {
            list.add(componentstronghold);
            componentstrongholdstairs2.field_35037_b.add(componentstronghold);
        }
        return componentstronghold;
    }

    static StructureComponent func_35850_a(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j, int k, int l, int i1)
    {
        return func_35848_c(componentstrongholdstairs2, list, random, i, j, k, l, i1);
    }

    static Class func_40751_a(Class class1)
    {
        return field_40752_d = class1;
    }

    static StructureStrongholdStones func_35852_b()
    {
        return field_35854_d;
    }

    static 
    {
        field_35855_b = (new StructureStrongholdPieceWeight[] {
            new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStraight.class, 40, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdPrison.class, 5, 5), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdLeftTurn.class, 20, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdRightTurn.class, 20, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdRoomCrossing.class, 10, 6), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStairsStraight.class, 5, 5), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStairs.class, 5, 5), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdCrossing.class, 5, 4), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdChestCorridor.class, 5, 4), new StructureStrongholdPieceWeight2(net.minecraft.src.ComponentStrongholdLibrary.class, 10, 2), 
            new StructureStrongholdPieceWeight3(net.minecraft.src.ComponentStrongholdPortalRoom.class, 20, 1)
        });
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureVillagePieceWeight, ComponentVillageHouse4_Garden, MathHelper, ComponentVillageChurch, 
//            ComponentVillageHouse1, ComponentVillageWoodHut, ComponentVillageHall, ComponentVillageField, 
//            ComponentVillageField2, ComponentVillageHouse2, ComponentVillageHouse3, ComponentVillageStartPiece, 
//            ComponentVillageTorch, StructureBoundingBox, StructureComponent, MapGenVillage, 
//            WorldChunkManager, ComponentVillagePathGen, ComponentVillage

public class StructureVillagePieces
{

    public StructureVillagePieces()
    {
    }

    public static ArrayList func_35705_a(Random random, int i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse4_Garden.class, 4, MathHelper.func_35598_a(random, 2 + i, 4 + i * 2)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageChurch.class, 20, MathHelper.func_35598_a(random, 0 + i, 1 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse1.class, 20, MathHelper.func_35598_a(random, 0 + i, 2 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageWoodHut.class, 3, MathHelper.func_35598_a(random, 2 + i, 5 + i * 3)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHall.class, 15, MathHelper.func_35598_a(random, 0 + i, 2 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageField.class, 3, MathHelper.func_35598_a(random, 1 + i, 4 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageField2.class, 3, MathHelper.func_35598_a(random, 2 + i, 4 + i * 2)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse2.class, 15, MathHelper.func_35598_a(random, 0, 1 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse3.class, 8, MathHelper.func_35598_a(random, 0 + i, 3 + i * 2)));
        Iterator iterator = arraylist.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            if(((StructureVillagePieceWeight)iterator.next()).field_35604_d == 0)
            {
                iterator.remove();
            }
        } while(true);
        return arraylist;
    }

    private static int func_35703_a(ArrayList arraylist)
    {
        boolean flag = false;
        int i = 0;
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            StructureVillagePieceWeight structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();
            if(structurevillagepieceweight.field_35604_d > 0 && structurevillagepieceweight.field_35606_c < structurevillagepieceweight.field_35604_d)
            {
                flag = true;
            }
            i += structurevillagepieceweight.field_35605_b;
        }

        return flag ? i : -1;
    }

    private static ComponentVillage func_35699_a(StructureVillagePieceWeight structurevillagepieceweight, List list, Random random, int i, int j, int k, int l, int i1)
    {
        Class class1 = structurevillagepieceweight.field_35607_a;
        Object obj = null;
        if(class1 == (net.minecraft.src.ComponentVillageHouse4_Garden.class))
        {
            obj = ComponentVillageHouse4_Garden.func_35082_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageChurch.class))
        {
            obj = ComponentVillageChurch.func_35097_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse1.class))
        {
            obj = ComponentVillageHouse1.func_35095_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageWoodHut.class))
        {
            obj = ComponentVillageWoodHut.func_35091_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHall.class))
        {
            obj = ComponentVillageHall.func_35078_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageField.class))
        {
            obj = ComponentVillageField.func_35080_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageField2.class))
        {
            obj = ComponentVillageField2.func_35089_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse2.class))
        {
            obj = ComponentVillageHouse2.func_35085_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse3.class))
        {
            obj = ComponentVillageHouse3.func_35101_a(list, random, i, j, k, l, i1);
        }
        return ((ComponentVillage) (obj));
    }

    private static ComponentVillage func_35700_c(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        int j1;
        int k1;
        j1 = func_35703_a(componentvillagestartpiece.field_35107_d);
        if(j1 <= 0)
        {
            return null;
        }
        k1 = 0;
_L2:
        int l1;
        Iterator iterator;
        if(k1 >= 5)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        k1++;
        l1 = random.nextInt(j1);
        iterator = componentvillagestartpiece.field_35107_d.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        StructureVillagePieceWeight structurevillagepieceweight;
        structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();
        l1 -= structurevillagepieceweight.field_35605_b;
        if(l1 >= 0) goto _L4; else goto _L3
_L3:
        if(structurevillagepieceweight.func_35602_a(i1) && (structurevillagepieceweight != componentvillagestartpiece.field_35110_c || componentvillagestartpiece.field_35107_d.size() <= 1)) goto _L5; else goto _L2
_L5:
        ComponentVillage componentvillage = func_35699_a(structurevillagepieceweight, list, random, i, j, k, l, i1);
        if(componentvillage == null) goto _L4; else goto _L6
_L6:
        structurevillagepieceweight.field_35606_c++;
        componentvillagestartpiece.field_35110_c = structurevillagepieceweight;
        if(!structurevillagepieceweight.func_35603_a())
        {
            componentvillagestartpiece.field_35107_d.remove(structurevillagepieceweight);
        }
        return componentvillage;
        StructureBoundingBox structureboundingbox = ComponentVillageTorch.func_35099_a(list, random, i, j, k, l);
        if(structureboundingbox != null)
        {
            return new ComponentVillageTorch(i1, random, structureboundingbox, l);
        } else
        {
            return null;
        }
    }

    private static StructureComponent func_35702_d(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        if(i1 > 50)
        {
            return null;
        }
        if(Math.abs(i - componentvillagestartpiece.func_35021_b().field_35753_a) > 112 || Math.abs(k - componentvillagestartpiece.func_35021_b().field_35752_c) > 112)
        {
            return null;
        }
        ComponentVillage componentvillage = func_35700_c(componentvillagestartpiece, list, random, i, j, k, l, i1 + 1);
        if(componentvillage != null)
        {
            int j1 = (((StructureComponent) (componentvillage)).field_35024_g.field_35753_a + ((StructureComponent) (componentvillage)).field_35024_g.field_35749_d) / 2;
            int k1 = (((StructureComponent) (componentvillage)).field_35024_g.field_35752_c + ((StructureComponent) (componentvillage)).field_35024_g.field_35748_f) / 2;
            int l1 = ((StructureComponent) (componentvillage)).field_35024_g.field_35749_d - ((StructureComponent) (componentvillage)).field_35024_g.field_35753_a;
            int i2 = ((StructureComponent) (componentvillage)).field_35024_g.field_35748_f - ((StructureComponent) (componentvillage)).field_35024_g.field_35752_c;
            int j2 = l1 <= i2 ? i2 : l1;
            if(componentvillagestartpiece.func_35105_a().func_35562_a(j1, k1, j2 / 2 + 4, MapGenVillage.field_35635_a))
            {
                list.add(componentvillage);
                componentvillagestartpiece.field_35108_e.add(componentvillage);
                return componentvillage;
            }
        }
        return null;
    }

    private static StructureComponent func_35698_e(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        if(i1 > 3 + componentvillagestartpiece.field_35109_b)
        {
            return null;
        }
        if(Math.abs(i - componentvillagestartpiece.func_35021_b().field_35753_a) > 112 || Math.abs(k - componentvillagestartpiece.func_35021_b().field_35752_c) > 112)
        {
            return null;
        }
        StructureBoundingBox structureboundingbox = ComponentVillagePathGen.func_35087_a(componentvillagestartpiece, list, random, i, j, k, l);
        if(structureboundingbox != null && structureboundingbox.field_35751_b > 10)
        {
            ComponentVillagePathGen componentvillagepathgen = new ComponentVillagePathGen(i1, random, structureboundingbox, l);
            int j1 = (((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35753_a + ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35749_d) / 2;
            int k1 = (((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35752_c + ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35748_f) / 2;
            int l1 = ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35749_d - ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35753_a;
            int i2 = ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35748_f - ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35752_c;
            int j2 = l1 <= i2 ? i2 : l1;
            if(componentvillagestartpiece.func_35105_a().func_35562_a(j1, k1, j2 / 2 + 4, MapGenVillage.field_35635_a))
            {
                list.add(componentvillagepathgen);
                componentvillagestartpiece.field_35106_f.add(componentvillagepathgen);
                return componentvillagepathgen;
            }
        }
        return null;
    }

    static StructureComponent func_35704_a(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        return func_35702_d(componentvillagestartpiece, list, random, i, j, k, l, i1);
    }

    static StructureComponent func_35701_b(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        return func_35698_e(componentvillagestartpiece, list, random, i, j, k, l, i1);
    }
}

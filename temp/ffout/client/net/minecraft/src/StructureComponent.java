// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureBoundingBox, ChunkPosition, World, Block, 
//            Material, StructurePieceBlockSelector, TileEntityChest, WeightedRandom, 
//            StructurePieceTreasure, Item, ItemStack, ItemDoor

public abstract class StructureComponent
{

    protected StructureBoundingBox field_35024_g;
    protected int field_35025_h;
    protected int field_35026_i;

    protected StructureComponent(int i)
    {
        field_35026_i = i;
        field_35025_h = -1;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public abstract boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox);

    public StructureBoundingBox func_35021_b()
    {
        return field_35024_g;
    }

    public int func_35012_c()
    {
        return field_35026_i;
    }

    public static StructureComponent func_35020_a(List list, StructureBoundingBox structureboundingbox)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            StructureComponent structurecomponent = (StructureComponent)iterator.next();
            if(structurecomponent.func_35021_b() != null && structurecomponent.func_35021_b().func_35740_a(structureboundingbox))
            {
                return structurecomponent;
            }
        }

        return null;
    }

    public ChunkPosition func_40008_a_()
    {
        return new ChunkPosition(field_35024_g.func_40597_e(), field_35024_g.func_40596_f(), field_35024_g.func_40598_g());
    }

    protected boolean func_35013_a(World world, StructureBoundingBox structureboundingbox)
    {
        int i = Math.max(field_35024_g.field_35753_a - 1, structureboundingbox.field_35753_a);
        int j = Math.max(field_35024_g.field_35751_b - 1, structureboundingbox.field_35751_b);
        int k = Math.max(field_35024_g.field_35752_c - 1, structureboundingbox.field_35752_c);
        int l = Math.min(field_35024_g.field_35749_d + 1, structureboundingbox.field_35749_d);
        int i1 = Math.min(field_35024_g.field_35750_e + 1, structureboundingbox.field_35750_e);
        int j1 = Math.min(field_35024_g.field_35748_f + 1, structureboundingbox.field_35748_f);
        for(int k1 = i; k1 <= l; k1++)
        {
            for(int j2 = k; j2 <= j1; j2++)
            {
                int i3 = world.func_600_a(k1, j, j2);
                if(i3 > 0 && Block.field_345_n[i3].field_356_bn.func_879_d())
                {
                    return true;
                }
                i3 = world.func_600_a(k1, i1, j2);
                if(i3 > 0 && Block.field_345_n[i3].field_356_bn.func_879_d())
                {
                    return true;
                }
            }

        }

        for(int l1 = i; l1 <= l; l1++)
        {
            for(int k2 = j; k2 <= i1; k2++)
            {
                int j3 = world.func_600_a(l1, k2, k);
                if(j3 > 0 && Block.field_345_n[j3].field_356_bn.func_879_d())
                {
                    return true;
                }
                j3 = world.func_600_a(l1, k2, j1);
                if(j3 > 0 && Block.field_345_n[j3].field_356_bn.func_879_d())
                {
                    return true;
                }
            }

        }

        for(int i2 = k; i2 <= j1; i2++)
        {
            for(int l2 = j; l2 <= i1; l2++)
            {
                int k3 = world.func_600_a(i, l2, i2);
                if(k3 > 0 && Block.field_345_n[k3].field_356_bn.func_879_d())
                {
                    return true;
                }
                k3 = world.func_600_a(l, l2, i2);
                if(k3 > 0 && Block.field_345_n[k3].field_356_bn.func_879_d())
                {
                    return true;
                }
            }

        }

        return false;
    }

    protected int func_35017_a(int i, int j)
    {
        switch(field_35025_h)
        {
        case 0: // '\0'
        case 2: // '\002'
            return field_35024_g.field_35753_a + i;

        case 1: // '\001'
            return field_35024_g.field_35749_d - j;

        case 3: // '\003'
            return field_35024_g.field_35753_a + j;
        }
        return i;
    }

    protected int func_35008_a(int i)
    {
        if(field_35025_h == -1)
        {
            return i;
        } else
        {
            return i + field_35024_g.field_35751_b;
        }
    }

    protected int func_35006_b(int i, int j)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return field_35024_g.field_35748_f - j;

        case 0: // '\0'
            return field_35024_g.field_35752_c + j;

        case 1: // '\001'
        case 3: // '\003'
            return field_35024_g.field_35752_c + i;
        }
        return j;
    }

    protected int func_35009_c(int i, int j)
    {
        if(i == Block.field_440_aH.field_376_bc)
        {
            if(field_35025_h == 1 || field_35025_h == 3)
            {
                return j != 1 ? 1 : 0;
            }
        } else
        if(i == Block.field_442_aF.field_376_bc || i == Block.field_435_aM.field_376_bc)
        {
            if(field_35025_h == 0)
            {
                if(j == 0)
                {
                    return 2;
                }
                if(j == 2)
                {
                    return 0;
                }
            } else
            {
                if(field_35025_h == 1)
                {
                    return j + 1 & 3;
                }
                if(field_35025_h == 3)
                {
                    return j + 3 & 3;
                }
            }
        } else
        if(i == Block.field_4069_aI.field_376_bc || i == Block.field_4059_au.field_376_bc || i == Block.field_40204_bD.field_376_bc || i == Block.field_35279_by.field_376_bc)
        {
            if(field_35025_h == 0)
            {
                if(j == 2)
                {
                    return 3;
                }
                if(j == 3)
                {
                    return 2;
                }
            } else
            if(field_35025_h == 1)
            {
                if(j == 0)
                {
                    return 2;
                }
                if(j == 1)
                {
                    return 3;
                }
                if(j == 2)
                {
                    return 0;
                }
                if(j == 3)
                {
                    return 1;
                }
            } else
            if(field_35025_h == 3)
            {
                if(j == 0)
                {
                    return 2;
                }
                if(j == 1)
                {
                    return 3;
                }
                if(j == 2)
                {
                    return 1;
                }
                if(j == 3)
                {
                    return 0;
                }
            }
        } else
        if(i == Block.field_441_aG.field_376_bc)
        {
            if(field_35025_h == 0)
            {
                if(j == 2)
                {
                    return 3;
                }
                if(j == 3)
                {
                    return 2;
                }
            } else
            if(field_35025_h == 1)
            {
                if(j == 2)
                {
                    return 4;
                }
                if(j == 3)
                {
                    return 5;
                }
                if(j == 4)
                {
                    return 2;
                }
                if(j == 5)
                {
                    return 3;
                }
            } else
            if(field_35025_h == 3)
            {
                if(j == 2)
                {
                    return 5;
                }
                if(j == 3)
                {
                    return 4;
                }
                if(j == 4)
                {
                    return 2;
                }
                if(j == 5)
                {
                    return 3;
                }
            }
        } else
        if(i == Block.field_4064_aS.field_376_bc)
        {
            if(field_35025_h == 0)
            {
                if(j == 3)
                {
                    return 4;
                }
                if(j == 4)
                {
                    return 3;
                }
            } else
            if(field_35025_h == 1)
            {
                if(j == 3)
                {
                    return 1;
                }
                if(j == 4)
                {
                    return 2;
                }
                if(j == 2)
                {
                    return 3;
                }
                if(j == 1)
                {
                    return 4;
                }
            } else
            if(field_35025_h == 3)
            {
                if(j == 3)
                {
                    return 2;
                }
                if(j == 4)
                {
                    return 1;
                }
                if(j == 2)
                {
                    return 3;
                }
                if(j == 1)
                {
                    return 4;
                }
            }
        }
        return j;
    }

    protected void func_35018_a(World world, int i, int j, int k, int l, int i1, StructureBoundingBox structureboundingbox)
    {
        int j1 = func_35017_a(k, i1);
        int k1 = func_35008_a(l);
        int l1 = func_35006_b(k, i1);
        if(!structureboundingbox.func_35742_b(j1, k1, l1))
        {
            return;
        } else
        {
            world.func_643_a(j1, k1, l1, i, j);
            return;
        }
    }

    protected int func_35007_a(World world, int i, int j, int k, StructureBoundingBox structureboundingbox)
    {
        int l = func_35017_a(i, k);
        int i1 = func_35008_a(j);
        int j1 = func_35006_b(i, k);
        if(!structureboundingbox.func_35742_b(l, i1, j1))
        {
            return 0;
        } else
        {
            return world.func_600_a(l, i1, j1);
        }
    }

    protected void func_35011_a(World world, StructureBoundingBox structureboundingbox, int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, boolean flag)
    {
        for(int i2 = j; i2 <= i1; i2++)
        {
            for(int j2 = i; j2 <= l; j2++)
            {
                for(int k2 = k; k2 <= j1; k2++)
                {
                    if(flag && func_35007_a(world, j2, i2, k2, structureboundingbox) == 0)
                    {
                        continue;
                    }
                    if(i2 == j || i2 == i1 || j2 == i || j2 == l || k2 == k || k2 == j1)
                    {
                        func_35018_a(world, k1, 0, j2, i2, k2, structureboundingbox);
                    } else
                    {
                        func_35018_a(world, l1, 0, j2, i2, k2, structureboundingbox);
                    }
                }

            }

        }

    }

    protected void func_35022_a(World world, StructureBoundingBox structureboundingbox, int i, int j, int k, int l, int i1, 
            int j1, boolean flag, Random random, StructurePieceBlockSelector structurepieceblockselector)
    {
        for(int k1 = j; k1 <= i1; k1++)
        {
            for(int l1 = i; l1 <= l; l1++)
            {
                for(int i2 = k; i2 <= j1; i2++)
                {
                    if(!flag || func_35007_a(world, l1, k1, i2, structureboundingbox) != 0)
                    {
                        structurepieceblockselector.func_35706_a(random, l1, k1, i2, k1 == j || k1 == i1 || l1 == i || l1 == l || i2 == k || i2 == j1);
                        func_35018_a(world, structurepieceblockselector.func_35707_a(), structurepieceblockselector.func_35708_b(), l1, k1, i2, structureboundingbox);
                    }
                }

            }

        }

    }

    protected void func_35010_a(World world, StructureBoundingBox structureboundingbox, Random random, float f, int i, int j, int k, 
            int l, int i1, int j1, int k1, int l1, boolean flag)
    {
        for(int i2 = j; i2 <= i1; i2++)
        {
            for(int j2 = i; j2 <= l; j2++)
            {
                for(int k2 = k; k2 <= j1; k2++)
                {
                    if(random.nextFloat() > f || flag && func_35007_a(world, j2, i2, k2, structureboundingbox) == 0)
                    {
                        continue;
                    }
                    if(i2 == j || i2 == i1 || j2 == i || j2 == l || k2 == k || k2 == j1)
                    {
                        func_35018_a(world, k1, 0, j2, i2, k2, structureboundingbox);
                    } else
                    {
                        func_35018_a(world, l1, 0, j2, i2, k2, structureboundingbox);
                    }
                }

            }

        }

    }

    protected void func_35014_a(World world, StructureBoundingBox structureboundingbox, Random random, float f, int i, int j, int k, 
            int l, int i1)
    {
        if(random.nextFloat() < f)
        {
            func_35018_a(world, l, i1, i, j, k, structureboundingbox);
        }
    }

    protected void func_35015_a(World world, StructureBoundingBox structureboundingbox, int i, int j, int k, int l, int i1, 
            int j1, int k1, boolean flag)
    {
        float f = (l - i) + 1;
        float f1 = (i1 - j) + 1;
        float f2 = (j1 - k) + 1;
        float f3 = (float)i + f / 2.0F;
        float f4 = (float)k + f2 / 2.0F;
        for(int l1 = j; l1 <= i1; l1++)
        {
            float f5 = (float)(l1 - j) / f1;
            for(int i2 = i; i2 <= l; i2++)
            {
                float f6 = ((float)i2 - f3) / (f * 0.5F);
                for(int j2 = k; j2 <= j1; j2++)
                {
                    float f7 = ((float)j2 - f4) / (f2 * 0.5F);
                    if(flag && func_35007_a(world, i2, l1, j2, structureboundingbox) == 0)
                    {
                        continue;
                    }
                    float f8 = f6 * f6 + f5 * f5 + f7 * f7;
                    if(f8 <= 1.05F)
                    {
                        func_35018_a(world, k1, 0, i2, l1, j2, structureboundingbox);
                    }
                }

            }

        }

    }

    protected void func_35016_b(World world, int i, int j, int k, StructureBoundingBox structureboundingbox)
    {
        int l = func_35017_a(i, k);
        int i1 = func_35008_a(j);
        int j1 = func_35006_b(i, k);
        if(!structureboundingbox.func_35742_b(l, i1, j1))
        {
            return;
        }
        for(; !world.func_20084_d(l, i1, j1) && i1 < world.field_35469_d; i1++)
        {
            world.func_643_a(l, i1, j1, 0, 0);
        }

    }

    protected void func_35005_b(World world, int i, int j, int k, int l, int i1, StructureBoundingBox structureboundingbox)
    {
        int j1 = func_35017_a(k, i1);
        int k1 = func_35008_a(l);
        int l1 = func_35006_b(k, i1);
        if(!structureboundingbox.func_35742_b(j1, k1, l1))
        {
            return;
        }
        for(; (world.func_20084_d(j1, k1, l1) || world.func_599_f(j1, k1, l1).func_879_d()) && k1 > 1; k1--)
        {
            world.func_643_a(j1, k1, l1, i, j);
        }

    }

    protected void func_35003_a(World world, StructureBoundingBox structureboundingbox, Random random, int i, int j, int k, StructurePieceTreasure astructurepiecetreasure[], 
            int l)
    {
        int i1 = func_35017_a(i, k);
        int j1 = func_35008_a(j);
        int k1 = func_35006_b(i, k);
        if(structureboundingbox.func_35742_b(i1, j1, k1) && world.func_600_a(i1, j1, k1) != Block.field_396_av.field_376_bc)
        {
            world.func_690_d(i1, j1, k1, Block.field_396_av.field_376_bc);
            TileEntityChest tileentitychest = (TileEntityChest)world.func_603_b(i1, j1, k1);
            if(tileentitychest != null)
            {
                func_35019_a(random, astructurepiecetreasure, tileentitychest, l);
            }
        }
    }

    private static void func_35019_a(Random random, StructurePieceTreasure astructurepiecetreasure[], TileEntityChest tileentitychest, int i)
    {
        for(int j = 0; j < i; j++)
        {
            StructurePieceTreasure structurepiecetreasure = (StructurePieceTreasure)WeightedRandom.func_35735_a(random, astructurepiecetreasure);
            int k = structurepiecetreasure.field_35595_c + random.nextInt((structurepiecetreasure.field_35593_e - structurepiecetreasure.field_35595_c) + 1);
            if(Item.field_233_c[structurepiecetreasure.field_35596_a].func_200_b() >= k)
            {
                tileentitychest.func_472_a(random.nextInt(tileentitychest.func_469_c()), new ItemStack(structurepiecetreasure.field_35596_a, k, structurepiecetreasure.field_35594_b));
                continue;
            }
            for(int l = 0; l < k; l++)
            {
                tileentitychest.func_472_a(random.nextInt(tileentitychest.func_469_c()), new ItemStack(structurepiecetreasure.field_35596_a, 1, structurepiecetreasure.field_35594_b));
            }

        }

    }

    protected void func_35002_a(World world, StructureBoundingBox structureboundingbox, Random random, int i, int j, int k, int l)
    {
        int i1 = func_35017_a(i, k);
        int j1 = func_35008_a(j);
        int k1 = func_35006_b(i, k);
        if(structureboundingbox.func_35742_b(i1, j1, k1))
        {
            ItemDoor.func_35434_a(world, i1, j1, k1, l, Block.field_442_aF);
        }
    }
}

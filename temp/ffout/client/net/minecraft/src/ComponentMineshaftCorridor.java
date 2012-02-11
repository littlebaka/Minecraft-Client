// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureMineshaftPieces, Block, 
//            World, TileEntityMobSpawner

public class ComponentMineshaftCorridor extends StructureComponent
{

    private final boolean field_35070_a;
    private final boolean field_35068_b;
    private boolean field_35069_c;
    private int field_35067_d;

    public ComponentMineshaftCorridor(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
        field_35070_a = random.nextInt(3) == 0;
        field_35068_b = !field_35070_a && random.nextInt(23) == 0;
        if(field_35025_h == 2 || field_35025_h == 0)
        {
            field_35067_d = structureboundingbox.func_35739_d() / 5;
        } else
        {
            field_35067_d = structureboundingbox.func_35744_b() / 5;
        }
    }

    public static StructureBoundingBox func_35066_a(List list, Random random, int i, int j, int k, int l)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(i, j, k, i, j + 2, k);
        int i1 = random.nextInt(3) + 2;
        do
        {
            if(i1 <= 0)
            {
                break;
            }
            int j1 = i1 * 5;
            switch(l)
            {
            case 2: // '\002'
                structureboundingbox.field_35749_d = i + 2;
                structureboundingbox.field_35752_c = k - (j1 - 1);
                break;

            case 0: // '\0'
                structureboundingbox.field_35749_d = i + 2;
                structureboundingbox.field_35748_f = k + (j1 - 1);
                break;

            case 1: // '\001'
                structureboundingbox.field_35753_a = i - (j1 - 1);
                structureboundingbox.field_35748_f = k + 2;
                break;

            case 3: // '\003'
                structureboundingbox.field_35749_d = i + (j1 - 1);
                structureboundingbox.field_35748_f = k + 2;
                break;
            }
            if(StructureComponent.func_35020_a(list, structureboundingbox) == null)
            {
                break;
            }
            i1--;
        } while(true);
        if(i1 > 0)
        {
            return structureboundingbox;
        } else
        {
            return null;
        }
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        int i = func_35012_c();
        int j = random.nextInt(4);
        switch(field_35025_h)
        {
        case 2: // '\002'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35752_c - 1, field_35025_h, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35752_c, 1, i);
            } else
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35752_c, 3, i);
            }
            break;

        case 0: // '\0'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35748_f + 1, field_35025_h, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35748_f - 3, 1, i);
            } else
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35748_f - 3, 3, i);
            }
            break;

        case 1: // '\001'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35752_c, field_35025_h, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35752_c - 1, 2, i);
            } else
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35748_f + 1, 0, i);
            }
            break;

        case 3: // '\003'
            if(j <= 1)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35752_c, field_35025_h, i);
            } else
            if(j == 2)
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d - 3, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35752_c - 1, 2, i);
            } else
            {
                StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d - 3, (field_35024_g.field_35751_b - 1) + random.nextInt(3), field_35024_g.field_35748_f + 1, 0, i);
            }
            break;
        }
        if(i < 8)
        {
            if(field_35025_h == 2 || field_35025_h == 0)
            {
                for(int k = field_35024_g.field_35752_c + 3; k + 3 <= field_35024_g.field_35748_f; k += 5)
                {
                    int i1 = random.nextInt(5);
                    if(i1 == 0)
                    {
                        StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b, k, 1, i + 1);
                    } else
                    if(i1 == 1)
                    {
                        StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b, k, 3, i + 1);
                    }
                }

            } else
            {
                for(int l = field_35024_g.field_35753_a + 3; l + 3 <= field_35024_g.field_35749_d; l += 5)
                {
                    int j1 = random.nextInt(5);
                    if(j1 == 0)
                    {
                        StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, l, field_35024_g.field_35751_b, field_35024_g.field_35752_c - 1, 2, i + 1);
                        continue;
                    }
                    if(j1 == 1)
                    {
                        StructureMineshaftPieces.func_35585_a(structurecomponent, list, random, l, field_35024_g.field_35751_b, field_35024_g.field_35748_f + 1, 0, i + 1);
                    }
                }

            }
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        int i = field_35067_d * 5 - 1;
        func_35011_a(world, structureboundingbox, 0, 0, 0, 2, 1, i, 0, 0, false);
        func_35010_a(world, structureboundingbox, random, 0.8F, 0, 2, 0, 2, 2, i, 0, 0, false);
        if(field_35068_b)
        {
            func_35010_a(world, structureboundingbox, random, 0.6F, 0, 0, 0, 2, 1, i, Block.field_9258_W.field_376_bc, 0, false);
        }
        for(int j = 0; j < field_35067_d; j++)
        {
            int l = 2 + j * 5;
            func_35011_a(world, structureboundingbox, 0, 0, l, 0, 1, l, Block.field_4057_ba.field_376_bc, 0, false);
            func_35011_a(world, structureboundingbox, 2, 0, l, 2, 1, l, Block.field_4057_ba.field_376_bc, 0, false);
            if(random.nextInt(4) != 0)
            {
                func_35011_a(world, structureboundingbox, 0, 2, l, 2, 2, l, Block.field_334_y.field_376_bc, 0, false);
            } else
            {
                func_35011_a(world, structureboundingbox, 0, 2, l, 0, 2, l, Block.field_334_y.field_376_bc, 0, false);
                func_35011_a(world, structureboundingbox, 2, 2, l, 2, 2, l, Block.field_334_y.field_376_bc, 0, false);
            }
            func_35014_a(world, structureboundingbox, random, 0.1F, 0, 2, l - 1, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.1F, 2, 2, l - 1, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.1F, 0, 2, l + 1, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.1F, 2, 2, l + 1, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.05F, 0, 2, l - 2, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.05F, 2, 2, l - 2, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.05F, 0, 2, l + 2, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.05F, 2, 2, l + 2, Block.field_9258_W.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.05F, 1, 2, l - 1, Block.field_404_ar.field_376_bc, 0);
            func_35014_a(world, structureboundingbox, random, 0.05F, 1, 2, l + 1, Block.field_404_ar.field_376_bc, 0);
            if(random.nextInt(100) == 0)
            {
                func_35003_a(world, structureboundingbox, random, 2, 0, l - 1, StructureMineshaftPieces.func_35588_a(), 3 + random.nextInt(4));
            }
            if(random.nextInt(100) == 0)
            {
                func_35003_a(world, structureboundingbox, random, 0, 0, l + 1, StructureMineshaftPieces.func_35588_a(), 3 + random.nextInt(4));
            }
            if(!field_35068_b || field_35069_c)
            {
                continue;
            }
            int j1 = func_35008_a(0);
            int k1 = (l - 1) + random.nextInt(3);
            int l1 = func_35017_a(1, k1);
            k1 = func_35006_b(1, k1);
            if(!structureboundingbox.func_35742_b(l1, j1, k1))
            {
                continue;
            }
            field_35069_c = true;
            world.func_690_d(l1, j1, k1, Block.field_400_at.field_376_bc);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.func_603_b(l1, j1, k1);
            if(tileentitymobspawner != null)
            {
                tileentitymobspawner.func_21098_a("CaveSpider");
            }
        }

        if(field_35070_a)
        {
            for(int k = 0; k <= i; k++)
            {
                int i1 = func_35007_a(world, 1, -1, k, structureboundingbox);
                if(i1 > 0 && Block.field_343_p[i1])
                {
                    func_35014_a(world, structureboundingbox, random, 0.7F, 1, 0, k, Block.field_440_aH.field_376_bc, func_35009_c(Block.field_440_aH.field_376_bc, 0));
                }
            }

        }
        return true;
    }
}

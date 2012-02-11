// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Path, IntHashMap, PathPoint, Entity, 
//            AxisAlignedBB, MathHelper, IBlockAccess, Block, 
//            BlockDoor, Material, PathEntity

public class PathFinder
{

    private IBlockAccess field_1674_a;
    private Path field_1673_b;
    private IntHashMap field_1676_c;
    private PathPoint field_1675_d[];

    public PathFinder(IBlockAccess iblockaccess)
    {
        field_1673_b = new Path();
        field_1676_c = new IntHashMap();
        field_1675_d = new PathPoint[32];
        field_1674_a = iblockaccess;
    }

    public PathEntity func_1137_a(Entity entity, Entity entity1, float f)
    {
        return func_1130_a(entity, entity1.field_611_ak, entity1.field_601_au.field_1697_b, entity1.field_609_am, f);
    }

    public PathEntity func_1131_a(Entity entity, int i, int j, int k, float f)
    {
        return func_1130_a(entity, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, f);
    }

    private PathEntity func_1130_a(Entity entity, double d, double d1, double d2, 
            float f)
    {
        field_1673_b.func_1038_a();
        field_1676_c.func_1058_a();
        PathPoint pathpoint = func_1136_a(MathHelper.func_1108_b(entity.field_601_au.field_1698_a), MathHelper.func_1108_b(entity.field_601_au.field_1697_b), MathHelper.func_1108_b(entity.field_601_au.field_1704_c));
        PathPoint pathpoint1 = func_1136_a(MathHelper.func_1108_b(d - (double)(entity.field_644_aC / 2.0F)), MathHelper.func_1108_b(d1), MathHelper.func_1108_b(d2 - (double)(entity.field_644_aC / 2.0F)));
        PathPoint pathpoint2 = new PathPoint(MathHelper.func_1110_d(entity.field_644_aC + 1.0F), MathHelper.func_1110_d(entity.field_643_aD + 1.0F), MathHelper.func_1110_d(entity.field_644_aC + 1.0F));
        PathEntity pathentity = func_1129_a(entity, pathpoint, pathpoint1, pathpoint2, f);
        return pathentity;
    }

    private PathEntity func_1129_a(Entity entity, PathPoint pathpoint, PathPoint pathpoint1, PathPoint pathpoint2, float f)
    {
        pathpoint.field_1713_f = 0.0F;
        pathpoint.field_1712_g = pathpoint.func_1180_a(pathpoint1);
        pathpoint.field_1711_h = pathpoint.field_1712_g;
        field_1673_b.func_1038_a();
        field_1673_b.func_1034_a(pathpoint);
        PathPoint pathpoint3 = pathpoint;
        while(!field_1673_b.func_1039_c()) 
        {
            PathPoint pathpoint4 = field_1673_b.func_1036_b();
            if(pathpoint4.equals(pathpoint1))
            {
                return func_1134_a(pathpoint, pathpoint1);
            }
            if(pathpoint4.func_1180_a(pathpoint1) < pathpoint3.func_1180_a(pathpoint1))
            {
                pathpoint3 = pathpoint4;
            }
            pathpoint4.field_1709_j = true;
            int i = func_1133_b(entity, pathpoint4, pathpoint2, pathpoint1, f);
            int j = 0;
            while(j < i) 
            {
                PathPoint pathpoint5 = field_1675_d[j];
                float f1 = pathpoint4.field_1713_f + pathpoint4.func_1180_a(pathpoint5);
                if(!pathpoint5.func_1179_a() || f1 < pathpoint5.field_1713_f)
                {
                    pathpoint5.field_1710_i = pathpoint4;
                    pathpoint5.field_1713_f = f1;
                    pathpoint5.field_1712_g = pathpoint5.func_1180_a(pathpoint1);
                    if(pathpoint5.func_1179_a())
                    {
                        field_1673_b.func_1035_a(pathpoint5, pathpoint5.field_1713_f + pathpoint5.field_1712_g);
                    } else
                    {
                        pathpoint5.field_1711_h = pathpoint5.field_1713_f + pathpoint5.field_1712_g;
                        field_1673_b.func_1034_a(pathpoint5);
                    }
                }
                j++;
            }
        }
        if(pathpoint3 == pathpoint)
        {
            return null;
        } else
        {
            return func_1134_a(pathpoint, pathpoint3);
        }
    }

    private int func_1133_b(Entity entity, PathPoint pathpoint, PathPoint pathpoint1, PathPoint pathpoint2, float f)
    {
        int i = 0;
        int j = 0;
        if(func_1132_a(entity, pathpoint.field_1718_a, pathpoint.field_1717_b + 1, pathpoint.field_1716_c, pathpoint1) == 1)
        {
            j = 1;
        }
        PathPoint pathpoint3 = func_1135_a(entity, pathpoint.field_1718_a, pathpoint.field_1717_b, pathpoint.field_1716_c + 1, pathpoint1, j);
        PathPoint pathpoint4 = func_1135_a(entity, pathpoint.field_1718_a - 1, pathpoint.field_1717_b, pathpoint.field_1716_c, pathpoint1, j);
        PathPoint pathpoint5 = func_1135_a(entity, pathpoint.field_1718_a + 1, pathpoint.field_1717_b, pathpoint.field_1716_c, pathpoint1, j);
        PathPoint pathpoint6 = func_1135_a(entity, pathpoint.field_1718_a, pathpoint.field_1717_b, pathpoint.field_1716_c - 1, pathpoint1, j);
        if(pathpoint3 != null && !pathpoint3.field_1709_j && pathpoint3.func_1180_a(pathpoint2) < f)
        {
            field_1675_d[i++] = pathpoint3;
        }
        if(pathpoint4 != null && !pathpoint4.field_1709_j && pathpoint4.func_1180_a(pathpoint2) < f)
        {
            field_1675_d[i++] = pathpoint4;
        }
        if(pathpoint5 != null && !pathpoint5.field_1709_j && pathpoint5.func_1180_a(pathpoint2) < f)
        {
            field_1675_d[i++] = pathpoint5;
        }
        if(pathpoint6 != null && !pathpoint6.field_1709_j && pathpoint6.func_1180_a(pathpoint2) < f)
        {
            field_1675_d[i++] = pathpoint6;
        }
        return i;
    }

    private PathPoint func_1135_a(Entity entity, int i, int j, int k, PathPoint pathpoint, int l)
    {
        PathPoint pathpoint1 = null;
        if(func_1132_a(entity, i, j, k, pathpoint) == 1)
        {
            pathpoint1 = func_1136_a(i, j, k);
        }
        if(pathpoint1 == null && l > 0 && func_1132_a(entity, i, j + l, k, pathpoint) == 1)
        {
            pathpoint1 = func_1136_a(i, j + l, k);
            j += l;
        }
        if(pathpoint1 != null)
        {
            int i1 = 0;
            int j1 = 0;
            do
            {
                if(j <= 0 || (j1 = func_1132_a(entity, i, j - 1, k, pathpoint)) != 1)
                {
                    break;
                }
                if(++i1 >= 4)
                {
                    return null;
                }
                if(--j > 0)
                {
                    pathpoint1 = func_1136_a(i, j, k);
                }
            } while(true);
            if(j1 == -2)
            {
                return null;
            }
        }
        return pathpoint1;
    }

    private final PathPoint func_1136_a(int i, int j, int k)
    {
        int l = PathPoint.func_22329_a(i, j, k);
        PathPoint pathpoint = (PathPoint)field_1676_c.func_1057_a(l);
        if(pathpoint == null)
        {
            pathpoint = new PathPoint(i, j, k);
            field_1676_c.func_1061_a(l, pathpoint);
        }
        return pathpoint;
    }

    private int func_1132_a(Entity entity, int i, int j, int k, PathPoint pathpoint)
    {
        for(int l = i; l < i + pathpoint.field_1718_a; l++)
        {
            for(int i1 = j; i1 < j + pathpoint.field_1717_b; i1++)
            {
                for(int j1 = k; j1 < k + pathpoint.field_1716_c; j1++)
                {
                    int k1 = field_1674_a.func_600_a(l, i1, j1);
                    if(k1 <= 0)
                    {
                        continue;
                    }
                    if(k1 == Block.field_435_aM.field_376_bc || k1 == Block.field_442_aF.field_376_bc)
                    {
                        int l1 = field_1674_a.func_602_e(l, i1, j1);
                        if(!BlockDoor.func_27047_e(l1))
                        {
                            return 0;
                        }
                        continue;
                    }
                    Material material = Block.field_345_n[k1].field_356_bn;
                    if(material.func_880_c())
                    {
                        return 0;
                    }
                    if(material == Material.field_1332_f)
                    {
                        return -1;
                    }
                    if(material == Material.field_1331_g)
                    {
                        return -2;
                    }
                }

            }

        }

        return 1;
    }

    private PathEntity func_1134_a(PathPoint pathpoint, PathPoint pathpoint1)
    {
        int i = 1;
        for(PathPoint pathpoint2 = pathpoint1; pathpoint2.field_1710_i != null; pathpoint2 = pathpoint2.field_1710_i)
        {
            i++;
        }

        PathPoint apathpoint[] = new PathPoint[i];
        PathPoint pathpoint3 = pathpoint1;
        for(apathpoint[--i] = pathpoint3; pathpoint3.field_1710_i != null; apathpoint[--i] = pathpoint3)
        {
            pathpoint3 = pathpoint3.field_1710_i;
        }

        return new PathEntity(apathpoint);
    }
}

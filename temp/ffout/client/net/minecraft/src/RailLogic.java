// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            World, Block, BlockRail, ChunkPosition

class RailLogic
{

    private World field_1159_b;
    private int field_1165_c;
    private int field_1164_d;
    private int field_1163_e;
    private final boolean field_27212_f;
    private List field_1161_g;
    final BlockRail field_1160_a; /* synthetic field */

    public RailLogic(BlockRail blockrail, World world, int i, int j, int k)
    {
        field_1160_a = blockrail;
        super();
        field_1161_g = new ArrayList();
        field_1159_b = world;
        field_1165_c = i;
        field_1164_d = j;
        field_1163_e = k;
        int l = world.func_600_a(i, j, k);
        int i1 = world.func_602_e(i, j, k);
        if(BlockRail.func_27039_a((BlockRail)Block.field_345_n[l]))
        {
            field_27212_f = true;
            i1 &= -9;
        } else
        {
            field_27212_f = false;
        }
        func_27211_a(i1);
    }

    private void func_27211_a(int i)
    {
        field_1161_g.clear();
        if(i == 0)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e - 1));
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e + 1));
        } else
        if(i == 1)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c - 1, field_1164_d, field_1163_e));
            field_1161_g.add(new ChunkPosition(field_1165_c + 1, field_1164_d, field_1163_e));
        } else
        if(i == 2)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c - 1, field_1164_d, field_1163_e));
            field_1161_g.add(new ChunkPosition(field_1165_c + 1, field_1164_d + 1, field_1163_e));
        } else
        if(i == 3)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c - 1, field_1164_d + 1, field_1163_e));
            field_1161_g.add(new ChunkPosition(field_1165_c + 1, field_1164_d, field_1163_e));
        } else
        if(i == 4)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d + 1, field_1163_e - 1));
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e + 1));
        } else
        if(i == 5)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e - 1));
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d + 1, field_1163_e + 1));
        } else
        if(i == 6)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c + 1, field_1164_d, field_1163_e));
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e + 1));
        } else
        if(i == 7)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c - 1, field_1164_d, field_1163_e));
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e + 1));
        } else
        if(i == 8)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c - 1, field_1164_d, field_1163_e));
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e - 1));
        } else
        if(i == 9)
        {
            field_1161_g.add(new ChunkPosition(field_1165_c + 1, field_1164_d, field_1163_e));
            field_1161_g.add(new ChunkPosition(field_1165_c, field_1164_d, field_1163_e - 1));
        }
    }

    private void func_785_b()
    {
        for(int i = 0; i < field_1161_g.size(); i++)
        {
            RailLogic raillogic = func_795_a((ChunkPosition)field_1161_g.get(i));
            if(raillogic == null || !raillogic.func_793_b(this))
            {
                field_1161_g.remove(i--);
            } else
            {
                field_1161_g.set(i, new ChunkPosition(raillogic.field_1165_c, raillogic.field_1164_d, raillogic.field_1163_e));
            }
        }

    }

    private boolean func_784_a(int i, int j, int k)
    {
        if(BlockRail.func_27040_h(field_1159_b, i, j, k))
        {
            return true;
        }
        if(BlockRail.func_27040_h(field_1159_b, i, j + 1, k))
        {
            return true;
        }
        return BlockRail.func_27040_h(field_1159_b, i, j - 1, k);
    }

    private RailLogic func_795_a(ChunkPosition chunkposition)
    {
        if(BlockRail.func_27040_h(field_1159_b, chunkposition.field_1111_a, chunkposition.field_1110_b, chunkposition.field_1112_c))
        {
            return new RailLogic(field_1160_a, field_1159_b, chunkposition.field_1111_a, chunkposition.field_1110_b, chunkposition.field_1112_c);
        }
        if(BlockRail.func_27040_h(field_1159_b, chunkposition.field_1111_a, chunkposition.field_1110_b + 1, chunkposition.field_1112_c))
        {
            return new RailLogic(field_1160_a, field_1159_b, chunkposition.field_1111_a, chunkposition.field_1110_b + 1, chunkposition.field_1112_c);
        }
        if(BlockRail.func_27040_h(field_1159_b, chunkposition.field_1111_a, chunkposition.field_1110_b - 1, chunkposition.field_1112_c))
        {
            return new RailLogic(field_1160_a, field_1159_b, chunkposition.field_1111_a, chunkposition.field_1110_b - 1, chunkposition.field_1112_c);
        } else
        {
            return null;
        }
    }

    private boolean func_793_b(RailLogic raillogic)
    {
        for(int i = 0; i < field_1161_g.size(); i++)
        {
            ChunkPosition chunkposition = (ChunkPosition)field_1161_g.get(i);
            if(chunkposition.field_1111_a == raillogic.field_1165_c && chunkposition.field_1112_c == raillogic.field_1163_e)
            {
                return true;
            }
        }

        return false;
    }

    private boolean func_794_b(int i, int j, int k)
    {
        for(int l = 0; l < field_1161_g.size(); l++)
        {
            ChunkPosition chunkposition = (ChunkPosition)field_1161_g.get(l);
            if(chunkposition.field_1111_a == i && chunkposition.field_1112_c == k)
            {
                return true;
            }
        }

        return false;
    }

    private int func_790_c()
    {
        int i = 0;
        if(func_784_a(field_1165_c, field_1164_d, field_1163_e - 1))
        {
            i++;
        }
        if(func_784_a(field_1165_c, field_1164_d, field_1163_e + 1))
        {
            i++;
        }
        if(func_784_a(field_1165_c - 1, field_1164_d, field_1163_e))
        {
            i++;
        }
        if(func_784_a(field_1165_c + 1, field_1164_d, field_1163_e))
        {
            i++;
        }
        return i;
    }

    private boolean func_787_c(RailLogic raillogic)
    {
        if(func_793_b(raillogic))
        {
            return true;
        }
        if(field_1161_g.size() == 2)
        {
            return false;
        }
        if(field_1161_g.size() == 0)
        {
            return true;
        }
        ChunkPosition chunkposition = (ChunkPosition)field_1161_g.get(0);
        return raillogic.field_1164_d != field_1164_d || chunkposition.field_1110_b != field_1164_d ? true : true;
    }

    private void func_788_d(RailLogic raillogic)
    {
        field_1161_g.add(new ChunkPosition(raillogic.field_1165_c, raillogic.field_1164_d, raillogic.field_1163_e));
        boolean flag = func_794_b(field_1165_c, field_1164_d, field_1163_e - 1);
        boolean flag1 = func_794_b(field_1165_c, field_1164_d, field_1163_e + 1);
        boolean flag2 = func_794_b(field_1165_c - 1, field_1164_d, field_1163_e);
        boolean flag3 = func_794_b(field_1165_c + 1, field_1164_d, field_1163_e);
        byte byte0 = -1;
        if(flag || flag1)
        {
            byte0 = 0;
        }
        if(flag2 || flag3)
        {
            byte0 = 1;
        }
        if(!field_27212_f)
        {
            if(flag1 && flag3 && !flag && !flag2)
            {
                byte0 = 6;
            }
            if(flag1 && flag2 && !flag && !flag3)
            {
                byte0 = 7;
            }
            if(flag && flag2 && !flag1 && !flag3)
            {
                byte0 = 8;
            }
            if(flag && flag3 && !flag1 && !flag2)
            {
                byte0 = 9;
            }
        }
        if(byte0 == 0)
        {
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c, field_1164_d + 1, field_1163_e - 1))
            {
                byte0 = 4;
            }
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c, field_1164_d + 1, field_1163_e + 1))
            {
                byte0 = 5;
            }
        }
        if(byte0 == 1)
        {
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c + 1, field_1164_d + 1, field_1163_e))
            {
                byte0 = 2;
            }
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c - 1, field_1164_d + 1, field_1163_e))
            {
                byte0 = 3;
            }
        }
        if(byte0 < 0)
        {
            byte0 = 0;
        }
        int i = byte0;
        if(field_27212_f)
        {
            i = field_1159_b.func_602_e(field_1165_c, field_1164_d, field_1163_e) & 8 | byte0;
        }
        field_1159_b.func_691_b(field_1165_c, field_1164_d, field_1163_e, i);
    }

    private boolean func_786_c(int i, int j, int k)
    {
        RailLogic raillogic = func_795_a(new ChunkPosition(i, j, k));
        if(raillogic == null)
        {
            return false;
        } else
        {
            raillogic.func_785_b();
            return raillogic.func_787_c(this);
        }
    }

    public void func_792_a(boolean flag, boolean flag1)
    {
        boolean flag2 = func_786_c(field_1165_c, field_1164_d, field_1163_e - 1);
        boolean flag3 = func_786_c(field_1165_c, field_1164_d, field_1163_e + 1);
        boolean flag4 = func_786_c(field_1165_c - 1, field_1164_d, field_1163_e);
        boolean flag5 = func_786_c(field_1165_c + 1, field_1164_d, field_1163_e);
        byte byte0 = -1;
        if((flag2 || flag3) && !flag4 && !flag5)
        {
            byte0 = 0;
        }
        if((flag4 || flag5) && !flag2 && !flag3)
        {
            byte0 = 1;
        }
        if(!field_27212_f)
        {
            if(flag3 && flag5 && !flag2 && !flag4)
            {
                byte0 = 6;
            }
            if(flag3 && flag4 && !flag2 && !flag5)
            {
                byte0 = 7;
            }
            if(flag2 && flag4 && !flag3 && !flag5)
            {
                byte0 = 8;
            }
            if(flag2 && flag5 && !flag3 && !flag4)
            {
                byte0 = 9;
            }
        }
        if(byte0 == -1)
        {
            if(flag2 || flag3)
            {
                byte0 = 0;
            }
            if(flag4 || flag5)
            {
                byte0 = 1;
            }
            if(!field_27212_f)
            {
                if(flag)
                {
                    if(flag3 && flag5)
                    {
                        byte0 = 6;
                    }
                    if(flag4 && flag3)
                    {
                        byte0 = 7;
                    }
                    if(flag5 && flag2)
                    {
                        byte0 = 9;
                    }
                    if(flag2 && flag4)
                    {
                        byte0 = 8;
                    }
                } else
                {
                    if(flag2 && flag4)
                    {
                        byte0 = 8;
                    }
                    if(flag5 && flag2)
                    {
                        byte0 = 9;
                    }
                    if(flag4 && flag3)
                    {
                        byte0 = 7;
                    }
                    if(flag3 && flag5)
                    {
                        byte0 = 6;
                    }
                }
            }
        }
        if(byte0 == 0)
        {
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c, field_1164_d + 1, field_1163_e - 1))
            {
                byte0 = 4;
            }
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c, field_1164_d + 1, field_1163_e + 1))
            {
                byte0 = 5;
            }
        }
        if(byte0 == 1)
        {
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c + 1, field_1164_d + 1, field_1163_e))
            {
                byte0 = 2;
            }
            if(BlockRail.func_27040_h(field_1159_b, field_1165_c - 1, field_1164_d + 1, field_1163_e))
            {
                byte0 = 3;
            }
        }
        if(byte0 < 0)
        {
            byte0 = 0;
        }
        func_27211_a(byte0);
        int i = byte0;
        if(field_27212_f)
        {
            i = field_1159_b.func_602_e(field_1165_c, field_1164_d, field_1163_e) & 8 | byte0;
        }
        if(flag1 || field_1159_b.func_602_e(field_1165_c, field_1164_d, field_1163_e) != i)
        {
            field_1159_b.func_691_b(field_1165_c, field_1164_d, field_1163_e, i);
            for(int j = 0; j < field_1161_g.size(); j++)
            {
                RailLogic raillogic = func_795_a((ChunkPosition)field_1161_g.get(j));
                if(raillogic == null)
                {
                    continue;
                }
                raillogic.func_785_b();
                if(raillogic.func_787_c(this))
                {
                    raillogic.func_788_d(this);
                }
            }

        }
    }

    static int func_791_a(RailLogic raillogic)
    {
        return raillogic.func_790_c();
    }
}

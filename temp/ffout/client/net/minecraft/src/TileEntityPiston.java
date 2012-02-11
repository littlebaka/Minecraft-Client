// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            TileEntity, Facing, Block, BlockPistonMoving, 
//            World, Entity, NBTTagCompound

public class TileEntityPiston extends TileEntity
{

    private int field_31021_a;
    private int field_31019_b;
    private int field_31025_c;
    private boolean field_31024_i;
    private boolean field_31023_j;
    private float field_31022_k;
    private float field_31020_l;
    private static List field_31018_m = new ArrayList();

    public TileEntityPiston()
    {
    }

    public TileEntityPiston(int i, int j, int k, boolean flag, boolean flag1)
    {
        field_31021_a = i;
        field_31019_b = j;
        field_31025_c = k;
        field_31024_i = flag;
        field_31023_j = flag1;
    }

    public int func_31016_a()
    {
        return field_31021_a;
    }

    public int func_479_f()
    {
        return field_31019_b;
    }

    public boolean func_31015_b()
    {
        return field_31024_i;
    }

    public int func_31009_d()
    {
        return field_31025_c;
    }

    public boolean func_31012_k()
    {
        return field_31023_j;
    }

    public float func_31008_a(float f)
    {
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        return field_31020_l + (field_31022_k - field_31020_l) * f;
    }

    public float func_31017_b(float f)
    {
        if(field_31024_i)
        {
            return (func_31008_a(f) - 1.0F) * (float)Facing.field_31056_b[field_31025_c];
        } else
        {
            return (1.0F - func_31008_a(f)) * (float)Facing.field_31056_b[field_31025_c];
        }
    }

    public float func_31014_c(float f)
    {
        if(field_31024_i)
        {
            return (func_31008_a(f) - 1.0F) * (float)Facing.field_31059_c[field_31025_c];
        } else
        {
            return (1.0F - func_31008_a(f)) * (float)Facing.field_31059_c[field_31025_c];
        }
    }

    public float func_31013_d(float f)
    {
        if(field_31024_i)
        {
            return (func_31008_a(f) - 1.0F) * (float)Facing.field_31058_d[field_31025_c];
        } else
        {
            return (1.0F - func_31008_a(f)) * (float)Facing.field_31058_d[field_31025_c];
        }
    }

    private void func_31010_a(float f, float f1)
    {
        if(!field_31024_i)
        {
            f--;
        } else
        {
            f = 1.0F - f;
        }
        AxisAlignedBB axisalignedbb = Block.field_9268_ac.func_31035_a(field_824_e, field_823_f, field_822_g, field_821_h, field_31021_a, f, field_31025_c);
        if(axisalignedbb != null)
        {
            List list = field_824_e.func_659_b(null, axisalignedbb);
            if(!list.isEmpty())
            {
                field_31018_m.addAll(list);
                Entity entity;
                for(Iterator iterator = field_31018_m.iterator(); iterator.hasNext(); entity.func_349_c(f1 * (float)Facing.field_31056_b[field_31025_c], f1 * (float)Facing.field_31059_c[field_31025_c], f1 * (float)Facing.field_31058_d[field_31025_c]))
                {
                    entity = (Entity)iterator.next();
                }

                field_31018_m.clear();
            }
        }
    }

    public void func_31011_l()
    {
        if(field_31020_l < 1.0F && field_824_e != null)
        {
            field_31020_l = field_31022_k = 1.0F;
            field_824_e.func_692_l(field_823_f, field_822_g, field_821_h);
            func_31005_i();
            if(field_824_e.func_600_a(field_823_f, field_822_g, field_821_h) == Block.field_9268_ac.field_376_bc)
            {
                field_824_e.func_688_b(field_823_f, field_822_g, field_821_h, field_31021_a, field_31019_b);
            }
        }
    }

    public void func_475_b()
    {
        field_31020_l = field_31022_k;
        if(field_31020_l >= 1.0F)
        {
            func_31010_a(1.0F, 0.25F);
            field_824_e.func_692_l(field_823_f, field_822_g, field_821_h);
            func_31005_i();
            if(field_824_e.func_600_a(field_823_f, field_822_g, field_821_h) == Block.field_9268_ac.field_376_bc)
            {
                field_824_e.func_688_b(field_823_f, field_822_g, field_821_h, field_31021_a, field_31019_b);
            }
            return;
        }
        field_31022_k += 0.5F;
        if(field_31022_k >= 1.0F)
        {
            field_31022_k = 1.0F;
        }
        if(field_31024_i)
        {
            func_31010_a(field_31022_k, (field_31022_k - field_31020_l) + 0.0625F);
        }
    }

    public void func_482_a(NBTTagCompound nbttagcompound)
    {
        super.func_482_a(nbttagcompound);
        field_31021_a = nbttagcompound.func_756_e("blockId");
        field_31019_b = nbttagcompound.func_756_e("blockData");
        field_31025_c = nbttagcompound.func_756_e("facing");
        field_31020_l = field_31022_k = nbttagcompound.func_752_g("progress");
        field_31024_i = nbttagcompound.func_760_m("extending");
    }

    public void func_481_b(NBTTagCompound nbttagcompound)
    {
        super.func_481_b(nbttagcompound);
        nbttagcompound.func_758_a("blockId", field_31021_a);
        nbttagcompound.func_758_a("blockData", field_31019_b);
        nbttagcompound.func_758_a("facing", field_31025_c);
        nbttagcompound.func_744_a("progress", field_31020_l);
        nbttagcompound.func_748_a("extending", field_31024_i);
    }

}

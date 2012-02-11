// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            StatBase, ItemStack, AchievementList, StatCollector, 
//            IStatStringFormat, Item, Block

public class Achievement extends StatBase
{

    public final int field_25075_a;
    public final int field_25074_b;
    public final Achievement field_25076_c;
    private final String field_27096_l;
    private IStatStringFormat field_27095_m;
    public final ItemStack field_27097_d;
    private boolean field_27098_n;

    public Achievement(int i, String s, int j, int k, Item item, Achievement achievement)
    {
        this(i, s, j, k, new ItemStack(item), achievement);
    }

    public Achievement(int i, String s, int j, int k, Block block, Achievement achievement)
    {
        this(i, s, j, k, new ItemStack(block), achievement);
    }

    public Achievement(int i, String s, int j, int k, ItemStack itemstack, Achievement achievement)
    {
        super(0x500000 + i, (new StringBuilder()).append("achievement.").append(s).toString());
        field_27097_d = itemstack;
        field_27096_l = (new StringBuilder()).append("achievement.").append(s).append(".desc").toString();
        field_25075_a = j;
        field_25074_b = k;
        if(j < AchievementList.field_27392_a)
        {
            AchievementList.field_27392_a = j;
        }
        if(k < AchievementList.field_27391_b)
        {
            AchievementList.field_27391_b = k;
        }
        if(j > AchievementList.field_27390_c)
        {
            AchievementList.field_27390_c = j;
        }
        if(k > AchievementList.field_27389_d)
        {
            AchievementList.field_27389_d = k;
        }
        field_25076_c = achievement;
    }

    public Achievement func_27089_a()
    {
        field_27088_g = true;
        return this;
    }

    public Achievement func_27094_b()
    {
        field_27098_n = true;
        return this;
    }

    public Achievement func_27091_c()
    {
        super.func_25068_c();
        AchievementList.field_27388_e.add(this);
        return this;
    }

    public boolean func_25067_a()
    {
        return true;
    }

    public String func_27090_e()
    {
        if(field_27095_m != null)
        {
            return field_27095_m.func_27343_a(StatCollector.func_25200_a(field_27096_l));
        } else
        {
            return StatCollector.func_25200_a(field_27096_l);
        }
    }

    public Achievement func_27092_a(IStatStringFormat istatstringformat)
    {
        field_27095_m = istatstringformat;
        return this;
    }

    public boolean func_27093_f()
    {
        return field_27098_n;
    }

    public StatBase func_25068_c()
    {
        return func_27091_c();
    }

    public StatBase func_27082_h()
    {
        return func_27089_a();
    }
}

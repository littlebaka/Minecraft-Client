// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class StructureBoundingBox
{

    public int field_35753_a;
    public int field_35751_b;
    public int field_35752_c;
    public int field_35749_d;
    public int field_35750_e;
    public int field_35748_f;

    public StructureBoundingBox()
    {
    }

    public static StructureBoundingBox func_35741_a()
    {
        return new StructureBoundingBox(0x7fffffff, 0x7fffffff, 0x7fffffff, 0x80000000, 0x80000000, 0x80000000);
    }

    public static StructureBoundingBox func_35747_a(int i, int j, int k, int l, int i1, int j1, int k1, int l1, 
            int i2, int j2)
    {
        switch(j2)
        {
        default:
            return new StructureBoundingBox(i + l, j + i1, k + j1, ((i + k1) - 1) + l, ((j + l1) - 1) + i1, ((k + i2) - 1) + j1);

        case 2: // '\002'
            return new StructureBoundingBox(i + l, j + i1, (k - i2) + 1 + j1, ((i + k1) - 1) + l, ((j + l1) - 1) + i1, k + j1);

        case 0: // '\0'
            return new StructureBoundingBox(i + l, j + i1, k + j1, ((i + k1) - 1) + l, ((j + l1) - 1) + i1, ((k + i2) - 1) + j1);

        case 1: // '\001'
            return new StructureBoundingBox((i - i2) + 1 + j1, j + i1, k + l, i + j1, ((j + l1) - 1) + i1, ((k + k1) - 1) + l);

        case 3: // '\003'
            return new StructureBoundingBox(i + j1, j + i1, k + l, ((i + i2) - 1) + j1, ((j + l1) - 1) + i1, ((k + k1) - 1) + l);
        }
    }

    public StructureBoundingBox(StructureBoundingBox structureboundingbox)
    {
        field_35753_a = structureboundingbox.field_35753_a;
        field_35751_b = structureboundingbox.field_35751_b;
        field_35752_c = structureboundingbox.field_35752_c;
        field_35749_d = structureboundingbox.field_35749_d;
        field_35750_e = structureboundingbox.field_35750_e;
        field_35748_f = structureboundingbox.field_35748_f;
    }

    public StructureBoundingBox(int i, int j, int k, int l, int i1, int j1)
    {
        field_35753_a = i;
        field_35751_b = j;
        field_35752_c = k;
        field_35749_d = l;
        field_35750_e = i1;
        field_35748_f = j1;
    }

    public StructureBoundingBox(int i, int j, int k, int l)
    {
        field_35753_a = i;
        field_35752_c = j;
        field_35749_d = k;
        field_35748_f = l;
        field_35751_b = 1;
        field_35750_e = 512;
    }

    public boolean func_35740_a(StructureBoundingBox structureboundingbox)
    {
        return field_35749_d >= structureboundingbox.field_35753_a && field_35753_a <= structureboundingbox.field_35749_d && field_35748_f >= structureboundingbox.field_35752_c && field_35752_c <= structureboundingbox.field_35748_f && field_35750_e >= structureboundingbox.field_35751_b && field_35751_b <= structureboundingbox.field_35750_e;
    }

    public boolean func_35746_a(int i, int j, int k, int l)
    {
        return field_35749_d >= i && field_35753_a <= k && field_35748_f >= j && field_35752_c <= l;
    }

    public void func_35738_b(StructureBoundingBox structureboundingbox)
    {
        field_35753_a = Math.min(field_35753_a, structureboundingbox.field_35753_a);
        field_35751_b = Math.min(field_35751_b, structureboundingbox.field_35751_b);
        field_35752_c = Math.min(field_35752_c, structureboundingbox.field_35752_c);
        field_35749_d = Math.max(field_35749_d, structureboundingbox.field_35749_d);
        field_35750_e = Math.max(field_35750_e, structureboundingbox.field_35750_e);
        field_35748_f = Math.max(field_35748_f, structureboundingbox.field_35748_f);
    }

    public void func_35745_a(int i, int j, int k)
    {
        field_35753_a += i;
        field_35751_b += j;
        field_35752_c += k;
        field_35749_d += i;
        field_35750_e += j;
        field_35748_f += k;
    }

    public boolean func_35742_b(int i, int j, int k)
    {
        return i >= field_35753_a && i <= field_35749_d && k >= field_35752_c && k <= field_35748_f && j >= field_35751_b && j <= field_35750_e;
    }

    public int func_35744_b()
    {
        return (field_35749_d - field_35753_a) + 1;
    }

    public int func_35743_c()
    {
        return (field_35750_e - field_35751_b) + 1;
    }

    public int func_35739_d()
    {
        return (field_35748_f - field_35752_c) + 1;
    }

    public int func_40597_e()
    {
        return field_35753_a + ((field_35749_d - field_35753_a) + 1) / 2;
    }

    public int func_40596_f()
    {
        return field_35751_b + ((field_35750_e - field_35751_b) + 1) / 2;
    }

    public int func_40598_g()
    {
        return field_35752_c + ((field_35748_f - field_35752_c) + 1) / 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("(").append(field_35753_a).append(", ").append(field_35751_b).append(", ").append(field_35752_c).append("; ").append(field_35749_d).append(", ").append(field_35750_e).append(", ").append(field_35748_f).append(")").toString();
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDamageSource, EntityDamageSourceIndirect, EntityLiving, EntityPlayer, 
//            EntityArrow, Entity, EntityFireball

public class DamageSource
{

    public static DamageSource field_35542_a = (new DamageSource("inFire")).func_40546_j();
    public static DamageSource field_35540_b = (new DamageSource("onFire")).func_35528_f().func_40546_j();
    public static DamageSource field_35541_c = (new DamageSource("lava")).func_40546_j();
    public static DamageSource field_35538_d = (new DamageSource("inWall")).func_35528_f();
    public static DamageSource field_35539_e = (new DamageSource("drown")).func_35528_f();
    public static DamageSource field_35536_f = (new DamageSource("starve")).func_35528_f();
    public static DamageSource field_35537_g = new DamageSource("cactus");
    public static DamageSource field_35549_h = (new DamageSource("fall")).func_35528_f();
    public static DamageSource field_35550_i = (new DamageSource("outOfWorld")).func_35528_f().func_35531_g();
    public static DamageSource field_35547_j = (new DamageSource("generic")).func_35528_f();
    public static DamageSource field_35548_k = new DamageSource("explosion");
    public static DamageSource field_35545_l = (new DamageSource("magic")).func_35528_f();
    private boolean field_35543_n;
    private boolean field_35544_o;
    private float field_35551_p;
    private boolean field_40549_q;
    private boolean field_40548_r;
    public String field_35546_m;

    public static DamageSource func_35525_a(EntityLiving entityliving)
    {
        return new EntityDamageSource("mob", entityliving);
    }

    public static DamageSource func_35527_a(EntityPlayer entityplayer)
    {
        return new EntityDamageSource("player", entityplayer);
    }

    public static DamageSource func_35535_a(EntityArrow entityarrow, Entity entity)
    {
        return (new EntityDamageSourceIndirect("arrow", entityarrow, entity)).func_40544_c();
    }

    public static DamageSource func_35530_a(EntityFireball entityfireball, Entity entity)
    {
        return (new EntityDamageSourceIndirect("fireball", entityfireball, entity)).func_40546_j().func_40544_c();
    }

    public static DamageSource func_35524_a(Entity entity, Entity entity1)
    {
        return (new EntityDamageSourceIndirect("thrown", entity, entity1)).func_40544_c();
    }

    public static DamageSource func_40542_b(Entity entity, Entity entity1)
    {
        return (new EntityDamageSourceIndirect("indirectMagic", entity, entity1)).func_35528_f();
    }

    public boolean func_40547_b()
    {
        return field_40548_r;
    }

    public DamageSource func_40544_c()
    {
        field_40548_r = true;
        return this;
    }

    public boolean func_35534_b()
    {
        return field_35543_n;
    }

    public float func_35533_c()
    {
        return field_35551_p;
    }

    public boolean func_35529_d()
    {
        return field_35544_o;
    }

    protected DamageSource(String s)
    {
        field_35543_n = false;
        field_35544_o = false;
        field_35551_p = 0.3F;
        field_35546_m = s;
    }

    public Entity func_35526_e()
    {
        return func_35532_a();
    }

    public Entity func_35532_a()
    {
        return null;
    }

    protected DamageSource func_35528_f()
    {
        field_35543_n = true;
        field_35551_p = 0.0F;
        return this;
    }

    protected DamageSource func_35531_g()
    {
        field_35544_o = true;
        return this;
    }

    protected DamageSource func_40546_j()
    {
        field_40549_q = true;
        return this;
    }

    public boolean func_40543_k()
    {
        return field_40549_q;
    }

    public String func_40545_l()
    {
        return field_35546_m;
    }

}

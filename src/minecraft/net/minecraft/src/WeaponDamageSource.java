package net.minecraft.src;

public class WeaponDamageSource  extends EntityDamageSourceIndirect
{

    private Entity damageSourceProjectile;
    private Entity damageSourceEntity;

    public WeaponDamageSource(String s, Entity entity, Entity entity1)
    {
        super(s, entity, entity1);
        damageSourceProjectile = entity;
        damageSourceEntity = entity1;
    }

    public Entity getProjectile()
    {
        return damageSourceProjectile;
    }

    public Entity getEntity()
    {
        return damageSourceEntity;
    }

    public static DamageSource causeWeaponDamage(Entity entity, Entity entity1)
    {
        return (new WeaponDamageSource("weapon", entity, entity1)).setProjectile();
    }
}

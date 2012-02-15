package net.minecraft.src;

public class ModelDummy extends ModelBase
{
    public ModelRenderer armLeft;
    public ModelRenderer armRight;
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer stick;
    public ModelRenderer inside;

    public ModelDummy()
    {
        armLeft = new ModelRenderer(this, 0, 24);
        armLeft.addBox(0.0F, 0.0F, 0.0F, 10, 4, 4);
        armLeft.setRotationPoint(6F, 18F, -2F);
        armRight = new ModelRenderer(this, 0, 24);
        armRight.addBox(-10F, 0.0F, 0.0F, 10, 4, 4);
        armRight.setRotationPoint(-6F, 18F, -2F);
        body = new ModelRenderer(this, 40, 0);
        body.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 3F);
        body.setRotationPoint(-3F, 11F, -3F);
        inside = new ModelRenderer(this, 40, 14);
        inside.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 2.0F);
        inside.setRotationPoint(-3F, 11F, -3F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-5F, 0.0F, -5F, 6, 6, 6, 2.0F);
        head.setRotationPoint(1.5F, 25F, 1.5F);
        stick = new ModelRenderer(this, 24, 0);
        stick.addBox(0.0F, 0.0F, 0.0F, 4, 10, 4);
        stick.setRotationPoint(-2F, 0.0F, -2F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        armLeft.render(f5);
        armRight.render(f5);
        body.render(f5);
        inside.render(f5);
        head.render(f5);
        stick.render(f5);
    }
}

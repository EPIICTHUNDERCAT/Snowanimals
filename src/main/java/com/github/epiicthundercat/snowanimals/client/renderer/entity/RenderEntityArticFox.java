package com.github.epiicthundercat.snowanimals.client.renderer.entity;

import com.github.epiicthundercat.snowanimals.Reference;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityArticFox;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEntityArticFox extends RenderLiving<EntityArticFox>
{
    private static final ResourceLocation WOLF_TEXTURES = new ResourceLocation(Reference.ID, "textures/entity/fox/artic_fox.png");
    private static final ResourceLocation TAMED_WOLF_TEXTURES = new ResourceLocation(Reference.ID, "textures/entity/fox/artic_fox.png");
    private static final ResourceLocation ANRGY_WOLF_TEXTURES = new ResourceLocation(Reference.ID, "textures/entity/fox/artic_fox.png");

    public RenderEntityArticFox(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn)
    {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
      //  this.addLayer(new LayerWolfCollar(this));
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    /*protected float handleRotationFloat(EntityArticFox livingBase, float partialTicks)
    {
        return livingBase.getTailRotation();
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityArticFox entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (entity.isFoxWet())
        {
            float f = entity.getBrightness(partialTicks) * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityArticFox entity)
    {
        return entity.isTamed() ? TAMED_WOLF_TEXTURES : (entity.isAngry() ? ANRGY_WOLF_TEXTURES : WOLF_TEXTURES);
    }
}

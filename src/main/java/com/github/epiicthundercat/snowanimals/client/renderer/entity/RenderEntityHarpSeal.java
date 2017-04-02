package com.github.epiicthundercat.snowanimals.client.renderer.entity;

import com.github.epiicthundercat.snowanimals.Reference;
import com.github.epiicthundercat.snowanimals.client.model.ModelHarpSeal;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityHarpSeal;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityHarpSeal extends RenderLiving<EntityHarpSeal> {
	private static final ResourceLocation HARP_SEAL_TEXTURE = new ResourceLocation(Reference.ID, "textures/entity/harp_seal.png");
	private static final ResourceLocation CHILDSEAL = new ResourceLocation(Reference.ID, "textures/entity/childharp_seal.png");
	
	public RenderEntityHarpSeal(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelHarpSeal(), 0.5F);
	}



	@Override
	public void doRender(EntityHarpSeal entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		ModelHarpSeal seal = new ModelHarpSeal();
		if (seal.isChild){
		this.bindTexture(CHILDSEAL);
		}
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		
	}
    /**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityHarpSeal entity) {
		return entity.isChild() ? CHILDSEAL : HARP_SEAL_TEXTURE;
	}
	
}
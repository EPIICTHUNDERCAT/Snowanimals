package com.github.epiicthundercat.snowanimals.client.model;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityHarpSeal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHarpSeal extends ModelBase {
	  public ModelRenderer SealBody;
	    public ModelRenderer SealHead;
	    public ModelRenderer Arm1;
	    public ModelRenderer Tail1;
	    public ModelRenderer Tail2;
	    public ModelRenderer TailEnd;
	    public ModelRenderer Arm2;

	    public ModelHarpSeal() {
	        this.textureWidth = 96;
	        this.textureHeight = 64;

	        this.SealBody = new ModelRenderer(this, 12, 22);
	        this.SealBody.setRotationPoint(0.0F, 0.0F, 0.0F);
	        this.SealBody.addBox(-6.0F, -4.0F, -1.0F, 11, 11, 31);
	        this.SealHead = new ModelRenderer(this, 11, 37);
	        this.SealHead.setRotationPoint(-1.0F, 3.0F, -1.3F);
	        this.SealHead.addBox(-4.0F, -6.0F, -4.8F, 9, 9, 7);
	        this.SealBody.addChild(this.SealHead);
	        this.Arm1 = new ModelRenderer(this, 0, 17);
	        this.Arm1.setRotationPoint(5.0F, 5.0F, 0.0F);
	        this.Arm1.addBox(-0.4F, -1.0F, -0.1F, 9, 3, 3);
	        this.setRotationAngles(this.Arm1, -0.08482300397719036F, -0.8066912015770679F, 0.0F);
	        this.SealBody.addChild(this.Arm1);
	        this.Tail1 = new ModelRenderer(this, 60, 4);
	        this.Tail1.setRotationPoint(-1.1F, 0.9F, 30.0F);
	        this.Tail1.addBox(-4.0F, -4.0F, -1.0F, 9, 9, 9);
	        this.SealBody.addChild(this.Tail1);
	        this.Tail2 = new ModelRenderer(this, 0, 23);
	        this.Tail2.setRotationPoint(1.0F, 1.0F, 8.0F);
	        this.Tail2.addBox(-4.0F, -4.0F, 0.0F, 7, 7, 7);
	        this.Tail1.addChild(this.Tail2);
	        this.TailEnd = new ModelRenderer(this, 0, 0);
	        this.TailEnd.setRotationPoint(0.0F, -0.8F, 6.0F);
	        this.TailEnd.addBox(-6.0F, -0.1F, 0.0F, 11, 0, 11);
	        this.Tail2.addChild(this.TailEnd);
	        this.Arm2 = new ModelRenderer(this, 0, 11);
	        this.Arm2.setRotationPoint(-4.5F, 6.0F, 1.0F);
	        this.Arm2.addBox(-0.4F, -2.0F, -1.1F, 9, 3, 3);
	        this.setRotationAngles(this.Arm2, 0.0F, -2.1650809903621875F, -0.04241150198859518F);
	        this.SealBody.addChild(this.Arm2);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    	 this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
    	 if (this.isChild)
         {
             float f = 2.0F;
             GlStateManager.pushMatrix();
             GlStateManager.translate(0.0F, 1.2, -1.0F);
             GlStateManager.scale(0.6F, 0.6F, 0.6F);
             this.SealBody.render(scale);
             GlStateManager.popMatrix();
            
         }
         else
         {
        	 GlStateManager.pushMatrix();
             GlStateManager.translate(0.0F, 1.0, -1.0F);
            
             this.SealBody.render(scale);
             GlStateManager.popMatrix();
         }
       
    }

    private void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
        
    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		EntityHarpSeal seal =(EntityHarpSeal) entityIn;
		this.SealHead.rotateAngleX = headPitch * 0.017453292F;
		this.SealHead.rotateAngleY = netHeadYaw * 0.017453292F;
		
		this.Arm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Arm2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.Arm1.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Arm2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		
		TailEnd.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		
		if (seal.isInWater())
		{	TailEnd.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		
		}
	}
}
package com.github.epiicthundercat.snowanimals.client.model;

import com.github.epiicthundercat.snowanimals.entity.passive.EntityArticOwl;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelArticOwl extends ModelBase {
	 public ModelRenderer OwlBody;
	    public ModelRenderer WingOne;
	    public ModelRenderer Wing2;
	    public ModelRenderer Feet1;
	    public ModelRenderer Feet1bot;
	    public ModelRenderer Feet2;
	    public ModelRenderer Feet2bot;
	    public ModelRenderer Head;
	    public ModelRenderer Beak;
	    public ModelRenderer Beak2;
	   // public ModelRenderer EyeColor1;
	    //public ModelRenderer EyeColor2;
	    
	    public ModelArticOwl() {
	        this.textureWidth = 64;
	        this.textureHeight = 32;

	        this.OwlBody = new ModelRenderer(this, 11, 12);
	        this.OwlBody.setRotationPoint(0.0F, 0.0F, 0.0F);
	        this.OwlBody.addBox(0.0F, 0.0F, 0.0F, 5, 8, 5);
	        this.WingOne = new ModelRenderer(this, 34, 11);
	        this.WingOne.setRotationPoint(0.2F, 0.3F, 1.3F);
	        this.WingOne.addBox(-0.8F, 0.0F, -0.9F, 1, 9, 4);
	        this.setRotationAngles(this.WingOne, 0.12740903872453743F, 0.0F, 0.21223203437934937F);
	        this.OwlBody.addChild(this.WingOne);
	        this.Wing2 = new ModelRenderer(this, 0, 10);
	        this.Wing2.setRotationPoint(4.8F, 0.3F, 1.3F);
	        this.Wing2.addBox(-0.3F, 0.0F, -0.8F, 1, 9, 4);
	        this.setRotationAngles(this.Wing2, 0.12740903872453743F, 0.0F, -0.21223203437934937F);
	        this.OwlBody.addChild(this.Wing2);
	        this.Feet1 = new ModelRenderer(this, 14, 25);
	        this.Feet1.setRotationPoint(3.0F, 8.0F, 2.0F);
	        this.Feet1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
	        this.OwlBody.addChild(this.Feet1);
	        this.Feet1bot = new ModelRenderer(this, 14, 29);
	        this.Feet1bot.setRotationPoint(0.0F, 1.2F, -0.9F);
	        this.Feet1bot.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
	        this.Feet1.addChild(this.Feet1bot);
	        this.Feet2 = new ModelRenderer(this, 26, 25);
	        this.Feet2.setRotationPoint(1.0F, 8.0F, 2.0F);
	        this.Feet2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
	        this.OwlBody.addChild(this.Feet2);
	        this.Feet2bot = new ModelRenderer(this, 25, 29);
	        this.Feet2bot.setRotationPoint(0.0F, 1.2F, -0.9F);
	        this.Feet2bot.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
	        this.Feet2.addChild(this.Feet2bot);
	        this.Head = new ModelRenderer(this, 14, 3);
	        this.Head.setRotationPoint(2.5F, 0.0F, 1.5F);
	        this.Head.addBox(-2.0F, -4.0F, -1.0F, 4, 4, 4);
	        this.OwlBody.addChild(this.Head);
	        this.Beak = new ModelRenderer(this, 19, 0);
	        this.Beak.setRotationPoint(-0.1F, -1.7F, -2.0F);
	        this.Beak.addBox(-0.4F, 0.0F, 0.0F, 1, 1, 1);
	        this.Beak.mirror = true;
	        this.setRotationAngles(this.Beak, 0.21223203437934937F, 0.0F, 0.0F);
	        this.Head.addChild(this.Beak);
	        this.Beak2 = new ModelRenderer(this, 19, 0);
	        this.Beak2.setRotationPoint(-0.2F, 0.6F, 0.1F);
	        this.Beak2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
	        this.Beak2.mirror = true;
	        this.setRotationAngles(this.Beak2, -0.5094616179782085F, 0.0F, 0.0F);
	        this.Beak.addChild(this.Beak2);
	      //  this.EyeColor1 = new ModelRenderer(this, 19, 0);
	        //this.EyeColor1.setRotationPoint(1.4F, -2.6F, -1.1F);
	        //this.EyeColor1.addBox(-0.6F, -0.5F, 0.0F, 1, 1, 1);
	        //this.EyeColor1.mirror = true;
	        //this.Head.addChild(this.EyeColor1);
	      //  this.EyeColor2 = new ModelRenderer(this, 19, 0);
	        //this.EyeColor2.setRotationPoint(-1.1F, -2.6F, -1.1F);
	        //this.EyeColor2.addBox(-1.6F, -0.5F, 0.0F, 1, 1, 1);
	        //this.EyeColor2.mirror = true;
	        //this.Head.addChild(this.EyeColor2);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw,
			float rotationPitch, float scale) {
		if (this.isChild) {
			float f = 2.0F;
			GlStateManager.pushMatrix();
			GlStateManager.translate(-0.1F, 1.5, -0.1F);
			GlStateManager.scale(0.6F, 0.6F, 0.6F);

			this.OwlBody.render(scale);
			GlStateManager.popMatrix();

		} else {
			GlStateManager.pushMatrix();
			GlStateManager.translate(-0.18F, 1.2, -0.3F);

			this.OwlBody.render(scale);
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
		
		
		
		this.Head.rotateAngleX = headPitch * 0.017453292F;
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;

		this.OwlBody.rotateAngleX = ((float) Math.PI / 2F);
		this.Feet1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Feet2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.WingOne.rotateAngleZ = ageInTicks;
		this.Wing2.rotateAngleZ = -ageInTicks;
	}

}
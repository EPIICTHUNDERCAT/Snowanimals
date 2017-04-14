package com.github.epiicthundercat.snowanimals.client.model;

import com.github.epiicthundercat.snowanimals.entity.passive.EntityArticFox;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ArticFox by EPIIC_THUNDERCAT
 */
@SideOnly(Side.CLIENT)
public class ModelArticFox extends ModelBase {
	 public ModelRenderer Body;
	    public ModelRenderer leg1;
	    public ModelRenderer leg2;
	    public ModelRenderer leg3;
	    public ModelRenderer leg4;
	    public ModelRenderer Head;
	    public ModelRenderer Snout;
	    public ModelRenderer nose;
	    public ModelRenderer Fluff;
	    public ModelRenderer tailFirst;
	    public ModelRenderer tailFluff;
	    public ModelRenderer tailEnd;

	    public ModelArticFox() {
	        this.textureWidth = 64;
	        this.textureHeight = 32;

	        this.Body = new ModelRenderer(this, 14, 12);
	        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
	        this.Body.addBox(-5.0F, -3.0F, -3.0F, 10, 6, 6);
	        this.leg1 = new ModelRenderer(this, 10, 25);
	        this.leg1.setRotationPoint(-3.4F, 3.0F, -2.7F);
	        this.leg1.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2);
	        this.Body.addChild(this.leg1);
	        this.leg2 = new ModelRenderer(this, 18, 25);
	        this.leg2.setRotationPoint(-3.4F, 3.0F, 0.7F);
	        this.leg2.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2);
	        this.Body.addChild(this.leg2);
	        this.leg3 = new ModelRenderer(this, 26, 25);
	        this.leg3.setRotationPoint(3.5F, 2.0F, -2.7F);
	        this.leg3.addBox(-1.0F, 1.0F, 0.0F, 2, 5, 2);
	        this.Body.addChild(this.leg3);
	        this.leg4 = new ModelRenderer(this, 34, 25);
	        this.leg4.setRotationPoint(3.5F, 3.0F, 0.7F);
	        this.leg4.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2);
	        this.Body.addChild(this.leg4);
	        this.Head = new ModelRenderer(this, 20, 0);
	        this.Head.setRotationPoint(5.0F, 0.0F, -1.0F);
	        this.Head.addBox(0.0F, -3.0F, -2.0F, 4, 6, 6);
	        this.Body.addChild(this.Head);
	        this.Snout = new ModelRenderer(this, 34, 0);
	        this.Snout.setRotationPoint(3.4F, 0.0F, -0.6F);
	        this.Snout.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
	        this.Head.addChild(this.Snout);
	        this.nose = new ModelRenderer(this, 41, 7);
	        this.nose.setRotationPoint(2.8F, 0.8F, 0.8F);
	        this.nose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
	        this.Snout.addChild(this.nose);
	        this.Fluff = new ModelRenderer(this, 40, 4);
	        this.Fluff.setRotationPoint(4.0F, -1.4F, -2.3F);
	        this.Fluff.addBox(-2.0F, -2.0F, -1.0F, 5, 7, 7);
	        this.Body.addChild(this.Fluff);
	        this.tailFirst = new ModelRenderer(this, 6, 7);
	        this.tailFirst.setRotationPoint(-4.3F, -1.0F, -1.0F);
	        this.tailFirst.addBox(-2.0F, -1.0F, 0.0F, 2, 2, 2);
	        this.setRotationAngles(this.tailFirst, 0.0F, 0.0F, -0.46705011182842415F);
	        this.Body.addChild(this.tailFirst);
	        this.tailFluff = new ModelRenderer(this, 5, 0);
	        this.tailFluff.setRotationPoint(-2.2F, 0.0F, 0.0F);
	        this.tailFluff.addBox(-6.6F, -1.4F, -0.5F, 7, 3, 3);
	        this.setRotationAngles(this.tailFluff, 0.0F, 0.0F, -0.33964105645913F);
	        this.tailFirst.addChild(this.tailFluff);
	        this.tailEnd = new ModelRenderer(this, 7, 13);
	        this.tailEnd.setRotationPoint(-6.8F, 0.1F, 0.0F);
	        this.tailEnd.addBox(-0.6F, -1.0F, 0.0F, 1, 2, 2);
	        this.tailFluff.addChild(this.tailEnd);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	 if (this.isChild)
         {
             float f12 = 2.0F;
             GlStateManager.pushMatrix();
             GlStateManager.translate(0.0F, 1.2, 0.0F);
             GlStateManager.scale(0.6F, 0.6F, 0.6F);
             this.Body.render(f5);
             GlStateManager.popMatrix();
            
         }
         else
         {
        	 GlStateManager.pushMatrix();
             GlStateManager.translate(0.0F, 1.0, 0.0F);
            
             this.Body.render(f5);
             GlStateManager.popMatrix();
         }
    }

    private void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    public void setlivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime)
    {
        EntityArticFox entity = (EntityArticFox)entitylivingbaseIn;

        if (entity.isAngry())
        {
            this.tailFirst.rotateAngleY = 0.0F;
        }
        else
        {
            this.tailFirst.rotateAngleY = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        }

        if (entity.isSitting())
        {
            this.Fluff.setRotationPoint(-1.0F, 16.0F, -3.0F);
            this.Fluff.rotateAngleX = ((float)Math.PI * 2F / 5F);
            this.Fluff.rotateAngleY = 0.0F;
            this.Body.setRotationPoint(0.0F, 18.0F, 0.0F);
            this.Body.rotateAngleX = ((float)Math.PI / 4F);
            this.tailFirst.setRotationPoint(-1.0F, 21.0F, 6.0F);
            this.leg1.setRotationPoint(-2.5F, 22.0F, 2.0F);
            this.leg1.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.leg2.setRotationPoint(0.5F, 22.0F, 2.0F);
            this.leg2.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.leg3.rotateAngleX = 5.811947F;
            this.leg3.setRotationPoint(-2.49F, 17.0F, -4.0F);
            this.leg4.rotateAngleX = 5.811947F;
            this.leg4.setRotationPoint(0.51F, 17.0F, -4.0F);
        }
        else
        {
            this.Body.setRotationPoint(0.0F, 14.0F, 2.0F);
            this.Body.rotateAngleX = ((float)Math.PI / 2F);
            this.Fluff.setRotationPoint(-1.0F, 14.0F, -3.0F);
            this.Fluff.rotateAngleX = this.Body.rotateAngleX;
            this.tailFirst.setRotationPoint(-1.0F, 12.0F, 8.0F);
            this.leg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
            this.leg2.setRotationPoint(0.5F, 16.0F, 7.0F);
            this.leg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
            this.leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
            this.leg1.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
            this.leg2.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_78086_3_;
            this.leg3.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_78086_3_;
            this.leg4.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        }

        this.Head.rotateAngleZ = entity.getInterestedAngle(partialTickTime) + entity.getShakeAngle(partialTickTime, 0.0F);
        this.Fluff.rotateAngleZ = entity.getShakeAngle(partialTickTime, -0.08F);
        this.Body.rotateAngleZ = entity.getShakeAngle(partialTickTime, -0.16F);
        this.tailFirst.rotateAngleZ = entity.getShakeAngle(partialTickTime, -0.2F);
    }
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3,
    		float f4, float f5, Entity entity) {
    	super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	EntityArticFox fox =(EntityArticFox) entity;
    	 this.Head.rotateAngleX = f4 * 0.017453292F;
         this.Head.rotateAngleY = f3 * 0.017453292F;
    	//howFar * f1 * cos(howFast * f + timingOffset)  + lean * f1"
    	
    //	f = entity.ticksExisted;
    	//f1 = 0.5f;
    	float globalSpeed = 1f;
    	float globalDegree =1;
    	float globalHeight = 1;
    	
    	
    	Body.rotateAngleY =  0.1f * f1 * MathHelper.cos(0.9f * f * 0.5f) + 0.5f * f1;
    	
    	leg1.rotateAngleZ = globalDegree * 0.9f * f1 * MathHelper.cos(globalSpeed * 0.9f * f * 0.5f) + 0.5f * f1;
    	leg2.rotateAngleZ = globalDegree * -0.9f * f1 * MathHelper.cos(globalSpeed * 0.9f * f * 0.5f) + 0.5f * f1;
    	leg3.rotateAngleZ = globalDegree * 0.9f * f1 * MathHelper.cos(globalSpeed * 0.9f * f * 0.5f) + 0.5f * f1;
    	leg4.rotateAngleZ = globalDegree * -0.9f * f1 * MathHelper.cos(globalSpeed * 0.9f * f * 0.5f) + 0.5f * f1;
        tailFirst.rotateAngleZ = globalDegree * 0.3f * f1 * MathHelper.cos(globalSpeed * 0.9f * f * -0.5f) + 0.1f * f1;
    	tailFluff.rotateAngleZ = globalDegree * -0.1f * f1 * MathHelper.sin(globalSpeed * 1.0f * f * 1.0f) + -1.0f * f1;
    	
    	
    	
    }
   
    
}

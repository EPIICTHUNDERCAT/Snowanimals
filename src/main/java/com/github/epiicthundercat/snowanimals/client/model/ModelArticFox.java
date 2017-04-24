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
	public ModelRenderer mainBody;
	public ModelRenderer head;
	public ModelRenderer tailFront;
	public ModelRenderer frontLeftThigh;
	public ModelRenderer frontRightThigh;
	public ModelRenderer backRightThigh;
	public ModelRenderer backLeftThigh;
	public ModelRenderer rightEar;
	public ModelRenderer leftEar;
	public ModelRenderer nose;
	public ModelRenderer tailEnd;
	public ModelRenderer frontLeftCalf;
	public ModelRenderer frontLeftFoot;
	public ModelRenderer frontRightCalf;
	public ModelRenderer frontRightFoot;
	public ModelRenderer backRightCalf;
	public ModelRenderer backRightFoot;
	public ModelRenderer backLeftCalf;
	public ModelRenderer backLeftFoot;

	public ModelArticFox() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.tailFront = new ModelRenderer(this, 0, 0);
		this.tailFront.setRotationPoint(0.0F, -1.0F, 10.4F);
		this.tailFront.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotationAngles(tailFront, 0.36425021489121656F, 0.0F, 0.0F);
		this.leftEar = new ModelRenderer(this, 57, 4);
		this.leftEar.setRotationPoint(-0.5F, -1.0F, -1.0F);
		this.leftEar.addBox(1.0F, -3.0F, 0.0F, 2, 3, 1, 0.0F);
		this.rightEar = new ModelRenderer(this, 53, 0);
		this.rightEar.setRotationPoint(-0.5F, -1.0F, -1.0F);
		this.rightEar.addBox(-2.0F, -3.0F, 0.0F, 2, 3, 1, 0.0F);
		this.frontRightCalf = new ModelRenderer(this, 54, 8);
		this.frontRightCalf.setRotationPoint(-1.0F, 2.4F, -0.1F);
		this.frontRightCalf.addBox(-1.0F, 0.5F, -0.9F, 2, 3, 2, 0.0F);
		this.frontRightThigh = new ModelRenderer(this, 37, 0);
		this.frontRightThigh.setRotationPoint(-0.4F, 0.7F, 1.1F);
		this.frontRightThigh.addBox(-2.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.tailEnd = new ModelRenderer(this, 46, 8);
		this.tailEnd.setRotationPoint(0.0F, 0.6F, 0.0F);
		this.tailEnd.addBox(-1.0F, 0.0F, -0.6F, 2, 6, 2, 0.0F);
		this.backRightFoot = new ModelRenderer(this, 50, 17);
		this.backRightFoot.setRotationPoint(0.0F, 3.5F, 0.5F);
		this.backRightFoot.addBox(-1.0F, -0.1F, -2.4F, 2, 1, 3, 0.0F);
		this.head = new ModelRenderer(this, 21, 0);
		this.head.setRotationPoint(0.0F, -2.0F, -2.0F);
		this.head.addBox(-2.5F, -2.0F, -3.0F, 5, 5, 3, 0.0F);
		this.frontLeftThigh = new ModelRenderer(this, 4, 0);
		this.frontLeftThigh.setRotationPoint(1.4F, 1.0F, 0.8F);
		this.frontLeftThigh.addBox(-1.1F, -1.3F, -0.8F, 2, 4, 2, 0.0F);
		this.backRightThigh = new ModelRenderer(this, 45, 0);
		this.backRightThigh.setRotationPoint(-0.4F, 1.7F, 8.0F);
		this.backRightThigh.addBox(-2.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
		this.frontLeftCalf = new ModelRenderer(this, 21, 8);
		this.frontLeftCalf.setRotationPoint(-0.1F, 2.2F, 0.1F);
		this.frontLeftCalf.addBox(-1.0F, 0.5F, -0.9F, 2, 3, 2, 0.0F);
		this.nose = new ModelRenderer(this, 0, 6);
		this.nose.setRotationPoint(0.1F, 1.2F, -1.5F);
		this.nose.addBox(-1.0F, -0.2F, -4.0F, 2, 2, 4, 0.0F);
		this.mainBody = new ModelRenderer(this, 0, 0);
		this.mainBody.setRotationPoint(0.0F, 16.3F, -6.0F);
		this.mainBody.addBox(-2.0F, -2.0F, -2.0F, 4, 5, 13, 0.0F);
		this.frontRightFoot = new ModelRenderer(this, 34, 14);
		this.frontRightFoot.setRotationPoint(0.0F, 3.5F, 0.5F);
		this.frontRightFoot.addBox(-1.0F, -0.1F, -2.4F, 2, 1, 3, 0.0F);
		this.backRightCalf = new ModelRenderer(this, 42, 16);
		this.backRightCalf.setRotationPoint(-1.0F, 1.5F, -0.1F);
		this.backRightCalf.addBox(-1.0F, 0.5F, -0.9F, 2, 3, 2, 0.0F);
		this.backLeftThigh = new ModelRenderer(this, 34, 6);
		this.backLeftThigh.setRotationPoint(0.4F, 1.7F, 8.0F);
		this.backLeftThigh.addBox(0.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
		this.backLeftCalf = new ModelRenderer(this, 0, 18);
		this.backLeftCalf.setRotationPoint(1.0F, 1.5F, -0.1F);
		this.backLeftCalf.addBox(-1.0F, 0.5F, -0.9F, 2, 3, 2, 0.0F);
		this.backLeftFoot = new ModelRenderer(this, 8, 18);
		this.backLeftFoot.setRotationPoint(0.0F, 3.5F, 0.6F);
		this.backLeftFoot.addBox(-1.0F, -0.1F, -2.5F, 2, 1, 3, 0.0F);
		this.frontLeftFoot = new ModelRenderer(this, 51, 13);
		this.frontLeftFoot.setRotationPoint(0.0F, 3.5F, 0.6F);
		this.frontLeftFoot.addBox(-1.0F, -0.1F, -2.5F, 2, 1, 3, 0.0F);
		this.mainBody.addChild(this.tailFront);
		this.head.addChild(this.leftEar);
		this.head.addChild(this.rightEar);
		this.frontRightThigh.addChild(this.frontRightCalf);
		this.mainBody.addChild(this.frontRightThigh);
		this.tailFront.addChild(this.tailEnd);
		this.backRightCalf.addChild(this.backRightFoot);
		this.mainBody.addChild(this.head);
		this.mainBody.addChild(this.frontLeftThigh);
		this.mainBody.addChild(this.backRightThigh);
		this.frontLeftThigh.addChild(this.frontLeftCalf);
		this.head.addChild(this.nose);
		this.frontRightCalf.addChild(this.frontRightFoot);
		this.backRightThigh.addChild(this.backRightCalf);
		this.mainBody.addChild(this.backLeftThigh);
		this.backLeftThigh.addChild(this.backLeftCalf);
		this.backLeftCalf.addChild(this.backLeftFoot);
		this.frontLeftCalf.addChild(this.frontLeftFoot);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		if (this.isChild) {
			float f12 = 2.0F;
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 1.2, 0.0F);
			GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.scale(0.6F, 0.6F, 0.6F);
			this.mainBody.render(f5);
			GlStateManager.popMatrix();

		} else {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 1.0, 0.0F);
			GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
			this.mainBody.render(f5);
			GlStateManager.popMatrix();
		}
	}

	private void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third
	 * float params here are the same second and third as in the
	 * setRotationAngles method.
	 */
	public void setlivingAnimations(EntityLivingBase entitylivingbaseIn, float f1, float f2, float partialTickTime) {

	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		EntityArticFox fox = (EntityArticFox) entity;
		this.head.rotateAngleX = f4 * 0.017453292F;
		this.head.rotateAngleY = f3 * 0.017453292F;
		// howFar * f1 * cos(howFast * f + timingOffset) + lean * f1"

		
		if (fox.isSitting()) {
			
			setRotationAngles(mainBody, -0.71f, 0f, 0.0F);
				setRotationAngles(frontLeftCalf, 10.49f, 0.0f, 0.0F);
				setRotationAngles(frontRightCalf, 0.49f, 0f, 0.0F);
				setRotationAngles(backLeftCalf, 0.35f, 0f, 0.0F);
				setRotationAngles(backRightCalf, 0.65f, 0f, 0.0F);

				setRotationAngles(frontLeftThigh, 0.2f, 0f, 0.0F);
				setRotationAngles(frontRightThigh, 0.2f, 0f, 0.0F);
				setRotationAngles(backLeftThigh, -0.20f, 0.0f, -0.97F);
				setRotationAngles(backRightThigh, -1.00f, 0.23f, 0.37F);
				setRotationAngles(tailFront, 2.8f, 0f, 0.0F);
				setRotationAngles(leftEar, 0.30f, 0.1f, 0.13F);
				setRotationAngles(rightEar, 0.30f, 0f, 0.0F);
				setRotationAngles(head, 0.780999f, 0f, 0.0F);

			} else {
				
				setRotationAngles(mainBody, 0f, 0f, 0.0F);
				setRotationAngles(frontLeftCalf, 0f, 0f, 0.0F);
				setRotationAngles(frontRightCalf, 0f, 0f, 0.0F);
				setRotationAngles(backLeftCalf, 0f, 0f, 0.0F);
				setRotationAngles(backRightCalf, 0f, 0f, 0.0F);

				setRotationAngles(backLeftThigh, 0f, 0f, 0.0F);
				setRotationAngles(backRightThigh, 0f, 0f, 0.0F);
				setRotationAngles(tailFront, 0f, 0f, 0.0F);
				setRotationAngles(leftEar, 0f, 0f, 0.0F);
				setRotationAngles(rightEar, 0f, 0f, 0.0F);
				setRotationAngles(head, 0f, 0f, 0.0F);

			}
			if (fox.isAngry()) {
				this.tailFront.rotateAngleZ = 1.0F;
			} else {
				this.tailFront.rotateAngleZ = 0;
			}

			if (fox.isWet()) {
				this.head.rotateAngleZ = fox.getInterestedAngle(f2) + fox.getShakeAngle(f2, 0.0F);
				// this.Fluff.rotateAngleZ = fox.getShakeAngle(f2, -0.08F);
				this.mainBody.rotateAngleZ = fox.getShakeAngle(f2, -0.16F);
				this.tailFront.rotateAngleZ = fox.getShakeAngle(f2, -0.2F);
			}
		
		
		
		// f = entity.ticksExisted;
		// f1 = 0.5f;
		float globalSpeed = 1f;
		float globalDegree = 0.5f;
		float globalHeight = 0.1f;

		bob(tailFront, 1F * globalSpeed, 2F * globalHeight, 1, 1, f, f1);
		bob(mainBody, 0.5F * globalSpeed, 2F * globalHeight, 1, 1, f, f1);
		walk(frontRightThigh, 0.2f * globalSpeed, 3.5f * globalDegree, false, 0f, 0.5f, f, f1);
		walk(frontLeftThigh, 0.2f * globalSpeed, -3.5f * globalDegree, true, 0.7f, -0.4f, f, f1);
		walk(backRightThigh, 0.2f * globalSpeed, -3.5f * globalDegree, true, 0.7f, -0.4f, f, f1);
		walk(backLeftThigh, 0.2f * globalSpeed, 3.5f * globalDegree, false, 0f, 0.5f, f, f1);

		walk(frontRightCalf, 0.2f * globalSpeed, 2.5f * globalDegree, false, -1.5f, 1f, f, f1);
		walk(frontLeftCalf, 0.2f * globalSpeed, 2.5f * globalDegree, false, -1.5f, 1.8f, f, f1);
		walk(backRightCalf, 0.2f * globalSpeed, 2.5f * globalDegree, false, -1.5f, 1.8f, f, f1);
		walk(backLeftCalf, 0.2f * globalSpeed, 2.5f * globalDegree, false, -1.5f, 1f, f, f1);

		walk(frontRightFoot, 0.2f * globalSpeed, 3f * globalDegree, false, -5.5f, 0.5f, f, f1);
		walk(frontLeftFoot, 0.2f * globalSpeed, 3f * globalDegree, false, -2f, 0.0f, f, f1);
		walk(backRightFoot, 0.2f * globalSpeed, 3f * globalDegree, false, -2f, 0.0f, f, f1);
		walk(backLeftFoot, 0.2f * globalSpeed, 3f * globalDegree, false, -5.5f, 0.5f, f, f1);

		flap(tailFront, 0.2f * globalSpeed, 2f * globalDegree, false, 0f, 0f, f, f1);

		walk(head, 0.2f * globalSpeed, 0.2f * globalDegree, true, -5.0f, 0.0f, f, f1);

		
		

	}

	public void swing(ModelRenderer box, float speed, float degree, float offset, float weight, float f, float f1) {
		box.rotateAngleY = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}

	public void flap(ModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f,
			float f1) {

		box.rotateAngleZ = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}

	public void bob(ModelRenderer box, float speed, float degree, float offset, float weight, float f, float f1) {
		box.rotationPointY = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}

	public void walk(ModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f,
			float f1) {

		box.rotateAngleX = degree * f1 * MathHelper.cos(speed * f + offset) + weight * f1;
	}

}

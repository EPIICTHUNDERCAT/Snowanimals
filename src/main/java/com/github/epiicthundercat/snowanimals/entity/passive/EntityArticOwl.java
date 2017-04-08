package com.github.epiicthundercat.snowanimals.entity.passive;

import java.util.Set;

import javax.annotation.Nullable;

import com.github.epiicthundercat.snowanimals.Reference;
import com.google.common.collect.Sets;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityArticOwl extends EntityAnimal {
	private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(new Item[] { Items.FISH, Items.COOKED_FISH });
	  private static final DataParameter<Byte> ONGROUND = EntityDataManager.<Byte>createKey(EntityArticOwl.class, DataSerializers.BYTE);
	    
	public static final ResourceLocation LOOT_ARTIC_OWL = new ResourceLocation(Reference.ID, "entities/artic_owl");
	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 0.5F;
	/** The time until the next egg is spawned. */
	public int timeUntilNextEgg;
	private BlockPos spawnPosition;

	public EntityArticOwl(World worldIn) {
		super(worldIn);
		this.setSize(0.4F, 0.7F);
		this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
		experienceValue = 10;
		this.setPathPriority(PathNodeType.WATER, 0.0F);

	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, TEMPTATION_ITEMS));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));

	}

	@Override
	protected void entityInit() {
		super.entityInit();
		 this.dataManager.register(ONGROUND, Byte.valueOf((byte)0));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	@Override
	public EntityArticOwl createChild(EntityAgeable ageable) {

		return new EntityArticOwl(this.worldObj);
	}

	public float getEyeHeight() {
		return this.height;
	}

	public boolean isBreedingItem(@Nullable ItemStack stack) {
		return stack != null && TEMPTATION_ITEMS.contains(stack.getItem());
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return LOOT_ARTIC_OWL;
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1 : 4) * 0.3D);
		this.destPos = MathHelper.clamp_float(this.destPos, 0.0F, 1.0F);

		if (!this.onGround && this.wingRotDelta < 1.0F) {
			this.wingRotDelta = 1.0F;
		}

		this.wingRotDelta = (float) ((double) this.wingRotDelta * 0.5D);

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.wingRotation += this.wingRotDelta * 2.0F;
		if (!this.worldObj.isRemote && !this.isChild()  && --this.timeUntilNextEgg <= 0)
        {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Items.EGG, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
	}

	public void fall(float distance, float damageMultiplier) {
	}

	/*
	 * protected SoundEvent getAmbientSound() { return
	 * SoundEvents.ENTITY_CHICKEN_AMBIENT; }
	 * 
	 * protected SoundEvent getHurtSound() { return
	 * SoundEvents.ENTITY_CHICKEN_HURT; }
	 * 
	 * protected SoundEvent getDeathSound() { return
	 * SoundEvents.ENTITY_CHICKEN_DEATH; }
	 * 
	 * protected void playStepSound(BlockPos pos, Block blockIn) {
	 * this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F); }
	 */
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		 this.dataManager.set(ONGROUND, Byte.valueOf(compound.getByte("BatFlags")));
		if (compound.hasKey("EggLayTime")) {
			this.timeUntilNextEgg = compound.getInteger("EggLayTime");
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		 compound.setByte("BatFlags", ((Byte)this.dataManager.get(ONGROUND)).byteValue());
		compound.setInteger("EggLayTime", this.timeUntilNextEgg);
	}

	public void onUpdate() {
		super.onUpdate();
		if (this.getIsOwlOnGround())
        {
            this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
            this.posY = (double)MathHelper.floor_double(this.posY) + 1.0D - (double)this.height;
        }
        else
        {
		this.motionY *= 0.6000000238418579D;
        }
	}
	public static void registerFixesOwl(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, "ArticOwl");
    }
	 @Nullable
	    protected SoundEvent getAmbientSound()
	    {
	        return this.getIsOwlOnGround() && this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_BAT_AMBIENT;
	    }
	protected void updateAITasks() {
		super.updateAITasks();
		BlockPos blockpos = new BlockPos(this);
		BlockPos blockpos1 = blockpos.down();
		if (this.getIsOwlOnGround())
        {
            if (this.worldObj.getBlockState(blockpos1).isNormalCube())
            {
                if (this.rand.nextInt(200) == 0)
                {
                    this.rotationYawHead = (float)this.rand.nextInt(360);
                }

                if (this.worldObj.getNearestPlayerNotCreative(this, 4.0D) != null)
                {
                    this.setIsOwlOnGround(false);
                    this.worldObj.playEvent((EntityPlayer)null, 1025, blockpos, 0);
                }
            }
            else
            {
                this.setIsOwlOnGround(false);
                this.worldObj.playEvent((EntityPlayer)null, 1025, blockpos, 0);
            }
        }
        else
        {
            if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1))
            {
                this.spawnPosition = null;
            }

            if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((double)((int)this.posX), (double)((int)this.posY), (double)((int)this.posZ)) < 4.0D)
            {
                this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }
		double d0 = (double) this.spawnPosition.getX() + 0.5D - this.posX;
		double d1 = (double) this.spawnPosition.getY() + 0.1D - this.posY;
		double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.posZ;
		this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
		this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
		this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
		float f = (float) (MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
		float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
		this.moveForward = 0.5F;
		this.rotationYaw += f1;
		  if (this.rand.nextInt(100) == 0 && this.worldObj.getBlockState(blockpos1).isNormalCube())
        {
            this.setIsOwlOnGround(true);
            this.wingRotation = 0;
            this.wingRotDelta = 0;
        }
		
	        }
	}

	
	
	
	
	
	
	
	
	 public boolean getIsOwlOnGround()
	    {
	        return (((Byte)this.dataManager.get(ONGROUND)).byteValue() & 1) != 0;
	    }

	    public void setIsOwlOnGround(boolean isOnGround)
	    {
	        byte b0 = ((Byte)this.dataManager.get(ONGROUND)).byteValue();

	        if (isOnGround)
	        {
	            this.dataManager.set(ONGROUND, Byte.valueOf((byte)(b0 | 1)));
	        }
	        else
	        {
	            this.dataManager.set(ONGROUND, Byte.valueOf((byte)(b0 & -2)));
	        }
	    }
	    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
	    {
	    }
	    public boolean attackEntityFrom(DamageSource source, float amount)
	    {
	        if (this.isEntityInvulnerable(source))
	        {
	            return false;
	        }
	        else
	        {
	            if (!this.worldObj.isRemote && this.getIsOwlOnGround())
	            {
	                this.setIsOwlOnGround(false);
	            }

	            return super.attackEntityFrom(source, amount);
	        }
	    }
}
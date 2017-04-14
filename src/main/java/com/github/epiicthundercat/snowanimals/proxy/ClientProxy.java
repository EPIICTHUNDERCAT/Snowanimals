package com.github.epiicthundercat.snowanimals.proxy;

import com.github.epiicthundercat.snowanimals.client.model.ModelArticFox;
import com.github.epiicthundercat.snowanimals.client.model.ModelArticOwl;
import com.github.epiicthundercat.snowanimals.client.renderer.entity.RenderEntityArticFox;
import com.github.epiicthundercat.snowanimals.client.renderer.entity.RenderEntityArticOwl;
import com.github.epiicthundercat.snowanimals.client.renderer.entity.RenderEntityHarpSeal;
import com.github.epiicthundercat.snowanimals.entity.ModEntities;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityArticFox;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityArticOwl;
import com.github.epiicthundercat.snowanimals.entity.passive.EntityHarpSeal;
import com.github.epiicthundercat.snowanimals.init.SItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	
	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);
		ModEntities.init();
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);

		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		rm.entityRenderMap.put(EntityHarpSeal.class, new RenderEntityHarpSeal(rm));
		rm.entityRenderMap.put(EntityArticOwl.class, new RenderEntityArticOwl(rm, new ModelArticOwl(), 0.4F));
		rm.entityRenderMap.put(EntityArticFox.class, new RenderEntityArticFox(rm, new ModelArticFox(), 0.4F));
		//rm.entityRenderMap.put(EntityHarpSeal.class, new RenderEntityHarpSeal(rm));

	}
	@Override
	public void registerRenders(FMLInitializationEvent event) {
		SItems.registerRender(event);
		// SBlocks.registerRender(event);
	}
	
	@Override
	public void registerEntities(FMLPreInitializationEvent preEvent) {
		super.registerEntities(preEvent);
	}
}

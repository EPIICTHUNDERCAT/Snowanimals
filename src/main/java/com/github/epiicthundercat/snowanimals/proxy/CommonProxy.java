package com.github.epiicthundercat.snowanimals.proxy;

import com.github.epiicthundercat.snowanimals.init.SItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		register(preEvent);
		//NGConfig.config(preEvent);

	}

	public void init(FMLInitializationEvent event) {
		registerRenders(event);
	//	SModEntities.init();
	
	}

	private void register(FMLPreInitializationEvent preEvent) {
		SItems.register(preEvent);
	//	SRecipes.register(preEvent);
		
		//SBlocks.register(preEvent);
		//MinecraftForge.EVENT_BUS.register(new SMobDrops());
		//MinecraftForge.EVENT_BUS.register(new SEventHandler());
		

	}

	public void registerRenders(FMLInitializationEvent event) {

	}

	public void registerRender(FMLInitializationEvent event) {
	}
	public void registerEntities(FMLPreInitializationEvent preEvent) {
		}

}

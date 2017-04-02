package com.github.epiicthundercat.snowanimals;

import com.github.epiicthundercat.snowanimals.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VER)
public class Snowanimals {
	@Instance(value = Reference.ID)
	public static Snowanimals instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	//public static Configuration config;

	@EventHandler
	private void preInit(FMLPreInitializationEvent preEvent) {
		proxy.preInit(preEvent);
	}

	@EventHandler
	private void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

}

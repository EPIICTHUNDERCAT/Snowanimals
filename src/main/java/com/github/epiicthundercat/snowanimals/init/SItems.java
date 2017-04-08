package com.github.epiicthundercat.snowanimals.init;

import java.util.ArrayList;
import java.util.List;

import com.github.epiicthundercat.snowanimals.item.SItem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SItems {
	public static List<Item> items = new ArrayList();
	
	public static Item owl_egg = new SItem("owl_egg");
	
	
	
	private static List<Item> getItems() {
		return items;
	}
	
	public static void register(FMLPreInitializationEvent preEvent) {
		for (Item item : getItems()) {
			GameRegistry.register(item);
		}
	}

	public static void registerRender(FMLInitializationEvent event) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		for (Item item : getItems()) {
			renderItem.getItemModelMesher().register(item, 0,
					new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		}
	}
}

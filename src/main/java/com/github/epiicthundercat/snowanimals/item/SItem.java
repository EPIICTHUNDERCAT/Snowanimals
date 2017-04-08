package com.github.epiicthundercat.snowanimals.item;

import com.github.epiicthundercat.snowanimals.creativetab.SCreativeTab;
import com.github.epiicthundercat.snowanimals.init.SItems;

import net.minecraft.item.Item;

public class SItem extends Item{
	
	
	public SItem(String name) {
		
		setRegistryName(name.toLowerCase());
		setUnlocalizedName(name.toLowerCase());
		setCreativeTab(SCreativeTab.STabs);
		addToItems(this);
	}

	private void addToItems(Item item) {

		SItems.items.add(item);

	}

}
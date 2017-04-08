package com.github.epiicthundercat.snowanimals.creativetab;

import com.github.epiicthundercat.snowanimals.init.SItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SCreativeTab extends CreativeTabs{
	public SCreativeTab(int index, String label) {
		super(index, label);
	}

	public static final SCreativeTab STabs = new SCreativeTab(CreativeTabs.getNextID(), "stabs") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SItems.owl_egg;
		}
	};
	
	@Override
	public Item getTabIconItem() {
		return null;
	}
}

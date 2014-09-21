package com.gjkf.fc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs{

	public CreativeTab(int pos, String name) {
		super(pos, name);
	}

	@Override
	public Item getTabIconItem(){
		return null;
	}

}
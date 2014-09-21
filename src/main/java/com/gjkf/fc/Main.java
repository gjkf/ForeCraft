/*
 * Copyright (c) 2014 Davide Cossu.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses>.
 */

package com.gjkf.fc;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.gjkf.fc.blocks.BaseCore;
import com.gjkf.fc.handler.ConfigurationHandler;
import com.gjkf.fc.items.ItemCard;
import com.gjkf.fc.proxy.CommonProxy;
import com.gjkf.fc.references.References;
import com.gjkf.lib.helper.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.MOD_NAME,version = References.VERSION, guiFactory = References.GUI_FACTORY_CLASS, dependencies = References.DEPENDENCIES)
public class Main{

	@Instance(References.MODID)
	public static Main instance;
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static LogHelper log = new LogHelper(References.MODID);
	
	public static CreativeTabs tab = new CreativeTab(CreativeTab.getNextID(), "foreCraftTab");
	
	public static Block baseCore = new BaseCore().setBlockName("baseCore").setCreativeTab(tab);
	
	public static Item itemCard = new ItemCard().setUnlocalizedName("itemCard").setCreativeTab(tab);
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ConfigurationHandler.register();
		
		GameRegistry.registerBlock(baseCore, baseCore.getUnlocalizedName());
		
		GameRegistry.registerItem(itemCard, itemCard.getUnlocalizedName());
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		
	}
}
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
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;

import com.gjkf.fc.blocks.BaseCore;
import com.gjkf.fc.blocks.Station;
import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.fc.handler.BiomesHandler;
import com.gjkf.fc.handler.ConfigurationHandler;
import com.gjkf.fc.handler.GuiHandler;
import com.gjkf.fc.items.ItemCard;
import com.gjkf.fc.proxy.CommonProxy;
import com.gjkf.fc.references.References;
import com.gjkf.fc.weather.Pressure;
import com.gjkf.lib.helper.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
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
	
	public static Block station = new Station().setBlockName("station").setCreativeTab(tab);
	
	public static Item itemCard = new ItemCard().setUnlocalizedName("itemCard").setCreativeTab(tab);
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		BiomesHandler.putAllBiomes();
		
		/*
		biomesMap.put(BiomeGenBase.beach, 303.5);
		biomesMap.put(BiomeGenBase.birchForest, 298.15);
		biomesMap.put(BiomeGenBase.birchForestHills, 298.15);
		biomesMap.put(BiomeGenBase.coldBeach, 278.15);
		biomesMap.put(BiomeGenBase.coldTaiga, 278.15);
		biomesMap.put(BiomeGenBase.coldTaigaHills, 278.15);
		biomesMap.put(BiomeGenBase.deepOcean, 298.15);
		biomesMap.put(BiomeGenBase.desert, 313.15);
		biomesMap.put(BiomeGenBase.desertHills, 313.15);
		biomesMap.put(BiomeGenBase.extremeHills, 278.15);
		biomesMap.put(BiomeGenBase.forest, 298.15);
		biomesMap.put(BiomeGenBase.extremeHillsEdge, 278.15);
		biomesMap.put(BiomeGenBase.extremeHillsPlus, 278.15);
		biomesMap.put(BiomeGenBase.forestHills, 298.15);
		biomesMap.put(BiomeGenBase.frozenOcean, 273.15);
		biomesMap.put(BiomeGenBase.frozenRiver, 273.15);
		biomesMap.put(BiomeGenBase.iceMountains, 273.15);
		biomesMap.put(BiomeGenBase.hell, 673.15);
		biomesMap.put(BiomeGenBase.icePlains, 273.15);
		biomesMap.put(BiomeGenBase.jungle, 303.15);
		biomesMap.put(BiomeGenBase.jungleEdge, 303.15);
		biomesMap.put(BiomeGenBase.jungleHills, 303.15);
		biomesMap.put(BiomeGenBase.megaTaiga, 283.15);
		biomesMap.put(BiomeGenBase.mesa, 298.15);
		biomesMap.put(BiomeGenBase.mesaPlateau, 298.15);
		biomesMap.put(BiomeGenBase.mesaPlateau_F, 298.15);
		biomesMap.put(BiomeGenBase.mushroomIsland, 298.15);
		biomesMap.put(BiomeGenBase.mushroomIslandShore, 298.15);
		biomesMap.put(BiomeGenBase.ocean, 298.15);
		biomesMap.put(BiomeGenBase.river, 298.15);
		biomesMap.put(BiomeGenBase.roofedForest, 298.15);
		biomesMap.put(BiomeGenBase.savanna, 303.15);
		biomesMap.put(BiomeGenBase.savannaPlateau, 303.15);
		biomesMap.put(BiomeGenBase.sky, 243.15);
		biomesMap.put(BiomeGenBase.stoneBeach, 303.5);
		biomesMap.put(BiomeGenBase.swampland, 303.15);
		biomesMap.put(BiomeGenBase.taiga, 283.15);
		biomesMap.put(BiomeGenBase.taigaHills, 283.15);

		 */
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ConfigurationHandler.register();
		
		GameRegistry.registerBlock(baseCore, baseCore.getUnlocalizedName());
		GameRegistry.registerBlock(station, station.getUnlocalizedName());
		
		GameRegistry.registerItem(itemCard, itemCard.getUnlocalizedName());

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		proxy.registerTE();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		
	}
}
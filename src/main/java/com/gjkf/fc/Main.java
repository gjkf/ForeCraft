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

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

import com.gjkf.fc.blocks.BaseCore;
import com.gjkf.fc.blocks.Station;
import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.fc.handler.ConfigurationHandler;
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
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.MOD_NAME,version = References.VERSION, guiFactory = References.GUI_FACTORY_CLASS, dependencies = References.DEPENDENCIES)
public class Main{

	@Instance(References.MODID)
	public static Main instance;
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public Map<BiomeGenBase, Pressure> biomesMap;
	
	public static LogHelper log = new LogHelper(References.MODID);
	
	public static CreativeTabs tab = new CreativeTab(CreativeTab.getNextID(), "foreCraftTab");
	
	public static Block baseCore = new BaseCore().setBlockName("baseCore").setCreativeTab(tab);
	
	public static Block station = new Station().setBlockName("station").setCreativeTab(tab);
	
	public static Item itemCard = new ItemCard().setUnlocalizedName("itemCard").setCreativeTab(tab);
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ConfigurationHandler.register();
		
		GameRegistry.registerBlock(baseCore, baseCore.getUnlocalizedName());
		GameRegistry.registerBlock(station, station.getUnlocalizedName());
		
		GameRegistry.registerItem(itemCard, itemCard.getUnlocalizedName());

		biomesMap.put(BiomeGenBase.beach, new Pressure());
		biomesMap.put(BiomeGenPlains.birchForest, new Pressure());
		biomesMap.put(BiomeGenBase.birchForestHills, new Pressure());
		biomesMap.put(BiomeGenBase.coldBeach, new Pressure());
		biomesMap.put(BiomeGenBase.coldTaiga, new Pressure());
		biomesMap.put(BiomeGenBase.coldTaigaHills, new Pressure());
		biomesMap.put(BiomeGenBase.deepOcean, new Pressure());
		biomesMap.put(BiomeGenBase.desert, new Pressure());
		biomesMap.put(BiomeGenBase.desertHills, new Pressure());
		biomesMap.put(BiomeGenBase.extremeHills, new Pressure());
		biomesMap.put(BiomeGenBase.forest, new Pressure());
		biomesMap.put(BiomeGenBase.extremeHillsEdge, new Pressure());
		biomesMap.put(BiomeGenBase.extremeHillsPlus, new Pressure());
		biomesMap.put(BiomeGenBase.forestHills, new Pressure());
		biomesMap.put(BiomeGenBase.frozenOcean, new Pressure());
		biomesMap.put(BiomeGenBase.frozenRiver, new Pressure());
		biomesMap.put(BiomeGenBase.iceMountains, new Pressure());
		biomesMap.put(BiomeGenBase.hell, new Pressure());
		biomesMap.put(BiomeGenBase.icePlains, new Pressure());
		biomesMap.put(BiomeGenBase.jungle, new Pressure());
		biomesMap.put(BiomeGenBase.jungleEdge, new Pressure());
		biomesMap.put(BiomeGenBase.jungleHills, new Pressure());
		biomesMap.put(BiomeGenBase.megaTaiga, new Pressure());
		biomesMap.put(BiomeGenBase.mesa, new Pressure());
		biomesMap.put(BiomeGenBase.mesaPlateau, new Pressure());
		biomesMap.put(BiomeGenBase.mesaPlateau_F, new Pressure());
		biomesMap.put(BiomeGenBase.mushroomIsland, new Pressure());
		biomesMap.put(BiomeGenBase.mushroomIslandShore, new Pressure());
		biomesMap.put(BiomeGenBase.ocean, new Pressure());
		biomesMap.put(BiomeGenBase.river, new Pressure());
		biomesMap.put(BiomeGenBase.roofedForest, new Pressure());
		biomesMap.put(BiomeGenBase.savanna, new Pressure());
		biomesMap.put(BiomeGenBase.savannaPlateau, new Pressure());
		biomesMap.put(BiomeGenBase.sky, new Pressure());
		biomesMap.put(BiomeGenBase.stoneBeach, new Pressure());
		biomesMap.put(BiomeGenBase.swampland, new Pressure());
		biomesMap.put(BiomeGenBase.taiga, new Pressure());
		biomesMap.put(BiomeGenBase.taigaHills, new Pressure());
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		proxy.registerTE();
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		
	}
}
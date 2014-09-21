package com.gjkf.fc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.gjkf.fc.handler.ConfigurationHandler;
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

@Mod(modid = References.MODID, name = References.MOD_NAME,version = References.VERSION, guiFactory = References.GUI_FACTORY_CLASS, dependencies = References.DEPENDENCIES)
public class Main{

	@Instance(References.MODID)
	public static Main instance;
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static LogHelper log = new LogHelper(References.MODID);
	
	public static CreativeTabs tab = new CreativeTab(CreativeTab.getNextID(), "foreCraftTab");
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ConfigurationHandler.register();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		
	}
}
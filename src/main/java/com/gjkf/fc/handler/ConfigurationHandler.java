package com.gjkf.fc.handler;

import java.io.File;

import com.gjkf.fc.references.References;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler{

	public static Configuration config;
	
	public static boolean realWeather = false;
	
	public static void init(File configFile){

		if(config == null){
			config = new Configuration(configFile);
			loadConfigurations();
		}

	}
	
	private static void loadConfigurations(){
		realWeather = config.getBoolean("realWeather", Configuration.CATEGORY_GENERAL, false, "Do you want the weather to be like the place where you play in?");
	}

	public static void register(){
		
	}

	@SubscribeEvent
	public void onConfigrationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

		if(event.modID.equalsIgnoreCase(References.MODID)){
			loadConfigurations();
		}

	}
	
}
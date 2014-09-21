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
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

package com.gjkf.fc.weather;

import com.gjkf.fc.Main;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.WorldInfo;

public class Rain{

	private static double probability;
	
	public static void setProbableRain(double humidity, double pressure){
		WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
		
		/*
		 * If probability is less than 1100 or more than 1500 then make rain.
		 */
		
		setProbability(humidity, pressure);
		
		if(pressure <= 980 || pressure >= 1000){
	        worldinfo.setRaining(true);
		}else if(getProbability() <= 850){
			worldinfo.setThundering(true);
		}
		
		if(pressure >= 1001 && (worldinfo.isRaining() || worldinfo.isThundering())){
			worldinfo.setRaining(false);
			worldinfo.setThundering(false);
		}
		
		Main.log.info("Rain Probability: " + getProbability());
		
	}
	
	public static void setProbability(double humidity, double pressure){
		probability = pressure / (humidity/100);
	}
	
	public static double getProbability(){
		return probability;
	}
	
}
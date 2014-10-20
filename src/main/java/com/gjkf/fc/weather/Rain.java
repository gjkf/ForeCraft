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

import java.util.Random;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.WorldInfo;

import com.gjkf.fc.Main;

public class Rain{

	private static double probability;

	public static void setProbableRain(double humidity, double pressure){
		WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();

		setProbability(humidity, pressure);

		/*
		 * If pressure is less than 1100 or more than 1500 then make rain.
		 */

		if(getProbability() <= 1115){
			worldinfo.setRaining(true);
		}else if(getProbability() <= 850){
			worldinfo.setThundering(true);
		}else if(getProbability() >= 2050 && (worldinfo.isRaining() || worldinfo.isThundering())){
			worldinfo.setRaining(false);
			worldinfo.setThundering(false);
		}else{
			int rnd = new Random().nextInt(100);
			if(rnd % 2 == 0){
				worldinfo.setRaining(true);
			}
		}

	}

	public static void setProbability(double humidity, double pressure){
		probability = pressure / (humidity/100);
	}

	public static double getProbability(){
		return probability;
	}

}
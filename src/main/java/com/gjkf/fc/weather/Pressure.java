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

import com.gjkf.fc.handler.BiomesHandler;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class Pressure{

	public double pressure;
	
	public static double constant = 9.81 * 0.03 / 8.31 / 0.0065; // 5.45
	
	public Pressure(){
		
	}
	
	public double getPressure(){
		return pressure;
	}
	
	/*
	 * Sets the Pressure based on Temperature of the given biome
	 * @param Tile Entity
	 * @param biome 
	 */
	
	public void setPressure(TileEntity te, BiomeGenBase biome){
		if(BiomesHandler.vanillaBiomes.get(biome) == null){
			pressure = (101325 * Math.pow((1 + (-0.0065 / (BiomesHandler.biomesMap.get(BiomeDictionary.getTypesForBiome(biome))) * ((te.yCoord - 64)))), constant)) * Math.pow(10, -2);
		}else{
			pressure = (101325 * Math.pow((1 + (-0.0065 / (BiomesHandler.vanillaBiomes.get(biome)) * ((te.yCoord - 64)))), constant)) * Math.pow(10, -2);
		}
		// This gives the pressure a range of 200
		pressure = Math.random() * 201 + (pressure - 100);
	}
	
}
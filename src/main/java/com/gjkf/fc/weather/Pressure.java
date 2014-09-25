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

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;

public class Pressure{

	public double pressure;
	
	public static double constant = 9.81 * 0.03 / 8.31 / 0.0065; // 5.45
	
	public Pressure(){
		
	}
	
	public double getPressure(){
		return pressure;
	}
	
	public void setPressure(double temperature, TileEntity te, BiomeGenBase biome){
		pressure = (101325 * Math.pow((1 + (-0.0065 / (Main.biomesMap.get(biome)) * ((te.yCoord - 64)))), constant)) * Math.pow(10, -2);
		
		pressure = Math.random() * 201 + (pressure - 100);
	}
	
}
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

package com.gjkf.fc.blocks.te;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.gjkf.lib.helper.NBTHelper;

public class BaseCoreTE extends TileEntity{

	private int xCoord, yCoord, zCoord;
	private double humidity, temperature, pressure;
	private StationTE station;

	public BaseCoreTE(){
	}
	
	public void registerCoords(ItemStack card){
		if(card != null){
			xCoord = NBTHelper.getInt(card, "xCoord");
			yCoord = NBTHelper.getInt(card, "yCoord");
			zCoord = NBTHelper.getInt(card, "zCoord");
		}
	}
	
	public double getTemperature(){
		station = (StationTE) this.getWorldObj().getTileEntity(xCoord, yCoord, zCoord);
		return station.getTemperature();
	}
	
	public double getPressure(){
		station = (StationTE) this.getWorldObj().getTileEntity(xCoord, yCoord, zCoord);
		return station.getPressure();
	}
	
	public double getHumidity(){
		station = (StationTE) this.getWorldObj().getTileEntity(xCoord, yCoord, zCoord);
		return station.getHumidity();
	}
	
}
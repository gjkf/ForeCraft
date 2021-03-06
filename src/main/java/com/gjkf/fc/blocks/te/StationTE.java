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

import com.gjkf.fc.Main;
import com.gjkf.fc.blocks.Station;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class StationTE extends TileEntity implements IInventory{

	public static double temperature;
	public static double humidity;
	public static double pressure;
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		
		this.temperature = tag.getDouble("Temperature");
		this.humidity = tag.getDouble("Humidity");
		this.pressure = tag.getDouble("Pressure");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		
		tag.setDouble("Temperature", Station.temperature);
		tag.setDouble("Humidity", Station.humidity);
		tag.setDouble("Pressure", Station.pressure);
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int slot){
		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int ammount){
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot){
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack){	
	}

	@Override
	public String getInventoryName(){
		return null;
	}

	@Override
	public boolean hasCustomInventoryName(){
		return false;
	}

	@Override
	public int getInventoryStackLimit(){
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player){
		return false;
	}

	@Override
	public void openInventory(){
	}

	@Override
	public void closeInventory(){
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack){
		return false;
	}
	
	public static double getTemperature(){
		return temperature;
	}
	
	public static double getPressure(){
		return pressure;
	}

	public static double getHumidity(){
		return humidity;
	}
	
}
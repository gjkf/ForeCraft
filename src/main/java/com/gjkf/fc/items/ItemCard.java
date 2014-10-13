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

package com.gjkf.fc.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.world.World;

import com.gjkf.fc.Main;
import com.gjkf.fc.blocks.te.StationTE;
import com.gjkf.lib.helper.NBTHelper;

public class ItemCard extends Item{

	public ItemCard(){

	}
	
	/*
	 * This ensures that the compund won't be null
	 */
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player){
		if(itemStack.stackTagCompound == null){
			itemStack.setTagCompound(new NBTTagCompound());
		}
	}
	
	/*
	 * This will take the coords of the StationTE
	 */
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		
		if(world.getTileEntity(x, y, z) instanceof StationTE){
			
			StationTE station = (StationTE) world.getTileEntity(x, y, z);
			
			NBTHelper.setInteger(itemStack, "XCoord", x);
			NBTHelper.setInteger(itemStack, "YCoord", y);
			NBTHelper.setInteger(itemStack, "ZCoord", z);
			
			NBTHelper.setDouble(itemStack, "Temperature", station.getTemperature());
			NBTHelper.setDouble(itemStack, "Humidity", station.getHumidity());
			NBTHelper.setDouble(itemStack, "Pressure", station.getPressure());
			
			return true;
		}
		
		return false;
	}
	
	/*
	 * This will create the tooltip
	 */
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		list.add("X: " + NBTHelper.getInt(stack, "XCoord"));
		list.add("Y: " + NBTHelper.getInt(stack, "YCoord"));
		list.add("Z: " + NBTHelper.getInt(stack, "ZCoord"));
	
		list.add(String.format("Temp: %.2f", NBTHelper.getDouble(stack, "Temperature")));
		list.add(String.format("Hum: %.2f", NBTHelper.getDouble(stack, "Humidity")));
		list.add(String.format("Press: %.2f", NBTHelper.getDouble(stack, "Pressure")));
	}
	
}
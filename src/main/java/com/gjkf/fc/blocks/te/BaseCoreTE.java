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

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.gjkf.fc.items.ItemCard;
import com.gjkf.lib.helper.NBTHelper;

public class BaseCoreTE extends TileEntity implements IInventory{

	public ItemStack[] stackInSlot; 

	public static final int INVENTORY_SIZE = 1;
	public static final int INVENTORY_INDEX = 0;

	private int xCoord, yCoord, zCoord;
	public double humidity;
	public double temperature;
	public double pressure;

	public BaseCoreTE(){
		stackInSlot = new ItemStack[INVENTORY_SIZE];
	}

	@Override
	public void readFromNBT(NBTTagCompound tag){

		super.readFromNBT(tag);

		// Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = tag.getTagList("Items", 10);
        stackInSlot = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i){
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < stackInSlot.length){
                stackInSlot[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }

		this.xCoord = tag.getInteger("xCoord");
		this.yCoord = tag.getInteger("yCoord");
		this.zCoord = tag.getInteger("zCoord");
		this.temperature = tag.getDouble("Temperature");
		this.humidity = tag.getDouble("Humidity");
		this.pressure = tag.getDouble("Pressure");

	}

	@Override
	public void writeToNBT(NBTTagCompound tag){

		super.writeToNBT(tag);

		if(getStackInSlot(0) != null && getStackInSlot(0) == new ItemStack(new ItemCard())){

			ItemStack card = getStackInSlot(0);

			// Write the ItemStacks in the inventory to NBT
	        NBTTagList tagList = new NBTTagList();
	        for (int currentIndex = 0; currentIndex < stackInSlot.length; ++currentIndex){
	            if (stackInSlot[currentIndex] != null){
	                NBTTagCompound tagCompound = new NBTTagCompound();
	                tagCompound.setByte("Slot", (byte) currentIndex);
	                stackInSlot[currentIndex].writeToNBT(tagCompound);
	                tagList.appendTag(tagCompound);
	            }
	        }
	        
	        tag.setTag("Items", tagList);

			tag.setInteger("xCoord", NBTHelper.getInt(card, "xCoord"));
			tag.setInteger("yCoord", NBTHelper.getInt(card, "yCoord"));
			tag.setInteger("zCoord", NBTHelper.getInt(card, "zCoord"));

			tag.setDouble("temperature", NBTHelper.getDouble(card, "Temperature"));
			tag.setDouble("humidity", NBTHelper.getDouble(card, "Humidity"));
			tag.setDouble("pressure", NBTHelper.getDouble(card, "Pressure"));

		}

	}

	@Override
	public int getSizeInventory(){
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slot){
		return this.stackInSlot[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int ammount){
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null){
			if (itemStack.stackSize <= ammount){
				setInventorySlotContents(slot, null);
			}else{
				itemStack = itemStack.splitStack(ammount);
				if (itemStack.stackSize == 0){
					setInventorySlotContents(slot, null);
				}
			}
		}

		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot){
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null){
			setInventorySlotContents(slot, null);
		}
		return itemStack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack){
		stackInSlot[slot] = stack;
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
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player){
		return true;
	}

	@Override
	public void openInventory(){

	}

	@Override
	public void closeInventory(){

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack){
		return stack.getItem() instanceof ItemCard;
	}

}
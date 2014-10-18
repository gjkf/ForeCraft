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
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.gjkf.fc.items.ItemCard;

public class BaseCoreTE extends TileEntity implements IInventory{
	
	public ItemStack[] stackInSlot; 
	
	public static final int INVENTORY_SIZE = 1;
    public static final int INVENTORY_INDEX = 0;
	
    public BaseCoreTE(){
    	stackInSlot = new ItemStack[INVENTORY_SIZE];
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
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot){
		return null;
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
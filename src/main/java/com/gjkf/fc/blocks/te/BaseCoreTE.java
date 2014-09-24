package com.gjkf.fc.blocks.te;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class BaseCoreTE extends TileEntity implements IInventory{
	
	public ItemStack[] stackInSlot = new ItemStack[1]; 
	
	@Override
	public int getSizeInventory(){
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slot){
		return stackInSlot[slot];
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
		return 1;
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

}
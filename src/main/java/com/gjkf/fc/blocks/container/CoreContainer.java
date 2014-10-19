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

package com.gjkf.fc.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.gjkf.fc.blocks.te.BaseCoreTE;

public class CoreContainer extends Container{

	private BaseCoreTE te;
	
	public CoreContainer(InventoryPlayer playerInv, BaseCoreTE te){
		this.te = te;

		this.addSlotToContainer(new Slot(te, BaseCoreTE.INVENTORY_INDEX, -187, 88));
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}

}
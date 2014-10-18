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

package com.gjkf.fc.handler;

import com.gjkf.fc.blocks.container.CoreContainer;
import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.fc.client.gui.inventory.CoreGui;
import com.gjkf.fc.references.References;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		
		if(ID == References.GUI_CORE_ID){
			BaseCoreTE baseCoreTe = (BaseCoreTE) world.getTileEntity(x, y, z);
			return new CoreContainer(player.inventory, baseCoreTe);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		
		if(ID == References.GUI_CORE_ID){
			BaseCoreTE baseCoreTe = (BaseCoreTE) world.getTileEntity(x, y, z);
			return new CoreGui(player.inventory, baseCoreTe);
		}
		
		return null;
	}

}
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

package com.gjkf.fc.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.gjkf.fc.blocks.container.CoreContainer;
import com.gjkf.fc.blocks.te.BaseCoreTE;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CoreGui extends GuiContainer{

	/*
	 * TODO: Create a custom container class in the library, it will be quite hard but hopefully fun
	 */

	private BaseCoreTE tileEntity;
	
	public CoreGui(InventoryPlayer inventoryPlayer, BaseCoreTE tileEntity){
		super(new CoreContainer(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;
	}

	
	@Override
	public void drawGuiContainerBackgroundLayer(float f, int x, int y){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("/textures/gui/inventory.png"));
		this.drawTexturedModalRect(50, 0, 0, 0, this.xSize, this.ySize);
	}

	
	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}

}
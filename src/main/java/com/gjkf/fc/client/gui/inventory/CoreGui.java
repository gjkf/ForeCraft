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
import com.gjkf.lib.gui.GuiContainerScreen;
import com.gjkf.lib.gui.GuiDraw;
import com.gjkf.lib.gui.GuiGJButton;
import com.gjkf.lib.helper.NBTHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CoreGui extends GuiContainerScreen{

	private BaseCoreTE tileEntity;

	private double temp;
	private double hum;
	private double press;

	public CoreGui(InventoryPlayer inventoryPlayer, BaseCoreTE tileEntity){
		super(new CoreContainer(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;

		if(tileEntity.getStackInSlot(0) != null){
			this.temp = NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Temperature");
			this.hum = NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Humidity");
			this.press = NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Pressure");
		}
	}

	@Override
	public void addWidgets(){
		add(new GuiGJButton(-110, -140, 30, 20, "C/F").setActionCommand("changeTemp"));
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int x, int y){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("forecraft", "/textures/gui/coreBackground.png"));
		GuiDraw.drawNonStandartTexturedRect(0, 0, 0, 0, width, height, 512, 256);
	}

	@Override
	public void drawGuiContainerForegroundLayer(int x, int y){
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		if(tileEntity.getStackInSlot(0) != null){
			GuiDraw.drawString(String.format("Temperature: %.2f", NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Temperature")), -200, -110, 0x1c9727);
			GuiDraw.drawString(String.format("Humidity: %.2f", NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Humidity")), -200, -90, 0x1c9727);
			GuiDraw.drawString(String.format("Pressure: %.2f", NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Pressure")), -200, -70, 0x1c9727);
		}else{
			GuiDraw.drawString("Temperature: null", -200, -110, 0x1c9727);
			GuiDraw.drawString("Humidity: null", -200, -90, 0x1c9727);
			GuiDraw.drawString("Pressure: null", -200, -70, 0x1c9727);
		}
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
	}

	@Override
	public void updateScreen(){
		super.updateScreen();

		if(tileEntity.getStackInSlot(0) != null){
			this.temp = NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Temperature");
			this.hum = NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Humidity");
			this.press = NBTHelper.getDouble(this.tileEntity.getStackInSlot(0), "Pressure");
		}
	}

	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}

}
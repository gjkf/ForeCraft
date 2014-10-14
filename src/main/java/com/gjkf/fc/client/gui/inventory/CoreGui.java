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

import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.lib.gui.GuiDraw;
import com.gjkf.lib.gui.GuiGJButton;
import com.gjkf.lib.gui.GuiScreenWidget;

public class CoreGui extends GuiScreenWidget{
	
	{super.width = GuiDraw.displaySize().width;
	super.height = GuiDraw.displaySize().height;}
	
	public CoreGui(InventoryPlayer inventoryPlayer, BaseCoreTE te){
		super(GuiDraw.displaySize().width, GuiDraw.displaySize().height);
	}

	@Override
	public void addWidgets(){
		add(new GuiGJButton(width + 40, height - 150, 30, 20, "C/F").setActionCommand("C/F"));
	}

	@Override
	public void initGui(){
		super.initGui();
		System.err.println(width);
		System.err.println(height);
	}

	@Override
	public void drawForeground(){
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		GuiDraw.drawCentered("Test It seems to Work!!! YAY", width, height, 0xFFFFFF);
		
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float f){
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, f);
	}

	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}

}
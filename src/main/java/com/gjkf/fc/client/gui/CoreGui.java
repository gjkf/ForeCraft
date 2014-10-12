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

package com.gjkf.fc.client.gui;

import net.minecraft.entity.player.InventoryPlayer;

import com.gjkf.fc.blocks.container.CoreContainer;
import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.lib.gui.GuiGJButton;
import com.gjkf.lib.gui.GuiScreenWidget;

public class CoreGui extends GuiScreenWidget{
	
	public CoreGui(InventoryPlayer inventoryPlayer, BaseCoreTE te){
		super();
	}
	
	@Override
	public void addWidgets(){
		add(new GuiGJButton(width + 40, height - 150, 30, 20, "C/F").setActionCommand("C/F"));
	}
	
	@Override
	public void initGui(){
		super.initGui();
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
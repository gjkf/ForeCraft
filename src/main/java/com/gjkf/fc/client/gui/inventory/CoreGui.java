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
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.gjkf.fc.Main;
import com.gjkf.fc.blocks.container.CoreContainer;
import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.fc.handler.WeatherHandler;
import com.gjkf.lib.gui.GuiContainerScreen;
import com.gjkf.lib.gui.GuiDraw;
import com.gjkf.lib.gui.GuiGJButton;
import com.gjkf.lib.gui.GuiScreenWidget;
import com.gjkf.lib.helper.NBTHelper;
import com.gjkf.lib.render.GJRenderState;

public class CoreGui extends GuiScreenWidget{

	private BaseCoreTE tileEntity;

	private double temp;
	private double hum;
	private double press;

	private int selectedType = 2;

	private GuiGJButton cfButton;

	private String[] type = new String[3];

	public CoreGui(InventoryPlayer inventoryPlayer, BaseCoreTE tileEntity){
		super(GuiDraw.displaySize().width, GuiDraw.displaySize().height);
		this.tileEntity = tileEntity;

		type[0] = "C";
		type[1] = "F";
		type[2] = "K";
		
		temp = tileEntity.getTemperature();
		hum = tileEntity.getHumidity();
		press = tileEntity.getPressure();
	}

	@Override
	public void addWidgets(){
		add(cfButton = new GuiGJButton(20, 100, 30, 20, "C/F").setActionCommand("changeTemp"));
	}

	@Override
	public void drawBackground(){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		/*this.mc.getTextureManager().bindTexture(new ResourceLocation("forecraft", "/textures/gui/coreBackground.png"));
		GuiDraw.drawNonStandartTexturedRect(0, 0, 0, 0, width, height, 512, 256);*/
		drawDefaultBackground();
	}

	@Override
	public void drawForeground(){
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		/*
		 * This will write the desidered type of degree
		 */

		if(type[selectedType].equals("C")){
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[0]), 20, 30, 0x1c9727);
		}else if(type[selectedType].equals("F")){
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[1]), 20, 30, 0x1c9727);
		}else if(type[selectedType].equals("K")){
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[2]), 20, 30, 0x1c9727);
		}else{
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[0]), 20, 30, 0x1c9727);
		}

		GuiDraw.drawString(String.format("Humidity: %.2f", hum), 20, 50, 0x1c9727);
		GuiDraw.drawString(String.format("Pressure: %.2f millibar", press), 20, 70, 0x1c9727);


		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
	}

	@Override
	public void updateScreen(){
		super.updateScreen();

		if(type[selectedType].equals("C")){
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[0]), 20, 30, 0x1c9727);
		}else if(type[selectedType].equals("F")){
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[1]), 20, 30, 0x1c9727);
		}else if(type[selectedType].equals("K")){
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[2]), 20, 30, 0x1c9727);
		}else{
			GuiDraw.drawString(String.format("Temperature: %.2f %s", temp, type[0]), 20, 30, 0x1c9727);
		}

	}

	@Override
	public void actionPerformed(String ident, Object... params){

		if(ident.equals("changeTemp")){

			Main.log.info("Type: " + selectedType);

			if(selectedType == 0){
				setSelectedType(1);
				temp = WeatherHandler.celciusToFarenheit(temp);
			}else if(selectedType == 1){
				setSelectedType(2);
				temp = WeatherHandler.farenheitToKelvin(temp);
			}else if(selectedType == 2){
				setSelectedType(0);
				temp = WeatherHandler.kelvinToCelcius(temp);
			}
			
			Main.log.info("TypeAfter: " + selectedType);

		}
	}

	private void setSelectedType(int type){
		this.selectedType = type;
	}

	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}

}
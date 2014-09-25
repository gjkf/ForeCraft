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

package com.gjkf.fc.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.gjkf.fc.Main;
import com.gjkf.fc.blocks.te.StationTE;
import com.gjkf.fc.weather.Humidity;
import com.gjkf.fc.weather.Pressure;
import com.gjkf.fc.weather.Temperature;
import com.gjkf.lib.blocks.GJMachineBlock;

public class Station extends GJMachineBlock implements ITileEntityProvider{

	public static String name = "station";
	
	public static double temperature;
	public static double humidity;
	public static double pressure;
	
	private static float biomeTemp;
	private static float biomeHum;
	
	private Pressure p;
	private Temperature t;
	private Humidity h;
	
	public Station(){
		setTickRandomly(true);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata){
		return new StationTE();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack){
		
		if(!(entity instanceof EntityPlayer)){
			return;
		}
		
		world = entity.worldObj;
		BiomeGenBase currBiome = world.getBiomeGenForCoords(x, z);
		EntityPlayer player = (EntityPlayer)entity;
		
		p = new Pressure();
		t = new Temperature();
		h = new Humidity();
		
		biomeTemp = currBiome.temperature;
		biomeHum = currBiome.rainfall;
		
		t.setTemperature(Main.biomesMap.get(currBiome));
		p.setPressure(temperature, world.getTileEntity(x, y, z), currBiome);
		h.setHumidity(biomeHum * 100);
		
		setWeather(t, h, p);
		
		if(world.isRemote){
			player.addChatMessage(new ChatComponentText(String.format("BiomeTemp: %.2f | Biome Humidity: %.2f | Biome Pressure: %.2f", this.temperature, this.humidity, this.pressure)));
		}
		
		biomeHum = 0;
		biomeTemp = 0;
	}
	
	public static void setBlockTemperature(float ammount){
		temperature = ammount;
	}
	
	public static void setBlockHumidity(float ammount){
		humidity = ammount;
	}
	
	public static double getBlockTemperature(){
		return temperature;
	}
	
	public static double getBlockHumidity(){
		return humidity;
	}
	
	public static double getBlockPressure(){
		return pressure;
	}
	
	public static void setWeather(Temperature t, Humidity h, Pressure p){
		temperature = t.getTemperature();
		humidity = h.getHumidity();
		pressure = p.getPressure();
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rnd){
		
		if(rnd.nextInt() % 2 == 0){
			setWeather(t, h, p);
			
			Main.log.info("Temp/Hum/Press: " + temperature + " " + humidity + " " + pressure);
		}
		
	}
	
	@Override
	public int getRenderType(){
		return 0;
	}
	
	@Override
	public boolean hasTileEntity(){
		return true;
	}
	
}
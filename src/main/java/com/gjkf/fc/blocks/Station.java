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

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import com.gjkf.fc.Main;
import com.gjkf.fc.blocks.te.StationTE;
import com.gjkf.fc.handler.BiomesHandler;
import com.gjkf.fc.handler.WeatherHandler;
import com.gjkf.fc.items.ItemCard;
import com.gjkf.fc.weather.Humidity;
import com.gjkf.fc.weather.Pressure;
import com.gjkf.fc.weather.Temperature;
import com.gjkf.lib.blocks.GJMachineBlock;
import com.gjkf.lib.helper.NBTHelper;

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

	private WeatherHandler weatherHandler;

	public ItemStack card;

	public Station(){
		super();
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

		setWeather(t, h, p, currBiome, x, y, z, world);

		if(world.isRemote){
			player.addChatMessage(new ChatComponentText(String.format("BiomeTemp: %.2f | Biome Humidity: %.2f | Biome Pressure: %.2f", this.temperature, this.humidity, this.pressure)));
		}

		biomeHum = 0;
		biomeTemp = 0;

		weatherHandler = new WeatherHandler();
		weatherHandler.init(this);
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

	/*
	 * Sets the Pressure, Humidity and Temperature that the block can measure
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 * @param biome
	 * @param xCoord
	 * @param yCoord
	 * @param zCoord
	 * @param world
	 */

	public static void setWeather(Temperature t, Humidity h, Pressure p, BiomeGenBase currBiome, int x, int y, int z, World world){

		/*
		 *If the biome is not a vanilla biome, then use the dictionary 
		 */

		if(BiomesHandler.vanillaBiomes.get(currBiome) == null){
			t.setTemperature(BiomesHandler.biomesMap.get(BiomeDictionary.getTypesForBiome(currBiome)[0]));
		}else{
			t.setTemperature(BiomesHandler.vanillaBiomes.get(currBiome));
		}
		p.setPressure(world.getTileEntity(x, y, z), currBiome);
		h.setHumidity(currBiome.rainfall * 100);		

		temperature = t.getTemperature();
		humidity = h.getHumidity();
		pressure = p.getPressure();
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rnd){

		super.updateTick(world, x, y, z, rnd);
		
		p = new Pressure();
		t = new Temperature();
		h = new Humidity();

		setWeather(t, h, p, world.getBiomeGenForCoords(x, z), x, y, z, world);

		Main.log.info("Temp/Hum/Press: " + temperature + " " + humidity + " " + pressure);

		weatherHandler = new WeatherHandler();
		weatherHandler.init(this);

		if(card != null){
			NBTHelper.setDouble(card, "Temperature", temperature);
			NBTHelper.setDouble(card, "Humidity", humidity);
			NBTHelper.setDouble(card, "Pressure", pressure);
		}

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		Main.log.info("Temp/Hum/Press: " + temperature + " " + humidity + " " + pressure);
		return true;
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
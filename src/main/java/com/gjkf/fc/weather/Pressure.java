package com.gjkf.fc.weather;

import net.minecraft.world.biome.BiomeGenBase;

public class Pressure {

	public float pressure;
		
	public float getPressure(){
		return pressure;
	}
	
	public void setPressure(float temperature, float humidity){
		pressure = temperature * 25 + humidity * 100;
	}
	
}
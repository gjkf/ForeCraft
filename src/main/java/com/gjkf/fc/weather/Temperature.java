package com.gjkf.fc.weather;

import com.gjkf.fc.Main;

public class Temperature{

	private double temperature;

	public double getTemperature(){
		return temperature;
	}

	public void setTemperature(double biomeTemp){
		temperature = Math.random() * 11 + (biomeTemp - 10);
	}
	
}
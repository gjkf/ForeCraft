package com.gjkf.fc.weather;

public class Humidity{

	private double humidity;
	
	public double getHumidity(){
		return humidity;
	}
	
	public void setHumidity(double biomHum){
		humidity = Math.random() * 16 + (biomHum - 8);
	}
	
}
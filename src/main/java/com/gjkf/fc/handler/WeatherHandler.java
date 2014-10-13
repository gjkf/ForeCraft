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

package com.gjkf.fc.handler;

import com.gjkf.fc.Main;
import com.gjkf.fc.blocks.Station;
import com.gjkf.fc.weather.Rain;

public class WeatherHandler{

	public void init(Object o){
		
		if(o instanceof Station){
			Rain.setProbableRain(Station.getBlockHumidity(), Station.getBlockPressure());
		}
		
	}
}
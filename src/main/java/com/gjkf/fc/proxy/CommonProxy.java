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

package com.gjkf.fc.proxy;

import com.gjkf.fc.blocks.BaseCore;
import com.gjkf.fc.blocks.Station;
import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.fc.blocks.te.StationTE;
import com.gjkf.fc.references.References;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy{

	@Override
	public void registerTE() {
		GameRegistry.registerTileEntity(BaseCoreTE.class, "tile." + BaseCore.name);
		GameRegistry.registerTileEntity(StationTE.class, "tile." +  Station.name);
	}

}
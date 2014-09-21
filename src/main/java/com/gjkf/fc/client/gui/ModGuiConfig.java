package com.gjkf.fc.client.gui;

import java.util.List;

import com.gjkf.fc.handler.ConfigurationHandler;
import com.gjkf.fc.references.References;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class ModGuiConfig extends GuiConfig{

	public ModGuiConfig(GuiScreen guiScreen){
		super(guiScreen,
				new ConfigElement(ConfigurationHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                References.MODID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
	}

}
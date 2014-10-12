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

import com.gjkf.fc.Main;
import com.gjkf.fc.blocks.te.BaseCoreTE;
import com.gjkf.fc.references.References;
import com.gjkf.lib.blocks.GJMachineBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BaseCore extends GJMachineBlock implements ITileEntityProvider{

	public static final String name = "baseCore";
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	public BaseCore(){
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata){
		return new BaseCoreTE();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		if(world.isRemote && player.getCurrentEquippedItem() == null && world.getTileEntity(x, y, z) instanceof BaseCoreTE){
			
			Main.log.info("Opening Gui");
			
			player.openGui(Main.instance, References.GUI_CORE_ID, world, (int)player.posX, (int)player.posY, (int)player.posZ);
			
			Main.log.info("Succesfully opened Gui");
			
			return true;
		}
		
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister IconRegistry){
		this.blockIcon = IconRegistry.registerIcon(References.MODID + ":baseCoreSide");
		this.iconFront = IconRegistry.registerIcon(References.MODID + ":baseCoreFront");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 1 ? this.blockIcon : (side == 0 ? this.blockIcon : (side != meta ? this.blockIcon : this.iconFront)); 
	}
	
	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			Block block = world.getBlock(x, y, z-1);
			Block block1 = world.getBlock(x, y, z+1);
			Block block2 = world.getBlock(x-1, y, z);
			Block block3 = world.getBlock(x+1, y, z);
			byte b0 = 3;

			if(block.func_149730_j() && !block1.func_149730_j()){
				b0 = 3;
			}

			if(block1.func_149730_j() && !block.func_149730_j()){
				b0 = 2;
			}

			if(block2.func_149730_j() && !block3.func_149730_j()){
				b0 = 5;
			}

			if(block3.func_149730_j() && !block2.func_149730_j()){
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack){
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0 / 360.F) + 0.5D) & 3;

		if(l==0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if(l==1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if(l==2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if(l==3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
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
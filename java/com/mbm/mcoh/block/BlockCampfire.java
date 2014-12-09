package com.mbm.mcoh.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.tileentity.TileEntityCampfire;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCampfire extends BlockContainer{

	public static boolean keepInventory;
	public TileEntityCampfire tileEntity;
	
	public boolean isActive;
	
	public BlockCampfire(String unlocalizedName, String textureName, Material material, boolean isActive) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(1.0F);
        this.setResistance(2.0F);
        this.setHarvestLevel("axe", 1);
        this.setStepSound(soundTypeWood);
        this.setBlockBounds(0, 0, 0, 1, 0.25F, 1);        
        this.isActive = isActive;
        
        if(this.isActive){
        	this.setLightLevel(1.0F);
        }else{
        	this.setLightLevel(0F);
        }
		}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z){
		return new ItemStack(Item.getItemFromBlock(BlockRegistry.campfireOff));
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Main.MODID + ":campfire");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return this.blockIcon;
	}
	
	public Item getItemDropped(int i, Random random, int j)
    {
        return Item.getItemFromBlock(BlockRegistry.campfireOff);
    }
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		
		if(this.isActive){
		      			
			int l;
	        float f;
	        float f1;
	        float f2;
		
			if(random.nextFloat() >= 0.7){
				
				world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
				}
		
          for (l = 0; l < 2; ++l)
                {
                    f = (float)x + random.nextFloat();
                    f1 = (float)y + random.nextFloat() + 0.3F;
                    f2 = (float)z + random.nextFloat();
                    world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
 			}
 		}
     
	
	public boolean isBurning(IBlockAccess world, int x, int y, int z)
    {
		if(this.isActive){
			return true;
		}else{
			return false;
		}
    }
		
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileEntityCampfire(isActive);
	}
	

	
}

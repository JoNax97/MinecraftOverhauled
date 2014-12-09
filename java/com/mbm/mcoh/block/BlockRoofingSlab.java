package com.mbm.mcoh.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRoofingSlab extends BlockSlab{

private boolean isDoubleSlab;
private int numSubBlocks;
private Block singleSlab;
private Block textureBlock;
private int textureStartCounter;




public BlockRoofingSlab(boolean isDouble, Material material, Block singleSlab, Block textureBlock) {
	super(isDouble, material);
	  setHardness(2.0F);
	  setResistance(5.0F);
	  setStepSound(Block.soundTypeStone);              
	  useNeighborBrightness = true;
	  
	  if(isDouble)
	   setCreativeTab(null);
	  else
	   setCreativeTab(CreativeTabs.tabBlock);
	  
	  isDoubleSlab = isDouble;
	  numSubBlocks = 2;
	  this.singleSlab = singleSlab;
	  this.textureBlock = textureBlock;
	  textureStartCounter = 0;
}

@Override
public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z){
	if(world.getBlock(x, y, z) == BlockRegistry.slabRoofing && world.getBlockMetadata(x, y, z) == 0){
		return new ItemStack(Item.getItemFromBlock(BlockRegistry.slabRoofing),1,0);
	}
	if(world.getBlock(x, y, z) == BlockRegistry.slabRoofing && world.getBlockMetadata(x, y, z) == 1){
		return new ItemStack(Item.getItemFromBlock(BlockRegistry.slabRoofing),1,1);
	}
	
	return new ItemStack(Item.getItemFromBlock(Blocks.air));
}



@SideOnly(Side.CLIENT)
public void getSubBlocks(Item item, CreativeTabs creativeTab, List subItems)
    {
     for (int ix = 0; ix < numSubBlocks; ix++)
     {
      subItems.add(new ItemStack(this, 1, ix));
     }
}

@SideOnly(Side.CLIENT)
public IIcon getIcon(int side, int meta)
{
  return textureBlock.getIcon(side, (meta % 8) + textureStartCounter);
}


@Override
public Item getItemDropped(int par1, Random rand, int par3)
{
  return (isDoubleSlab ? Item.getItemFromBlock(singleSlab) : Item.getItemFromBlock(this));
}

@Override
    public int quantityDropped(Random rand)
    {
        return (isDoubleSlab ? 2 : 1);
    }

@Override
public int damageDropped (int metadata) {
  return metadata % 8;
}



@Override
protected ItemStack createStackedBlock(int meta)       
{               
  return new ItemStack(singleSlab, 2, meta);       
}       


public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity)
{
if(world.getBlock(x, y - 1, z) == BlockRegistry.slabRoofing)
{
world.setBlock(x, y, z, Blocks.air);
world.setBlock(x, y - 1, z, BlockRegistry.doubleSlabRoofing);
}
if(world.getBlock(x, y + 1, z) == BlockRegistry.slabRoofing)
{
world.setBlock(x, y, z, Blocks.air);
world.setBlock(x, y + 1, z, BlockRegistry.doubleSlabRoofing);
}
}


@Override
//In Forge 1.6.4 it was "getFullSlabName"
public String func_150002_b(int par1)
{
  if ((par1 < 0) || (par1 >= numSubBlocks))               
  {                       
   par1 = 0;               
  }               
  return super.getUnlocalizedName() + "." + (par1+1);  
}
}
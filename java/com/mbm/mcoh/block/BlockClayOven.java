package com.mbm.mcoh.block;

import java.util.Random;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.gui.GuiRegistry;
import com.mbm.mcoh.tileentity.TileEntityClayOven;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockClayOven extends BlockContainer{
	
	public boolean isActive;
	public static boolean keepInventory;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	private IIcon iconSide;
	private IIcon iconTop;
	
	private Random rand = new Random();
	
	public BlockClayOven(String unlocalizedName, String textureName, Material material, boolean isActive) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + textureName);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(2.0F);
        this.setResistance(6.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
        
        this.isActive = isActive;
        
        if(this.isActive){
        	this.setLightLevel(0.9F);
		}else{
			this.setLightLevel(0.0F);
		}
        	
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconSide = iconRegister.registerIcon(Main.MODID + ":clay_oven_side");
		this.iconTop = iconRegister.registerIcon(Main.MODID + ":clay_oven_top");
		if (isActive){
			this.iconFront = iconRegister.registerIcon(Main.MODID + ":clay_oven_front_on");
		}else{
			this.iconFront = iconRegister.registerIcon(Main.MODID + ":clay_oven_front_off");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
				
		if (meta == 0 && side == 3)
   	 {
   		 return this.iconFront;
   	 }else{
   		return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != meta ? this.iconSide : this.iconFront));
   	 }
	}
		
	public Item getItemDropped(int i, Random random, int j)
    {
        return Item.getItemFromBlock(BlockRegistry.clayOvenOff);
    }
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z){
		return new ItemStack(Item.getItemFromBlock(BlockRegistry.clayOvenOff));
		
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
		
	}
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote){
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);
			
			byte b0 = 3;
			
			if(b1.func_149730_j() && !b2.func_149730_j()){
				b0 = 3;
			}
			
			if(b2.func_149730_j() && !b1.func_149730_j()){
				b0 = 2;
			}
			
			if(b3.func_149730_j() && !b4.func_149730_j()){
				b0 = 5;
			}
			
			if(b4.func_149730_j() && !b3.func_149730_j()){
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
		
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack){
		
		int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(l == 0){
			world.setBlockMetadataWithNotify(x, y, z , 2, 2);
		}
		if(l == 1){
			world.setBlockMetadataWithNotify(x, y, z , 5, 2);
		}
		if(l == 2){
			world.setBlockMetadataWithNotify(x, y, z , 3, 2);
		}
		if(l == 3){
			world.setBlockMetadataWithNotify(x, y, z , 4, 2);
		}
		if(itemStack.hasDisplayName()){
				((TileEntityClayOven)world.getTileEntity(x,y,z)).setGuiDisplayName(itemStack.getDisplayName());
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityClayOven();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, Main.instance, GuiRegistry.guiIDClayOven, world, x, y, z);
		}
		return true; 
	}

	public static void updateState(boolean isActive, World worldObj, int xCoord, int yCoord, int zCoord) {
		
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		TileEntity tileEntity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if(isActive){
			worldObj.setBlock(xCoord, yCoord, zCoord, BlockRegistry.clayOvenOn);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, BlockRegistry.clayOvenOff);
		}
		
		keepInventory = false;
		
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta, 2);
		
		if(tileEntity !=null){
			tileEntity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileEntity);
			
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if(this.isActive) {
			int direction = world.getBlockMetadata(x, y, z);
			
			float x1 = (float)x + 0.5F;
			 float y1 = (float)y + 0.2F + random.nextFloat() * 6.0F / 16.0F;
			float z1 = (float)z + 0.5F;
			
			float f = 0.52F;
			float f1 = random.nextFloat() * 0.6F - 0.3F;
			
			if(direction == 4){
				world.spawnParticle("smoke", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			}
			
			if(direction == 5){
				world.spawnParticle("smoke", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			}
			
			if(direction == 2){
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
			}
			
			if(direction == 3){
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
			}
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		if(!keepInventory) {
			TileEntityClayOven tileentity = (TileEntityClayOven) world.getTileEntity(x, y, z);
			
			if(tileentity != null) {
				for(int i = 0; i < tileentity.getSizeInventory(); i++) {
					ItemStack itemstack = tileentity.getStackInSlot(i);
					
					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						
						while(itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;
							
							if(j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= j;
							
							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							
							if(itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}
							
							world.spawnEntityInWorld(item);
						}
					}
				}
				
				world.func_147453_f(x, y, z, oldblock);
			}
		}
		
		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}

}

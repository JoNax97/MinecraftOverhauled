package com.mbm.mcoh.manager;

import com.mbm.mcoh.container.SlotCraftingTool;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TieredRecipes implements ITieredRecipe
{
    /** How many horizontal slots this recipe is wide. */
    public final int recipeWidth;
    /** How many vertical slots this recipe uses. */
    public final int recipeHeight;
    /** Is a array of ItemStack that composes the recipe. */
    public final ItemStack[] recipeItems;
    /** Is the ItemStack that you get when craft the recipe. */
    private ItemStack recipeOutput;
        /** Is the ItemStack needed in the tool slot. */
    private ItemStack recipeTool;
        /** Is the lowest tier in wich a recipe can be made. */
    private int minTier;
    
    private boolean field_92101_f;
    private static final String __OBFID = "CL_00000093";

    public TieredRecipes(int width, int height, ItemStack[] recipe, ItemStack tool, int tier, ItemStack result)
    {
        this.recipeWidth = width;
        this.recipeHeight = height;
        this.recipeItems = recipe;
        this.recipeTool = tool;
        this.recipeOutput = result;
        this.minTier = tier;
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting inventory, World world, ItemStack usedTool, int currentTier)
    {
        for (int i = 0; i <= 3 - this.recipeWidth; ++i)
        {
            for (int j = 0; j <= 3 - this.recipeHeight; ++j)
            {
                if (this.checkMatch(inventory, i, j, true) && this.checkToolMatch(usedTool) && this.checkTier(currentTier))
                {
                 	
                    return true;
                }

                if (this.checkMatch(inventory, i, j, false)&& this.checkToolMatch(usedTool) && this.checkTier(currentTier))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkTier(int currentTier) {
		if(currentTier >= this.minTier){
			return true;
		}
		
		return false;
	}

	private boolean checkToolMatch(ItemStack usedTool) {
      	
    	if (usedTool == null && this.recipeTool == null){
			return true;
    	}
    	
		if (usedTool == null && this.recipeTool != null){
			return false;
		}
			
			
		if (usedTool != null && this.recipeTool == null){
			return false;
		}
		
		if (usedTool != null && this.recipeTool != null){
			return usedTool.getItem() == recipeTool.getItem();			
		}
		
		return true;
	}

	/**
     * Checks if the region of a crafting inventory is match for the recipe.
     */
    private boolean checkMatch(InventoryCrafting p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_)
    {
        for (int k = 0; k < 3; ++k)
        {
            for (int l = 0; l < 3; ++l)
            {
                int i1 = k - p_77573_2_;
                int j1 = l - p_77573_3_;
                ItemStack itemstack = null;

                if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
                {
                    if (p_77573_4_)
                    {
                        itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
                    }
                    else
                    {
                        itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
                    }
                }

                ItemStack itemstack1 = p_77573_1_.getStackInRowAndColumn(k, l);

                if (itemstack1 != null || itemstack != null)
                {
                    if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
                    {
                        return false;
                    }

                    if (itemstack.getItem() != itemstack1.getItem())
                    {
                        return false;
                    }

                    if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack usedTool)
    {
        ItemStack itemstack = this.getRecipeOutput().copy();

        if (this.field_92101_f)
        {
            for (int i = 0; i < inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack1 = inventory.getStackInSlot(i);

                if (itemstack1 != null && itemstack1.hasTagCompound())
                {
                    itemstack.setTagCompound((NBTTagCompound)itemstack1.stackTagCompound.copy());
                }
            }
        }

        return itemstack;
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeWidth * this.recipeHeight;
    }

    public TieredRecipes func_92100_c()
    {
        this.field_92101_f = true;
        return this;
    }
}
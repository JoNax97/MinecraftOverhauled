package com.mbm.mcoh.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class TieredShapelessRecipes implements ITieredRecipe
{
    /** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;
    /** Is a List of ItemStack that composes the recipe. */
    public final List recipeItems;
    /** Is the ItemStack needed in the tool slot. */
    private ItemStack recipeTool;
    /** Is the lowest tier in wich a recipe can be made. */
    private int minTier;
    
       
    private static final String __OBFID = "CL_00000094";

    public TieredShapelessRecipes(ItemStack result, ItemStack tool, int tier, List recipe)
    {
        this.recipeOutput = result;
        this.recipeItems = recipe;
        this.recipeTool = tool;
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
        ArrayList arraylist = new ArrayList(this.recipeItems);

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                ItemStack itemstack = inventory.getStackInRowAndColumn(j, i);

                if (itemstack != null)
                {
                    boolean flag = false;
                    Iterator iterator = arraylist.iterator();

                    while (iterator.hasNext())
                    {
                        ItemStack itemstack1 = (ItemStack)iterator.next();

                        if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage())  && this.checkToolMatch(usedTool) && this.checkTier(currentTier))
                        {
                            flag = true;
                            arraylist.remove(itemstack1);
                            break;
                        }
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
            }
        }

        return arraylist.isEmpty();
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
		
		return false;
	}

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack tool)
    {
        return this.recipeOutput.copy();
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
}
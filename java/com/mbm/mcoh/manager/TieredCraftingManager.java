package com.mbm.mcoh.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.mbm.mcoh.item.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class TieredCraftingManager
{
    /** The static instance of this class */
    private static final TieredCraftingManager instance = new TieredCraftingManager();
    /** A list of all the recipes added */
    private List<Object> recipes = new ArrayList<Object>();
    /**
     * Returns the static instance of this class
     */
    public static final TieredCraftingManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    @SuppressWarnings("unchecked")
	private TieredCraftingManager()
    {
    	recipes = new ArrayList<Object>();
    	
    	this.addSawRecipes();
    	this.addHammerRecipes();
    	this.addMortarRecipes();
    	
       	this.addRecipe(0, new ItemStack(ItemRegistry.impaledFish), null, new Object[] {" F", "S ", 'F', Items.fish, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledBacon), null, new Object[] {" F", "S ", 'F', ItemRegistry.bacon, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledBeef), null, new Object[] {" F", "S ", 'F', Items.beef, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledCacti), null, new Object[] {" F", "S ", 'F', ItemRegistry.cactusMeat, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledCarrot), null, new Object[] {" F", "S ", 'F', Items.carrot, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledChicken), null, new Object[] {" F", "S ", 'F', Items.chicken, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledCorn), null, new Object[] {" F", "S ", 'F', ItemRegistry.corn, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledMantaray), null, new Object[] {" F", "S ", 'F', ItemRegistry.mantaray, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledMutton), null, new Object[] {" F", "S ", 'F', ItemRegistry.mutton, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledPorkchop), null, new Object[] {" F", "S ", 'F', Items.porkchop, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledPotato), null, new Object[] {" F", "S ", 'F', Items.potato, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledRottenFlesh), null, new Object[] {" F", "S ", 'F', Items.rotten_flesh, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledSquid), null, new Object[] {" F", "S ", 'F', ItemRegistry.squid, 'S', Items.stick});
    	this.addRecipe(0, new ItemStack(ItemRegistry.impaledTuna), null, new Object[] {" F", "S ", 'F', ItemRegistry.tuna, 'S', Items.stick});
       
        Collections.sort(this.recipes, new TieredComparator(this));
    }

    private void addMortarRecipes() {
		
 	Item[] recipeTool = new Item[] {ItemRegistry.mortar};
		
    	for (int i = 0; i == 0; i++ ){
    		
    		 	this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 11), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.yellow_flower, 1, 0)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 1), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 0)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 3, 15), new ItemStack(recipeTool[i]), new Object[] {Items.bone});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 9), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 14), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 11)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 10), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 2), new ItemStack(Items.dye, 1, 15)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 8), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 15)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 7), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 8), new ItemStack(Items.dye, 1, 15)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 3, 7), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 12), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 6), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 2)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 5), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 1)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 13), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 9)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 3, 13), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 9)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 4, 13), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 12), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 1)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 13), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 2)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 7), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 3)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 1), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 4)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 14), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 5)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 7), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 6)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 9), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 7)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 1, 7), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.red_flower, 1, 8)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 11), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.double_plant, 1, 0)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 13), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.double_plant, 1, 1)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 1), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.double_plant, 1, 4)});
    	        this.addShapelessRecipe(0, new ItemStack(Items.dye, 2, 9), new ItemStack(recipeTool[i]), new Object[] {new ItemStack(Blocks.double_plant, 1, 5)});
						
    	}
		
	}

	private void addSawRecipes() {
		
    	Item[] recipeTool = new Item[] {ItemRegistry.bronzeSaw, ItemRegistry.ironSaw, ItemRegistry.diamondSaw};
		
    	for (int i = 0; i < 3; i++ ){
    		
			this.addRecipe(1, new ItemStack(Items.bed, 1), new ItemStack(recipeTool[i]), new Object[] {"###", "XXX", '#', Blocks.wool, 'X', Blocks.planks});
    	
			this.addRecipe(1, new ItemStack(ItemRegistry.woodenPlankOak, 15), new ItemStack(recipeTool[i]), new Object[] {"L", 'L', new ItemStack(Blocks.log, 1, 0)});
	    	this.addRecipe(1, new ItemStack(ItemRegistry.woodenPlankBirch, 15), new ItemStack(recipeTool[i]), new Object[] {"L", 'L', new ItemStack(Blocks.log, 1, 2)});
	    	this.addRecipe(1, new ItemStack(ItemRegistry.woodenPlankSpruce, 15), new ItemStack(recipeTool[i]), new Object[] {"L", 'L', new ItemStack(Blocks.log, 1, 1)});
	    	this.addRecipe(1, new ItemStack(ItemRegistry.woodenPlankJungle, 15), new ItemStack(recipeTool[i]), new Object[] {"L", 'L', new ItemStack(Blocks.log, 1, 3)});
	    	this.addRecipe(1, new ItemStack(ItemRegistry.woodenPlankAcacia, 15), new ItemStack(recipeTool[i]), new Object[] {"L", 'L', new ItemStack(Blocks.log2, 1, 0)});
	    	this.addRecipe(1, new ItemStack(ItemRegistry.woodenPlankBigOak, 15), new ItemStack(recipeTool[i]), new Object[] {"L", 'L', new ItemStack(Blocks.log2, 1, 1)});
			
    	}
    }
    
    private void addHammerRecipes() {
		
    	Item[] recipeTool = new Item[] {ItemRegistry.bronzeHammer, ItemRegistry.ironHammer, ItemRegistry.diamondHammer};
		
    	for (int i = 0; i < 3; i++ ){
    		
    		this.addRecipe(1, new ItemStack(Blocks.planks, 1, 0), new ItemStack(recipeTool[i]), new Object[] {"PNP", "NPN", "PNP", 'P', ItemRegistry.woodenPlankOak, 'N', ItemRegistry.nail});
        	this.addRecipe(1, new ItemStack(Blocks.planks, 1, 1), new ItemStack(recipeTool[i]), new Object[] {"PNP", "NPN", "PNP", 'P', ItemRegistry.woodenPlankSpruce, 'N', ItemRegistry.nail});
        	this.addRecipe(1, new ItemStack(Blocks.planks, 1, 2), new ItemStack(recipeTool[i]), new Object[] {"PNP", "NPN", "PNP", 'P', ItemRegistry.woodenPlankBirch, 'N', ItemRegistry.nail});
        	this.addRecipe(1, new ItemStack(Blocks.planks, 1, 3), new ItemStack(recipeTool[i]), new Object[] {"PNP", "NPN", "PNP", 'P', ItemRegistry.woodenPlankJungle, 'N', ItemRegistry.nail});
        	this.addRecipe(1, new ItemStack(Blocks.planks, 1, 4), new ItemStack(recipeTool[i]), new Object[] {"PNP", "NPN", "PNP", 'P', ItemRegistry.woodenPlankAcacia, 'N', ItemRegistry.nail});
        	this.addRecipe(1, new ItemStack(Blocks.planks, 1, 5), new ItemStack(recipeTool[i]), new Object[] {"PNP", "NPN", "PNP", 'P', ItemRegistry.woodenPlankBigOak, 'N', ItemRegistry.nail});

    	}
    }

	public TieredRecipes addRecipe(int tier, ItemStack result, ItemStack tool, Object ... recipe)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (recipe[i] instanceof String[])
        {
            String[] astring = (String[])((String[])recipe[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (recipe[i] instanceof String)
            {
                String s2 = (String)recipe[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap<Character, ItemStack> hashmap;

        for (hashmap = new HashMap<Character, ItemStack>(); i < recipe.length; i += 2)
        {
            Character character = (Character)recipe[i];
            ItemStack itemstack1 = null;

            if (recipe[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)recipe[i + 1]);
            }
            else if (recipe[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)recipe[i + 1], 1, 32767);
            }
            else if (recipe[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)recipe[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        TieredRecipes tieredRecipe = new TieredRecipes(j, k, aitemstack, tool, tier, result);
        this.recipes.add(tieredRecipe);
        return tieredRecipe;
    }

    public void addShapelessRecipe(int tier, ItemStack result, ItemStack tool, Object ... recipe)
    {
        ArrayList<ItemStack> arraylist = new ArrayList<ItemStack>();
        Object[] aobject = recipe;
        int i = recipe.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new TieredShapelessRecipes(result, tool, tier, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting inventory, World world, ItemStack usedTool, int tier)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < inventory.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = inventory.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                ITieredRecipe irecipe = (ITieredRecipe)this.recipes.get(j);

                if (irecipe.matches(inventory, world, usedTool, tier))
                {
                   return irecipe.getCraftingResult(inventory, usedTool);
                    
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List<Object> getRecipeList()
    {
        return this.recipes;
    }
}
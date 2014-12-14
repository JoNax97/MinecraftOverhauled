package com.mbm.mcoh.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.block.BlockRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ItemRegistry {

	public static Item impaledFish;
	public static Item impaledBeef;
	public static Item impaledTuna;
	public static Item impaledSquid;
	public static Item impaledRottenFlesh;
	public static Item impaledPotato;
	public static Item impaledPorkchop;
	public static Item impaledMutton;
	public static Item impaledMantaray;
	public static Item impaledCorn;
	public static Item impaledChicken;
	public static Item impaledCarrot;
	public static Item impaledCacti;
	public static Item impaledBacon;
	
	public static Item tuna;
	public static Item squid;
	public static Item mutton;
	public static Item mantaray;
	public static Item corn;
	public static Item cactusMeat;
	public static Item bacon;
	public static Item algae;
	public static Item olives;
	
	public static Item cookedTuna;
	public static Item cookedSquid;
	public static Item cookedFlesh;
	public static Item cookedMutton;
	public static Item cookedMantaray;
	public static Item cookedCorn;
	public static Item cookedCarrot;
	public static Item cookedCactusMeat;
	public static Item cookedBacon;

    public static Item clayPanel;
	public static Item woodenPlankOak;
	public static Item woodenPlankBirch;
	public static Item woodenPlankSpruce;
	public static Item woodenPlankJungle;
	public static Item woodenPlankBigOak;
	public static Item woodenPlankAcacia;
	
	public static Item ashes;
	public static Item branch;
	public static Item seashell;
	public static Item rock;
	
	public static Item bambooItem;
		
	public static Item bronzeSaw;
	public static Item diamondSaw;
	public static Item ironSaw;
	
	public static Item silverChunk;
	public static Item nickelChunk;
	public static Item manganeseChunk;
	public static Item leadChunk;
	public static Item aluminumChunk;
	public static Item tinChunk;
	public static Item ironChunk;
	public static Item goldChunk;
	public static Item copperChunk;
	
	public static Item bronzeHammer;
	public static Item ironHammer;
	public static Item diamondHammer;
	
	public static Item flintKnife;
	
	public static Item boneNeedle;
	
	public static Item mortar;
	
	public static Item nail;
	

    public static final void init() {
    	
		ironSaw = new ItemSaw()
		        
		.setUnlocalizedName("ironSaw")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":iron_saw");
		
		GameRegistry.registerItem(ironSaw, "ironSaw");
		
		bronzeSaw = new ItemSaw()
        
		.setUnlocalizedName("ironSaw")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":bronze_saw");
		
		GameRegistry.registerItem(bronzeSaw, "bronzeSaw");
		
		diamondSaw = new ItemSaw()
        
		.setUnlocalizedName("diamondSaw")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":diamond_saw");

		GameRegistry.registerItem(diamondSaw, "diamondSaw");
		
		bronzeHammer = new ItemHammer()
        
		.setUnlocalizedName("bronzeHammer") 
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":bronze_hammer");

		GameRegistry.registerItem(bronzeHammer, "bronzeHammer");
		
		ironHammer = new ItemHammer()
        
		.setUnlocalizedName("ironHammer")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":iron_hammer");

		GameRegistry.registerItem(ironHammer, "ironHammer");
	
		diamondHammer = new ItemHammer()
        
		.setUnlocalizedName("diamondSaw")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":diamond_hammer");

		GameRegistry.registerItem(diamondHammer, "diamondHammer");
		
		
		flintKnife = new ItemKnife(2, ToolMaterial.WOOD, null)
        
		.setUnlocalizedName("flintKnife")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":flint_knife");

		GameRegistry.registerItem(flintKnife, "flintKnife");
		
		boneNeedle = new ItemTool()
        
		.setUnlocalizedName("boneNeedle")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":bone_needle");

		GameRegistry.registerItem(boneNeedle, "boneNeedle");
		
		mortar = new ItemTool()
        
		.setUnlocalizedName("mortar")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(Main.MODID + ":mortar");

		GameRegistry.registerItem(mortar, "mortar");
		
		silverChunk = new Item()
        
		.setUnlocalizedName("silverChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":silver_chunk");

		GameRegistry.registerItem(silverChunk, "silverChunk");
		
		nickelChunk = new Item()
        
		.setUnlocalizedName("nickelChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":nickel_chunk");

		GameRegistry.registerItem(nickelChunk, "nickelChunk");
		
		manganeseChunk = new Item()
        
		.setUnlocalizedName("manganeseChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":manganese_chunk");

		GameRegistry.registerItem(manganeseChunk, "manganeseChunk");
		
		leadChunk = new Item()
        
		.setUnlocalizedName("leadChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":lead_chunk");

		GameRegistry.registerItem(leadChunk, "leadChunk");
		
		aluminumChunk = new Item()
        
		.setUnlocalizedName("aluminumChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":aluminum_chunk");

		GameRegistry.registerItem(aluminumChunk, "aluminumChunk");
		
		tinChunk = new Item()
        
		.setUnlocalizedName("tinChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":tin_chunk");

		GameRegistry.registerItem(tinChunk, "tinChunk");
		
		ironChunk = new Item()
        
		.setUnlocalizedName("ironChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":iron_chunk");

		GameRegistry.registerItem(ironChunk, "ironChunk");
		
		
		goldChunk = new Item()
        
		.setUnlocalizedName("goldChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":gold_chunk");

		GameRegistry.registerItem(goldChunk, "goldChunk");
		
		copperChunk = new Item()
        
		.setUnlocalizedName("copperChunk")
		.setCreativeTab(CreativeTabs.tabMaterials)
		.setTextureName(Main.MODID + ":copper_chunk");

		GameRegistry.registerItem(copperChunk, "copperChunk");
		
		    	
        clayPanel = new Item()
        
        				.setUnlocalizedName("clayPanel")
        				.setCreativeTab(CreativeTabs.tabMaterials)
        				.setTextureName(Main.MODID + ":clay_panel");
        
        				GameRegistry.registerItem(clayPanel, "clayPanel");
        				
        nail = new Item()
        		        
        				.setUnlocalizedName("nail")
        				.setCreativeTab(CreativeTabs.tabMaterials)
        				.setTextureName(Main.MODID + ":nail");
        
        				GameRegistry.registerItem(nail, "nail");
        				
        woodenPlankOak = new Item()
        		        
        				.setUnlocalizedName("woodenPlankOak")
        				.setCreativeTab(CreativeTabs.tabMaterials)
        				.setTextureName(Main.MODID + ":wooden_plank_oak");
        
        				GameRegistry.registerItem(woodenPlankOak, "woodenPlankOak");
        				
        woodenPlankBirch = new Item()
         		        
         				.setUnlocalizedName("woodenPlankBirch")
         				.setCreativeTab(CreativeTabs.tabMaterials)
         				.setTextureName(Main.MODID + ":wooden_plank_birch");
         
         				GameRegistry.registerItem(woodenPlankBirch, "woodenPlankBirch");
         				
        woodenPlankSpruce = new Item()
         		        
         				.setUnlocalizedName("woodenPlankSpruce")
         				.setCreativeTab(CreativeTabs.tabMaterials)
         				.setTextureName(Main.MODID + ":wooden_plank_spruce");
         
         				GameRegistry.registerItem(woodenPlankSpruce, "woodenPlankSpruce");
         				
        woodenPlankJungle = new Item()
         		        
         				.setUnlocalizedName("woodenPlankJungle")
         				.setCreativeTab(CreativeTabs.tabMaterials)
         				.setTextureName(Main.MODID + ":wooden_plank_jungle");
         
         				GameRegistry.registerItem(woodenPlankJungle, "woodenPlankJungle");
         				
        woodenPlankBigOak = new Item()
         		        
         				.setUnlocalizedName("woodenPlankBigOak")
         				.setCreativeTab(CreativeTabs.tabMaterials)
         				.setTextureName(Main.MODID + ":wooden_plank_big_oak");
         
         				GameRegistry.registerItem(woodenPlankBigOak, "woodenPlankBigOak");
         				
        woodenPlankAcacia = new Item()
         		        
         				.setUnlocalizedName("woodenPlankAcacia")
         				.setCreativeTab(CreativeTabs.tabMaterials)
         				.setTextureName(Main.MODID + ":wooden_plank_acacia");
         
         				GameRegistry.registerItem(woodenPlankAcacia, "woodenPlankAcacia");
        				
        ashes = new Item()
        		        
        				.setUnlocalizedName("ashes")
        				.setCreativeTab(CreativeTabs.tabMisc)
        				.setTextureName(Main.MODID + ":ashes");
        
        				GameRegistry.registerItem(ashes, "ashes");
        				
       seashell = new Item()
        		        
        				.setUnlocalizedName("seashell")
        				.setCreativeTab(CreativeTabs.tabMaterials)
        				.setTextureName(Main.MODID + ":seashell");
        
        				GameRegistry.registerItem(seashell, "seashell");
        				
       rock = new Item()
         		        
         				.setUnlocalizedName("rock")
         				.setCreativeTab(CreativeTabs.tabMaterials)
         				.setTextureName(Main.MODID + ":rock");
         
         				GameRegistry.registerItem(rock, "rock");
        				
       branch = new Item()
        		        
        				.setUnlocalizedName("branch")
        				.setCreativeTab(CreativeTabs.tabMaterials)
        				.setTextureName(Main.MODID + ":branch");
        
        				GameRegistry.registerItem(branch, "branch");
        				
       bambooItem = new ItemBamboo()
        		        
        				.setUnlocalizedName("bambooItem")
        				.setTextureName(Main.MODID + ":bamboo");
        
        				GameRegistry.registerItem(bambooItem, "bambooItem");
        					
       impaledFish = new ItemImpaledFood()
        
        				.setUnlocalizedName("impaledFish")
        				.setCreativeTab(CreativeTabs.tabFood)
                		.setTextureName(Main.MODID + ":impaled_fish");
        
                		GameRegistry.registerItem(impaledFish, "impaledFish");
                		
       impaledBeef = new ItemImpaledFood()
                        
        				.setUnlocalizedName("impaledBeef")
        				.setCreativeTab(CreativeTabs.tabFood)
                		.setTextureName(Main.MODID + ":impaled_beef");
        
                		GameRegistry.registerItem(impaledBeef, "impaledBeef");
                		
       impaledTuna = new ItemImpaledFood()
                         
         				.setUnlocalizedName("impaledTuna")
         				.setCreativeTab(CreativeTabs.tabFood)
                 		.setTextureName(Main.MODID + ":impaled_tuna");
         
                 		GameRegistry.registerItem(impaledTuna, "impaledTuna");
                		
       impaledSquid = new ItemImpaledFood()
                         
         				.setUnlocalizedName("impaledSquid")
         				.setCreativeTab(CreativeTabs.tabFood)
                 		.setTextureName(Main.MODID + ":impaled_squid");
         
                 		GameRegistry.registerItem(impaledSquid, "impaledSquid");
                 		
      impaledRottenFlesh = new ItemImpaledFood()
                          
          				.setUnlocalizedName("impaledRottenFlesh")
          				.setCreativeTab(CreativeTabs.tabFood)
                  		.setTextureName(Main.MODID + ":impaled_rotten_flesh");
          
                  		GameRegistry.registerItem(impaledRottenFlesh, "impaledRottenFlesh");
                  		
                  		
     impaledPotato = new ItemImpaledFood()
                        
        				.setUnlocalizedName("impaledPotato")
        				.setCreativeTab(CreativeTabs.tabFood)
                		.setTextureName(Main.MODID + ":impaled_potato");
        
                		GameRegistry.registerItem(impaledPotato, "impaledPotato");
                		
     impaledPorkchop = new ItemImpaledFood()
                         
         				.setUnlocalizedName("impaledPorkchop")
         				.setCreativeTab(CreativeTabs.tabFood)
                 		.setTextureName(Main.MODID + ":impaled_porkchop");
         
                 		GameRegistry.registerItem(impaledPorkchop, "impaledPorkchop");
                 		
     impaledMutton = new ItemImpaledFood()
                         
         				.setUnlocalizedName("impaledMutton")
         				.setCreativeTab(CreativeTabs.tabFood)
                 		.setTextureName(Main.MODID + ":impaled_mutton");
         
                 		GameRegistry.registerItem(impaledMutton, "impaledMutton");
                 		
      impaledMantaray = new ItemImpaledFood()
                          
          				.setUnlocalizedName("impaledMantaray")
          				.setCreativeTab(CreativeTabs.tabFood)
                  		.setTextureName(Main.MODID + ":impaled_manta_ray");
          
                  		GameRegistry.registerItem(impaledMantaray, "impaledMantaray");
                  		
                		
      impaledCorn = new ItemImpaledFood()
                          
          				.setUnlocalizedName("impaledCorn")
          				.setCreativeTab(CreativeTabs.tabFood)
                  		.setTextureName(Main.MODID + ":impaled_corn");
          
                  		GameRegistry.registerItem(impaledCorn, "impaledCorn");
                  		
     impaledChicken = new ItemImpaledFood()
                          
          				.setUnlocalizedName("impaledChicken")
          				.setCreativeTab(CreativeTabs.tabFood)
                  		.setTextureName(Main.MODID + ":impaled_chicken");
          
                  		GameRegistry.registerItem(impaledChicken, "impaledChicken");
                  		
     impaledCarrot = new ItemImpaledFood()
                           
           				.setUnlocalizedName("impaledCarrot")
           				.setCreativeTab(CreativeTabs.tabFood)
                   		.setTextureName(Main.MODID + ":impaled_carrot");
           
                   		GameRegistry.registerItem(impaledCarrot, "impaledCarrot");
                   		
     impaledCacti = new ItemImpaledFood()
                     
     				.setUnlocalizedName("impaledCacti")
     				.setCreativeTab(CreativeTabs.tabFood)
             		.setTextureName(Main.MODID + ":impaled_cactus_meat");
     
             		GameRegistry.registerItem(impaledCacti, "impaledCacti");
             		
     impaledBacon = new ItemImpaledFood()
                      
      				.setUnlocalizedName("impaledBacon")
      				.setCreativeTab(CreativeTabs.tabFood)
              		.setTextureName(Main.MODID + ":impaled_bacon");
      
              		GameRegistry.registerItem(impaledBacon, "impaledBacon");
              		
     
tuna = new ItemFood(2, 0.4F, false)

					.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F)
      				.setUnlocalizedName("tuna")
      				.setTextureName(Main.MODID + ":tuna_raw");
      
              		GameRegistry.registerItem(tuna, "tuna");  
              		
algae = new ItemFood(1, 0.3F, false)

	 				.setUnlocalizedName("algae")
      				.setTextureName(Main.MODID + ":algae");
      
              		GameRegistry.registerItem(algae, "algae");  
              		
olives = new ItemFood(1, 0.3F, false)

	 				.setUnlocalizedName("olives")
      				.setTextureName(Main.MODID + ":olives");
      
              		GameRegistry.registerItem(olives, "olives");
              		
              		
squid = new ItemFood(1, 0.4F, false)
                    
					.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F)
					.setUnlocalizedName("squid")
               		.setTextureName(Main.MODID + ":squid_raw");
      
              		GameRegistry.registerItem(squid, "squid");  
              		
mutton = new ItemFood(2, 1.2F, false)
                    
					.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F)
      				.setUnlocalizedName("mutton")
              		.setTextureName(Main.MODID + ":mutton_raw");
      
              		GameRegistry.registerItem(mutton, "mutton");   
              		
mantaray = new ItemFood(2, 0.4F, false)

					.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F)
      				.setUnlocalizedName("mantaray")
              		.setTextureName(Main.MODID + ":manta_ray_raw");
      
              		GameRegistry.registerItem(mantaray, "mantaray");
              		
corn = new ItemFood(1, 0.6F, false)
                    
      				.setUnlocalizedName("corn")
      				.setCreativeTab(CreativeTabs.tabFood)
              		.setTextureName(Main.MODID + ":corn");
      
              		GameRegistry.registerItem(corn, "corn"); 
              		
cactusMeat = new ItemFood(1, 0.6F, false)
                    
      				.setUnlocalizedName("cactusMeat")
      				.setCreativeTab(CreativeTabs.tabFood)
              		.setTextureName(Main.MODID + ":cactus_meat_raw");
      
              		GameRegistry.registerItem(cactusMeat, "cactusMeat"); 
              		
bacon = new ItemFood(3, 1.8F, false)
                    
					.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F)
      				.setUnlocalizedName("bacon")
              		.setTextureName(Main.MODID + ":bacon_raw");
      
              		GameRegistry.registerItem(bacon, "bacon");     		
              		
cookedTuna = new ItemFood(5, 6F, false)
                    
    				.setUnlocalizedName("cookedTuna")
              		.setTextureName(Main.MODID + ":tuna_cooked");
      
              		GameRegistry.registerItem(cookedTuna, "cookedTuna");
              		
cookedSquid = new ItemFood(5, 3F, false)
                    
      				.setUnlocalizedName("cookedSquid")
              		.setTextureName(Main.MODID + ":squid_cooked");
      
              		GameRegistry.registerItem(cookedSquid, "cookedSquid");
              		
cookedFlesh = new ItemFood(6, 1.8F, true)
                    
      				.setUnlocalizedName("cookedFlesh")
              		.setTextureName(Main.MODID + ":cooked_flesh");
      
              		GameRegistry.registerItem(cookedFlesh, "cookedFlesh");
              		
cookedMutton = new ItemFood(6, 9.6F, true)
                    
      				.setUnlocalizedName("cookedMutton")
              		.setTextureName(Main.MODID + ":mutton_cooked");
      
              		GameRegistry.registerItem(cookedMutton, "cookedMutton");
              		
cookedMantaray = new ItemFood(5, 6F, false)
                    
      				.setUnlocalizedName("cookedMantaray")
              		.setTextureName(Main.MODID + ":manta_ray_cooked");
      
              		GameRegistry.registerItem(cookedMantaray, "cookedMantaray");
              		
cookedCorn = new ItemFood(5, 6F, false)
                    
      				.setUnlocalizedName("cookedCorn")
              		.setTextureName(Main.MODID + ":corn_cooked");
      
              		GameRegistry.registerItem(cookedCorn, "cookedCorn");
              		
cookedCarrot = new ItemFood(4, 6F, false)
                    
      				.setUnlocalizedName("cookedCarrot")
              		.setTextureName(Main.MODID + ":carrot_cooked");
      
              		GameRegistry.registerItem(cookedCarrot, "cookedCarrot");
              		
cookedCactusMeat = new ItemFood(4, 6F, false)
                    
      				.setUnlocalizedName("cookedCactusMeat")
              		.setTextureName(Main.MODID + ":cactus_meat_cooked");
      
              		GameRegistry.registerItem(cookedCactusMeat, "cookedCactusMeat");
              		
cookedBacon = new ItemFood(8, 12.8F, true)
                    
      				.setUnlocalizedName("cookedBacon")
              		.setTextureName(Main.MODID + ":bacon_cooked");
      
              		GameRegistry.registerItem(cookedBacon, "cookedBacon");
    }
 }
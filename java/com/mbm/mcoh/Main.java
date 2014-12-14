package com.mbm.mcoh;

import net.minecraftforge.common.MinecraftForge;

import com.mbm.mcoh.handler.GuiHandler;
import com.mbm.mcoh.handler.PlayerInteractionHandler;
import com.mbm.mcoh.handler.TickEventHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

        public static final String MODID = "minecraftoverhauled";
        public static final String MODNAME = "The MINECRAFT OVERHAULED! Mod";
        public static final String VERSION = "alpha 0.5";
        
        @Instance
        public static Main instance = new Main();
        
        @SidedProxy(clientSide="com.mbm.mcoh.ClientProxy", serverSide="com.mbm.mcoh.ServerProxy")
        public static CommonProxy proxy;
        
       @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
    	   Main.proxy.preInit(event);  
        }
        
        @EventHandler
        public void init(FMLInitializationEvent event) {
        	 Main.proxy.init(event);
        	 NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
        	 Main.proxy.postInit(event);
        	 
        	 MinecraftForge.EVENT_BUS.register(new PlayerInteractionHandler());
           	 FMLCommonHandler.instance().bus().register(new TickEventHandler());
        }
}
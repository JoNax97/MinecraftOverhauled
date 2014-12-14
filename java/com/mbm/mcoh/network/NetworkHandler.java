package com.mbm.mcoh.network;

import com.mbm.mcoh.Main;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler {
	
public static SimpleNetworkWrapper network;

    public static void init() {
       network = NetworkRegistry.INSTANCE.newSimpleChannel(Main.MODID);
       
       network.registerMessage(CraftMatrixUpdate.Handler.class, CraftMatrixUpdate.class, 0, Side.SERVER);
       
    }

}

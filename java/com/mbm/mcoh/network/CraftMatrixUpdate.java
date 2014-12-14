package com.mbm.mcoh.network;

import com.mbm.mcoh.container.ContainerLeatherWorkbench;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.server.MinecraftServer;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CraftMatrixUpdate implements IMessage {


	public boolean update; 

    public CraftMatrixUpdate() {}

    public CraftMatrixUpdate(boolean update) { 
        this.update = update;
    }

    @Override
    public void toBytes(ByteBuf buf) { 
        buf.writeBoolean(update);
    }

    @Override
    public void fromBytes(ByteBuf buf) { 
        this.update = buf.readBoolean();
    }
    
    public static class Handler implements IMessageHandler<CraftMatrixUpdate, IMessage> { 

        @Override
        public IMessage onMessage(CraftMatrixUpdate message, MessageContext ctx) { 
        	
        	ContainerLeatherWorkbench workbench = (ContainerLeatherWorkbench) Minecraft.getMinecraft().thePlayer.openContainer;
        	workbench.onCraftMatrixChanged(workbench.craftMatrix);
        	
        	return null;
        }

    }

}
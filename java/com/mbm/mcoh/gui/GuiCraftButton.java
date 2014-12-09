package com.mbm.mcoh.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mbm.mcoh.Main;

@SideOnly(Side.CLIENT)
public class GuiCraftButton extends GuiButton
{
    protected static final ResourceLocation texture = new ResourceLocation(Main.MODID + ":textures/gui/widgets.png" );

    public GuiCraftButton(int ID, int posX, int posY, String message){
    	super(ID, posX, posY, 16, 16, message);
    	
    }
    @Override
    public void drawButton(Minecraft minecraft, int mouseX, int mouseY)
    {}
}

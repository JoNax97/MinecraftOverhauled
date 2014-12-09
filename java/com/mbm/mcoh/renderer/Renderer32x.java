package com.mbm.mcoh.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.mbm.mcoh.item.Item32x;

public class Renderer32x implements IItemRenderer {
	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		return (type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON) ? true : false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack itemStack, ItemRendererHelper helper) {
		return (type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON) ? true : false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
		Item item = itemStack.getItem();

		if(item instanceof Item32x) {

			IIcon icon = item.getIcon(itemStack, 0);

			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);

			if(type == ItemRenderType.EQUIPPED) {
								
				GL11.glPushMatrix();

				GL11.glScaled(2, 2, 2);

				GL11.glTranslated(0.05D, 1.1D, -0.05D);

				GL11.glRotated(130D, 0D, 1D, 0D);
				GL11.glRotated(-120D, 0D, 0D, 1D);

				ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), 255, 255, 0.0625F);

				GL11.glPopMatrix();
			} else if(type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
								
				GL11.glPushMatrix();

				GL11.glScaled(200, 200, 100);

				GL11.glTranslated(0.4D, -0.2D, 0.45D);

				GL11.glRotated(37.5D, 0D, 1D, 0D);
				GL11.glRotated(-30D, 0D, 0D, 1D);

				ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), 255, 255, 0.0625F);

				GL11.glPopMatrix();
			}
		}
	}
}
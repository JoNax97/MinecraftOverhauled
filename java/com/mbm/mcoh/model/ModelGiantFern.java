package com.mbm.mcoh.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGiantFern extends ModelBase
{
	 //fields
    ModelRenderer log1;
    ModelRenderer log2;
    ModelRenderer leafTop;
    ModelRenderer leafSide1;
    ModelRenderer leafSide2;
    ModelRenderer leafSide3;
    ModelRenderer leafSide4;
  
  public ModelGiantFern()
  {
    textureWidth = 128;
    textureHeight = 64;
    
    log1 = new ModelRenderer(this, 0, 0);
    log1.addBox(-8F, 0F, 0F, 16, 32, 0);
    log1.setRotationPoint(0F, -8F, 0F);
    log1.setTextureSize(128, 64);
    log1.mirror = true;
    setRotation(log1, 0F, -0.7853982F, 0F);
    log2 = new ModelRenderer(this, 0, 0);
    log2.addBox(-8F, 0F, 0F, 16, 32, 0);
    log2.setRotationPoint(0F, -8F, 0F);
    log2.setTextureSize(128, 64);
    log2.mirror = true;
    setRotation(log2, 0F, 0.7853982F, 0F);
    leafTop = new ModelRenderer(this, 62, 0);
    leafTop.addBox(-16F, -16F, 0F, 32, 32, 0);
    leafTop.setRotationPoint(0F, -9.1F, 0F);
    leafTop.setTextureSize(128, 64);
    leafTop.mirror = true;
    setRotation(leafTop, -1.570796F, 0F, 0F);
    leafSide1 = new ModelRenderer(this, 62, 35);
    leafSide1.addBox(-16F, -2F, 0F, 32, 16, 0);
    leafSide1.setRotationPoint(0F, -7F, 0F);
    leafSide1.setTextureSize(128, 64);
    leafSide1.mirror = true;
    setRotation(leafSide1, 0F, -1.570796F, 0F);
    leafSide2 = new ModelRenderer(this, 62, 35);
    leafSide2.addBox(-16F, -2F, 0F, 32, 16, 0);
    leafSide2.setRotationPoint(0.1F, -7F, 0.1F);
    leafSide2.setTextureSize(128, 64);
    leafSide2.mirror = true;
    setRotation(leafSide2, 0F, 0.7853982F, 0F);
    leafSide3 = new ModelRenderer(this, 62, 35);
    leafSide3.addBox(-16F, -2F, 0F, 32, 16, 0);
    leafSide3.setRotationPoint(0F, -7F, 0F);
    leafSide3.setTextureSize(128, 64);
    leafSide3.mirror = true;
    setRotation(leafSide3, 0F, 0F, 0F);
    leafSide4 = new ModelRenderer(this, 62, 35);
    leafSide4.addBox(-16F, -2F, 0F, 32, 16, 0);
    leafSide4.setRotationPoint(0.1F, -7F, 0F);
    leafSide4.setTextureSize(128, 64);
    leafSide4.mirror = true;
    setRotation(leafSide4, 0F, -0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    log1.render(f5);
    log2.render(f5);
    //leafTop.render(f5);
    leafSide1.render(f5);
    //leafSide2.render(f5);
    leafSide3.render(f5);
    //leafSide4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}

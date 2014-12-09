package com.mbm.mcoh.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCampfire extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer log1;
    ModelRenderer log2;
    ModelRenderer log3;
    ModelRenderer log4;
   
  
  public ModelCampfire()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      base = new ModelRenderer(this, 0, 0);
      base.addBox(0F, 0F, 0F, 16, 4, 16);
      base.setRotationPoint(-8F, 20F, -8F);
      base.setTextureSize(64, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      log1 = new ModelRenderer(this, 50, 0);
      log1.addBox(-1F, -12F, -1F, 2, 13, 2);
      log1.setRotationPoint(5F, 20F, -5F);
      log1.setTextureSize(64, 64);
      log1.mirror = true;
      setRotation(log1, 0.6108652F, 2.356194F, 0F);
      log2 = new ModelRenderer(this, 50, 0);
      log2.addBox(-1F, -12F, -1F, 2, 13, 2);
      log2.setRotationPoint(5F, 20F, 5F);
      log2.setTextureSize(64, 64);
      log2.mirror = true;
      setRotation(log2, 0.6108652F, 0.7853982F, 0F);
      log3 = new ModelRenderer(this, 50, 0);
      log3.addBox(-1F, -12F, -1F, 2, 13, 2);
      log3.setRotationPoint(-5F, 20F, -5F);
      log3.setTextureSize(64, 64);
      log3.mirror = true;
      setRotation(log3, 0.6108652F, -2.356194F, 0F);
      log4 = new ModelRenderer(this, 50, 0);
      log4.addBox(-1F, -12F, -1F, 2, 13, 2);
      log4.setRotationPoint(-5F, 20F, 5F);
      log4.setTextureSize(64, 64);
      log4.mirror = true;
      setRotation(log4, 0.6108652F, -0.7853982F, 0F);
   
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    log1.render(f5);
    log2.render(f5);
    log3.render(f5);
    log4.render(f5);
    
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

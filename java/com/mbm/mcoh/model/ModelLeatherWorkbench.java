package com.mbm.mcoh.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeatherWorkbench extends ModelBase
{
  //fields
    ModelRenderer Body;
  
  public ModelLeatherWorkbench()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 16, 1, 16);
      Body.setRotationPoint(-8F, 23F, -8F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
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

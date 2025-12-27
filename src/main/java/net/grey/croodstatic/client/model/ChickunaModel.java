package net.grey.croodstatic.client.model;

import net.grey.croodstatic.entity.ChickunaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChickunaModel extends GeoModel<ChickunaEntity> {
    @Override
    public ResourceLocation getModelResource(ChickunaEntity object) {
        return new ResourceLocation("croodstatic", "geo/chickuna.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChickunaEntity object) {
        if (object.isBaby()) {
            return new ResourceLocation("croodstatic", "textures/entity/chickuna_baby.png");
        } else {
            return new ResourceLocation("croodstatic", "textures/entity/chickuna.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(ChickunaEntity animatable) {
        return new ResourceLocation("croodstatic", "animations/chickuna.animation.json");
    }
}

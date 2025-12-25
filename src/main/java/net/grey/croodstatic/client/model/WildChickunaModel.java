package net.grey.croodstatic.client.model;

import net.grey.croodstatic.entity.ChickunaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WildChickunaModel extends GeoModel<ChickunaEntity> {
    @Override
    public ResourceLocation getModelResource(ChickunaEntity object) {
        return new ResourceLocation("croodstatic", "geo/wild_chickuna.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChickunaEntity object) {
        return new ResourceLocation("croodstatic", "textures/entity/wild_chickuna.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChickunaEntity animatable) {
        return new ResourceLocation("croodstatic", "animations/wild_chickuna.animation.json");
    }
}

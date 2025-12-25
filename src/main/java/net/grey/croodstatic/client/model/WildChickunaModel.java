package net.grey.croodstatic.client.model;

import net.grey.croodstatic.entity.WildChickunaEntity;
import net.grey.croodstatic.entity.WildChickunaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WildChickunaModel extends GeoModel<WildChickunaEntity> {
    @Override
    public ResourceLocation getModelResource(WildChickunaEntity object) {
        return new ResourceLocation("croodstatic", "geo/wild_chickuna.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WildChickunaEntity object) {
        return new ResourceLocation("croodstatic", "textures/entity/wild_chickuna.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WildChickunaEntity animatable) {
        return new ResourceLocation("croodstatic", "animations/wild_chickuna.animation.json");
    }
}

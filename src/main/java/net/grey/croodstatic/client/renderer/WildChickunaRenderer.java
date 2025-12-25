package net.grey.croodstatic.client.renderer;

import net.grey.croodstatic.client.model.WildChickunaModel;
import net.grey.croodstatic.entity.WildChickunaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WildChickunaRenderer extends GeoEntityRenderer<WildChickunaEntity> {
    public WildChickunaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WildChickunaModel());
    }
}

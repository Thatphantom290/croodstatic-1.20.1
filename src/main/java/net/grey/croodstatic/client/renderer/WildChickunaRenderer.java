package net.grey.croodstatic.client.renderer;

import net.grey.croodstatic.client.model.WildChickunaModel;
import net.grey.croodstatic.entity.ChickunaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WildChickunaRenderer extends GeoEntityRenderer<ChickunaEntity> {
    public WildChickunaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WildChickunaModel());
    }
}

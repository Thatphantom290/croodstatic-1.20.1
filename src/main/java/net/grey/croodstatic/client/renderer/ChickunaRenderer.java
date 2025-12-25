package net.grey.croodstatic.client.renderer;

import net.grey.croodstatic.entity.ChickunaEntity;
import net.grey.croodstatic.client.model.ChickunaModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ChickunaRenderer extends GeoEntityRenderer<ChickunaEntity> {
    public ChickunaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ChickunaModel());
    }
}

package net.grey.croodstatic.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.grey.croodstatic.entity.ChickunaEntity;
import net.grey.croodstatic.client.model.ChickunaModel;
import net.minecraft.client.renderer.MultiBufferSource;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ChickunaRenderer extends GeoEntityRenderer<ChickunaEntity> {
    public ChickunaRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new ChickunaModel());
    }

    @Override
    public void render(ChickunaEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(-0.8F, -0.8F, -0.8F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}

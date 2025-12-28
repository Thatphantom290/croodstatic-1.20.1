package net.grey.croodstatic.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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
    public void render(ChickunaEntity entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
            poseStack.translate(0.0D, -0.5D, 0.0D);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}

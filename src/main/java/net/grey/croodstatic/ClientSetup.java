package net.grey.croodstatic;

import net.grey.croodstatic.block.ModBlocks;
import net.grey.croodstatic.client.renderer.ChickunaRenderer;
import net.grey.croodstatic.client.renderer.WildChickunaRenderer;
import net.grey.croodstatic.entity.ModEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Croodstatic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOIST_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNAIL_TREE_GROWTHS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MEDIUM_MOIST_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHICKUNA_NEST.get(), RenderType.cutout());

        EntityRenderers.register(ModEntities.CHICKUNA.get(), ChickunaRenderer::new);
        EntityRenderers.register(ModEntities.WILD_CHICKUNA.get(), WildChickunaRenderer::new);
    }
}

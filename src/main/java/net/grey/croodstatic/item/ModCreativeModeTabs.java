package net.grey.croodstatic.item;

import net.grey.croodstatic.Croodstatic;
import net.grey.croodstatic.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Croodstatic.MODID);

    public static final RegistryObject<CreativeModeTab> CROODSTATIC =
            CREATIVE_MODE_TABS.register("croodstatic",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.CHICKUNA_EGG.get()))
                            .title(Component.translatable("creativetab.croodstatic"))
                            .displayItems((itemDisplayParameters, output) -> {
                                // Blocks Yay
                                output.accept(ModBlocks.REDSLATE.get());
                                output.accept(ModBlocks.CHISELED_REDSLATE.get());
                                output.accept(ModBlocks.CUT_REDSLATE.get());
                                output.accept(ModBlocks.REDSLATE_STAIRS.get());
                                output.accept(ModBlocks.REDSLATE_WALL.get());
                                output.accept(ModBlocks.REDSLATE_SLAB.get());
                                output.accept(ModBlocks.SMOOTH_REDSLATE.get());
                                output.accept(ModBlocks.GRASSY_MOIST_SOIL.get());
                                output.accept(ModBlocks.MOIST_SOIL.get());

                                // Flora Yay
                                output.accept(ModBlocks.MOIST_GRASS.get());
                                output.accept(ModBlocks.MEDIUM_MOIST_GRASS.get());

                                // Item Yay
                                output.accept(new ItemStack(ModItems.CHICKUNA_EGG.get())); }) .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

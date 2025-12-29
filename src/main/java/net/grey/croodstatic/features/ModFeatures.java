package net.grey.croodstatic.features;

import net.grey.croodstatic.Croodstatic;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, Croodstatic.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SNAIL_TREE =
            FEATURES.register("snail_tree", () -> new SnailTreeFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CHICKUNA_NEST =
            FEATURES.register("chickuna_nest", () -> new ChickunaNestFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}

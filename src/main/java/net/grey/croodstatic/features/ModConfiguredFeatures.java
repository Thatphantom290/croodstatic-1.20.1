package net.grey.croodstatic.features;

import net.grey.croodstatic.block.ModBlocks;
import net.grey.croodstatic.Croodstatic;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SNAIL_TREE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "snail_tree"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHICKUNA_NEST_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "chickuna_nest"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> MOIST_GRASS_PATCH_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "moist_grass_patch"));


    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_MOIST_GRASS_PATCH_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "medium_moist_grass_patch"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        context.register(CHICKUNA_NEST_KEY,
                new ConfiguredFeature<>(ModFeatures.CHICKUNA_NEST.get(), NoneFeatureConfiguration.INSTANCE));

        context.register(MOIST_GRASS_PATCH_KEY,
                new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                        FeatureUtils.simplePatchConfiguration(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MOIST_GRASS.get())),
                                List.of(), 32)));

        context.register(MEDIUM_MOIST_GRASS_PATCH_KEY,
                new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                        FeatureUtils.simplePatchConfiguration(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MEDIUM_MOIST_GRASS.get())),
                                List.of(), 32)));

        context.register(SNAIL_TREE_KEY,
                new ConfiguredFeature<>(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SNAIL_TREE_LEAVES.get()))));
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SNAIL_TREE_STEM.get()));
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SNAIL_TREE_GROWTHS.get()));

    }
}

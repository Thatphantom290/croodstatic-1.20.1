package net.grey.croodstatic.features;

import net.grey.croodstatic.Croodstatic;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CHICKUNA_NEST_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "chickuna_nest_placed"));

    public static final ResourceKey<PlacedFeature> MOIST_GRASS_PATCH_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "moist_grass_patch_placed"));

    public static final ResourceKey<PlacedFeature> MEDIUM_MOIST_GRASS_PATCH_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "medium_moist_grass_patch_placed"));

    public static final ResourceKey<PlacedFeature> SNAIL_TREE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(Croodstatic.MODID, "snail_tree_placed"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        Holder<ConfiguredFeature<?, ?>> nest =
                context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.CHICKUNA_NEST_KEY);
        context.register(CHICKUNA_NEST_PLACED_KEY,
                new PlacedFeature(nest, List.of()));

        Holder<ConfiguredFeature<?, ?>> moistPatch =
                context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.MOIST_GRASS_PATCH_KEY);
        context.register(MOIST_GRASS_PATCH_PLACED_KEY,
                new PlacedFeature(moistPatch, VegetationPlacements.worldSurfaceSquaredWithCount(5)));

        Holder<ConfiguredFeature<?, ?>> mediumPatch =
                context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.MEDIUM_MOIST_GRASS_PATCH_KEY);
        context.register(MEDIUM_MOIST_GRASS_PATCH_PLACED_KEY,
                new PlacedFeature(mediumPatch, VegetationPlacements.worldSurfaceSquaredWithCount(5)));

        Holder<ConfiguredFeature<?, ?>> snailTree =
                context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.SNAIL_TREE_KEY);

        int min = 67;
        int max = 124;
        int randomSpacing = Mth.nextInt(RandomSource.create(), min, max);

        context.register(SNAIL_TREE_PLACED_KEY,
                new PlacedFeature(snailTree, List.of(
                        InSquarePlacement.spread(),
                        RarityFilter.onAverageOnceEvery(randomSpacing),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )));
    }
}

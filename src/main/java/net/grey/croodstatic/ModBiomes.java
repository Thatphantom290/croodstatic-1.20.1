package net.grey.croodstatic;

import com.mojang.serialization.Lifecycle;
import net.grey.croodstatic.entity.ModEntities;
import net.grey.croodstatic.features.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class ModBiomes {

    public static final ResourceKey<Biome> FLAT_LANDS_KEY =
            ResourceKey.create(Registries.BIOME,
                    new ResourceLocation(Croodstatic.MODID, "flat_lands"));

    public static void bootstrap(BootstapContext<Biome> context) {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .skyColor(6431266)
                .fogColor(7623461)
                .waterColor(6524036)
                .waterFogColor(3687290)
                .grassColorOverride(10043418)
                .foliageColorOverride(7810318)
                .build();

        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        spawns.addSpawn(MobCategory.CREATURE,
                new MobSpawnSettings.SpawnerData(ModEntities.CHICKUNA.get(), 4, 2, 5));

        BiomeGenerationSettings.Builder generation =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER)
                );

        generation.addFeature(net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.SNAIL_TREE_PLACED_KEY);
        generation.addFeature(net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.MOIST_GRASS_PATCH_PLACED_KEY);
        generation.addFeature(net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.MEDIUM_MOIST_GRASS_PATCH_PLACED_KEY);
        generation.addFeature(net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.CHICKUNA_NEST_PLACED_KEY);

        Biome biome = new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.9F)
                .downfall(0.0F)
                .specialEffects(effects)
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .build();

        context.register(FLAT_LANDS_KEY, biome, Lifecycle.stable());
    }
}

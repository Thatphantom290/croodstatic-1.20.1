package net.grey.croodstatic.features;

import com.mojang.serialization.Codec;
import net.grey.croodstatic.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ChickunaNestFeature extends Feature<NoneFeatureConfiguration> {
    public ChickunaNestFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        if (!(context.level() instanceof ServerLevel serverLevel)) {
            return false;
        }

        BlockPos pos = context.origin();

        serverLevel.setBlock(pos, ModBlocks.MOIST_SOIL.get().defaultBlockState(), 2);
        serverLevel.setBlock(pos.above(), ModBlocks.MOIST_SOIL.get().defaultBlockState(), 2);

        serverLevel.setBlock(pos.above(2), ModBlocks.CHICKUNA_NEST.get().defaultBlockState(), 2);

        return true;
    }
}

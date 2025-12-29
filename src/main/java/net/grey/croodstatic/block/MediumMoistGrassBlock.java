package net.grey.croodstatic.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.Blocks;

public class MediumMoistGrassBlock extends Block {

    public MediumMoistGrassBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.GRASS)
                .strength(0.3F)
                .sound(SoundType.GRASS)
                .noCollission());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        return below.is(Blocks.GRASS_BLOCK)
                || below.is(Blocks.MOSS_BLOCK)
                || below.is(ModBlocks.GRASSY_MOIST_SOIL.get());
    }
}

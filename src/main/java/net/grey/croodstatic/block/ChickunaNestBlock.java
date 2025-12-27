package net.grey.croodstatic.block;

import net.grey.croodstatic.entity.ChickunaEntity;
import net.grey.croodstatic.entity.ModEntities;
import net.grey.croodstatic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ChickunaNestBlock extends Block {
    public static final BooleanProperty WITH_EGG = BooleanProperty.create("with_egg");
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE = Shapes.box(0.0, 0.0, 0.0, 1.0, 0.9, 1.0);

    public ChickunaNestBlock(Properties properties) {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_YELLOW)
                .strength(0.5F)
                .sound(SoundType.GRASS)
                .randomTicks());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WITH_EGG, Boolean.FALSE)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WITH_EGG, FACING);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(WITH_EGG)) {
            level.playSound(null, pos, SoundEvents.TURTLE_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 1.0F);
            level.setBlock(pos, state.setValue(WITH_EGG, Boolean.FALSE), Block.UPDATE_ALL);

            ChickunaEntity chickuna = ModEntities.CHICKUNA.get().create(level);
            if (chickuna != null) {
                chickuna.setAge(-24000);
                chickuna.moveTo(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 0.0F, 0.0F);
                chickuna.setNestPos(pos);
                level.addFreshEntity(chickuna);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);

        if (level.isClientSide) {
            level.playSound(player, pos, SoundEvents.GRASS_FALL, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }

        if (state.getValue(WITH_EGG) && held.isEmpty()) {
            level.setBlock(pos, state.setValue(WITH_EGG, Boolean.FALSE), Block.UPDATE_ALL);
            player.addItem(new ItemStack(ModItems.CHICKUNA_EGG.get()));
            level.playSound(null, pos, SoundEvents.GRASS_FALL, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.CONSUME;

        }


        if (!state.getValue(WITH_EGG) && (held.is(ModItems.CHICKUNA_EGG.get()))) {
            if (!player.isCreative()) held.shrink(1);
            level.setBlock(pos, state.setValue(WITH_EGG, Boolean.FALSE), Block.UPDATE_ALL);
            level.playSound(null, pos, SoundEvents.GRASS_FALL, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacent, Direction side) {
        return false;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(this.asItem()));
        return drops;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WITH_EGG, Boolean.FALSE);
    }
}

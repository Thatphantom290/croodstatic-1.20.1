package net.grey.croodstatic.block;

import net.grey.croodstatic.block.entity.ModBlockEntities;
import net.grey.croodstatic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;


import javax.annotation.Nullable;

public class ChickunaNestBlock extends Block implements EntityBlock {
    public static final EnumProperty<EggType> EGG_PROPERTY =
            EnumProperty.create("egg", EggType.class);

    public ChickunaNestBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(EGG_PROPERTY, EggType.NONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(EGG_PROPERTY);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChickunaNestBlockEntity(pos, state);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof ChickunaNestBlockEntity nest)) return InteractionResult.PASS;

        ItemStack held = player.getItemInHand(hand);

        if (nest.getEgg().isEmpty() && (held.getItem() == ModItems.WILD_CHICKUNA_EGG.get() || held.getItem() == ModItems.CHICKUNA_EGG.get())) {
            nest.setEgg(held.copy());
            held.shrink(1);
            level.setBlock(pos, state.setValue(EGG_PROPERTY, getEggType(held)), 3);
            return InteractionResult.CONSUME;
        } else if (!nest.getEgg().isEmpty()) {
            player.addItem(nest.getEgg());
            nest.setEgg(ItemStack.EMPTY);
            level.setBlock(pos, state.setValue(EGG_PROPERTY, EggType.NONE), 3);
            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }

    private EggType getEggType(ItemStack stack) {
        if (stack.getItem() == ModItems.WILD_CHICKUNA_EGG.get()) {
            return EggType.WILD;
        } else if (stack.getItem() == ModItems.CHICKUNA_EGG.get()) {
            return EggType.NORMAL;
        }
        return EggType.NONE;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level,
                                                                  BlockState state,
                                                                  BlockEntityType<T> type) {
        return level.isClientSide ? null :
                makeTickerHelper(type,
                        ModBlockEntities.CHICKUNA_NEST.get(),
                        ChickunaNestBlockEntity::tick);
    }

    @SuppressWarnings("unchecked")
    private static <T extends BlockEntity, E extends BlockEntity> BlockEntityTicker<T> makeTickerHelper(
            BlockEntityType<T> givenType,
            BlockEntityType<E> expectedType,
            BlockEntityTicker<? super E> ticker) {
        return givenType == expectedType ? (BlockEntityTicker<T>) ticker : null;
    }
}

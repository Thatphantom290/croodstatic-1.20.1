package net.grey.croodstatic.block;

import net.grey.croodstatic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;

import javax.annotation.Nullable;

public class ChickunaNestBlock extends Block implements EntityBlock {
    public static final EnumProperty<EggType> EGG = EnumProperty.create("egg", EggType.class);

    public ChickunaNestBlock(Properties props) {
        super(props);
        this.registerDefaultState(this.stateDefinition.any().setValue(EGG, EggType.NONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(EGG);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        BlockEntity be = level.getBlockEntity(pos);

        if (be instanceof ChickunaNestBlockEntity nest) {
            if (stack.is(ModItems.CHICKUNA_EGG.get())) {
                nest.setEgg(EggType.CHICKUNA);
                if (!player.isCreative()) stack.shrink(1);
                return InteractionResult.SUCCESS;
            } else if (stack.is(ModItems.WILD_CHICKUNA_EGG.get())) {
                nest.setEgg(EggType.WILD);
                if (!player.isCreative()) stack.shrink(1);
                return InteractionResult.SUCCESS;
            } else if (nest.hasEgg()) {
                nest.removeEgg();
                player.addItem(new ItemStack(nest.getEggItem()));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChickunaNestBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
                                                                  BlockEntityType<T> type) {
        return type == ModBlockEntities.CHICKUNA_NEST.get()
                ? (lvl, p, s, be) -> ((ChickunaNestBlockEntity) be).tick()
                : null;
    }
}

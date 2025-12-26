package net.grey.croodstatic.block;

import net.grey.croodstatic.block.entity.ModBlockEntities;
import net.grey.croodstatic.entity.ChickunaEntity;
import net.grey.croodstatic.entity.ModEntities;
import net.grey.croodstatic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ChickunaNestBlockEntity extends BlockEntity{
    private ItemStack egg = ItemStack.EMPTY;
    private int hatchTimer = 0;

    public ChickunaNestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHICKUNA_NEST.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ChickunaNestBlockEntity nest) {
        if (!nest.getEgg().isEmpty()) {
            nest.hatchTimer++;
            if (nest.hatchTimer >= 24000) {
                nest.hatchEgg();
                nest.hatchTimer = 0;
            }
        }
    }


    private void hatchEgg() {
        if (level == null || level.isClientSide) return;

        if (egg.getItem() == ModItems.WILD_CHICKUNA_EGG.get()) {
            ChickunaEntity chickuna = new ChickunaEntity(ModEntities.WILD_CHICKUNA.get(), level);
            chickuna.setBaby(true);
            chickuna.moveTo(worldPosition.getX()+0.5, worldPosition.getY()+1, worldPosition.getZ()+0.5, 0, 0);
            level.addFreshEntity(chickuna);
        } else if (egg.getItem() == ModItems.CHICKUNA_EGG.get()) {
            ChickunaEntity chickuna = new ChickunaEntity(ModEntities.CHICKUNA.get(), level);
            chickuna.setBaby(true);
            chickuna.moveTo(worldPosition.getX()+0.5, worldPosition.getY()+1, worldPosition.getZ()+0.5, 0, 0);
            level.addFreshEntity(chickuna);
        }

        egg = ItemStack.EMPTY;
        setChanged();
    }

    public void setEgg(ItemStack stack) {
        this.egg = stack;
        this.hatchTimer = 0;
        setChanged();
    }

    public ItemStack getEgg() {
        return egg;
    }
}


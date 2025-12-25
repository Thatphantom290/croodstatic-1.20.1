package net.grey.croodstatic.block;

import net.grey.croodstatic.entity.ModEntities;
import net.grey.croodstatic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ChickunaNestBlockEntity extends BlockEntity {
    private int timer = 0;
    private EggType eggType = EggType.NONE;

    public ChickunaNestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHICKUNA_NEST.get(), pos, state);
    }

    public void setEgg(EggType type) {
        this.eggType = type;
        this.timer = 0;
        updateBlockState();
    }

    public void removeEgg() {
        this.eggType = EggType.NONE;
        this.timer = 0;
        updateBlockState();
    }

    private void updateBlockState() {
        level.setBlock(worldPosition, getBlockState().setValue(ChickunaNestBlock.EGG, eggType), 3);
    }

    public void tick() {
        if (eggType != EggType.NONE) {
            timer++;
            if (timer >= 65 * 60 * 20) { // 65 minutos em ticks
                if (eggType == EggType.CHICKUNA) {
                    spawnEntity(ModEntities.CHICKUNA.get());
                } else if (eggType == EggType.WILD) {
                    spawnEntity(ModEntities.WILD_CHICKUNA.get());
                }
                removeEgg();
            }
        }
    }

    private void spawnEntity(EntityType<?> type) {
        Entity entity = type.create(level);
        if (entity != null) {
            entity.moveTo(worldPosition.getX() + 0.5, worldPosition.getY() + 1, worldPosition.getZ() + 0.5, 0, 0);
            level.addFreshEntity(entity);
        }
    }

    public boolean hasEgg() {
        return eggType != EggType.NONE;
    }

    public Item getEggItem() {
        if (eggType == EggType.CHICKUNA) {
            return ModItems.CHICKUNA_EGG.get();
        } else if (eggType == EggType.WILD) {
            return ModItems.WILD_CHICKUNA_EGG.get();
        }
        return Items.AIR;
    }

}

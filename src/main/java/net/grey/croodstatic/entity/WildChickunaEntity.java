package net.grey.croodstatic.entity;

import net.grey.croodstatic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class WildChickunaEntity extends Chicken implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public WildChickunaEntity(EntityType<? extends Chicken> type, Level level) {
        super(type, level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }

    @Override public boolean isFood(ItemStack stack) {
        return stack.is(Items.WHEAT_SEEDS)
                || stack.is(Items.BEETROOT_SEEDS)
                || stack.is(Items.MELON_SEEDS)
                || stack.is(Items.PUMPKIN_SEEDS);
    }

    @Override
    public Chicken getBreedOffspring(ServerLevel level, AgeableMob partner) {
        ItemStack egg;

        if (this instanceof WildChickunaEntity || partner instanceof WildChickunaEntity) {
            egg = new ItemStack(ModItems.WILD_CHICKUNA_EGG.get());
        } else {
            egg = new ItemStack(ModItems.WILD_CHICKUNA_EGG.get());
        }

        level.addFreshEntity(new ItemEntity(level, this.getX(), this.getY(), this.getZ(), egg));

        return null;
    }

    public static boolean canSpawn(EntityType<WildChickunaEntity> entityType,
                                   LevelAccessor world,
                                   MobSpawnType reason,
                                   BlockPos pos,
                                   RandomSource random) {
        return world.getBlockState(pos.below()).isSolid() &&
                world.getRawBrightness(pos, 0) > 8;
    }
}

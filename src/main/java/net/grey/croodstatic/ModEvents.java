package net.grey.croodstatic;

import net.grey.croodstatic.entity.ChickunaEntity;
import net.grey.croodstatic.entity.ModEntities;
import net.grey.croodstatic.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Croodstatic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CHICKUNA.get(), ChickunaEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.CHICKUNA.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ChickunaEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void onBabySpawn(BabyEntitySpawnEvent event) {
        if (event.getParentA() instanceof ChickunaEntity || event.getParentB() instanceof ChickunaEntity) {

            event.setCanceled(true);

            ServerLevel level = (ServerLevel) event.getParentA().level();
            ItemStack egg = new ItemStack(ModItems.CHICKUNA_EGG.get());
            level.addFreshEntity(new ItemEntity(level,
                    event.getParentA().getX(),
                    event.getParentA().getY(),
                    event.getParentA().getZ(),
                    egg));
        }
    }
}


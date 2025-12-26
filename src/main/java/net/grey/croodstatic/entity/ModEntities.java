package net.grey.croodstatic.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "croodstatic");

    public static final RegistryObject<EntityType<ChickunaEntity>> CHICKUNA = ENTITIES.register("chickuna", () -> EntityType.Builder.of(ChickunaEntity::new, MobCategory.CREATURE).sized(0.75F, 0.6F).clientTrackingRange(10).build("chickuna"));

    public static final RegistryObject<EntityType<WildChickunaEntity>> WILD_CHICKUNA = ENTITIES.register("wild_chickuna", () -> EntityType.Builder.of(WildChickunaEntity::new, MobCategory.CREATURE).sized(0.75F, 0.6F).clientTrackingRange(10).build("wild_chickuna"));
}

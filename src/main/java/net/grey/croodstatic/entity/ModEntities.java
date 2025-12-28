package net.grey.croodstatic.entity;

import net.grey.croodstatic.Croodstatic;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Croodstatic.MODID);

    public static final RegistryObject<EntityType<ChickunaEntity>> CHICKUNA =
            ENTITIES.register("chickuna",
                    () -> EntityType.Builder.of(ChickunaEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.0F)
                            .build(Croodstatic.MODID + ":chickuna"));
}

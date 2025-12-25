package net.grey.croodstatic.entity;

import net.grey.croodstatic.Croodstatic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "croodstatic");

    public static final RegistryObject<EntityType<ChickunaEntity>> CHICKUNA =
            ENTITIES.register("chickuna",
                    () -> EntityType.Builder.of(ChickunaEntity::new, MobCategory.CREATURE)
                            .sized(0.4F, 0.7F)
                            .build(new ResourceLocation(Croodstatic.MODID, "chickuna").toString()));

    public static final RegistryObject<EntityType<WildChickunaEntity>> WILD_CHICKUNA =
            ENTITIES.register("wild_chickuna",
                    () -> EntityType.Builder.of(WildChickunaEntity::new, MobCategory.CREATURE)
                            .sized(0.4F, 0.7F)
                            .build(new ResourceLocation(Croodstatic.MODID, "wild_chickuna").toString()));

}

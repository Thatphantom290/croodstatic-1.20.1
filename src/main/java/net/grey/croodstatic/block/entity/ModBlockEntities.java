package net.grey.croodstatic.block.entity;

import net.grey.croodstatic.Croodstatic;
import net.grey.croodstatic.block.ChickunaNestBlockEntity;
import net.grey.croodstatic.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Croodstatic.MODID);

    public static final RegistryObject<BlockEntityType<ChickunaNestBlockEntity>> CHICKUNA_NEST =
            BLOCK_ENTITIES.register("chickuna_nest",
                    () -> BlockEntityType.Builder.of(
                            ChickunaNestBlockEntity::new,
                            ModBlocks.CHICKUNA_NEST.get()
                    ).build(null));
}

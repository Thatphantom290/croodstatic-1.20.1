package net.grey.croodstatic.block;

import net.grey.croodstatic.Croodstatic;
import net.grey.croodstatic.block.custom.MoistGrass;
import net.grey.croodstatic.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraftforge.registries.ForgeRegistries.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Croodstatic.MODID);

    public static final RegistryObject<Block> REDSLATE = registerBlock("redslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> CUT_REDSLATE = registerBlock("cut_redslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> SMOOTH_REDSLATE = registerBlock("smooth_redslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> CHISELED_REDSLATE = registerBlock("chiseled_redslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> REDSLATE_SLAB = registerBlock("redslate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

    public static final RegistryObject<Block> REDSLATE_STAIRS = registerBlock("redslate_stairs",
            () -> new StairBlock(
                    () -> REDSLATE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(REDSLATE.get())));

    public static final RegistryObject<Block> REDSLATE_WALL =
            registerBlock("redslate_wall", () -> new WallBlock(
                    BlockBehaviour.Properties.copy(REDSLATE.get())));

    public static final RegistryObject<Block> GRASSY_MOIST_SOIL = registerBlock("grassy_moist_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> MOIST_SOIL = registerBlock("moist_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> MOIST_GRASS = BLOCKS.register("moist_grass",
            () -> new MoistGrass(BlockBehaviour.Properties.copy(Blocks.GRASS)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

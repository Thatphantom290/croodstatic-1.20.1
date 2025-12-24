package net.grey.croodstatic.item;

import net.grey.croodstatic.Croodstatic;
import net.grey.croodstatic.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Croodstatic.MODID);

    public static final RegistryObject<Item> CHICKUNA_EGG = ITEMS.register("chickuna_egg",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REDSLATE_WALL_ITEM = ITEMS.register("redslate_wall",
            () -> new BlockItem(ModBlocks.REDSLATE_WALL.get(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package net.grey.croodstatic.item;

import net.grey.croodstatic.Croodstatic;
import net.grey.croodstatic.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Croodstatic.MODID);

    public static final RegistryObject<Item> CHICKUNA_EGG = ITEMS.register("chickuna_egg",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WILD_CHICKUNA_EGG = ITEMS.register("wild_chickuna_egg",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHICKUNA_SPAWN_EGG = ITEMS.register("chickuna_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CHICKUNA,
                    0xE5F7E0,
                    0x338F95,
                    new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> WILD_CHICKUNA_SPAWN_EGG = ITEMS.register("wild_chickuna_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WILD_CHICKUNA,
                    0xAF5F40,
                    0x316D63,
                    new Item.Properties().stacksTo(64)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

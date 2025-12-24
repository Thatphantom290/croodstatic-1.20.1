package net.grey.croodstatic.painting;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {

    public static final DeferredRegister<PaintingVariant> PAINTINGS =
            DeferredRegister.create(Registries.PAINTING_VARIANT, "croodstatic");

    public static final RegistryObject<PaintingVariant> RAWR_CANYON =
            PAINTINGS.register("rawr_canyon",
                    () -> new PaintingVariant(32, 32));

    public static void register(IEventBus eventBus) {
        PAINTINGS.register(eventBus);
    }
}

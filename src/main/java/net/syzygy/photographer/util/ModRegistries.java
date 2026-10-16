package net.syzygy.photographer.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.syzygy.photographer.ThePhotographer;
import net.syzygy.photographer.entity.ModEntities;
import net.syzygy.photographer.entity.ShaheerComponents.ShaheerEntity;
import net.syzygy.photographer.event.ShaheerSpawnEvent;

public class ModRegistries {
    public static void registerModStuffs() {
        registerEvents();
        registerAttributes();


        ThePhotographer.LOGGER.info("Registering ModRegistries for " + ThePhotographer.MOD_ID);
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SHAHEER, ShaheerEntity.createAttributes());
    }

    private static void registerEvents() {
        ShaheerSpawnEvent.register();
    }
}

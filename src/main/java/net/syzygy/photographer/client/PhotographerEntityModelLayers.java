package net.syzygy.photographer.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.syzygy.photographer.ThePhotographer;
import net.syzygy.photographer.entity.ShaheerComponents.ShaheerModel;
import net.syzygy.photographer.event.RegisterEntityLayersEvent;

@Environment(EnvType.CLIENT)
public class PhotographerEntityModelLayers {
    public static final EntityModelLayer SHAHEER = new EntityModelLayer(ThePhotographer.makeID("shaheer"), "main");

    public static void registerModEntities() {
        ThePhotographer.LOGGER.info("Registering ModEntities for " + ThePhotographer.MOD_ID);
    }

    public static void registerEntityLayers(RegisterEntityLayersEvent event) {
        event.register(SHAHEER, ShaheerModel::getTexturedModelData);
    }
}

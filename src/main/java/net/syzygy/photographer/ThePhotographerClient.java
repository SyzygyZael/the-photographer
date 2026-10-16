package net.syzygy.photographer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererFactories;
import net.syzygy.photographer.entity.ModEntities;
import net.syzygy.photographer.entity.ShaheerComponents.ShaheerEntity;
import net.syzygy.photographer.entity.ShaheerComponents.ShaheerModel;
import net.syzygy.photographer.entity.ShaheerComponents.ShaheerRenderer;

public class ThePhotographerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ShaheerEntity.SHAHEER, ShaheerModel::getTexturedModelData);
        EntityRendererFactories.register(ModEntities.SHAHEER, ShaheerRenderer::new);
    }
}

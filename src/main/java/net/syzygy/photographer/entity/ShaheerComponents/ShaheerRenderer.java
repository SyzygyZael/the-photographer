package net.syzygy.photographer.entity.ShaheerComponents;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.syzygy.photographer.ThePhotographer;
import net.syzygy.photographer.client.PhotographerEntityModelLayers;

@Environment(EnvType.CLIENT)
public class ShaheerRenderer extends MobEntityRenderer<ShaheerEntity, ShaheerRenderState, ShaheerModel> {
    private static final Identifier TEXTURE = Identifier.of(ThePhotographer.MOD_ID, "textures/entity/shaheer.png");

    public ShaheerRenderer(EntityRendererFactory.Context context) {
        super(context, new ShaheerModel(context.getPart(PhotographerEntityModelLayers.SHAHEER)), 0.0F);
    }

    @Override
    public Identifier getTexture(ShaheerRenderState state) {
        return TEXTURE;
    }

    @Override
    public ShaheerRenderState createRenderState() {
        return new ShaheerRenderState();
    }
}

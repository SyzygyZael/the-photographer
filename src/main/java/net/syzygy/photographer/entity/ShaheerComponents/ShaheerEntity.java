package net.syzygy.photographer.entity.ShaheerComponents;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.syzygy.photographer.ThePhotographer;

public class ShaheerEntity extends Entity {
    public ShaheerEntity(EntityType<? extends Entity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer SHAHEER =
            new EntityModelLayer(Identifier.of(ThePhotographer.MOD_ID, "shaheer"), "main");

    @Override
    public void tick() {
        super.tick();


    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void readCustomData(ReadView view) {

    }

    @Override
    protected void writeCustomData(WriteView view) {

    }
}

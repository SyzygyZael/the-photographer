package net.syzygy.photographer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.syzygy.photographer.ThePhotographer;
import net.syzygy.photographer.entity.ShaheerComponents.ShaheerEntity;

public class ModEntities {
    public static final EntityType<ShaheerEntity> SHAHEER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ThePhotographer.MOD_ID, "shaheer"),
            EntityType.Builder.create(ShaheerEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.0f, 2.0f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(ThePhotographer.MOD_ID, "shaheer"))));

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(ThePhotographer.MOD_ID, name));

        return Registry.register(Registries.ENTITY_TYPE, key, builder.build(key));
    }
}

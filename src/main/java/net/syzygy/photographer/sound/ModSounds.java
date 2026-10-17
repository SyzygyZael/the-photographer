package net.syzygy.photographer.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.syzygy.photographer.ThePhotographer;

public class ModSounds {
    public static final SoundEvent CAMERA_SHUTTER = registerSoundEvent("camera_shutter");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = Identifier.of(ThePhotographer.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSoundEvents() {
        ThePhotographer.LOGGER.info("Registering ModSounds for " + ThePhotographer.MOD_ID);
    }
}
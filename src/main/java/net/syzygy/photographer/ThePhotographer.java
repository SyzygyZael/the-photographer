package net.syzygy.photographer;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.syzygy.photographer.entity.ModEntities;
import net.syzygy.photographer.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThePhotographer implements ModInitializer {
	public static final String MOD_ID = "the-photographer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModEntities.registerModEntites();
		ModRegistries.registerModStuffs();
	}

	public static Identifier makeID(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

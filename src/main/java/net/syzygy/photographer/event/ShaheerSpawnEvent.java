package net.syzygy.photographer.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.syzygy.photographer.ThePhotographer;
import net.syzygy.photographer.entity.ModEntities;
import net.syzygy.photographer.entity.ShaheerComponents.ShaheerEntity;

public class ShaheerSpawnEvent {
    private static int spawnCooldown = 0;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerWorld world : server.getWorlds()) {
                for (ServerPlayerEntity player : world.getPlayers()) {
                    trySpawnNearPlayer(world, player);
                }
            }
        });
    }

    private static void trySpawnNearPlayer(ServerWorld world, ServerPlayerEntity player) {
        if (spawnCooldown > 0) {
            spawnCooldown--;
            return;
        }
        spawnCooldown = 200;

        ThePhotographer.LOGGER.info("Attempting Shaheer Spawn...");

        if (!yourCondition(world, player)) return;
        if (hasExistingShaheer(world, player)) return;

        double angle = world.random.nextDouble() * Math.PI * 2;
        double distance = 14;
        double x = player.getX() + Math.cos(angle) * distance;
        double z = player.getZ() + Math.sin(angle) * distance;
        double y = player.getY();

        BlockPos spawnPos = new BlockPos((int) x, (int) y, (int) z);

        // if (!world.isChunkLoaded(spawnPos)) return;
        // if (!world.getBlockState(spawnPos).isAir()) return;
        // if (!world.getBlockState(spawnPos.down()).isSolidBlock(world, spawnPos.down())) return;

        if (world.getBlockState(spawnPos.up(1)).isSolidBlock(world, spawnPos.up(1))) {
            ThePhotographer.LOGGER.info("Failed Reason: Invalid spawn location");
            return;
        }
        if (world.getBlockState(spawnPos.up(2)).isSolidBlock(world, spawnPos.up(2))) {
            ThePhotographer.LOGGER.info("Failed Reason: Invalid spawn location");
            return;
        }

        ShaheerEntity shaheer = ModEntities.SHAHEER.create(world, SpawnReason.EVENT);
        if (shaheer != null) {
            ThePhotographer.LOGGER.info("Success!");

            double dx = player.getX() - x;
            double dz = player.getZ() - z;
            float yaw = (float) Math.toDegrees(Math.atan2(dz, dx)) - 90f;

            shaheer.refreshPositionAndAngles(x, y, z, yaw, 0);
            world.spawnEntity(shaheer);
        }
    }

    private static boolean yourCondition(ServerWorld world, ServerPlayerEntity player) {
        int randSpawn = (int) (Math.random() * 25) + 1;
        boolean isNight = world.isNight();

        if (randSpawn != 15) ThePhotographer.LOGGER.info("Failed Reason: Incorrect randSpawn value::" + randSpawn);
        if (!isNight) ThePhotographer.LOGGER.info("Failed Reason: Not night time");

        return (isNight && randSpawn == 15);
    }

    private static boolean hasExistingShaheer(ServerWorld world, ServerPlayerEntity player) {
        Box searchBox = Box.of(player.getEntityPos(), 100, 100, 100); // search radius
        return !world.getEntitiesByType(
                ModEntities.SHAHEER,
                searchBox,
                entity -> true
        ).isEmpty();
    }
}

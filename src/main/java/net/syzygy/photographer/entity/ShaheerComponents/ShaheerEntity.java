package net.syzygy.photographer.entity.ShaheerComponents;

import net.minecraft.block.Blocks;
import net.minecraft.block.LightBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.syzygy.photographer.ThePhotographer;
import org.jspecify.annotations.Nullable;

public class ShaheerEntity extends AnimalEntity {
    private int lightTimer = 40;
    private BlockPos lastLightPos = null;
    private int flashNum = 0;

    public ShaheerEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer SHAHEER =
            new EntityModelLayer(Identifier.of(ThePhotographer.MOD_ID, "shaheer"), "main");

    @Override
    protected void initGoals() {
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.FOLLOW_RANGE, (double)32.0F)
                .add(EntityAttributes.MOVEMENT_SPEED, (double)0.30F)
                .add(EntityAttributes.ATTACK_DAMAGE, (double) 0.0F)
                .add(EntityAttributes.ARMOR, (double)3.0F)
                .add(EntityAttributes.MAX_HEALTH, (double)30.0F);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getEntityWorld().isClient() && this.getEntityWorld() instanceof ServerWorld serverWorld) {
            PlayerEntity nearestPlayer = this.getEntityWorld().getClosestPlayer(this, 32);

            if (nearestPlayer != null) {
                double dx = nearestPlayer.getX() - this.getX();
                double dz = nearestPlayer.getZ() - this.getZ();
                float yaw = (float) Math.toDegrees(Math.atan2(dz, dx)) - 90f;
                this.setYaw(yaw);
                this.setHeadYaw(yaw);
                this.setBodyYaw(yaw);

                if (nearestPlayer.squaredDistanceTo(this) <= 64 || nearestPlayer.squaredDistanceTo(this) >= 625) {
                    this.discard();
                }

                if (lightTimer > 0 && flashNum < 1) {
                    lightTimer--;

                    BlockPos currentPos = this.getBlockPos().up((int) this.getHeight() + 1);

                    if (!currentPos.equals(lastLightPos)) {
                        if (lastLightPos != null) removeLight(serverWorld, lastLightPos);
                        placeLight(serverWorld, currentPos, 15);
                        lastLightPos = currentPos;
                    }

                    // timer expired, remove the light
                    if (lightTimer == 0 && lastLightPos != null) {
                        removeLight(serverWorld, lastLightPos);
                        lastLightPos = null;
                        this.flashNum++;
                        this.lightTimer = 20;
                    }
                } else if (lightTimer > 0 && flashNum >= 1) {
                    lightTimer--;

                    BlockPos currentPos = this.getBlockPos().up((int) this.getHeight() + 1);

                    if (!currentPos.equals(lastLightPos)) {
                        if (lastLightPos != null) removeLight(serverWorld, lastLightPos);
                        placeLight(serverWorld, currentPos, 15);
                        lastLightPos = currentPos;
                    }

                    // timer expired, remove the light
                    if (lightTimer == 0 && lastLightPos != null) {
                        nearestPlayer.damage(serverWorld, this.getEntityWorld().getDamageSources().mobAttack(this), 7.0f);
                        removeLight(serverWorld, lastLightPos);
                        lastLightPos = null;
                    }
                }
            }
        }
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public void onRemoved() {
        super.onRemoved();
        if (!this.getEntityWorld().isClient() && lastLightPos != null && this.getEntityWorld() instanceof ServerWorld serverWorld) {
            removeLight(serverWorld, lastLightPos);
        }
    }

    private void placeLight(ServerWorld world, BlockPos pos, int lightLevel) {
        if (world.getBlockState(pos).isAir()) {
            world.setBlockState(pos, Blocks.LIGHT.getDefaultState()
                    .with(LightBlock.LEVEL_15, lightLevel));
        }
    }

    private void removeLight(ServerWorld world, BlockPos pos) {
        if (world.getBlockState(pos).isOf(Blocks.LIGHT)) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }
}

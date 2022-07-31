package dev.hugeblank.gatekeep.block;

import dev.hugeblank.gatekeep.util.Reporter;
import net.minecraft.block.WeightedPressurePlateBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SnitchPressurePlate extends WeightedPressurePlateBlock {
    private static final int weight = 15;

    public SnitchPressurePlate(Settings settings) {
        super(weight, settings);
    }

    @Override
    protected int getRedstoneOutput(World world, BlockPos pos) {
        var players = world.getNonSpectatingEntities(PlayerEntity.class, BOX.offset(pos));
        int out = 0;
        for (PlayerEntity player : players) {
            if (!player.getWorld().isClient()) {
                out += ((Reporter) player).gatekeep$getReported();
            }
        }
        return MathHelper.clamp(out, 0, weight);
    }

}

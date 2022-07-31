package dev.hugeblank.gatekeep.mixin;

import dev.hugeblank.gatekeep.util.Reporter;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin implements Reporter {
    private int reported = 0;

    public void gatekeep$incrementReported() {
        reported++;
    }

    public int gatekeep$getReported() {
        return reported;
    }
}

package dev.hugeblank.gatekeep.mixin;

import dev.hugeblank.gatekeep.network.ClientPacketHandler;
import dev.hugeblank.gatekeep.network.GatekeepPackets;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.multiplayer.SocialInteractionsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SocialInteractionsScreen.class)
public class SocialInteractionsScreenMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void gatekeep$iAmADeveloperPretendingThatISnitched(CallbackInfo ci) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            ClientPacketHandler.send(GatekeepPackets.PLAYER_REPORT);
        }
    }
}

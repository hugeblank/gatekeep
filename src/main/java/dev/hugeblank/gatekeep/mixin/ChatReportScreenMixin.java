package dev.hugeblank.gatekeep.mixin;

import dev.hugeblank.gatekeep.network.ClientPacketHandler;
import dev.hugeblank.gatekeep.network.GatekeepPackets;
import net.minecraft.client.gui.screen.report.ChatReportScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatReportScreen.class)
public class ChatReportScreenMixin {
    @Inject(at = @At("HEAD"), method = "onSubmissionFinished()V")
    private void gatekeep$iSnitched(CallbackInfo ci) {
        // Rule 69 of minecraft. If it exists as a feature, it will be used in a mod.

        ClientPacketHandler.send(GatekeepPackets.PLAYER_REPORT);
    }
}

package dev.hugeblank.gatekeep.network;

import dev.hugeblank.gatekeep.util.Reporter;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ServerPacketHandler {
    public static void register(Identifier id) {
        ServerPlayNetworking.registerGlobalReceiver(id, ServerPacketHandler::accept);
    }

    private static void accept(MinecraftServer server, ServerPlayerEntity serverPlayerEntity, ServerPlayNetworkHandler serverPlayNetworkHandler, PacketByteBuf buffer, PacketSender packetSender) {
        ((Reporter) serverPlayerEntity).gatekeep$incrementReported();
    }
}

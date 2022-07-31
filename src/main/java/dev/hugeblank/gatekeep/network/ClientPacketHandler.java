package dev.hugeblank.gatekeep.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class ClientPacketHandler {
    public static void send(Identifier packetID) {
        // Literally *just* send a single empty packet on player report. No need to feed any other details to server.
        // Technically I could be an ass and send the specific player that got reported and do a *whole* lot worse.
        // Look forward to that being featured at ModFest singularity! ;D
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ClientPlayNetworking.send(packetID, buf);
    }
}
package dev.hugeblank.gatekeep;

import dev.hugeblank.gatekeep.block.SnitchPressurePlate;
import dev.hugeblank.gatekeep.network.GatekeepPackets;
import dev.hugeblank.gatekeep.network.ServerPacketHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// Gatekeep - by hugeblank - July 2022
// The reason I won't get hired by Mojang.
// Adds a "snitch pressure plate" that outputs a redstone signal equivalent to the amount of player reports sent,
// to a max of 15 reported players.
public class Gatekeep implements ModInitializer {
    public static final String ID = "gatekeep";

    public static final Block SNITCH_PRESSURE_PLATE = new SnitchPressurePlate(FabricBlockSettings.copyOf(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE));
    public static final Item SNITCH_PRESSURE_PLATE_ITEM = new BlockItem(SNITCH_PRESSURE_PLATE, new FabricItemSettings().group(ItemGroup.REDSTONE));

    @Override
    public void onInitialize() {
        Identifier snitch_pressure_plate = new Identifier(ID, "snitch_pressure_plate");
        Registry.register(Registry.BLOCK, snitch_pressure_plate, SNITCH_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, snitch_pressure_plate, SNITCH_PRESSURE_PLATE_ITEM);

        ServerPacketHandler.register(GatekeepPackets.PLAYER_REPORT);
    }
}

package afrocraft.afrocraft;

import afrocraft.afrocraft.item.ModItems;
import afrocraft.afrocraft.block.ModBlocks;
import afrocraft.afrocraft.sound.ModSounds;
import afrocraft.afrocraft.util.ModCustomTrades;
import afrocraft.afrocraft.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AfroCraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "afrocraft";
    public static final Logger LOGGER = LoggerFactory.getLogger("afrocraft");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("AfroCraft Initilazing...");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();

		ModSounds.registerModSounds();
	}
}
package afrocraft.afrocraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static afrocraft.afrocraft.block.ModBlocks.WEED_CROP;

public class AfroCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		// allow this block to have transparent cutouts
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WEED_CROP);
	}
}
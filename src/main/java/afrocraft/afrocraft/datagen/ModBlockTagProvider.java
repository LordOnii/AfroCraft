package afrocraft.afrocraft.datagen;

import afrocraft.afrocraft.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//    getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR)
//            .add(ModBlocks.WEED_CROP)
//            .forceAddTag(BlockTags.COAL_ORES)
//            .forceAddTag(BlockTags.EMERALD_ORES)
//            .forceAddTag(BlockTags.COPPER_ORES)
//            .forceAddTag(BlockTags.DIAMOND_ORES)
//            .forceAddTag(BlockTags.GOLD_ORES)
//            .forceAddTag(BlockTags.IRON_ORES)
//            .forceAddTag(BlockTags.REDSTONE_ORES)
//            .forceAddTag(BlockTags.LAPIS_ORES)
//    ;
    }
}

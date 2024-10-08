package afrocraft.afrocraft.datagen;

import afrocraft.afrocraft.AfroCraft;
import afrocraft.afrocraft.block.ModBlocks;
import afrocraft.afrocraft.block.custom.WeedCrop;
import afrocraft.afrocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.sound.SoundEvents;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.WEED_CROP, WeedCrop.AGE, 0, 1, 2, 3, 3, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        AfroCraft.LOGGER.info("Generating items models");
        itemModelGenerator.register(ModItems.BLUNT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEED , Models.GENERATED);
        // itemModelGenerator.register(ModItems.WEED_SEEDS , Models.GENERATED); because AliasedBlockItem probably
        itemModelGenerator.register(ModItems.BAKED_CARROT , Models.GENERATED);
        itemModelGenerator.register(ModItems.HYMN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRAZY_RAP_MUSIC_DISC, Models.GENERATED);

    }
}

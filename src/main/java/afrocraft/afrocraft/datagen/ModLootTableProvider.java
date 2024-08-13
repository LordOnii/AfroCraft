package afrocraft.afrocraft.datagen;

import afrocraft.afrocraft.block.ModBlocks;
import afrocraft.afrocraft.block.custom.WeedCrop;
import afrocraft.afrocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // add block for it to be drop when broken
        addDrop(Blocks.DIAMOND_BLOCK);

        // for specific item drop
        addDrop(
                Blocks.DIAMOND_ORE,
                oreDrops(Blocks.DIAMOND_ORE, Items.DIAMOND)
        );

        addWeedCropDrops();
    }

    private void addWeedCropDrops() {
        LootTable.Builder builder = new LootTable.Builder();
        // Add the main crop drop
        builder.pool(
                LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(
                                BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP)
                                        .properties(StatePredicate.Builder.create().exactMatch(WeedCrop.AGE, 5))
                        )
                        .with(ItemEntry.builder(ModItems.WEED))
        );
        // Add the seeds drop
        builder.pool(
                LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(0, 2))
                        .conditionally(
                                BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP)
                                        .properties(StatePredicate.Builder.create().exactMatch(WeedCrop.AGE, 5))
                        )
                        .with(ItemEntry.builder(ModItems.WEED_SEEDS))
        );

        // Register the loot table
        this.addDrop(ModBlocks.WEED_CROP, builder);
    }

}

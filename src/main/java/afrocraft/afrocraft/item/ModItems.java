package afrocraft.afrocraft.item;

import afrocraft.afrocraft.AfroCraft;
import afrocraft.afrocraft.block.ModBlocks;
import afrocraft.afrocraft.item.custom.Blunt;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item BAKED_CARROT = registerItem("baked_carrot",
            new Item(
                    new Item.Settings()
                    .food(new FoodComponent
                        .Builder()
                        .nutrition(7)
                        .saturationModifier(0.8F)
                        .build()
                    )
            ),
            true
    );

    public static final Item WEED_SEEDS = registerItem("weed_seeds",
            new AliasedBlockItem(
                    ModBlocks.WEED_CROP, new Item.Settings()
            ),
            true
    );

    public static final Item WEED = registerItem("weed",
            new Item(new Item.Settings()),
            true
    );

    // TODO
    public static final Item BLUNT = registerItem("blunt",
            new Blunt(new Item.Settings().maxCount(1)),
            true
    );

    public static Item registerItem(String name, Item item, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(AfroCraft.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            Item itemRegister = new Item(new Item.Settings());
            Registry.register(Registries.ITEM, id, itemRegister);
        }

        return Registry.register(Registries.ITEM, id, item);
    }
    public static void registerModItems() {

        /* Register items in creative groups */

        // baked_carrot
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.BAKED_CARROT));

        // weed_seeds
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> itemGroup.add(ModItems.WEED_SEEDS));

        // weed
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.WEED));

        // blunt
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.BLUNT));



        AfroCraft.LOGGER.info("Registering Mod Items for " + AfroCraft.MOD_ID);
    }
}
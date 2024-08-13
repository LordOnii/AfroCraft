package afrocraft.afrocraft.item;

import afrocraft.afrocraft.AfroCraft;
import afrocraft.afrocraft.block.ModBlocks;
import afrocraft.afrocraft.item.custom.Blunt;
import afrocraft.afrocraft.sound.ModJukeboxSongs;
import afrocraft.afrocraft.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.MusicType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    public static final Item BAKED_CARROT = registerItem(
            "baked_carrot",
            new Item(
                    new Item.Settings()
                    .food(new FoodComponent
                        .Builder()
                        .nutrition(7)
                        .saturationModifier(0.8F)
                        .build()
                    )
            )
    );

    public static final Item WEED_SEEDS = registerItem(
            "weed_seeds",
            new AliasedBlockItem(
                    ModBlocks.WEED_CROP, new Item.Settings()
            )
    );

    public static final Item WEED = registerItem(
            "weed",
            new Item(new Item.Settings())
    );

    public static final Item BLUNT = registerItem(
            "blunt",
            new Blunt(new Item.Settings().maxCount(1))
    );

    public static final Item HYMN_MUSIC_DISC = registerItem(
            "hymn_music_disc",
            new Item((new Item.Settings()).maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.HYMN))
    );

    public static Item registerItem(String name, Item item) {
        if (item != null) {
            Identifier id = Identifier.of(AfroCraft.MOD_ID, name);
            return Registry.register(Registries.ITEM, id, item);
        }
        return null;
    }

    public static void registerModItems() {

        /* Register items in creative groups */

        //  baked_carrot
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
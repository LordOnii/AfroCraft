package afrocraft.afrocraft.villager;

import afrocraft.afrocraft.AfroCraft;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> DEALER_POI_KEY = poiKey("dealerpoi");
    public static final PointOfInterestType DEALER_POI = registerPoi("dealerpoi", Blocks.BAMBOO_BLOCK);

    public static final VillagerProfession DEALER = registerProfession("dealer", DEALER_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        Identifier id = Identifier.of(AfroCraft.MOD_ID, name);

        VillagerProfession profession = new VillagerProfession(
            name,
            entry -> entry.matchesKey(type),
            entry -> entry.matchesKey(type),
            ImmutableSet.of(),
            ImmutableSet.of(),
            SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD
        );
        return Registry.register(Registries.VILLAGER_PROFESSION, id, profession);
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(
                Identifier.of(AfroCraft.MOD_ID, name),
                1,
                1,
                block
        );
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(
                RegistryKeys.POINT_OF_INTEREST_TYPE,
                Identifier.of(AfroCraft.MOD_ID, name)
        );
    }

    public static void registerVillagers() {
        AfroCraft.LOGGER.info("Registering Mod Villagers for " + AfroCraft.MOD_ID);
    }
}

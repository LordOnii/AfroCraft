package afrocraft.afrocraft.sound;

import afrocraft.afrocraft.AfroCraft;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent HYMN = registerSoundEvent("hymn");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(AfroCraft.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        AfroCraft.LOGGER.info("Registering Mod Sounds for " + AfroCraft.MOD_ID);
    }
}

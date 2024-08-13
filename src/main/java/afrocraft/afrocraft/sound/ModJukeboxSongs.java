package afrocraft.afrocraft.sound;

import afrocraft.afrocraft.AfroCraft;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModJukeboxSongs {

    public static final RegistryKey<JukeboxSong> HYMN = of("hymn");
    public static final RegistryKey<JukeboxSong> CRAZY_RAP = of("crazy_rap");

    private static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(AfroCraft.MOD_ID, id));
    }


    public static void registerModJukeboxSounds() {
        AfroCraft.LOGGER.info("Registering Mod Jukebox Songs for " + AfroCraft.MOD_ID);
    }
}

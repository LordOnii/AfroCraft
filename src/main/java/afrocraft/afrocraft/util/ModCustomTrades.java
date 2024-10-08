package afrocraft.afrocraft.util;

import afrocraft.afrocraft.item.ModItems;
import afrocraft.afrocraft.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(
                ModVillagers.DEALER,
                1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 2),
                            new ItemStack(ModItems.WEED, 5),
                            6,
                            10,
                            0.2f
                    ));
                }
        );
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.FARMER,
                1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 2),
                            new ItemStack(ModItems.WEED, 5),
                            6,
                            10,
                            0.2f
                    ));
                }
        );
    }
}

package afrocraft.afrocraft.datagen;

import afrocraft.afrocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, List.of(Items.CARROT), RecipeCategory.FOOD, ModItems.BAKED_CARROT, 0.7f, 200, "food");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUNT)
                .pattern("WWW")
                .pattern("PPP")
                .input('W', ModItems.WEED)
                .input('P', Items.PAPER)
                .criterion(hasItem(ModItems.WEED), conditionsFromItem(ModItems.WEED))
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BLUNT)));
    }
}

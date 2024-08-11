package afrocraft.afrocraft.item.custom;

import afrocraft.afrocraft.AfroCraft;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class Blunt extends Item {
    public Blunt(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        Hand otherHand = hand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
        ItemStack otherHandStack = user.getStackInHand(otherHand);

        if (!otherHandStack.isOf(Items.FLINT_AND_STEEL)) {
            return TypedActionResult.fail(itemStack);
        }

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300));
            AfroCraft.LOGGER.info("Player {} is smoking...", user.getName().getString());

            // Optionally consume the item
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
                EquipmentSlot EquipmentSlotOtherHand = otherHand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                otherHandStack.damage(1, user, EquipmentSlotOtherHand);
            }

        }

        // Play a using sound and animation
        user.playSound(SoundEvents.ITEM_FLINTANDSTEEL_USE);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW; // This will make the player do an "eating" animation
    }
}

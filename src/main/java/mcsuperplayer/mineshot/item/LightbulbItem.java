package mcsuperplayer.mineshot.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightbulbItem extends MineShotItem {

	public LightbulbItem(Properties pProperties) {
		super(pProperties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
		if (!level.isClientSide()) {
			MobEffectInstance currentEffect = player.getEffect(MobEffects.NIGHT_VISION);
			if (currentEffect == null || currentEffect.getDuration() <= 210) {
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
			}
		}

		super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
	}
}
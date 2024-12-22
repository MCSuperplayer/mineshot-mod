package mcsuperplayer.mineshot.integration.curios;

import mcsuperplayer.mineshot.item.LightbulbItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class LightbulbCurioItem extends LightbulbItem implements ICurioItem {

	public LightbulbCurioItem(Properties properties) {
		super(properties);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		LivingEntity entity = slotContext.entity();
		MobEffectInstance currentEffect = entity.getEffect(MobEffects.NIGHT_VISION);
		if (currentEffect == null || currentEffect.getDuration() <= 210) {
			entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
		}
	}

}

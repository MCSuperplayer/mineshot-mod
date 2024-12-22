package mcsuperplayer.mineshot.item;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class MineShotItem extends Item {

	public MineShotItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		components.add(Component.translatable(stack.getDescriptionId() + "_desc"));
		super.appendHoverText(stack, level, components, flag);
	}

}

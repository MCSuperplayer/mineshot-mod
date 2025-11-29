package io.github.mcsuperplayer.mineshot.item;

import java.util.List;

import io.github.mcsuperplayer.mineshot.event.ServerEventHandler;
import io.github.mcsuperplayer.mineshot.recipe.MineShotCombinationRecipe;
import io.github.mcsuperplayer.mineshot.recipe.MineShotCombinationRecipe.recipes;
import io.github.mcsuperplayer.mineshot.recipe.MineShotInteractionRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MineShotItem extends Item {

	public MineShotItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, @NotNull TooltipFlag flag) {
		components.add(Component.translatable(stack.getDescriptionId() + "_desc"));
		super.appendHoverText(stack, level, components, flag);
	}

	@Override
	public @NotNull InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();
		Level level = context.getLevel();
		if (level.isClientSide) {
			return InteractionResult.FAIL;
		}
		MineShotInteractionRecipe interaction = MineShotInteractionRecipe.getRecipe(context);
		if(interaction != null) {
			interaction.action.context = context;
			ServerEventHandler.scheduleAction(interaction.action);
			return InteractionResult.SUCCESS;
		}

        //noinspection ConstantConditions
		recipes recipe = MineShotCombinationRecipe.getRecipe(player.getItemInHand(InteractionHand.MAIN_HAND).getItem(), player.getItemInHand(InteractionHand.OFF_HAND).getItem());
		if (recipe != null) {
			MineShotCombinationRecipe.combine(player, recipe.input, recipe.secondary, recipe.output, recipe.remainder,
					recipe.message, recipe.voice, recipe.display);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;

	}
}

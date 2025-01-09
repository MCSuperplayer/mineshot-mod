package mcsuperplayer.mineshot.recipe;

import mcsuperplayer.mineshot.command.TextEngineCommand;
import mcsuperplayer.mineshot.command.TextEngineCommand.displaytype;
import mcsuperplayer.mineshot.command.TextEngineCommand.voicetype;
import mcsuperplayer.mineshot.event.CommandAction;
import mcsuperplayer.mineshot.event.DelayedAction;
import mcsuperplayer.mineshot.event.ItemTransformAction;
import mcsuperplayer.mineshot.init.BlockInit;
import mcsuperplayer.mineshot.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class MineShotInteractionRecipe {
	public static MineShotInteractionRecipe[] RECIPES = {
			new MineShotInteractionRecipe(ItemInit.ITEM_CROWBAR.get(), Blocks.CHEST, // TODO: replace with Locked Box
					new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON, displaytype.SUBTITLE, Component.translatable("mineshot.dialogue.batterybox_open").getString()), 0,
					new ItemTransformAction(ItemInit.ITEM_BATTERY_BROKEN.get(), 0,
					new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON, displaytype.SUBTITLE, Component.translatable("mineshot.dialogue.batterybox_open_2").getString()), 120)))),
			new MineShotInteractionRecipe(ItemInit.ITEM_BRANCH_WET.get(), BlockInit.COMPUTER.get(),
					new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON, displaytype.SUBTITLE, Component.translatable("mineshot.dialogue.light_branch").getString()), 0,
					new ItemTransformAction(ItemInit.ITEM_TORCH.get(), 0)))
	};
	public Item useItem;
	public Block hitBlock;
	public DelayedAction action;

	public MineShotInteractionRecipe(Item useitem, Block hitblock, DelayedAction action) {
		this.useItem = useitem;
		this.hitBlock = hitblock;
		this.action = action;
	}

	public static MineShotInteractionRecipe getRecipe(UseOnContext context) {
		for (MineShotInteractionRecipe recipe : RECIPES) {
			if (recipe.useItem == context.getItemInHand().getItem()
					&& recipe.hitBlock == context.getLevel().getBlockState(context.getClickedPos()).getBlock()) {
				recipe.action.context = context;
				return recipe;
			}
		}
		return null;
	}
}

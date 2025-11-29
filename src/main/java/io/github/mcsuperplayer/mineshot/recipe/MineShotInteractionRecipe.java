package io.github.mcsuperplayer.mineshot.recipe;

import io.github.mcsuperplayer.mineshot.command.TextEngineCommand;
import io.github.mcsuperplayer.mineshot.command.TextEngineCommand.displaytype;
import io.github.mcsuperplayer.mineshot.command.TextEngineCommand.voicetype;
import io.github.mcsuperplayer.mineshot.event.CommandAction;
import io.github.mcsuperplayer.mineshot.event.DelayedAction;
import io.github.mcsuperplayer.mineshot.event.ItemTransformAction;
import io.github.mcsuperplayer.mineshot.init.BlockInit;
import io.github.mcsuperplayer.mineshot.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class MineShotInteractionRecipe {
	public static MineShotInteractionRecipe[] RECIPES = {
			new MineShotInteractionRecipe(ItemInit.ITEM_CROWBAR.get(), Blocks.CHEST, // TODO: replace with Locked Box
					new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON, displaytype.SUBTITLE, Component.translatable("text.mineshot.dialogue.batterybox_open").getString()), 0,
					new ItemTransformAction(ItemInit.ITEM_BATTERY_BROKEN.get(), 0,
					new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON, displaytype.SUBTITLE, Component.translatable("text.mineshot.dialogue.batterybox_contents").getString()), 120,
                    new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON, displaytype.SUBTITLE, Component.translatable("text.mineshot.dialogue.batterybox_contents2").getString()),120,
                    new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON, displaytype.SUBTITLE, Component.translatable("text.mineshot.dialogue.batterybox_contents3").getString()),120)))))),
			new MineShotInteractionRecipe(ItemInit.ITEM_BRANCH_WET.get(), BlockInit.COMPUTER.get(),
					new CommandAction(TextEngineCommand.textengineCommandString(voicetype.SILENT, displaytype.SUBTITLE, Component.translatable("text.mineshot.dialogue.ready_branch").getString()), 0,
					new ItemTransformAction(ItemInit.ITEM_TORCH.get(), 20,
                    new CommandAction(TextEngineCommand.textengineCommandString(voicetype.PERSON,displaytype.SUBTITLE,Component.translatable("text.mineshot.dialogue.torch_ah").getString()),0))))
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

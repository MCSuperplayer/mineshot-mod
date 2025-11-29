package io.github.mcsuperplayer.mineshot.recipe;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import io.github.mcsuperplayer.mineshot.MineShot;
import io.github.mcsuperplayer.mineshot.command.TextEngineCommand.displaytype;
import io.github.mcsuperplayer.mineshot.command.TextEngineCommand.voicetype;
import io.github.mcsuperplayer.mineshot.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class MineShotCombinationRecipe {

	public enum messages {
		EMPTY(""),
		ALCOHOLBRANCH("Niko dips the branch into the alcohol."),
		LENSPULL("Use the screwdriver to ... pull the lens out...?  Okay...   Done!"),
		LENSPUT(""),
		CHARGE(""),
		BOTTLED_WATER(""),
		ACID_BOTTLE(""), 
		WET_SPONGE(""),
		FEATHER_PEN(""),
		BUTTON(""),
		MAGNET_BUTTON(""),
		GLUE_PHOTO(""),
		GLUE_PHOTO_NO(""),
		STICKY_PHOTO_CARD(""),
		STICKY_CARD(""),
		STICKY_CARD_PHOTO(""),
		MEDICATED_WATER("");
		public String msg;

		messages(String msg) {
			this.msg = msg;
		}
	}

	public enum recipes {
		ALCOHOL_BOTTLE_BRANCH(ItemInit.ITEM_ALCOHOL_BOTTLE.get(), ItemInit.ITEM_BRANCH.get(), ItemInit.ITEM_BOTTLE.get(), ItemInit.ITEM_BRANCH_WET.get(), messages.ALCOHOLBRANCH, voicetype.SILENT, displaytype.SUBTITLE),
		CAMERA_LENSREMOVE(ItemInit.ITEM_CAMERA.get(), ItemInit.ITEM_SCREWDRIVER.get(), ItemInit.ITEM_LENS.get(), Items.AIR, messages.LENSPULL, voicetype.PERSON, displaytype.HOTBAR),
		LENS_IN_BATTERY(ItemInit.ITEM_LENS.get(), ItemInit.ITEM_BATTERY_BROKEN.get(), Items.AIR, ItemInit.ITEM_BATTERY_EMPTY.get(), messages.LENSPUT, voicetype.PERSON, displaytype.HOTBAR),
		BATTERY_CHARGE(ItemInit.ITEM_BATTERY_EMPTY.get(), ItemInit.ITEM_LIGHTBULB.get(), ItemInit.ITEM_BATTERY_CHARGED.get(), ItemInit.ITEM_LIGHTBULB.get(), messages.CHARGE, voicetype.PERSON, displaytype.HOTBAR),
		BOTTLE_WITH_WATER(ItemInit.ITEM_BOTTLE.get(), ItemInit.ITEM_FILLED_SYRINGE.get(),ItemInit.ITEM_POND_WATER_BOTTLE.get(), ItemInit.ITEM_EMPTY_SYRINGE.get(), messages.BOTTLED_WATER,voicetype.PERSON, displaytype.HOTBAR),
		ACID_BOTTLE(ItemInit.ITEM_SMOKE_BOTTLE.get(), ItemInit.ITEM_FILLED_SYRINGE.get(), ItemInit.ITEM_BOTTLE.get(), ItemInit.ITEM_EMPTY_SYRINGE.get(), messages.ACID_BOTTLE, voicetype.PERSON, displaytype.HOTBAR),
		WET_SPONGE(ItemInit.ITEM_SPONGE.get(), ItemInit.ITEM_ACID_BOTTLE.get(), ItemInit.ITEM_WET_SPONGE.get(), ItemInit.ITEM_BOTTLE.get(), messages.WET_SPONGE, voicetype.PERSON, displaytype.HOTBAR),
		FEATHER_PEN(ItemInit.ITEM_FEATHER.get(), ItemInit.ITEM_DYE_BOTTLE.get(), ItemInit.ITEM_FEATHER_PEN.get(), Items.AIR, messages.FEATHER_PEN, voicetype.PERSON, displaytype.HOTBAR),
		BUTTON(ItemInit.ITEM_METAL_CAN.get(), ItemInit.ITEM_SCISSORS.get(), ItemInit.ITEM_BUTTON.get(), Items.AIR, messages.BUTTON, voicetype.PERSON, displaytype.HOTBAR),
		MAGNET_BUTTON(ItemInit.ITEM_BUTTON.get(), ItemInit.ITEM_MAGNETS.get(), ItemInit.ITEM_MAGNETIZED_BUTTON.get(), Items.AIR, messages.MAGNET_BUTTON, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_1(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO1.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_2(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO2.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_3(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO3.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_4(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO4.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_5(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO5.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_6(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO_FAIL.get(), ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO_FAIL.get(), messages.GLUE_PHOTO_NO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_7(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO7.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_8(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO8.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_9(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO9.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		GLUE_PHOTO_10(ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_PHOTO10.get(), Items.AIR, ItemInit.ITEM_PHOTO_GLUE.get(), messages.GLUE_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_PHOTO_CARD(ItemInit.ITEM_LIBRARY_CARD.get(), ItemInit.ITEM_PHOTO_GLUE.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_PHOTO_CARD, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD(ItemInit.ITEM_LIBRARY_CARD.get(), ItemInit.ITEM_GLITTER_GLUE.get(), ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), Items.AIR, messages.STICKY_CARD, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_1(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO1.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_2(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO2.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_3(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO3.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_4(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO4.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_5(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO5.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_6(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO_FAIL.get(), ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO_FAIL.get(), messages.GLUE_PHOTO_NO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_7(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO7.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_8(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO8.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_9(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO9.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		STICKY_CARD_PHOTO_10(ItemInit.ITEM_LIBRARY_CARD_GLUE.get(), ItemInit.ITEM_PHOTO10.get(), ItemInit.ITEM_LIBRARY_CARD_NIKO.get(), Items.AIR, messages.STICKY_CARD_PHOTO, voicetype.PERSON, displaytype.HOTBAR),
		MEDICATED_WATER(ItemInit.ITEM_WATER_TUBE.get(), ItemInit.ITEM_WATER_PILL.get(), ItemInit.ITEM_MEDICATED_WATER.get(), Items.AIR, messages.MEDICATED_WATER, voicetype.PERSON, displaytype.HOTBAR);

		public Item input;
		public Item secondary;
		public Item output;
		public Item remainder;
		public messages message;
		public voicetype voice;
		public displaytype display;

		recipes(Item input, Item secondary, Item output, Item remainder, messages msg, voicetype voice, displaytype display) {
			this.input = input;
			this.secondary = secondary;
			this.output = output;
			this.remainder = remainder;
			this.message = msg;
			this.voice = voice;
			this.display = display;
		}

		recipes reverse() {
			//exchange input and secondary
			Item temp = this.secondary;
			this.secondary = this.input;
			this.input = temp;
			//exchange output and remainder
			temp = this.remainder;
			this.remainder = this.output;
			this.output = temp;
			//keep everything the same
			return this;
		}
	}
	
	public static void combine(Player player, Item item, Item secondary, Item result, Item remainder, messages message, voicetype voice, displaytype display) {
		if (player.getItemInHand(InteractionHand.OFF_HAND).getItem() == secondary) {
			player.setItemInHand(InteractionHand.MAIN_HAND, result.getDefaultInstance());
			player.setItemInHand(InteractionHand.OFF_HAND, remainder.getDefaultInstance());
			if(message.msg.isEmpty()) { return;}
			try {
				player.getServer().getCommands().getDispatcher().execute(String.join(" ", "textengine", voice.type, display.display, message.msg), player.createCommandSourceStack());
			} catch (CommandSyntaxException e) {
				MineShot.log("Combination Craft couldn't run Text Engine: " + e.toString());
				player.sendSystemMessage(Component.literal(
						"Something went wrong when trying to run the text engine for this combination recipe, please report this to MCSuperplayer along with your log file."));
			}
		}
	}

	public static recipes getRecipe(Item mainhand, Item offhand) {
		for (MineShotCombinationRecipe.recipes recipe : recipes.values()) {
			if (recipe.input == mainhand && recipe.secondary == offhand) {
				return recipe;
			}
			if (recipe.input == offhand && recipe.secondary == mainhand) {
				return recipe.reverse();
			}
		}

		return null;

	}
}

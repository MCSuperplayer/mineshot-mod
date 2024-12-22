package mcsuperplayer.mineshot.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class TextEngineCommand {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		LiteralArgumentBuilder<CommandSourceStack> command = Commands.literal("textengine")
				.requires(source -> source.hasPermission(0))
				.then(Commands.argument("voice", StringArgumentType.word())
					.suggests((context, builder) -> {
						return SharedSuggestionProvider.suggest(new String[] {"silent", "person", "robot"}, builder);
					})
				.then(Commands.argument("display",StringArgumentType.word())
					.suggests((context, builder) -> {
						return SharedSuggestionProvider.suggest(new String[] {"title", "subtitle", "hotbar"}, builder);
					})
				.then(Commands.argument("message",StringArgumentType.greedyString())
				.executes(TextEngineCommand::execute))));
		dispatcher.register(command);
	}

	private static int execute(CommandContext<CommandSourceStack> context) {
		
		CommandSourceStack source = context.getSource();
			String voice = StringArgumentType.getString(context, "voice");
			String display = StringArgumentType.getString(context, "display");
			String message = StringArgumentType.getString(context, "message");
			
			ServerPlayer player;

			try {
			player = source.getPlayer();
			} catch (Exception e) {
				source.sendFailure(Component.literal("Error executing command textengine: Needs to be run on a player."));
				return -1;
			}

			if (!voice.equalsIgnoreCase("silent") && 
				!voice.equalsIgnoreCase("person") &&
				!voice.equalsIgnoreCase("robot")) {
				source.sendFailure(Component.translatable("text.mineshot.textengine.invalid_command").append(voice));
			}

			if (!display.equalsIgnoreCase("hotbar") && 
				!display.equalsIgnoreCase("title") && 
				!display.equalsIgnoreCase("subtitle")) {
				source.sendFailure(Component.translatable("text.mineshot.textengine.invalid_command").append(display));
			}

			CompoundTag playerData = player.getPersistentData();
			CompoundTag mineshotData = playerData.getCompound("MineShotData");
			CompoundTag textengine = mineshotData.getCompound("textengine");

			textengine.putString("voice", voice);
			textengine.putString("display", display);
			textengine.putString("message", message);

			textengine.putInt("index", 1);
			textengine.putInt("delay", 0);

			textengine.putBoolean("runText", true);

			mineshotData.put("textengine", textengine);
			playerData.put("MineShotData", mineshotData);

			return 1;
	}

}

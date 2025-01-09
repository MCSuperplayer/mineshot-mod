package mcsuperplayer.mineshot.event;

import net.minecraft.commands.CommandSourceStack;

public class CommandAction extends DelayedAction {

	public CommandAction(String command, int delay) {
		this.command = command;
		this.delay = delay;
	}

	public CommandAction(String command, int delay, DelayedAction action) {
		this(command, delay);
		this.action = action;
	}

	@Override
	public void run() {
		super.run();
		CommandSourceStack cms = context.getPlayer().createCommandSourceStack();
		context.getPlayer().getServer().getCommands().performPrefixedCommand(cms, command);
	}
}
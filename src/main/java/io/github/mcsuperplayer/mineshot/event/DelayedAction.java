package io.github.mcsuperplayer.mineshot.event;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public abstract class DelayedAction implements Runnable {

	int delay;
	int tick = 0;
	String command;
	Block block;
	Item item;
	DelayedAction action;
	public UseOnContext context;

	public void run() {
		if (action != null) { // chained action
			action.context = this.context;
			if (action.delay == 0) {
				action.run();
			} else {
				ServerEventHandler.scheduleAction(action);
			}
		}
	}
}

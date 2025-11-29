package io.github.mcsuperplayer.mineshot.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.github.mcsuperplayer.mineshot.MineShot;
import io.github.mcsuperplayer.mineshot.command.TextEngineCommand;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ServerEventHandler {
	private static final List<DelayedAction> actions = new ArrayList<>(0);
	private static final List<DelayedAction> newactions = new ArrayList<>(0);

	@SubscribeEvent
	public static void onServerStarting(ServerStartingEvent event) {
		TextEngineCommand.register(event.getServer().getCommands().getDispatcher());
	}

	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Iterator<DelayedAction> iterator = actions.iterator();
			while (iterator.hasNext()) {
				DelayedAction task = iterator.next();
				task.tick++;
				if (task.tick >= task.delay) {
					task.tick = 0;
					try {
						task.run();
					} catch (Exception e) {
						MineShot.log("Error Executing Delayed Task: " + e.getMessage());
					}
					iterator.remove();
				}
			}
			actions.addAll(newactions);
			newactions.clear();
		}
	}

	public static void scheduleAction(DelayedAction Action) {
		newactions.add(Action);
	}
}

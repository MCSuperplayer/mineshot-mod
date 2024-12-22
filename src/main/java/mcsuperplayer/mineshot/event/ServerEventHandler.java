package mcsuperplayer.mineshot.event;

import mcsuperplayer.mineshot.command.TextEngineCommand;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ServerEventHandler {

	@SubscribeEvent
	public static void onServerStarting(ServerStartingEvent event) {
		TextEngineCommand.register(event.getServer().getCommands().getDispatcher());
	}
}

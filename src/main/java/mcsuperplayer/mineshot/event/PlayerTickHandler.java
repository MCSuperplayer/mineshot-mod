package mcsuperplayer.mineshot.event;

import mcsuperplayer.mineshot.Config;
import mcsuperplayer.mineshot.packet.ClientbountPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerTickHandler {

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.player instanceof ServerPlayer serverPlayer && event.phase == TickEvent.Phase.END) {
			CompoundTag playerData = serverPlayer.getPersistentData();
			CompoundTag modData = playerData.getCompound("MineShotData");
			CompoundTag textengineData = modData.getCompound("textengine");

			boolean runText = textengineData.getBoolean("runText");
			if (!runText) {
				return;
			}
			
			int delay = textengineData.getInt("delay");
			
			if (delay < Config.textengine_delay) {
				delay = delay + 1;
				textengineData.putInt("delay", delay);
				modData.put("textengine", textengineData);
				playerData.put("MineShotData", modData);
				return;
			}
			
			String message = textengineData.getString("message");
			String voice = textengineData.getString("voice");
			String display = textengineData.getString("display");
			int index = textengineData.getInt("index");
			String msg;
			
			if (index >= message.length()) {
				msg = message;
				runText = false;
			} else {
				msg = message.substring(0, index);
			}
			
			switch (display) {
			case "title":
				ClientbountPacket.sendTitle(serverPlayer, msg);
				break;
			case "subtitle":
				ClientbountPacket.sendSubtitle(serverPlayer, msg);
				break;
			case "hotbar":
				serverPlayer.displayClientMessage(Component.literal(msg), true);
				break;
			}

			switch (voice) {
			case "person":
				// play person sound
				break;
			case "robot":
				// play robot sound
				break;
			case "silent":
				break;
			default:
				break;
			}
			
			delay = 0;
			index = index + 1;
			
			textengineData.putBoolean("runText", runText);
			textengineData.putInt("delay", delay);
			textengineData.putInt("index", index);
			modData.put("textengine", textengineData);
			playerData.put("MineShotData", modData);

		}
	}
}

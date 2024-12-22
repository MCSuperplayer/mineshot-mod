package mcsuperplayer.mineshot.packet;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.server.level.ServerPlayer;

public class ClientbountPacket {
	public static void sendTitle(ServerPlayer player, String titleText) {

		Component title = Component.literal(titleText);
		
		ClientboundSetTitlesAnimationPacket timingPacket = new ClientboundSetTitlesAnimationPacket(0, 20, 10);
		ClientboundSetTitleTextPacket titlePacket = new ClientboundSetTitleTextPacket(title);

		player.connection.send(timingPacket);
		player.connection.send(titlePacket);
	}

	public static void sendSubtitle(ServerPlayer player, String subtitleText) {

		Component subtitle = Component.literal(subtitleText);

		ClientboundSetTitlesAnimationPacket timingPacket = new ClientboundSetTitlesAnimationPacket(0, 20, 10);
		ClientboundSetSubtitleTextPacket subtitlePacket = new ClientboundSetSubtitleTextPacket(subtitle);

		player.connection.send(timingPacket);
		player.connection.send(subtitlePacket);
		player.connection.send(new ClientboundSetTitleTextPacket(Component.literal("")));
	}
}

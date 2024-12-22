package mcsuperplayer.mineshot.item;

import java.util.Random;

import mcsuperplayer.mineshot.MineShotData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RemoteItem extends MineShotItem {

	public RemoteItem(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (level.isClientSide) {
			return InteractionResultHolder.success(itemstack);
		}

		String remoteCode = MineShotData.get(level).remoteCode;

		if (remoteCode == "-") {
			Random random = new Random();
			remoteCode = Integer.toString(random.nextInt(10)) + Integer.toString(random.nextInt(10))
					+ Integer.toString(random.nextInt(10)) + Integer.toString(random.nextInt(10));
			MineShotData.get(level).remoteCode = remoteCode;
			MineShotData.get(level).syncData();
		}

		player.sendSystemMessage(Component.literal((remoteCode)));
		return InteractionResultHolder.success(itemstack);
	}
}

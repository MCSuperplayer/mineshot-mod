package mcsuperplayer.mineshot.event;

import net.minecraft.world.item.Item;

public class ItemTransformAction extends DelayedAction {

	public ItemTransformAction(Item item, int delay) {
		this.item = item;
		this.delay = delay;
	}

	public ItemTransformAction(Item item, int delay, DelayedAction action) {
		this(item, delay);
		this.action = action;
	}

	@Override
	public void run() {
		super.run();
		context.getPlayer().setItemInHand(context.getHand(), item.getDefaultInstance());
	}

}

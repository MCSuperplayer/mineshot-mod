package io.github.mcsuperplayer.mineshot.event;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class BlockTransformAction extends DelayedAction {

	public BlockTransformAction(UseOnContext context, Block block, int delay) {
		this.context = context;
		this.block = block;
		this.delay = delay;
	}

	public BlockTransformAction(UseOnContext context, Block block, int delay, DelayedAction action) {
		this(context, block, delay);
		this.action = action;
	}

	@Override
	public void run() {
		super.run();
		context.getLevel().setBlock(context.getClickedPos(), block.defaultBlockState(), 0);
	}

}

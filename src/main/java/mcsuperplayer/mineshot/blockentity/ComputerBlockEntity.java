package mcsuperplayer.mineshot.blockentity;

import mcsuperplayer.mineshot.MineShot;
import mcsuperplayer.mineshot.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ComputerBlockEntity extends BlockEntity {

	public ComputerBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.COMPUTER_BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		@SuppressWarnings("unused")
		CompoundTag mineshotData = nbt.getCompound(MineShot.MODID);
		// data = mineshotData.get
	}

	@Override
	protected void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		var mineshotData = new CompoundTag();
		// mineshotData.put data
		nbt.put(MineShot.MODID, mineshotData);
	}
}

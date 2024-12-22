package mcsuperplayer.mineshot.block;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import mcsuperplayer.mineshot.init.BlockEntityInit;
import mcsuperplayer.mineshot.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

public class ComputerBlock extends HorizontalDirectionalBlock implements EntityBlock {

	public static final EnumProperty<BLOCKHALF> HALF = EnumProperty.create("half", BLOCKHALF.class);
	public static final EnumProperty<COMPUTERTYPE> TYPE = EnumProperty.create("type", COMPUTERTYPE.class);
	
	
	public ComputerBlock(Properties p_49795_) {
		super(p_49795_);
		registerDefaultState(defaultBlockState()
				.setValue(FACING, Direction.NORTH)
				.setValue(HALF, BLOCKHALF.LEFT)
				.setValue(TYPE, COMPUTERTYPE.OFF)
			);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		return BlockEntityInit.COMPUTER_BLOCK_ENTITY.get().create(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, HALF, TYPE);
	}

	public enum BLOCKHALF implements StringRepresentable {
		LEFT, RIGHT;

		@Override
		public String getSerializedName() {

			return this.name().toLowerCase();
		}
	}

	public enum COMPUTERTYPE implements StringRepresentable {
		OFF, BLUE, GREEN, RED, YELLOW;

		public String getSerializedName() {
			return this.name().toLowerCase();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
		return super.use(state, level, pos, player, hand, result);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level level = context.getLevel();
		BlockPos checkpos = context.getClickedPos().relative(context.getHorizontalDirection().getClockWise());

		if (level.getBlockState(checkpos).canBeReplaced()) {
			return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		if (state.getValue(HALF) == BLOCKHALF.LEFT) {
			level.setBlock(pos.relative(state.getValue(FACING).getCounterClockWise()),
					state.setValue(HALF, BLOCKHALF.RIGHT), UPDATE_ALL);
		}
		super.setPlacedBy(level, pos, state, entity, stack);
	}
	
	@Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		if (level.isClientSide) {
			return false;
		}
		BLOCKHALF half = state.getValue(HALF);
		Direction facing = state.getValue(FACING);
		Direction otherHalf = null;

		switch (half) {
		case LEFT:
			otherHalf = facing.getCounterClockWise();
			break;
		case RIGHT:
			otherHalf = facing.getClockWise();
			break;
		}
		if (level.getBlockState(pos.relative(otherHalf)).getBlock() == BlockInit.COMPUTER.get()) {
			level.destroyBlock(pos.relative(otherHalf), false);
			return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
		} else {
			return super.onDestroyedByPlayer(state, level, pos, player, false, fluid);
		}
	}

}

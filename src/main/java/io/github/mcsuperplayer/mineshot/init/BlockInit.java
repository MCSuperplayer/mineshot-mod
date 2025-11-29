package io.github.mcsuperplayer.mineshot.init;

import io.github.mcsuperplayer.mineshot.MineShot;
import io.github.mcsuperplayer.mineshot.block.ComputerBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MineShot.MODID);

	public static final RegistryObject<Block> BARRENS_SAND = BLOCKS.register("barrens_sand", 
			() -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
					.mapColor(MapColor.COLOR_BLUE)
					.lightLevel(state -> 5)
					.strength(-1)
			));

	public static final RegistryObject<Block> COMPUTER = BLOCKS.register("computer",
			() -> new ComputerBlock(BlockBehaviour.Properties.of()
					.mapColor(MapColor.NONE)
					.noOcclusion()
					.dynamicShape()
					.lightLevel(state -> ComputerBlock.getLightLevel(state))
					.strength(-1)
					.emissiveRendering((pState, pBlockGetter, pBlockPos) -> true)
			));

	public static final RegistryObject<Block> GLEN_GRASS_BLOCK = BLOCKS.register("glen_grass_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
					.mapColor(DyeColor.GREEN)
					.lightLevel(state -> 7)
					.strength(-1)
			));
	
	public static final RegistryObject<Block> REFUGE_FLOOR = BLOCKS.register("refuge_floor",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)
					.mapColor(DyeColor.RED)
					.lightLevel(state -> 3)
					.strength(-1)
			));

	public static final RegistryObject<Block> POWER_CELL = BLOCKS.register("power_cell",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.CHEST)
					.mapColor(DyeColor.BLUE)
					.dynamicShape().strength(-1)));

	public static final RegistryObject<Block> WITHERED_PLANT = BLOCKS.register("withered_plant",
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(-1).sound(SoundType.DECORATED_POT)
			));

	public static final RegistryObject<Block> TV_REMOTE_BLOCK = BLOCKS.register("tv_remote_block",
			() -> new Block(BlockBehaviour.Properties.of().strength(-1)
					.noCollission()
			));
	
	public static final RegistryObject<Block> GLEN_DIRT = BLOCKS.register("glen_dirt", 
			() -> new Block(BlockBehaviour.Properties.copy(BlockInit.GLEN_GRASS_BLOCK.get())
			));
}

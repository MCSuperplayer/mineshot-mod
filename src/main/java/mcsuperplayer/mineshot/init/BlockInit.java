package mcsuperplayer.mineshot.init;

import mcsuperplayer.mineshot.MineShot;
import mcsuperplayer.mineshot.block.ComputerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GravelBlock;
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
			));

	public static final RegistryObject<Block> COMPUTER = BLOCKS.register("computer",
			() -> new ComputerBlock(BlockBehaviour.Properties.of()
					.mapColor(MapColor.NONE)
					.noOcclusion()
					.lightLevel(state -> 1)
			));
}

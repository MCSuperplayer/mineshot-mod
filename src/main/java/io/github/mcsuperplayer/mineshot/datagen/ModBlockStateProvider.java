package io.github.mcsuperplayer.mineshot.datagen;

import io.github.mcsuperplayer.mineshot.MineShot;
import io.github.mcsuperplayer.mineshot.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

	private ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}

	private String name(Block block) {
		return key(block).getPath();
	}

	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, MineShot.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		blockWithItem(BlockInit.BARRENS_SAND);
		blockWithItem(BlockInit.REFUGE_FLOOR);
		grassBlockWithItem(BlockInit.GLEN_GRASS_BLOCK, BlockInit.GLEN_DIRT.get());
		blockWithItem(BlockInit.GLEN_DIRT);
	}


	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}

	private void grassBlockWithItem(RegistryObject<Block> blockRegistryObject, Block sideTextureOf) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeTop(blockRegistryObject.get(), sideTextureOf));
	}

	private ModelFile cubeTop(Block block, Block sideTextureOf) {
		return models().cubeTop(name(block), blockTexture(sideTextureOf), blockTexture(block));
	}
}

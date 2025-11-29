package io.github.mcsuperplayer.mineshot.datagen.loot;

import java.util.Set;

import io.github.mcsuperplayer.mineshot.init.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

	public ModBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		for (RegistryObject<Block> block : BlockInit.BLOCKS.getEntries()) {
			this.dropSelf(block.get());
		}
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		// TODO Auto-generated method stub
		return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}

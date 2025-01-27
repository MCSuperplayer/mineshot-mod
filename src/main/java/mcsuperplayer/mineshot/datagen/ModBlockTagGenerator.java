package mcsuperplayer.mineshot.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import mcsuperplayer.mineshot.MineShot;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagGenerator extends BlockTagsProvider {

	public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, MineShot.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider pProvider) {
		// this.tag(BlockTags.SOME_RANDOM_BLOCKTAG).add(SOME_MODBLOCK.get()).addTag(Tags.Blocks.WHATEVER)
	}

}

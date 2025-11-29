package io.github.mcsuperplayer.mineshot.datagen;

import io.github.mcsuperplayer.mineshot.MineShot;
import io.github.mcsuperplayer.mineshot.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, MineShot.MODID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerModels() {
		for (RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
			simpleItem(item);
		}
		for (RegistryObject<Item> item : ItemInit.SOLSTICE_ITEMS.getEntries()) {
			simpleItem(item);
		}
	}

	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        //noinspection ConstantConditions
        return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(MineShot.MODID, "item/" + item.getId().getPath()));
	}

}
